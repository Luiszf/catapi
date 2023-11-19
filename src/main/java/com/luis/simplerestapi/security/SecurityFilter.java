package com.luis.simplerestapi.security;

import com.luis.simplerestapi.repository.UserRepository;
import com.luis.simplerestapi.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Autowired
    UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = recoverToken(request);
        if (token != null) {
            var subject = tokenService.validateToken(token);
            var user = userRepository.findByLogin(subject);

            var authetication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authetication);
        }
        filterChain.doFilter(request,response);
    }


    private String recoverToken(HttpServletRequest request){
        var auth = request.getHeader("authorization");
        if (auth == null) return null;
        return auth.replace("bearer ", "");
    }
}

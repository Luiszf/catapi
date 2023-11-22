package com.luis.simplerestapi.model.user;

public record RegisterDTO(
        String login,
        String password,
        UserRole userRole
){}

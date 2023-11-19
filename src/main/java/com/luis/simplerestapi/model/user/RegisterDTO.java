package com.luis.simplerestapi.model.user;

public record RegisterDTO(
        String username,
        String password,
        UserRole userRole
){}

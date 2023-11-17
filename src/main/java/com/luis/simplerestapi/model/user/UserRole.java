package com.luis.simplerestapi.model.user;

public enum UserRole {
    USER("user"),
    ADMIN("admim");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    String getRole() {
        return role;
    }
}

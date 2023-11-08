package com.example.springdatabasicdemo.enumPacage;

public enum Role {
    User(1),
    Admin(2);

    private final int roleCode;

    private Role(int roleCode){
        this.roleCode = roleCode;
    }
}

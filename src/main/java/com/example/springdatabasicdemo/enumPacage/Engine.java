package com.example.springdatabasicdemo.enumPacage;

public enum Engine {
    GASOLINE(1),
    DIESEL(2),
    ELECTRIC(3),
    HYBRID(4);

    private final int engineCode;

    private Engine(int engineCode){
        this.engineCode = engineCode;
    }
}

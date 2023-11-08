package com.example.springdatabasicdemo.enumPacage;

public enum Transmission {
    MANUAL(1),
    AUTOMATIC(2);

    private final int transmissionCode;

    private Transmission(int transmissionCode){
        this.transmissionCode = transmissionCode;
    }
}

package com.example.springdatabasicdemo.enumPacage;

public enum Category {
    Car(1),
    Buss(2),
    Truck(3),
    Motorcycle(4);

    private final int categoryCode;

    private Category(int categoryCode){
        this.categoryCode = categoryCode;
    }


}

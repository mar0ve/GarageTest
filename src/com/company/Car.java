package com.company;

public class Car {
    protected String carNumber;
    protected String carMark;
    protected String carModel;

    public Car(String carNumber, String carMark, String carModel) {
        this.carNumber = carNumber;
        this.carMark = carMark;
        this.carModel = carModel;
    }

    @Override
    public String toString() {
        return carNumber + ", " + carMark + ", " + carModel;
    }
}

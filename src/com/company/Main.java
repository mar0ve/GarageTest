package com.company;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] argc) {

        try {

            Car car = new Car("A213AB78", "Golf", "6");
            Car car1 = new Car("B323BB198", "Mercedes", "AMG65");
            Car car2 = new Car("B888BB198", "Mercedes", "GLK33");
            Car car3 = new Car("C444CA198", "BMW", "530i");
            Garage garage = new Garage();
            System.out.println("Состояние: ");
            garage.DisplayGarage();
            System.out.println("есть ли в гараже машина с номером B323BB198?");
            System.out.println(garage.findCarByNumber(car1));
            System.out.println("найти все мерседесы: ");
            Car[] cars = garage.getCarByMark("Mercedes");
            System.out.println(Arrays.toString(cars));
            System.out.println();
            System.out.println("BMW выезжает");
            garage.DeleteCarFromGarage(car3);
            System.out.println("Golf заезжает");
            garage.parkCar(car);
            System.out.println("BMW заезжает");
            garage.parkCar(car3);
            System.out.println("Состояние: ");
            garage.DisplayGarage();
        }catch (IOException e) {
            e.getMessage();
        }
    }
}
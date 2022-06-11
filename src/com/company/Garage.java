package com.company;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Garage {

    public Boolean findCarByNumber(Car car) throws IOException {
        if(car == null) {
            return false;
        }

        FileReader fileReader = new FileReader("garageList.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String finder = bufferedReader.readLine();
        while(finder != null) {
            String[] strings = finder.split(", ");
            if(strings[0].equals(car.carNumber)) {
                return true;
            }

            finder = bufferedReader.readLine();
        }

        bufferedReader.close();
        fileReader.close();
        return false;
    }

    public void parkCar(Car car) throws IOException {
        if(car == null) {
            return;
        }

        if(findCarByNumber(car)) {
            return;
        }

        FileWriter fileWriter = new FileWriter("garageList.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String carString = car.toString();
        bufferedWriter.newLine();
        bufferedWriter.write(carString);
        bufferedWriter.close();
        fileWriter.close();
    }

    public void DeleteCarFromGarage(Car car) throws IOException {
        if(!findCarByNumber(car)) {
            return;
        }

        List<Car> carList = new LinkedList<>();
        FileReader fileReader = new FileReader("garageList.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String findCar = bufferedReader.readLine();
        while(findCar != null) {
            String[] strings = findCar.split(", ");
            if(strings.length > 1) {
                if(!strings[0].equals(car.carNumber)) {
                    carList.add(new Car(strings[0], strings[1], strings[2]));
                }
            }
            findCar = bufferedReader.readLine();
        }
        bufferedReader.close();
        fileReader.close();
        FileWriter fileWriter = new FileWriter("garageList.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for(Car c : carList) {
            String strCar = c.toString();
            bufferedWriter.newLine();
            bufferedWriter.write(strCar);
        }
        bufferedWriter.close();
        fileWriter.close();
    }

    public Car[] getCarByMark(String mark) throws IOException {
        ArrayList<Car> carList = new ArrayList<>();
        FileReader fileReader = new FileReader("garageList.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String findCar = bufferedReader.readLine();
        while(findCar != null) {
            String[] strings = findCar.split(", ");
            if(strings.length > 1) {
                if(strings[1].equals(mark)) {
                    carList.add(new Car(strings[0], strings[1], strings[2]));
                }
            }
            findCar = bufferedReader.readLine();
        }
        bufferedReader.close();
        fileReader.close();
        return carList.toArray(new Car[0]);
    }

    public void DisplayGarage() throws IOException {

        FileReader fileReader = new FileReader("garageList.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String findCar = bufferedReader.readLine();
        while(findCar != null) {
            System.out.println(findCar);
            findCar = bufferedReader.readLine();
        }
        System.out.println();
        bufferedReader.close();
        fileReader.close();
    }
}

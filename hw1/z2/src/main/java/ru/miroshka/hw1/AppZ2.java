package ru.miroshka.hw1;

import ru.miroshka.hw1.cars.Car;
import ru.miroshka.hw1.cars.Engine;
import ru.miroshka.hw1.cars.LightWeightCar;
import ru.miroshka.hw1.cars.Lorry;

public class AppZ2 {

    public static void main(String[] args) {

        System.out.println("zadanie 2");
        Car carLorry = new Lorry(new Engine.Builder().
                setName("Russian")
                .setPower(300d)
                .setSize(12d)
                .setWeight(124d)
                .setLiters(5.5d)
                .build(),"Black","GeekMobile");
        Car carLightWeightCar = new LightWeightCar(new Engine.Builder()
                .setLiters(2.5d)
                .setWeight(25d)
                .setName("miniEngine")
                .setSize(2d)
                .setPower(180d)
                .build(),"White","SuperCar");
        carLightWeightCar.start();
        carLorry.start();
        carLightWeightCar.open();
        carLorry.open();
        ((Lorry) carLorry).move();
        ((LightWeightCar) carLightWeightCar).move();
        ((Lorry) carLorry).stop();
    }



}

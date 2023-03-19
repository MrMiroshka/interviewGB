package ru.miroshka.hw1.cars;

public class LightWeightCar extends Car implements Moveable {

    public LightWeightCar(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    @Override
    public void start() {
        System.out.println("LightWeightCar is start");
    }

    @Override
    public void open() {
        System.out.println("LightWeightCar is open");
    }

    @Override
    public void move() {
        System.out.println("LightWeightCar is moving");
    }


}

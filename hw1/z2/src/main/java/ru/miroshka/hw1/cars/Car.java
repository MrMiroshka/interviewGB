package ru.miroshka.hw1.cars;

public abstract class Car {
    private Engine engine;
    private String color;
    private String name;

    public Car(Engine engine, String color, String name) {
        this.engine = engine;
        this.color = color;
        this.name = name;
    }

    public abstract void start();

    public abstract void open();

    public Engine getEngine() {
        return engine;
    }


    public String getColor() {
        return color;
    }


    public String getName() {
        return name;
    }


}

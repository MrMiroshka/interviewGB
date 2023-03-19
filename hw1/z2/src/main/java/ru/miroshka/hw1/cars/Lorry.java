package ru.miroshka.hw1.cars;

public class Lorry extends Car implements Moveable, Stopable {

    public Lorry(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    public void move() {
        System.out.println("Lorry is moving");
    }

    public void stop() {
        System.out.println("Lorry is stop");
    }

    @Override
    public void start() {
        System.out.println("Lorry is start");
    }

    @Override
    public void open() {
        System.out.println("Lorry is open");
    }
}

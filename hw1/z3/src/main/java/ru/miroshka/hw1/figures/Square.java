package ru.miroshka.hw1.figures;

public class Square implements Figure{
    private final double side;

    public double getSide() {
        return side;
    }

    private Square(Builder builder) {
        this.side = builder.side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                ", area=" + area() +
                '}';
    }

    @Override
    public double area() {
        return Math.sqrt(side);
    }

    public static class Builder {
        private double side;

        public Builder() {
        }

        public Square build(){
            return new Square(this);
        }

        public Builder setSide(double side) {
            this.side = side;
            return this;
        }
    }
}

package ru.miroshka.hw1.figures;

public class Circle implements Figure {
    private final double radius;

    public double getRadius() {
        return radius;
    }

    private Circle(Builder builder) {
        this.radius = builder.radius;
    }

    @Override
    public double area() {
        return 3.14 * radius * radius;
    }


    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", area=" + area() +
                '}';
    }

    public static class Builder {
        private double radius;

        public Builder() {
        }

        public Circle build() {
            return new Circle(this);
        }

        public Builder setRadius(double radius) {
            this.radius = radius;
            return this;
        }
    }
}

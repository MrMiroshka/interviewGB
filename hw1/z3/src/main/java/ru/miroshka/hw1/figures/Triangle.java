package ru.miroshka.hw1.figures;

public class Triangle implements Figure {
    private final double sideA;
    private final double sideB;
    private final double sideC;

    private Triangle(Builder builder) {
        this.sideA = builder.sideA;
        this.sideB = builder.sideB;
        this.sideC = builder.sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    @Override
    public double area() {
        double p = (sideA + sideB + sideC) / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }


    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                ", area=" + area() +
                '}';
    }

    public static class Builder {
        private double sideA;
        private double sideB;
        private double sideC;

        public Builder() {
        }

        public Triangle builde() {
            return new Triangle(this);
        }

        public Builder setSideA(double sideA) {
            this.sideA = sideA;
            return this;
        }

        public Builder setSideB(double sideB) {
            this.sideB = sideB;
            return this;
        }

        public Builder setSideC(double sideC) {
            this.sideC = sideC;
            return this;
        }
    }
}

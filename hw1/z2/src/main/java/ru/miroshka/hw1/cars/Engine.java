package ru.miroshka.hw1.cars;

public class Engine {
    private final double power;
    private final double liters;
    private final double weight;
    private final double size;
    private final String name;

    public double getPower() {
        return power;
    }

    public double getLiters() {
        return liters;
    }

    public double getWeight() {
        return weight;
    }

    public double getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public Engine(Builder builder) {
        this.power = builder.power;
        this.liters = builder.liters;
        this.weight = builder.weight;
        this.size = builder.size;
        this.name = builder.name;
    }

    public static class  Builder {
        private Double power;
        private Double liters;
        private Double weight;
        private Double size;
        private String name;

        public Builder() {
        }

        public Engine build() {
            return new Engine(this);
        }

        public Builder setPower(double power) {
            this.power = power;
            return this;
        }

        public Builder setLiters(double liters) {
            this.liters = liters;
            return this;
        }

        public Builder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder setSize(double size) {
            this.size = size;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
    }
}

package oop.parking.domain;

public class CarBuilder {
    private String id;
    private boolean large;
    private boolean handicapped;

    public CarBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public CarBuilder setLarge(boolean large) {
        this.large = large;
        return this;
    }

    public CarBuilder setHandicapped(boolean handicapped) {
        this.handicapped = handicapped;
        return this;
    }

    public Car createCar() {
        return new Car(id);
    }
}
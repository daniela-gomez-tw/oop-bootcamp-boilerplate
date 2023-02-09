package oop.parking.domain;

public class Car {

    private String id;
    private boolean large;
    private boolean handicapped;


    public Car(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

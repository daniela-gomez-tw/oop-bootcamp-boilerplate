package oop.parking;

import oop.parking.domain.Car;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private PropertyChangeSupport propertyChangeSupport;
    private final int capacity;
    private final List<Car> parkedCars = new ArrayList<>();
    private boolean acceptsHandicapped;


    public ParkingLot(int capacity, Owner owner) {
        this.capacity = capacity;
        setListenerSupport(owner);
    }

    public ParkingLot(int capacity, Owner owner, boolean acceptsHandicapped) {
        this.capacity = capacity;
        setListenerSupport(owner);
        this.acceptsHandicapped = acceptsHandicapped;
    }

    private void setListenerSupport(Owner owner) {
        propertyChangeSupport = new PropertyChangeSupport(this);
        propertyChangeSupport.addPropertyChangeListener(owner);
    }

    public void parkCar(Car newCar) {
        if (this.hasFreeSlots()) {
            double capacityBefore = checkCapacityPercentage();
            parkedCars.add(newCar);
            propertyChangeSupport.firePropertyChange("capacityChanged", capacityBefore, checkCapacityPercentage());
        }
    }

    public List<Car> getParkedCars() {
        return parkedCars;
    }


    public boolean retrieveCar(Car car) {
        return parkedCars.remove(car);
    }

    public boolean checkIfCarIsParked(Car car) {
        return parkedCars.contains(car);
    }

    private boolean hasFreeSlots() {
        return parkedCars.size() < this.capacity;
    }

    public double checkCapacityPercentage() {
        return (double) parkedCars.size() / (double) this.capacity;
    }

    public boolean isAcceptsHandicapped() {
        return acceptsHandicapped;
    }

    public boolean contains(Car car) {
        return parkedCars.contains(car);
    }
}

package oop.parking;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private PropertyChangeSupport propertyChangeSupport;
    private final int capacity;
    private final List<String> parkedCars = new ArrayList<>();


    public ParkingLot(int capacity, Owner owner) {
        this.capacity = capacity;
        setListenerSupport(owner);
    }

    private void setListenerSupport(Owner owner) {
        propertyChangeSupport = new PropertyChangeSupport(this);
        propertyChangeSupport.addPropertyChangeListener(owner);
    }

    public void parkCar(String newCar) {
        if (this.hasFreeSlots()) {
            double capacityBefore = checkCapacityPercentage();
            parkedCars.add(newCar);
            propertyChangeSupport.firePropertyChange("capacityChanged", capacityBefore, checkCapacityPercentage());
        }
    }

    public List<String> getParkedCars() {
        return parkedCars;
    }


    public boolean retrieveCar(String carId) {
        return parkedCars.remove(carId);
    }

    public boolean checkIfCarIsParked(String carId) {
        return parkedCars.contains(carId);
    }

    private boolean hasFreeSlots() {
        return parkedCars.size() < this.capacity;
    }

    public double checkCapacityPercentage() {
        return (double) parkedCars.size() / (double) this.capacity;
    }
}

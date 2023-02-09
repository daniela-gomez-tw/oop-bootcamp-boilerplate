package oop.parking;

import java.util.List;

public class Assistant {

    private final List<ParkingLot> parkingLots;

    public Assistant(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public void parkCar(String carId) {
        for (ParkingLot lot : this.parkingLots) {
            if (lot.checkCapacityPercentage() < 0.8) {
                lot.parkCar(carId);
                return;
            }
        }
    }

    private ParkingLot findParkingLotFor(String carId) {
        for (ParkingLot lot : this.parkingLots) {
            if (lot.checkIfCarIsParked(carId)) {
                return lot;
            }
        }
        return null;
    }

    public boolean isCarParked(String carId) {
        return findParkingLotFor(carId) != null;
    }

    public boolean retrieveCar(String carId) {
        ParkingLot lot = findParkingLotFor(carId);
        if (lot == null) {
            return false;
        }
        return lot.retrieveCar(carId);
    }

    public ParkingLot findLowestOccupancyParkingLot() {
        ParkingLot parkingLot = null;
        double maxOccupancy = 1.0;
        for (ParkingLot lot : this.parkingLots) {
            if (lot.checkCapacityPercentage() < maxOccupancy) {
                parkingLot = lot;
            }
        }
        return parkingLot;
    }
}

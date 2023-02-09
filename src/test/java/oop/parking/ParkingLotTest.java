package oop.parking;

import oop.parking.domain.Car;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParkingLotTest {

    private Owner owner;
    private ParkingLot parkingLot;

    @BeforeMethod
    public void setupBeforeEach() {
        this.owner = new Owner();
        this.parkingLot = new ParkingLot(2, owner);
    }

    @Test
    public void itShouldBeAbleToParkACar() {
        parkingLot.parkCar(new Car("ABC-123"));

        assertTrue(parkingLot.getParkedCars().contains("ABC-123"));
    }

    @Test
    public void itShouldBeAbleToRetrieveACar() {
        String carId = "ABC-123";
        parkingLot.parkCar(new Car(carId));

        parkingLot.retrieveCar(carId);
        assertFalse(parkingLot.getParkedCars().contains("ABC-123"));
    }

    @Test
    public void itShouldBeAbleToCheckIfACarIsParked() {
        String carId = "ABC-123";
        parkingLot.parkCar(new Car(carId));

        assertTrue(parkingLot.checkIfCarIsParked(carId));
    }

    @Test
    public void itShouldNotParkACarWhenIsFull() {
        parkingLot.parkCar(new Car("1"));
        parkingLot.parkCar(new Car("2"));

        String carId = "ABC-123";
        parkingLot.parkCar(new Car(carId));

        assertFalse(parkingLot.checkIfCarIsParked(carId));
    }

    @Test
    public void itShouldReturnPercentageOfUsedCapacity() {
        parkingLot.parkCar(new Car("1"));

        assertEquals(parkingLot.checkCapacityPercentage(), 0.5);
    }
}

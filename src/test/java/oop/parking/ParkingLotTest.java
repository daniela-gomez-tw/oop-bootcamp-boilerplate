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
        Car car = new Car("ABC-123");
        parkingLot.parkCar(car);

        parkingLot.retrieveCar(car);
        assertFalse(parkingLot.getParkedCars().contains(car.getId()));
    }

    @Test
    public void itShouldBeAbleToCheckIfCarIsParked() {
        final Car car = new Car("ABC-123");
        parkingLot.parkCar(car);

        assertTrue(parkingLot.checkIfCarIsParked(car));
    }

    @Test
    public void itShouldNotParkACarWhenIsFull() {
        Car carToFind = new Car("ABC-123");
        parkingLot.parkCar(new Car("1"));
        parkingLot.parkCar(new Car("2"));

        parkingLot.parkCar(carToFind);

        assertFalse(parkingLot.checkIfCarIsParked(carToFind));
    }

    @Test
    public void itShouldReturnPercentageOfUsedCapacity() {
        parkingLot.parkCar(new Car("1"));

        assertEquals(parkingLot.checkCapacityPercentage(), 0.5);
    }
}

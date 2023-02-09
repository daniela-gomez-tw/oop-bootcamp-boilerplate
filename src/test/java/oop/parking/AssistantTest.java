package oop.parking;

import oop.parking.domain.Car;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class AssistantTest {
    private String carId;
    private Owner owner;
    private Assistant assistant;

    @BeforeTest
    public void init() {
        this.owner = new Owner();
        this.carId = "ABC-123";
    }

    @BeforeMethod
    public void setupBeforeEach() {
        List<ParkingLot> parkingLotList = new ArrayList<>();

        parkingLotList.add(new ParkingLot(5, owner));
        parkingLotList.add(new ParkingLot(5, owner));

        this.assistant = new Assistant(parkingLotList);
    }


    @Test
    public void itShouldBeAbleToParkACar() {
        assertFalse(assistant.isCarParked(carId));

        assistant.parkCar(new Car(carId));
        assertTrue(assistant.isCarParked(carId));
    }

    @Test
    public void itShouldBeAbleToRetrieveACar() {
        assistant.parkCar(new Car(carId));

        assertTrue(assistant.retrieveCar(carId));

        assertFalse(assistant.isCarParked(carId));
    }

    @Test
    public void itShouldNotBeAbleToRetrieveACarThatIsNotParked() {
        assertFalse(assistant.retrieveCar(carId));
    }

    @Test
    public void itShouldParkAtTheSecondParkingLotIfTheFirstOneIsFull() {
        assistant.parkCar(new Car("1"));
        assistant.parkCar(new Car("2"));
        assistant.parkCar(new Car("3"));
        assistant.parkCar(new Car(carId));

        assertTrue(assistant.isCarParked(carId));
    }

    @Test
    public void itShouldNotParkIfParkingIsOverEightyPercentCapacity() {
        assistant.parkCar(new Car("1"));
        assistant.parkCar(new Car("2"));
        assistant.parkCar(new Car("3"));
        assistant.parkCar(new Car("4"));
        assistant.parkCar(new Car("5"));
        assistant.parkCar(new Car("6"));
        assistant.parkCar(new Car("7"));
        assistant.parkCar(new Car("8"));
        assistant.parkCar(new Car(carId));

        assertFalse(assistant.isCarParked(carId));
    }

    @Test
    public void itShouldFindLowestOccupancyParkingLot() {
        List<ParkingLot> parkingLotList = new ArrayList<>();
        final ParkingLot parkingLot1 = new ParkingLot(5, owner);
        final ParkingLot parkingLot2 = new ParkingLot(5, owner);
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);

        final Assistant assistant1 = new Assistant(parkingLotList);
        assistant1.parkCar(new Car("abc"));

        assertEquals(assistant1.findLowestOccupancyParkingLot(), parkingLot2);
        //TODO need to park the car
    }

    @Test
    public void itShouldFindFirstParkingLotThatAcceptsHandicapped() {
        List<ParkingLot> parkingLotList = new ArrayList<>();
        final ParkingLot parkingLot1 = new ParkingLot(5, owner);
        final ParkingLot parkingLot2 = new ParkingLot(5, owner, true);
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);

        final Assistant assistant1 = new Assistant(parkingLotList);
        assistant1.parkCar(new Car("abc"));

        assertEquals(assistant1.findParkingLotThatAcceptsHandicapped(), parkingLot2);
    }
}
package oop.parking;

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

        assistant.parkCar(carId);
        assertTrue(assistant.isCarParked(carId));
    }

    @Test
    public void itShouldBeAbleToRetrieveACar() {
        assistant.parkCar(carId);

        assertTrue(assistant.retrieveCar(carId));

        assertFalse(assistant.isCarParked(carId));
    }

    @Test
    public void itShouldNotBeAbleToRetrieveACarThatIsNotParked() {
        assertFalse(assistant.retrieveCar(carId));
    }

    @Test
    public void itShouldParkAtTheSecondParkingLotIfTheFirstOneIsFull() {
        assistant.parkCar("1");
        assistant.parkCar("2");
        assistant.parkCar("3");
        assistant.parkCar(carId);

        assertTrue(assistant.isCarParked(carId));
    }

    @Test
    public void itShouldNotParkIfParkingIsOverEightyPercentCapacity() {
        assistant.parkCar("1");
        assistant.parkCar("2");
        assistant.parkCar("3");
        assistant.parkCar("4");
        assistant.parkCar("5");
        assistant.parkCar("6");
        assistant.parkCar("7");
        assistant.parkCar("8");
        assistant.parkCar(carId);

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


        assertEquals(assistant1.findLowestOccupancyParkingLot(), parkingLot2);

    }
}
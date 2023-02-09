package oop.parking;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class OwnerTest {

    private Owner owner;

    @BeforeMethod
    public void setupBeforeEach() {
        this.owner = new Owner();
    }
    @Test
    public void itShouldGiveAnOvercrowdedAlertWhenCapacityLimitIsExceeded() {
        ParkingLot parkingLot = new ParkingLot(5, owner);

        parkingLot.parkCar("123");
        parkingLot.parkCar("456");
        parkingLot.parkCar("789");
        parkingLot.parkCar("000");
        assertTrue(owner.isAlerted());
    }

    @Test
    public void itShouldNotGiveAnOvercrowdedAlertWhenBelowCapacityLimit() {
        ParkingLot parkingLot = new ParkingLot(4, owner);

        parkingLot.parkCar("1");
        parkingLot.parkCar("2");
        assertFalse(owner.isAlerted());
    }

    @Test
    public void itShouldGiveAnLowOccupancyAlertWhenCapacityIsBellowTheLimit() {
        ParkingLot parkingLot = new ParkingLot(10, owner);
        parkingLot.parkCar("1");

        assertTrue(owner.isLowOccupancyAlerted());
    }

    @Test
    public void itShouldNotGiveAnLowOccupancyAlertWhenCapacityIsAboveTheLimit() {
        ParkingLot parkingLot = new ParkingLot(10, owner);
        parkingLot.parkCar("1");
        parkingLot.parkCar("2");

        assertFalse(owner.isLowOccupancyAlerted());
    }
}

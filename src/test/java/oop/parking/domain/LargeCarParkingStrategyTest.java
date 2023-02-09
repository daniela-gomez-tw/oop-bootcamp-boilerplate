package oop.parking.domain;

import oop.parking.Owner;
import oop.parking.ParkingLot;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class LargeCarParkingStrategyTest {

    private Owner owner;
    private final ParkingLot parkingLot1 = new ParkingLot(5, owner);
    private final ParkingLot parkingLot2 = new ParkingLot(5, owner);

    private LargeCarParkingStrategy strategy = new LargeCarParkingStrategy();

    @Test
    public void itShouldParkLargerCarsIntoLowestOccupancyParkingLot() {
        final Car car = new CarBuilder("123").withLarge(true).build();

        strategy.park(car, Arrays.asList(parkingLot1, parkingLot2));

        assertTrue(parkingLot1.contains(car));
    }

}
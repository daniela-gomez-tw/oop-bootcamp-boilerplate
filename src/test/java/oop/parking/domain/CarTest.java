package oop.parking.domain;



import oop.parking.ParkingStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    public void itShouldReturnDefaultStrategyWhenCarDefault() {
        Car car = new CarBuilder("abc")
                .build();

        ParkingStrategy actual = car.findStrategyToPark();

        assertTrue(actual instanceof DefaultParkingStrategy);
    }

    @Test
    public void itShouldReturnLargeStrategyWhenCarLarge() {
        Car car = new CarBuilder("abc")
                .withLarge(true)
                .build();

        ParkingStrategy actual = car.findStrategyToPark();

        assertTrue(actual instanceof LargeCarParkingStrategy);
    }

    @Test
    public void itShouldReturnHandicapStrategyWhenCarHandicap() {
        Car car = new CarBuilder("abc")
                .withHandicapped(true)
                .build();

        ParkingStrategy actual = car.findStrategyToPark();

        assertTrue(actual instanceof HandicapParkingStrategy);
    }

    @Test
    public void itShouldReturnLargeHandicapStrategyWhenCarLargeHandicap() {
        Car car = new CarBuilder("abc")
                .withHandicapped(true)
                .build();

        ParkingStrategy actual = car.findStrategyToPark();

        assertTrue(actual instanceof LargeHandicapParkingStrategy);
    }

}
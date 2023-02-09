package oop;

public class MeasureConverter {

    private static final double METERS_FEET_CONVERSION_FACTOR = 0.3048;

    public double feetToMeters(double feet) {
        return feet* METERS_FEET_CONVERSION_FACTOR;
    }

    public double metersToFeet(double meters) {
        return meters/ METERS_FEET_CONVERSION_FACTOR;
    }
}

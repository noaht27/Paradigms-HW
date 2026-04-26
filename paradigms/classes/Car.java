package paradigms.classes;

import java.util.Objects;

public class Car {
    private String licensePlate;
    private String make;
    private String model;
    private int year;
    private String color;

    public Car(String licensePlate, String make, String model, int year, String color) {
        this.licensePlate = licensePlate;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Car)) return false;
        Car car = (Car) o;
        return year == car.year &&
                this.licensePlate.equals( car.licensePlate) &&
                this.make.equals(car.make) &&
                this.model.equals(car.model) &&
                this.color.equals(car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.color);
    }
}
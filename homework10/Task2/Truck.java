package homework10.Task2;

import java.util.Objects;

public class Truck extends Car {
    private int heightOfTheDoor;

    public Truck(String marka, String model, int yearOfIssue, String transmission, int heightOfTheDoor) {
        super(marka, model, yearOfIssue, transmission);
        this.heightOfTheDoor = heightOfTheDoor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Truck truck = (Truck) o;

        return Integer.compare(truck.heightOfTheDoor, heightOfTheDoor) == 0;
    }

    @Override
    public int hashCode() {

        return super.hashCode() + new Integer(heightOfTheDoor).hashCode();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", heightOfDoors =" + heightOfTheDoor;
    }
}

package homework10.Task2;

import java.util.Objects;

public class Motorcycle extends Car{
    private int numberOfWheel;

    public Motorcycle(String marka, String model, int yearOfIssue, String transmission, int numberOfWheel) {
        super(marka, model, yearOfIssue, transmission);
        this.numberOfWheel = numberOfWheel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Motorcycle that = (Motorcycle) o;

        return numberOfWheel == that.numberOfWheel;
    }

    @Override
    public int hashCode() {

        return super.hashCode() + new Integer(numberOfWheel).hashCode();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", numberOfWheels =" + numberOfWheel;
    }
}

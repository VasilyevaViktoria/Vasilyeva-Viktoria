package homework10.Task2;

import java.util.Objects;

public class Minivan extends Car{
    private int countOfSeats;

    public Minivan(String marka, String model, int yearOfIssue, String transmission, int countOfSeats) {
        super(marka, model, yearOfIssue, transmission);
        this.countOfSeats = countOfSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Minivan minivan = (Minivan) o;

        return countOfSeats == minivan.countOfSeats;
    }

    @Override
    public int hashCode() {

        return super.hashCode() + new Integer(countOfSeats).hashCode();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", numberOfSeats =" + countOfSeats;
    }
}

package homework10.Task2;

import java.util.Objects;

public class Limousine extends Car {
    int lengthOdLimousine;

    public Limousine(String marka, String model, int yearOfIssue, String transmission, int lengthOdLimousine) {
        super(marka, model, yearOfIssue, transmission);
        this.lengthOdLimousine = lengthOdLimousine;
        this.lengthOdLimousine = lengthOdLimousine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Limousine limousine = (Limousine) o;

        return Integer.compare(limousine.lengthOdLimousine, lengthOdLimousine) == 0;
    }

    @Override
    public int hashCode() {

        return super.hashCode() + new Integer(lengthOdLimousine).hashCode();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", lengthOfLimousine =" + lengthOdLimousine;
    }


}

package homework10.Task2;

import java.util.Objects;

public abstract class Car {
    private String marka;
    private String model;
    private int yearOfIssue;
    private String transmission;

    public Car(String marka, String model, int yearOfIssue, String transmission) {
        this.marka = marka;
        this.model = model;
        this.yearOfIssue = yearOfIssue;
        this.transmission = transmission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return yearOfIssue == car.yearOfIssue &&
                transmission == car.transmission &&
                Objects.equals(marka, car.marka) &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {

        return 17 * marka.hashCode()
                + 17 * model.hashCode()
                + 31 * new Integer(yearOfIssue).hashCode()
                + 11 * transmission.hashCode();
    }

    @Override
    public String toString() {
        return "Car: " +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", yearOfIssue=" + yearOfIssue +
                ", transmission=" + transmission;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public String getTransmission() {
        return transmission;
    }
}

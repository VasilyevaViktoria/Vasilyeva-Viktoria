package homework10.Task2;

import java.util.HashMap;
import java.util.Map;

public class Garage {

    Map<Car, Integer> carParkingMap = new HashMap<>();

    public void fullParking(Car car) {
        carParkingMap.put(car, carParkingMap.containsKey(car) ? carParkingMap.get(car) + 1 : 1);
    }

    public void messageAboutCarOfThisType() {
        for (Map.Entry<Car, Integer> entry : carParkingMap.entrySet()) {
            System.out.printf("Автомобиль %s - %s", entry.getKey(), entry.getValue());
            System.out.println();
        }
    }

    public void deleteFromParking(Car car) {
        if (carParkingMap.containsKey(car) && carParkingMap.get(car) > 1) {
            carParkingMap.put(car, carParkingMap.get(car) - 1);
        } else if (carParkingMap.containsKey(car) && carParkingMap.get(car) > 0) {
            carParkingMap.remove(car);
        } else {
            System.out.println("Автомобиль " + car + " нет на стоянке");
        }
    }

    public int countOfTheSameCars(Car car) {
        int count = 0;
        for (Map.Entry<Car, Integer> entry : carParkingMap.entrySet()) {
            if(car.getClass().getName().equals(entry.getKey().getClass().getName())){
                count = count + entry.getValue();
            }
        }
        return count;
    }
}

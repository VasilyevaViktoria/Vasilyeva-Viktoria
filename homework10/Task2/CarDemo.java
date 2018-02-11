package homework10.Task2;

public class CarDemo {

    public static void main(String[] args) {
        Car limousine1 = new Limousine("Lincoln", "Excalibur", 1999, "machine", 5);
        Car limousine2 = new Limousine("Cadillac","Escalade" , 2002, "machine",7);

        Car minivan1 = new Minivan("Volkswagen", "Sharan", 2015, "automat", 4);
        Car minivan2 = new Minivan("Nissan", "Serena", 2017, "automat", 6);

        Car truck1 = new Truck("Class", "Xerion", 2002, "machine", 1);
        Car truck2 = new Truck("John","Deere", 2005, "machine", 2);

        Car motocycle1 = new Motorcycle("Yamaha", "Thunderace", 2017,"automat", 2);
        Car motocycle2 = new Motorcycle("Kawasaki ", "Ninja", 2015, "machine", 3);

        Garage garage = new Garage();
        garage.fullParking(minivan1);
        garage.fullParking(limousine2);
        garage.fullParking(truck1);
        garage.fullParking(motocycle1);
        garage.fullParking(motocycle1);
        garage.fullParking(minivan2);
        garage.fullParking(motocycle2);
        garage.fullParking(minivan1);

        System.out.println();
        garage.messageAboutCarOfThisType();

        garage.deleteFromParking(truck2);
        garage.deleteFromParking(truck1);
        garage.deleteFromParking(limousine1);
        garage.deleteFromParking(truck1);

        System.out.println();
        garage.messageAboutCarOfThisType();

        System.out.println();
        System.out.println("Количество автомоблей данного вида: " + garage.countOfTheSameCars(minivan1));
    }
}

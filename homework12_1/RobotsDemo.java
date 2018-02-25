package homework12_1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class RobotsDemo {

    public static void main(String[] args) {
        Dump dump = new Dump();

        Servant servantFirst = new Servant();
        Servant servantSecond = new Servant();

        Labaratory scientistFirst = new Labaratory();
        Labaratory scientistSecond = new Labaratory();

        final CyclicBarrier NIGHT = new CyclicBarrier(3, () -> System.out.println("Завершилась ещё одна ночь" + "\n" + "\n"));

        Thread factory = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    System.out.println("На свалку были выброшены детали ...");
                    dump.dropDetailsOnDump();
                    Thread.sleep(100);
                    try {
                        NIGHT.await();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread servantFirstScientist = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    System.out.println("Прислужник первого ученого ушел на свалку за деталями ...");
                    System.out.println("Список деталей в лабаротории второго ученого: " + scientistFirst.optimazeListOfDetails(servantFirst.getRandomDetail(dump.getListOfDetailsOnDump())));
                    try {
                        NIGHT.await();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread servantSecondScientist = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    System.out.println("Прислужник второго ученого ушел на свалку за деталями ...");
                    System.out.println("Список деталей в лабаротории второго ученого: " + scientistSecond.optimazeListOfDetails(servantSecond.getRandomDetail(dump.getListOfDetailsOnDump())));
                    try {
                        NIGHT.await();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        factory.start();
        servantFirstScientist.start();
        servantSecondScientist.start();

        try {
            factory.join();
            servantSecondScientist.join();
            servantFirstScientist.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Первый ученый начинает собирать роботов из имеющихся деталей: ");
        System.out.println("Второй ученый начинает собирать роботов из имеющихся деталей: ");
        System.out.println();
        System.out.println("Первым ученым создано " + scientistFirst.сreateRobots() + " роботов");
        System.out.println("Вторым ученым создано " + scientistSecond.сreateRobots() + " роботов");

    }
}

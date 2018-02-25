package homework12_1;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Dump{

    private List<Details> listOfDetailsOnDump = new LinkedList<>();
    private static final int START_COUNT_OF_DETAILS = 20;

    public Dump() {
        initializatingDump();
    }

    private synchronized void initializatingDump() {
        for (int i = 0; i < START_COUNT_OF_DETAILS; i++) {
            int indexOfDetail = RandomUtil.generateDetails(Details.values().length);
            listOfDetailsOnDump.add(Details.values()[indexOfDetail]);
        }
    }

    public synchronized void dropDetailsOnDump() {
        int countOfDetails = RandomUtil.generateDetailsFromOneToFour();
        for (int i = 0; i < countOfDetails; i++) {
            int indexOfDetail = RandomUtil.generateDetails(Details.values().length);
            listOfDetailsOnDump.add(Details.values()[indexOfDetail]);
        }
    }

    public List<Details> getListOfDetailsOnDump() {
        return listOfDetailsOnDump;
    }
}

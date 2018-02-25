package homework12_1;

import java.util.ArrayList;
import java.util.List;

public class Servant {

    private List<Details> detailsForLabaratory = new ArrayList<>();
    private int countOfDetailsForToday = RandomUtil.generateDetailsFromOneToFour();

    public synchronized List<Details> getRandomDetail(List<Details> listOfDetailsOnDump) {
        if (countOfDetailsForToday <= listOfDetailsOnDump.size()) {
            for (int i = 0; i < countOfDetailsForToday; i++) {
                int index = RandomUtil.generateDetails(listOfDetailsOnDump.size());
                    detailsForLabaratory.add(listOfDetailsOnDump.get(index));
                    listOfDetailsOnDump.remove(index);
            }
        } else {
            for (int i = 0; i < listOfDetailsOnDump.size(); i++) {
                int index = RandomUtil.generateDetails(listOfDetailsOnDump.size());
                detailsForLabaratory.add(listOfDetailsOnDump.get(index));
                listOfDetailsOnDump.remove(index);
            }
        }

        return detailsForLabaratory;
    }

    public void print() {
        System.out.println(detailsForLabaratory);
    }
}

package homework12_1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Labaratory {

    private Map<Details, Integer> listOfDetailsInLabaratory = new HashMap<>();

    public synchronized Map<Details, Integer> optimazeListOfDetails(List<Details> detailsForLabaratory) {
        for (Details detail : detailsForLabaratory) {
            listOfDetailsInLabaratory.put(detail,
                    listOfDetailsInLabaratory.getOrDefault(detail, 0) + 1);
        }
        detailsForLabaratory.clear();

        return listOfDetailsInLabaratory;
    }

    public int сreateRobots() {
        Map.Entry<Details, Integer> entry = listOfDetailsInLabaratory.entrySet().iterator().next();
        int countsOfRobots = entry.getValue();

        for (int value : listOfDetailsInLabaratory.values()) {
            if (listOfDetailsInLabaratory.size() != Details.values().length) {
                countsOfRobots = 0;
                break;
            }
            if (value < countsOfRobots) {
                countsOfRobots = value;
            }
        }

        return countsOfRobots;
    }
}

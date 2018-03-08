package homework13temp2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

public final class PrintUtil {

    public PrintUtil() {
    }

    public static void printPercent(BufferedWriter reportAsTotalTime,int minutesOfActivity, int totalTime){
        try {
            reportAsTotalTime.write(String.format("%.2f", (double) minutesOfActivity / ((double) totalTime / 100))+ "%" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printTimeOfTypesOfActivity(BufferedWriter reportAsTotalTime, Map<String, Integer> listOfLectionsToday, int minutesOfActivity){
        for (Map.Entry<String, Integer> entry : listOfLectionsToday.entrySet()) {
            try {
                reportAsTotalTime.write("   " + entry.getKey() + ": " + entry.getValue() + " минут ");
            } catch (IOException e) {
                e.printStackTrace();
            }
            printPercent(reportAsTotalTime, entry.getValue(), minutesOfActivity);
        }
    }
}

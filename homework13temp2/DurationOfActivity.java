package homework13temp2;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import static java.time.Duration.between;

public class DurationOfActivity {

    public int minutesOfActivityToday(Matcher startTime, Matcher endTime, List<String> activity, int minutesOfActivity) {
        LocalTime endTimeToLocalTime = LocalTime.parse(endTime.group(1));
        LocalTime startTimeToLocalTime = LocalTime.parse(startTime.group(1));

        for (String typeOfActivity : activity) {
            if (startTime.group(2).equals(typeOfActivity)) {
                minutesOfActivity += (int) between(startTimeToLocalTime, endTimeToLocalTime).toMinutes();
            }
        }

        return minutesOfActivity;
    }

    public Map<String, Integer> minutesOfTypes(Matcher startTime, Matcher endTime, List<String> activity, Map<String, Integer> listOfTypeOfActivityForToday) {
        LocalTime endTimeToLocalTime = LocalTime.parse(endTime.group(1));
        LocalTime startTimeToLocalTime = LocalTime.parse(startTime.group(1));

        for (String typeOfActivity : activity) {
            if (startTime.group(2).equals(typeOfActivity)) {
                int minutesOfActivity = (int) between(startTimeToLocalTime, endTimeToLocalTime).toMinutes();
                listOfTypeOfActivityForToday.merge(typeOfActivity, minutesOfActivity, Integer::sum);
            }
        }

        return listOfTypeOfActivityForToday;
    }
}

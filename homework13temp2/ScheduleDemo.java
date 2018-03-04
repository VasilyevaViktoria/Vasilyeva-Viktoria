package homework13temp2;

import java.io.File;
import java.util.List;

import static java.lang.String.join;

public class ScheduleDemo {

    public static void main(String[] args) {
        File file = new File(join(File.separator, "src", "homework13temp2",  "schedule.log"));

        ReadSchedule scheduleList = new ReadSchedule();
        List<String> schedule = scheduleList.getScheduleFromFile(file);

        FirstReport firstReport = new FirstReport();
        firstReport.scheduleOfLessons(schedule);

        SecondReport secondReport = new SecondReport();
        secondReport.totalTimeOfLessons(schedule);
    }
}

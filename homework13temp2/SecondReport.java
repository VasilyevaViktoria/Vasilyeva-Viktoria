package homework13temp2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.join;

public class SecondReport {

    public void totalTimeOfLessons(List<String> sheduleList) {
        File secondReportAsTotalTime = new File(join(File.separator, "src", "homework13temp2", "secondReport.txt"));
        Map<String, Integer> listOfLecturesForToday = new HashMap<>();

        Pattern pattern = Pattern.compile("^(\\d{2}:\\d{2})\\s?([а-яА-Я\\s?]+)");
        Pattern pattern1 = Pattern.compile("\\d{2}:\\d{2}\\s?Конец");

        int minutesLectures = 0;
        int minutesOfLecture;
        int minutesRest = 0;
        int minutesPractice = 0;

        try (BufferedWriter reportAsTotalTime = new BufferedWriter(new FileWriter(secondReportAsTotalTime));) {
            for (int i = 0; i < sheduleList.size(); i++) {
                Matcher startTime = pattern.matcher(sheduleList.get(i));
                Matcher endOfTodayDay = pattern1.matcher(sheduleList.get(i));

                if (endOfTodayDay.find()) {
                    writeTotalTime(minutesLectures, minutesPractice, minutesRest, reportAsTotalTime, listOfLecturesForToday);

                    minutesLectures = 0;
                    minutesRest = 0;
                    minutesPractice = 0;
                    listOfLecturesForToday.clear();

                    i++;

                } else if (startTime.find()) {
                    Matcher endTime = pattern.matcher(sheduleList.get(i + 1));
                    endTime.find();

                    LocalTime endTimeToLocalType = LocalTime.parse(endTime.group(1));
                    LocalTime startTimeToLocalType = LocalTime.parse(startTime.group(1));
                    Lectures[] type = Lectures.values();

                    for (int lecture = 0; lecture < type.length; lecture++) {
                        if (startTime.group(2).equals(type[lecture].getDescription())) {
                            minutesOfLecture = (int) Duration.between(startTimeToLocalType, endTimeToLocalType).toMinutes();
                            listOfLecturesForToday.merge(type[lecture].getDescription(), minutesOfLecture, Integer::sum);

                            minutesLectures += minutesOfLecture;
                        }
                    }

                    for (int rest = 0; rest < Rest.values().length; rest++) {
                        if (startTime.group(2).equals(Rest.values()[rest].getDescription())) {
                            minutesRest += (int) Duration.between(startTimeToLocalType, endTimeToLocalType).toMinutes();
                        }
                    }

                    for (int practice = 0; practice < Practice.values().length; practice++) {
                        if (startTime.group(2).equals(Practice.values()[practice].getDescription())) {
                            minutesPractice += (int) Duration.between(startTimeToLocalType, endTimeToLocalType).toMinutes();
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeTotalTime(int minutesLectures, int minutesPractice, int minutesRest, BufferedWriter reportAsTotalTime, Map<String, Integer> listOfLectionsToday) {
        try {
            int totalTime = minutesLectures + minutesPractice + minutesRest;

            reportAsTotalTime.write("Общее время: " + totalTime + " минут " + "\n");

            reportAsTotalTime.write("Лекции: " + minutesLectures + " минут " +
                    String.format("%.2f", (double) minutesLectures / ((double) totalTime / 100)) + "%" + "\n");
            for (Map.Entry<String, Integer> entry : listOfLectionsToday.entrySet()) {
                reportAsTotalTime.write("   " + entry.getKey() + ": " + entry.getValue() + " минут " +
                        String.format("%.2f", (double) entry.getValue() / ((double) minutesLectures / 100)) + "%" + "\n");
            }

            reportAsTotalTime.write("Перерывы: " + minutesRest + " минут " +
                    String.format("%.2f", (double) minutesRest / ((double) totalTime / 100)) + "%" + "\n");

            reportAsTotalTime.write("Практики: " + minutesPractice + " минут " +
                    String.format("%.2f", (double) minutesPractice / ((double) totalTime / 100)) + "%" + "\n");

            reportAsTotalTime.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

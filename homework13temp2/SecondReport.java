package homework13temp2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static homework13temp2.DurationOfActivity.minutesOfActivityToday;
import static homework13temp2.DurationOfActivity.minutesOfTypes;
import static homework13temp2.PrintUtil.printPercent;
import static homework13temp2.PrintUtil.printTimeOfTypesOfActivity;
import static java.lang.String.join;

public class SecondReport {

    public void totalTimeOfLessons(List<String> sheduleList) {
        File secondReportAsTotalTime = new File(join(File.separator, "src", "homework13temp2", "secondReport.log"));

        List<String> lectures = Arrays.asList("Введение", "Массивы", "Скаляры", "Углубленное изучение массивов");
        List<String> rest = Arrays.asList("Перерыв", "Обеденный перерыв", "Разминка");
        List<String> practice = Arrays.asList("Упражнения", "Решения");

        Map<String, Integer> listOfLecturesForToday = new HashMap<>();

        Pattern pattern = Pattern.compile("^(\\d{2}:\\d{2})\\s?([а-яА-Я\\s?]+)");
        Pattern pattern1 = Pattern.compile("\\d{2}:\\d{2}\\s?Конец");

        int minutesLectures = 0;
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

                    minutesLectures = minutesOfActivityToday(startTime, endTime, lectures, minutesLectures);
                    listOfLecturesForToday = minutesOfTypes(startTime, endTime, lectures, listOfLecturesForToday);

                    minutesRest = minutesOfActivityToday(startTime, endTime, rest, minutesRest);

                    minutesPractice = minutesOfActivityToday(startTime, endTime, practice, minutesPractice);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeTotalTime(int minutesLectures, int minutesPractice, int minutesRest, BufferedWriter reportAsTotalTime, Map<String, Integer> listOfLecturesForToday) {
        try {
            int totalTime = minutesLectures + minutesPractice + minutesRest;

            reportAsTotalTime.write("Общее время: " + totalTime + " минут " + "\n");

            reportAsTotalTime.write("Лекции: " + minutesLectures + " минут ");
            printPercent(reportAsTotalTime, minutesLectures, totalTime);
            printTimeOfTypesOfActivity(reportAsTotalTime, listOfLecturesForToday, minutesLectures);

            reportAsTotalTime.write("Перерывы: " + minutesRest + " минут ");
            printPercent(reportAsTotalTime, minutesRest, totalTime);

            reportAsTotalTime.write("Практики: " + minutesPractice + " минут ");
            printPercent(reportAsTotalTime, minutesPractice, totalTime);

            reportAsTotalTime.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

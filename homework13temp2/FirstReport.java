package homework13temp2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.join;

public class FirstReport {

    public void scheduleOfLessons(List<String> scheduleList) {
        File firstReportAsTimeInervals = new File(join(File.separator, "src", "homework13temp2", "firstReport.txt"));
        StringBuffer reportFirst = new StringBuffer();

        Pattern pattern = Pattern.compile("^(\\d{2}:\\d{2})(\\s?[а-яА-Я\\s?]+)$");

        try (BufferedWriter reportAsTimeIntervalsOfLessons = new BufferedWriter(new FileWriter(firstReportAsTimeInervals));) {

            for (int i = 0; i < scheduleList.size() - 1; i++) {
                Matcher startTime = pattern.matcher(scheduleList.get(i));
                Matcher finishTime = pattern.matcher(scheduleList.get(i + 1));

                if (startTime.find() && finishTime.find()) {
                    startTime.appendReplacement(reportFirst,
                            startTime.group(1) + " - " + finishTime.group(1) + startTime.group(2) + "\n");
                } else {
                    reportFirst.append("\n");
                    i++;
                }
            }

            reportAsTimeIntervalsOfLessons.write(reportFirst.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

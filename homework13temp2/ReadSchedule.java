package homework13temp2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadSchedule {

    public List<String> getScheduleFromFile(File file) {
        List<String> scheduleList = new ArrayList<>();

        Pattern pattern = Pattern.compile("^(\\d{2}:\\d{2})(\\s?[а-яА-Я\\s?]+)$");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                scheduleList.add(matcher.find() ? matcher.group() : "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return scheduleList;
    }
}

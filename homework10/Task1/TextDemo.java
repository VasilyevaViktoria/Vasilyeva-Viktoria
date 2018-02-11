package homework10.Task1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sun.deploy.uitoolkit.impl.awt.AWTClientPrintHelper.print;
import static homework10.Task1.Text.frequencyOfOccurrence;

public class TextDemo {

    public static void main(String[] args) {
        String str = "Success is like reaching an important birthday and finding you’re exactly the same same Same";

        TextPrint.print(frequencyOfOccurrence(str));
    }
}

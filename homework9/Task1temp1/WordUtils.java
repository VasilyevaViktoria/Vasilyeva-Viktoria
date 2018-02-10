package homework9.Task1temp1;

import java.util.ArrayList;

public class WordUtils {
    
    public static ArrayList<String> markLength4(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
        return list;
    }


}

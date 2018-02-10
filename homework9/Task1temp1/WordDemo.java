package homework9.Task1temp1;

import java.util.ArrayList;

public class WordDemo {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("this");
        list.add("is");
        list.add("lots");
        list.add("of");
        list.add("fun");
        list.add("for");
        list.add("every");
        list.add("Java");
        list.add("programmer");

        System.out.print("Исходный массив: ");
        WordPrint.print(list);

        System.out.println();
        System.out.print("Полученный массив: ");
        ArrayList<String> newList = WordUtils.markLength4(list);
        WordPrint.print(newList);
    }
}


package homework9.Task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class TheHighestAverageScoreFirstVar {

    public static void bestAverageScore(ArrayList<Student> list) {
        list.sort(new StudentSort.StudentAverageScoreComparator());
        Student bestStudent = list.get(0);
        Iterator<Student> setIterator = list.iterator();

        while (setIterator.hasNext()) {
            Student nextStudent = setIterator.next();
            if (bestStudent.getAverageScore() != nextStudent.getAverageScore()) {
                setIterator.remove();
            }
        }
    }
}

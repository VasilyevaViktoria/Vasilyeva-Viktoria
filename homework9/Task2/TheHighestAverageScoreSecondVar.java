package homework9.Task2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class TheHighestAverageScoreSecondVar {

    public static double bestAverageScore(ArrayList<Student> list) {
        Iterator<Student> setIterator = list.iterator();
        Student bestStudent = list.get(0);
        double bestStudentAverageScore = 0;

        while (setIterator.hasNext()) {
            Student nextStudent = setIterator.next();
            if (bestStudent.getAverageScore() <= nextStudent.getAverageScore()) {
                bestStudentAverageScore = nextStudent.getAverageScore();
                bestStudent = nextStudent;
            }
        }

        return bestStudentAverageScore;
    }

    public static ArrayList<Student> TheHighestScore(ArrayList<Student> list) {
        ArrayList<Student> listOfBestStudents = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAverageScore() == bestAverageScore(list)) {
                listOfBestStudents.add(list.get(i));
            }
        }

        return listOfBestStudents;
    }
}

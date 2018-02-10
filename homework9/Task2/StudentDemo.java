package homework9.Task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static homework9.Task2.StudentPrint.print;
import static homework9.Task2.TheHighestAverageScoreFirstVar.bestAverageScore;
import static homework9.Task2.TheHighestAverageScoreSecondVar.TheHighestScore;

public class StudentDemo {

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("George", "Washington", 67, 6));
        list.add(new Student("John", "Adams", 90, 8));
        list.add(new Student("John", "Tyler", 71, 10));
        list.add(new Student("Franklin", "Pierce", 64, 10));
        list.add(new Student("Abraham", "Lincoln", 56, 9));
        list.add(new Student("Andrew", "Johnson", 66, 6));
        list.add(new Student("Franklin", "Roosevelt", 63, 9));
        list.add(new Student("John", "Kennedy", 46, 5));

        print(list);

        System.out.println("");
        System.out.println("Student with the highest average score: ");
        ArrayList<Student> listOfBestStudents = TheHighestScore(list);
        print(listOfBestStudents);

//        System.out.println();
//        Collections.sort(list);
//        print(list);

        System.out.println();
        list.sort(new StudentSort.StudentFirstSecondNameComparator());
        print(list);

        System.out.println();
        list.sort(new StudentSort.StudentAgeComparator());
        print(list);

        System.out.println();
        list.sort(new StudentSort.StudentAverageScoreComparator());
        print(list);

        System.out.println();
        bestAverageScore(list);
        print(list);
    }
}

package homework9.Task2;

import java.util.Comparator;

public class StudentSort {

    public static class StudentFirstSecondNameComparator implements Comparator<Student> {
        private StudentSecondNameComparator secondNameComparator = new StudentSecondNameComparator();

        @Override
        public int compare(Student o1, Student o2) {
            int result = o1.getFirstName().compareTo(o2.getFirstName());
            if (result == 0) {
                result = secondNameComparator.compare(o1, o2);
            }

            return result;
        }
    }

    public static class StudentSecondNameComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {

            return o1.getSecondName().compareTo(o2.getSecondName());
        }
    }

    public static class StudentAgeComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {

            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }

    public static class StudentAverageScoreComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {

            return Double.compare(o2.getAverageScore(), o1.getAverageScore());
        }
    }
}

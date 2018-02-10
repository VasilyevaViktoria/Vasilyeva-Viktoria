package homework9.Task2;

public class Student {
    private String firstName;
    private String secondName;
    private int age;
    private double averageScore;

    public Student(String firstName, String secondName, int age, int averageScore) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", averageScore=" + averageScore +
                '}';
    }

    //    Оставила этот метод для себя, в данной задаче эта сортиовка не уместна
//    @Override
//    public int compareTo(Student o) {
//        return Integer.valueOf(this.getAverageScore()).compareTo(Integer.valueOf(o.getAverageScore()));
//    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public double getAverageScore() {
        return averageScore;
    }
}

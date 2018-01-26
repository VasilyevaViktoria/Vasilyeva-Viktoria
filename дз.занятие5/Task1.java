package дз.занятие5;

public class Task1 {
    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder()
                .append("123456789");

        System.out.println("Source string: " + builder.toString());
        System.out.println("Reverse string: " + builder.reverse().toString());

        isPolindrom(builder);
        System.out.println(isPolindrom(builder));
    }

    public static boolean isPolindrom(StringBuilder builder) {
        return builder.toString() == builder.reverse().toString();
    }
}

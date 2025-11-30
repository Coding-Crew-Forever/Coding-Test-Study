import java.io.*;
import java.util.*;

public class BOJ_5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        List<Person> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = bufferedReader.readLine();
            String name = input.split(" ")[0];
            int day = Integer.parseInt(input.split(" ")[1]);
            int month = Integer.parseInt(input.split(" ")[2]);
            int year = Integer.parseInt(input.split(" ")[3]);

            list.add(new Person(name, day, month, year));
        }

        list.sort((a, b) -> {
            if (a.year != b.year) return a.year - b.year;
            if (a.month != b.month) return a.month - b.month;
            return a.day - b.day;
        });

        System.out.println(list.get(list.size() - 1).name);

        System.out.println(list.get(0).name);
    }
}
class Person {
    String name;
    int day;
    int month;
    int year;

    public Person(String name, int day, int month, int year) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }
}

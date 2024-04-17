package s12_Generics;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Comparing {
    public static void main(String[] args) {
        Integer five = 5;
        Integer[] others = {0, 5, 10, -50, 50};

        for (Integer i : others) {
            int val = five.compareTo(i);
            System.out.printf("%d %s %d: compareTo=%d%n", five,
                    (val == 0 ? "==" : (val < 0) ? "<" : ">"), i, val);
        }

        String banana = "banana";
        String[] fruit = {"apple", "banana", "pear", "BANANA"};

        System.out.println("----------------------");
        for (String s : fruit) {
            int val = banana.compareTo(s);
            System.out.printf("%s %s %s: compareTo=%d%n", banana,
                    (val == 0 ? "==" : (val < 0) ? "<" : ">"), s, val);
        }

        System.out.println("----------------------");
        Arrays.sort(fruit);
        System.out.println(Arrays.toString(fruit));

        System.out.println("----------------------");
        System.out.println("A:" + (int) 'A' + " " + "a:" + (int) 'a');
        System.out.println("B:" + (int) 'B' + " " + "b:" + (int) 'b');
        System.out.println("P:" + (int) 'P' + " " + "p:" + (int) 'p');

        System.out.println("----------------------");
        Student manu = new Student("Manu");
        Student[] students = {new Student("Raj"), new Student("Akhil"),
                new Student("Ruchir")};

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        System.out.println("result = " + manu.compareTo(new Student("MANU")));

        Comparator<Student> cgpaSorter = new StudentCGPAComparator();
        Arrays.sort(students,cgpaSorter.reversed());
        System.out.println(Arrays.toString(students));

    }
}

class StudentCGPAComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return (o1.cgpa + o1.name).compareTo(o2.cgpa + o2.name);
    }
}

class Student implements Comparable<Student> {
    private static int LAST_ID = 1000;
    private static Random random = new Random();
    String name;
    private int id;
    protected double cgpa;


    public Student(String name) {
        this.name = name;
        id = LAST_ID++;
        cgpa = random.nextDouble(4.0, 10.0);
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id, name, cgpa);
    }

/*    @Override
    public int compareTo(Object o) {
        Student other = (Student) o;
        return name.compareTo(other.name);
    }*/

    @Override
    public int compareTo(Student o) {
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
    }
}

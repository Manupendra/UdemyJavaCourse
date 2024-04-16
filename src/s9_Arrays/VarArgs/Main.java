package s9_Arrays.VarArgs;

public class Main {
    public static void main(String... args) {
        System.out.println("Hello World again");

        String[] splitString = "Hello World again".split(" ");
        printText(splitString);
        System.out.println("_".repeat(20));
        printText("Hello");

        System.out.println("_".repeat(20));
        printText("Hello", "World", "again");

        System.out.println("_".repeat(20));
        printText();

        String[] sArray = {"first", "Second", "Third", "Fourth", "Fifth"};
        System.out.println(String.join(",", sArray));
    }

    private static void printText(String... textList) {
        for (String t : textList) {
            System.out.println(t);
        }
    }
}

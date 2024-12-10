package s17.streams.streamSource;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        IntStream.iterate(1, n -> n + 1)
                .limit(20)
                .forEach(s -> System.out.print(s + " "));
        System.out.println();

        IntStream.iterate(1,n->n+1)
                .limit(100)
                .filter(Main::isPrime)
                .forEach(s-> System.out.print(s+" "));
    }

    public static boolean isPrime(int wholeNumber) {
        if (wholeNumber <= 2) {
            return (wholeNumber == 2);
        }
        for (int divisor = 2; divisor < wholeNumber; divisor++) {
            if (wholeNumber % divisor == 0)
                return false;
        }
        return true;

    }
}

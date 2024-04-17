package s10.List;

import java.util.ArrayList;
import java.util.List;

public class MoreLists {
    public static void main(String[] args) {
        String[] items = {"apples", "bananas", "milk", "eggs"};

        // static method List.of()
        List<String> list = List.of(items);
        System.out.println(list);

        // Create an ArrayList to add the elements
        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("yogurt");
        System.out.println(groceries);

        // create an ArrayList and passed static method in constructor
        ArrayList<String> nextList = new ArrayList<>(
                List.of("pickles", "mustard", "cheese")
        );
        System.out.println(nextList);

        // adding into existing list
        groceries.addAll(nextList);
        System.out.println(groceries);
    }
}

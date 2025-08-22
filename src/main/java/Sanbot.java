import java.util.Scanner;
import java.util.ArrayList;

public class Sanbot {

    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {

        String greeting ="Hello! I'm Sanbot\nWhat can I do for you?\n";
        System.out.println(greeting);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            exit = handleInput(scanner.nextLine());
        }

        scanner.close();
    }

    private static boolean handleInput(String input) {
        String bye = "Bye. Hope to see you again soon!";

        if (input.equals("bye")) {
            System.out.println(bye);
            return true;
        } else if (input.equals("list")){
            printListItems();
        } else {
            list.add(input);
            System.out.println("added: " + input);
        }
        return false;
    }

    private static void printListItems() {
        int index = 1;
        for (String item : list) {
            System.out.println(index + ": " + item);
            index++;
        }
    }
}
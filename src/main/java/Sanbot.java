import java.util.Scanner;
import java.util.ArrayList;

public class Sanbot {
    public static void main(String[] args) {

        String greeting ="Hello! I'm Sanbot\nWhat can I do for you?\n";
        String bye = "Bye. Hope to see you again soon!";

        Scanner scanner = new Scanner(System.in);

        System.out.println(greeting);

        String input;
        ArrayList<String> list = new ArrayList<>();

        while (true) {
            input = scanner.nextLine();

            if (input.equals("bye")) {
                System.out.println(bye);
                break;
            } else if (input.equals("list")){
                int index = 1;
                for (String i : list) {
                    System.out.println(index + ". " + i);
                    index++;
                }
            } else {
                list.add(input);
                System.out.println("added: " + input);
            }
        }

        scanner.close();
    }
}
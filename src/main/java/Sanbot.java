import java.util.Scanner;

public class Sanbot {
    public static void main(String[] args) {

        String greeting ="Hello! I'm Sanbot\nWhat can I do for you?\n";
        String bye = "Bye. Hope to see you again soon!";

        Scanner scanner = new Scanner(System.in);

        System.out.println(greeting);

        String input;

        while (true) {
            input = scanner.nextLine();

            if (input.equals("bye")) {
                System.out.println(bye);
                break;
            } else {
                System.out.println(input);
            }
        }

        scanner.close();
    }
}
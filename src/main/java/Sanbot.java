import java.util.Scanner;
import java.util.ArrayList;

public class Sanbot {

    private static ArrayList<Task> list = new ArrayList<>();

    public static void main(String[] args) {

        String greeting = "Hello! I'm Sanbot\nWhat can I do for you?\n";
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
        String[] processed = input.split(" ");

        switch (processed[0]) {
            case "bye":
                System.out.println(bye);
                return true;
            case "list":
                printListItems();
                break;
            case "mark":
                markDone(Integer.parseInt(processed[1].trim()) - 1);
                break;
            case "unmark":
                markNotDone(Integer.parseInt(processed[1].trim()) - 1);
                break;
            case "todo":
                todoHandler(input);
                break;
            case "deadline":
                deadlineHandler(input);
                break;
            case "event":
                eventHandler(input);
                break;
            default:
                System.out.println("Oops, I am not sure what is the task type!");
        }
        return false;
    }

    private static void printListItems() {
        int index = 1;
        for (Task item : list) {
            System.out.println(index + ": " + item);
            index++;
        }
    }

    private static void markDone(int num) {
        list.get(num).markAsDone();
        System.out.println("Nice! I have marked this task as done:\n" + list.get(num));
    }

    private static void markNotDone(int num) {
        list.get(num).markAsNotDone();
        System.out.println("OK, I've marked this task as not done yet:\n" + list.get(num));
    }

    private static void todoHandler(String input) {
        Task t = new TodoTask(input.substring(5));
        list.add(t);
        System.out.println("Got it. I have added this task:\n" + t);
    }

    private static void deadlineHandler(String input) {
        String[] details = input.split("/by");
        Task dt = new DeadlineTask(details[0].substring(9), details[1].substring(1));
        list.add(dt);
        System.out.println("Got it. I have added this task:\n" + dt);
    }

    private static void eventHandler(String input) {
        String[] details2 = input.split("/from");
        String[] details3 = details2[1].split("/to");
        Task et = new EventTask(details2[0].substring(6), details3[0].substring(1), details3[1].substring(1));
        list.add(et);
        System.out.println("Got it. I have added this task:\n" + et);
    }
}
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sanbot {

    private static ArrayList<Task> list = new ArrayList<>();
    private static int count = 0;

    public static void main(String[] args) {

        String greeting = "Hello! I'm Sanbot\nWhat can I do for you?\n";
        System.out.println(greeting);

        list = Storage.loadTasks();
        count = list.size();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            exit = handleInput(scanner.nextLine());
        }

        scanner.close();
        Storage.saveTasks(list);
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
                markDone(processed);
                break;
            case "unmark":
                markNotDone(processed);
                break;
            case "delete":
                delete(processed);
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

    private static void markDone(String[] processed) {
        try {
            int num = Integer.parseInt(processed[1].trim()) - 1;
            list.get(num).markAsDone();
            System.out.println("Nice! I have marked this task as done:\n" + list.get(num));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Oops! It seems like you are trying to mark your task done\n" +
                    "but you missed out the task number\nor maybe forgot to add a space before the number?");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Oops! It seems like you are trying to mark your task done\n" +
                    "but you have entered an invalid task index");
        }
    }

    private static void markNotDone(String[] processed) {
        try {
            int num = Integer.parseInt(processed[1].trim()) - 1;
            list.get(num).markAsNotDone();
            System.out.println("OK, I've marked this task as not done yet:\n" + list.get(num));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Oops! It seems like you are trying to mark your task as not done\n"
                + "but you missed out the task number\nor maybe forgot to add a space before the number?");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Oops! It seems like you are trying to mark your task as not done\n" +
                    "but you have entered an invalid task index");
        }
    }

    private static void delete(String[] processed) {
        try {
            int num = Integer.parseInt(processed[1].trim()) - 1;
            Task removed = list.get(num);
            list.remove(num);
            count--;
            System.out.println("OK, I have removed this task from the list:\n" + removed);
            System.out.printf("Now you have %d task(s) in the list%n", count);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Oops! It seems like you are trying to delete a task\n"
                    + "but you missed out the task number\nor maybe forgot to add a space before the number?");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Oops! It seems like you are trying to delete a task\n" +
                    "but you have entered an invalid task index");
        }
    }

    private static void todoHandler(String input) {
        Task t = new TodoTask(input.substring(5));
        list.add(t);
        count++;
        System.out.println("Got it. I have added this task:\n" + t);
        System.out.printf("Now you have %d task(s) in the list%n", count);
    }

    private static void deadlineHandler(String input) {
        try {
            String[] details = input.split("/by");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            LocalDateTime deadline = LocalDateTime.parse(details[1].substring(1), formatter);
            Task dt = new DeadlineTask(details[0].substring(9), deadline);
            list.add(dt);
            count++;
            System.out.println("Got it. I have added this task:\n" + dt);
            System.out.printf("Now you have %d task(s) in the list%n", count);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("I see you are trying to add a task with a deadline.\n"
                + "it seems you did not use the '/by' flag properly\n"
                + "input in the following format:\n"
                + "deadline <task> /by <deadline>");
        }

    }

    private static void eventHandler(String input) {
        try {
            String[] details2 = input.split("/from");
            String[] details3 = details2[1].split("/to");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            LocalDateTime from = LocalDateTime.parse(details3[0].substring(1).trim(), formatter);
            LocalDateTime to = LocalDateTime.parse(details3[1].substring(1).trim(), formatter);
            Task et = new EventTask(details2[0].substring(6), from, to);
            list.add(et);
            count++;
            System.out.println("Got it. I have added this task:\n" + et);
            System.out.printf("Now you have %d task(s) in the list%n", count);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("I see you are trying to add an event.\n"
                + "it seems you did not use the '/from' and '/to' flags properly\n"
                + "input in the following format:\n"
                + "event <task> /from <start> /to <end>");
        }

    }
}
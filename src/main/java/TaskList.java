import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> list = new ArrayList<>();
    private static int count;

    public static void taskList(ArrayList<Task> list) {
        list = list;
        count = list.size();
    }

    public static ArrayList<Task> getAllTasks() {
        return list;
    }

    public static void printListItems() {
        int index = 1;
        for (Task item : list) {
            System.out.println(index + ": " + item);
            index++;
        }
    }

    public static void markDone(String[] processed) {
        try {
            int num = Integer.parseInt(processed[1].trim()) - 1;
            list.get(num).markAsDone();
            Ui.markDone(list.get(num));
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.markDoneIndexError();
        } catch (IndexOutOfBoundsException e) {
            Ui.markDoneInvalidIndex();
        }
    }

    public static void markNotDone(String[] processed) {
        try {
            int num = Integer.parseInt(processed[1].trim()) - 1;
            list.get(num).markAsNotDone();
            Ui.markNotDone(list.get(num));
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.markNotDoneIndexError();
        } catch (IndexOutOfBoundsException e) {
            Ui.markNotDoneInvalidIndex();
        }
    }

    public static void delete(String[] processed) {
        try {
            int num = Integer.parseInt(processed[1].trim()) - 1;
            Task removed = list.get(num);
            list.remove(num);
            count--;
            Ui.delete(removed, count);
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.deleteIndexError();
        } catch (IndexOutOfBoundsException e) {
            Ui.deleteInvalidIndex();
        }
    }

    public static void todoHandler(String input) {
        Task task = new TodoTask(input.substring(5));
        list.add(task);
        count++;
        Ui.todo(task, count);
    }

    public static void deadlineHandler(String input) {
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

    public static void eventHandler(String input) {
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

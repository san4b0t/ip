import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> list = new ArrayList<>();
    private static int count;

    public static void taskList(ArrayList<Task> loadedList) {
        list = loadedList;
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
            Ui.deadline(dt, count);
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.deadlineIndexError();
        }

    }

    public static void eventHandler(String input) {
        try {
            String[] details = input.split("/from");
            String[] splitFromAndTo = details[1].split("/to");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            LocalDateTime from = LocalDateTime.parse(splitFromAndTo[0].substring(1).trim(), formatter);
            LocalDateTime to = LocalDateTime.parse(splitFromAndTo[1].substring(1).trim(), formatter);
            Task et = new EventTask(details[0].substring(6), from, to);
            list.add(et);
            count++;
            Ui.event(et, count);
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.eventIndexError();
        }

    }
}

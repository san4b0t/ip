package sanfobot.tasklist;

import sanfobot.command.*;
import sanfobot.task.Task;

import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> taskList = new ArrayList<>();

    public static void taskList(ArrayList<Task> loadedList) {
        taskList = loadedList;
    }

    public static ArrayList<Task> getAllTasks() {
        return taskList;
    }

    public static void printListItems() {
        int index = 1;
        for (Task item : taskList) {
            System.out.println(index + ": " + item);
            index++;
        }
    }

    public static void markDone(String input) {
        MarkDoneCommand command = new MarkDoneCommand();
        command.execute(input, taskList);
    }

    public static void markNotDone(String input) {
        MarkNotDoneCommand command = new MarkNotDoneCommand();
        command.execute(input, taskList);
    }

    public static void deleteTask(String input) {
        DeleteTaskCommand command = new DeleteTaskCommand();
        command.execute(input, taskList);
    }

    public static void todoHandler(String input) {
        AddTodoTaskCommand command = new AddTodoTaskCommand();
        command.execute(input, taskList);
    }

    public static void deadlineHandler(String input) {
        AddDeadlineTaskCommand command = new AddDeadlineTaskCommand();
        command.execute(input, taskList);
    }

    public static void eventHandler(String input) {
        AddEventTaskCommand command = new AddEventTaskCommand();
        command.execute(input, taskList);
    }
}

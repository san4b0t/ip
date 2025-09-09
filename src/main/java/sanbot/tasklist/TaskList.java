package sanbot.tasklist;

import sanbot.command.*;
import sanbot.task.Task;

import java.util.ArrayList;

/**
 * Static utility class for managing the global task list and delegating commands.
 */
public class TaskList {
    /** The global list of all tasks */
    private static ArrayList<Task> taskList = new ArrayList<>();

    /**
     * Initializes the task list with loaded tasks.
     *
     * @param loadedList the list of tasks to set as the current task list
     */
    public static void taskList(ArrayList<Task> loadedList) {
        taskList = loadedList;
    }

    /**
     * Returns the complete task list.
     *
     * @return the current list of all tasks
     */
    public static ArrayList<Task> getAllTasks() {
        return taskList;
    }

    /**
     * Prints all tasks with their index numbers.
     */
    public static void printListItems() {
        int index = 1;
        for (Task item : taskList) {
            System.out.println(index + ": " + item);
            index++;
        }
    }

    /**
     * Delegates mark done command to MarkDoneCommand.
     *
     * @param input the user input for marking task as done
     */
    public static void markDone(String input) {
        MarkDoneCommand command = new MarkDoneCommand();
        command.execute(input, taskList);
    }

    /**
     * Delegates mark not done command to MarkNotDoneCommand.
     *
     * @param input the user input for marking task as not done
     */
    public static void markNotDone(String input) {
        MarkNotDoneCommand command = new MarkNotDoneCommand();
        command.execute(input, taskList);
    }

    /**
     * Delegates delete command to DeleteTaskCommand.
     *
     * @param input the user input for deleting a task
     */
    public static void deleteTask(String input) {
        DeleteTaskCommand command = new DeleteTaskCommand();
        command.execute(input, taskList);
    }

    /**
     * Delegates todo creation to AddTodoTaskCommand.
     *
     * @param input the user input for creating a todo task
     */
    public static void todoHandler(String input) {
        AddTodoTaskCommand command = new AddTodoTaskCommand();
        command.execute(input, taskList);
    }

    /**
     * Delegates deadline task creation to AddDeadlineTaskCommand.
     *
     * @param input the user input for creating a deadline task
     */
    public static void deadlineHandler(String input) {
        AddDeadlineTaskCommand command = new AddDeadlineTaskCommand();
        command.execute(input, taskList);
    }

    /**
     * Delegates event task creation to AddEventTaskCommand.
     *
     * @param input the user input for creating an event task
     */
    public static void eventHandler(String input) {
        AddEventTaskCommand command = new AddEventTaskCommand();
        command.execute(input, taskList);
    }

    /**
     * Delegates finding tasks to FindTasksCommand
     *
     * @param input the user input to find related tasks
     */
    public static void findTasks(String input) {
        FindTasksCommand command = new FindTasksCommand();
        command.execute(input, taskList);
    }
}
package sanbot.ui;

import sanbot.task.Task;

import java.util.ArrayList;

/**
 * Utility class for handling all user interface output messages.
 */
public class Ui {

    /**
     * Displays the welcome greeting message.
     */
    public static String greeting() {
        String greeting = "Hello! I'm Sanbot\nWhat can I do for you?\n";
        System.out.println(greeting);
        return greeting;
    }

    /**
     * Displays confirmation message for marking task as done.
     *
     * @param task the task that was marked as done
     */
    public static String markDone(Task task) {
        System.out.println("Nice! I have marked this task as done:\n" + task.toString());
        return "Nice! I have marked this task as done:\n" + task;
    }

    /**
     * Displays error message for invalid mark done command format.
     */
    public static String markDoneIndexError() {
        System.out.println("Oops! It seems like you are trying to mark your task done\n" +
                "but you missed out the task number\nor maybe forgot to add a space before the number?");
        return "Oops! It seems like you are trying to mark your task done\n" +
                "but you missed out the task number\nor maybe forgot to add a space before the number?";
    }

    /**
     * Displays error message for invalid mark done task index.
     */
    public static String markDoneInvalidIndex() {
        System.out.println("Oops! It seems like you are trying to mark your task done\n" +
                "but you have entered an invalid task index");
        return "Oops! It seems like you are trying to mark your task done\n" +
                "but you have entered an invalid task index";
    }

    /**
     * Displays confirmation message for marking task as not done.
     *
     * @param task the task that was marked as not done
     */
    public static String markNotDone(Task task) {
        System.out.println("OK, I've marked this task as not done yet:\n" + task.toString());
        return "OK, I've marked this task as not done yet:\n" + task;
    }

    /**
     * Displays error message for invalid mark not done command format.
     */
    public static String markNotDoneIndexError() {
        System.out.println("Oops! It seems like you are trying to mark your task as not done\n"
                + "but you missed out the task number\nor maybe forgot to add a space before the number?");
        return "Oops! It seems like you are trying to mark your task as not done\n"
                + "but you missed out the task number\nor maybe forgot to add a space before the number?";
    }

    /**
     * Displays error message for invalid mark not done task index.
     */
    public static String markNotDoneInvalidIndex() {
        System.out.println("Oops! It seems like you are trying to mark your task as not done\n" +
                "but you have entered an invalid task index");
        return "Oops! It seems like you are trying to mark your task as not done\n" +
                "but you have entered an invalid task index";
    }

    /**
     * Displays confirmation message for deleting a task.
     *
     * @param removed the task that was deleted
     * @param count the number of remaining tasks in the list
     */
    public static String delete(Task removed, int count) {
        System.out.println("OK, I have removed this task from the list:\n" + removed);
        System.out.printf("Now you have %d task(s) in the list%n", count);
        return "OK, I have removed this task from the list:\n" + removed +
                String.format("Now you have %d task(s) in the list%n", count);
    }

    /**
     * Displays error message for invalid delete command format.
     */
    public static String deleteIndexError() {
        System.out.println("Oops! It seems like you are trying to delete a task\n"
                + "but you missed out the task number\nor maybe forgot to add a space before the number?");
        return "Oops! It seems like you are trying to delete a task\n"
                + "but you missed out the task number\nor maybe forgot to add a space before the number?";
    }

    /**
     * Displays error message for invalid delete task index.
     */
    public static String deleteInvalidIndex() {
        System.out.println("Oops! It seems like you are trying to delete a task\n" +
                "but you have entered an invalid task index");
        return "Oops! It seems like you are trying to delete a task\n" +
                "but you have entered an invalid task index";
    }

    /**
     * Displays confirmation message for adding a todo task.
     *
     * @param task the todo task that was added
     * @param count the total number of tasks in the list
     */
    public static String todo(Task task, int count) {
        System.out.println("Got it. I have added this task:\n" + task);
        System.out.printf("Now you have %d task(s) in the list%n", count);
        return "Got it. I have added this task:\n" + task + "\n" +
                String.format("Now you have %d task(s) in the list%n", count);
    }

    /**
     * Displays confirmation message for adding a deadline task.
     *
     * @param task the deadline task that was added
     * @param count the total number of tasks in the list
     */
    public static String deadline(Task task, int count) {
        System.out.println("Got it. I have added this task:\n" + task);
        System.out.printf("Now you have %d task(s) in the list%n", count);
        return "Got it. I have added this task:\n" + task + "\n" +
                String.format("Now you have %d task(s) in the list%n", count);
    }

    /**
     * Displays error message for invalid deadline command format.
     */
    public static String deadlineIndexError() {
        System.out.println("I see you are trying to add a task with a deadline.\n"
                + "it seems you did not use the '/by' flag properly\n"
                + "input in the following format:\n"
                + "deadline <task> /by <deadline>");
        return "I see you are trying to add a task with a deadline.\n"
                + "it seems you did not use the '/by' flag properly\n"
                + "input in the following format:\n"
                + "deadline <task> /by <deadline>";
    }

    /**
     * Displays confirmation message for adding an event task.
     *
     * @param task the event task that was added
     * @param count the total number of tasks in the list
     */
    public static String event(Task task, int count) {
        System.out.println("Got it. I have added this task:\n" + task);
        System.out.printf("Now you have %d task(s) in the list%n", count);
        return "Got it. I have added this task:\n" + task + "\n" +
                String.format("Now you have %d task(s) in the list%n", count);
    }

    /**
     * Displays error message for invalid event command format.
     */
    public static String eventIndexError() {
        System.out.println("I see you are trying to add an event.\n"
                + "it seems you did not use the '/from' and '/to' flags properly\n"
                + "input in the following format:\n"
                + "event <task> /from <start> /to <end>");
        return "I see you are trying to add an event.\n"
                + "it seems you did not use the '/from' and '/to' flags properly\n"
                + "input in the following format:\n"
                + "event <task> /from <start> /to <end>";
    }

    /**
     * Displays list of tasks found using input keyword
     *
     * @param foundTasks
     */
    public static String printFoundTasks(ArrayList<Task> foundTasks) {
        System.out.println("Here are the matching tasks in your task list:");
        String foundTaskList = "Here are the matching tasks in your task list:\n";
        int index = 1;
        for (Task task : foundTasks) {
            System.out.printf("%d. %s\n", index, task);
            foundTaskList += String.format("%d. %s\n", index, task);
            index++;
        }
        return foundTaskList;
    }

    /**
     * Display message in case no tasks was found using input keyword.
     */
    public static String noTasksFound() {
        System.out.println("Oops! No tasks were found using the keyword you input.");
        return "Oops! No tasks were found using the keyword you input.";
    }

    /**
     * Display error message for missing input for find command
     */
    public static String missingFindTaskInput() {
        System.out.println("Oops! It seems you were tyring to find tasks but did not enter a keyword.\n"
            + "Please enter the command in the format: \n"
            + "find <keyword>");
        return "Oops! It seems you were tyring to find tasks but did not enter a keyword.\n"
                + "Please enter the command in the format: \n"
                + "find <keyword>";
    }
}
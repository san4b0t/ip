package sanbot.parser;

import sanbot.storage.Storage;
import sanbot.tasklist.TaskList;

/**
 * Parser utility class for processing user commands.
 */
public class Parser {

    /**
     * Processes user input and delegates to appropriate task operations.
     * Returns true if the application should exit (bye command).
     *
     * @param input the user input string to be parsed and executed
     * @return true if the bye command was entered, false otherwise
     */
    public static String handleInput(String input) {
        assert input != null : "Input cannot be null!";
        assert !input.trim().isEmpty() : "Input cannot be just whitespaces!";

        String[] processed = input.split(" ");

        assert processed.length > 0 : "split should produce at least 1 element";

        switch (processed[0]) {
            case "bye":
                return TaskList.exitApp(input);
            case "list":
                return TaskList.printListItems();
            case "mark":
                return TaskList.markDone(input);
            case "unmark":
                return TaskList.markNotDone(input);
            case "delete":
                return TaskList.deleteTask(input);
            case "todo":
                return TaskList.todoHandler(input);
            case "deadline":
                return TaskList.deadlineHandler(input);
            case "event":
                return TaskList.eventHandler(input);
            case "find":
                return TaskList.findTasks(input);
            default:
                System.out.println("Oops, I am not sure what is the task type!");
                return "Oops, I am not sure what is the task type!";
        }
    }
}
package sanbot.parser;

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
    public static boolean handleInput(String input) {
        String bye = "Bye. Hope to see you again soon!";
        String[] processed = input.split(" ");

        switch (processed[0]) {
            case "bye":
                System.out.println(bye);
                return true;
            case "list":
                TaskList.printListItems();
                break;
            case "mark":
                TaskList.markDone(input);
                break;
            case "unmark":
                TaskList.markNotDone(input);
                break;
            case "delete":
                TaskList.deleteTask(input);
                break;
            case "todo":
                TaskList.todoHandler(input);
                break;
            case "deadline":
                TaskList.deadlineHandler(input);
                break;
            case "event":
                TaskList.eventHandler(input);
                break;
            default:
                System.out.println("Oops, I am not sure what is the task type!");
        }
        return false;
    }
}
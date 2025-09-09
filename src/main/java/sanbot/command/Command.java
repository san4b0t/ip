package sanbot.command;

import sanbot.task.Task;

import java.util.ArrayList;

/**
 * Interface for command objects following the Command pattern.
 */
public interface Command {

    /**
     * Executes the command with given input and task list.
     *
     * @param input the user input string that triggered this command
     * @param taskList the list of tasks that may be modified by the command execution
     */
    public void execute(String input, ArrayList<Task> taskList);
}

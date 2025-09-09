package sanbot.command;

import sanbot.task.Task;
import sanbot.ui.Ui;

import java.util.ArrayList;

/**
 * Command to mark tasks as not completed by index.
 */
public class MarkNotDoneCommand {

    /**
     * Marks a task as not done by its position number.
     * Format: "unmark [task_number]"
     *
     * @param input the user input string containing the unmark command and task number
     * @param taskList the list of tasks containing the task to mark as not done
     * @throws ArrayIndexOutOfBoundsException if the input format is invalid or missing the task number
     * @throws IndexOutOfBoundsException if the specified task index is out of bounds for the task list
     */
    public void execute(String input, ArrayList<Task> taskList) {
        String[] processed = input.split(" ");
        try {
            int num = Integer.parseInt(processed[1].trim()) - 1;
            taskList.get(num).markAsNotDone();
            Ui.markNotDone(taskList.get(num));
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.markNotDoneIndexError();
        } catch (IndexOutOfBoundsException e) {
            Ui.markNotDoneInvalidIndex();
        }
    }
}

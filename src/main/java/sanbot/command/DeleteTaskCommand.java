package sanbot.command;

import sanbot.task.Task;
import sanbot.ui.Ui;

import java.util.ArrayList;

/**
 * Command to delete tasks from the task list by index.
 */
public class DeleteTaskCommand {

    /**
     * Removes a task by its position number.
     * Format: "delete [task_number]"
     *
     * @param input the user input string containing the delete command and task number
     * @param taskList the list of tasks from which to remove the specified task
     * @throws ArrayIndexOutOfBoundsException if the input format is invalid or missing the task number
     * @throws IndexOutOfBoundsException if the specified task index is out of bounds for the task list
     */
    public String execute(String input, ArrayList<Task> taskList) {
        String[] processed = input.split(" ");
        try {
            int num = Integer.parseInt(processed[1].trim()) - 1;
            Task removed = taskList.get(num);
            taskList.remove(num);
            return Ui.delete(removed, taskList.size());
        } catch (ArrayIndexOutOfBoundsException e) {
            return Ui.deleteIndexError();
        } catch (IndexOutOfBoundsException e) {
            return Ui.deleteInvalidIndex();
        }
    }
}

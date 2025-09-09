package sanbot.command;

import sanbot.task.Task;
import sanbot.ui.Ui;

import java.util.ArrayList;

/**
 * Command to mark tasks as completed by index.
 */
public class MarkDoneCommand implements Command {

    /**
     * Marks a task as done by its position number.
     * Format: "mark [task_number]"
     *
     * @param input the user input string containing the mark command and task number
     * @param taskList the list of tasks containing the task to mark as done
     * @throws ArrayIndexOutOfBoundsException if the input format is invalid or missing the task number
     * @throws IndexOutOfBoundsException if the specified task index is out of bounds for the task list
     */
    public void execute(String input, ArrayList<Task> taskList) {
        String[] processed = input.split(" ");
        try {
            int num = Integer.parseInt(processed[1].trim()) - 1;
            taskList.get(num).markAsDone();
            Ui.markDone(taskList.get(num));
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.markDoneIndexError();
        } catch (IndexOutOfBoundsException e) {
            Ui.markDoneInvalidIndex();
        }
    }
}
package sanbot.command;

import sanbot.task.DeadlineTask;
import sanbot.task.Task;
import sanbot.ui.Ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Command to add deadline tasks with due dates to the task list.
 */
public class AddDeadlineTaskCommand {

    /**
     * Parses input and creates a deadline task.
     * Format: "deadline [description] /by [dd-MM-yyyy HH:mm]"
     *
     * @param input the user input string containing task description and deadline
     * @param taskList the list of tasks to add the new deadline task to
     * @throws ArrayIndexOutOfBoundsException if the input format is invalid or missing required parts
     */
    public void execute(String input, ArrayList<Task> taskList) {
        try {
            String[] details = input.split("/by");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            LocalDateTime deadline = LocalDateTime.parse(details[1].substring(1), formatter);
            Task dt = new DeadlineTask(details[0].substring(9), deadline);
            taskList.add(dt);
            Ui.deadline(dt, taskList.size());
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.deadlineIndexError();
        }
    }
}
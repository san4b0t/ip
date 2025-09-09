package sanbot.command;

import sanbot.task.EventTask;
import sanbot.task.Task;
import sanbot.ui.Ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Command to add event tasks with start and end times to the task list.
 */
public class AddEventTaskCommand {

    /**
     * Parses input and creates an event task.
     * Format: "event [description] /from [dd-MM-yyyy HH:mm] /to [dd-MM-yyyy HH:mm]"
     *
     * @param input the user input string containing task description, start time, and end time
     * @param taskList the list of tasks to add the new event task to
     * @throws ArrayIndexOutOfBoundsException if the input format is invalid or missing required parts
     */
    public void execute(String input, ArrayList<Task> taskList) {
        try {
            String[] details = input.split("/from");
            String[] splitFromAndTo = details[1].split("/to");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            LocalDateTime from = LocalDateTime.parse(splitFromAndTo[0].substring(1).trim(), formatter);
            LocalDateTime to = LocalDateTime.parse(splitFromAndTo[1].substring(1).trim(), formatter);
            Task et = new EventTask(details[0].substring(6), from, to);
            taskList.add(et);
            Ui.event(et, taskList.size());
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.eventIndexError();
        }
    }
}
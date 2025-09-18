package sanbot.reminder;

import sanbot.storage.Storage;
import sanbot.task.Task;

import java.util.ArrayList;

public class DeadlineTasksReminder {
    public static String remindDeadlinesMessage() {
        ArrayList<Task> deadlineTasks = Storage.getDeadlineTasks();

        if (deadlineTasks.isEmpty()) {
            return "You have no pending deadline tasks, keep it up!";
        }

        StringBuilder reminder = new StringBuilder();
        reminder.append("You have the following deadline tasks due\n");

        for (Task task : deadlineTasks) {
            reminder.append(task).append("\n");
        }

        return reminder.toString();
    }
}

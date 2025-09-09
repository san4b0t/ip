package sanbot.command;

import sanbot.task.Task;
import sanbot.ui.Ui;

import java.util.ArrayList;

public class FindTasksCommand implements Command {
    public void execute(String input, ArrayList<Task> taskList) {
        String key = input.substring(5).trim();
        ArrayList<Task> foundTasks = new ArrayList<>();
        for (Task task : taskList) {
            String[] split = task.toString().split(" ");
            for (String word : split) {
                if (word.equals(key)) {
                    foundTasks.add(task);
                }
            }
        }
        Ui.printFoundTasks(foundTasks);
    }
}

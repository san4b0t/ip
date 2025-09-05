package sanfobot.command;

import sanfobot.task.Task;
import sanfobot.ui.Ui;

import java.util.ArrayList;

public class DeleteTaskCommand {
    public void execute(String input, ArrayList<Task> taskList) {
        String[] processed = input.split(" ");
        try {
            int num = Integer.parseInt(processed[1].trim()) - 1;
            Task removed = taskList.get(num);
            taskList.remove(num);
            Ui.delete(removed, taskList.size());
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.deleteIndexError();
        } catch (IndexOutOfBoundsException e) {
            Ui.deleteInvalidIndex();
        }
    }
}

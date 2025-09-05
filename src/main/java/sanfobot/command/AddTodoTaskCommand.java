package sanfobot.command;

import sanfobot.task.Task;
import sanfobot.task.TodoTask;
import sanfobot.ui.Ui;

import java.util.ArrayList;

public class AddTodoTaskCommand {
    public void execute(String input, ArrayList<Task> taskList) {
        Task task = new TodoTask(input.substring(5));
        taskList.add(task);
        Ui.todo(task, taskList.size());
    }
}

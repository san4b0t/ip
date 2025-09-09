package sanbot.command;

import sanbot.task.Task;
import sanbot.task.TodoTask;
import sanbot.ui.Ui;

import java.util.ArrayList;

/**
 * Command to add simple todo tasks to the task list.
 */
public class AddTodoTaskCommand {

    /**
     * Creates a todo task from input description.
     * Format: "todo [description]"
     *
     * @param input the user input string containing the "todo" command and task description
     * @param taskList the list of tasks to add the new todo task to
     */
    public void execute(String input, ArrayList<Task> taskList) {
        Task task = new TodoTask(input.substring(5));
        taskList.add(task);
        Ui.todo(task, taskList.size());
    }
}
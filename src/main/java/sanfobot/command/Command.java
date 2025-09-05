package sanfobot.command;

import sanfobot.task.Task;

import java.util.ArrayList;

public interface Command {
    public void execute(String input, ArrayList<Task> taskList);
}

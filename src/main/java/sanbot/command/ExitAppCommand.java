package sanbot.command;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import sanbot.storage.Storage;
import sanbot.task.Task;
import sanbot.ui.Ui;

import java.util.ArrayList;

/**
 * Command to close the chatbot window
 */
public class ExitAppCommand implements Command {
    /**
     *
     * @param input the user input string that triggered this command
     * @param taskList the list of tasks
     * @return response to inform user that currently exiting chatbot
     */
    public String execute(String input, ArrayList<Task> taskList) {
        Storage.saveTasks(taskList);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(4), e -> {
            System.exit(0);
        }));
        timeline.play();
        return Ui.exitApp();
    }
}

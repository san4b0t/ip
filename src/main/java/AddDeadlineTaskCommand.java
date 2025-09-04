import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AddDeadlineTaskCommand {
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

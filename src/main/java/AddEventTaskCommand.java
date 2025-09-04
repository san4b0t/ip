import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AddEventTaskCommand {
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

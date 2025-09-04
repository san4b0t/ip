import java.util.ArrayList;

public class MarkNotDoneCommand {
    public void execute(String input, ArrayList<Task> taskList) {
        String[] processed = input.split(" ");
        try {
            int num = Integer.parseInt(processed[1].trim()) - 1;
            taskList.get(num).markAsNotDone();
            Ui.markNotDone(taskList.get(num));
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.markNotDoneIndexError();
        } catch (IndexOutOfBoundsException e) {
            Ui.markNotDoneInvalidIndex();
        }
    }
}

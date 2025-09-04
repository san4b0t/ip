import java.util.ArrayList;

public class MarkDoneCommand implements Command{
    public void execute(String input, ArrayList<Task> taskList) {
        String[] processed = input.split(" ");
        try {
            int num = Integer.parseInt(processed[1].trim()) - 1;
            taskList.get(num).markAsDone();
            Ui.markDone(taskList.get(num));
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.markDoneIndexError();
        } catch (IndexOutOfBoundsException e) {
            Ui.markDoneInvalidIndex();
        }
    }
}

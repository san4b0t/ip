import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> list = new ArrayList<>();
    private int count;

    public TaskList(ArrayList<Task> list) {
        this.list = list;
        this.count = list.size();
    }
}

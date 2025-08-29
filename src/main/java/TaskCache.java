import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TaskCache {

    private static final String FILEPATH = "data/taskCache.txt";

    public static void saveTasks(ArrayList<Task> tasks) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(FILEPATH));
            for (Task t : tasks) {
                writer.write(t.toString());
                writer.newLine();
                System.out.println("wrote task " + t.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

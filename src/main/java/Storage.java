import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Storage {

    private static final String FILEPATH = "data/taskCache.txt";

    public static void saveTasks(ArrayList<Task> tasks) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(FILEPATH));
            for (Task t : tasks) {
                writer.write(t.saver());
                writer.newLine();
                System.out.println("saved task: " + t.saver());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<Task> loadTasks() {
        ArrayList<Task> loaded = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(FILEPATH));
            String line = reader.readLine();
            while (line != null) {
                String[] processed = line.split("\\|");
                String type = processed[0].trim();

                if (type.equals("T")) {
                    Task t = new TodoTask(processed[2].trim());
                    if (processed[1].trim().equals("1")) {
                        t.markAsDone();
                    }
                    loaded.add(t);
                } else if (type.equals("D")) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                    LocalDateTime deadline = LocalDateTime.parse(processed[3].trim(), formatter);
                    Task t = new DeadlineTask(processed[2].trim(), deadline);
                    if (processed[1].trim().equals("1")) {
                        t.markAsDone();
                    }
                    loaded.add(t);
                } else if (type.equals("E")) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                    LocalDateTime from = LocalDateTime.parse(processed[3].trim(), formatter);
                    LocalDateTime to = LocalDateTime.parse(processed[4].trim(), formatter);
                    Task t = new EventTask(processed[2].trim(), from, to);
                    if (processed[1].trim().equals("1")) {
                        t.markAsDone();
                    }
                    loaded.add(t);
                } else {
                    System.out.println("Task could not be read");
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loaded;
    }

}

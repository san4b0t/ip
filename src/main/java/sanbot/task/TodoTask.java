package sanbot.task;

/**
 * Simple task with only a description and completion status.
 */
public class TodoTask extends Task {

    /**
     * Creates a todo task with specified name.
     *
     * @param name the task description
     */
    public TodoTask(String name) {
        super(name);
    }

    /**
     * Returns formatted string representation for display.
     * Format: "[T] [X] task description"
     *
     * @return formatted string with todo task marker
     */
    @Override
    public String toString() {
        return "[T] " + super.toString();
    }

    /**
     * Returns formatted string for file storage.
     * Format: "T isDone| task description"
     *
     * @return formatted string for saving to file
     */
    @Override
    public String toSaveString() {
        return String.format("T %s", super.toSaveString());
    }
}
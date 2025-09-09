package sanbot.task;

import java.time.LocalDateTime;

/**
 * Task with a deadline date and time.
 */
public class DeadlineTask extends Task {
    /** The deadline date and time for this task */
    private LocalDateTime deadline;

    /**
     * Creates a deadline task with specified name and deadline.
     *
     * @param name the task description
     * @param by the deadline date and time
     */
    public DeadlineTask(String name, LocalDateTime by) {
        super(name);
        this.deadline = by;
    }

    /**
     * Returns formatted string representation for display.
     * Format: "[D] [X] task description (by: dayOfWeek, month day year, hour:minute)"
     *
     * @return formatted string with deadline task marker and deadline for task itself
     */
    @Override
    public String toString() {
        String deadlineFormatted = String.format("%s, %s %d %d, %02d:%02d", deadline.getDayOfWeek(),
                deadline.getMonth(), deadline.getDayOfMonth(), deadline.getYear(),
                deadline.getHour(), deadline.getMinute());
        return "[D] " + super.toString() + String.format(" (by: %s)", deadlineFormatted);
    }

    /**
     * Returns formatted string for file storage.
     * Format: "D isDone| task description| dd-MM-yyyy HH:mm"
     *
     * @return formatted string for saving to file
     */
    @Override
    public String toSaveString() {
        String deadlineFormatted = String.format("%02d-%02d-%d %02d:%02d", deadline.getDayOfMonth(),
                deadline.getMonthValue(), deadline.getYear(), deadline.getHour(), deadline.getMinute());
        return String.format("D %s| %s", super.toSaveString(), deadlineFormatted);
    }
}
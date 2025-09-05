package sanfobot.task;

import java.time.LocalDateTime;


public class DeadlineTask extends Task {
    private LocalDateTime deadline;

    public DeadlineTask(String name, LocalDateTime by) {
        super(name);
        this.deadline = by;
    }

    @Override
    public String toString() {
        String deadlineFormatted = String.format("%s, %s %d %d, %02d:%02d", deadline.getDayOfWeek(),
                deadline.getMonth(), deadline.getDayOfMonth(), deadline.getYear(),
                deadline.getHour(), deadline.getMinute());
        return "[D] " + super.toString() + String.format(" (by: %s)", deadlineFormatted);
    }

    @Override
    public String toSaveString() {
        String deadlineFormatted = String.format("%02d-%02d-%d %02d:%02d", deadline.getDayOfMonth(),
                deadline.getMonthValue(), deadline.getYear(), deadline.getHour(), deadline.getMinute());
        return String.format("D %s | %s", super.toSaveString(), deadlineFormatted);
    }
}

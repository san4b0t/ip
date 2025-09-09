package sanbot.task;

import java.time.LocalDateTime;

/**
 * Task with start and end date/time periods.
 */
public class EventTask extends Task {
    /** The start date and time for this event */
    private LocalDateTime start;
    /** The end date and time for this event */
    private LocalDateTime end;

    /**
     * Creates an event task with specified name, start time, and end time.
     *
     * @param name the task description
     * @param start the event start date and time
     * @param end the event end date and time
     */
    public EventTask(String name, LocalDateTime start, LocalDateTime end) {
        super(name);
        this.start = start;
        this.end = end;
    }

    /**
     * Returns formatted string representation for display.
     * Format: "[E] [X] task description (from: start_datetime to: end_datetime)"
     *
     * @return formatted string with event task marker and time period
     */
    @Override
    public String toString() {
        String startFormatted = String.format("%s, %s %d %d, %d:%02d", start.getDayOfWeek(),
                start.getMonth(), start.getDayOfMonth(), start.getYear(),
                start.getHour(), start.getMinute());
        String endFormatted = String.format("%s, %s %d %d, %d:%02d", end.getDayOfWeek(),
                end.getMonth(), end.getDayOfMonth(), end.getYear(),
                end.getHour(), end.getMinute());
        return "[E] " + super.toString() + String.format(" (from: %s to: %s)", startFormatted, endFormatted);
    }

    /**
     * Returns formatted string for file storage.
     * Format: "E isDone| task description| dd-MM-yyyy HH:mm | dd-MM-yyyy HH:mm"
     *
     * @return formatted string for saving to file
     */
    @Override
    public String toSaveString() {
        String startFormatted = String.format("%02d-%02d-%d %02d:%02d", start.getDayOfMonth(),
                start.getMonthValue(), start.getYear(), start.getHour(), start.getMinute());
        String endFormatted = String.format("%02d-%02d-%d %02d:%02d", end.getDayOfMonth(),
                end.getMonthValue(), end.getYear(), end.getHour(), end.getMinute());
        return String.format("E %s| %s | %s", super.toSaveString(), startFormatted, endFormatted);
    }
}
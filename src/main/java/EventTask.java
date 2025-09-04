import java.time.LocalDateTime;

public class EventTask extends Task {
    private LocalDateTime start;
    private LocalDateTime end;

    public EventTask(String name, LocalDateTime start, LocalDateTime end) {
        super(name);
        this.start = start;
        this.end = end;
    }

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

    @Override
    public String toSaveString() {
        String startFormatted = String.format("%02d-%02d-%d %02d:%02d", start.getDayOfMonth(),
                start.getMonthValue(), start.getYear(), start.getHour(), start.getMinute());
        String endFormatted = String.format("%02d-%02d-%d %02d:%02d", end.getDayOfMonth(),
                end.getMonthValue(), end.getYear(), end.getHour(), end.getMinute());
        return String.format("E %s| %s | %s", super.toSaveString(), startFormatted, endFormatted);
    }
}

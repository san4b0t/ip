import java.time.LocalDateTime;

public class EventTask extends Task{
    private LocalDateTime start;
    private LocalDateTime end;

    public EventTask(String name, LocalDateTime start, LocalDateTime end) {
        super(name);
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[E] " + super.toString() + String.format(" (from: %s to: %s)", this.start, this.end);
    }

    @Override
    public String saver() {
        return String.format("E %s| %s | %s", super.saver(), this.start, this.end);
    }
}

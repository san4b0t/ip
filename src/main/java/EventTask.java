public class EventTask extends Task{
    private String start;
    private String end;

    public EventTask(String name, String start, String end) {
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

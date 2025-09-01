import java.time.LocalDateTime;


public class DeadlineTask extends Task {
    private LocalDateTime deadline;

    public DeadlineTask(String name, LocalDateTime by) {
        super(name);
        this.deadline = by;
    }

    @Override
    public String toString() {
        return "[D] " + super.toString() + String.format(" (by: %s)", this.deadline);
    }

    @Override
    public String saver() {
        return String.format("D %s | %s", super.saver(), this.deadline);
    }
}

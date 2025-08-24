public class DeadlineTask extends Task {
    private String deadline;

    public DeadlineTask(String name, String by) {
        super(name);
        this.deadline = by;
    }

    @Override
    public String toString() {
        return "[D] " + this.status() + String.format("(by: %s)", this.deadline);
    }
}

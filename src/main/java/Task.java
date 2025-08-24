public class Task {
    private String name;
    private boolean isDone;

    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void markAsNotDone() {
        this.isDone = false;
    }

    public String status() {
        String check = isDone ? "[X] " : "[ ] ";
        return check + this.name;
    }

    @Override
    public String toString() {
        return "[T] " + this.status();
    }
}

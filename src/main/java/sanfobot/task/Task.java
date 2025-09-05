package sanfobot.task;

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

    @Override
    public String toString() {
        String check = this.isDone ? "[X] " : "[ ] ";
        return check + this.name;
    }

    public String toSaveString() {
        int check = this.isDone ? 1 : 0;
        return String.format("| %d | %s", check, this.name);
    }
}

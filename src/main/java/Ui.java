public class Ui {

    public static void greeting() {
        String greeting = "Hello! I'm Sanbot\nWhat can I do for you?\n";
        System.out.println(greeting);
    }

    public static void markDone(Task task) {
        System.out.println("Nice! I have marked this task as done:\n" + task.toString());
    }

    public static void markDoneIndexError() {
        System.out.println("Oops! It seems like you are trying to mark your task done\n" +
                "but you missed out the task number\nor maybe forgot to add a space before the number?");
    }

    public static void markDoneInvalidIndex() {
        System.out.println("Oops! It seems like you are trying to mark your task done\n" +
                "but you have entered an invalid task index");
    }

    public static void markNotDone(Task task) {
        System.out.println("OK, I've marked this task as not done yet:\n" + task.toString());
    }

    public static void markNotDoneIndexError() {
        System.out.println("Oops! It seems like you are trying to mark your task as not done\n"
                + "but you missed out the task number\nor maybe forgot to add a space before the number?");
    }

    public static void markNotDoneInvalidIndex() {
        System.out.println("Oops! It seems like you are trying to mark your task as not done\n" +
                "but you have entered an invalid task index");
    }

    public static void delete(Task removed, int count) {
        System.out.println("OK, I have removed this task from the list:\n" + removed);
        System.out.printf("Now you have %d task(s) in the list%n", count);
    }

    public static void deleteIndexError() {
        System.out.println("Oops! It seems like you are trying to delete a task\n"
                + "but you missed out the task number\nor maybe forgot to add a space before the number?");
    }

    public static void deleteInvalidIndex() {
        System.out.println("Oops! It seems like you are trying to delete a task\n" +
                "but you have entered an invalid task index");
    }

    public static void todo(Task task, int count) {
        System.out.println("Got it. I have added this task:\n" + task);
        System.out.printf("Now you have %d task(s) in the list%n", count);
    }
}

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
}

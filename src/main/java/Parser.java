public class Parser {
    public static boolean handleInput(String input) {
        String bye = "Bye. Hope to see you again soon!";
        String[] processed = input.split(" ");

        switch (processed[0]) {
            case "bye":
                System.out.println(bye);
                return true;
            case "list":
                Sanbot.printListItems();
                break;
            case "mark":
                Sanbot.markDone(processed);
                break;
            case "unmark":
                Sanbot.markNotDone(processed);
                break;
            case "delete":
                Sanbot.delete(processed);
                break;
            case "todo":
                Sanbot.todoHandler(input);
                break;
            case "deadline":
                Sanbot.deadlineHandler(input);
                break;
            case "event":
                Sanbot.eventHandler(input);
                break;
            default:
                System.out.println("Oops, I am not sure what is the task type!");
        }
        return false;
    }
}

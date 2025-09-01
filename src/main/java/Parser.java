public class Parser {
    public static boolean handleInput(String input) {
        String bye = "Bye. Hope to see you again soon!";
        String[] processed = input.split(" ");

        switch (processed[0]) {
            case "bye":
                System.out.println(bye);
                return true;
            case "list":
                TaskList.printListItems();
                break;
            case "mark":
                TaskList.markDone(processed);
                break;
            case "unmark":
                TaskList.markNotDone(processed);
                break;
            case "delete":
                TaskList.delete(processed);
                break;
            case "todo":
                TaskList.todoHandler(input);
                break;
            case "deadline":
                TaskList.deadlineHandler(input);
                break;
            case "event":
                TaskList.eventHandler(input);
                break;
            default:
                System.out.println("Oops, I am not sure what is the task type!");
        }
        return false;
    }
}

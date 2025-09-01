import java.util.Scanner;

public class Sanbot {

    public static void main(String[] args) {

        String greeting = "Hello! I'm Sanbot\nWhat can I do for you?\n";
        System.out.println(greeting);

        TaskList.taskList(Storage.loadTasks());

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            exit = Parser.handleInput(scanner.nextLine());
        }

        scanner.close();
        Storage.saveTasks(TaskList.getAllTasks());
    }

}
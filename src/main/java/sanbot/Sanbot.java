package sanbot;

import sanbot.parser.Parser;
import sanbot.storage.Storage;
import sanbot.tasklist.TaskList;
import sanbot.ui.Ui;

import java.util.Scanner;

/**
 * Main class for the Sanbot chatbot.
 * Handles startup, user input loop, and exit.
 */
public class Sanbot {

    /**
     * Entry point for the Sanbot application.
     * Initializes the chatbot, loads saved tasks, processes user input,
     * and saves tasks before exit.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        Ui.greeting();
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
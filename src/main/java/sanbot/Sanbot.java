package sanbot;

import sanbot.parser.Parser;
import sanbot.storage.Storage;
import sanbot.tasklist.TaskList;
import sanbot.ui.Ui;

import java.util.Scanner;

public class Sanbot {

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
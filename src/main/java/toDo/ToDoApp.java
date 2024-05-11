package toDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class ToDoApp {
    Scanner scanner = new Scanner(System.in);
    String FILE_PATH = "src/main/java/toDo/toDo.txt";
    List<String> toDoList = new ArrayList<>();

    private void run() throws IOException {

        readFile();
        printWelcomeMessage();
        getInput();
        //writeFile();

    }

    private void printWelcomeMessage() {
        System.out.println("Welcome to this terminal app!");
        System.out.println("Here you can manage a to do list");
        System.out.println("Press one of the following numbers to access the associated action:");
        System.out.println("1: Add new to do");
        System.out.println("2: Show all to dos");
        System.out.println("3: Change an existing to do");
        System.out.println("4: Remove an existing to do");
        System.out.println("5: Terminate the session and save the changes");
    }

    public void getInput() {
        while (scanner.hasNext()) {
            switch (scanner.next()) {
                case "1":

                    addEntry();
                    printTasks();
                    break;
                case "2":

                    printTasks();
                    break;
                case "3":

                    changeTask();
                    printTasks();
                    break;
                case "4":
                    deleteTask();
                    printTasks();
                    break;
                case "5":
                    System.out.println("Saving the changes and exiting the session. Bye!");
                    writeFile();
                    return;
                default:
                    System.out.println("Invalid input");
                    System.out.println(scanner.next());
            }
        }
    }

    public void deleteTask() {
        System.out.println("Delete a task: Enter the index of the task and press enter");
        scanner.nextLine();
        while (true) {
            try {
                int indexOfTask = scanner.nextInt();
                while (!withinBounds(indexOfTask)) {
                    System.out.println("Index not within bounds! Try again");
                    indexOfTask = scanner.nextInt();
                }
                toDoList.remove(indexOfTask);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Not a number! Try again");
                scanner.next();
            }
        }
    }


    public boolean withinBounds(int index) {
        return (index < toDoList.size() && index >= 0);
    }

    public void changeTask() {
        System.out.println("Change a task: Enter the index of the task to change and press enter");
        scanner.nextLine();
        while (true) {
            try {
                int indexOfTask = scanner.nextInt();
                System.out.println("Index entered: " + indexOfTask);
                while (!withinBounds(indexOfTask)) {
                    System.out.println("Index not within bounds! Try again");
                    indexOfTask = scanner.nextInt();
                }
                System.out.println("Now enter the new task and press enter");
                scanner.nextLine();
                String newMessage = scanner.nextLine();

                toDoList.set(indexOfTask, newMessage);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
        }


    }

    public void addEntry() {
        System.out.println("Now enter the task and press enter");
        scanner.nextLine();
        String entry = scanner.nextLine();

        System.out.println("adding " + entry + " to the list");
        toDoList.add(entry);
    }

    public void printTasks() {
        System.out.println("Showing all tasks: ");
        System.out.println("List size: " + toDoList.size());
        System.out.println(toDoList);
        for (int i = 0; i < toDoList.size(); i++) {
            System.out.println("Index: " + i);
            System.out.println("Task: " + toDoList.get(i));
        }
    }

    public void writeFile() {
        try {
            FileWriter fw = new FileWriter(FILE_PATH);
            System.out.println("writing the list");
            System.out.println(toDoList);
            for (String str : toDoList) {
                if (str == null) break;
                fw.write(str + "\n");
            }
            //fw.write(String.valueOf(toDoList));
            fw.close();
        } catch (IOException e) {
            System.out.println("File not found! attempting to create it and try again");
            new File(FILE_PATH);
            writeFile();
        }

    }

    public void readFile() {
        try {
            Scanner scanner1 = new Scanner(new File(FILE_PATH));

            while (scanner1.hasNext()) {
                //System.out.println(scanner1.next());
                toDoList.add(scanner1.nextLine());
            }
            System.out.println("First element in the list read from hard drive:");

            if (!toDoList.isEmpty()) {
                printTasks();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found! List will be empty");
        }
    }

    private void ToDoApp() {
    }

    public static void main(String[] args) throws IOException {
        var app = new ToDoApp();
        app.run();

    }

}

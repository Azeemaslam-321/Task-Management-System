import java.util.ArrayList;
import java.util.Scanner;

public class TaskManagementSystem {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            performAction(choice);
        }
    }

    private static void displayMenu() {
        System.out.println("Task Management System");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. List Tasks");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("Invalid input. Please enter a number.");
            return getUserChoice();
        }
    }

    private static void performAction(int choice) {
        switch (choice) {
            case 1:
                addTask();
                break;
            case 2:
                removeTask();
                break;
            case 3:
                listTasks();
                break;
            case 4:
                System.out.println("Exiting the program. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    private static void addTask() {
        System.out.print("Enter task name: ");
        String name = scanner.next();
        System.out.print("Enter task description: ");
        String description = scanner.next();
        System.out.print("Enter due date: ");
        String dueDate = scanner.next();

        Task newTask = new Task(name, description, dueDate);
        tasks.add(newTask);

        System.out.println("Task added successfully!");
    }

    private static void removeTask() {
        System.out.print("Enter the index of the task to remove: ");
        int index = getUserChoice();

        if (index >= 0 && index < tasks.size()) {
            Task removedTask = tasks.remove(index);
            System.out.println("Task removed: " + removedTask.name);
        } else {
            System.out.println("Invalid index. Please enter a valid index.");
        }
    }

    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("List of tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println("Task " + i + ":");
                System.out.println("Name: " + task.name);
                System.out.println("Description: " + task.description);
                System.out.println("Due Date: " + task.dueDate);
                System.out.println();
            }
        }
    }
}

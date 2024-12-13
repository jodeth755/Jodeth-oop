
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private String title;

    public Task(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

class TodoList {
    private List<Task> tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void updateTask(int index, Task task) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set(index, task);
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public void displayTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).getTitle());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Display Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    todoList.addTask(new Task(title));
                    break;
                case 2:
                    todoList.displayTasks();
                    System.out.print("Enter task number to update: ");
                    int index = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline left-over
                    System.out.print("Enter new task title: ");
                    title = scanner.nextLine();
                    todoList.updateTask(index, new Task(title));
                    break;
                case 3:
                    todoList.displayTasks();
                    System.out.print("Enter task number to delete: ");
                    index = scanner.nextInt() - 1;
                    todoList.deleteTask(index);
                    break;
                case 4:
                    todoList.displayTasks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}

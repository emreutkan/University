import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TaskController tc = new TaskController();
        TaskView view = new TaskView(tc);

        Scanner scanner = new Scanner(System.in);

        Task task;

        while (true){
            System.out.println("Option:");
            System.out.println("1. Add Task");
            System.out.println("2. View Task");
            System.out.println("3. Mark Task as complete");
            System.out.println("4. Exit ");

            int input = scanner.nextInt();

            switch (input){
                case 1:
                    System.out.println("Give description for the task");
                    String description = scanner.next();
                    task = new Task(description);
                    tc.addTask(task);
                    break;
                case 2:
                    view.viewTasks();
                    break;
                case 3:
                    System.out.println("Give task number index");
                    int index = scanner.nextInt();
                    tc.markComplete(index-1);
                    break;
                case 4:
                    System.out.println("Exiting");
                    break;
            }


        }
    }
}
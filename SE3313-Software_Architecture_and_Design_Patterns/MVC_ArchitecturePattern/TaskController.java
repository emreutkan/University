import java.util.ArrayList;

public class TaskController {

    ArrayList<Task> taskList = new ArrayList<Task>();

    void addTask(Task task) {
        taskList.add(task);
    }


    void listTasks(){
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            String s =  i+1 + " " + task.description + " " + task.isComplete;
            System.out.println(s);

        }
    }


    void markComplete(int index){
        taskList.get(index).markCompletee();
    }


}

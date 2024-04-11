public class TaskView {

    TaskController taskcontroller;
    TaskView(TaskController taskcontroller){
        this.taskcontroller = taskcontroller;
    }

    void viewTasks(){
        for (int i = 0; i < taskcontroller.taskList.size(); i++) {
            Task task = taskcontroller.taskList.get(i);
            String s =  i+1 + " " + task.description + " " + task.isComplete;
            System.out.println(s);
        }
    }



}

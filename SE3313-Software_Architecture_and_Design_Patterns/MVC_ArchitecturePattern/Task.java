public class Task {

    Boolean isComplete;

    String description;

    Task(String description){
        this.description = description;
        isComplete = false;
    }

    void changeDescription(String description){
        this.description = description;
    }

    void markCompletee(){
        this.isComplete = true;
    }

    void markNotComplete(Task task){
        task.isComplete = false;
    }
}

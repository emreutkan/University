import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Flow;

public class channel implements subject{

    private final String cn;
    private ArrayList<observer> subscribers;
    private ArrayList<observer> Psubscribers;


    public channel(String cn){
        this.cn = cn;
        subscribers = new ArrayList<observer>();
        Psubscribers = new ArrayList<observer>();

    }

    public String returnName(){
        return cn;
    }

    @Override
    public void registerSubscriber(observer o) {
        subscribers.add(o);
    }
    @Override
    public void removeSubscriber(observer o) {
        subscribers.remove(o);
    }
    @Override
    public void notifySubscriber() {
        for(observer observer: this.subscribers){
           observer.update(this.cn,"normal");
        }
    }
    public void videoUploaded(){
        notifySubscriber();
    }
}

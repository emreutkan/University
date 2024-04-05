import java.util.ArrayList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Flow;
    public class premiumchannel implements subject{

        private final String cn;
        private final String premium;
        private ArrayList<observer> subscribers;

        public premiumchannel(String cn){
            this.cn = cn;
            subscribers = new ArrayList<observer>();
            this.premium = "premium";
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
                observer.update(this.cn,"premium");
            }
        }
        public void videoUploaded(){
            notifySubscriber();
        }
    }


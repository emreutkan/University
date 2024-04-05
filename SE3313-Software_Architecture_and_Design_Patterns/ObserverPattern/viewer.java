
public class viewer implements observer{

    private final String channelName;


    public viewer(String channelName){
        this.channelName = channelName;
    }
    @Override
    public void update(String name,String type) {
        if (type == "normal"){
            System.out.println("Wake up "+channelName+"!! " +name+" Uploaded a new video");
        }
        else if (type == "premium"){
            System.out.println("Wake up "+channelName+"!! " +name+" Uploaded a new video with ads free");

        }
    }
}

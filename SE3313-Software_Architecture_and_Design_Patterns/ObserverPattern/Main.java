// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        channel abc = new channel("veritasium");
        premiumchannel adc = new premiumchannel("Minute Physics");
        viewer elena = new viewer("Elena");
        viewer derek = new viewer("Derek");
        viewer gale = new viewer("Gale");
        viewer lane = new viewer("Lane");


        abc.registerSubscriber(elena);
        abc.registerSubscriber(derek);

        adc.registerSubscriber(gale);
        adc.registerSubscriber(lane);

        abc.videoUploaded();
        adc.videoUploaded();

    }
}
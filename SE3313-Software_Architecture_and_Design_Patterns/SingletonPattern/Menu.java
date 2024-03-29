import java.util.Scanner;

public class Menu {

    MusicPlayer player;
    public Menu(){
    }

    public void Start(){
        MusicPlayer player = MusicPlayer.getInstance();
        boolean loop = true;
        while (loop){
            Scanner scanner = new Scanner(System.in);
            int selection;
            System.out.println();
            System.out.println();
            System.out.println("===== Music Player Menu =====");
            System.out.println("1. Play MP3");
            System.out.println("2. Play FLAC");
            System.out.println("3. Play AAC");
            System.out.println("4. Add to Playlist");
            System.out.println("5. Remove from Playlist");
            System.out.println("6. Show Playlist");
            System.out.println("7. Authenticate User");
            System.out.println("8. Log Event");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            try {
                selection = Integer.parseInt(scanner.nextLine());

                switch (selection) {
                    case 1:
                        player.playMP3();
                        break;
                    case 2:
                        player.playFLAC();
                        break;
                    case 3:
                        player.playAAC();
                        break;
                    case 4:
                        player.addToPlaylist();
                        break;
                    case 5:
                        player.removeFromPlaylist();
                        break;
                    case 6:
                        player.showPlaylist();
                        break;
                    case 7:
                        player.authenticateUser();
                        break;
                    case 8:
                        player.logEvent();
                        break;
                    case 0:
                        System.out.println("Exiting the music player...");
                        loop = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

    }

}

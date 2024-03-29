public class MusicPlayer {
    private static MusicPlayer instance = null;

    private MusicPlayer() {
        // private constructor
    }

    public static MusicPlayer getInstance() {
        if (instance == null) {
            instance = new MusicPlayer();
        }
        return instance;
    }

    public void playMP3() {
        System.out.println("Playing MP3");
    }

    public void playFLAC() {
        System.out.println("Playing FLAC");
    }

    public void playAAC() {
        System.out.println("Playing AAC");
    }
    public void addToPlaylist() {
        System.out.println("Song added to Playlist");
    }

    public void removeFromPlaylist() {
        System.out.println("Song removed from Playlist");
    }

    public void showPlaylist() {
        System.out.println("Song 1");
        System.out.println("Song 2");
        System.out.println("Song 3");
        System.out.println("Song 4");
        System.out.println("Song 5");

    }

    public void authenticateUser() {
        System.out.println("User Authenticated");
    }

    public void logEvent() {
        System.out.println("Even logged");
    }

}

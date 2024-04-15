import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        int portnumber = 12345;

        if (args.length >= 1) {
            portnumber = Integer.parseInt(args[0]);
        }

        try {
            server = new ServerSocket(portnumber);
            System.out.println("ServerSocket is created " + server);

            while (true) {
                Socket client = server.accept();

                try {
                    InputStream clientIn = client.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));

                    OutputStream clientOut = client.getOutputStream();
                    PrintWriter pw = new PrintWriter(clientOut, true);

                    String msgFromClient;

                    while ((msgFromClient = br.readLine()) != null) {
                        if (msgFromClient.equalsIgnoreCase("bye")) {
                            break;
                        }

                        // Calculate the key based on the number of spaces
                        int spaceCount = (int) msgFromClient.chars().filter(ch -> ch == ' ').count();
                        int key;
                        if (spaceCount == 0) {
                            key = 5; //def
                        } else {
                            key = spaceCount * 3; // Key based on space count
                        }

                        String decryptedMessage = decrypt(msgFromClient, key);

                        System.out.println("Encrypted String is: " + msgFromClient);
                        System.out.println("Decrypted String is: " + decryptedMessage);

                        pw.println(decryptedMessage);
                    }
                } finally {
                    client.close();
                }
            }
        } catch (IOException ie) {
            System.out.println("Cannot open socket." + ie);
        } finally {
            try {
                if (server != null) {
                    server.close();
                }
            } catch (IOException ie) {
                System.out.println("Error closing server: " + ie);
            }
        }
    }


    public static String decrypt(String str, int key) {
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            if (c == ' ') {
                decrypted.append(' ');
                continue;
            }
            if (Character.isUpperCase(c)) {
                c = c - (key % 26);
                if (c < 'A') {
                    c = c + 26;
                }
            } else if (Character.isLowerCase(c)) {
                c = c - (key % 26);
                if (c < 'a') {
                    c = c + 26;
                }
            }
            decrypted.append((char) c);
        }
        return decrypted.toString();
    }
}

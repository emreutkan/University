import java.io.*;
import java.net.*;

public class Client {
    public static void main(String args[]) {
        Socket client = null;
        int portnumber = 12345;

        if (args.length >= 1) {
            portnumber = Integer.parseInt(args[0]);
        }

        try {
            client = new Socket(InetAddress.getLocalHost(), portnumber);
            System.out.println("Client socket is created " + client);

            OutputStream clientOut = client.getOutputStream();
            PrintWriter pw = new PrintWriter(clientOut, true);

            InputStream clientIn = client.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a message to encrypt and send. Type Bye to exit.");

            String msg;

            while (!(msg = stdIn.readLine().trim()).equalsIgnoreCase("Bye")) {
                int spaceCount = (int) msg.chars().filter(ch -> ch == ' ').count();
                int key;
                if (spaceCount == 0) {
                    key = 5; //def
                } else {
                    key = spaceCount * 3; // Key based on space count
                }
                msg = encrypt(msg,key);
                pw.println(msg);
                String decryptedMsg = br.readLine();
                System.out.println("Decrypted message from server: " + decryptedMsg);
            }

            pw.println("Bye");
            client.close();
        } catch (IOException ie) {
            System.out.println("I/O error: " + ie);
        }
    }
    public static String encrypt(String str, int key) {

        String encrypted = "";
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                c = c + (key % 26);
                if (c > 'Z') {
                    c = c - 26;
                }
            } else if (Character.isLowerCase(c)) {
                c = c + (key % 26);
                if (c > 'z') {
                    c = c - 26;
                }
            }
            encrypted += (char) c;
        }
        return encrypted;
    }

}

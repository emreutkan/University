import java.net.*;
import java.io.*;

public class NetworkingServer {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket client;
        int portnumber = 1234;
        if (args.length >= 1) {
            portnumber = Integer.parseInt(args[0]);
        }

        try {
            server = new ServerSocket(portnumber);
            System.out.println("ServerSocket is created " + server);

            while (true) {
                System.out.println("Waiting for connect request...");
                client = server.accept();
                System.out.println("Connect request is accepted...");

                // Read data from the client
                InputStream clientIn = client.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));

                // Expecting operation and two numbers
                String msgFromClient = br.readLine();
                System.out.println("Message received from client = " + msgFromClient);

                if (msgFromClient != null && !msgFromClient.equalsIgnoreCase("bye")) {
                    String[] parts = msgFromClient.split(" ");
                    if (parts.length == 3) {
                        String operation = parts[0];
                        try {
                            int num1 = Integer.parseInt(parts[1]);
                            int num2 = Integer.parseInt(parts[2]);
                            int result = 0;
                            boolean isValidOperation = true;

                            switch (operation.toLowerCase()) {
                                case "+":
                                    result = num1 + num2;
                                    break;
                                case "-":
                                    result = num1 - num2;
                                    break;
                                case "*":
                                    result = num1 * num2;
                                    break;
                                case "/":
                                    if (num2 != 0) {
                                        result = num1 / num2;
                                    } else {
                                        isValidOperation = false;
                                        System.out.println("Division by zero is not allowed.");
                                    }
                                    break;
                                default:
                                    isValidOperation = false;
                                    System.out.println("Invalid operation: " + operation);
                            }

                            if (isValidOperation) {
                                // Send response to the client
                                OutputStream clientOut = client.getOutputStream();
                                PrintWriter pw = new PrintWriter(clientOut, true);
                                pw.println("Result: " + result);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input format. Please send an operation followed by two integers.");
                        }
                    } else {
                        System.out.println("Expected an operation and two numbers, but received: " + msgFromClient);
                    }
                }

                // Close sockets if "bye" is received
                if (msgFromClient != null && msgFromClient.equalsIgnoreCase("bye")) {
                    client.close();
                    break;
                }
            }
        } catch (IOException ie) {
            System.out.println("Cannot open socket." + ie);
            System.exit(1);
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
}

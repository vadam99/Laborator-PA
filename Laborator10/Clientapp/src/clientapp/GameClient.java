/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author vadam
 */
public class GameClient {

    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; //local
        int PORT = 5030;
        Scanner myObj = new Scanner(System.in);
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out
                = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()))) {
            while (true) {
                // Send a request to the server
                String request = new String();
                System.out.print("Enter command: ");
                request = myObj.nextLine();
                if (request.equals("exit")) {
                    System.exit(0);
                } else if (request.equals("stop")) {
                    out.println(request);
                    String response = in.readLine();
                    System.out.println(response);
                    System.exit(0);
                } else {
                    out.println(request);
                }
                // Wait the response from the server
                String response = in.readLine();
                System.out.println(response);
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author vadam
 */
class ClientThread extends Thread {

    private Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            while (true) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String raspuns = new String();
                if (request.equals("stop")) {
                    raspuns = "Server stopped";
                    out.println(raspuns);
                    out.flush();
                    System.exit(0);
                } else {
                    raspuns = "Server received the request " + request + ".";
                    out.println(raspuns);
                    out.flush();
                }
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}

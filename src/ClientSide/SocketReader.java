/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClientSide;

import ClientSide.Client;
import java.io.*;
//import java.net.*;
//import java.awt.*;
//import java.awt.event.*;
/**
 *
 * @author THANH LONG
 */
class SocketReader implements Runnable {

    /** object we used to read from the server */
    BufferedReader in;

    /** Reference to the local client, so that we can pass the updated states
     * to the clients
     */
    Client client;

    /**
     * This constructor simply initializes its members.
     */
    SocketReader(Client client, BufferedReader in)
    {
        this.in = in;
        this.client = client;
    }

    /** repeatedly read the states and call the client to update the states */
    public void run()
    {
        try
        {
            while (true)
            {
                //long timestamp = Long.parseLong(in.readLine());
                String header = in.readLine();
                String content = in.readLine();

                if (header.equals("Chat")) {
                    client.chat(content);
                }
                if (header.equals("Stop")) {
                    //do something
                }
                if (header.equals("Buy")) {
                    //int op = Integer.parseInt(in.readLine());
                    //int paddleX = Integer.parseInt(in.readLine());
                    //client.updatePaddle(timestamp, op, paddleX);
                    //do something
                }

                if (header.equals("Bid")) {
                    //Ball ball = new Ball();
                    //ball.x = Double.parseDouble(in.readLine());
                    //ball.y = Double.parseDouble(in.readLine());
                    //ball.vx = Integer.parseInt(in.readLine());
                    //ball.vy = Integer.parseInt(in.readLine());
                    //ball.moving = Boolean.parseBoolean(in.readLine());

                    //client.updateBall(timestamp, ball);
                    //do sothing
                }

                
            }
        }
        catch (NumberFormatException e)
        {
            System.err.println("Connection closed. Good bye.");
            System.exit(1);
        }
        catch (IOException e)
        {
            System.err.println("Unable to read from server. Good bye.");
            System.exit(8);
        }
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClientSide;

/**
 *
 * @author THANH LONG
 */
import Utility.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;



/**
 * Implements a thread that reads state updates form the server
 * and updates the local states.
 */


/** The main class for the client */
public class Client implements Runnable {
    
    // Game state
    /* Store the id of client */
    int clientID = -1;
    /* Using to connect to network */
    PrintWriter out;
    BufferedReader in;

    public Client() {
    }

    public Client(int id) {
        clientID = id;
    }

    /**
     * Connects to the server and reader/writer to the socket
     */
    public void initNetwork()
    {
        try
        {
            Socket s = new Socket(Simulation.SERVER_NAME, Simulation.PORT);
            out = new PrintWriter(s.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            SocketReader sr = new SocketReader(this, in);
            System.out.println("Successfully connect to server");
            new Thread(sr).start();
        }
        catch (Exception e)
        {
            System.err.println(e);
            System.exit(9);
        }
    }

    /**
     * Initializes the GUI
     */
    public void initGUI()
    {
        
    }    

    /** If user clicks send a message, send it to server
     */
    public void chat(String content)
    {
        
        if (clientID != -1 )
        {
            out.println(content);
            System.out.println("Client send message" + content);
        }
         
    }//end of chat

  
    /**
     * The main loop.  The client repeatedly draws the ball/paddles at
     * its updated position at FRAME_RATE frames per seconds.
     */
    public void run()
    {
        
        while (true)
        {
            //do something
           
            try
            {
                Thread.sleep(1000/Simulation.FRAME_RATE);
            }
            catch (InterruptedException e)
            {
                System.err.println("Interrupted!  Good bye.");
                System.exit(10);
            }
        }
    }

    

      

    /** Initializes the game and starts the threads running.  The real
     * main() of client.
     */
    public void play()
    {
        // initialize objects in game
        //initGUI();
        initNetwork();
        new Thread(this).start();
    }

    public static void main(String[] args)
    {
    	System.out.println("Client running...");

        Client client = new Client();
        client.play();
    }
}

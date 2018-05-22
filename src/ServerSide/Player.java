/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ServerSide;
import Utility.*;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 * A Player object is a thread that encapsulates the states of a client and
 * the communication channel to/from the client.
 */
class Player implements Runnable {
    /** The ID of this player */
    int playerID;

    /** the PongServer object used to signal a restart of game.  */
    Server server;

    /** a list of event objects used to delay execution of events. */
    LinkedList<Event> eventList;

    /** the input channel (from the client associated to this player) */
    BufferedReader in;

    /** the ouput channel (to the client associated to this player) */
    PrintWriter out;

    Player(int id, Server server, Socket s)
    {
        this.server = server;
        eventList = new LinkedList<Event>();
        this.playerID = id;
        
        try
        {
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(s.getOutputStream(), true);
        }
        catch (IOException e)
        {
            System.err.println("cannot create reader or writer");
            System.exit(5);
        }

    }//constructor

    /** Called when the server wants to send the state to this player.
     * 
     */
    
    public void sendMessage(String header, String content)
    {
        System.out.println("Update " + ++server.countMsg);
        eventList.add(new Event("Message", content));
    }

    /* Implement method run in interface runable
     *
     */
    public void run()
    {
        while (true)
        {
            try
            {
                String cmd = in.readLine();
                // if cmd is null, probably one of the player has quit.
                // Stop the game and quit.
                if (cmd == null)
                {
                    System.err.println("Connection closed. Good bye.");
                    System.exit(4);
                }

                // cmd is "connect" -- the player want to connect with server
                if (cmd.compareTo("start") == 0)
                {
                    //do something with evenList
                }
                // cmd is "move" -- the player has moved his mouse to
                // move the paddle.  Add the event to be executed later.
                else if (cmd.compareTo("move") == 0)
                {
                    String x = in.readLine();
                    //do something with evenList
                }
                // cmd is "delay" -- the player has increased his network
                // delay.  We update the simulated network delay now.
                else if (cmd.compareTo("delay") == 0)
                {
                    //Do something with evenlist
                }
            }
            catch (IOException e)
            {
                System.err.println("cannot read from socket: " + e);
                System.exit(6);
            }
        }
    }//end of run

    /**
     * Processes the events in the event list that have expired.
     */
    public void processEvents()
    {
        synchronized(eventList) {
            if (eventList.isEmpty())
            {
                return;
            }
           //All even is stored in a list and is process sequenly
            Event e = eventList.peek();
            while (!eventList.isEmpty() && e != null )
            {
                if (e.header.compareTo("join") == 0)
                {
                    // tells the server to restart the game and start moving
                    // the ball again (if the ball has stopped).
                    //server.connectClient();
                }
                else if (e.header.compareTo("move") == 0)
                {
                    // tells the paddle to move to new position.
                    //synchronized(paddle) {
                    //    paddle.move(e.x);
                    //}
                    //do something
                }
                else if (e.header.compareTo("send") == 0)
                {
                    // send updated states to the clients.
                    //out.println(e.states);
                }
                eventList.removeFirst();
                if (!eventList.isEmpty())
                {
                    e = eventList.peek();
                }
            }

        }
    }//end of processEvent
}//end of Player
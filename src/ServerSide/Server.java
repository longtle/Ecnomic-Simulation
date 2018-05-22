/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ServerSide;
import java.io.*;
import java.net.*;
import Utility.*;
/**
 *
 * @author THANH LONG
 */
public class Server {
    ServerSocket socket;
    Player players[];
    SimulationState state;

    // Count no. of message sent
    int countMsg = 0;




    /** When server receive one message, it will broadcast to all client */
    private void broadcastMessage()
    {

    }

    public void play()
    {
        try
        {
            socket = new ServerSocket(Simulation.PORT);
        }
        catch (IOException e)
        {
            System.err.println("cannot listen to " + Simulation.PORT);
            System.exit(11);
        }

        try
        {
            // waits for connections from two players, then starts a
            // thread for each of them.
            Socket s;
            players = new Player[Simulation.NO_PLAYERS];
            state = new SimulationState();

            // update the state of GUI
            //state.paddles[0].setY(Paddle.HEIGHT);
            //state.paddles[1].setY(Pong.HEIGHT);
            //do something

            // Accept connections
            int noOfPlayers = Simulation.NOOFWORKER + Simulation.NOOFFIRM;
            for (int i = 0; i < noOfPlayers; i++) {
                s = socket.accept();
                players[i] = new Player(i, this, s);
            }

            // Start all the players
            for (int i = 0; i < noOfPlayers; i++) {
                new Thread(players[i]).start();

                // Update the game state to all the players
                //clients[i].updateAll();
            }

            Thread.sleep(1000);
            // enters the main loop, which repeatedly processes the
            // messages from the clients,

            while (true)
            {
                for (int i = 0; i < noOfPlayers; i++)
                    players[i].processEvents();

                Thread.sleep(1000/Simulation.FRAME_RATE);
            }
        }
        catch (IOException e)
        {
            System.err.println("cannot accept at port " + Simulation.PORT);
            System.exit(2);
        }
        catch (InterruptedException e)
        {
            System.exit(3);
        }
    }

    public static void main(String args[])
    {
    	System.out.println("Server listening...");
        Server s = new Server();
        s.play();
    }

    public void restartGame()
    {
        //Do something to notify all client
    }

    protected void finalize()
    {
        try
        {
            socket.close();
        }
        catch (IOException e)
        {
            System.err.println("cannot close socket");
            System.exit(7);
        }
    }
}

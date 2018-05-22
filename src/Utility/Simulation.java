/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Utility;

/**
 *
 * @author THANH LONG
 */
public class Simulation {
    /*
     * Declare number of worker and firm
     */

    public static final int NOOFWORKER = 2;
    public static final int NOOFFIRM = 2;
    /* Number of players. For now only support 2.  */
    public static final int NO_PLAYERS = 4;
    
    /** 
     * The name of the server
     */
    public static final String SERVER_NAME = "localhost";

    /** The server port that accepts connection.
     */
    public static final int PORT = 5000;

    /** The number of frames per second the clients refresh their screen.
     *  Also defines the number of times per second the server updates the
     *  clients' states.
     */
    public static final int FRAME_RATE = 25;

    /** Update frequency (in ms) */
    public static final int UPDATE_FREQUENCY = 500;

    /** Local Perception */
    public static final int PERCEPTION = 400;

    /** Dead-Reckoning threshold */
    public static final int THRESHOLD = 5;

    /** Server will delay for at least this amount
     * of time before deciding the win/lose state of the game.
     */
    public static final int BONUSDELAY = 10;

    

     /** The height of the gaming window.
     */
    public static final int HEIGHT = 500;

    /** The width of the gaming window.
     */
    public static final int WIDTH = 500;

    //Declare variable for WorkerStatus class
    public static final int DEFAULT_WORKER_BLACK_CARD = 3;

    //Declare variable for FirmStatus class
    public static final int DEFAULT_FIRM_RED_CARD = 16;



}

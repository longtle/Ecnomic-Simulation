/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ClientSide;
import Utility.*;

/**
 *
 * @author THANH LONG
 */
public class WorkerStatus {


    /* These instance variable should be declared as private
     * Just lazy
     */
    public int blackCard;
    public int rubberBand;
    public int redCard;

    public WorkerStatus () {
        blackCard = Simulation.DEFAULT_WORKER_BLACK_CARD;
        rubberBand = 0;
        redCard = 0;
    }

    public int getNoOfBlackCard () {
        return blackCard;
    }

    public int getNoOfRubberBand(){
        return rubberBand;
    }

    public int getNoOfRedCard(){
        return this.redCard;
    }

    public void setBlackCard(int bc) {
        this.blackCard = bc;
    }

    public void setRubberBand(int rb) {
        this.rubberBand = rb;
    }

    public void setRedCard (int rc){
        this.redCard = rc;
    }

    public void sellBlackCard(int bc){
        //Do something to add redCard and reduce blackCard
    }

    public void buyRubberBand(int rb) {
        //Do something to add rubberBand and reduce redCard
    }

}//end of WorkerState

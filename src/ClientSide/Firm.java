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

/* This class is used to store the state of the firm
 */
class FirmStatus {
    /*Should declare as private
     */
    public int redCard;
    public int rubberBand;

    public FirmStatus (){
        this.redCard = Simulation.DEFAULT_FIRM_RED_CARD;
        this.rubberBand = 0;
    }

    public void buyBlackCard() {
        //do something to add rubberBand and reduce redCard
    }
    public void sellRubberBand (){
        //do something to add redCard and reduce blackCard
    }
}

/*
 * This class to store the firm: firmState, playerId
 */
public class Firm {
    int idFirm;
    FirmStatus statusFirm;

    protected Firm (int id, FirmStatus st) {
        this.idFirm = id;
        this.statusFirm = st;
    }

    public Firm (int id) {
        this.idFirm = id;
        this.statusFirm = new FirmStatus();
    }

}

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

/* This class is used to store the state of the worker
 */


/***************************************************************/
public class Worker {
    int idWorker;
    WorkerStatus statusWorker;

    public Worker(int id){
        this.idWorker = id;
        statusWorker = new WorkerStatus();
    }
}//End of worker

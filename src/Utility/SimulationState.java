/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Utility;

import ClientSide.Firm;
import ClientSide.Worker;

/**
 *
 * @author THANH LONG
 */

/** the Simulation state is used to control all worker and firm
 *
 */
public class SimulationState {
    public Worker worker[];
    public Firm firm [];

    public SimulationState (int noOfWorker, int noOfFirm){
        worker = new Worker[noOfWorker];
        firm = new Firm[noOfFirm];

        //Initialize the list of worker and firm
        for (int i = 0; i < noOfWorker; i ++) {
            worker[i] = new Worker(i);
        }
        for (int j = 0; j < noOfFirm; j ++) {
            firm[j]= new Firm(j);
        }
    }

    public SimulationState ( ){
        worker = new Worker[Simulation.NOOFWORKER];
        firm = new Firm[Simulation.NOOFFIRM];

        //Initialize the list of worker and firm
        for (int i = 0; i < Simulation.NOOFWORKER; i ++) {
            worker[i] = new Worker(i);
        }
        for (int j = 0; j < Simulation.NOOFFIRM; j ++) {
            firm[j]= new Firm(j);
        }
    }

}

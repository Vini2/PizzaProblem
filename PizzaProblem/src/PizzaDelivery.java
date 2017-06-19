

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vijini
 */
public class PizzaDelivery extends Thread{
    
    private StudyGroup studyGroup = new StudyGroup();

    public PizzaDelivery(StudyGroup sg) {
        this.studyGroup = sg;
    }
    
    @Override
    public void run(){
        while (true) {            
            try {
                studyGroup.checkOrder();
                sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}

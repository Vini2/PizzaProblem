
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vijini
 */
public class Student extends Thread{

    StudyGroup studyGroup = new StudyGroup();
    private Random r = new Random(); 
    
    public Student(StudyGroup sg) {
        this.studyGroup = sg;
    }
    
    @Override
    public void run(){
        while (true) {            
            try {
                studyGroup.beginStudying();
                sleep(r.nextInt(8000));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
    }
    
}

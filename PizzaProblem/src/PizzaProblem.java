/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vijini
 */
public class PizzaProblem {
    
    public static void main(String[] args) {
        StudyGroup studyGroup = new StudyGroup();
        int students = 6;
        
        for (int i = 0; i < students; i++) {
            new Student(studyGroup).start();
        }
        
        new PizzaDelivery(studyGroup).start();
    }
    
}

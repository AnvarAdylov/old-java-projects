/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clock_Package;

/**
 *
 * @author Anvar Adylov
 */
public class clockTest {
    public static void main(String []args) {
    Clock first = new Clock(10,0,0);
    System.out.println(first);
    first.setClock(1,2,59);
    System.out.println(first);
    for(int i = 0;i<50;i++) {
    first.tick();
    System.out.println(first);
    
    }
    first.resetToMidnight();
    System.out.println(first);
    }
}

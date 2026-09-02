/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practiceexercises;

/**
 *
 * @author Anvar Adylov
 */
import java.util.Scanner;
public class PracticeExercises {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int l, w, h, v, sa;
        Scanner in = new Scanner(System.in);
        System.out.println("Write length, width and height:");
        l = in.nextInt();
        w = in.nextInt();
        h = in.nextInt();
        v = l*w*h;
        sa = (l*w+l*h+h*w)*2;
        System.out.println("The volume of the box is:" + v + "\nThe surface area is:" + sa);
        
        int  r;
        double c, a;
        System.out.println("Type in radius of a circle:");
        r = in.nextInt();
        in.close();  
        c = 2*3.14*r;
        a = 3.14*r*r;
        System.out.println("The circumference of a circle:" + c + "\nThe area:" + a);
        
        System.out.println("   _____                             \n" +
                           "  /  _  \\   _______  _______ _______ \n" +
                           " /  /_\\  \\ /    \\  \\/ /\\__  \\\\_  __ \\\n" +
                           "/    |    \\   |  \\   /  / __ \\|  | \\/\n" +
                           "\\____|__  /___|  /\\_/  (____  /__|   \n" +
                           "        \\/     \\/           \\/       ");
    }
    
}

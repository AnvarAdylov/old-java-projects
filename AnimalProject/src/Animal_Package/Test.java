/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animal_Package;

/**
 *
 * @author Anvar Adylov
 */
public class Test {
    public static void feedMeat(Animal animal) {
        try {
            animal.feed("Meat");
        } catch(Exception ex) {
            System.out.println("I got an exception!");
            System.out.println(ex);
        }
    }
    public static void main(String[] args) {
        
        
        Animal tiger = new Tiger(15, true);
        Animal cow = new Cow(10, false);
        Animal monkey = new Monkey(50, true);
        monkey.seeGender();
        feedMeat(tiger);
        feedMeat(cow);
        feedMeat(monkey);
        cow.ageOneYear();
        System.out.println(tiger);
        System.out.println(cow);
        tiger.voice();
        monkey.seeHowLongLeft();
        for(int i = 0;i<9;i++) {
        cow.ageOneYear();
        }
        System.out.println(cow);
    } 
}

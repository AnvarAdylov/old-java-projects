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
public class Monkey extends AnimalImplementation {

    public Monkey(int lifespan, Boolean gender) {
        super(lifespan, gender);
    }
     @Override
    public String animalKind() {
        return "Monkey";
    } 

    @Override
    public boolean canEat(String food) {
        if (food.equals("Banana")) {
            return true;
        }
        return false;
    }

    @Override
    public void feed(String food) throws Exception {
        if (!this.canEat(food)) {
            throw new Exception("Monkeys cannot eat " + food);
        } 
        System.out.println("Nom nom nom!");
    }
    @Override
    public void voice() {
        System.out.println("Oooo oooooo!");
    }
}

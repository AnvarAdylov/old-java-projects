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
public class Tiger extends AnimalImplementation {

    public Tiger(int lifespan, Boolean gender) {
        super(lifespan, gender);
    }
            
    @Override
    public String animalKind() {
        return "Tiger";
    } 

    @Override
    public boolean canEat(String food) {
        if (food.equals("Meat")) {
            return true;
        }
        return false;
    }

    @Override
    public void feed(String food) throws Exception {
        if (!this.canEat(food)) {
            throw new Exception("Tigers cannot eat " + food);
        } 
        System.out.println("MUNCH, MUNCH!!!");
    }
    @Override
    public void voice() {
        System.out.println("ROAR!!!");
    }
}

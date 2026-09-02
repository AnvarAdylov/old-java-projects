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
public class AnimalImplementation implements Animal {
    private int age;
    private Boolean isMale;
    private Boolean isAlive;
    private int maxAge;
    
    public AnimalImplementation(int lifespan,Boolean gender) {
        age = 0;
        isAlive = true;
        maxAge = lifespan;
        isMale = gender;
    }
    
    @Override
    public int getAge() {
        return age;
    }
    @Override
    public void ageOneYear() {
        age++;
        if (age == maxAge || age > maxAge) {
            isAlive = false;
        }
    }
    @Override
    public String animalKind() {
        return "Animal";
    }
    
    @Override
    public void seeGender() {
    if (isMale) {
        System.out.println(animalKind() + " is a male.");
    } else {
        System.out.println(animalKind() + " is a female.");
    }
    }
    @Override
    public String toString() {
        if (isAlive) {
        return animalKind() +" which is " + getAge() + " years old.";
        } else {
            return animalKind() +" which died at the age of " + maxAge;
        }
    }

    @Override
    public void seeHowLongLeft() {
        int p = maxAge-age;
        System.out.println(animalKind() + " gonna die after " + p + " years.");
    }

    @Override
    public void voice() {
        System.out.println("MRGLGLGLGL");
    }
        
    
    @Override
    public boolean canEat(String food) {
        if (food.equals("Food")) {
        return true;
        } else {
        return false;    
        }
    }
    @Override
    public void feed(String food) throws Exception {
        if (!this.canEat(food)) {
            throw new Exception(animalKind() + " cannot eat " + food);
        } else if (!this.isAlive) {
            throw new Exception("Dead don't need to eat.");
        }
        System.out.println("Eating sound.");
    }
}

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
public interface Animal {
    
     /**Returns the kind of the animal.
     * 
     * @return the kind of animal
     */
    public String animalKind();  
     /**Returns age of the animal
     * 
     * @return age of animal
     */   
    public int getAge();
      /**Returns true if animal can eat the food
       * that was typed by user.
       * 
       * @param food 
       * @return can eat or not
       */
    public boolean canEat(String food);
    /**Feed the animal.
     * If animal can not eat this food, 
     * throws exception.
     * 
     * @param food
     * @throws Exception 
     */
    public void feed(String food) throws Exception; 
    /**Add one to the age of animal.
     * If age reaches maximum the animal will die.
     */
    public void ageOneYear(); 
    /**Returns gender of the animal.
     * @return gender of the animal
     */
    public void seeGender();
    /**Prints after how much years animal will eventually die.
     * 
     */
    public void seeHowLongLeft();
    /**To make appropriate sound of the animal
     * 
     */
    public void voice();
    
}

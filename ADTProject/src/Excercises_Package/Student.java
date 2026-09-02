/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excercises_Package;

/**
 *
 * @author Anvar Adylov
 */
public class Student {
    private String name;
    private int id;
    
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }
    
    public boolean equals(Object obj) { 
        if (obj instanceof Student) {
        Student sobj = (Student)obj;
        return id == sobj.getId() && name.equals(sobj.getName());
        }
        return false;
    }
    
    public String toString() {
        return "Name: " + getName() + "; id: " + getId();
    }
}

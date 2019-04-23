/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webinar.pkgfinal;

/**
 * ID, Название, Описание
 * @author Meidi
 */
public class Specialty {
    private final String name;
    private final String description;
    
    public Specialty(String name, String description) {
        this.name = name;
        this.description = description;
    }
 
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
   
}

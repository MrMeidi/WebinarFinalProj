/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webinar.pkgfinal;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Meidi
 */
public class Student {
    private final int id;
    private final String name;
    private final String specialty;
    private final float score;
    
    public Student(int id, String name, String specialty, float avgScore) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.score = avgScore;
    }
    
    public int getID() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getSpecialty() {
        return specialty;
    }
    
    public float getScore() {
        return score;
    }    
    
    public List<Student> toList() {
        List<Student> list = new ArrayList<>();
        list.add(this);
        return list;
    }
}

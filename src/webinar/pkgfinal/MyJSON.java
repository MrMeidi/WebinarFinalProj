/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webinar.pkgfinal;

import com.google.gson.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Meidi
 */
public class MyJSON {
    public static void exportToJSON(List<Student> studList, String path) {
        try (Writer wr = new FileWriter(path)) {          
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(studList, wr);
            System.out.println("JSON was successfully saved.");
        } catch (NullPointerException | IOException e) {
            System.out.println("Error saving JSON: " + e.toString());
        }
    }
    
    public static List<Student> importFromJSON(String path) {
        List<Student> studList = null;
        Gson gson = new Gson();
        try (Reader re = new FileReader(path)) {
            Student[] stud = gson.fromJson(re, Student[].class);
            studList = new ArrayList(Arrays.asList(stud));
            // Finish up list export + DB insertions
        } catch (NullPointerException | IOException e) {
            System.out.println("Error reading JSON: " + e.toString());
        }
        
        return studList;
    }
}

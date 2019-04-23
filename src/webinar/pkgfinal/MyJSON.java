/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webinar.pkgfinal;

import com.google.gson.*;
import java.util.List;

/**
 *
 * @author Meidi
 */
public class MyJSON {
    public static void exportToJSON(List<Student> studList) {
        String json = new Gson().toJson(studList);
    }
    
    public static void importFromJSON(String json) {
        
    }
}

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
            System.out.println("Файл JSON был успешно сохранён.");
        } catch (NullPointerException | IOException e) {
            System.out.println("Ошибка сохранения файла JSON: " + e.toString());
        }
    }
    
    public static List<Student> importFromJSON(String path) {
        List<Student> studList = new ArrayList<>();
        Gson gson = new Gson();
        try (Reader re = new FileReader(path)) {
            Student[] stud = gson.fromJson(re, Student[].class);
            // Дописать вывод списка + инсерты в БД
        } catch (NullPointerException | IOException e) {
            System.out.println("Ошибка чтения файла JSON: " + e.toString());
        }
        
        return studList;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webinar.pkgfinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ��������� ��� ������� �� �� � ������ (� List �������� ���������������� ����). 
 * ���������� �������� � ��. 
 * ������� ������ ��������� �� �������� �������������. 
 * ��������� ������� ���� ���������, ��������� �������������.
 * ������ ������ �������� �� JSON � ��. ������� ������ �������� �� �� � JSON.
 * @author Meidi
 */
public class WebinarFinal {

    /**
     * @param args the command line arguments
     */     
    public static void main(String[] args) {  
        // ��������� ���������� � ��
        SQLiteDB db = new SQLiteDB("wfinal");
        Scanner scanner = new Scanner(System.in);

        System.out.println("������� ����� �������... (/help ��� ������)");
        boolean isProcessing = true;
        
        while (isProcessing) {
            List<String> inList = splitWithQuotes(scanner.nextLine());
            
            if (!inList.isEmpty()) {
                switch (inList.get(0).toLowerCase()) {
                    case "/exportall":
                        
                        break;
                    case "/addstudent":
                        try {
                            Student stud = new Student(0, inList.get(1), inList.get(2), Float.parseFloat(inList.get(3)));
                            db.insertStudent(stud.getName(), stud.getSpecialty(), stud.getScore());                            
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("��� ���������� �������� ���������� ������� ��� ���������!");
                        }
                        break;
                    case "/addspecialty":
                        try {
                            Specialty spec = new Specialty(inList.get(1), inList.get(2));
                            db.insertSpecialty(spec.getName(), spec.getDescription());                           
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("��� ���������� ������������� ���������� ������� ��� ���������!");
                        }
                        break;                    
                    case "/getstudentsbyspec":
                        try {
                            List<Student> studList = db.selectStudentsBySpecialty(inList.get(1));
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("��� ������� ������ ���������� ������� �������������!");
                        } 
                        break;
                    case "/getavgscorebyspec":
                        try {
                            float avgScore = db.getAvgScoreBySpecialty(inList.get(1));
                            System.out.println("������� ���� ��������� �� ������������� " 
                                             + inList.get(1) + ": " + avgScore + ".");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("��� ������� ������ ���������� ������� �������������!");
                        } 
                        break;
                    case "/importfromjson":

                        break;
                    case "/exporttojson":

                        break;
                    case "/exit":
                        isProcessing = false;
                        break;    
                    case "/help":
                        System.out.println(Help.getText());
                        break;
                }
            } 
        }     

        db.close();
    }  
    
    // ���������� ������ �� ������� � ������ ������� ������� (" ")
    private static List<String> splitWithQuotes(String in) {
        List<String> inList = new ArrayList<>();
        Matcher match = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(in);
        
        while (match.find()) {
            inList.add(match.group(1).replace("\"", ""));
        }        
        
        return inList;
    }
}

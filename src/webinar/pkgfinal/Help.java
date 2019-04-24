/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webinar.pkgfinal;

/**
 * ����� � ����������� � ��������
 * @author Meidi
 */
public class Help {
    private static final String[] HELP = { "/addSpecialty [name] [description] - �������� ������������� � ��.",
                                           "/addStudent [name] [specialty] [avg_score] - �������� �������� � ��.",
                                           "/exit - ���������� ������ � �����������.",
                                           "/exportAll - ��������� ��� ������� �� ��.",
                                           "/exportToJson [filepath] - ������� ������ �������� �� �� � JSON.", 
                                           "/getAvgScoreBySpec [specialty] - ������� ������� ���� ��������� �� �������������.",
                                           "/getStudentsBySpec [specialty] - ������� ������ ��������� �� �������������.",
                                           "/help - ����� ���������� � ���� ��������.",
                                           "/importFromJson [filepath] - ������ ������ �������� �� JSON � ��." };    
      
    public static String getText() {
        String helpString = "";   
        for (int i = 0; i < HELP.length; i++) {
            helpString += HELP[i] + "\n";     
        }
        return helpString;
    }
}

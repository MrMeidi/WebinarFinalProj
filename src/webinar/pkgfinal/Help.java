/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webinar.pkgfinal;

/**
 * Класс с информацией о командах
 * @author Meidi
 */
public class Help {
    private static final String[] HELP = { "/addSpecialty [name] [description] - добавить специальность в БД.",
                                           "/addStudent [name] [specialty] [avg_score] - добавить студента в БД.",
                                           "/exit - завершение работы с приложением.",
                                           "/exportAll - выгрузить все объекты из БД.",
                                           "/exportToJson [filepath] - экспорт списка объектов из БД в JSON.", 
                                           "/getAvgScoreBySpec [specialty] - вывести средний балл студентов по специальности.",
                                           "/getStudentsBySpec [specialty] - вывести список студентов по специальности.",
                                           "/help - вывод информации о всех командах.",
                                           "/importFromJson [filepath] - импорт списка объектов из JSON в БД." };    
      
    public static String getText() {
        String helpString = "";   
        for (int i = 0; i < HELP.length; i++) {
            helpString += HELP[i] + "\n";     
        }
        return helpString;
    }
}

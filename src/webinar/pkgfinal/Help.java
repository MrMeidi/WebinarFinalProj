/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webinar.pkgfinal;

/**
 * Class with help info
 * @author Meidi
 */
public class Help {
    private static final String[] HELP = { "/addSpecialty [name] [description] - Insert a new specialty to the database.",
                                           "/addStudent [name] [specialty] [avg_score] - Insert a new student to the database.",
                                           "/exit - Quit the application.",
                                           "/exportAll - Export all data from the database to Object lists.",
                                           "/exportToJson [filepath] - Export the Student list to a JSON file.", 
                                           "/getAvgScoreBySpec [specialty] - Show the average score of all students with the specified specialty.",
                                           "/getStudentsBySpec [specialty] - Show a list of students with the specified specialty.",
                                           "/help - Show information about all available commands.",
                                           "/importFromJson [filepath] - import Student list from a JSON file to the database." };    
      
    public static String getText() {
        String helpString = "";   
        for (int i = 0; i < HELP.length; i++) {
            helpString += HELP[i] + "\n";     
        }
        return helpString;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webinar.pkgfinal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Meidi
 */
public class SQLiteDB {
    private static Connection conn;
    private static Statement stmt;
    
    public SQLiteDB(String dbname) {
        try {
           Class.forName("org.sqlite.JDBC");
           conn = DriverManager.getConnection("jdbc:sqlite:sqlite/" + dbname + ".db");
           stmt = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
           System.err.println( e.getClass().getName() + ": " + e.getMessage() );
           System.exit(0);
        }   
    }
     
    public void insertStudent(String name, String specialty, float avg_score) {
        int idSpec = 0;
        
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT id FROM specialty "
                                                       + "WHERE name = ?");     
            ps.setString(1, specialty);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idSpec = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println("Error when selecting data from Specialty table! " + e);
        }
        
        if (idSpec == 0) {
            System.out.println("Specified specialty does not exist! Student was ignored.");
        } else {
            try {
                PreparedStatement ps = conn.prepareStatement("INSERT INTO student "
                                                           + "(name, specialty_id, score) "
                                                           + "VALUES (?, ?, ?)");     
                 ps.setString(1, name);
                 ps.setInt(2, idSpec);
                 ps.setFloat(3, avg_score);
                 ps.executeUpdate();
                 System.out.println("New student was successfully added to the corresponding table."); 
            } catch (SQLException e) {
                System.out.println("Error when inserting data to Student table! " + e);
            }            
        }        
    }
    
    public void insertSpecialty(String name, String description) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO specialty "
                                                       + "(name, description) "
                                                       + "VALUES (?, ?)");     
             ps.setString(1, name);
             ps.setString(2, description);
             ps.executeUpdate();
             System.out.println("New specialty was successfully added to the corresponding table."); 
        } catch (SQLException e) {
            System.out.println("Error when inserting data to Specialty table! " + e);
        }            
    }
    
    public List<Student> selectAllStudents() {
        List<Student> studList = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT st.id AS studid, st.name AS studname, sp.name AS specname, st.score "
                                                       + "FROM student st "
                                                       + "INNER JOIN specialty sp ON st.specialty_id = sp.id");     
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student stud = new Student(rs.getInt("studid"), rs.getString("studname"), rs.getString("specname"), rs.getFloat("score"));
                studList.add(stud);
            }
        } catch (SQLException e) {
            System.out.println("Error when selecting data! " + e);
        }      
        
        return studList;        
    }
    
    public List<Specialty> selectAllSpecialties() {
        List<Specialty> specList = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT id, name, description FROM specialty");     
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Specialty spec = new Specialty(rs.getInt("id"), rs.getString("name"), rs.getString("description"));
                specList.add(spec);
            }
        } catch (SQLException e) {
            System.out.println("Error when selecting data from Specialty table! " + e);
        }      
        
        return specList;        
    }
    
    public List<Student> selectStudentsBySpecialty(String specialty) {
        List<Student> studList = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT st.id AS studid, st.name AS studname, sp.name AS specname, st.score "
                                                       + "FROM student st "
                                                       + "INNER JOIN specialty sp ON st.specialty_id = sp.id "
                                                       + "AND sp.name = ?");     
            ps.setString(1, specialty);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student stud = new Student(rs.getInt("studid"), rs.getString("studname"), rs.getString("specname"), rs.getFloat("score"));
                studList.add(stud);
            }
        } catch (SQLException e) {
            System.out.println("Error when selecting data! " + e);
        }      
        
        return studList;
    }

    public float getAvgScoreBySpecialty(String specialty) {
        float avgScore = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT AVG(score) AS avg_score "
                                                       + "FROM student st "
                                                       + "INNER JOIN specialty sp ON st.specialty_id = sp.id "
                                                       + "AND sp.name = ?");     
            ps.setString(1, specialty);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                avgScore = rs.getFloat("avg_score");
            }
        } catch (SQLException e) {
            System.out.println("Error when selecting data! " + e);
        }      
        
        return avgScore;
    }
    
    public void close() {
        try {
           stmt.close();
           conn.close();
        } catch ( SQLException e ) {
           System.out.println("Error when trying to close database connection! " + e);
           System.exit(0);
        }      
    }
}

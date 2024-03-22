/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hashtable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import hashtable.StudentMark;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author KieuVietPhuoc
 */
public class HashTable {

    //function create data to file txt
      public static Hashtable<String, StudentMark> readStudentMarks(String filePath) {
        Hashtable<String, StudentMark> hashtable = new Hashtable<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.trim().split("\\|");
               String student_id = fields[1].trim(); // Index 0 là dấu cách trước Student_ID
                double mark1 = Double.parseDouble(fields[2].trim());
                double mark2 = Double.parseDouble(fields[3].trim());
                double mark3 = Double.parseDouble(fields[4].trim());
                double mark4 = Double.parseDouble(fields[5].trim());
                double markAverage = Double.parseDouble(fields[6].trim()); // Index 7 là dấu cách sau Average


                StudentMark student = new StudentMark(student_id, mark1, mark2, mark3, mark4, markAverage);
                hashtable.put(student_id, student);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashtable;
    }
     public static void calculateFrequency(Hashtable<String, StudentMark> studentMarksMap) {
        HashMap<Double, Integer> frequencyMap = new HashMap<>();
        double minScore = Double.MAX_VALUE;
        double maxScore = Double.MIN_VALUE;
        int minFrequency = Integer.MAX_VALUE;
        int maxFrequency = Integer.MIN_VALUE;
        double minScoreFrequency = Double.MAX_VALUE;
        double maxScoreFrequency = Double.MIN_VALUE;

        // Duyệt qua từng sinh viên để tính tần suất
        for (StudentMark studentMark : studentMarksMap.values()) {
            // Tăng tần suất cho mark1
            double mark1 = studentMark.getMark1();
            frequencyMap.put(mark1, frequencyMap.getOrDefault(mark1, 0) + 1);

            // Tăng tần suất cho mark2
            double mark2 = studentMark.getMark2();
            frequencyMap.put(mark2, frequencyMap.getOrDefault(mark2, 0) + 1);

            // Tăng tần suất cho mark3
            double mark3 = studentMark.getMark3();
            frequencyMap.put(mark3, frequencyMap.getOrDefault(mark3, 0) + 1);

            // Tăng tần suất cho mark4
            double mark4 = studentMark.getMark4();
            frequencyMap.put(mark4, frequencyMap.getOrDefault(mark4, 0) + 1);

            // Tăng tần suất cho markAverage
            double markAverage = studentMark.getMarkAverage();
            frequencyMap.put(markAverage, frequencyMap.getOrDefault(markAverage, 0) + 1);
        }
        
        // In thông kê tần suất
        System.out.println("Thống kê tần suất từng điểm:");
        for (Map.Entry<Double, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("Điểm " + entry.getKey() + ": " + entry.getValue() + " lần");
            if(entry.getValue()<minFrequency){
                minFrequency=entry.getValue();
                minScoreFrequency=entry.getKey();
            }
            if(entry.getValue()>maxFrequency){
                maxFrequency=entry.getValue();
                maxScoreFrequency=entry.getKey();
            }
            
        }
        
        for (Map.Entry<Double, Integer> entry : frequencyMap.entrySet()) {
            if(entry.getKey()<minScore) minScore=entry.getKey(); 
        }
        System.out.println("Điểm thấp nhất là " + minScore );
        for (Map.Entry<Double, Integer> entry : frequencyMap.entrySet()) {
            if(entry.getKey()>maxScore) maxScore=entry.getKey(); 
        }
        System.out.println("Điểm cao nhất là " + maxScore );
        System.out.println("Điểm xuất hiện ít nhất " + minScoreFrequency + ": " + minFrequency + " lần");
        System.out.println("Điểm xuất hiện nhiều nhất " + maxScoreFrequency + ": " + maxFrequency + " lần");
    }
    public static void main(String[] args) {
         String filePath = "D:/Project PRJ/HashTable/data.txt";
        Hashtable<String, StudentMark> studentMarksMap = readStudentMarks(filePath);
        calculateFrequency(studentMarksMap);
        
    }
    
}

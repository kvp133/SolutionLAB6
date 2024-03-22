/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hashtable;

/**
 *
 * @author KieuVietPhuoc
 */
public class StudentMark {
    private String student_id;
    private double mark1;
    private double mark2;
    private double mark3;
    private double mark4;
    private double markAverage;

    public StudentMark() {
    }

    public StudentMark(String student_id, double mark1, double mark2, double mark3, double mark4, double markAverage) {
        this.student_id = student_id;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.mark4 = mark4;
        this.markAverage = markAverage;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public double getMark1() {
        return mark1;
    }

    public void setMark1(double mark1) {
        this.mark1 = mark1;
    }

    public double getMark2() {
        return mark2;
    }

    public void setMark2(double mark2) {
        this.mark2 = mark2;
    }

    public double getMark3() {
        return mark3;
    }

    public void setMark3(double mark3) {
        this.mark3 = mark3;
    }

    public double getMark4() {
        return mark4;
    }

    public void setMark4(double mark4) {
        this.mark4 = mark4;
    }

    public double getMarkAverage() {
        return markAverage;
    }

    public void setMarkAverage(double markAverage) {
        this.markAverage = markAverage;
    }
    
}

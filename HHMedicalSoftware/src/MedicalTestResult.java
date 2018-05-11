/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  File Name: MedicalTestResult
 *  Programmer: 
 *  Date: May 11, 2018
 *  Description:
 */

public class MedicalTestResult {

    private int day;
    private int month;
    private int year;
    private int score;

    public MedicalTestResult(int day, int month, int year, int score) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.score = score;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(day).append("/").append(month).append("/").append(year);
        return string.toString();
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  File Name: Date
 *  Programmer: 
 *  Date: May 12, 2018
 *  Description:
 */
public class Date {

    int day;
    int month;
    int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public Date(String date) {
        day = date.charAt(0) * 10 + date.charAt(1);
        day = date.charAt(3) * 10 + date.charAt(4);
        day = date.charAt(6) * 1000 + date.charAt(7) * 100 + date.charAt(8) * 10 + date.charAt(9);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(day).append("/").append(month).append("/").append(year);
        return string.toString();
    }
    
    
}

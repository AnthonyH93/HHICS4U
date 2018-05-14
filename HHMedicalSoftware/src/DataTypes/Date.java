package DataTypes;

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

    /* Define the properties of a date including day, month and year */
    int day;
    int month;
    int year;

    /* Define constructor to fill in properties */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    /* Define a different type of constructor that converts string into a date */
    public Date(String date) {
        day = date.charAt(0) * 10 + date.charAt(1);
        month = date.charAt(3) * 10 + date.charAt(4);
        year = date.charAt(6) * 10 + date.charAt(7);
    }

    /* Override string version to output a string with all the properties */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(day).append("/").append(month).append("/").append(year);
        return string.toString();
    }
    
    
}

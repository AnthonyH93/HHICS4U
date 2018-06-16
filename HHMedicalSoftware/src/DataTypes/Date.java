package DataTypes;

import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  File Name: Date
 *  Date: May 12, 2018
 *  Description: This class is defines the datatype for a date.
 */
public class Date {

    /* Define the properties of a date including day, month and year */
    int day;
    int month;
    int year;
    
    DecimalFormat dFormat = new DecimalFormat("00");

    /* Define constructor to fill in properties */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    /* Define a different type of constructor that converts string into a date */
    public Date(String date) {
        day = Character.getNumericValue(date.charAt(0)) * 10 + Character.getNumericValue(date.charAt(1));
        month = Character.getNumericValue(date.charAt(3)) * 10 + Character.getNumericValue(date.charAt(4));
        year = Character.getNumericValue(date.charAt(6)) * 10 + Character.getNumericValue(date.charAt(7));
    }

    /* Override string version to output a string with all the properties */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(dFormat.format(day)).append("/").append(dFormat.format(month)).append("/").append(dFormat.format(year));
        return string.toString();
    }
    
    /* Returns the date in a purely integer format for comparison purposes */
    public int toInt () {
        int comp = year * 10000 + month * 100 + day;
        return comp;
    }
    
}

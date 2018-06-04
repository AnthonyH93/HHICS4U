package DataTypes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  File Name: MedicalTestResult
 *  Date: May 11, 2018
 *  Description: This class is defines the datatype for a medical test result.
 */

public class MedicalTestResult {

    /* Create class for medical test results that contains the date and the score */
    private Date date;
    private int score;
    private Flag flag;

    /* Constructor that requires a date and score */
    public MedicalTestResult(Date date, int score) {
        this.date = date;
        this.score = score;
    }

    /* Define getter methods */
    public Date getDate () {
        return date;
    }

    public int getScore() {
        return score;
    }

    public Flag getFlag() {
        return flag;
    }
    
    public void setFlag(Flag flag) {
        this.flag = flag;
    }
    
    /* Override default toString method to instead output string in form "day/month/year" */
    @Override
    public String toString() {
        return date.toString();
    }
    
    public boolean compareDates (MedicalTestResult e) {
        int firstDate = date.toInt();
        int secondDate = (e.date.toInt());
        
        if (firstDate > secondDate) {
            return true;
        } else {
            return false;
        }
    }
    
}

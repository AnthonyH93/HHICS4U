package DataTypes;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  File Name: MedicalTestType
 *  Date: May 11, 2018
 *  Description: This class is defines the datatype for a medical test type.
 */

public class MedicalTestType {

    /* Define properties that a test type must have including
     * a name, description and an array to store the different tests
    */
    private String name;
    private String description;
    private ArrayList<MedicalTestResult> tests = new ArrayList<MedicalTestResult>();

    /* Define a constructor to give values to properties */
    public MedicalTestType(String name, String comment) {
        this.name = name;
        this.description = comment;
    }

    /* Return the name of the test type */
    public String getName() {
        return name;
    }
    
    /* Return the description of the test type */
    public String getDescription() {
        return description;
    }
    
    /* Define method to add a new test to the array */
    public void addTest (MedicalTestResult test) {
        tests.add(test);
    }
    
    /* Define method to return the tests */
    public ArrayList<MedicalTestResult> getTests () {
        return tests;
    }

    /* Return the name as the string version of a test type */
    @Override
    public String toString() {
        return name;
    }
    
    
}

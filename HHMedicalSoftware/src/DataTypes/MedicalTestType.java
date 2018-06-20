package DataTypes;


import java.util.ArrayList;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

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

public  class MedicalTestType {

    /* 
     * Define properties that a test type must have including
     * a name, description and an array to store the different tests
    */
    
    private final SimpleStringProperty name;
    private final SimpleDoubleProperty greenMinimumScore;
    private final SimpleDoubleProperty greenMaximumScore;
    private final SimpleDoubleProperty yellowMinimumScore;
    private final SimpleDoubleProperty yellowMaximumScore;
    
    private ArrayList<MedicalTestResult> tests = new ArrayList<MedicalTestResult>();

    /* Define a constructor to give values to properties except test array */
    public MedicalTestType(String name, double greenMinimumScore, double greenMaximumScore, double yellowMinimumScore, double yellowMaximumScore) {
        this.name = new SimpleStringProperty(name);
        this.greenMinimumScore = new SimpleDoubleProperty(greenMinimumScore);
        this.greenMaximumScore = new SimpleDoubleProperty(greenMaximumScore);
        this.yellowMinimumScore = new SimpleDoubleProperty(yellowMinimumScore);
        this.yellowMaximumScore = new SimpleDoubleProperty(yellowMaximumScore);
    }
    
    /* Define a constructor that also allows for the direct creation of the array list of tests */
    public MedicalTestType(String name, double greenMinimumScore, double greenMaximumScore, double yellowMinimumScore, double yellowMaximumScore, ArrayList<MedicalTestResult> tests) {
        this.name = new SimpleStringProperty(name);
        this.greenMinimumScore = new SimpleDoubleProperty(greenMinimumScore);
        this.greenMaximumScore = new SimpleDoubleProperty(greenMaximumScore);
        this.yellowMinimumScore = new SimpleDoubleProperty(yellowMinimumScore);
        this.yellowMaximumScore = new SimpleDoubleProperty(yellowMaximumScore);
        this.tests = tests;
    }

    /* Define setter methods */
    public void setName (String n) {
        name.set(n);
    }
    
    public void setGreenMinimumScore (double g) {
        greenMinimumScore.set(g);
    }
    
    public void setGreenMaximumScore (double g) {
        greenMaximumScore.set(g);
    }
    
    public void setYellowMinimumScore (double g) {
        yellowMinimumScore.set(g);
    }
    
    public void setYellowMaximumScore (double g) {
        yellowMaximumScore.set(g);
    }
    
    public void setTests (ArrayList<MedicalTestResult> t) {
        tests.clear();
        tests.addAll(t);
    }
    
    /* Return the name of the test type */
    public String getName() {
        return name.getValue();
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
        return name.getValue();
    }

    /* Define getter methods */
    public double getGreenMinimumScore() {
        return greenMinimumScore.get();
    }

    public double getGreenMaximumScore() {
        return greenMaximumScore.get();
    }

    public double getYellowMinimumScore() {
        return yellowMinimumScore.get();
    }

    public double getYellowMaximumScore() {
        return yellowMaximumScore.get();
    }
    
    /* Define method that will sort the tests in the array using a selection sort algorithm */
    public void sortTests () {
        for (int i = 0; i < tests.size() - 1; i++) {
                for (int j = i + 1; j < tests.size(); j++) {
                    if (tests.get(i).compareDates(tests.get(j))) {
                        MedicalTestResult temp = tests.get(i);
                        tests.set(i, tests.get(j));
                        tests.set(j, temp);
                    }
                }
            }
    }
}

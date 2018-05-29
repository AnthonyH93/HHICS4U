package DataTypes;


import java.util.ArrayList;
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

    /* Define properties that a test type must have including
     * a name, description and an array to store the different tests
    */
    private final SimpleStringProperty name;
    private final SimpleStringProperty description;
    private final SimpleIntegerProperty greenMinimumScore;
    private final SimpleIntegerProperty greenMaximumScore;
    private final SimpleIntegerProperty yellowMinimumScore;
    private final SimpleIntegerProperty yellowMaximumScore;
    
    private ArrayList<MedicalTestResult> tests = new ArrayList<MedicalTestResult>();

    /* Define a constructor to give values to properties */
    public MedicalTestType(String name, String description, int greenMinimumScore, int greenMaximumScore, int yellowMinimumScore, int yellowMaximumScore) {
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        this.greenMinimumScore = new SimpleIntegerProperty(greenMinimumScore);
        this.greenMaximumScore = new SimpleIntegerProperty(greenMaximumScore);
        this.yellowMinimumScore = new SimpleIntegerProperty(yellowMinimumScore);
        this.yellowMaximumScore = new SimpleIntegerProperty(yellowMaximumScore);
    }
    
    public MedicalTestType(String name, String description, int greenMinimumScore, int greenMaximumScore, int yellowMinimumScore, int yellowMaximumScore, ArrayList<MedicalTestResult> tests) {
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        this.greenMinimumScore = new SimpleIntegerProperty(greenMinimumScore);
        this.greenMaximumScore = new SimpleIntegerProperty(greenMaximumScore);
        this.yellowMinimumScore = new SimpleIntegerProperty(yellowMinimumScore);
        this.yellowMaximumScore = new SimpleIntegerProperty(yellowMaximumScore);
        this.tests = tests;
    }

    public void setName (String n) {
        name.set(n);
    }
    
    public void setGreenMinimumScore (int g) {
        greenMinimumScore.set(g);
    }
    
    public void setGreenMaximumScore (int g) {
        greenMinimumScore.set(g);
    }
    
    public void setYellowMinimumScore (int g) {
        greenMinimumScore.set(g);
    }
    
    public void setYellowMaximumScore (int g) {
        greenMinimumScore.set(g);
    }
    
    public void setTests (ArrayList<MedicalTestResult> t) {
        tests.clear();
        tests.addAll(t);
    }
    
    /* Return the name of the test type */
    public String getName() {
        return name.getValue();
    }
    
    /* Return the description of the test type */
    public String getDescription() {
        return description.getValue();
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

    public int getGreenMinimumScore() {
        return greenMinimumScore.get();
    }

    public int getGreenMaximumScore() {
        return greenMaximumScore.get();
    }

    public int getYellowMinimumScore() {
        return yellowMinimumScore.get();
    }

    public int getYellowMaximumScore() {
        return yellowMaximumScore.get();
    }
    
    
}

package DataTypes;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  File Name: MedicalTestType
 *  Programmer: 
 *  Date: May 11, 2018
 *  Description:
 */

public class MedicalTestType {

    private String name;
    private String comment;
    private ArrayList<MedicalTestResult> tests = new ArrayList<MedicalTestResult>();

    public MedicalTestType(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }
    
    public void addTest (MedicalTestResult test) {
        tests.add(test);
    }
    
    public ArrayList<MedicalTestResult> getTests () {
        return tests;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}

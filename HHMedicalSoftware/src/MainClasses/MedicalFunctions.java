package MainClasses;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  File Name: MedicalFunctions
 *  Date: May 11, 2018
 *  Description: This class holds all of the functions pertaining to user
 *  input functions.
 */

public class MedicalFunctions {
    
    /* Create a new MedicalTestTypeManagerScreen */
    public static void openMedicalTestTypeManager() {
        try {
            MedicalTestTypeManagerScreen screen = new MedicalTestTypeManagerScreen();
        } catch (IOException ex) {
            Logger.getLogger(MedicalFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /* Create a new InputMedicalTestResultScreen */
    public static void addMedicalTestResult() {
        try {
            InputMedicalTestResultScreen screen = new InputMedicalTestResultScreen();
        } catch (IOException ex) {
            Logger.getLogger(MedicalFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /* Create a new WarningAndSuggestionsScreen */
    public static void openWarningsScreen() {
        try {
            WarningsAndSuggestionsScreen screen = new WarningsAndSuggestionsScreen();
        } catch (IOException ex) {
            Logger.getLogger(MedicalFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /* Create a new MedicalDefinitionsScreen */
    public static void openDefinitionsScreen() {
        try {
           MedicalDefinitionsScreen screen = new MedicalDefinitionsScreen();
        } catch (IOException ex) {
            Logger.getLogger(MedicalFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}

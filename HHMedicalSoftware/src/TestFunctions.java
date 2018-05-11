
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  File Name: TestFunctions
 *  Programmer: 
 *  Date: May 11, 2018
 *  Description:
 */
public class TestFunctions {

    public static void addMedicalTestType () {
        try {
            InputMedicalTestDataScreen screen = new InputMedicalTestDataScreen();
        } catch (IOException ex) {
            Logger.getLogger(TestFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

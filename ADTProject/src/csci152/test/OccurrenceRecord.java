/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.test;

import java.io.File;

/**
 *
 * @author Anvar Adylov
 */
public class OccurrenceRecord {
    private File filename;
    private int line;
    private int col;
    
    public OccurrenceRecord(File file, int l, int c) {
        filename = file;
        line = l;
        col = c;
    }        
    
    public String toString() {
        String res = ""; 
        res = "{File: " + filename.getName() + " Line: " + line + " Column: " + col + "}";
        return res;
    }
}

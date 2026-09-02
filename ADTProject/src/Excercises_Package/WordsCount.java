/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excercises_Package;

import csci152.adt.Map;
import csci152.impl.LLQueueMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Anvar Adylov
 */
public class WordsCount {
    public static Map<String, Integer> wordCount(File infile) throws IOException {
        Map<String, Integer> wordcount = new LLQueueMap(); 
    BufferedReader reader =
				new BufferedReader(new FileReader(infile));
		
		int ch, o;
		String token = "";
		do {
			ch = reader.read();
			if (ch == '?' || ch == '!' || ch == ',' || ch == '.' || ch == ' ' || ch == '\n' || ch == '\r'
					|| ch == '\t' || ch == -1) {
				
				if (token.length() > 0) {
                                        if (wordcount.getValue(token) == null) {
                                            wordcount.define(token, 1);
                                        } else {
                                            o = wordcount.getValue(token);
                                            wordcount.define(token, o++);
                                        }
					token = "";
                                       
				} 
				
			} else {
                            token = token + (char)ch;
			}		
		} while (ch != -1);
                return wordcount;
    }
    public static void main(String[] args) {
        
    }
}

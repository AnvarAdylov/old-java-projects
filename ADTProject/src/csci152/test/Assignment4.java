/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.test;

import csci152.adt.HashTableMap;
import csci152.impl.LLQHashTableMap;
import csci152.adt.Map;
import csci152.adt.Queue;
import csci152.adt.Set;
import csci152.adt.SortedQueue;
import csci152.impl.LLQueueSet;
import csci152.impl.LinkedListQueue;
import csci152.impl.LinkedListSortedQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Anvar Adylov
 */
public class Assignment4 {
public static int tokenizeAllFiles(File dirSource, SortedQueue<String> allTokens, Map<String, Queue<OccurrenceRecord>> wordsData, int wordsNum) throws IOException {
        File[] contents =  dirSource.listFiles();
        for (File file : contents) {
            if (file.isDirectory()) {
                wordsNum = wordsNum + tokenizeAllFiles(file, allTokens, wordsData, wordsNum);
            } else {
                wordsNum = wordsNum + tokenize(file, allTokens, wordsData, wordsNum);
            }
        }
        return wordsNum;
    }
public static boolean isSeparator(int x) {
    if (x > 64 && x  < 123) {
        if (x > 96 || x  < 91) {
            return false;
        }
    }
    return true;
}
public static int tokenize(File infile, SortedQueue<String> allTokens, Map<String, Queue<OccurrenceRecord>> wordsData, int wordsNum) throws IOException {
    BufferedReader reader =
				new BufferedReader(new FileReader(infile));
		int ch;
                int line = 1,cCol = 0,sCol = 0;
		String token = "";
		do {
			ch = reader.read();
			if (ch == '\n') {
                            line++;
                            cCol = 0;
                        } else {
                            cCol++;
                        }
			if (isSeparator(ch) || ch == -1) {
				if (token.length() > 0) {
                                    String lcToken = token.toLowerCase();
                                        if (wordsData.getValue(lcToken) == null) {
                                            allTokens.insert(lcToken);
                                            Queue<OccurrenceRecord> occ = new LinkedListQueue();
                                            occ.enqueue(new OccurrenceRecord(infile, line, sCol));
                                            wordsData.define(lcToken, occ);
                                        } else {
                                            wordsData.getValue(lcToken).enqueue(new OccurrenceRecord(infile, line, sCol));
                                        }
					token = "";
                                        wordsNum++;
        			} 
			} else {
                            if (token.equals("")) {
                                sCol = cCol;
                            } 
				token = token + (char)ch;
			}	
		} while (ch != -1);
                reader.close();
                return wordsNum;
}
public static void printTokens(SortedQueue<String> List) {
    int sz = List.getSize();
    SortedQueue<String> Temp = new LinkedListSortedQueue();
    String token;
    try {
        for (int i = 0;i<sz;i++) {
            token = List.dequeue();
            Temp.insert(token);
        }  
        for (int i = 0;i<sz;i++) {
            token = Temp.dequeue();
            System.out.println(token);
            List.insert(token);
        }
    } catch (Exception ex) {
            System.out.println("I caught an exception!");
            System.out.println(ex);
    }
    
}
public static SortedQueue<String> readWords(File file) throws IOException {
    SortedQueue<String> words = new LinkedListSortedQueue();
    Set<String> list = new LLQueueSet();
    BufferedReader reader =
				new BufferedReader(new FileReader(file));
		int ch;
                String token = "";
		do {
			ch = reader.read();
			if (isSeparator(ch) || ch == -1) {
				if (token.length() > 0) {
                                    String lcToken = token.toLowerCase();
                                        list.add(lcToken);
                                    token = "";
        			} 
			} else {
				token = token + (char)ch;
			}	
		} while (ch != -1);
                reader.close();
        int s = list.getSize();
        try {
        for (int i = 0;i<s;i++) {
            words.insert(list.removeAny());
        }
        } catch (Exception ex) {
            System.out.println("I caught an exception!");
            System.out.println(ex);
    }
    return words;
}	

public static void findOccurences(SortedQueue<String> words, Map<String, Queue<OccurrenceRecord>> wordsData, int wordsNum) {
    int size = words.getSize();
    SortedQueue<String> Temp = new LinkedListSortedQueue();
    String token;
    double uf;
    int x;
    try {
        for (int i = 0;i<size;i++) {
            token = words.dequeue();
            Temp.insert(token);
        }  
        for (int i = 0;i<size;i++) {
            token = Temp.dequeue();
            words.insert(token);
            System.out.println(token);
            if (wordsData.getValue(token) == null) {
            System.out.println("Not found");
            System.out.println("Usage frequency: 0%");
            } else {
            System.out.println(wordsData.getValue(token));
            x = wordsData.getValue(token).getSize();
            uf = (double)x/wordsNum;
            System.out.println("Usage frequency: " + uf*100 + "%");
            }
            
    }
    } catch (Exception ex) {
            System.out.println("I caught an exception!");
            System.out.println(ex);
    }
}

public static void main(String[] args) throws IOException {
        HashTableMap<String, Queue<OccurrenceRecord>> wordsData = new LLQHashTableMap<String, Queue<OccurrenceRecord>>(10); ;
        SortedQueue<String> allTokens = new LinkedListSortedQueue();
        int wordsNum = 0;
	File infile = new File("inputfiles");	
        File file = new File("getwordinfo.txt");
        wordsNum = wordsNum + tokenizeAllFiles(infile, allTokens, wordsData, wordsNum);
        printTokens(allTokens);
        System.out.println("Load factor: " + wordsData.getLoadFactor() + "\nStandard deviation: " + wordsData.getBucketSizeStandardDev());
        SortedQueue<String> wordsFromDoc;
        wordsFromDoc = readWords(file);
        System.out.println(wordsNum);
        findOccurences(wordsFromDoc, wordsData, wordsNum);
	}
}

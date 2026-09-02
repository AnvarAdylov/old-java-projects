/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Queue;
import java.io.File;

/**
 *
 * @author Anvar Adylov
 */
public class FileDir {
    public static Queue<File> getAllFiles(File rootDir) {
        Queue<File> files = new LinkedListQueue();
        Queue<File> temp = new LinkedListQueue();
        int t;
        File[] contents =  rootDir.listFiles();
        for (File file : contents) {
        if (file.isDirectory()) {
            temp = getAllFiles(file);
            t = temp.getSize();
            try {
            for (int i = 0; i<t;i++) {
                files.enqueue(temp.dequeue());
            }
            } catch (Exception ex) {
                System.out.println("I caught an exception!");
                System.out.println(ex);
            }
        } else if (file.isFile()) {
            files.enqueue(file);
        }
        }
        return files;
    }
    public static void createDoc(String docname, Queue<String> dirnames) {
        int s;
        try {
        File dir = new File(dirnames.dequeue());
        s = dirnames.getSize();
        for (int i = 0;i<s;i++) {
            dir = new File(dir, dirnames.dequeue());
        if (!dir.exists()) {
            dir.mkdir();
        }
        }
        File doc = new File(dir, docname);
        doc.createNewFile();
        } catch (Exception ex) {
                System.out.println("I caught an exception!");
                System.out.println(ex);
        }
    }
    public static void main(String[] args) {
        File myDir = new File("src");
        Queue<File> files = new LinkedListQueue();
        files = getAllFiles(myDir);
        if (myDir.exists()) {
            File[] contents =  myDir.listFiles();
            for (File file : contents) {
                System.out.println("Name:" + file.getName());
                System.out.println("Path:" + file.getPath()); 
            }
        }
        System.out.println(files);
        Queue<String> dirNames = new LinkedListQueue();
        dirNames.enqueue("src");
        dirNames.enqueue("Experiment");
        createDoc("Input.txt" ,dirNames);
    }
}

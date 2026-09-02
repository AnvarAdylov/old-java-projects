
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class IOTest {
    
public static void copyDocs(File docSource, File docTarget) throws IOException {
    BufferedReader reader =
				new BufferedReader(new FileReader(docSource));
    PrintWriter writer = 
            new PrintWriter(new FileOutputStream(docTarget));
    int ch;
    do {
	ch = reader.read();
        writer.print((char)ch);
        } while (ch != -1);
    writer.close();
    reader.close();                     
}
public static void cloneDirs(File dirSource, File dirTarget) throws IOException {
    File[] contents =  dirSource.listFiles();
    String dir;
        for (File file : contents) {
            if (file.isDirectory()) {
                dir = file.getName();
                File doc = new File(dirTarget, dir);
                cloneDirs(file, doc);
            } else {
                if (!dirTarget.exists()) {
                    dirTarget.mkdir();
                }
                File copy = new File(dirTarget, file.getName());
                copyDocs(file, copy);
            }
        }
}
public static void wordsInDocs(File dirSource, File wordsDoc) throws IOException {
    File[] contents =  dirSource.listFiles();
     for (File file : contents) {
            if (file.isFile()) {
                BufferedReader reader =
				new BufferedReader(new FileReader(file));
		PrintWriter writer = 
                        new PrintWriter(new FileOutputStream(wordsDoc, true));
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
			if (ch == ' ' || ch == '\n' || ch == '\r'
					|| ch == '\t' || ch == -1) {
				if (token.length() > 0) {
                                        
					writer.println("/nToken: " + token + " Docname:" + file.getName() + " Line:" + line + " Col:" + sCol);
					token = "";
                                       
				} 	
			} else {
                            if (token.equals("")) {
                                sCol = cCol;
                            } 
				token = token + (char)ch;
			}	
		} while (ch != -1);
                reader.close();
                writer.close();
            }
     }
}
public static void tokenize(File infile) throws IOException {
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
			if (ch == ' ' || ch == '\n' || ch == '\r'
					|| ch == '\t' || ch == -1) {
				
				if (token.length() > 0) {
                                        
					System.out.println("Token: " + token + " Line:" + line + " Col:" + sCol);
					token = "";
                                       
				} 
				
			} else {
                            if (token.equals("")) {
                                sCol = cCol;
                            } 
				token = token + (char)ch;
			}
			
		} while (ch != -1);
}
	public static void main(String[] args) throws IOException {
		File infile2 = new File("input.txt");
		File infile = new File("src/Experiment");
		File outfile = new File("output.txt");
                File outfile2 = new File("output2.txt");
        copyDocs(infile, outfile);
	File dir = new File("src/Experiment2");
        cloneDirs(dir, new File("src/Experiment/newfolder"));
        wordsInDocs(infile, outfile);
	}
}

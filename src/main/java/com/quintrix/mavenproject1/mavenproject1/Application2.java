package com.quintrix.mavenproject1.mavenproject1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class Application2 {

    public static void main(String[] args) throws IOException {
    	
    	
        
    	BufferedReader br = new BufferedReader(new FileReader("test.txt"));
    	
    	String theText;
    	while((theText = br.readLine())!=null) {
    		System.out.println(theText);
    	}
    	
    	System.out.println(Paths.get("").toAbsolutePath());
    	
    	br.close();
    }

}
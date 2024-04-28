//Author: Sushma Nepal
//Course: COSC 2425
//Program Set 1
//Comments: Help from relative.


import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;

public class RoundingSN {

	public static void main(String[] args) throws IOException {
		System.out.print("Enter File name: ");
		Scanner sc = new Scanner(System.in);
		String filename = sc.nextLine();
		readFileAndPrintAddition(filename);

	}

	public static void readFileAndPrintAddition(String filename) throws IOException {
		
		File myObj = new File("TestData/" + filename);
		int count = 0;
		float addition = 0;
		int decimalPlaces = Integer.parseInt(Files.readAllLines(Paths.get("TestData/" +filename)).get(0));
		DecimalFormat df = new DecimalFormat();
		
		df.setMaximumFractionDigits(decimalPlaces);
		df.setRoundingMode(RoundingMode.CEILING);
		
	    Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        myReader.nextLine();
	        count++;
	        
	      }
	      
	      for(int i=1;i<count;i++) {
	    	  String line = Files.readAllLines(Paths.get("TestData/" +filename)).get(i);
	          addition = addition + Float.parseFloat(line);
	      }
	    
	      System.out.println("Final value : "+df.format(addition));

	}
}

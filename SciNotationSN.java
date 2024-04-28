//Author: Sushma Nepal
//Course: COSC 2425
//Program Set 1
//Comments: Help from relative from IT background.


import java.util.Scanner;
import java.text.DecimalFormat;
public class SciNotationSN {

	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		sciNotation();
      System.out.println("Run again (Y/N): ");
		String yesOrNo  = myObj.nextLine();
		while(yesOrNo.equals("Y") || yesOrNo.equals("y"))
		{
			sciNotation();
			System.out.println("Run again (Y/N): ");
			 yesOrNo  = myObj.nextLine();
		}
	}
	public static void sciNotation() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the base number: ");
		float base = scan.nextFloat();
		System.out.print("Enter the power of 10: ");
		int e = scan.nextInt();
		
		if(base >= 1 && base <= 10)
		{
		if(e >= -10 && e <= 10)
		{
		double result = base * Math.pow(10, e);	
		 
		System.out.println(base + " * " + "10^" + e + " = " + df.format(result));
		}
		else {
			System.out.println("Power of 10 is not in the range");
		}
		}
		else 
		{
		System.out.println("Entered base number is not in the range");
		}
		
	}

}

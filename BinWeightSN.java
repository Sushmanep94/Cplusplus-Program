//Author: Sushma Nepal
//Course: COSC 2425
//Program Set 1
//Comments: Help from relative.



import java.util.Scanner;

public class BinWeightSN {
	
	 
	
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		convertDecimalToBinary();
		System.out.println("Run again (Y/N): ");
		String yesOrNo  = myObj.nextLine();
		while(yesOrNo.equals("Y") || yesOrNo.equals("y"))
		{
			convertDecimalToBinary();
			System.out.println("Run again (Y/N): ");
			 yesOrNo  = myObj.nextLine();
		}
		 
	      

	}
	public static void convertDecimalToBinary()
	{
		Scanner myObj = new Scanner(System.in);
		 System.out.println("Enter a decimal number (1-1000000): "); 
		 int dec= myObj.nextInt();
		 if (dec>=1 && dec<=1000000)
		 {
			// converting to binary and representing it in a string
		      String bin = Integer.toBinaryString(dec);
		      
		      System.out.println("The number "+dec+" binary is : " +bin);
		       System.out.println("The binary weight of "+dec+" is: "+Integer.bitCount(dec)); 
		 }
		 else
		 {
			 System.out.println("Entered decimal number is not in the range");
		 }
	}

}

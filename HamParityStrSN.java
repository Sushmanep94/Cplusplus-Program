//Author: Sushma Nepal
//Course: COSC 2425
//Program Set 1
//Comments: Help from relative.

import java.util.*;

public class HamParityStrSN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    System.out.print("Enter a hex string and parity type: ");	    	    
		String input = sc.nextLine();
		String[] spiltedString = input.split(" ");
		String typeOfParity = spiltedString[1].toUpperCase();
		String hexString = spiltedString[0].toUpperCase();
		String bin = hexToBinary(hexString);
		int rBitsCount = 1;
		
		
		
	
		
		while(Math.pow(2, rBitsCount)<(bin.length()+rBitsCount+1))
		{
			rBitsCount++;
		}
		
		int[] ar = generateCode(bin, bin.length(),rBitsCount);
		System.out.print("Hamming "+typeOfParity+" parity string of "+hexString+" : ");
		ar=calculateParity(ar, rBitsCount,typeOfParity);
		printParity(typeOfParity, ar, rBitsCount);
		System.out.println();	
		Scanner myObj = new Scanner(System.in);
		System.out.println("Run again (Y/N): ");
		String yesOrNo  = myObj.nextLine();
		while(yesOrNo.toUpperCase().equals("Y"))
		{
			 sc = new Scanner(System.in);
		    System.out.print("Enter a hex string and parity type: ");	    	    
			 input = sc.nextLine();
			 spiltedString = input.split(" ");
			 typeOfParity = spiltedString[1].toUpperCase();
			 hexString = spiltedString[0].toUpperCase();
			 bin = hexToBinary(hexString);
			 rBitsCount = 1;
			
			
			
		
			
			while(Math.pow(2, rBitsCount)<(bin.length()+rBitsCount+1))
			{
				rBitsCount++;
			}
			
		    ar = generateCode(bin, bin.length(),rBitsCount);
			System.out.print("Hamming "+typeOfParity+" parity string of "+hexString+" : ");
			ar=calculateParity(ar, rBitsCount,typeOfParity);
			printParity(typeOfParity, ar, rBitsCount);
			System.out.println();	
			System.out.println("Run again (Y/N): ");
			 yesOrNo  = myObj.nextLine();
		}
		
	}
	
	
	public static String hexToBinary(String hex)
    {
        // variable to store the converted
        // Binary Sequence
        String binary = "";
 
        // converting the accepted Hexadecimal
        // string to upper case
        hex = hex.toUpperCase();
 
        // initializing the HashMap class
        HashMap<Character, String> hashMap
            = new HashMap<Character, String>();
 
        // storing the key value pairs
        hashMap.put('0', "0000");
        hashMap.put('1', "0001");
        hashMap.put('2', "0010");
        hashMap.put('3', "0011");
        hashMap.put('4', "0100");
        hashMap.put('5', "0101");
        hashMap.put('6', "0110");
        hashMap.put('7', "0111");
        hashMap.put('8', "1000");
        hashMap.put('9', "1001");
        hashMap.put('A', "1010");
        hashMap.put('B', "1011");
        hashMap.put('C', "1100");
        hashMap.put('D', "1101");
        hashMap.put('E', "1110");
        hashMap.put('F', "1111");
 
        int i;
        char ch;// loop to iterate through the length
        // of the Hexadecimal String
        for (i = 0; i < hex.length(); i++) {
            // extracting each character
            ch = hex.charAt(i);
 
            // checking if the character is
            // present in the keys
            if (hashMap.containsKey(ch))
 
                // adding to the Binary Sequence
                // the corresponding value of
                // the key
                binary += hashMap.get(ch);
 
            // returning Invalid Hexadecimal
            // String if the character is
            // not present in the keys
            else {
                binary = "Invalid Hexadecimal String";
                return binary;
            }
        }
 
        // returning the converted Binary
        return binary;
    }
	
	public static int[] generateCode(String binaryNumber, int M, int r)
    {
        int[] ar = new int[r + M + 1];
        int j = 0;
        for (int i = 1; i < ar.length; i++) {
        	
            if ((Math.ceil(Math.log(i) / Math.log(2))
                 - Math.floor(Math.log(i) / Math.log(2)))
                == 0) {
  
                // if i == 2^n for n in (0, 1, 2, .....)
                // then ar[i]=0
                // codeword[i] = 0 ----
                // redFundant bits are initialized
                // with value 0
                ar[i] = 0;
            }
            else {
  
                // codeword[i] = dataword[j]
                ar[i] = (int)(binaryNumber.charAt(j) - '0');
                j++;
            }
        }
        return ar;
    }
	
	public static int[] calculateParity(int[] ar , int rBits, String parity)
	{
		
		for (int i = 0; i < rBits; i++) {
			int p = (int)Math.pow(2, i);
			for (int j = 1 ; j < ar.length; j++) {
				if(((j>>i) & 1) == 1)
				{
					if(p!=j)
					{
						ar[p] = ar[p] ^ ar[j];
					}
				}
			  }
		    }
     return ar;
    }
	
	public static void printParity(String parityType,int[] ar,int r)
	{
		if(parityType.toUpperCase().equals("EVEN"))
		{
			for (int i = 1; i <= ar.length; i++) {
				for (int j = 0; j < r; j++) {
					if(i==(int)Math.pow(2, j))
						System.out.print(ar[i]);
				}
			}
		}

		
		if(parityType.toUpperCase().equals("ODD"))
		{
			for (int i = 1; i <= ar.length; i++) {
				for (int j = 0; j < r; j++) {
					int x = (int)Math.pow(2, j);
					if(i==x) {
						ar[i] = (ar[i]==1)?0:1;
						System.out.print(ar[i]);
					}
				}
			}
		}
	
	}
}

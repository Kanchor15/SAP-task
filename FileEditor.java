package zadSAP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileEditor 
{

	public static void main(String[] args) throws IOException 
	{
		int i = 0, choice = 0;		
		File file = new File("E:\\University\\2 KURS\\PIK3\\testSAP.txt");
		// Tuk az rabotq s tozi .txt fail i tazi direktoriq e na moq computer :)
		Scanner scan = new Scanner(file);
		Scanner sc = new Scanner(System.in);
		String[] ArrayLines = new String[25];
		boolean error = true;
		
		System.out.println("Type 1 for switching 2 lines in a file ");
		System.out.println();
		System.out.println("Type 2 for switching 2 words from a single line or from 2 different lines in a file ");
		System.out.println();

		while (error) 
		{
	        if (sc.hasNextInt())
	        {
	        choice = sc.nextInt();	        
	        }
	        else 
	        {
	        	System.out.println("Invalid input! Try again.");
	            sc.next();
	            continue;
	        }
	        error=false;
	    }
		
		// ATTENTION ! ALL INDEXES START FROM 0 !
		
		while(scan.hasNextLine())
		{
			ArrayLines[i]=scan.nextLine();
			i++;
		}
		scan.close();
		
		FileWriter writer = new FileWriter("E:\\University\\2 KURS\\PIK3\\testSAP.txt");
		
		if(choice==1)
		{
		System.out.printf("FirstLineIndex(Start from 0)=");
        int firstLineIndex = sc.nextInt();
        if(firstLineIndex<=0 || firstLineIndex>=i) 
        {
        	System.out.println("There is no line with that index!");
        	System.exit(0);
        }
        
        System.out.printf("SecondLineIndex(Start from 0)=");
        int secondLineIndex = sc.nextInt();
        sc.close();
        if(secondLineIndex<=0 || secondLineIndex>=i) 
        {
        	System.out.println("There is no line with that index!");
        	System.exit(0);
        }
        
        String tempLine = ArrayLines[firstLineIndex];
        ArrayLines[firstLineIndex]=ArrayLines[secondLineIndex];
        ArrayLines[secondLineIndex]=tempLine;
        
        for(int j = 0 ; j < i ; j++)
		{
		writer.write(ArrayLines[j]);
		writer.write("\n");
		}
        writer.close();
		}
        
		else if(choice==2)
		{
		System.out.printf("FirstLineIndex=");
	    int firstLineIndex = sc.nextInt();
	    System.out.printf("FirstWordIndex=");
        int firstWordIndex = sc.nextInt();
	    System.out.printf("SecondLineIndex=");
	    int secondLineIndex = sc.nextInt();
	    System.out.printf("SecondWordIndex=");
        int secondWordIndex = sc.nextInt();
        sc.close();
	    
		String[] Line1Words = ArrayLines[firstLineIndex].split(" ");
		String[] Line2Words = ArrayLines[secondLineIndex].split(" ");
        
        String tempWord = Line1Words[firstWordIndex];
        Line1Words[firstWordIndex]=Line2Words[secondWordIndex];
        Line2Words[secondWordIndex]=tempWord;
        
        ArrayLines[firstLineIndex]=String.join(" ", Line1Words);
        ArrayLines[secondLineIndex]=String.join(" ", Line2Words);
        
        for(int j = 0 ; j < i ; j++)
		{
		writer.write(ArrayLines[j]);
		writer.write("\n");
		}
		writer.close();
		}
		else 
		{
			System.out.println("Invalid number of action!");
			
			for(int j = 0 ; j < i ; j++)
			{
			writer.write(ArrayLines[j]);
			writer.write("\n");
			}
			writer.close();
		}
	}     
}

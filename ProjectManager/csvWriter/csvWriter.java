package csvWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import com.csvreader.CsvWriter;

public class csvWriter
{
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		boolean fileExists = new File("dit.csv").exists();
					
		try {
				CsvWriter usersFile = new CsvWriter(new FileWriter("dit.csv", true), ',');
				
				// Used to check if file already exists, if it doesn't it will give the file headers
				if (!fileExists)
				{
					usersFile.write("id");
					usersFile.write("name");
					usersFile.endRecord();
				}
				
				//User input
				Scanner exit = new Scanner(System.in);
				System.out.println("Enter a id: ");
				String n = exit.nextLine();
				
				Scanner reader = new Scanner(System.in);
				System.out.println("Enter a name: ");
				String input = reader.nextLine();
				
				//Used to write to the csv file
				usersFile.write(n);
				usersFile.write(input);
				usersFile.endRecord();
				usersFile.close();
			} 
		catch(IOException e) 
		{
			System.out.println(e);
		}
	}
}
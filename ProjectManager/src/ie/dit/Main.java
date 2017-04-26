package ie.dit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

/**
 * Created by David on 06/03/2017.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("ie/dit/daytheme.css");
        Image app = new Image(getClass().getResourceAsStream("kingthomas.png"));
        primaryStage.setTitle("Log In");
        primaryStage.getIcons().add(app);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
        csvReader();
    }
    
    //Skeleton code found online
    @SuppressWarnings("resource")
	private static void csvReader() {
		// TODO Auto-generated method stub
		try
		{
			CsvReader user = new CsvReader("Groupinformation.csv");
			user.readHeaders();// Used so the headers are not displayed
			
			//Used for user input
			Scanner reader = new Scanner(System.in);
			System.out.println("Reading file \nEnter a name: ");
			String input = reader.nextLine();
			
			while(user.readRecord())
			{
				String userId = user.get("id");
				String name = user.get("name");
				String Date = user.get("Date");
				String Eventname = user.get("Eventname");
				String Eventinfo = user.get("Eventinfo");
				if(input.equals(name))// Used to compare strings
				{
					System.out.println(userId + "," + name + "," + Date + "," + Eventname + "," + Eventinfo);
				}
			}
			user.close();
		 }
		catch(IOException t)
		{
			System.out.println("File cannot be found");
		}
		
	}
	
	@SuppressWarnings("resource")
	private static void csvWriter(String eventinfo, String eventname, String eventdate)
	{
		int exists = 0;
		boolean fileExists = new File("Groupinformation.csv").exists();
		if(fileExists)
		{
			 exists = 1;
			 System.out.println("File exists");
		}
						
		try {
				CsvWriter usersFile = new CsvWriter(new FileWriter("Groupinformation.csv", true), ',');
					
				// Used to check if file already exists, if it doesn't it will give the file headers
				if (exists!=1)
				{
					System.out.println("Creating file");
				    usersFile.write("id");
					usersFile.write("name");
					usersFile.write("Date");
					usersFile.write("Eventname");
					usersFile.write("Eventinfo");
					usersFile.endRecord();
				}
				
				//User input
				Scanner reader = new Scanner(System.in);
				System.out.println("Enter a id: ");
				String id = reader.nextLine();
					
				Scanner reader1 = new Scanner(System.in);
				System.out.println("Enter a name: ");
				String name = reader1.nextLine();
				
				/*
				Scanner reader2 = new Scanner(System.in);
				System.out.println("Enter a date: ");
				String Date = reader2.nextLine();
				
				Scanner reader3 = new Scanner(System.in);
				System.out.println("Enter event name: ");
				String Eventname = reader3.nextLine();
				
				Scanner reader4 = new Scanner(System.in);
				System.out.println("Enter event info: ");
				String Eventinfo = info
				*/
					
				//Used to write to the csv file
				usersFile.write(id);
				usersFile.write(name);
				usersFile.write(eventdate);
				usersFile.write(eventname);
				usersFile.write(eventinfo);
				usersFile.endRecord();
				usersFile.close();
				} 
			catch(IOException e) 
			{
				System.out.println(e);
			}
		}
	}

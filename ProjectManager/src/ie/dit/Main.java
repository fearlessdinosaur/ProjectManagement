package ie.dit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//import com.csvreader.CsvReader;
//import com.csvreader.CsvWriter;

//import com.csvreader.CsvWriter;

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
        //csvWriter();
    }
    
    /*private static void csvWriter()
	{
		int exists = 0;
		boolean fileExists = new File("GroupInfo.csv").exists();
		//To see if the file exists
		if(fileExists)
		{
			 exists = 1;
			 System.out.println(exists);
		}
						
		try {
				CsvWriter usersFile = new CsvWriter(new FileWriter("GroupInfo.csv", true), ',');
					
				// Used to check if file already exists, if it doesn't it will give the file headers
				if (exists!=1)
				{
				    usersFile.write("id");
					usersFile.write("name");
					usersFile.write("Date");
					usersFile.write("Event name");
					usersFile.write("Event info");
					usersFile.endRecord();
				}
				
				//User input
				Scanner exit = new Scanner(System.in);
				System.out.println("Enter a id: ");
				String id = exit.nextLine();
					
				Scanner reader = new Scanner(System.in);
				System.out.println("Enter a name: ");
				String name = reader.nextLine();
				
				Scanner reader1 = new Scanner(System.in);
				System.out.println("Enter a date: ");
				String date = reader1.nextLine();
				
				Scanner reader2 = new Scanner(System.in);
				System.out.println("Enter a event name: ");
				String eName = reader2.nextLine();
				
				Scanner reader3 = new Scanner(System.in);
				System.out.println("Enter event info: ");
				String eInfo = reader3.nextLine();
					
				//Used to write to the csv file
				usersFile.write(id);
				usersFile.write(name);
				usersFile.write(date);
				usersFile.write(eName);
				usersFile.write(eInfo);
				usersFile.endRecord();
				usersFile.close();
				} 
			catch(IOException e) 
			{
				System.out.println(e);
			}
		}*/

}

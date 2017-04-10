package ie.dit;

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
        Image app = new Image(getClass().getResourceAsStream("kingthomas.png"));
        primaryStage.setTitle("Log In");
        primaryStage.getIcons().add(app);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        /*Client client = new Client();
        try
        {
            client.post(logInController.log_in_event.username,"password");
            client.get();
        }
        catch(Exception e)
        {

        }*/

        launch(args);
    }

}

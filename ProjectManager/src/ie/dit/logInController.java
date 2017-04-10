package ie.dit;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class logInController {

    @FXML
    private Button sign_up;

    @FXML
    private TextField username_check;

    @FXML
    private Button log_in;

    @FXML
    private PasswordField password_check;

    @FXML
    void sign_up_event(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        Image app = new Image(getClass().getResourceAsStream("kingthomas.png"));
        System.out.println("hey");
        stage = (Stage) sign_up.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("sign_up.fxml"));
        stage.setScene(new Scene(root));
        stage.getIcons().add(app);
        stage.setTitle("Project Manager");
        stage.show();
    }

    @FXML
    void log_in_event(ActionEvent event) throws IOException{
        String username;
        String password;

        username = username_check.getText();
        password = password_check.getText();

        Client client = new Client();
        try
        {
            client.post(username,password);
            client.get();
        }
        catch(Exception e)
        {

        }

    }


}
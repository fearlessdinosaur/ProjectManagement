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
import java.lang.String.*;

import java.io.IOException;

public class signUpController {

    @FXML
    private Button log_in1;

    @FXML
    private Button sign_up1;

    @FXML
    private PasswordField password_check1;

    @FXML
    private PasswordField password_check2;

    @FXML
    private TextField username_check;

    @FXML
    void sign_up1_event(ActionEvent event){
        String username;
        String password1, password2;

        username = username_check.getText();
        password1 = password_check1.getText();
        password2 = password_check2.getText();

        Client client = new Client();

        if(password1.compareTo(password2)==0) {
            try {
                client.post(username, password1);
                client.get();
            } catch (Exception e) {

            }
        }
        else{
            System.out.println("no");
        }
    }

    @FXML
    void log_in1_event(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        Image app = new Image(getClass().getResourceAsStream("kingthomas.png"));
        System.out.println("hey");
        stage = (Stage) log_in1.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setScene(new Scene(root));
        stage.getIcons().add(app);
        stage.setTitle("Project Manager");
        stage.show();

    }

}

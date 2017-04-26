package ie.dit;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

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
    private Label samepassword;

    @FXML
    //creates new user account
    String sign_up1_event(ActionEvent event){
        String username;
        String password1, password2;

        username = username_check.getText();
        password1 = password_check1.getText();
        password2 = password_check2.getText();
        Client client = new Client();

        //checks if the 2 inputted passwords are the same
        if(password1.compareTo(password2)==0) {
            //if same, will send to database and create account/record
            try {
                client.postUser(username, password1);
                Main.name=username;
                Stage stage;
                Parent root;
                Image app = new Image(getClass().getResourceAsStream("kingthomas.png"));
                stage = (Stage) sign_up1.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("manager.fxml"));
                stage.setScene(new Scene(root));
                stage.getIcons().add(app);
                stage.setTitle("Project Manager");
                stage.show();
            } catch (Exception e) {

            }
            return username;
        }
        else{
            //if not same, will show error message
            samepassword.setVisible(true);
            return null;
        }
    }

    @FXML
    //will go back to log in page
    void log_in1_event(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        Image app = new Image(getClass().getResourceAsStream("kingthomas.png"));
        stage = (Stage) log_in1.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("ie/dit/daytheme.css");
        stage.setScene(scene);
        stage.getIcons().add(app);
        stage.setTitle("Project Manager");
        stage.show();

    }


}

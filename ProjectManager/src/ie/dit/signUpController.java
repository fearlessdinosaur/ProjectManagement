package ie.dit;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class signUpController {

    @FXML
    private Button log_in1;

    @FXML
    private Button sign_up1;

    @FXML
    void sign_up1_event(ActionEvent event) {

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

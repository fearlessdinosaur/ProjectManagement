package ie.dit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.json.JSONException;

import java.io.IOException;

public class createTeamController {

    @FXML
    private TextField teamname;

    @FXML
    private Label errormessage;

    @FXML
    void createteam(ActionEvent event) throws IOException, JSONException {

        errormessage.setVisible(false);

        String team = teamname.getText();

        Client client = new Client();
        try {
            client.postTeam(team);

            Stage stage;
            Parent root;
            Image app = new Image(getClass().getResourceAsStream("kingthomas.png"));
            stage = (Stage) teamname.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("manager.fxml"));
            stage.setScene(new Scene(root));
            stage.getIcons().add(app);
            stage.setTitle("Project Manager");
            stage.show();

        } catch (Exception e) {

        }
    }

    @FXML
    void backToMain(ActionEvent event) throws IOException{
        Stage stage;
        Parent root;
        Image app = new Image(getClass().getResourceAsStream("kingthomas.png"));
        stage = (Stage) teamname.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("manager.fxml"));
        stage.setScene(new Scene(root));
        stage.getIcons().add(app);
        stage.setTitle("Project Manager");
        stage.show();
    }
}

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

public class leaveTeamController {

    @FXML
    private Label errormessage;

    @FXML
    private TextField teamname;

    @FXML
    private Label workmessage;

    @FXML
    void leaveteam(ActionEvent event) {
        String team = teamname.getText();

        workmessage.setVisible(false);
        errormessage.setVisible(false);

        //Client client = new Client();
        try {
            /*String success = client.post(team);

            if (success.equals("0") == true) {
                System.out.println("it werks");

                workmessage.setVisible(true);
            }
            if (success.equals("1") == true) {
                System.out.println("no");

                errormessage.setVisible(true);
            }*/

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
}


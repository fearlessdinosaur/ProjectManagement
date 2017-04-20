package ie.dit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class createTeamController {

    @FXML
    private TextField teamname;

    @FXML
    private Label errormessage;

    @FXML
    private Label workmessage;

    @FXML
    void createteam(ActionEvent event) {

        errormessage.setVisible(false);
        workmessage.setVisible(false);

        String team = teamname.getText();

        Client client = new Client();
        try {
            String success = client.get(team);
            if (success.equals("0") == true) {
                System.out.println("it werks");

                workmessage.setVisible(true);
            }
            if (success.equals("1") == true) {
                System.out.println("no");

                errormessage.setVisible(true);
            }
        } catch (Exception e) {

        }
    }
}

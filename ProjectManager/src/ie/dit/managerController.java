package ie.dit;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class managerController {

    @FXML
    private MenuBar toolbar;

    @FXML
    private Menu settings_menu;

    @FXML
    private CheckMenuItem daytheme;

    @FXML
    private CheckMenuItem oddtheme;

    @FXML
    private CheckMenuItem nighttheme;

    private String daythemecss = getClass().getResource("daytheme.css").toExternalForm();
    private String nightthemecss = getClass().getResource("nighttheme.css").toExternalForm();
    private String oddthemecss = getClass().getResource("nighttheme.css").toExternalForm();

    @FXML
    void uncheck1(ActionEvent event) throws IOException {
        if(daytheme.isSelected() == true){
            nighttheme.setSelected(false);
            oddtheme.setSelected(false);

            Stage stage;
            Parent root = FXMLLoader.load(getClass().getResource("manager.fxml"));
            Image app = new Image(getClass().getResourceAsStream("kingthomas.png"));
            stage = (Stage) toolbar.getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().remove(nightthemecss);
            scene.getStylesheets().remove(oddthemecss);
            scene.getStylesheets().add("ie/dit/daytheme.css");
            stage.setScene(scene);
            stage.getIcons().add(app);
            stage.setTitle("Project Manager");
            stage.show();

        }
    }

    @FXML
    void uncheck2(ActionEvent event) throws IOException {
        if(nighttheme.isSelected() == true) {
            daytheme.setSelected(false);
            oddtheme.setSelected(false);

            Stage stage;
            Parent root = FXMLLoader.load(getClass().getResource("manager.fxml"));
            Image app = new Image(getClass().getResourceAsStream("kingthomas.png"));
            stage = (Stage) toolbar.getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("ie/dit/nighttheme.css");
            stage.setScene(scene);
            stage.getIcons().add(app);
            stage.setTitle("Project Manager");
            stage.show();
        }

    }

    @FXML
    void uncheck3(ActionEvent event) throws IOException {
        if(oddtheme.isSelected() == true){
            nighttheme.setSelected(false);
            daytheme.setSelected(false);

            Stage stage;
            Parent root = FXMLLoader.load(getClass().getResource("manager.fxml"));
            Image app = new Image(getClass().getResourceAsStream("kingthomas.png"));
            stage = (Stage) toolbar.getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().remove(nightthemecss);
            scene.getStylesheets().remove(oddthemecss);
            scene.getStylesheets().add("ie/dit/nighttheme.css");
            stage.setScene(scene);
            stage.getIcons().add(app);
            stage.setTitle("Project Manager");
            stage.show();

        }
    }
}


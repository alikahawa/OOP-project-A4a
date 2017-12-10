package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller {

    private SplitPane rootPane;

    public void studentButton(ActionEvent event) throws IOException {

        Parent pane_parent = FXMLLoader.load(getClass().getResource("loginscreen.fxml"));
        Scene pane_scene = new Scene(pane_parent);
        Stage pane_stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //First cast to node object.
        //When it is a node object you can get the scene and window and then formally cast it to a stage.
        pane_stage.setScene(pane_scene);
        pane_stage.show();
    }
    public void LoginButton(ActionEvent event) throws IOException{
        Parent pane_parent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene pane_scene = new Scene(pane_parent);
        Stage pane_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        pane_stage.setScene(pane_scene);
        pane_stage.show();
    }
    public void TeacherButton(ActionEvent event) throws IOException{
        Parent pane_parent = FXMLLoader.load(getClass().getResource("loginscreen.fxml"));
        Scene pane_scene = new Scene(pane_parent);
        Stage pane_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        pane_stage.setScene(pane_scene);
        pane_stage.show();
    }


}

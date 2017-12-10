package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;


public class Controller {

    @FXML private Label lblTest;
    @FXML private Label lblTest2;
    @FXML private Button button;

    public void button1() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample2.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        controller.setName("Hey");
        button.getScene().setRoot(root); //need button of first scene
//        The old method is below. This doesn't work because you make a new scene. This is bad practice because you can't
//        Pass arguments to this scene directly.
//        Parent pane_parent = FXMLLoader.load(getClass().getResource("sample2.fxml"));
//        Scene pane_scene = new Scene(pane_parent);
//        Stage pane_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Controller controller = loader
//        pane_stage.setScene(pane_scene);
//        pane_stage.show();
    }
    public void setName(String name){
        lblTest2.setText(name);
    }

    public void button2(ActionEvent event) throws IOException {
        lblTest2.setText("Hello");
    }
}

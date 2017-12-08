package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller {

    private SplitPane rootPane;
    private int count = 0;
    @FXML private Label counter;
    @FXML private Text text;
    @FXML private TextArea textArea;
    @FXML private TextField textField;


    public void studentButton(ActionEvent event) throws IOException {

        Parent pane_parent = FXMLLoader.load(getClass().getResource("loginscreen.fxml"));
        Scene pane_scene = new Scene(pane_parent);
        Stage pane_stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); //First cast to node object.
        //When it is a node object you can get the scene and window and then formally cast it to a stage.
        pane_stage.setScene(pane_scene);
        pane_stage.show();
    }
    public void BackButton(ActionEvent event) throws IOException{
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
    public void LoginButton(ActionEvent event) throws IOException{
        Parent pane_parent = FXMLLoader.load(getClass().getResource("clickable_picture_easy_1.fxml"));
        Scene pane_scene = new Scene(pane_parent);
        Stage pane_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        pane_stage.setScene(pane_scene);
        pane_stage.show();
    }
    public void tuAula(ActionEvent event) throws IOException {
        Parent pane_parent = FXMLLoader.load(getClass().getResource("Answer.fxml"));
        Scene pane_scene = new Scene(pane_parent);
        Stage pane_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        pane_stage.setScene(pane_scene);
        pane_stage.show();
        System.out.println("Correct, your score is: " + count);

    }
    public void tuAulaWrong(MouseEvent event) throws  IOException{
        Parent pane_parent = FXMLLoader.load(getClass().getResource("Answer.fxml"));
        Scene pane_scene = new Scene(pane_parent);
        Stage pane_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        pane_stage.setScene(pane_scene);
        pane_stage.show();
        count = 0;
        System.out.println("Wrong, your score is: " + count);
        //counter.setText(Integer.toString(count));
    }

}

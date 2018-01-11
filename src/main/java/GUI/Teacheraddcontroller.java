package GUI;

import Application.MultiQuestion;
import Application.Question;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;


public class Teacheraddcontroller {
    @FXML private Button mypage;
    @FXML private Button addtextquestion;
    @FXML private Button addimage;
    @FXML private Button back;

    public void fromTeacheraddToAddquestion() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Addquestion.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        addtextquestion.getScene().setRoot(root);
    }

    public void ToAddimage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Loginpage1.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        addimage.getScene().setRoot(root);
    }

    public void Tomypage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teacherpage.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        mypage.getScene().setRoot(root);
    }

    public void backtoLoginscreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Loginpage1.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        back.getScene().setRoot(root);
    }
}

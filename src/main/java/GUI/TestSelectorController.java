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


public class TestSelectorController {

    @FXML private Button TextBasedExamButton;
    @FXML private Button PictureBasedExamButton1;
    @FXML private Button PictureBasedExamButton2;
    @FXML private Button UIBasedExamButton;
    @FXML private Button back;
    @FXML private Button mypage;


    public void goToStartOfTextBasedTest() throws IOException {
        System.out.println("Text-based test is being loaded");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/TextExam.fxml"));
        Parent root = loader.load();
        TextTestController controller = loader.getController();
        TextBasedExamButton.getScene().setRoot(root);
    }

    /*
    Back to Login screen
     */

    public void backToLogin() throws IOException {
        System.out.println("Text-based test is being loaded");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Loginpage1.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        back.getScene().setRoot(root);
    }

    /*
    Navigate to student profile
     */

    public void goToMypagestudent() throws IOException {
        System.out.println("Text-based test is being loaded");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/StudentProfile.fxml"));
        Parent root = loader.load();
        TextTestController controller = loader.getController();
        mypage.getScene().setRoot(root);
    }
}

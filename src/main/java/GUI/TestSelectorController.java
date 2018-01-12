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
    @FXML private Button ClickablePictureBasedExamButton;
    @FXML private Button UIBasedExamButton;


    public void goToStartOfTextBasedTest() throws IOException {
        System.out.println("Text-based test is being loaded");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/TextExam.fxml"));
        Parent root = loader.load();
        TextTestController controller = loader.getController();
        TextBasedExamButton.getScene().setRoot(root);
    }

    public void goToStartOfClickablePictureBasedTest() throws IOException {
        System.out.println("ClickablePicture-based test is being loaded");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ClickablePictureExam.fxml"));
        Parent root = loader.load();
        ClickablePictureTestController controller = loader.getController();
        ClickablePictureBasedExamButton.getScene().setRoot(root);
    }

}

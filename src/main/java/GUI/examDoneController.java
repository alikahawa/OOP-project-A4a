package GUI;

import Application.MultiQuestion;
import Application.Question;
import Application.QuestionList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.ArrayList;


public class examDoneController {

    @FXML private Label finalScore;
    @FXML private Button returnButton;
    @FXML private Label finalText;

    public void setFinalScore(int score)
    {
        finalScore.setText("Score: " + score + "/10");
        if (score ==10)
        {
            finalText.setText("PERFECT! Andy would be proud");
        }
    }

    public void returnToMainMenu() throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Difficultyselectionpage.fxml"));
        Parent root = loader.load();
        TestSelectorController controller = loader.getController();
        returnButton.getScene().setRoot(root);
    }


}
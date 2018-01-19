package GUI;

import Application.MultiQuestion;
import Application.PictureQuestion;
import Application.Question;
import Application.QuestionList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static java.lang.Math.abs;

import java.io.IOException;
import java.util.ArrayList;


public class ClickablePictureTestController {

    @FXML private Button correctButton;
    @FXML private Button incorrectButton;
    @FXML private Label questionText;
    @FXML private Label scoreCounter;
    @FXML private ImageView progressbar;
    @FXML private ImageView questionPicture;
    @FXML private Button rageQuit;

    int examquestioncount = 0;
    int score = 0;
    ArrayList<Question> tmpq1shuffled;
    QuestionList tmpql;
    PictureQuestion tmpquestion;

    public void initialize() {

        System.out.println("ClickablePicture-based test is loaded");
        tmpql = QuestionList.ReadFromXML("OOP.xml");

        tmpq1shuffled = tmpql.shuffleQuestionList();
        // start quiz, per vraag show vraag en 3 antwoorden.

        displayQuestion();
    }

    public void displayQuestion() {

        QuestionList tmpq1shuffledQuestionList = new QuestionList(tmpq1shuffled);
        ArrayList<PictureQuestion> tmp2 = tmpq1shuffledQuestionList.getPictureQList();
        tmpquestion = tmp2.get(examquestioncount);

        System.out.println("This picture is now being shown: " + tmpquestion.getPicture());
        Image imagetmp = new Image(tmpquestion.getPicture());
        questionPicture.setImage(imagetmp);

        questionText.setText(tmpquestion.getQuestion());

        int tmpx1 = tmpquestion.getX1();
        int tmpx2 = tmpquestion.getX2();
        int tmpy1 = tmpquestion.getY1();
        int tmpy2 = tmpquestion.getY2();

        int dx = Math.abs(tmpx2 - tmpx1);
        int dy = Math.abs(tmpy2 - tmpy1);

        correctButton.setPrefWidth(dx);
        correctButton.setPrefHeight(dy);

        correctButton.setLayoutX(questionPicture.getLayoutX() + tmpx1 - 20 );
        correctButton.setLayoutY(questionPicture.getLayoutY() + tmpy1);

        scoreCounter.setText("Score: " + score + "/" + examquestioncount);
        progressBar();
    }


    public void correctlyClicked() throws IOException
    {
        score++;
        examquestioncount++;
        scoreCounter.setText("Score: " + score + "/" + examquestioncount);

        // display volgende vraag.
        if (examquestioncount < 10) {
            displayQuestion();
        } else {
            examDone();
        }
    }
    public void incorrectlyClicked() throws IOException{
        score = score;
        examquestioncount++;
        scoreCounter.setText("Score: " + score + "/" + examquestioncount);

        // display volgende vraag.
        if (examquestioncount < 10) {
            displayQuestion();
        } else {
            examDone();
        }
    }

    public void examDone() throws IOException {
        int Result = score;

        if (Result > 6) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/examPassed.fxml"));
            Parent root = loader.load();
            examDoneController controller = loader.getController();
            controller.setFinalScore(Result);
            correctButton.getScene().setRoot(root);
        }
        else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/examFailed.fxml"));
            Parent root = loader.load();
            examDoneController controller = loader.getController();
            controller.setFinalScore(Result);
            correctButton.getScene().setRoot(root);
        }
    }

    public void progressBar() {
        String imageString;
        switch (examquestioncount) {
            case 0:
                imageString = "images\\0.png";
                break;
            case 1:
                imageString = "images\\1.png";
                break;
            case 2:
                imageString = "images\\2.png";
                break;
            case 3:
                imageString = "images\\3.png";
                break;
            case 4:
                imageString = "images\\4.png";
                break;
            case 5:
                imageString = "images\\5.png";
                break;
            case 6:
                imageString = "images\\6.png";
                break;
            case 7:
                imageString = "images\\7.png";
                break;
            case 8:
                imageString = "images\\8.png";
                break;
            case 9:
                imageString = "images\\9.png";
                break;
            default:
                imageString = "images\\0.png";
                break;
        }
        Image image2 = new Image(imageString);
        progressbar.setImage(image2);
    }
    public void rageQuitButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Studentpage.fxml"));
        Parent root = loader.load();
        TestSelectorController controller = loader.getController();
        rageQuit.getScene().setRoot(root);
    }


}

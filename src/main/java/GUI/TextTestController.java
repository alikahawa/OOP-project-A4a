package GUI;

import Application.MultiQuestion;
import Application.Question;
import Application.QuestionList;
import Application.UserList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class TextTestController {
    int examquestioncount = 0;
    int score = 0;
    ArrayList<Question> tmpq1shuffled;
    QuestionList tmpql;
    int answer;
    MultiQuestion tmpquestion;

    @FXML private Button answerA;
    @FXML private Button answerB;
    @FXML private Button answerC;
    @FXML private Label answerAText;
    @FXML private Label answerBText;
    @FXML private Label answerCText;
    @FXML private Label questionText;
    @FXML private Label scoreCounter;
    private Button abcButton;
    @FXML private ImageView progressbar;

    @FXML
    public void initialize() {

        System.out.println("Text-based test is loaded");
        tmpql = QuestionList.ReadFromXML("OOP.xml");

        tmpq1shuffled = tmpql.shuffleQuestionList();
        // start quiz, per vraag show vraag en 3 antwoorden.

        displayQuestion();
    }

    public void displayQuestion() {
        // Krijg uit de geshufflede lijst een question, en zet die als de tmpquestion(de vraag die nu beantwoord moet worden).
        // 1. Ik zet "tmpq1shuffled" om naar een questionlist zodat ik makkelijk een multiquestion uit de geshufflde lijst kan halen.
        // 2. Daarna haal ik er een vraag uit, "tmpquestion".
        // 3. Ik weet dat dit heel vaag is wat er nu allemaal gebeurd, ik zal het later oplossen als daar animo voor is

        QuestionList tmpq1shuffledQuestionList = new QuestionList(tmpq1shuffled);
        ArrayList<MultiQuestion> tmp2 = tmpq1shuffledQuestionList.getMultiQList();
        //tmpquestion = tmpq1shuffledQuestionList.getMultiQuestion(examquestioncount);
        tmpquestion = tmp2.get(examquestioncount);

        questionText.setText(tmpquestion.getQuestion());
        answerAText.setText(tmpquestion.getAnswerList().get(0));
        answerBText.setText(tmpquestion.getAnswerList().get(1));
        answerCText.setText(tmpquestion.getAnswerList().get(2));

        scoreCounter.setText("Score: " + score + "/" + examquestioncount);
        progressBar();
    }

    public void checkAnswer(int answer) throws IOException {
        if (answer == tmpquestion.getRightAnswer()) {
            // correcte antwoord score gaat omhoog en naar volgende vraag
            score++;
            examquestioncount++;
            scoreCounter.setText("Score: " + score + "/" + examquestioncount);

            // hier scherm GROEN

            // display volgende vraag.
            if (examquestioncount < 10) {
                displayQuestion();
            } else {
                examDone();
            }
        } else {
            // incorrecte antwoord score blijft gelijk
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
    }

    public void answerAPressed() throws IOException {
        checkAnswer(0);
        abcButton = answerA;
    }

    public void answerBPressed() throws IOException {
        checkAnswer(1);
        abcButton = answerB;
    }

    public void answerCPressed() throws IOException {
        checkAnswer(2);
        abcButton = answerC;
    }

    public void examDone() throws IOException {
        int Result = score;

        if (Result > 6) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/examPassed.fxml"));
            Parent root = loader.load();
            examDoneController controller = loader.getController();
            controller.setFinalScore(Result);
            abcButton.getScene().setRoot(root);
        }
        else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/examFailed.fxml"));
            Parent root = loader.load();
            examDoneController controller = loader.getController();
            controller.setFinalScore(Result);
            abcButton.getScene().setRoot(root);
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
}

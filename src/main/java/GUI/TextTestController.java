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
import javafx.scene.text.Text;

import java.io.IOException;
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

    @FXML
    public void initialize() {

        System.out.println("Text-based test is loaded");

        tmpql = QuestionList.ReadFromXML("OOP.xml");
        tmpql.WriteToXML("OOP.xml");

        answerAText.setText("TESTTEST");

        tmpq1shuffled = tmpql.shuffleQuestionList();
        // start quiz 10 vragen, per vraag show vraag en 3 antwoorden.

        displayQuestion();
    }

    public void displayQuestion()
    {
        // Krijg uit de geshufflede lijst een question, en zet die als de tmpquestion(de vraag die nu beantwoord moet worden).
        // 1. Ik zet "tmpq1shuffled" om naar een questionlist zodat ik makkelijk een multiquestion uit de geshufflde lijst kan halen.
        // 2. Daarna haal ik er een vraag uit, "tmpquestion".

        QuestionList tmpq1shuffledQuestionList = new QuestionList(tmpq1shuffled);
        tmpquestion = tmpq1shuffledQuestionList.getMultiQuestion(examquestioncount);

        questionText.setText(tmpquestion.getQuestion());
        answerAText.setText(tmpquestion.getAnswerList().get(0));
        answerBText.setText(tmpquestion.getAnswerList().get(1));
        answerCText.setText(tmpquestion.getAnswerList().get(2));
    }
    
    public void checkAnswer(int answer)
    {
        if (answer == tmpquestion.getRightAnswer())
        {
            // correcte antwoord score gaat omhoog en naar volgende vraag
            score++;
            examquestioncount++;
            scoreCounter.setText("Score:" + score + "/" + examquestioncount);

            // hier scherm GROEN

            // display volgende vraag.
            if (examquestioncount < 10)
            {
                displayQuestion();
            }
            else
            {
                // hier scherm QUIZ KLAAR
            }
        }
        else
        {
            // incorrecte antwoord score blijft gelijk
            score = score;
            examquestioncount++;
            scoreCounter.setText("Score:" + score + "/" + examquestioncount);

            // hier scherm ROOD

            // display volgende vraag.
            if (examquestioncount < 10)
            {
                displayQuestion();
            }
            else
            {
                // hier scherm QUIZ KLAAR
            }
        }
    }

    public void answerAPressed() throws IOException{
        checkAnswer(0);
    }

    public void answerBPressed() throws IOException{
        checkAnswer(1);
    }

    public void answerCPressed() throws IOException{
        checkAnswer(2);
    }

}

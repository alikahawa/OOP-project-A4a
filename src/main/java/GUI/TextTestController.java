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

import java.io.IOException;
import java.util.ArrayList;


public class TextTestController {
    static int examquestioncount = 0;
    static int score = 0;
    static ArrayList<Question> tmpq1shuffled;
    static QuestionList tmpql;

    @FXML private static Button answerA;
    @FXML private static Button answerB;
    @FXML private static Button answerC;
    @FXML private static Label answerAText;
    @FXML private static Label answerBText;
    @FXML private static Label answerCText;
    @FXML private static Label questionText;
    @FXML private static Label scoreCounter;

    public static void main(String[] args) {

        tmpql = QuestionList.ReadFromXML("OOP.xml");
        tmpql.WriteToXML("OOP.xml");

        tmpq1shuffled = tmpql.shuffleQuestionList();
        // start quiz 10 vragen, per vraag show vraag en 3 antwoorden.

        displayQuestion();
    }

    public static void displayQuestion()
    {
        // "(multiquestion)" is tijdelijk en moet gefixt worden.
        MultiQuestion tmpquestion = (MultiQuestion)tmpq1shuffled.get(examquestioncount);

        questionText.setText(tmpquestion.getQuestion());
        answerAText.setText(tmpquestion.getAnswerList().get(0));
        answerBText.setText(tmpquestion.getAnswerList().get(0));
        answerCText.setText(tmpquestion.getAnswerList().get(0));
    }
    
    public static void checkAnswer(int answer)
    {
        // "(multiquestion)" is tijdelijk en moet gefixt worden.
        MultiQuestion tmpquestion = (MultiQuestion)tmpq1shuffled.get(examquestioncount);

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
}

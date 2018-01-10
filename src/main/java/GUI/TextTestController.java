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


public class TextTestController {

    QuestionList tmpql = QuestionList.ReadFromXML("OOP.xml");
    tmpql.WriteToXML("OOP.xml");
 
    QuestionList tmpq1shuffled = tmpq1.shuffleQuestionList();

    UserList userList = UserList.readFromXML("src/Users.xml");
    userList.writeToXML("src/Users.xml");
   
    int examquestioncount = 0;
    int score = 0;

    @FXML private Button answerA;
    @FXML private Button answerB;
    @FXML private Button answerC;
    @FXML private Label answerAText;
    @FXML private Label answerBText;
    @FXML private Label answerCText;
    @FXML private Label questionText;
    @FXML private Label scoreCounter;
    
    public static void main(String[] args) {

        // start quiz 10 vragen, per vraag show vraag en 3 antwoorden.
        displayQuestion(examquestioncount);

    }

    public void displayQuestion()
    {
        // "(multiquestion)" is tijdelijk en moet gefixt worden.
        MultiQuestion tmpquestion = (MultiQuestion)tmpq1shuffled.getQ(examquestioncount);
            
        questionText.setText(tmpquestion.getQuestion());
        answerAText.setText(tmpquestion.getAnswerList().get(0));
        answerBText.setText(tmpquestion.getAnswerList().get(0));
        answerCText.setText(tmpquestion.getAnswerList().get(0));
    }

    public void checkAnswer(answer)
    {
        MultiQuestion tmpquestion = (MultiQuestion)tmpq1shuffled.getQ(examquestioncount);
            
        if (answer == tmpquestion.getRightAnswer())
        {
            // correcte antwoord score gaat omhoog
            score++;
            examquestioncount++;
            scoreCounter.setText("Score:" + score + "/" + examquestioncount);

            // hier scherm GROEN

            // display volgende vraag.
            if (examquestioncount < 10)
            {
            displayQuestion(examquestioncount);
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
            displayQuestion(examquestioncount);
            }
            else
            {
                // hier scherm QUIZ KLAAR
            }
        }
    }
}

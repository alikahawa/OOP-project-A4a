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

    UserList userList = UserList.readFromXML("src/Users.xml");
    userList.writeToXML("src/Users.xml");

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
        for (i = 0; i < 9; i++)
        {
            QuestionList tmpq1shuffled = tmpq1.shuffleQuestionList();

            MultiQuestion tmpquestion = (MultiQuestion)shuffleQuestionList().getQ(i);
            
            questionText.setText(tmpquestion.getQuestion());
            answerAText.setText(tmpquestion.getAnswerList().get(0));
            answerBText.setText(tmpquestion.getAnswerList().get(0));
            answerCText.setText(tmpquestion.getAnswerList().get(0));

        }

    }
}

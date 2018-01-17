package GUI;

import Application.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.collections.FXCollections;


public class UITestController {
    int examquestioncount = 0;
    int score = 0;
    ArrayList<Question> tmpq1shuffled;
    ArrayList<UIQuestions> examQuestions;
    QuestionList tmpql;
    int answer;
    UIQuestions tmpquestion;
    int type = 0;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Label questionText;
    @FXML
    private Label scoreCounter;
    private Button abcButton;
    @FXML
    private ImageView progressbar;
    @FXML
    private Button submitDropDown;
    @FXML
    private Button submitCheckBox;
    @FXML
    private javafx.scene.control.CheckBox checkBox1;
    @FXML
    private javafx.scene.control.CheckBox checkBox2;
    @FXML
    private javafx.scene.control.CheckBox checkBox3;

    @FXML
    public void initialize() {

        QuestionList questionList = QuestionList.ReadFromXML("OOP.xml");
        questionList.shuffleQuestionList();
        examQuestions = questionList.getUIList();
        Collections.shuffle(examQuestions);
        System.out.println("Hello world");

        choiceBox.setItems(FXCollections.observableArrayList(
                "New Document", "Open ", "Save", "Save as")
        );

        if (examquestioncount == 0) {
            displayQuestion();
        }
    }

    public void displayQuestion() {
        System.out.println("displaay");
        tmpquestion = examQuestions.get(examquestioncount);
        if (tmpquestion instanceof DropDown) {
            type = 1;
        } else if (tmpquestion instanceof CheckBoxQuestion) {
            type = 2;
        }
        questionText.setText(tmpquestion.getQuestion());
        if (type == 1) {
            checkBox1.setVisible(false);
            checkBox2.setVisible(false);
            checkBox3.setVisible(false);
            submitCheckBox.setVisible(false);

            choiceBox.setVisible(true);
            submitDropDown.setVisible(true);

            choiceBox.setItems(FXCollections.observableArrayList("Select sth", tmpquestion.getAnswerList().get(0), tmpquestion.getAnswerList().get(1), tmpquestion.getAnswerList().get(2)));
            choiceBox.getSelectionModel().selectFirst();
        }

        if(type == 2) {
            checkBox1.setVisible(true);
            checkBox2.setVisible(true);
            checkBox3.setVisible(true);
            submitCheckBox.setVisible(true);

            choiceBox.setVisible(false);
            submitDropDown.setVisible(false);

            checkBox1.setSelected(false);
            checkBox2.setSelected(false);
            checkBox3.setSelected(false);

            checkBox1.setText(tmpquestion.getAnswerList().get(0));
            checkBox2.setText(tmpquestion.getAnswerList().get(1));
            checkBox3.setText(tmpquestion.getAnswerList().get(2));
        }
    }

    public void right() {
        score += 1;
        examquestioncount += 1;
        System.out.println(examquestioncount);
        scoreCounter.setText("Score: " + score + "/" + examquestioncount);
        progressBar();

        // hier scherm GROEN

        // display volgende vraag.
        if (examquestioncount < 10) {
            displayQuestion();
        } else {
            try {
                examDone();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void wrong() {
        // incorrecte antwoord score blijft gelijk
        score = score;
        examquestioncount += 1;
        scoreCounter.setText("Score: " + score + "/" + examquestioncount);
        progressBar();

        // display volgende vraag.
        if (examquestioncount < 10) {
            displayQuestion();
        } else {
            try {
                examDone();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void submitDropDownPressed() throws IOException {
        System.out.println("Button Pressed");
        int choice = choiceBox.getSelectionModel().getSelectedIndex();
        System.out.println(choice);

        DropDown tmpDrop = (DropDown) tmpquestion;
        if ( choice == tmpDrop.getRightAnswer() + 1) {
            right();
        } else if ( choice != 0) {
            wrong();
        }

    }

    public void submitCheckBoxPressed(){
        List<String> givenAnswers = new ArrayList<String>();
        CheckBoxQuestion checkBox = (CheckBoxQuestion)tmpquestion;
        if(checkBox1.isSelected()){
            givenAnswers.add(checkBox1.getText());
        }
        if(checkBox2.isSelected()){
            givenAnswers.add(checkBox2.getText());
        }
        if(checkBox3.isSelected()){
            givenAnswers.add(checkBox3.getText());
        }
        System.out.println(givenAnswers);
        System.out.println(checkBox.checkAnswer(givenAnswers));
        if(checkBox.checkAnswer(givenAnswers)){
            right();
        }
        else{
            wrong();
        }
    }

    public void examDone() throws IOException {
        int Result = score;

        if (Result > 6) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/examPassed.fxml"));
            Parent root = loader.load();
            examDoneController controller = loader.getController();
            controller.setFinalScore(Result);
            submitDropDown.getScene().setRoot(root);
        }
        else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/examFailed.fxml"));
            Parent root = loader.load();
            examDoneController controller = loader.getController();
            controller.setFinalScore(Result);
            submitDropDown.getScene().setRoot(root);
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
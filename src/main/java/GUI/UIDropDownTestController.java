package GUI;

import Application.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.collections.FXCollections;


public class UIDropDownTestController {
    int examquestioncount = 0;
    int score = 0;
    ArrayList<Question> tmpq1shuffled;
    ArrayList<UIQuestions> examQuestions;
    QuestionList tmpql;
    int answer;
    UIQuestions tmpquestion;

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
    private Button submitButton;

    @FXML
    public void initialize() {

        QuestionList questionList = QuestionList.ReadFromXML("OOP.xml");
        questionList.shuffleQuestionList();
        examQuestions = questionList.getDropDownList();
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

        questionText.setText(tmpquestion.getQuestion());

        choiceBox.setItems(FXCollections.observableArrayList("Select sth", tmpquestion.getAnswerList().get(0), tmpquestion.getAnswerList().get(1), tmpquestion.getAnswerList().get(2)));
        choiceBox.getSelectionModel().selectFirst();

//        choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
//                DropDown tmpDrop = (DropDown) tmpquestion;
//                if ((Integer) number2 == tmpDrop.getRightAnswer() + 1) {
//                    right();
//                } else if((Integer) number2 != 0){
//                    wrong();
//                }
//            }
//        });
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

    public void submitButtonPressed() throws IOException {
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

    public void examDone() throws IOException {
        int Result = score;

        if (Result > 6) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/examPassed.fxml"));
            Parent root = loader.load();
            examDoneController controller = loader.getController();
            controller.setFinalScore(Result);
            submitButton.getScene().setRoot(root);
        }
        else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/examFailed.fxml"));
            Parent root = loader.load();
            examDoneController controller = loader.getController();
            controller.setFinalScore(Result);
            submitButton.getScene().setRoot(root);
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
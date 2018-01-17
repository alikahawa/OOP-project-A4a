package GUI;

import Application.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class AddCheckBoxController {

    private QuestionList questionList = QuestionList.ReadFromXML("OOP.xml");

    @FXML
    private TextField answer1;
    @FXML
    private TextField answer2;
    @FXML
    private TextField answer3;
    @FXML
    private javafx.scene.control.CheckBox checkAnswer1;
    @FXML
    private javafx.scene.control.CheckBox checkAnswer2;
    @FXML
    private javafx.scene.control.CheckBox checkAnswer3;
    @FXML
    private TextArea questionText;
    @FXML
    private Button saveButton;


    @FXML
    public void initialize() {
    }

    public void addQuestion() {
        List<String> answers = new ArrayList<String>();
        List<String> rightAnswers = new ArrayList<String>();
        answers.add(answer1.getText());
        answers.add(answer2.getText());
        answers.add(answer3.getText());

        if (checkAnswer1.isSelected()) {
            rightAnswers.add(answer1.getText());
        }

        if (checkAnswer2.isSelected()) {
            rightAnswers.add(answer2.getText());
        }

        if (checkAnswer3.isSelected()) {
            rightAnswers.add(answer3.getText());
        }

        CheckBoxQuestion checkBoxQuestion = new CheckBoxQuestion(rightAnswers, answers, questionText.getText());
        System.out.println(checkBoxQuestion.getAnswerList() + "\n" + checkBoxQuestion.getRightAnswerList() + "\n" + checkBoxQuestion.getQuestion());

        questionList.add(checkBoxQuestion);
        questionList.WriteToXML("OOP.xml");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("The question is added!");

        Optional<ButtonType> result = alert.showAndWait();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teacherpage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TestSelectorController controller = loader.getController();
        saveButton.getScene().setRoot(root);

    }

    public void goBack(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teacherpage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TestSelectorController controller = loader.getController();
        saveButton.getScene().setRoot(root);
    }

}
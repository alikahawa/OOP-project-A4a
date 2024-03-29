package GUI;

import Application.DropDown;
import Application.QuestionList;
import Application.UITextQuestion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


public class AddUITextController {

    private QuestionList questionList = QuestionList.ReadFromXML("OOP.xml");

    @FXML
    private TextField rightAnswer;
    @FXML
    private TextField wrongAnswer1;
    @FXML
    private TextField wrongAnswer2;
    @FXML
    private TextArea questionText;
    @FXML
    private Button saveButton;

    public void addQuestion(){
        List<String> answers = new ArrayList<String>();
        answers.add(wrongAnswer1.getText());
        answers.add(wrongAnswer2.getText());
        answers.add(rightAnswer.getText());
        Collections.shuffle(answers);
        int index = answers.indexOf(rightAnswer.getText());
        UITextQuestion uiTextQuestion = new UITextQuestion(index, answers, questionText.getText());
        System.out.println(uiTextQuestion.getAnswerList() + "\n" + uiTextQuestion.getRightAnswer() + "\n" + uiTextQuestion.getQuestion());

        questionList.add(uiTextQuestion);
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
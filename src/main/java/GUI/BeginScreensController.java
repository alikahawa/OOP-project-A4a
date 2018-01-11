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


public class BeginScreensController {

    @FXML
    private Button start;
    @FXML
    private Button login;
    @FXML
    private Button createAccount;
    @FXML
    private Button createAccount_student;
    @FXML
    private Button createAccount_teacher;
    @FXML
    private Button createAccount_finished;

    public void fromWelcomeToLoginScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Loginpage1.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        start.getScene().setRoot(root);
    }

    public void createAccountButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Userchoice3.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        createAccount.getScene().setRoot(root);
    }

    public void createAccountButton_student() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CreateAccount_simple.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        createAccount_student.getScene().setRoot(root);
    }

    public void createAccountButton_teacher() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CreateAccount_simple.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        createAccount_teacher.getScene().setRoot(root);
    }

    public void createAccount_finished() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teacher_authentication.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        createAccount_finished.getScene().setRoot(root);
    }

    public void loginButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Difficultyselectionpage.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        login.getScene().setRoot(root);
    }
}
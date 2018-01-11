package GUI;

import Application.MultiQuestion;
import Application.Question;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;


public class BeginScreensController {

    @FXML private Button start;
    @FXML private Button login;
    @FXML private Button createAccount;
    @FXML private Button createAccount_student;
    @FXML private Button createAccount_teacher;
    @FXML private Button createAccount_finished_student;
    @FXML private Button createAccount_finished_teacher;
    @FXML private Button succesfully_created_account;
    @FXML private Button finishedAuthenticationTeacher;
    @FXML private TextField firstname;
    @FXML private Button user_choice_cancel;
    @FXML private Button createAccountStudentCancel;
    @FXML private Button createAccountTeacherCancel;


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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CreateAccount_student.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        createAccount_student.getScene().setRoot(root);
    }
    public void createAccountButton_teacher() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CreateAccount_teacher.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        createAccount_teacher.getScene().setRoot(root);
    }
    public void createAccount_button_finished_student() throws IOException {
        System.out.println(firstname.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/createAccountSuccesfully.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        createAccount_finished_student.getScene().setRoot(root);

    }
    public void createAccount_button_finished_teacher() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teacher_authentication.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        createAccount_finished_teacher.getScene().setRoot(root);
    }
    public void succesfullyAccountToLoginScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Loginpage1.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        succesfully_created_account.getScene().setRoot(root);
    }
    public void finishedAuthenticationTeacherButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/createAccountSuccesfully.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        finishedAuthenticationTeacher.getScene().setRoot(root);
    }
    public void userChoiceCancelButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Loginpage1.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        user_choice_cancel.getScene().setRoot(root);
    }
    public void createAccountStudentCancelButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Loginpage1.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        createAccountStudentCancel.getScene().setRoot(root);
    }
    public void createAccountTeacherCancelButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Loginpage1.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        createAccountTeacherCancel.getScene().setRoot(root);
    }





}


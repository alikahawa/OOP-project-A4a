package GUI;

import Application.MultiQuestion;
import Application.Question;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;


public class StudentProfilecontroller {
    @FXML private Button ToExams;
    @FXML private Button Logout;
    @FXML private Button Edit;
    @FXML private CheckBox  username;
    @FXML private CheckBox  password;
    @FXML private CheckBox  emailaddress;
    @FXML private TextField usernametext;
    @FXML private TextField passwordtext;
    @FXML private TextField emailAddresstext;


        /*
    Logout and go to welcome screen
     */

    public void backToWelcome() throws IOException {
        System.out.println("Text-based test is being loaded");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Welcome1.fxml"));
        Parent root = loader.load();
        Logout.getScene().setRoot(root);
    }

    /*
    Navigate to the exams
     */

    public void goToExams() throws IOException {
        System.out.println("Text-based test is being loaded");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Difficultyselectionpage.fxml"));
        Parent root = loader.load();
        ToExams.getScene().setRoot(root);
    }

    /*
    Still need to connect the database with the text fields

     */



}


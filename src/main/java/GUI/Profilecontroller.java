package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.io.IOException;


public class Profilecontroller {
    @FXML private Button ToExamsTeacher;
    @FXML private Button Logout;
    @FXML private Button ToExamsStudent;

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

    public void goToExamsTeacher() throws IOException {
        System.out.println("Text-based test is being loaded");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teacherpage.fxml"));
        Parent root = loader.load();
        ToExamsTeacher.getScene().setRoot(root);
    }
    public void goToExamsStudent() throws IOException {
        System.out.println("Text-based test is being loaded");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Studentpage.fxml"));
        Parent root = loader.load();
        ToExamsStudent.getScene().setRoot(root);
    }

    /*
    Still need to connect the database with the text fields

     */



}


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


public class Teacheraddcontroller {
    @FXML private Button mypage;
    @FXML private Button addtextquestion;
    @FXML private Button addimage;
    @FXML private Button back;

    /*
    This method will make the butoon add text question navigate the teacher to the screen where
    the question can be added
     */
    public void fromTeacheraddToAddquestion() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Addquestion.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        addtextquestion.getScene().setRoot(root);
    }

    /*
    This method is for the add image button, It will navigate the teacher to another screen where he/she can upload
    a picture and then add a question on it
     */
    public void ToAddimage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Loginpage1.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        addimage.getScene().setRoot(root);
    }

    /*
    This method is foe the mypage button, it will navigate the user to his/her page
     */
    public void Tomypage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teacherpage.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        mypage.getScene().setRoot(root);
    }

    /*
    Get back to the login screen (( Need to be disscused ))
     */
    public void backtoLoginscreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Loginpage1.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        back.getScene().setRoot(root);
    }
}

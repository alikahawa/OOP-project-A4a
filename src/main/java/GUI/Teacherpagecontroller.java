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


public class Teacherpagecontroller {

    @FXML private Button mypage;
    @FXML private Button buttonn;
    @FXML private Button back;
    @FXML private Button logout;


    /*
    This method is for the button My page , it will refresh My page screen(namely get back to it).
     */
    public void Tomypage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teacherpage.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        mypage.getScene().setRoot(root);
    }
    /*
    This method is for the back button,(( Disscuss whether it should stay and where should it navigate ))
     */
    public void backtoLoginscreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Loginpage1.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        back.getScene().setRoot(root);
    }
    /*
    Log out button will take you back to the welcome screen
     */
    public void BackToWelcome() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Welcome1.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        logout.getScene().setRoot(root);
    }


}



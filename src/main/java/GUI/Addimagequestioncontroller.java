package GUI;

import Application.MultiQuestion;
import Application.Question;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;


public class Addimagequestioncontroller {

    @FXML private Button mypage;
    @FXML private Button save;
    @FXML private Button logout;
    @FXML private Button cancel;
    @FXML private TextArea Questiontext;
    @FXML private TextField answertext;
    @FXML private TextField answertext1;
    @FXML private TextField answertext2;
    @FXML private TextField answertext3;


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
    Button cancel will cancel the operation and navigate back to teacher add screen
     */
    public void CancelbacktoTeacheradd() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teacheradd.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        cancel.getScene().setRoot(root);
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

     /*
   We need to use the write methode for the textfields and the textarea to save the given text to the database
    */

}

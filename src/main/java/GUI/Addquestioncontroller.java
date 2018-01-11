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

public class Addquestioncontroller {
    @FXML private TextArea Questiontext;
    @FXML private TextField answertext;
    @FXML private TextField answertext1;
    @FXML private TextField answertext2;
    @FXML private TextField answertext3;
    @FXML private Button savequestion;
    @FXML private Button cancelback;

   /*
   We need to use the write methode for the textfields and the textarea to save the given text to the database
    */

    public void CancelbacktoTeacheradd() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teacheradd.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        cancelback.getScene().setRoot(root);
    }

}

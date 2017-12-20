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


public class Controller {

    @FXML private Button start;
    @FXML private Button login;
    @FXML private Label testlabel;

    public void fromWelcomeToMainScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main1.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        start.getScene().setRoot(root);
    }

    public void logInClick()
    {
        ArrayList<String> al = new ArrayList<>();
        Question q = new MultiQuestion(1,al,"some question?");
        setLabel(q.getQuestion());
    }

    public void setLabel(String i)
    {
        testlabel.setText(i);
    }


}

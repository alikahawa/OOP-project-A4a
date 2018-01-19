package GUI;

import Application.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;



public class BeginScreensController {

    @FXML private Button start;
    @FXML private Button login;
    @FXML private Button createAccount;
    @FXML private TextField EMail;
    @FXML private PasswordField Password;
    @FXML private Label msglb;


    private UserList userList;

    public void fromWelcomeToLoginScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Loginpage1.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        start.getScene().setRoot(root);
    }

    public void createAccountButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Userchoice3.fxml"));
        Parent root = loader.load();
        CreateAccountController controller = loader.getController();
        createAccount.getScene().setRoot(root);
    }

    @FXML
    protected void initialize()
    {
        this.userList = UserList.readFromXML("src/Users.xml");
    }

    public void loginButton() throws IOException {
        String givenMail = EMail.getText();
        String givenPassword = Password.getText();
        User tmpu = userList.getUser(givenMail);

        System.out.println();
        System.out.println();
        if (tmpu != null)
        {
            if (tmpu.CheckPassword(givenPassword))
            {
                if (userList.getUser(givenMail) instanceof Teacher) {
                    msglb.setText("");
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teacherpage.fxml"));
                    Parent root = loader.load();
                    TestSelectorController controller = loader.getController();
                    login.getScene().setRoot(root);
                }
                else if (userList.getUser(givenMail) instanceof Student){
                    msglb.setText("");
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Studentpage.fxml"));
                    Parent root = loader.load();
                    TestSelectorController controller = loader.getController();
                    login.getScene().setRoot(root);
                }
                else {
                    msglb.setText("You are not a user or a teacher, maybe transgender?");
                }
            }
            else
            {
                // say the password is wrong
                msglb.setText("The password was wrong");
            }
        }
        else
        {
            // Say the user doesn't exist
            msglb.setText("This user does not exist");
        }
    }

}
package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class CreateAccountController {

    @FXML private Button createAccount_student;
    @FXML private Button createAccount_teacher;
    @FXML private Button createAccount_finished_student;
    @FXML private Button createAccount_finished_teacher;
    @FXML private Button succesfully_created_account;
    @FXML private Button finishedAuthenticationTeacher;
    @FXML private TextField firstnameStudent;
    @FXML private TextField lastnameStudent;
    @FXML private TextField mailaddressStudent;
    @FXML private TextField firstnameTeacher;
    @FXML private TextField lastnameTeacher;
    @FXML private TextField mailaddressTeacher;
    @FXML private Button user_choice_cancel;
    @FXML private Button createAccountStudentCancel;
    @FXML private Button createAccountTeacherCancel;
    @FXML private Text warningPromptStudent;
    @FXML private Text warningPromptTeacher;
    @FXML private Text authenticationPrompt;
    @FXML private TextField authenticationPassword;

    public void createAccountButton_student() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CreateAccount_student.fxml"));
        Parent root = loader.load();
        CreateAccountController controller = loader.getController();
        createAccount_student.getScene().setRoot(root);
    }
    public void createAccountButton_teacher() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/CreateAccount_teacher.fxml"));
        Parent root = loader.load();
        CreateAccountController controller = loader.getController();
        createAccount_teacher.getScene().setRoot(root);
    }

    /**
     * createAccount_button_finished_student checks if the first and last name has at least 1 character and mail address is in the format
     * something@something.something so the @ and . are necessary
     * @throws IOException
     */
    public void createAccount_button_finished_student() throws IOException {
        //System.out.println(firstname.getText());

        if (firstnameStudent.getText().isEmpty() || !firstnameStudent.getText().matches("[A-Za-z0-9_]+")){
            warningPromptStudent.setText("Please only use letters and numbers for first name");
        }
        else if (lastnameStudent.getText().isEmpty() || !lastnameStudent.getText().matches("[A-Za-z0-9_]+")){
            warningPromptStudent.setText("Please only use letters and numbers for last name");
        }
        else if (mailaddressStudent.getText().isEmpty() || !mailaddressStudent.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            warningPromptStudent.setText("Please use a valid mail address");
        }
        else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/createAccountSuccesfully.fxml"));
            Parent root = loader.load();
            CreateAccountController controller = loader.getController();
            createAccount_finished_student.getScene().setRoot(root);
        }
    }
    public void createAccount_button_finished_teacher() throws IOException {
        if (firstnameTeacher.getText().isEmpty() || !firstnameTeacher.getText().matches("[A-Za-z0-9_]+")){
            warningPromptTeacher.setText("Please only use letters and numbers for first name");
        }
        else if (lastnameTeacher.getText().isEmpty() || !lastnameTeacher.getText().matches("[A-Za-z0-9_]+")){
            warningPromptTeacher.setText("Please only use letters and numbers for last name");
        }
        else if (mailaddressTeacher.getText().isEmpty() || !mailaddressTeacher.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            warningPromptTeacher.setText("Please use a valid mail address");
        }
        else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teacher_authentication.fxml"));
            Parent root = loader.load();
            CreateAccountController controller = loader.getController();
            createAccount_finished_teacher.getScene().setRoot(root);
        }
    }
    public void succesfullyAccountToLoginScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Loginpage1.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        succesfully_created_account.getScene().setRoot(root);
    }
    public void finishedAuthenticationTeacherButton() throws IOException {
        if (authenticationPassword.getText().equals("just merge it")){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/createAccountSuccesfully.fxml"));
            Parent root = loader.load();
            CreateAccountController controller = loader.getController();
            finishedAuthenticationTeacher.getScene().setRoot(root);
        }
        else {
            authenticationPrompt.setText("Onjuist wachtwoord, misschien moet het juiste wachtwoord geheim blijven, maar jij mag het wel" +
                    "weten, het wachtwoord is: just merge it");
        }


    }
    public void userChoiceCancelButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Loginpage1.fxml"));
        Parent root = loader.load();
        CreateAccountController controller = loader.getController();
        user_choice_cancel.getScene().setRoot(root);
    }
    public void createAccountStudentCancelButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Loginpage1.fxml"));
        Parent root = loader.load();
        CreateAccountController controller = loader.getController();
        createAccountStudentCancel.getScene().setRoot(root);
    }
    public void createAccountTeacherCancelButton() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Loginpage1.fxml"));
        Parent root = loader.load();
        CreateAccountController controller = loader.getController();
        createAccountTeacherCancel.getScene().setRoot(root);
    }
}

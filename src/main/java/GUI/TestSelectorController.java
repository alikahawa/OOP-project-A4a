package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.io.IOException;


public class TestSelectorController {

    @FXML private Button TextBasedExamButton;
    @FXML private Button ClickablePictureBasedExamButton;
    @FXML private Button UIBasedExamButton;
    @FXML private Button back;
    @FXML private Button mypage;
    @FXML private Button addDropDownButton;
    @FXML private Button addCheckBoxButton;
    @FXML private Button mypageteacher;

    public void goToStartOfTextBasedTest() throws IOException {
        System.out.println("Text-based test is being loaded");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/TextExam.fxml"));
        Parent root = loader.load();
        TextTestController controller = loader.getController();
        TextBasedExamButton.getScene().setRoot(root);
    }
  
    public void goToStartOfClickablePictureBasedTest() throws IOException {
        System.out.println("ClickablePicture-based test is being loaded");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ClickablePictureExam.fxml"));
        Parent root = loader.load();
        ClickablePictureTestController controller = loader.getController();
        ClickablePictureBasedExamButton.getScene().setRoot(root);
    }
    /*
    Back to Login screen
     */

    public void backToLogin() throws IOException {
        System.out.println("Text-based test is being loaded");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Loginpage1.fxml"));
        Parent root = loader.load();
        BeginScreensController controller = loader.getController();
        back.getScene().setRoot(root);
    }

    /*
    Navigate to student profile
     */

    public void goToMypagestudent() throws IOException {
        System.out.println("Text-based test is being loaded");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/StudentProfile.fxml"));
        Parent root = loader.load();
        Profilecontroller controller = loader.getController();
        mypage.getScene().setRoot(root);
    }
    public void goToMypageteacher() throws IOException {
        System.out.println("Text-based test is being loaded");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/TeacherProfile.fxml"));
        Parent root = loader.load();
        Profilecontroller controller = loader.getController();
        mypageteacher.getScene().setRoot(root);
    }

	public void goToStartOfUITest() throws IOException {
        System.out.println("Text-based test is not being loaded");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/UIExam.fxml"));
        Parent root = loader.load();
        UITestController controller = loader.getController();
        UIBasedExamButton.getScene().setRoot(root);
    }

    public void addDropDown() throws IOException {
        System.out.println("Text-based test is not being loaded");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AddDropDown.fxml"));
        Parent root = loader.load();
        AddDropDownController controller = loader.getController();
        addDropDownButton.getScene().setRoot(root);
    }
    public void addCheckBox() throws IOException {
        System.out.println("Text-based test is not being loaded");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AddCheckBox.fxml"));
        Parent root = loader.load();
        AddCheckBoxController controller = loader.getController();
        addCheckBoxButton.getScene().setRoot(root);
    }

}

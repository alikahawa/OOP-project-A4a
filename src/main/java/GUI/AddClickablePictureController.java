package GUI;

import Application.MultiQuestion;
import Application.PictureQuestion;
import Application.QuestionList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;


public class AddClickablePictureController {

    private QuestionList questionList = QuestionList.ReadFromXML("OOP.xml");

    @FXML
    private TextArea questionText;
    @FXML
    private Button uploadImageButton;
    @FXML
    private Button saveButton;
    @FXML
    private ImageView questionPicture;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button clickButtonXY;

    private String uploadedImage;
    private int mousex;
    private int mousey;
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    int teller;


    public void addQuestion(){
        if (uploadedImage != null)
        {
            PictureQuestion pictureQuestion = new PictureQuestion(questionText.getText(), uploadedImage, x1,x2,y1,y2);
            questionList.add(pictureQuestion);
            questionList.WriteToXML("OOP.xml");

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("The question is added!");

            Optional<ButtonType> result = alert.showAndWait();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teacherpage.fxml"));
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            TestSelectorController controller = loader.getController();
            saveButton.getScene().setRoot(root);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Add a picture to your question!");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    public void goBack(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Teacherpage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        TestSelectorController controller = loader.getController();
        saveButton.getScene().setRoot(root);
    }

    public void uploadImage() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Picture");

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();

        Path extra = Paths.get(s + "\\src\\main\\resources\\images");
        s = extra.toAbsolutePath().toString();

        fileChooser.setInitialDirectory(
                new File(s)
            );

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
            );

        File tmp = fileChooser.showOpenDialog(saveButton.getScene().getWindow());

        String name =  new Date().toString().replaceAll(" ", "").replaceAll(":", "");
        File tmp2 = new File(s + "\\" + name);
        tmp2.getParentFile().mkdirs();
        tmp2.createNewFile();

        Path tmp3 = Paths.get(tmp.getAbsolutePath());
        Path tmp4 = Paths.get(tmp2.getAbsolutePath());

        System.out.println("Path source is: " + tmp3.toString());
        System.out.println("Path destination is: " + tmp4.toString());

        CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
        };
        try {
            Files.copy(tmp3, tmp4, options);
        } catch (final DirectoryNotEmptyException dnee) {
        }

        tmp3.toAbsolutePath();
        tmp4.toAbsolutePath();

        uploadedImage = "file:///" + tmp4.toString().replace("\\", "/");
        Image image2 = new Image(uploadedImage);
        questionPicture.setImage(image2);

        uploadedImage = "images\\" + name;

        getTopLeft();

        System.out.println("HOI");
    }

    public void getTopLeft() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Click top left corner of correct part");

        Optional<ButtonType> result = alert.showAndWait();

        questionPicture.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                mousex = (int) Math.floor(mouseEvent.getX() - questionPicture.getX());
                mousey = (int) Math.floor(mouseEvent.getY() - questionPicture.getY());

                x1 = mousex;
                y1 = mousey;
                getLowerRight();
                System.out.println("x1 is: " + x1 + " y1 is: " + y1);
            }
        });
    }

    public void getLowerRight() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Click bottom right corner of correct part");

        Optional<ButtonType> result = alert.showAndWait();

        questionPicture.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                mousex = (int) Math.floor(mouseEvent.getX() - questionPicture.getX());
                mousex = (int) Math.floor(mouseEvent.getX());
                mousey = (int) Math.floor(mouseEvent.getY() - questionPicture.getY());
                mousey = (int) Math.floor(mouseEvent.getY());

                x2 = mousex;
                y2 = mousey;

                System.out.println("x2 is: " + x2 + " y2 is: " + y2);

                clickButtonXY.setPrefHeight(y2 - y1);
                clickButtonXY.setPrefWidth(x2 - x1);
                clickButtonXY.setLayoutX(x1 + questionPicture.getX()+ 14);
                clickButtonXY.setLayoutY(y1 + questionPicture.getY()+ 55);
            }
        });
    }
}
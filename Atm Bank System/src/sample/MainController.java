package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {


    @FXML
    private PasswordField password;

    @FXML
    private TextField user;

    @FXML
    private RadioButton rdbtnuser;

    @FXML
    private RadioButton rdbtnadmin;

    @FXML
    private Label label;
    public static Stage stage=new Stage(); //static to close the stage

    @FXML
    public void openAbout(ActionEvent event) throws IOException {
        stage.close();
        stage.setTitle("About");
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("About.fxml"));
        Parent parent=(Parent) fxmlLoader.load();

        stage.setResizable(false);
        stage.setScene(new Scene(parent));
        stage.show();
    }
    @FXML
    public   void close(ActionEvent event)throws IOException {
        stage.close();
    }
    @FXML
    public void makeLogin(ActionEvent event) throws IOException {
        LoginSystem object=new LoginSystem();
        LoginSystem.username =user.getText();
        object.pass=password.getText();
        if (user.getText().isEmpty()&&password.getText().isEmpty()){
            label.setText("Enter Your Information To Login");
            return;
        }
        if(rdbtnuser.isSelected()){
            object.logIn(LoginSystem.username,object.pass,"Users.txt");
            if(object.found)
            {
                label.setText("Login Successful!");
                Parent userlogparent = FXMLLoader.load(getClass().getResource("UserMainPage.fxml"));
                Scene  userlogscene = new Scene(userlogparent);
                Stage  userwindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
                userwindow.setScene(userlogscene);
                userwindow.getIcons().add(new Image("sample\\pics\\bank_60px.png"));
                userwindow.setTitle("User Main Page");
                userwindow.setResizable(false);
                userwindow.show();
            }else {
                label.setText("        Login failed Try Again!");
            }
        }
        else if(rdbtnadmin.isSelected()) {
            object.logIn(LoginSystem.username,object.pass,"Admins.txt");
            if (object.found) {
                label.setText("Login Successful!");
                Parent adminlogparent = FXMLLoader.load(getClass().getResource("AdminMainpage.fxml"));
                Scene  adminlogscene = new Scene(adminlogparent);
                Stage  adminwindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
                adminwindow.setScene(adminlogscene);
                adminwindow.getIcons().add(new Image("sample\\pics\\bank_60px.png"));
                adminwindow.setTitle("Admin Main Page");
                adminwindow.setResizable(false);
                adminwindow.show();

            }else {
                label.setText("Login failed!!\ntry Again!");
        }
        }
    }

}

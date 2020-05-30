package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UserLoginController extends MainController {
    @FXML
    public  Label  userlabel;
    static   Stage  stage = new Stage();//to close Stage popup without stacking
    @FXML
    public void makeChangePassButton(ActionEvent event) throws IOException {
        stage.setTitle("Change Password");
        stage.close();
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("UserChangePassword.fxml"));
        Parent parent=(Parent) fxmlLoader.load();
        stage.setScene(new Scene(parent));
        stage.setResizable(false);
        stage.getIcons().add(new Image("sample\\pics\\bank_60px.png"));
        stage.show();
    }
    @FXML
    public void makeCheckBalButton(ActionEvent event) throws IOException {
        stage.setTitle("Balance Check");
        stage.close();
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("UserCheckBalance.fxml"));
        Parent parent=(Parent) fxmlLoader.load();
        stage.setScene(new Scene(parent));
        stage.setResizable(false);
        stage.getIcons().add(new Image("sample\\pics\\bank_60px.png"));
        stage.show();
    }
    @FXML
    public void makeDepositButton(ActionEvent event) throws IOException {
        stage.setTitle("Deposit");
        stage.close();
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("UserDepositmoney.fxml"));
        Parent parent=(Parent) fxmlLoader.load();
        stage.setScene(new Scene(parent));
        stage.getIcons().add(new Image("sample\\pics\\bank_60px.png"));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void makeInfoButton(ActionEvent event) throws IOException {
        stage.setTitle("Information");
        stage.close();
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("Userinformation.fxml"));
        Parent parent=(Parent) fxmlLoader.load();
        stage.setScene(new Scene(parent));
        stage.getIcons().add(new Image("sample\\pics\\bank_60px.png"));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void makeWithdrawButton(ActionEvent event) throws IOException {
        stage.setTitle("Withdraw");
        stage.close();
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("UserWithdrawPage.fxml"));
        Parent parent=(Parent) fxmlLoader.load();
        stage.setScene(new Scene(parent));
        stage.getIcons().add(new Image("sample\\pics\\bank_60px.png"));
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    public void makeTransferButton(ActionEvent event) throws IOException {
        stage.setTitle("Transfer Money");
        stage.close();
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("UserTransferMoney.fxml"));
        Parent parent=(Parent) fxmlLoader.load();
        stage.setScene(new Scene(parent));
        stage.getIcons().add(new Image("sample\\pics\\bank_60px.png"));
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    public void goBack(ActionEvent event) throws IOException {
        Parent loginparent = FXMLLoader.load(getClass().getResource("MainLoginPage.fxml"));
        Scene  loginscene = new Scene(loginparent);
        Stage  loginwindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        loginwindow.setScene(loginscene);
        loginwindow.setTitle("ATM Bank System");
        loginwindow.getIcons().add(new Image("sample\\pics\\bank_60px.png"));
        loginwindow.setResizable(false);
        loginwindow.show();
    }
    public void close(ActionEvent event) throws IOException {
        stage.close();
    }
    @FXML
    public void makeLabel(MouseEvent event) throws FileNotFoundException {
        User object =new User();
        object.userInformation();
        userlabel.setText("Welcome "+object.usernameinfo.toUpperCase());
    }
}

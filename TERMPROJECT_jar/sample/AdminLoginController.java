package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AdminLoginController extends MainController {
    public static   Stage  stage = new Stage(); //to close Stage popup without stacking
    @FXML
    private TableView<TableVariables> UserTable;
    @FXML
    private TableColumn<TableVariables,String>IDcolumn;
    @FXML
    private TableColumn<TableVariables,String>namecolumn;
    @FXML
    private  TableColumn<TableVariables,String>Passwordcolumn;
    @FXML
    private TableColumn<TableVariables,String>Balancecolumn;
    @FXML
    private Label adminname;
    @FXML
    private Label adminid;

    @FXML
    public  void deleteUserButton(ActionEvent event) throws IOException {
        stage.close();
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("AdminRemoveUsers.fxml"));
        Parent parent=(Parent) fxmlLoader.load();
        stage.setScene(new Scene(parent));
        stage.getIcons().add(new Image("sample\\pics\\bank_60px.png"));
        stage.setTitle("Delete User");
        stage.setResizable(false);
        stage.show();
    }
    @FXML
    public void LoadUserInformation(ActionEvent event) throws IOException {
        Parent adminlogparent = FXMLLoader.load(getClass().getResource("AdminInfomationTable.fxml"));
        Scene  adminlogscene = new Scene(adminlogparent);
        Stage  adminwindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        adminwindow.setScene(adminlogscene);
        adminwindow.getIcons().add(new Image("sample\\pics\\bank_60px.png"));
        adminwindow.setTitle("User Information");
        adminwindow.show();

    }
    @FXML
    public void resetPasswordButton(ActionEvent event) throws IOException {
        stage.close();
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("AdminPasswordChange.fxml"));
        Parent parent=(Parent) fxmlLoader.load();
        stage.setScene(new Scene(parent));
        stage.getIcons().add(new Image("sample\\pics\\bank_60px.png"));
        stage.setTitle("Password Rest");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void LoadTable(ActionEvent event) throws Exception {
        AdminAccess object=new AdminAccess();
        IDcolumn.setMinWidth(100);
        IDcolumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        namecolumn.setMinWidth(100);
        namecolumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        Passwordcolumn.setMinWidth(100);
        Passwordcolumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        Balancecolumn.setMinWidth(100);
        Balancecolumn.setCellValueFactory(new PropertyValueFactory<>("Balance"));
        UserTable.setItems(object.tab());
    }

    @FXML
    public void makeAddButton(ActionEvent event) throws IOException {
        stage.close();
        FXMLLoader fxmlLoader =new FXMLLoader(getClass().getResource("AdminAddUsers.fxml"));
        Parent parent=(Parent) fxmlLoader.load();
        stage.setScene(new Scene(parent));
        stage.getIcons().add(new Image("sample\\pics\\bank_60px.png"));
        stage.setTitle("Add User");
        stage.setResizable(false);
        stage.show();

    }
    @FXML
    public void goBackAdmin(ActionEvent event) throws IOException {
        Parent adminparent = FXMLLoader.load(getClass().getResource("AdminMainpage.fxml"));
        Scene  adminscene = new Scene(adminparent);
        Stage  adminwindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        adminwindow.setScene(adminscene);
        adminwindow.getIcons().add(new Image("sample\\pics\\bank_60px.png"));
        adminwindow.setTitle("Admin Main Page");
        adminwindow.setResizable(false);

        adminwindow.show();
    }
    @FXML
    public void goBack(ActionEvent event) throws IOException {
        Parent adminparent = FXMLLoader.load(getClass().getResource("MainLoginPage.fxml"));
        Scene  adminscene = new Scene(adminparent);
        Stage adminwindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

        adminwindow.getIcons().add(new Image("sample\\pics\\bank_60px.png"));
        adminwindow.setTitle("ATM Bank System");
        adminwindow.setScene(adminscene);
        adminwindow.setResizable(false);
        adminwindow.show();
    }
    @FXML
    public void makeLabel(MouseEvent event) throws FileNotFoundException {
        LoginSystem object =new User();
        ((User) object).userInformation();
        adminname.setText(((User) object).usernameinfo.toUpperCase());
        adminid.setText(((User) object).useridinfo);
    }
}
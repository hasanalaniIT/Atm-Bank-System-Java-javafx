package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.io.IOException;

public class AdminPageController extends AdminLoginController {
    @FXML
    private TextField removeuserid;

    @FXML
    private Label removelabel;

    @FXML
    private Label removelabel1;

    @FXML
    private TextField addusername;

    @FXML
    private PasswordField adduserpass;

    @FXML
    private Label signuplabel;

    @FXML
    private Label signuplabel2;

    @FXML
    private PasswordField newpass;

    @FXML
    private PasswordField passretype;

    @FXML
    private Label changepassconf;
    @FXML
    private Label changepassconf1;

    @FXML
    private TextField useridpass;

    @FXML
    public void deleteUserButton(ActionEvent event) throws IOException {
    AdminAccess access=new AdminAccess();

    if (removeuserid.getText().isEmpty()||removeuserid.getText().equals("")){
        removelabel1.setText("");
        removelabel.setText("Please Enter User Id!");
        return;
    }
    if (!removeuserid.getText().matches("[0-9]+")) {
            removelabel1.setText("");
            removelabel.setText("Enter User Id!");
             return;
        }


        access.sendIdToFile(removeuserid.getText());
        access.removeUser();
        if (access.idnullcheck){
            removelabel1.setText("");
            removelabel.setText("User Id Not Found Or Available!");

        }else {
            removelabel.setText("");
            removelabel1.setText("User Successfully Removed");
        }

    }

    @FXML
    public void resetPasswordButton(ActionEvent event) throws IOException {
    AdminAccess ob=new AdminAccess();
    if (!passretype.getText().equals(newpass.getText())){
        changepassconf1.setText("");
        changepassconf.setText("Password Does Not Match!!");
        return;
    }
    else if (useridpass.getText().isEmpty()||newpass.getText().isEmpty()||passretype.getText().isEmpty()){
        changepassconf1.setText("");
        changepassconf.setText("Please Enter Information!!");
        return;
    } else if (useridpass.getText().contains(" ")||passretype.getText().contains(" ")){
        changepassconf1.setText("");
        changepassconf.setText("Do Not Enter Space!");
        return;
    }
    else
            ob.sendIdToFile(useridpass.getText());
            ob.changeUserPassword(newpass.getText());
            if (ob.passwordequlcheck) {
                changepassconf1.setText("");
                changepassconf.setText("Password Already Available!!");
                return;
            }
            if (ob.idnotequlcheck){
                changepassconf1.setText("");
                changepassconf.setText("User Id Not Available!!");
            }   else {

                changepassconf.setText("");
                changepassconf1.setText("Password Changed Successfully");
            }

    }

    @FXML
    public void makeAddButton(ActionEvent event) throws IOException {
        LoginSystem object= new LoginSystem();
        if (addusername.getText().contains(" ")||adduserpass.getText().contains(" ")) {
            signuplabel2.setText("");
            signuplabel.setText("Do not Enter Space");
            return;
        }
        LoginSystem.username = addusername.getText();
        object.pass= adduserpass.getText();
        object.signUp(LoginSystem.username, object.pass);

       if (object.nullcatcher){
            signuplabel2.setText("");
            signuplabel.setText("Please Enter Information!!");
        }else if (object.signup) {
            signuplabel.setText("");
            signuplabel2.setText("User Added Successfully");
           }else {
            signuplabel2.setText("");
            signuplabel.setText("User Already Registered!!");
           }
    }
    @FXML
    public void goBack(ActionEvent event) {
        AdminLoginController.stage.close();
    }

}

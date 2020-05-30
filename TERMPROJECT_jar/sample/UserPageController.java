package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UserPageController extends UserLoginController {

    @FXML
    private TextField withdrawamount;

    @FXML
    private Label withdrawinfo;

    @FXML
    private TextField depositamount;

    @FXML
    private TextField uid;

    @FXML
    private TextField uname;

    @FXML
    private TextField ubalance;
    @FXML
    private TextField receiverid;

    @FXML
    private TextField trnasamount;

    @FXML
    private Label transferinfo;

    @FXML
    private Label transferconf;

    @FXML
    private TextField balance;

    @FXML
    private Label depositinfo;

    @FXML
    private PasswordField oldpass;

    @FXML
    private PasswordField newpass;

    @FXML
    private PasswordField passretype;

    @FXML
    private Label changepassconf;
    @FXML
    private Label changepassconf1;

    @FXML
    public void makeChangePassButton(ActionEvent event) throws IOException {
        User object=new User();
        passretype.getText();
          if (!passretype.getText().equals(newpass.getText())){
              changepassconf1.setText("");
              changepassconf.setText("Password Does Not Match!!");
            return;
        } else if (oldpass.getText().isEmpty()||newpass.getText().isEmpty()||passretype.getText().isEmpty()){
            changepassconf1.setText("");
            changepassconf.setText("Please Enter Information!!");
            return;
        }else if (oldpass.getText().contains(" ")||newpass.getText().contains(" ")||passretype.getText().contains(" ")) {
            changepassconf1.setText("");
            changepassconf.setText("Do Not Enter Space!");
            return;
        }
        else
                object.passwordChange(newpass.getText(), oldpass.getText());

                 if (object.oldpasswordcheck){
                    changepassconf1.setText("");
                    changepassconf.setText("Old Password Is Incorrect!!");
                }
                 else if (object.passwordequlcheck) {
                    changepassconf1.setText("");
                    changepassconf.setText("Passwords Are the Same!!"); }
                 else{
                    changepassconf.setText("");
                    changepassconf1.setText("Password Changed Successfully");
                }

    }

    @FXML
    public void makeTransferButton(ActionEvent event) throws IOException {
        AdminAccess object=new AdminAccess();
        User objectuser=new User();
        object.sendIdToFile(receiverid.getText());
        if (receiverid.getText().isEmpty()||trnasamount.getText().isEmpty()){
            transferinfo.setText("");
            transferconf.setText("Please Enter A Valid Information");
            return;
        }if (!trnasamount.getText().matches("[0.0-9]+")){
            transferinfo.setText("");
            transferconf.setText("Please Enter A Valid Information");
            return;
        }if (trnasamount.getText().contains(" ")||receiverid.getText().contains(" ")) {
            transferinfo.setText("");
            transferconf.setText("Please Enter A Valid Information");
            return;
        }
        if ((trnasamount.getText().length() >=7)){
            transferinfo.setText("");
            transferconf.setText("Cant Transfer This Amount");
            return;
        }if (trnasamount.getText().matches("[0.0-0]+")){
            transferinfo.setText("");
            transferconf.setText("Cant Transfer This Amount");
            return;
        }
        objectuser.transferCash(trnasamount.getText());
        if (!objectuser.idnotequlcheck){
            objectuser.withdrawCash(trnasamount.getText());
           if (objectuser.insufficientwithdraw){
                transferinfo.setText("");
                transferconf.setText("Not Enough Balance To Transfer!!\nPlease Try Again With Enough Money");
                return;
            }
            transferconf.setText("");
            transferinfo.setText("Transfer Successful\nYou Have Transferd "+trnasamount.getText()+"$");

        }

        else {
            transferinfo.setText("");
            transferconf.setText("Invalid User Id ");
        }
    }
    @FXML
    public void makeInfoButton(ActionEvent event) throws FileNotFoundException {
        User object=new User();
        object.userInformation();
        uid.setText(object.useridinfo);
        uname.setText(object.usernameinfo);
        ubalance.setText(object.userbalanceinfo);
    }
    @FXML
    public void makeDepositButton(ActionEvent event) throws IOException {
        User object=new User();
    if (depositamount.getText().isEmpty()){
        depositinfo.setText("Please Enter A Valid Amount");
        return;
    }
        if (!depositamount.getText().matches("[0.0-9]+")){
            depositinfo.setText("Please Enter A Valid Amount");
            return;
        }
        if ((depositamount.getText().length() >=7)){
            depositinfo.setText("Cant Deposit This Amount");
            return;
        }if (depositamount.getText().matches("[0.0-0]+"))
        {
            depositinfo.setText("Cant Deposit This Amount");
            return;
        }
        if (depositamount.getText().contains(" ")){
            depositinfo.setText("Please Enter A Valid Amount");
            return;
        }
    object.depositCash(depositamount.getText());
    depositinfo.setText("You Have Deposited "+depositamount.getText()+"$");
    }
    @FXML
    public void makeWithdrawButton(ActionEvent event) throws IOException {
        User object=new User();
        if (withdrawamount.getText().isEmpty()){
            withdrawinfo.setText("Please Enter A Valid Amount!");
            return;
        }
        if (!withdrawamount.getText().matches("[0.0-9]+")) {  //this so the user can enter only numbers
            withdrawinfo.setText("Please Enter A Valid Amount!");
            return;
        }
        if ((withdrawamount.getText().length() >=7)){
            withdrawinfo.setText("Please Enter A Valid Amount");
            return;
        }if (withdrawamount.getText().matches("[0.0-0]+"))
        {
            withdrawinfo.setText("Cant Deposit This Amount");
            return;
        }
        if (withdrawamount.getText().contains(" "))
        {
            withdrawinfo.setText("Cant Deposit This Amount");
            return;
        }

        object.withdrawCash(withdrawamount.getText());

    if (object.insufficientwithdraw){
        withdrawinfo.setText("Not Enough Balance To Withdraw!!\nPlease Try Again With Enough Money");
     }
    else {
        withdrawinfo.setText("Withdraw Successful"+"\nYou Have Withdrawn:"+withdrawamount.getText()+"$");
     }
    }
    @FXML
    void makeCheckBalButton(MouseEvent event) throws IOException {
        User object=new User();
        balance.setText(object.checkBalance()+"$");
    }
    @FXML
    public void goBack(ActionEvent event) {
        UserLoginController.stage.close();
    }

   }

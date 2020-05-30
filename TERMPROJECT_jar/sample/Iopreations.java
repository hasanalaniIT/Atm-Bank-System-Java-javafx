package sample;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Iopreations {
    String checkBalance() throws IOException;
    void depositCash(String amount) throws IOException;
    boolean withdrawCash(String amount) throws IOException;
    void transferCash(String amount) throws IOException;
    void userInformation() throws FileNotFoundException;
    void passwordChange(String newpass,String oldpass) throws IOException;

}

package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public abstract class Admin extends LoginSystem {
    public  boolean passwordequlcheck=false;
    public  boolean idnotequlcheck=false;
    public  boolean idnullcheck=false;

    public abstract void changeUserPassword(String newpass) throws IOException;
    public abstract void sendIdToFile(String userid) throws IOException;
    public abstract void removeUser() throws IOException;

    public ObservableList<TableVariables> tab(){
        ObservableList<TableVariables> atm= FXCollections.observableArrayList();
        File file=new File("Users.txt");
        try {
            Scanner scanner=new Scanner(file);
            while (scanner.hasNext()){
                atm.add(new TableVariables(scanner.next(),scanner.next(),scanner.next(),scanner.next()));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return atm;
    }
}

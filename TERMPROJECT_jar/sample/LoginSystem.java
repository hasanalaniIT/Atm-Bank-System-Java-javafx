package sample;

import java.io.*;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
public class LoginSystem extends Exception {
    public  static String username;
    public  String pass;
    public  static String Id;
    public  String balance;
    public  int rf;
    public  boolean found=false;
    public  boolean signup=false;
    public  boolean nullcatcher=false;

    public  boolean logIn(String key,String value,String filename) throws IOException {
        HashMap<String,String>hashMap=new HashMap<>();
        File users=new File(filename);
        Scanner scanner=new Scanner(users);

        while (scanner.hasNext()){
            Id=scanner.next();
            username=scanner.next();
            pass=scanner.next();
            balance=scanner.next();
            hashMap.put(username,pass);
            if (hashMap.containsKey(key) && hashMap.get(key).compareTo(value)==0  ){
                FileWriter fileWriter=new FileWriter(new File("getId.txt"));
                fileWriter.write(Id);
                fileWriter.close();
                found=true;
                return true;

            }
        }
        return false;
    }
     public  int setRandomId(){
        Random randomNum=new Random();
        return this.rf = randomNum.nextInt(10000-1000)+1000;
        }
     public void signUp(String key,String value) throws IOException {
        File file1=new File("Users.txt");
        FileWriter writer=new FileWriter(file1,true);
        Scanner scanner=new Scanner(file1);
        HashMap<String,String> hashMap=new HashMap<>();

        while (scanner.hasNext()){
            Id=scanner.next();
            LoginSystem.username=scanner.next();
            pass=scanner.next();
            balance=scanner.next();
            hashMap.put(LoginSystem.username,pass);
        }
        if (hashMap.containsKey(key) && hashMap.get(key).compareTo(value)==0){
           // System.out.println("signup"+signup);
             signup=false;
           // nullcatcher=true;
        }
        else if (key.equals("")||value.equals("")){
            nullcatcher=true;
          //  System.out.println(nullcatcher);
        }
        else{
            writer.write(setRandomId()+" "+key+" "+value+" "+0+"\n");
            writer.close();
            signup=true;

        }
    }

}

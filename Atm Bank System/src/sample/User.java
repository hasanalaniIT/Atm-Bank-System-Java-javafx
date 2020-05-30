package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public  class User  extends LoginSystem  implements Iopreations {
    private String balance;
    public  String useridinfo;
    public  String usernameinfo;
    public  String userbalanceinfo;
    public boolean passwordequlcheck=false;
    public boolean oldpasswordcheck =false;
    public boolean passwordwork=false;
    public boolean idnotequlcheck=false;
    public boolean insufficientwithdraw=false;
    public String getBalance() throws IOException {
        return checkBalance();
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public String checkBalance() throws IOException {
        File file=new File("Users.txt");
        Scanner scan=new Scanner(file);
        HashMap<String,String> hashMap=new HashMap<>();

        String uni=null;
        String ism = null;
        String fam = null;
        String fee = null;
        File d=new File("getId.txt");
        Scanner scanner=new Scanner(d);
        while (scanner.hasNext()){
            uni=scanner.next();
        }
        while (scan.hasNext()){

            Id=scan.next();
            username=scan.next();
            pass=scan.next();
            balance=scan.next();
            hashMap.put(Id,username+" "+pass+" "+balance);
            if (Id.compareTo(uni)==0){
                ism=username;
                fam=pass;
                fee=balance;
            }
        }
        return fee;
    }
    @Override
    public void depositCash(String amount) throws IOException {
        File file=new File("Users.txt");
        Scanner scan=new Scanner(file);
        HashMap<String,String> hashMap=new HashMap<>();

        String tempid =null;
        String tempname = null;
        String temppass = null;
        String tempbal = null;
        File d=new File("getId.txt");
        Scanner scanner=new Scanner(d);
        while (scanner.hasNext()){
            tempid=scanner.next();
        }
        while (scan.hasNext()){

            Id=scan.next();
            username=scan.next();
            pass=scan.next();
            balance=scan.next();
            hashMap.put(Id,username+" "+pass+" "+balance);
            if (Id.compareTo(tempid)==0){
                tempname =username;
                temppass =pass;
                tempbal =balance;
            }
        }
        double a=Double.parseDouble(amount);
        double b=Double.parseDouble(tempbal);
        double res=a+b;
        hashMap.replace(tempid, tempname +" "+ temppass +" "+res);
        FileWriter fileWriter =new FileWriter(file);
        fileWriter.write("");
        fileWriter.close();
        FileWriter writer=new FileWriter(file,true);
        hashMap.forEach((k,v)->{
            try {
                writer.write(k+" "+v+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });writer.close();
    }
    public boolean withdrawCash(String amount) throws IOException {

        File file=new File("Users.txt");
        Scanner scan=new Scanner(file);
        HashMap<String,String> hashMap=new HashMap<>();
        String tempid =null;
        String tempname = null;
        String temppass = null;
        String tempbal = null;
        File d=new File("getId.txt");
        Scanner scanner=new Scanner(d);
        while (scanner.hasNext()){
            tempid =scanner.next();
        }
        while (scan.hasNext()){
            Id=scan.next();
            username=scan.next();
            pass=scan.next();
            balance=scan.next();
            hashMap.put(Id,username+" "+pass+" "+balance);
            if (Id.compareTo(tempid)==0){
                tempname =username;
                temppass =pass;
                tempbal =balance;
            }
        }
        double a=Double.parseDouble(amount);
        double b=Double.parseDouble(tempbal);
        if (a>b){
            insufficientwithdraw=true;
           // System.out.println(insufficientwithdraw);
            return true;
        }
        else {
            double res = b - a;
            hashMap.replace(tempid, tempname + " " + temppass + " " + res);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("");
            fileWriter.close();
            FileWriter writer = new FileWriter(file, true);
            hashMap.forEach((k, v) -> {
                try {
                    writer.write(k + " " + v + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.close();
            insufficientwithdraw=false;
          // System.out.println(insufficientwithdraw);
        }
        return false;
    }
    @Override
    public void passwordChange(String newpass,String oldpass) throws IOException {
        File file=new File("Users.txt");
        Scanner scan=new Scanner(file);
        HashMap<String,String> hashMap=new HashMap<>();

        String tempid=null;
        String tempname = null;
        String temppass=null;
        String tempbal = null;
        File d=new File("getId.txt");
        Scanner scanner=new Scanner(d);
        while (scanner.hasNext()){
            tempid=scanner.next();
        }
        while (scan.hasNext()){

            Id=scan.next();
            username=scan.next();
            pass=scan.next();
            balance=scan.next();
            hashMap.put(Id,username+" "+pass+" "+balance);
            if (Id.compareTo(tempid)==0){
                tempname=username;
                temppass=pass;
                tempbal =balance;
            }
        } if (!oldpass.equals(temppass)) {
            oldpasswordcheck = true;
           // System.out.println(oldpasswordcheck +" old pass!=");
            return;
        }
        if (newpass.equals(temppass)){
            passwordequlcheck = true;
           // System.out.println("same pass "+passwordequlcheck);
            return;
        }

        else  {
             passwordwork=true;
            //System.out.println("passwordwork "+passwordwork);
             hashMap.replace(tempid, tempname + " " + newpass + " " + tempbal);
             FileWriter fileWriter = new FileWriter(file);
             fileWriter.write("");
             fileWriter.close();
             FileWriter writer = new FileWriter(file, true);
             hashMap.forEach((k, v) -> {
                 try {
                     writer.write(k + " " + v + "\n");
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             });
             writer.close();
        }

    }
    @Override
    public void transferCash(String amount) throws IOException {
        File file=new File("Users.txt");
        Scanner scan=new Scanner(file);
        HashMap<String,String> hashMap=new HashMap<>();
        String tempuserid=null;
        String tempid =null;
        String tempname = null;
        String temppass=null;
        String tempbal = null;
        File d=new File("sendId.txt");
        Scanner scanner=new Scanner(d);
        while (scanner.hasNext()){
            tempid =scanner.next();
        }
        while (scan.hasNext()){
            Id=scan.next();
            username=scan.next();
            pass=scan.next();
            balance=scan.next();
            hashMap.put(Id,username+" "+pass+" "+balance);
            if (Id.compareTo(tempid)==0){
                tempname=username;
                temppass=pass;
                tempbal=balance;
                tempuserid=tempid;
            }
        }
        if (tempuserid == null){
            idnotequlcheck=true;
          //  System.out.println(Id+"    "+tempid);
           // System.out.println(idnotequlcheck);
            return;
            }
            userInformation();
            if (useridinfo.equals(tempuserid))  //User Cant Transfer himself
            {
                idnotequlcheck=true;
                return;
            }
            if (withdrawCash(amount)) {
                    return;
            }
                double a = Double.parseDouble(amount);
                double b = Double.parseDouble(tempbal);
                double res = a + b;
                hashMap.replace(tempid, tempname + " " + temppass + " " + res);
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write("");
                fileWriter.close();
                FileWriter writer = new FileWriter(file, true);
                hashMap.forEach((k, v) -> {
                    try {
                        writer.write(k + " " + v + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                writer.close();
            }
    @Override
    public void userInformation() throws FileNotFoundException {
        File file=new File("Users.txt");
        Scanner scan=new Scanner(file);
        HashMap<String,String> hashMap=new HashMap<>();

        String tempid =null;
        String tempname = null;
        String temppass = null;
        String tempbal = null;
        File d=new File("getId.txt");
        Scanner scanner=new Scanner(d);
        while (scanner.hasNext()){
            tempid =scanner.next();
        }
        while (scan.hasNext()){

            Id=scan.next();
            username=scan.next();
            pass=scan.next();
            balance=scan.next();
            hashMap.put(Id,username+" "+pass+" "+balance);
            if (Id.compareTo(tempid)==0){
                tempname =username;
                temppass =pass;
                tempbal =balance;
                }
            }
                useridinfo= tempid;
                usernameinfo= tempname;
                userbalanceinfo= tempbal;
        }
    }



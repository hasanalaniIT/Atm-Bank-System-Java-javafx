package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class AdminAccess extends Admin {

  public  void sendIdToFile(String userid) throws IOException {
      FileWriter fileWriter=new FileWriter(new File("sendId.txt"));
      fileWriter.write(userid);
      fileWriter.close();
  }

    @Override
    public void removeUser() throws IOException {
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
                idnullcheck=true;
               // System.out.println(Id+"    "+tempid);
                // System.out.println(idnotequlcheck);
                return;
        }
            else {

                hashMap.remove(tempid, tempname + " " + temppass + " " + tempbal);
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
    public void changeUserPassword(String newpass) throws IOException {
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
      if (temppass.equals(newpass)){
          passwordequlcheck=true;
      }
      else {
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
}

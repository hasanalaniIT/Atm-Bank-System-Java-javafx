package sample;

public class TableVariables extends AdminAccess {
    private String ID,name,password,Balance;

    TableVariables(){
        this.ID=null;
        this.name=null;
        this.password=null;
        this.Balance=null;
    }
    TableVariables(String ID, String name, String password, String Balance){
        this.ID=ID;
        this.name=name;
        this.password=password;
        this.Balance=Balance;
    }

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String balance) {
        Balance = balance;
    }


}

import java.util.*;
public class Passenger{
    private String lName,fName;

    public Passenger(String lName, String fName){
        this.lName = lName;
        this.fName = fName;
    }



    //accessor
    public String getLName(){
        return lName;
    }

    public String getFName(){
        return fName;
    }

    //mutator
    public void setLName(String lName){
        this.lName=lName;
    }

    public void setFName(String fName){
        this.fName=fName;
    }

    public String toString(){
        return fName+lName;
    }
}
import java.util.*;
import java.text.*;
import java.io.*;
public class Reservation{

    private Passenger[][] seatingChart;
    private ArrayList<Passenger> waitingList;

    Scanner scan = new Scanner(System.in);

    public Reservation(Passenger[][] seatingChart, ArrayList<Passenger> waitingList){
        this.seatingChart=seatingChart;
        this.waitingList=waitingList;
    }


    public String splitFName(String name){
        int indexSpace=name.indexOf(" ");
        return name.substring(0,indexSpace);
    }

    public String splitLName(String name){
        int indexSpace=name.indexOf(" ");
        return name.substring(indexSpace+1,indexSpace+2);
    }

    public void addPassenger(Passenger person){
        boolean nullFound = false;
        for(int i =0;i<seatingChart.length;i++){
            for(int j =0;j<seatingChart[i].length;j++){
                if(seatingChart[i][j]==null){
                    nullFound = true;
                    break;
                }
                
            }
        }


        if(!nullFound){
            System.out.println("No empty seats. "+person+" has been added to the waiting list.");
            waitingList.add(person);
            }
        else{
            printSeatingChart();
            System.out.println("Enter the row number of the empty seat you wish to fill:");
            int row = scan.nextInt();
            System.out.println("Enter the column number of the empty seat you wish to fill:");
            int col = scan.nextInt();
            seatingChart[row-1][col-1]=person;
            System.out.println(person+" has been added to the seating chart.");
        }
        System.out.println("New Seating Chart:");
        printSeatingChart();
        System.out.println("New Waiting List");
        System.out.println(getWaitingList());
    }

    public void removePassenger(Passenger person,int row,int col){
        if(waitingList.size()<1){
            seatingChart[row][col]=null;
        }
        else{
            seatingChart[row][col]=waitingList.get(0);
            waitingList.remove(waitingList.get(0));
        }
        System.out.println(person+" has been removed from the seating chart.");
        //DISPLAY SEAT CHART AND NEW WAITING LIST
        
    }

    public void printSeatingChart(){
        System.out.printf("%-6s %-17s %-17s %-17s %-17s %-17s\n"," ","1","2","3","4","5");
        for( int j=0;j<10;j++)
        {
            System.out.printf("%-7s",j+1);
            for(int k=0;k<5;k++)
            {
                System.out.printf("%-18s",seatingChart[j][k]);
            }
            System.out.println();
        }
    }

    public ArrayList<Passenger> getWaitingList(){
        return waitingList;
    }

    //CUSTOM 
    //clear everyone in column selected by user and replaces with people on waiting list
    public void clearCol(int nums){
        for(int i=0;i<seatingChart[0].length;i++){
            if(i==nums-1){
            for(int j=0;j<seatingChart.length;j++){
                seatingChart[j][i]=null;
            }
            }
        }

        for(int i=0;i<seatingChart.length;i++){
            for(int j =0;j<seatingChart[0].length;j++){
                if(seatingChart[i][j]==null){
                    seatingChart[i][j]=waitingList.get(0);
                    waitingList.remove(0);
                }
            }
        }
    }




}
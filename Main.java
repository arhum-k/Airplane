import java.util.*;
import java.io.*;
public class Main{

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        Passenger[][] seatingChart=new Passenger[10][5];
        ArrayList<Passenger> waitingList = new ArrayList<Passenger>();
        ArrayList<Passenger> passengerList = new ArrayList<Passenger>();

        BufferedReader br = new BufferedReader(new FileReader("Names.txt")); //or E:\\FolderName\\list.txt
    
        String line = null; //each line in the text file
        
        String[] values = new String[10];//pick up the values in the file separated by commas
        
        while ((line = br.readLine()) != null) { //while there are lines to pick up in the text file
        values = line.split(",");  //pick up item seperated by comma

        passengerList.add(new Passenger(values[0],values[1]));
       
        }
        int count = 0;
        for(int i =0;i<seatingChart.length;i++){
            for(int j =0;j<seatingChart[0].length;j++){
                if(count<50){
                    seatingChart[i][j]=passengerList.get(count);
                    count++;
                }
               
                }
            }
             for(int k=count;k<passengerList.size();k++) {
                    waitingList.add(passengerList.get(k));
                    count++;
        }

        Reservation plane = new Reservation(seatingChart, waitingList);
        
        
        
        boolean run = true;
        String name = "";
        
        while (run){
            System.out.println("Would you like to 1) add passenger 2) remove passenger 3) clear a column and replace passengers with people on the waiting list 4) display seating chart 5) display waiting list 6) quit");
            int x = scan.nextInt();
            //add passenger
            if(x==1){
                System.out.print("Name of Passenger: ");
                scan.nextLine();
                 name = scan.nextLine();
                Passenger temp = new Passenger(plane.splitLName(name),plane.splitFName(name));
                plane.addPassenger(temp);
            }
            //remove passenger
            else if (x==2){
                System.out.print("Name of Passenger (First Name + Last Initial): ");
                scan.nextLine();
                 name = scan.nextLine();
                Passenger temp = new Passenger(plane.splitLName(name),plane.splitFName(name));
                boolean found = false;
                for(int i =0;i<seatingChart.length;i++){
                    for(int j=0;j<seatingChart[i].length;j++){
                        if(seatingChart[i][j]!=null){
                        if(seatingChart[i][j].getFName().equals(temp.getFName())  &&  seatingChart[i][j].getLName().equals(temp.getLName())){
                            plane.removePassenger(seatingChart[i][j],i,j);
                            found = true;
                        }
                        }
                    }
                }
                if(!found){
                    System.out.println("Passenger "+name+" name not found!");
                }
                System.out.println("New Seating Chart:");
                plane.printSeatingChart();
                System.out.println("New Waiting List");
                System.out.println(plane.getWaitingList());
            }
            else if(x==3){
                System.out.println("What column would you like to clear and replace?");
                int num = scan.nextInt();
                plane.clearCol(num);
            }
            else if (x==4){
                plane.printSeatingChart();
            }
            else if (x==5){
                System.out.println(plane.getWaitingList());
            }
            else if(x==6){
                run=false;
            }
            System.out.println();
        }
    

        System.out.println("FINAL SEATING CHART");
        plane.printSeatingChart();
        System.out.println("FINAL Waiting List");
        System.out.println(plane.getWaitingList());





        /* remove person code: tests if name exists in passenger list
     
        for(int i =0;i<seatingChart.length;i++){
            for(int j=0;j<seatingChart[i].length;j++){
                if(seatingChart[i][j].getFName().equals(splitFName(name))  &&  seatingChart[i][j].getLName().equals(splitLName(name))){
                    //STARTR HERE
                    passengerList.remove(seatingChart[i][j],i,j);
                }
            }
        }
        */

       



    }

}

package core;

import java.io.*;
import java.util.ArrayList;

public class TicketList extends ArrayList<Ticket>{
    private static final String FILENAME = "src\\data\\TicketData.txt";

    public void readTicket(){
        File file = new File(FILENAME);
        if(!file.exists()){
            System.out.println("File not exist.");
            System.exit(0);
        }

        try{
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
            String line = reader.readLine();
            while((line = reader.readLine())!=null){
                String[] elements = line.split(", ");
                String movieName = elements[0];
                String userName = elements[1];
                String showTime = elements[2];
                ArrayList<Integer> seatNumber = new ArrayList<>();

                for(int i=3;i<elements.length;i++){
                    seatNumber.add(Integer.parseInt(elements[i]));
                }
                Ticket tk = new Ticket(movieName,userName,showTime,seatNumber);
                this.add(tk);
            }
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public void writeTicket() throws FileNotFoundException {
        PrintWriter out = new PrintWriter(FILENAME);
        out.println("Movie Name, Username, Show Time, Seat Number");
        for(Ticket tk : this){
            out.print(tk.getMovieName()+", "+tk.getUserName()+", "+tk.getShowTime());
            for(int i =0;i<tk.getSeatOrdered().size();i++){
                out.print(", " + tk.getSeatOrdered().get(i));
            }
            System.out.println();
        }
        out.flush();
        out.close();
    }

    public int[][] showAndReturn_SeatsMap(String movieName, String slot){
        int [][]a = new int[10][10];
        for(Ticket x: this){
            for(int i=0;i<x.getSeatOrdered().size();i++){
                if(x.getMovieName().equals(movieName)){
                    if(x.getShowTime().equals(slot)){
                        int row = x.getSeatOrdered().get(i)/10;
                        int column = x.getSeatOrdered().get(i)%10;
                        a[row][column]=1;
                    }
                }

            }
        }
        //Show seat
        System.out.print(" | ");
        for (int i = 1; i <= 9; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i <= 20; i++) {
            System.out.print("_");
        }
        System.out.println();
        for (int i = 1; i <= 9; i++) {
            System.out.print(i + "| ");
            for (int j = 1; j <= 9; j++) {
                if (a[i][j] == 1) System.out.print("X ");
                else System.out.print("O ");
            }
            System.out.println();
        }
        return a;
    }

    public void showTicket(int username){
        for(Ticket ticket: this){

        }
    }

}

package core;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

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
                String seatNumber = elements[2];
                String showTime = elements[3];
                Ticket tk = new Ticket(movieName,userName,seatNumber,showTime);
                this.add(tk);
            }
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public void writeTicket() throws FileNotFoundException {
        PrintWriter out = new PrintWriter(FILENAME);
        out.println("Movie Name, Username, Seat Number. Show Time");
        for(Ticket tk : this){
            out.println(tk.getMovieName()+", "+tk.getUserName()+", "+tk.getSeatNumber()+" ,"+tk.getShowTime());
        }
        out.flush();
        out.close();
    }
}

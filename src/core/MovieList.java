package core;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MovieList extends ArrayList<Movie> {
    private static final String FILENAME = "src\\data\\MovieData.txt";
    public MovieList(){
    }

    public void readMovie(){
        File file = new File(FILENAME);
        if(!file.exists()){
            System.out.println("File not exist.");
            System.exit(0);
        }

        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();

            while((line = reader.readLine())!=null){
                String[] row = line.split(", ");
                String movieName = row[0];
                String author = row[1];
                double price = Double.parseDouble(row[3]);
                ArrayList<String> showTime = new ArrayList<>(Arrays.asList(row).subList(4, row.length-1));
                Movie movie = new Movie(movieName,author,price,showTime);
                this.add(movie);
            }
        }
        catch (IOException var10){
            throw new RuntimeException(var10);
        }
    }

    public void writeToFile() throws FileNotFoundException {
        PrintWriter out = new PrintWriter(FILENAME);
        out.println("Movie Name, Author, Show Time, Price");
        for(Movie mv : this) {
            out.print(mv.getMovieName() + ", " + mv.getAuthor() + ", " + mv.getPrice());
            String showtime = String.join(", ",mv.getShowTime());
            out.println(showtime);
        }
        out.flush();
        out.close();
    }

}
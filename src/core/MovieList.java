package core;

import java.io.*;
import java.util.ArrayList;
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
                String showTime = row[2];
                Movie movie = new Movie(movieName,author,showTime);
                this.add(movie);
            }
        }
        catch (IOException var10){
            throw new RuntimeException(var10);
        }
    }

    public void writeToFile() {
        try {
            PrintWriter out = new PrintWriter(FILENAME);
            Iterator loop = this.iterator();

            while(loop.hasNext()) {
                Movie mv = (Movie)loop.next();
                out.println(mv.getMovieName()+", "+mv.getAuthor()+", "+mv.getShowTime());
            }
            out.close();
        }
        catch (FileNotFoundException var4) {
            Logger.getLogger(MovieList.class.getName()).log(Level.SEVERE, (String)null, var4);
        }

    }

}
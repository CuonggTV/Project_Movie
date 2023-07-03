package core;

import utils.MyUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

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
                double price = Double.parseDouble(row[2]);
                ArrayList<String> showTime = new ArrayList<>();
                if(row.length-1==3){
                    for(int i = 3;i<row.length;i++){
                        showTime.add(row[i]);
                    }
                    //showTime = new ArrayList<>(Arrays.asList(row).subList(3, row.length-1));
                }
                else showTime = null;
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
        out.println("Movie Name, Author, Price, Show Time");
        for(Movie mv : this) {
            out.print(mv.getMovieName() + ", " + mv.getAuthor() + ", " + mv.getPrice());
            if(mv.getShowTime()!=null){
                for (int i=0;i<mv.getShowTime().size();i++){
                    out.print(", ");
                    out.print(mv.getShowTime().get(i));
                }
                out.println();
            }
            else out.println();
        }
        out.flush();
        out.close();
    }

    public int findMoviePosition(){
        int mvPosition;
        do {
            System.out.flush();
            String newMv = MyUtil.inputString("Enter the movie name: ");
            mvPosition = -1;
            for (int i = 0; i < this.size(); i++) {
                if (newMv.equals(this.get(i).getMovieName())) {
                    mvPosition = i;
                    break;
                }
            }

            if (mvPosition == -1) {
                if(!MyUtil.continueAfterWrongInput("We don't have this movie yet.")){
                    return -1;
                }
            }
        } while (mvPosition==-1);

        return mvPosition;
    }

    public void showMovieInfo(int mvPosition){
        System.out.println("\n--------------------------------------------------");
        System.out.println("|Movie name: "+this.get(mvPosition).getMovieName());
        System.out.println("|Author: "+this.get(mvPosition).getAuthor());
        System.out.println("|Price: "+this.get(mvPosition).getPrice());
        System.out.println("|Showtime: ");
        //System.out.println(this.get(mvPosition).getShowTime().isEmpty());
        if (this.get(mvPosition).getShowTime() != null){
            for (int i=0;i<this.get(mvPosition).getShowTime().size();i++){
                String showTime = this.get(mvPosition).getShowTime().get(i);
                String []elements = showTime.split("/");

                System.out.print("|\tOn "+elements[0]+"/"+elements[1]+": ");
                switch (elements[2]){
                    case "1" -> System.out.println("7:00 - 9:00");
                    case "2" -> System.out.println("10:00 - 12:00");
                    case "3" -> System.out.println("13:00 - 15:00");
                    case "4" -> System.out.println("16:00 - 18:00");
                    case "5" -> System.out.println("19:00 - 21:00");
                }
            }
        }
        System.out.println("--------------------------------------------------\n");

    }

    public void showAllMoviesInfo(){
        for(int i=0;i<this.size();i++){
            showMovieInfo(i);
        }
    }


}
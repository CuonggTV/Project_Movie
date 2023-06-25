package core;

import utils.MyUtil;

import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        MovieList mvList = new MovieList();
        mvList.readMovie();
//        Movie mv = new Movie("hello world","cuong",12.5);
//        mvList.add(mv);
        mvList.writeToFile();

    }

}

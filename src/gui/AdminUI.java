package gui;
import core.Admin;
import core.MovieList;
import utils.MyUtil;


public class AdminUI {
    public AdminUI(){
    }
    public boolean enterPassword(){
        String myPassword;
        do {
            System.out.flush();
            myPassword = MyUtil.inputString("Enter your password: ");
            if(myPassword.equals(Admin.PASSWORD)){
                return true;
            }
            else if(!MyUtil.continueAfterWrongInput("Incorrect password!")){
                return false;
            }
        }while(true);
    }

    public void AdminMainUI(MovieList movieList){
        Admin admin= new Admin();
        int choice;
        do{
            System.out.println("=====) ADMIN (=====");
            System.out.println("1. Create movie");
            System.out.println("2. Add show time");
            System.out.println("3. Update movie");
            System.out.println("4. Delete movie");
            System.out.println("5. Log out");
            System.out.println("===================");
            choice = MyUtil.inputInterger("Your choice: ",1,5);
            switch (choice){
                case 1 -> admin.createMovie(movieList);
                case 2 -> admin.addShowTime(movieList);
                case 3 -> admin.updateMovie(movieList);
                case 4 -> admin.deleteMovie(movieList);
            }
        }while(choice!=5);
    }
}

package core;

import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        UserList userlist = new UserList();
        userlist.register();
        userlist.writeToFile();
    }

}

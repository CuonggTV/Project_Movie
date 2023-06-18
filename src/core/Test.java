package core;

import utils.MyUtil;

import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        UserList userList = new UserList();
        User loginUser = userList.login();

        ((Custumer) loginUser).addMoney();

    }

}

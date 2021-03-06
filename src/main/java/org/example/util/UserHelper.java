package org.example.util;


import org.example.model.Roles;
import org.example.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class UserHelper {

    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String EMAIL = "@gmail.com";

    private static Random random = new Random();

    public static List<User> generateUserList(int count){
        List<User> userList = new ArrayList<User>(count);

        for(int i=0;i<count;i++){
            userList.add(new User(i, NAME +i, SURNAME +i,i+EMAIL, generateRandomRole()));
        }
        return userList;
    }

    public static Roles generateRandomRole()  {
        final Roles[] values = Roles.values();
        return Arrays.asList(values).get(random.nextInt(values.length));
    }

   public static List<String> getAcceptableValues() {
        List<String> range = new ArrayList<String>();
        for (Roles role : Roles.values()) {
            range.add(role.toString());
        }
        return range;
    }
}

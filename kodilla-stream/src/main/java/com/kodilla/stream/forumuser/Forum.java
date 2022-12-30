package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    public static List<ForumUser> getUserList(){
        final List<ForumUser> theUserList = new ArrayList<>();
        theUserList.add(new ForumUser(1, "User1", 'M', LocalDate.of(2000, 1, 1) , 0));
        theUserList.add(new ForumUser(2, "User2", 'M', LocalDate.of(1996, 1, 1) , 45));
        theUserList.add(new ForumUser(3, "User3", 'M', LocalDate.of(2001, 1, 1) , 120));
        theUserList.add(new ForumUser(4, "User4", 'F', LocalDate.of(1998, 1, 1) , 130));
        theUserList.add(new ForumUser(5, "User5", 'M', LocalDate.of(1999, 1, 1) , 0));
        theUserList.add(new ForumUser(6, "User6", 'F', LocalDate.of(2015, 1, 1) , 160));
        theUserList.add(new ForumUser(7, "User7", 'M', LocalDate.of(1956, 1, 1) , 50));
        theUserList.add(new ForumUser(8, "User8", 'F', LocalDate.of(2003, 1, 1) , 220));
        theUserList.add(new ForumUser(9, "User9", 'M', LocalDate.of(2011, 1, 1) , 230));

        return new ArrayList<>(theUserList);
    }
}
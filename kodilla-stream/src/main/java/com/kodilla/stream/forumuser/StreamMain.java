package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {

        Map<Integer, ForumUser> userListMap = Forum.getUserList().stream().
                filter(s -> s.getSex() == 'M').
                filter(s -> s.getDate().isBefore(LocalDate.of(2002, 1, 1))).
                filter(s -> s.getPostQuantity() != 0).
                collect(Collectors.toMap(ForumUser::getID, s -> s));

        System.out.println("\nThe list of users after sorting is: ");
        userListMap.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}
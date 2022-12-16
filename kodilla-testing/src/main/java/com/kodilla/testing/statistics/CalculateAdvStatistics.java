package com.kodilla.testing.statistics;

import java.util.List;


public class CalculateAdvStatistics{

    List<String> usersNames;
    private String usersCount;
    private int postsCount;
    private int commentsCount;
    private int averagePostsCountPerUser;
    private int averageCommentsCountPerUser;
    private int averageCommentsCountPerPost;
    private int usersCounter;

    private Statistics statistics;

    public CalculateAdvStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public CalculateAdvStatistics(String usersCount, int postsCount, int commentsCount) {
        this.usersCount = usersCount;
        this.postsCount = postsCount;
        this.commentsCount = commentsCount;
    }

    List<String> usersNames(){
        return usersNames;
    }

    public int commentsCount() {
        return commentsCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    void calculateAdvStatistics(Statistics statistics){
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();
        usersNames = statistics.usersNames();
    }

    void showStatistics(){
        System.out.println(" " + usersCount);
        System.out.println(" " + postsCount);
        System.out.println(" " + commentsCount);
        System.out.println(" " + averagePostsCountPerUser);
        System.out.println(" " + averageCommentsCountPerUser);
        System.out.println(" " + averageCommentsCountPerPost);
    }

    public Integer postCount() {
        return postsCount;
    }

}

package com.kodilla.testing.statistics;

import java.util.List;

//Mt: not implement//
public class CalculateAdvStatistics{

    List<String> usersNames;
    static int usersCount;
    private int postsCount;
    private int commentsCount;
    private int averagePostsCountPerUser;
    private int averageCommentsCountPerUser;
    private int averageCommentsCountPerPost;

    //Mt: variable statistics not need!
    //private Statistics statistics;

    //public CalculateAdvStatistics(Statistics statistics) {
        //this.statistics = statistics;
    //}

    public CalculateAdvStatistics(List<String> usersNames, int usersCount, int postsCount, int commentsCount) {
        this.usersNames = usersNames;
        this.usersCount = usersCount;
        this.postsCount = postsCount;
        this.commentsCount = commentsCount;
    }

    //Constructor is need!
    public CalculateAdvStatistics(Statistics statisticsMock) {
    }

    public int postsCount() {
        return postsCount;
    }

    public int commentsCount() {
        return commentsCount;
    }

    void calculateAdvStatistics(Statistics statistics){
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();
        usersNames = statistics.usersNames();
        averageCommentsCountPerPost = 10;
        averageCommentsCountPerUser = 11;
        averagePostsCountPerUser = 12;
    }

    void showStatistics(){
        System.out.println("UsersCount: " + usersCount);
        System.out.println("PostsCount: " + postsCount);
        System.out.println("CommentsCount: " + commentsCount);
        System.out.println("AveragePostsCountPerUser: " + averagePostsCountPerUser);
        System.out.println("AverageCommentsCountPerUser: " + averageCommentsCountPerUser);
        System.out.println("AverageCommentsCountPerPost: " + averageCommentsCountPerPost);
    }

}

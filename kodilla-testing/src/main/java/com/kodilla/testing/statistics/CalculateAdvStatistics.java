package com.kodilla.testing.statistics;

import java.util.List;


public class CalculateAdvStatistics implements Statistics{

    List<String> usersNames;
    private int usersCount;
    private int usersCountAdv;
    private int postsCount;
    private int commentsCount;
    private int averagePostsCountPerUser;
    private int averageCommentsCountPerUser;
    private int averageCommentsCountPerPost;

    Statistics statistics;

    public CalculateAdvStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public CalculateAdvStatistics(int usersCount, int postsCount, int commentsCount) {
        this.usersCount = usersCount;
        this.postsCount = postsCount;
        this.commentsCount = commentsCount;
    }

    public CalculateAdvStatistics(List<String> usersNames, int usersCount, int postsCount, int commentsCount) {
        this.usersNames = usersNames;
        this.usersCount = usersCount;
        this.postsCount = postsCount;
        this.commentsCount = commentsCount;
    }

    public CalculateAdvStatistics(List<String> usersNames) {
        this.usersNames = usersNames;
    }

    @Override
    public List<String> usersNames(){
        return usersNames;
    }

    @Override
    public int postsCount() {
        return postsCount;
    }

    @Override
    public int commentsCount() {
        return commentsCount;
    }

    void calculateAdvStatistics(Statistics statistics){
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();
        usersNames = statistics.usersNames();
        usersCountAdv = usersNames.size();
        averageCommentsCountPerPost = 10;
        averageCommentsCountPerUser = 11;
        averagePostsCountPerUser = 12;
    }

    void showStatistics(){
        System.out.println("UsersCount: " + usersCountAdv);
        System.out.println("PostsCount: " + postsCount);
        System.out.println("CommentsCount: " + commentsCount);
        System.out.println("AveragePostsCountPerUser: " + averagePostsCountPerUser);
        System.out.println("AverageCommentsCountPerUser: " + averageCommentsCountPerUser);
        System.out.println("AverageCommentsCountPerPost: " + averageCommentsCountPerPost);
    }
}

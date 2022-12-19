package com.kodilla.testing.statistics;

import java.util.List;

//Mt: not implement
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
    //Mt: delete method argument 'statistics': example: public CalculateAdvStatistics(Statistics statisticsMock)
    public CalculateAdvStatistics() {
    }

    public int getAveragePostsCountPerUser() {
        return averagePostsCountPerUser;
    }

    public int getAverageCommentsCountPerUser() {
        return averageCommentsCountPerUser;
    }

    public int getAverageCommentsCountPerPost() {
        return averageCommentsCountPerPost;
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
        //Mt: correction
        if (postsCount != 0  || commentsCount != 0) {
            averageCommentsCountPerPost = commentsCount / postsCount;
            averageCommentsCountPerUser = commentsCount / usersNames.size();
            averagePostsCountPerUser = postsCount / usersNames.size();
        }
    }

    void showStatistics(){
        System.out.println("UsersCount: " + usersNames.size());
        System.out.println("PostsCount: " + postsCount);
        System.out.println("CommentsCount: " + commentsCount);
        System.out.println("AveragePostsCountPerUser: " + averagePostsCountPerUser);
        System.out.println("AverageCommentsCountPerUser: " + averageCommentsCountPerUser);
        System.out.println("AverageCommentsCountPerPost: " + averageCommentsCountPerPost);
    }

}

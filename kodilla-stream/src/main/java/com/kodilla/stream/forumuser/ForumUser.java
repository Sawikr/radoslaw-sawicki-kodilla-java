package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Objects;

public final class ForumUser {

    private final int ID;
    private final String userName;
    private final char sex;
    private final LocalDate date;
    private final int postQuantity;


    public ForumUser(final int id, final String userName, final char sex, final LocalDate date, final int postQuantity) {
        this.ID = id;
        this.userName = userName;
        this.sex = sex;
        this.date = date;
        this.postQuantity = postQuantity;
    }

    public int getID() {
        return ID;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getPostQuantity() {
        return postQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForumUser forumUser = (ForumUser) o;
        return ID == forumUser.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "ID=" + ID +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", date=" + date +
                ", postQuantity=" + postQuantity +
                '}';
    }
}
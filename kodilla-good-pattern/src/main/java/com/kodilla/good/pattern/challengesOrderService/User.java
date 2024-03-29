package com.kodilla.good.pattern.challengesOrderService;

public class User {

    private final String userName;
    private final String realName;

    public User(final String username, final String realName) {
        this.userName = username;
        this.realName = realName;
    }

    @Override
    public String toString() {
        return "User {" +
                "username = '" + userName + '\'' + ", " +
                "realname = '" + realName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return userName.equals(user.userName);
    }
}

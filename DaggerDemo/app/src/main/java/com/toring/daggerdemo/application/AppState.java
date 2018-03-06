package com.toring.daggerdemo.application;

import com.toring.daggerdemo.network.User;

public class AppState {
    public AppState() {
    }

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

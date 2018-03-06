package com.toring.daggerdemo.network.service;

import com.toring.daggerdemo.network.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AppService {
    @GET("/users/{username}")
    Call<User> getUser(
            @Path("username") String username
    );
}

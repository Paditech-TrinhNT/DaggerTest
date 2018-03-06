package com.toring.daggerdemo.module;

import com.toring.daggerdemo.network.service.AppService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    public Retrofit provideRestAdapter() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    @Provides
    public AppService provideGithubApiService(Retrofit retrofit) {
        return retrofit.create(AppService.class);
    }

//    @Provides
//    @Singleton
//    public UserManager provideUserManager(GithubApiService githubApiService) {
//        return new UserManager(githubApiService);
//    }
}

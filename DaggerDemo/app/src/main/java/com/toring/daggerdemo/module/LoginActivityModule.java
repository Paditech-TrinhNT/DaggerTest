package com.toring.daggerdemo.module;

import com.toring.daggerdemo.application.AppState;
import com.toring.daggerdemo.network.service.AppService;
import com.toring.daggerdemo.presenter.LoginActivityPresenter;
import com.toring.daggerdemo.presenter.MainActivityPresenter;
import com.toring.daggerdemo.view.LoginActivity;
import com.toring.daggerdemo.view.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityModule {
    private LoginActivity loginActivity;

    public LoginActivityModule(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }

    @Provides
    LoginActivityPresenter provideLoginPresenter(AppState appState, AppService appService){
        return new LoginActivityPresenter(loginActivity, appState, appService);
    }
}

package com.toring.daggerdemo.module;

import com.toring.daggerdemo.application.AppState;
import com.toring.daggerdemo.presenter.MainActivityPresenter;
import com.toring.daggerdemo.view.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    private MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    MainActivityPresenter provideMainPresenter(AppState appState){
        return new MainActivityPresenter(mainActivity, appState);
    }
}

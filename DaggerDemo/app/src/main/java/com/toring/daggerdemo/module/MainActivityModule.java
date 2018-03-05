package com.toring.daggerdemo.module;

import com.toring.daggerdemo.presenter.MainActivityPresenter;
import com.toring.daggerdemo.view.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    MainActivityPresenter provideMainPresenter(){
        return new MainActivityPresenter(mainActivity);
    }
}

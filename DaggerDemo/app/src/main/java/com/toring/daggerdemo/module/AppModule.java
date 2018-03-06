package com.toring.daggerdemo.module;

import com.toring.daggerdemo.application.AppState;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Singleton
    @Provides
    AppState provideAppState() {
        return new AppState();
    }
}

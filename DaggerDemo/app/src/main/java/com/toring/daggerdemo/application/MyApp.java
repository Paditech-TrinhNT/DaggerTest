package com.toring.daggerdemo.application;

import android.app.Application;
import android.content.Context;

import com.toring.daggerdemo.component.AppComponent;
import com.toring.daggerdemo.component.DaggerAppComponent;
import com.toring.daggerdemo.network.User;
import com.toring.daggerdemo.module.AppModule;

import javax.inject.Inject;

public class MyApp extends Application {
    @Inject
    AppState appState;

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
        appComponent.inject(this);
        User user = new User();
        user.setName("Trinh");
        appState.setUser(user);
    }

    private void init() {
        appComponent = DaggerAppComponent.builder().appModule(new AppModule()).build();
    }

    public static MyApp get(Context context) {
        return (MyApp) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

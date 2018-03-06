package com.toring.daggerdemo.component;

import com.toring.daggerdemo.application.MyApp;
import com.toring.daggerdemo.module.AppModule;
import com.toring.daggerdemo.module.LoginActivityModule;
import com.toring.daggerdemo.module.MainActivityModule;
import com.toring.daggerdemo.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(MyApp myApp);

    LoginActivityComponent plus(LoginActivityModule loginActivityModule);

    MainActivityComponent plus(MainActivityModule mainActivityModule);
}

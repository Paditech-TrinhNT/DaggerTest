package com.toring.daggerdemo.component;

import com.toring.daggerdemo.module.LoginActivityModule;
import com.toring.daggerdemo.module.MainActivityModule;
import com.toring.daggerdemo.view.LoginActivity;
import com.toring.daggerdemo.view.MainActivity;

import dagger.Subcomponent;

@Subcomponent(
        modules = LoginActivityModule.class
)
public interface LoginActivityComponent {
    LoginActivity inject(LoginActivity loginActivity);
}

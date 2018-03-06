package com.toring.daggerdemo.component;

import com.toring.daggerdemo.module.MainActivityModule;
import com.toring.daggerdemo.view.MainActivity;

import dagger.Component;
import dagger.Subcomponent;

@Subcomponent(
        modules = MainActivityModule.class
)
public interface MainActivityComponent {
    MainActivity inject(MainActivity mainActivity);
}

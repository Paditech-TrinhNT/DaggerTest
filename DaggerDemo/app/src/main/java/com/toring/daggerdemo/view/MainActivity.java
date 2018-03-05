package com.toring.daggerdemo.view;

import android.app.Activity;
import android.os.Bundle;

import com.toring.daggerdemo.R;
import com.toring.daggerdemo.component.DaggerMainActivityComponent;
import com.toring.daggerdemo.module.MainActivityModule;
import com.toring.daggerdemo.presenter.MainActivityPresenter;

import javax.inject.Inject;

public class MainActivity extends Activity {

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMainActivityComponent.builder().mainActivityModule(new MainActivityModule(this)).build().inject(this);
    }
}

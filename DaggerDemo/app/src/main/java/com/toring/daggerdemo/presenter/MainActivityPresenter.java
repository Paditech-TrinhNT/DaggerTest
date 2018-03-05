package com.toring.daggerdemo.presenter;

import android.widget.Toast;

import com.toring.daggerdemo.view.MainActivity;

public class MainActivityPresenter {
    private MainActivity mainActivity;

    public MainActivityPresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void showMessage(String s) {
        Toast.makeText(mainActivity, s, Toast.LENGTH_SHORT).show();
    }
}

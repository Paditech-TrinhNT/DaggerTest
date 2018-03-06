package com.toring.daggerdemo.presenter;

import android.widget.Toast;

import com.toring.daggerdemo.R;
import com.toring.daggerdemo.application.AppState;
import com.toring.daggerdemo.contract.MainContract;
import com.toring.daggerdemo.view.MainActivity;

public class MainActivityPresenter implements MainContract.PresenterImpl{
    private MainActivity mainActivity;
    private AppState appState;

    public MainActivityPresenter(MainActivity mainActivity, AppState appState) {
        this.mainActivity = mainActivity;
        this.appState = appState;
    }

    @Override
    public void onCreate() {
        showMessage(mainActivity.getString(R.string.message_wellcome, appState.getUser().getName()));
        mainActivity.setUserName(appState.getUser().getName());
        mainActivity.setAvatar(appState.getUser().getAvatar_url());
    }

    public void showMessage(String s) {
        Toast.makeText(mainActivity, s, Toast.LENGTH_SHORT).show();
    }
}

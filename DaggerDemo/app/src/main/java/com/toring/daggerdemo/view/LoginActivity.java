package com.toring.daggerdemo.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.toring.daggerdemo.R;
import com.toring.daggerdemo.application.MyApp;
import com.toring.daggerdemo.contract.LoginContract;
import com.toring.daggerdemo.module.LoginActivityModule;
import com.toring.daggerdemo.presenter.LoginActivityPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends Activity implements LoginContract.ViewImpl {

    @BindView(R.id.etUsername)
    EditText etUsername;
    @BindView(R.id.progressLayout)
    View progressLayout;

    @Inject
    LoginActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        MyApp.get(this).getAppComponent().plus(new LoginActivityModule(this)).inject(this);

        presenter.onCreate();
    }

    @OnClick(R.id.tvLogin)
    public void onClickLogin() {
        if (getUsername() == null || getUsername().isEmpty())
            Toast.makeText(this, "Phải nhập tên trước", Toast.LENGTH_SHORT).show();
        presenter.onLogin();
    }

    @Override
    public String getUsername() {
        return etUsername.getText().toString();
    }

    @Override
    public void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

    @Override
    public void showProgressLayout(boolean isShow) {
        progressLayout.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }
}

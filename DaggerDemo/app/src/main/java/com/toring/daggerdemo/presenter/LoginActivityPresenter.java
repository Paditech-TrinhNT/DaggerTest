package com.toring.daggerdemo.presenter;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.toring.daggerdemo.application.AppState;
import com.toring.daggerdemo.contract.LoginContract;
import com.toring.daggerdemo.network.User;
import com.toring.daggerdemo.network.service.AppService;
import com.toring.daggerdemo.view.LoginActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivityPresenter implements LoginContract.PresenterImpl {
    private LoginActivity loginActivity;
    private AppState appState;
    private AppService appService;

    public LoginActivityPresenter(LoginActivity loginActivity, AppState appState, AppService appService) {
        this.loginActivity = loginActivity;
        this.appState = appState;
        this.appService = appService;
    }


    @Override
    public void onCreate() {

    }

    @Override
    public void showMessage(String s) {
        Toast.makeText(loginActivity, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLogin() {
        loginActivity.showProgressLayout(true);
        appService.getUser(loginActivity.getUsername()).enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                loginActivity.showProgressLayout(false);
                if (response.body() != null){
                    appState.setUser(response.body());
                    loginActivity.goToMain();
                }else {
                    showMessage("Tài khoản không tồn tại");
                }
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                loginActivity.showProgressLayout(false);
                showMessage("Đăng nhập không thành công");
            }
        });
    }
}

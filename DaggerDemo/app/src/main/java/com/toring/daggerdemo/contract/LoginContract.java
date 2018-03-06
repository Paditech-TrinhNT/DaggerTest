package com.toring.daggerdemo.contract;

public interface LoginContract {
    interface ViewImpl {

        String getUsername();

        void goToMain();

        void showProgressLayout(boolean isShow);
    }

    interface PresenterImpl {
        void onCreate();

        void showMessage(String s);

        void onLogin();
    }
}

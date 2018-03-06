package com.toring.daggerdemo.contract;

import android.widget.Toast;

public interface MainContract {
    interface ViewImpl{

        void setUserName(String name);

        void setAvatar(String avatar_url);
    }

    interface PresenterImpl{
        void onCreate();

        void showMessage(String s);
    }
}

package com.toring.daggerdemo.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.toring.daggerdemo.R;
import com.toring.daggerdemo.application.MyApp;
import com.toring.daggerdemo.contract.MainContract;
import com.toring.daggerdemo.glide.GlideApp;
import com.toring.daggerdemo.module.MainActivityModule;
import com.toring.daggerdemo.presenter.MainActivityPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements MainContract.ViewImpl {

    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.ivAvatar)
    ImageView ivAvatar;

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        MyApp.get(this).getAppComponent().plus(new MainActivityModule(this)).inject(this);

        presenter.onCreate();
    }

    @Override
    public void setUserName(String name) {
        if (name == null || name.isEmpty())
            tvName.setText("Username");
        else
            tvName.setText(name);
    }

    @Override
    public void setAvatar(String avatar_url) {
        GlideApp.with(this).load(avatar_url)
                .placeholder(R.drawable.ic_person_black_24dp)
                .error(R.drawable.ic_launcher_foreground)
                .circleCrop()
                .into(ivAvatar);
    }
}

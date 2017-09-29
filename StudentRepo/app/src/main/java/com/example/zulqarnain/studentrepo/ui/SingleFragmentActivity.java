package com.example.zulqarnain.studentrepo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.example.zulqarnain.studentrepo.R;

/**
 * Created by Zul Qarnain on 9/29/2017.
 */

public abstract class SingleFragmentActivity extends FragmentActivity {

    public abstract Fragment createFragment();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.activity_main);

        if(fragment!=null){
            fragment = createFragment();
            manager.beginTransaction().add(R.id.activity_main,fragment).commit();
        }
    }
}

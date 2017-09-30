package com.example.zulqarnain.studentrepo.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.zulqarnain.studentrepo.ui.fragments.StudentViewFragment;

public class StudentViewActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context pakage){
        Intent intent = new Intent(pakage,StudentViewActivity.class);
        return intent;
    }
    @Override
    public Fragment createFragment() {
        return StudentViewFragment.newInstance();
    }


}

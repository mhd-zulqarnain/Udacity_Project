package com.example.zulqarnain.studentrepo.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.zulqarnain.studentrepo.ui.SingleFragmentActivity;
import com.example.zulqarnain.studentrepo.ui.fragments.StudentAddFragment;

/**
 * Created by Zul Qarnain on 9/29/2017.
 */

public class StudentAddActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context pkg){
        Intent intent = new Intent(pkg,StudentAddActivity.class);
        return intent;
    }

    @Override
    public Fragment createFragment() {

        return StudentAddFragment.newInstance();
    }
}

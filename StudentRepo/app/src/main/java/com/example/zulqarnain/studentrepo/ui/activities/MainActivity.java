package com.example.zulqarnain.studentrepo.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.zulqarnain.studentrepo.R;
import com.example.zulqarnain.studentrepo.database.StudentDbHelper;
import com.example.zulqarnain.studentrepo.ui.fragments.StudentViewFragment;
import com.example.zulqarnain.studentrepo.utilities.ImgProcess;
import com.example.zulqarnain.studentrepo.utilities.Messege;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public void viewStudent(View v){
        Intent intent = StudentViewActivity.newIntent(this);
        startActivity(intent);
    }
    public void addStudent(View v){
        Intent intent = StudentAddActivity.newIntent(this);
        startActivity(intent);
    }

}

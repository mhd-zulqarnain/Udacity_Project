package com.example.zulqarnain.studentrepo.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.zulqarnain.studentrepo.R;
import com.example.zulqarnain.studentrepo.database.StudentDbHelper;
import com.example.zulqarnain.studentrepo.model.Student;
import com.example.zulqarnain.studentrepo.utilities.ImgProcess;
import com.example.zulqarnain.studentrepo.utilities.Messege;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_IMG_CODE = 23;
    StudentDbHelper dbh;
    ImageView imagev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbh = new StudentDbHelper(this);
       /* ArrayList<Student> ls = new ArrayList<>();
        ls = dbh.getStudentData();
        Student std = ls.get(0);
        Log.d("null", "onCreate: "+std.getSt_img());
        imagev= (ImageView) findViewById(R.id.test_img);*/
    }

    public void saveImage(View v) {
        storeImg();
    }

    public void viewFragment(View v) {
        StudentViewFragment fragmentA = new StudentViewFragment();
        android.app.FragmentManager manager =getFragmentManager();
        android.app.FragmentTransaction transaction= manager.beginTransaction();
        transaction.add(R.id.group,fragmentA,"A");
        transaction.commit();
    }

    public void storeImg() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, REQUEST_IMG_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMG_CODE && resultCode == Activity.RESULT_OK && data != null) {
            Uri path = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                String da = ImgProcess.imgToString(bitmap);
                long i = dbh.insetData(da);
                Messege.messege(this, "is the size  " + i);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

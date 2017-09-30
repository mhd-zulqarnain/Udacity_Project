package com.example.zulqarnain.studentrepo.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.RemoteInput;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zulqarnain.studentrepo.R;
import com.example.zulqarnain.studentrepo.database.StudentDbHelper;
import com.example.zulqarnain.studentrepo.ui.activities.StudentViewActivity;
import com.example.zulqarnain.studentrepo.ui.adapters.AdapterCallBack;
import com.example.zulqarnain.studentrepo.utilities.ImgProcess;
import com.example.zulqarnain.studentrepo.utilities.Messege;

/**
 * Created by Zul Qarnain on 9/29/2017.
 */

public class StudentAddFragment extends Fragment implements View.OnClickListener {

    private TextView mStdName;
    private TextView mStdEmail;
    private TextView mStdPhone;
    private ImageView mStdImg;

    private Button btnImgAdd;
    private Button btnStdAdd;

    private final static int REQUEST_IMAGE_CODE = 1;
    private StudentDbHelper dbh;
    private String imgStringForm="";

    public static StudentAddFragment newInstance() {
        return new StudentAddFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.student_add_fragement, container, false);
        mStdName = view.findViewById(R.id.ed_std_name);
        mStdEmail = view.findViewById(R.id.ed_std_email);
        mStdPhone = view.findViewById(R.id.ed_std_phone);
        mStdImg = view.findViewById(R.id.imgview_std);

        btnImgAdd = view.findViewById(R.id.std_add_img_btn);
        btnStdAdd = view.findViewById(R.id.std_add_btn);
        btnImgAdd.setOnClickListener(this);
        btnStdAdd.setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dbh = new StudentDbHelper(getContext());
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.std_add_img_btn:
                imageIntent();
                break;
            case R.id.std_add_btn:
                addData();
                break;
        }
    }

    public void imageIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, REQUEST_IMAGE_CODE);
    }

    public void addData() {
        String name = mStdName.getText().toString();
        String email = mStdEmail.getText().toString();
        String phone = mStdPhone.getText().toString();
        if (!name.equals("") && !phone.equals("") && !email.equals("") && !imgStringForm.equals("")) {
            long i = dbh.insetData(name, phone, email, imgStringForm);
            Intent intent = StudentViewActivity.newIntent(getActivity());
            startActivity(intent);
        } else {
            Messege.messege(getActivity(), "Fill all the fileds");
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CODE && resultCode == Activity.RESULT_OK && data != null) {
            Uri path = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), path);
                imgStringForm = ImgProcess.imgToString(bitmap);
                mStdImg.setImageBitmap(bitmap);

            } catch (Exception e) {
                Log.d("Error", "onActivityResult: " + e);
            }

        }
    }



}

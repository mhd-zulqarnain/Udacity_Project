package com.example.zulqarnain.studentrepo.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zulqarnain.studentrepo.R;
import com.example.zulqarnain.studentrepo.database.StudentDbHelper;
import com.example.zulqarnain.studentrepo.model.Student;
import com.example.zulqarnain.studentrepo.ui.adapters.StudentRecycler;

import java.util.ArrayList;

/**
 * Created by Zul Qarnain on 9/27/2017.
 */

public class StudentViewFragment extends Fragment {
    StudentDbHelper dbh;
    ArrayList<Student> mList;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View row = inflater.inflate(R.layout.student_view_fragement,container,false);
        dbh= new StudentDbHelper(container.getContext());
        mList=dbh.getStudentData();
        recyclerView = row.findViewById(R.id.fragment_std_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter( new StudentRecycler(mList));
        return row;
    }
}

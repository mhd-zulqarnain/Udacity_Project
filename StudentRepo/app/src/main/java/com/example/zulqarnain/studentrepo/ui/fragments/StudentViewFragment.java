package com.example.zulqarnain.studentrepo.ui.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.zulqarnain.studentrepo.R;
import com.example.zulqarnain.studentrepo.database.StudentDbHelper;
import com.example.zulqarnain.studentrepo.model.Student;
import com.example.zulqarnain.studentrepo.ui.adapters.AdapterCallBack;
import com.example.zulqarnain.studentrepo.ui.adapters.StudentRecycler;

import java.util.ArrayList;

/**
 * Created by Zul Qarnain on 9/27/2017.
 */

public class StudentViewFragment extends Fragment implements SearchView.OnQueryTextListener ,AdapterCallBack {
    StudentDbHelper dbh;
    ArrayList<Student> mList;
    RecyclerView recyclerView;
    StudentRecycler adapter;

    public static Fragment newInstance(){
      return new StudentViewFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View row = inflater.inflate(R.layout.student_view_fragement,container,false);
        dbh= new StudentDbHelper(container.getContext());
        recyclerView = row.findViewById(R.id.fragment_std_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext(),LinearLayoutManager.VERTICAL,false));


        return row;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        mList=dbh.getStudentData();
        adapter=new StudentRecycler(mList);
        recyclerView.setAdapter( adapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_item,menu);
        MenuItem item=menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);
        adapter.setAdapterCallback(this);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        ArrayList<Student> newList = new ArrayList<>();
        for(Student model:mList){
            String name= model.getSt_name().toLowerCase();
            if(name.contains(newText)){
                newList.add(model);
            }
        }
        adapter.setFilter(newList);
        return true;
    }

    ///to delete the object on clicking the button in view holder
    @Override
    public void methodcallback(int stdID) {
        dbh.delStuent(stdID);
        mList=dbh.getStudentData();
        adapter.setFilter(mList);
        Log.d("TAF", "methodcallback: called"+stdID);
    }
}

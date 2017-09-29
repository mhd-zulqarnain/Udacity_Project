package com.example.zulqarnain.studentrepo.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

public class StudentViewFragment extends Fragment implements SearchView.OnQueryTextListener {
    StudentDbHelper dbh;
    ArrayList<Student> mList;
    RecyclerView recyclerView;
    StudentRecycler adapter;
    @Nullable
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

 /*   @Override
    public boolean onQueryTextSubmit(String query) {
        mList = dbh.getStudent(query);

        recyclerView.setAdapter(new StudentRecycler(mList));
//        notifyDataSetChanged();
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }*/
}

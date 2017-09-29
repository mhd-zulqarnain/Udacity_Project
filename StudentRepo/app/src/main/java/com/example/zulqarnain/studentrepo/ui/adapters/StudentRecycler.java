package com.example.zulqarnain.studentrepo.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zulqarnain.studentrepo.R;
import com.example.zulqarnain.studentrepo.model.Student;
import com.example.zulqarnain.studentrepo.utilities.ImgProcess;

import java.util.ArrayList;

/**
 * Created by Zul Qarnain on 9/26/2017.
 */

public class StudentRecycler  extends RecyclerView.Adapter<StudentRecycler.StdViewHolder>{
    ArrayList<Student> list;
    public StudentRecycler(ArrayList<Student> list){
        this.list=list;
    }
    @Override
    public StdViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).
               inflate(R.layout.single_row_view,parent,false);
        StdViewHolder holder = new StdViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(StdViewHolder holder, int position) {
        Student std = list.get(position);
        holder.stdImg.setImageBitmap(ImgProcess.StringtoImage(std.getSt_img()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class StdViewHolder extends RecyclerView.ViewHolder{

        TextView view;
        ImageView stdImg;
        public StdViewHolder(View itemView) {
            super(itemView);
//            view = (TextView) itemView;
            stdImg=itemView.findViewById(R.id.std_img);
        }
    }
    public void setFilter(ArrayList<Student> mList){
        list=new ArrayList<>();
        list.addAll(mList);
        notifyDataSetChanged();
    }
}

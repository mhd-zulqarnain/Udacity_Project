package com.example.zulqarnain.studentrepo.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zulqarnain.studentrepo.R;
import com.example.zulqarnain.studentrepo.model.Student;
import com.example.zulqarnain.studentrepo.ui.fragments.StudentAddFragment;
import com.example.zulqarnain.studentrepo.ui.fragments.StudentViewFragment;
import com.example.zulqarnain.studentrepo.utilities.ImgProcess;

import java.util.ArrayList;

/**
 * Created by Zul Qarnain on 9/26/2017.
 */

public class StudentRecycler  extends RecyclerView.Adapter<StudentRecycler.StdViewHolder>{
    ArrayList<Student> list;
    AdapterCallBack callback;

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
        holder.bindView(std);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class StdViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView name;
        private TextView phone;
        private TextView email;
        private Button rButton;
        private ImageView stdImg;
        private Student mStd;
        public StdViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.std_name);
            phone=itemView.findViewById(R.id.std_phone);
            email=itemView.findViewById(R.id.std_email);
            rButton=itemView.findViewById(R.id.btn_dlt);
            stdImg=itemView.findViewById(R.id.std_img);
            rButton.setOnClickListener(this);
        }

        public void bindView(Student std) {
            this.mStd=std;
            name.setText(mStd.getSt_name());
            phone.setText(mStd.getSt_ph());
            email.setText(mStd.getSt_email());
            stdImg.setImageBitmap(ImgProcess.StringtoImage(mStd.getSt_img()));
        }

        @Override
        public void onClick(View view) {
            callback.methodcallback(mStd.getSt_id());
        }
    }

    public void setAdapterCallback(StudentViewFragment callback){
        this.callback=callback;
    }

    public void setFilter(ArrayList<Student> mList){
        list=new ArrayList<>();
        list.addAll(mList);
        notifyDataSetChanged();
    }
}

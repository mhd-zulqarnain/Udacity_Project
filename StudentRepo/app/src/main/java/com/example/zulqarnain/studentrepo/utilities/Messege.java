package com.example.zulqarnain.studentrepo.utilities;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Zul Qarnain on 9/26/2017.
 */

public class Messege {
    public static void messege(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }
}

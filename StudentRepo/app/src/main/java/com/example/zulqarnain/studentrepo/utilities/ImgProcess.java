package com.example.zulqarnain.studentrepo.utilities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;

/**
 * Created by Zul Qarnain on 9/26/2017.
 */

public class ImgProcess {


    public static String imgToString(Bitmap bitmap) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
        byte[] imgByte = bos.toByteArray();
        String imgStringFormat = Base64.encodeToString(imgByte, Base64.DEFAULT);
        return imgStringFormat;
    }

    public static Bitmap StringtoImage(String path) {
        try {

            byte[] decodedString = Base64.decode(path, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            Bitmap bitmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            Log.d("TAG", "StringtoImage: exception " + bitmap);
            return bitmap;
        } catch (Exception e) {
            Log.d("TAG", "StringtoImage: exception " + e);

        }
        return null;
    }
}

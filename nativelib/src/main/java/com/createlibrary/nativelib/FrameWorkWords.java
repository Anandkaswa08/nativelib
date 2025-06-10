package com.createlibrary.nativelib;

import android.content.Context;
import android.content.SharedPreferences;

public class FrameWorkWords {


    Context context;
    SharedPreferences mySharedPassbook;

    public FrameWorkWords(Context mAppContext){

        NativeLib nativeLib = new NativeLib();

        context = mAppContext;
        mySharedPassbook = context.getSharedPreferences("PSSBNK", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPassbook.edit();
        editor.putString("extra10",nativeLib.getST());
        editor.apply();

    }

    public String[] extra10(){

        String extra = mySharedPassbook.getString("extra10", "~");
        return extra.split(",");

    }



}

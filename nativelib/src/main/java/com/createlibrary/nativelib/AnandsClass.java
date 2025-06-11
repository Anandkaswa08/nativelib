package com.createlibrary.nativelib;

import android.content.Context;

public class AnandsClass {

    public String getString(){

        return "Anand";
    }

    public String getNative(){
        NativeLib nativeLib = new NativeLib();
        return  nativeLib.getS();
    }


    public String[] getFrameWork(Context context){

        FrameWorkWords frameWorkWords = new FrameWorkWords(context);

        return frameWorkWords.extra10();

    }

    public String getValue(){
        NativeLib nativeLib = new NativeLib();
        return nativeLib.stringFromJNI();
    }

    public String getSIValue(){

        SiValue siValue = new SiValue();
        return siValue.decrypt("Uzuzp4_ugcu");
    }
}

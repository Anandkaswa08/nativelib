package com.createlibrary.nativelib;

public class NativeLib {

    // Used to load the 'nativelib' library on application startup.
    static {
        System.loadLibrary("nativelib");
    }


    public String getS(){

        return stringFromJNI();
    }

    public String getST(){

        return getStringSNAMEFORELE();
    }


    /**
     * A native method that is implemented by the 'nativelib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native String getStringSNAMEFORELE();
}
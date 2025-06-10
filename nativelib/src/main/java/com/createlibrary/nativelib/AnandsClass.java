package com.createlibrary.nativelib;

public class AnandsClass {

    public String getString(){

        return "Anand";
    }

    public String getNative(){
        NativeLib nativeLib = new NativeLib();
        return  nativeLib.getS();
    }
}

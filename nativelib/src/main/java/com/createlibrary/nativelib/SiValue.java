package com.createlibrary.nativelib;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class SiValue {

    static {
        System.loadLibrary("nativelib");
    }

    Logger logger = Logger.getLogger("SenderID");

    public SenderDetails senderName(String address, Context context){

        String senderName = "";

        SenderDetails  senderDetails = new SenderDetails();
        senderDetails.setIsBankSender("");
        senderDetails.setSenderNameFound("");


        //Log.d("SEnderADd","--"+address);
        if (!address.contains("+") && address.length() == 6 && !TextUtils.isDigitsOnly(address)) {


            SharedPreferences sharedPreferences = context.getSharedPreferences("SiValueGotIt",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            String senderIDSi = sharedPreferences.getString("senderIDSi","~");
            String senderNameSi = sharedPreferences.getString("senderNameSi","~");
            String senderIsBankSi = sharedPreferences.getString("isBank","~");

            if (senderIDSi.contains(address.toUpperCase())){

                try {

                    //String senderNameSi = sharedPreferences.getString("senderNameSi","~");

                    String[] arraySenderID = senderIDSi.split(",");
                    String[] arraySenderName = senderNameSi.split(",");
                    String[] arrayIsBank = senderIsBankSi.split(",");


                    List<String> senderList_id = Arrays.asList(arraySenderID);
                    List<String> senderList_name = Arrays.asList(arraySenderName);
                    List<String> senderList_isBank = Arrays.asList(arrayIsBank);

                    int myAdd_index = senderList_id.indexOf(address.toUpperCase());

                    try {
                        if (myAdd_index > 0){
                            senderName = senderList_name.get(myAdd_index);
                            String isBank = senderList_isBank.get(myAdd_index);

                            senderDetails.setIsBankSender(isBank);
                            senderDetails.setSenderNameFound(senderName);
                        }

                    } catch (Exception e) {
                        logger.warning(e.getMessage());
                    }

                }catch (Exception e){
                    logger.warning(e.getMessage());
                }



            }else {


                Cursor cursor = null;
                SQLiteDatabase db = null;
                try {

                    //String fileName = "senderid.db";
                    String fileName = "mezo_si_en.db";
                    File file = context.getDatabasePath(fileName);

                    if (!file.exists()) {
                        if (!file.getParentFile().exists()) {
                            file.getParentFile().mkdir();
                        }

                        InputStream inputStream = context.getAssets().open("mezo_si_en.db");
                        OutputStream outputStream = new FileOutputStream(file);
                        byte[] buffer = new byte[1024 * 8];
                        int numOfBytesToRead;
                        while ((numOfBytesToRead = inputStream.read(buffer)) > 0)
                            outputStream.write(buffer, 0, numOfBytesToRead);
                        inputStream.close();
                        outputStream.close();
                    }

                    db = SQLiteDatabase.openOrCreateDatabase(file, null);

                    String send_address = encrypt(address);

                    //Log.d("SEnderADd","2--"+send_address);

                    cursor = db.query("SI1", null, "a1" + " =?", new String[]{send_address}, null, null, null);

                    int ccc = cursor.getCount();
                    if (ccc > 0) {
                        while (cursor.moveToNext()) {

                            //String dsdds = cursor.getString(cursor.getColumnIndex(column_name1));
                            //String return_val = cursor.getString(cursor.getColumnIndex("a1"));
                            senderName = cursor.getString(cursor.getColumnIndexOrThrow("a2"));

                            int isBankSender = cursor.getInt(cursor.getColumnIndexOrThrow("a4"));

                            //Log.d("SEnderADd","3--"+senderName);


                            senderName = decrypt(senderName);

                            senderDetails.setIsBankSender(""+isBankSender);
                            senderDetails.setSenderNameFound(senderName);

                            editor.putString("senderIDSi",senderIDSi +","+address.toUpperCase());
                            editor.putString("senderNameSi",senderNameSi +","+senderName);
                            editor.putString("isBank",senderIsBankSi +","+isBankSender);
                            editor.apply();

                            //Log.d("SEnderADd","4--"+senderName);
                            // senderName = senderName.replace("Transactional/","");

                            senderName = senderName;
                            break;

                        }
                    }
                } catch (Exception e) {
                    logger.warning(e.getMessage());
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }

                    if (db != null) {
                        if (db.isOpen()) {
                            db.close();
                        }
                    }
                }

            }
        }

        return  senderDetails;

    }
    public native String encrypt(String val1);
    public native String decrypt(String val1);
}

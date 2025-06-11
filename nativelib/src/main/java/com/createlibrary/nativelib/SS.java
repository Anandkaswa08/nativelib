package com.createlibrary.nativelib;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SS {

    private String incomingSender;
    private final String changeSenderName;
    private String incomingMessage;
    private String toLowerCaseSMS;
    final private Context appContext;

    public static final String ADDRESS = "address";
    public static final String DATE = "date";

    Logger logger = Logger.getLogger("Error2");

    CommonLogicFunction commonLogicFunction;
    String checkIfBankID = "0";


    public SS(String sender, String message, String changedName, String logoOfBrand,
              String checkIfBankIDViaDatabase, Context context) {

        try {
            if (sender.length() == 8) {
                if (sender.matches("(?i)[A-Z]{8}")) {

                    sender = "" + sender.charAt(0) + "" + sender.charAt(1) + "-" + sender.substring(2);

                }
            }

        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
        checkIfBankID= checkIfBankIDViaDatabase;


        SharedPreferences mySharedPassbook = context.getSharedPreferences("PSSBNK", Context.MODE_PRIVATE);
        String CASE17_DateFormat = mySharedPassbook.getString("case17_dtfmt", "~");
        String[] case17_DateFormat = CASE17_DateFormat.split(",");


        try {
            Matcher mm = Pattern.compile("(?i)(" + case17_DateFormat[6] + "{1,2})(" + case17_DateFormat[7] + ")(\\W+|)(" + case17_DateFormat[1] + ")").matcher(message);
            if (mm.find()) {

                String group = mm.group();
                String date = mm.group(1);
                String middle = mm.group(3);
                String month = mm.group(4);
                message = message.replaceAll(group, date + middle + month);

            }

        } catch (Exception e) {
            logger.warning(e.getMessage());
        }

        changeSenderName = changedName;
        incomingSender = sender;
        incomingMessage = message;
        toLowerCaseSMS = message.toLowerCase();
        appContext = context;
        commonLogicFunction = new CommonLogicFunction();

    }

    public BlockResult processMessage(boolean isSentSMS, long s_time) {


        BlockResult blockResult = new BlockResult();
        blockResult.setOutput(0);
        blockResult.setReason(0);

        FrameworkWords frameworkWords = new FrameworkWords(appContext);



        return blockResult;
    }

    }

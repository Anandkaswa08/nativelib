package com.createlibrary.nativelib;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonLogicFunction {

    static Logger logger = Logger.getLogger("Error");

    public BlockResult getBlockStatus(Context context, String iNumber, String iMessage,
                                      long s_time, String changeName, String logoOfBrand,
                                      int senderFromWhere, boolean isSentSMS) {


        String sms_add=iNumber;

        CommonLogicFunction commonLogicFunction = new CommonLogicFunction();
        SenderIdNamesFromList senderIdNamesFromList = commonLogicFunction.getSenderNameChangeName(sms_add,
                context);

        //String sixCharacterSender = senderIdNamesFromList.getSixCharacterSender();

        //tempAddress = sixCharacterSender;
        //tempAddressBank = tempAddress;

        changeName = senderIdNamesFromList.getChangeNameOfSender();
        String checkIfBankID = senderIdNamesFromList.getCheckIfBankID();


        BlockResult status;

        SS iSenderId = new SS(iNumber,
                iMessage, changeName, logoOfBrand, checkIfBankID, context);
        status = iSenderId.processMessage(isSentSMS, s_time);

        return status;
    }

    //----------------------------------------------------------------------------------------------

    public ArrayList<String> findURlInMessage(Context context, String incomingMessage){

        SharedPreferences mySharedPassbook = context.getSharedPreferences("PSSBNK", Context.MODE_PRIVATE);
        String CASE19 = mySharedPassbook.getString("case19", "~");
        String[] case19 = CASE19.split(",");

        Matcher email_matcher = Patterns.EMAIL_ADDRESS.matcher(incomingMessage);

        while (email_matcher.find()) {
            String email = email_matcher.group();
            incomingMessage = incomingMessage.replace(email," ");
        }

        ArrayList<String> array_url = new ArrayList<>();

        Matcher test = Pattern.compile("(?i)(^|[^\\w\\.])("+case19[0]+"|"+case19[1]+"(s|))(\\W+).*?(\\s|$|\")").matcher(incomingMessage);

        while (test.find()) {
            String url = test.group().trim();
            array_url.add(url.trim());
        }

        Matcher test2 = Pattern.compile("(?i)(\\w+)\\.(\\w+)\\/["+case19[6]+"\\/_\\!\\§\\?\\=\\~\\¿\\%]+(\\s|$)").matcher(incomingMessage);

        while (test2.find()) {

            String url = test2.group().trim();
            if (!array_url.toString().contains(url)) {

                url = url.replace("/","\\/");
                url = url.replace("?","\\?");
                url = url.replace("!","\\!");
                url = url.replace("§","\\§");
                url = url.replace("~","\\~");
                url = url.replace("¿","\\¿");
                url = url.replace("%","\\%");

                Matcher test3 = Pattern.compile("(?i)(^|[^\\w\\.])([\\w\\.\\/]+|)" + url + "").matcher(incomingMessage);

                if (test3.find()) {

                    String complete_url = test3.group();
                    complete_url = complete_url.trim();
                    array_url.add(complete_url.trim());

                }
            }
        }

        Matcher test4 = Pattern.compile("(?i)\\.("+case19[2]+")").matcher(incomingMessage);

        while (test4.find()) {

            String url = test4.group(1);
            if (url!=null){
                url = url.trim();
            }

            Matcher test3 = Pattern.compile("(?i)(^|[^\\w\\.])[\\w\\.\\/]+\\."+url+".*?(\\s|$)").matcher(incomingMessage);

            if (test3.find()) {

                String complete_url = test3.group();

                complete_url = complete_url.trim();

                if (!array_url.toString().contains(complete_url)) {

                    array_url.add(complete_url);

                }
            }
        }

        return array_url;
    }

    //----------------------------------------------------------------------------------------------

    public String smsWithoutUrl(String smsWithUrl, ArrayList<String> all_Urls){

        String without_url = smsWithUrl;
        try {
            for (String replace_url : all_Urls) {
                without_url = without_url.replace(replace_url.toLowerCase(), " ");
            }
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }

        return without_url;

    }

    //----------------------------------------------------------------------------------------------

    public String getReplaceDateText(Context context, String desc) {

        String found = "";
        DateFormat formatter;
        String tempdate = "";
        desc = desc.toLowerCase();


        SharedPreferences mySharedPassbook = context.getSharedPreferences("PSSBNK", Context.MODE_PRIVATE);
        String CASE17_DateFormat = mySharedPassbook.getString("case17_dtfmt", "~");
        String[] case17_DateFormat = CASE17_DateFormat.split(",");


        Matcher m = Pattern.compile("(" + case17_DateFormat[0] + ")[- /.](" + case17_DateFormat[1] + ")[- /.](" + case17_DateFormat[2] + "{2})").matcher(desc);

        if (m.find()) {
            try {
                String date = m.group();
                tempdate = m.group();
                date = date.replace("/", "-");
                date = date.replace(".", "-");
                date = date.replace(" ", "-");
                date = date.replace("--", "-");
                formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                Date date1 = formatter.parse(date);
                if (date1 != null) {
                    found = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(date1);
                }
                boolean checkIfAmPm = checkIfAmPm(desc, tempdate, case17_DateFormat);
                if (!checkIfAmPm) {
                    return found + "~" + tempdate;
                } else {
                    return "~";
                }

            } catch (ParseException e) {
                // TODO Auto-generated catch block
                logger.warning(e.getMessage());
            }

        }

        Matcher m17 = Pattern.compile("(" + case17_DateFormat[0] + ")(" + case17_DateFormat[1] + ")(" + case17_DateFormat[2] + "{2})").matcher(desc);

        if (m17.find()) {
            try {
                String date = m17.group();
                tempdate = m17.group();
                date = date.replace("/", "-");
                date = date.replace(".", "-");
                date = date.replace(" ", "-");
                date = date.replace("--", "-");
                formatter = new SimpleDateFormat("ddMMMyyyy", Locale.ENGLISH);
                Date date1 = formatter.parse(date);
                if (date1 != null) {
                    found = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(date1);
                }
                boolean checkIfAmPm = checkIfAmPm(desc, tempdate, case17_DateFormat);
                if (!checkIfAmPm) {
                    return found + "~" + tempdate;
                } else {
                    return "~";
                }
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                logger.warning(e.getMessage());
            }

        }


        Matcher m1 = Pattern.compile("(" + case17_DateFormat[1] + ")[- /.](" + case17_DateFormat[0] + ")[- /.](" + case17_DateFormat[2] + "{2})").matcher(desc);

        if (m1.find()) {
            try {
                String date = m1.group();
                tempdate = m1.group();
                date = date.replace("/", "-");
                date = date.replace(".", "-");
                date = date.replace(" ", "-");
                date = date.replace("--", "-");
                formatter = new SimpleDateFormat("MMM-dd-yyyy", Locale.ENGLISH);
                Date date1 = formatter.parse(date);
                if (date1 != null) {
                    found = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(date1);
                }
                boolean checkIfAmPm = checkIfAmPm(desc, tempdate, case17_DateFormat);
                if (!checkIfAmPm) {
                    return found + "~" + tempdate;
                } else {
                    return "~";
                }


            } catch (ParseException e) {
                // TODO Auto-generated catch block
                logger.warning(e.getMessage());
            }

        }

        Matcher m2 = Pattern.compile("(" + case17_DateFormat[0] + ")[- /.](" + case17_DateFormat[3] + ")[- /.](" + case17_DateFormat[2] + "{2})").matcher(desc);

        if (m2.find()) {
            try {
                String date = m2.group();
                tempdate = m2.group();
                date = date.replace("/", "-");
                date = date.replace(".", "-");
                date = date.replace(" ", "-");
                date = date.replace("--", "-");
                formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                Date date1 = formatter.parse(date);
                if (date1 != null) {
                    found = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(date1);
                }
                boolean checkIfAmPm = checkIfAmPm(desc, tempdate, case17_DateFormat);
                if (!checkIfAmPm) {
                    return found + "~" + tempdate;
                } else {
                    return "~";
                }

            } catch (ParseException e) {
                // TODO Auto-generated catch block
                logger.warning(e.getMessage());
            }

        }


        Matcher m3 = Pattern.compile("(" + case17_DateFormat[2] + "{2})[- /.](" + case17_DateFormat[3] + ")[- /.](0?3[01]|" + case17_DateFormat[5] + "|[1-9])").matcher(desc);

        if (m3.find()) {
            try {
                String date = m3.group();
                tempdate = m3.group();
                date = date.replace("/", "-");
                date = date.replace(".", "-");
                date = date.replace(" ", "-");
                date = date.replace("--", "-");
                formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                Date date1 = formatter.parse(date);

                if (date1 != null) {
                    found = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(date1);
                }
                boolean checkIfAmPm = checkIfAmPm(desc, tempdate, case17_DateFormat);
                if (!checkIfAmPm) {
                    return found + "~" + tempdate;
                } else {
                    return "~";
                }


            } catch (ParseException e) {
                // TODO Auto-generated catch block
                logger.warning(e.getMessage());
            }

        }


        Matcher m4 = Pattern.compile("(" + case17_DateFormat[0] + ")[- /.](" + case17_DateFormat[4] + ")[- /.](" + case17_DateFormat[2] + "{2})").matcher(desc);

        if (m4.find()) {
            try {
                String date = m4.group();
                tempdate = m4.group();
                date = date.replace("/", "-");
                date = date.replace(".", "-");
                date = date.replace(" ", "-");
                date = date.replace("--", "-");
                formatter = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);
                Date date1 = formatter.parse(date);
                if (date1 != null) {
                    found = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(date1);
                }
                boolean checkIfAmPm = checkIfAmPm(desc, tempdate, case17_DateFormat);
                if (!checkIfAmPm) {
                    return found + "~" + tempdate;
                } else {
                    return "~";
                }


            } catch (ParseException e) {
                // TODO Auto-generated catch block
                logger.warning(e.getMessage());
            }

        }

        Matcher m5 = Pattern.compile("(" + case17_DateFormat[4] + ")[- /.](" + case17_DateFormat[0] + ")[- /.,]+(" + case17_DateFormat[2] + "{2})").matcher(desc);

        if (m5.find()) {
            try {
                String date = m5.group();
                tempdate = m5.group();
                date = date.replace("/", "-");
                date = date.replace(",", "-");
                date = date.replace(".", "-");
                date = date.replace(" ", "-");
                date = date.replace("--", "-");
                formatter = new SimpleDateFormat("MMMM-dd-yyyy", Locale.ENGLISH);
                Date date1 = formatter.parse(date);

                //Log.d("ATTTQQQ","1-- "+tempdate);

                if (date1 != null) {
                    found = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(date1);
                }
                boolean checkIfAmPm = checkIfAmPm(desc, tempdate, case17_DateFormat);
                if (!checkIfAmPm) {
                    return found + "~" + tempdate;
                } else {
                    return "~";
                }


            } catch (ParseException e) {
                // TODO Auto-generated catch block
                logger.warning(e.getMessage());
            }

        }

        Matcher m6 = Pattern.compile("(" + case17_DateFormat[0] + ")(" + case17_DateFormat[1] + ")(" + case17_DateFormat[5] + ")").matcher(desc);

        if (m6.find()) {
            try {
                String date = m6.group();
                tempdate = m6.group();
                date = date.replace("/", "-");
                date = date.replace(".", "-");
                date = date.replace(" ", "-");
                date = date.replace("--", "-");
                formatter = new SimpleDateFormat("ddMMMyy", Locale.ENGLISH);
                Date date1 = formatter.parse(date);
                if (date1 != null) {
                    found = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(date1);
                }
                boolean checkIfAmPm = checkIfAmPm(desc, tempdate, case17_DateFormat);
                if (!checkIfAmPm) {
                    return found + "~" + tempdate;
                } else {
                    return "~";
                }


            } catch (ParseException e) {
                // TODO Auto-generated catch block
                logger.warning(e.getMessage());
            }

        }

        Matcher m8 = Pattern.compile("(" + case17_DateFormat[2] + "{2})[- /.](" + case17_DateFormat[3] + ")[- /.](" + case17_DateFormat[0] + ")").matcher(desc);

        if (m8.find()) {
            try {
                String date = m8.group();
                tempdate = m8.group();
                date = date.replace("/", "-");
                date = date.replace(".", "-");
                date = date.replace(" ", "-");
                date = date.replace("--", "-");
                formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                Date date1 = formatter.parse(date);
                if (date1 != null) {
                    found = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(date1);
                }
                boolean checkIfAmPm = checkIfAmPm(desc, tempdate, case17_DateFormat);
                if (!checkIfAmPm) {
                    return found + "~" + tempdate;
                } else {
                    return "~";
                }


            } catch (ParseException e) {
                // TODO Auto-generated catch block
                logger.warning(e.getMessage());
            }

        }

        Matcher m9 = Pattern.compile("(" + case17_DateFormat[2] + "{2})[- /.](" + case17_DateFormat[0] + ")[- /.](" + case17_DateFormat[3] + ")").matcher(desc);

        if (m9.find()) {
            try {
                String date = m9.group();
                tempdate = m9.group();
                date = date.replace("/", "-");
                date = date.replace(".", "-");
                date = date.replace(" ", "-");
                date = date.replace("--", "-");
                formatter = new SimpleDateFormat("yyyy-dd-MM", Locale.ENGLISH);
                Date date1 = formatter.parse(date);
                if (date1 != null) {
                    found = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(date1);
                }
                boolean checkIfAmPm = checkIfAmPm(desc, tempdate, case17_DateFormat);
                if (!checkIfAmPm) {
                    return found + "~" + tempdate;
                } else {
                    return "~";
                }


            } catch (ParseException e) {
                // TODO Auto-generated catch block
                logger.warning(e.getMessage());
            }

        }


        Matcher m12 = Pattern.compile("(" + case17_DateFormat[1] + ")[- /.](" + case17_DateFormat[0] + ")[- /.,](" + case17_DateFormat[2] + "{2})").matcher(desc);

        if (m12.find()) {
            try {
                String date = m12.group();
                tempdate = m12.group();
                date = date.replace("/", "-");
                date = date.replace(".", "-");
                date = date.replace(" ", "-");
                date = date.replace(",", "-");
                date = date.replace("--", "-");
                formatter = new SimpleDateFormat("MMM-dd-yyyy", Locale.ENGLISH);
                Date date1 = formatter.parse(date);
                if (date1 != null) {
                    found = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(date1);
                }
                boolean checkIfAmPm = checkIfAmPm(desc, tempdate, case17_DateFormat);
                if (!checkIfAmPm) {
                    return found + "~" + tempdate;
                } else {
                    return "~";
                }


            } catch (ParseException e) {
                // TODO Auto-generated catch block
                logger.warning(e.getMessage());
            }

        }

        Matcher m13 = Pattern.compile("(" + case17_DateFormat[1] + ")[- /.](" + case17_DateFormat[0] + ")[- /.,][ ](" + case17_DateFormat[2] + "{2})").matcher(desc);

        if (m13.find()) {
            try {
                String date = m13.group();
                tempdate = m13.group();
                date = date.replace("/", "-");
                date = date.replace(".", "-");
                date = date.replace(" ", "-");
                date = date.replace(",", "-");
                date = date.replace("--", "-");
                formatter = new SimpleDateFormat("MMM-dd-yyyy", Locale.ENGLISH);
                Date date1 = formatter.parse(date);
                if (date1 != null) {
                    found = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(date1);
                }
                boolean checkIfAmPm = checkIfAmPm(desc, tempdate, case17_DateFormat);
                if (!checkIfAmPm) {
                    return found + "~" + tempdate;
                } else {
                    return "~";
                }


            } catch (ParseException e) {
                // TODO Auto-generated catch block
                logger.warning(e.getMessage());
            }

        }

        Matcher m14 = Pattern.compile("(" + case17_DateFormat[0] + ")[- /.](" + case17_DateFormat[3] + ")[- /.](" + case17_DateFormat[5] + ")").matcher(desc);

        if (m14.find()) {
            try {
                String date = m14.group();
                tempdate = m14.group();
                date = date.replace("/", "-");
                date = date.replace(".", "-");
                date = date.replace(" ", "-");
                date = date.replace("--", "-");
                formatter = new SimpleDateFormat("dd-MM-yy", Locale.ENGLISH);
                Date date1 = formatter.parse(date);

                if (date1 != null) {
                    found = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(date1);
                }
                boolean checkIfAmPm = checkIfAmPm(desc, tempdate, case17_DateFormat);
                if (!checkIfAmPm) {
                    return found + "~" + tempdate;
                } else {
                    return "~";
                }


            } catch (ParseException e) {
                // TODO Auto-generated catch block
                logger.warning(e.getMessage());
            }

        }

        Matcher m16 = Pattern.compile("(" + case17_DateFormat[1] + ")[- /.,](" + case17_DateFormat[6] + "{1})[- /.,](" + case17_DateFormat[2] + "{2})").matcher(desc);

        if (m16.find()) {
            try {
                String date = m16.group();
                tempdate = m16.group();
                date = date.replace("/", "-");
                date = date.replace(".", "-");
                date = date.replace(" ", "-");
                date = date.replace(",", "-");
                date = date.replace("--", "-");
                formatter = new SimpleDateFormat("MMM-dd-yyyy", Locale.ENGLISH);
                Date date1 = formatter.parse(date);

                if (date1 != null) {
                    found = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(date1);
                }
                boolean checkIfAmPm = checkIfAmPm(desc, tempdate, case17_DateFormat);
                if (!checkIfAmPm) {
                    return found + "~" + tempdate;
                } else {
                    return "~";
                }


            } catch (ParseException e) {
                // TODO Auto-generated catch block
                logger.warning(e.getMessage());
            }

        }

        Matcher m18 = Pattern.compile("(" + case17_DateFormat[1] + ")[- /.,](" + case17_DateFormat[6] + "{1})[- /.,][ ](" + case17_DateFormat[2] + "{2})").matcher(desc);

        if (m18.find()) {
            try {
                String date = m18.group();
                tempdate = m18.group();
                date = date.replace("/", "-");
                date = date.replace(".", "-");
                date = date.replace(" ", "-");
                date = date.replace(",", "-");
                date = date.replace("--", "-");
                formatter = new SimpleDateFormat("MMM-dd-yyyy", Locale.ENGLISH);
                Date date1 = formatter.parse(date);

                if (date1 != null) {
                    found = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(date1);
                }
                boolean checkIfAmPm = checkIfAmPm(desc, tempdate, case17_DateFormat);
                if (!checkIfAmPm) {
                    return found + "~" + tempdate;
                } else {
                    return "~";
                }


            } catch (ParseException e) {
                // TODO Auto-generated catch block
                logger.warning(e.getMessage());
            }

        }
        Matcher m20 = Pattern.compile("\\W(" + case17_DateFormat[0] + ")[- /.,](" + case17_DateFormat[3] + ")[- /.,](" + case17_DateFormat[5] + "{1})\\W").matcher(desc);

        if (m20.find()) {
            try {
                String date = m20.group();
                tempdate = m20.group();
                date = date.replace("/", "-");
                date = date.replace(".", "-");
                date = date.replace(" ", "-");
                date = date.replace(",", "-");
                date = date.replace("--", "-");
                formatter = new SimpleDateFormat("dd-MM-yy", Locale.ENGLISH);
                Date date1 = formatter.parse(date);

                if (date1 != null) {
                    found = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(date1);
                }
                boolean checkIfAmPm = checkIfAmPm(desc, tempdate, case17_DateFormat);
                if (!checkIfAmPm) {
                    return found + "~" + tempdate;
                } else {
                    return "~";
                }


            } catch (ParseException e) {
                // TODO Auto-generated catch block
                logger.warning(e.getMessage());
            }

        }

        Matcher m21 = Pattern.compile("(" + case17_DateFormat[3] + ")[- /.,](" + case17_DateFormat[0] + ")[- /.,](" + case17_DateFormat[2] + "{2})").matcher(desc);

        if (m21.find()) {
            try {
                String date = m21.group();
                tempdate = m21.group();
                date = date.replace("/", "-");
                date = date.replace(".", "-");
                date = date.replace(" ", "-");
                date = date.replace(",", "-");
                date = date.replace("--", "-");
                formatter = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);
                Date date1 = formatter.parse(date);

                if (date1 != null) {
                    found = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(date1);
                }
                boolean checkIfAmPm = checkIfAmPm(desc, tempdate, case17_DateFormat);
                if (!checkIfAmPm) {
                    return found + "~" + tempdate;
                } else {
                    return "~";
                }


            } catch (ParseException e) {
                // TODO Auto-generated catch block
                logger.warning(e.getMessage());
            }

        }

        Matcher m22 = Pattern.compile("(" + case17_DateFormat[3] + ")[ /.,](" + case17_DateFormat[0] + ")[ /.,](" + case17_DateFormat[2] + "{2})").matcher(desc);

        if (m22.find()) {
            try {
                String date = m22.group();
                tempdate = m22.group();
                date = date.replace("/", "-");
                date = date.replace(".", "-");
                date = date.replace(" ", "-");
                date = date.replace(",", "-");
                date = date.replace("--", "-");
                formatter = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);
                Date date1 = formatter.parse(date);

                if (date1 != null) {
                    found = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(date1);
                }
                boolean checkIfAmPm = checkIfAmPm(desc, tempdate, case17_DateFormat);
                if (!checkIfAmPm) {
                    return found + "~" + tempdate;
                } else {
                    return "~";
                }


            } catch (ParseException e) {
                // TODO Auto-generated catch block
                logger.warning(e.getMessage());
            }

        }

        Matcher m26 = Pattern.compile("(" + case17_DateFormat[0] + ")[- /.](" + case17_DateFormat[1] + ")[- /.](" + case17_DateFormat[5] + ")").matcher(desc);

        if (m26.find()) {
            try {
                String date = m26.group();
                tempdate = m26.group();
                date = date.replace("/", "-");
                date = date.replace(".", "-");
                date = date.replace(" ", "-");
                date = date.replace("--", "-");
                formatter = new SimpleDateFormat("dd-MMM-yy", Locale.ENGLISH);
                Date date1 = formatter.parse(date);
                if (date1 != null) {
                    found = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(date1);
                }
                boolean checkIfAmPm = checkIfAmPm(desc, tempdate, case17_DateFormat);
                if (!checkIfAmPm) {
                    return found + "~" + tempdate;
                } else {
                    return "~";
                }


            } catch (ParseException e) {
                // TODO Auto-generated catch block
                logger.warning(e.getMessage());
            }

        }

        Matcher m19 = Pattern.compile("(" + case17_DateFormat[0] + ")\\s*[- /.,]\\s*(" + case17_DateFormat[1] + ")\\s*[- /.,]\\s*(" + case17_DateFormat[2] + "{2})").matcher(desc);

        if (m19.find()) {
            try {
                String date = m19.group();
                tempdate = m19.group();
                date = date.replace("/", "-");
                date = date.replace(",", "-");
                date = date.replace(".", "-");
                date = date.replace(" ", "-");
                date = date.replace("--", "-");
                formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                Date date1 = formatter.parse(date);
                if (date1 != null) {
                    found = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(date1);
                }
                boolean checkIfAmPm = checkIfAmPm(desc, tempdate, case17_DateFormat);
                if (!checkIfAmPm) {
                    return found + "~" + tempdate;
                } else {
                    return "~";
                }


            } catch (ParseException e) {
                // TODO Auto-generated catch block
                logger.warning(e.getMessage());
            }

        }

        Matcher m28 = Pattern.compile("(" + case17_DateFormat[0] + ")( |\\/|\\.|\\,|-)(" + case17_DateFormat[1] + ")( |\\/|\\.|\\,|-)(" + case17_DateFormat[2] + "{2})").matcher(desc);

        if (m28.find()) {
            try {
                String date = m28.group();
                tempdate = m28.group();
                date = date.replace("/", "-");
                date = date.replace(".", "-");
                date = date.replace(" ", "-");
                date = date.replace("--", "-");
                formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                Date date1 = formatter.parse(date);
                if (date1 != null) {
                    found = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(date1);
                }
                boolean checkIfAmPm = checkIfAmPm(desc, tempdate, case17_DateFormat);
                if (!checkIfAmPm) {
                    return found + "~" + tempdate;
                } else {
                    return "~";
                }


            } catch (ParseException e) {
                // TODO Auto-generated catch block
                logger.warning(e.getMessage());
            }

        }

        Matcher m29 = Pattern.compile("(" + case17_DateFormat[0] + ")[\\/-](" + case17_DateFormat[3] + ")[\\/-](0?[1-9]" + case17_DateFormat[6] + ")").matcher(desc);

        if (m29.find()) {
            try {
                String date = m29.group();
                tempdate = m29.group();
                date = date.replace("/", "-");
                date = date.replace(".", "-");
                date = date.replace(" ", "-");
                date = date.replace("--", "-");
                formatter = new SimpleDateFormat("dd-MM-yy", Locale.ENGLISH);
                Date date1 = formatter.parse(date);
                if (date1 != null) {
                    found = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(date1);
                }
                boolean checkIfAmPm = checkIfAmPm(desc, tempdate, case17_DateFormat);
                if (!checkIfAmPm) {
                    return found + "~" + tempdate;
                } else {
                    return "~";
                }


            } catch (ParseException e) {
                // TODO Auto-generated catch block
                logger.warning(e.getMessage());
            }

        }


        return found + "~" + tempdate;
    }

    public boolean checkIfAmPm(String desc, String tempDate,String[] case17_DateFormat) {


        boolean am_pm_found = false;
        try {
            if (!tempDate.isEmpty()) {

                int index = desc.indexOf(tempDate) + tempDate.length();
                int end_index = index + 6;
                if (end_index > desc.length()) {
                    end_index = desc.length();
                }

                String myTextToCheck = desc.substring(index, end_index);

                Matcher test = Pattern.compile("(?i)^\\s*((\\-\\s*" + case17_DateFormat[6] + ")|" + case17_DateFormat[8] + "\\W|" + case17_DateFormat[9] + "\\W|" + case17_DateFormat[10] + "\\W|" + case17_DateFormat[11] + "\\W|:)").matcher(myTextToCheck);

                if (test.find()) {
                    am_pm_found = true;
                }


            }

        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
        return am_pm_found;

    }

    public SenderIdNamesFromList getSenderNameChangeName(String address, Context context) {

        String tempAddress = address;

        SenderIdNamesFromList senderIdNamesFromList = new SenderIdNamesFromList();


        if (!address.startsWith("+")) {

            boolean got_dash = false;

            tempAddress = tempAddress.replaceAll("\\$-", "S-");

            try {
                Matcher matcherDeleteLastDash = Pattern.compile("(?i)(^[a-zA-Z]{2}\\-)([a-zA-Z]{6})(\\-[a-zA-Z]+)").matcher(tempAddress);
                if (matcherDeleteLastDash.find()){
                    String group = matcherDeleteLastDash.group();
                    String group1 = matcherDeleteLastDash.group(1);
                    String group2 = matcherDeleteLastDash.group(2);
                    tempAddress = tempAddress.replace(group,group1+group2);
                }
            }catch (Exception e){
                logger.warning(e.getMessage());
            }

            Matcher match = Pattern.compile("(?i)^[a-zA-Z]{2}-").matcher(tempAddress);
            String outputmatch = "";
            if (match.find()) {
                outputmatch = match.group();
                got_dash = true;
            } else if (tempAddress.length() == 8) {
                if (tempAddress.contains("$")) {

                    tempAddress = tempAddress.replaceFirst("\\$", "S");
                }

                Matcher match3 = Pattern.compile("^[A-Z]{2}").matcher(tempAddress);
                if (match3.find()) {
                    outputmatch = match3.group();
                    got_dash = true;
                }
            }

            tempAddress = tempAddress.replaceFirst(outputmatch, "");



            SharedPreferences prefMyBANK = context.getSharedPreferences("PREFFMyBANK", Context.MODE_PRIVATE);
            String bank_sender_id = prefMyBANK.getString("bank_sender_id", "");


            String myAddress = tempAddress;
            if (tempAddress.length() == 8 && !got_dash && !TextUtils.isDigitsOnly(tempAddress)) {

                myAddress = myAddress.substring(myAddress.length() - 6);
                tempAddress = myAddress;
            }

            if (!TextUtils.isDigitsOnly(tempAddress)) {

                boolean put_in_json = false;

                SenderIdNamesFromList senderIdNamesFromList1 = getNameAndOtherValueSenderName(context, myAddress);

                if (senderIdNamesFromList1 != null) {

                    senderIdNamesFromList.setChangeNameOfSender(senderIdNamesFromList1.getChangeNameOfSender());
                    senderIdNamesFromList.setSenderIDPresent(true);
                    senderIdNamesFromList.setSenderNameFindWhere(senderIdNamesFromList1.getSenderNameFindWhere());
                    senderIdNamesFromList.setSenderNameLogo(senderIdNamesFromList1.getSenderNameLogo());
                    senderIdNamesFromList.setCheckIfBankID(senderIdNamesFromList1.getCheckIfBankID());

                } else if (bank_sender_id.toUpperCase().contains(myAddress.toUpperCase())) {
                    String bank_name = prefMyBANK.getString("bank_name", "");


                    String[] bank_id = bank_sender_id.split(",");
                    String[] bank_name_ = bank_name.split(",");


                    List<String> bankList_id = Arrays.asList(bank_id);
                    List<String> bankList_name = Arrays.asList(bank_name_);


                    int myAddressIndex = bankList_id.indexOf(myAddress.toUpperCase());

                    try {
                        tempAddress = bankList_name.get(myAddressIndex);

                        senderIdNamesFromList.setChangeNameOfSender(tempAddress);
                        senderIdNamesFromList.setSenderIDPresent(true);
                        senderIdNamesFromList.setSenderNameFindWhere(1);
                        senderIdNamesFromList.setCheckIfBankID("1");
                        put_in_json = true;
                    } catch (Exception e) {
                        logger.warning(e.getMessage());

                        senderIdNamesFromList.setSixCharacterSender(tempAddress);
                        senderIdNamesFromList.setChangeNameOfSender(tempAddress);
                        senderIdNamesFromList.setSenderNameLogo("");
                        senderIdNamesFromList.setSenderIDPresent(false);
                        senderIdNamesFromList.setSenderNameFindWhere(0);
                        senderIdNamesFromList.setCheckIfBankID("0");
                    }

                } else {

                    String knownOrganization = prefMyBANK.getString("just_sender_id", "");
                    String sender_id_next1000 = prefMyBANK.getString("senderID_1000", "");

                    String p_sender_id = prefMyBANK.getString("p_sender_id", "");


                    if (knownOrganization.toUpperCase().contains(myAddress.toUpperCase())) {

                        String organizationName = prefMyBANK.getString("just_name", "");


                        String[] arrayOrganizationId = knownOrganization.split(",");
                        String[] arrayOrganizationName = organizationName.split(",");


                        List<String> organizationListId = Arrays.asList(arrayOrganizationId);
                        List<String> organizationListName = Arrays.asList(arrayOrganizationName);


                        int myAddressIndex = organizationListId.indexOf(myAddress.toUpperCase());

                        try {
                            tempAddress = organizationListName.get(myAddressIndex);

                            senderIdNamesFromList.setChangeNameOfSender(tempAddress);
                            senderIdNamesFromList.setSenderIDPresent(true);
                            senderIdNamesFromList.setSenderNameFindWhere(2);
                            senderIdNamesFromList.setCheckIfBankID("0");
                            put_in_json = true;

                            FrameworkWords frameworkWords = new FrameworkWords(context);
                            String[] getStringForDataBaseB = frameworkWords.getStringForDataBaseB().split(",");

                            if (tempAddress.equalsIgnoreCase(getStringForDataBaseB[7]) ||
                                    tempAddress.toUpperCase().contains(getStringForDataBaseB[7]+" "+getStringForDataBaseB[8]) ||
                                    tempAddress.toUpperCase().contains(getStringForDataBaseB[7]+" "+getStringForDataBaseB[3])
                                    || tempAddress.equalsIgnoreCase(getStringForDataBaseB[10])
                                    || tempAddress.equalsIgnoreCase(getStringForDataBaseB[22])
                                    || tempAddress.equals(getStringForDataBaseB[23])){

                                senderIdNamesFromList.setCheckIfBankID("1");
                            }
                        } catch (Exception e) {
                            logger.warning(e.getMessage());

                            senderIdNamesFromList.setSixCharacterSender(tempAddress);
                            senderIdNamesFromList.setChangeNameOfSender(tempAddress);
                            senderIdNamesFromList.setSenderNameLogo("");
                            senderIdNamesFromList.setSenderIDPresent(false);
                            senderIdNamesFromList.setSenderNameFindWhere(0);
                            senderIdNamesFromList.setCheckIfBankID("0");
                        }




                    } else if (sender_id_next1000.toUpperCase().contains(myAddress.toUpperCase())) {

                        String organizationName1000 = prefMyBANK.getString("sender_names_1000", "");

                        String[] arrayOrganizationId1000 = sender_id_next1000.split(",");
                        String[] arrayOrganizationName = organizationName1000.split(",");


                        List<String> organizationListId1000 = Arrays.asList(arrayOrganizationId1000);
                        List<String> organizationListName1000 = Arrays.asList(arrayOrganizationName);


                        int myAddressIndex = organizationListId1000.indexOf(myAddress.toUpperCase());

                        try {
                            tempAddress = organizationListName1000.get(myAddressIndex);

                            senderIdNamesFromList.setChangeNameOfSender(tempAddress);
                            senderIdNamesFromList.setSenderIDPresent(true);
                            senderIdNamesFromList.setSenderNameFindWhere(3);
                            senderIdNamesFromList.setCheckIfBankID("0");
                            put_in_json = true;

                            FrameworkWords frameworkWords = new FrameworkWords(context);
                            String[] getStringForDataBaseB = frameworkWords.getStringForDataBaseB().split(",");

                            if (tempAddress.equalsIgnoreCase(getStringForDataBaseB[7]) ||
                                    tempAddress.toUpperCase().contains(getStringForDataBaseB[7]+" "+getStringForDataBaseB[8]) ||
                                    tempAddress.toUpperCase().contains(getStringForDataBaseB[7]+" "+getStringForDataBaseB[3])
                                    || tempAddress.equalsIgnoreCase(getStringForDataBaseB[10])
                                    || tempAddress.equalsIgnoreCase(getStringForDataBaseB[22])
                                    || tempAddress.equals(getStringForDataBaseB[23])){

                                senderIdNamesFromList.setCheckIfBankID("1");
                            }
                        } catch (Exception e) {
                            logger.warning(e.getMessage());

                            senderIdNamesFromList.setSixCharacterSender(tempAddress);
                            senderIdNamesFromList.setChangeNameOfSender(tempAddress);
                            senderIdNamesFromList.setSenderNameLogo("");
                            senderIdNamesFromList.setSenderIDPresent(false);
                            senderIdNamesFromList.setSenderNameFindWhere(0);
                            senderIdNamesFromList.setCheckIfBankID("0");
                        }

                    } else if (p_sender_id.toUpperCase().contains(myAddress.toUpperCase())) {

                        String p_sender_name = prefMyBANK.getString("p_sender_name", "");

                        String[] arrayPSenderId = p_sender_id.split(",");
                        String[] arrayPSenderName = p_sender_name.split(",");

                        List<String> pOrganizationId = Arrays.asList(arrayPSenderId);
                        List<String> pOrganizationName = Arrays.asList(arrayPSenderName);

                        int myAddressIndex = pOrganizationId.indexOf(myAddress);

                        try {
                            tempAddress = pOrganizationName.get(myAddressIndex);

                            senderIdNamesFromList.setChangeNameOfSender(tempAddress);
                            senderIdNamesFromList.setSenderIDPresent(true);
                            senderIdNamesFromList.setSenderNameFindWhere(5);
                            senderIdNamesFromList.setCheckIfBankID("0");
                            put_in_json = true;


                        } catch (Exception e) {
                            logger.warning(e.getMessage());

                            senderIdNamesFromList.setSixCharacterSender(tempAddress);
                            senderIdNamesFromList.setChangeNameOfSender(tempAddress);
                            senderIdNamesFromList.setSenderNameLogo("");
                            senderIdNamesFromList.setSenderIDPresent(false);
                            senderIdNamesFromList.setSenderNameFindWhere(0);
                            senderIdNamesFromList.setCheckIfBankID("0");
                        }
                    } else {

                        SenderDetails senderDetails = senderName(myAddress,context);
                        //String senderName = senderName(myAddress, context);

                        if (!senderDetails.getSenderNameFound().isEmpty()) {

                            tempAddress = senderDetails.getSenderNameFound();
                            senderIdNamesFromList.setChangeNameOfSender(tempAddress);
                            senderIdNamesFromList.setSenderIDPresent(true);
                            senderIdNamesFromList.setSenderNameFindWhere(4);
                            senderIdNamesFromList.setCheckIfBankID(senderDetails.getIsBankSender());
                            put_in_json = true;
                        } else {

                            String senderName = myAddress;
                            tempAddress = senderName;
                            senderIdNamesFromList.setChangeNameOfSender(tempAddress);
                            senderIdNamesFromList.setSenderIDPresent(false);
                            senderIdNamesFromList.setSenderNameFindWhere(0);
                            senderIdNamesFromList.setCheckIfBankID("0");
                            put_in_json = true;
                        }

                    }

                }
                senderIdNamesFromList.setSixCharacterSender(myAddress);

                if (put_in_json) {

                    try {
                        String allSenderID = prefMyBANK.getString("allSenderID", "");

                        if (allSenderID.toUpperCase().contains(tempAddress.toUpperCase())) {

                            String allSenderLogos = prefMyBANK.getString("allSenderLogo", "");

                            String[] arrayAllSenderId = allSenderID.split(",");
                            String[] arrayAllSenderLogo = allSenderLogos.split(",");
                            List<String> listAllSenderId = Arrays.asList(arrayAllSenderId);
                            List<String> listAllSenderLogo = Arrays.asList(arrayAllSenderLogo);
                            int myAddressIndex = listAllSenderId.indexOf(tempAddress);
                            String senderIDLogo = listAllSenderLogo.get(myAddressIndex);
                            senderIdNamesFromList.setSenderNameLogo(senderIDLogo);

                        }
                    } catch (Exception e) {
                        logger.warning(e.getMessage());

                        senderIdNamesFromList.setSixCharacterSender(tempAddress);
                        senderIdNamesFromList.setChangeNameOfSender(tempAddress);
                        senderIdNamesFromList.setSenderNameLogo("");
                        senderIdNamesFromList.setSenderIDPresent(false);
                        senderIdNamesFromList.setSenderNameFindWhere(0);
                        senderIdNamesFromList.setCheckIfBankID("0");

                    }

                    setJsonForSenderCharacter(context, myAddress, senderIdNamesFromList);
                }
            }else {
                senderIdNamesFromList.setSixCharacterSender(tempAddress);
                senderIdNamesFromList.setChangeNameOfSender(tempAddress);
                senderIdNamesFromList.setSenderNameLogo("");
                senderIdNamesFromList.setSenderIDPresent(false);
                senderIdNamesFromList.setSenderNameFindWhere(0);
                senderIdNamesFromList.setCheckIfBankID("0");
            }
        }
        else {
            senderIdNamesFromList.setSixCharacterSender(tempAddress);
            senderIdNamesFromList.setChangeNameOfSender(tempAddress);
            senderIdNamesFromList.setSenderNameLogo("");
            senderIdNamesFromList.setSenderIDPresent(false);
            senderIdNamesFromList.setSenderNameFindWhere(0);
            senderIdNamesFromList.setCheckIfBankID("0");

        }
        return senderIdNamesFromList;
    }


    private SenderDetails senderName(String address, Context context){

        //String senderName = "";

        SenderDetails senderDetails = new SenderDetails();
        SiValue siValue = new SiValue();
        senderDetails = siValue.senderName(address,context);

        return  senderDetails;

    }

    private void setJsonForSenderCharacter(Context context, String senderName,
                                           SenderIdNamesFromList senderIdNamesFromList){

        SharedPreferences prefSenderNames = context.getSharedPreferences("SenderNames", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorSenderName = prefSenderNames.edit();



        try {
            Gson gson = new Gson();
            String json = prefSenderNames.getString("SenderNamesWithValues", "");
            Type type = new TypeToken<Map<String, SenderIdNamesFromList>>() {
            }.getType();
            Map<String, SenderIdNamesFromList> arrayList = gson.fromJson(json, type);

            Map<String, SenderIdNamesFromList> arraylistSenderIdNames = new LinkedHashMap<>();

            arraylistSenderIdNames = arrayList;

            if (arraylistSenderIdNames == null) {

                arraylistSenderIdNames = new LinkedHashMap<>();

                final SenderIdNamesFromList senderIdNamesFromList1 = new SenderIdNamesFromList();
                senderIdNamesFromList1.setSixCharacterSender(senderName);
                senderIdNamesFromList1.setSenderNameFindWhere(senderIdNamesFromList.getSenderNameFindWhere());
                senderIdNamesFromList1.setSenderIDPresent(true);
                senderIdNamesFromList1.setSenderNameLogo((senderIdNamesFromList.getSenderNameLogo()));
                senderIdNamesFromList1.setChangeNameOfSender(senderIdNamesFromList.getChangeNameOfSender());
                senderIdNamesFromList1.setCheckIfBankID(senderIdNamesFromList.getCheckIfBankID());



                arraylistSenderIdNames.put( senderName, senderIdNamesFromList1);

                Gson gson111 = new Gson();
                String jsonFirstVal = gson111.toJson(arraylistSenderIdNames);
                editorSenderName.putString("SenderNamesWithValues", jsonFirstVal);
                editorSenderName.apply();

            }else {



                if (!arrayList.containsKey(senderName)) {

                    final SenderIdNamesFromList senderIdNamesFromList1 = new SenderIdNamesFromList();
                    senderIdNamesFromList1.setSixCharacterSender(senderName);
                    senderIdNamesFromList1.setSenderNameFindWhere(senderIdNamesFromList.getSenderNameFindWhere());
                    senderIdNamesFromList1.setSenderIDPresent(true);
                    senderIdNamesFromList1.setSenderNameLogo((senderIdNamesFromList.getSenderNameLogo()));
                    senderIdNamesFromList1.setChangeNameOfSender(senderIdNamesFromList.getChangeNameOfSender());
                    senderIdNamesFromList1.setCheckIfBankID(senderIdNamesFromList.getCheckIfBankID());
                    arraylistSenderIdNames.put(senderName, senderIdNamesFromList1);

                    Gson gson111 = new Gson();
                    String jsonFirstVal = gson111.toJson(arraylistSenderIdNames);
                    editorSenderName.putString("SenderNamesWithValues", jsonFirstVal);
                    editorSenderName.apply();
                }

            }



        }catch (Exception e){
            logger.warning(e.getMessage());
        }

    }


    public SenderIdNamesFromList getNameAndOtherValueSenderName(Context context, String senderName){


        SenderIdNamesFromList senderIdNamesFromList = new SenderIdNamesFromList();

        SharedPreferences prefSenderNames = context.getSharedPreferences("SenderNames", Context.MODE_PRIVATE);

        try {
            Gson gson = new Gson();
            String json = prefSenderNames.getString("SenderNamesWithValues", "");
            Type type = new TypeToken<Map<String, SenderIdNamesFromList>>() {
            }.getType();
            Map<String, SenderIdNamesFromList> arrayList = gson.fromJson(json, type);

            Map<String, SenderIdNamesFromList> arraylistSenderIdNames = new LinkedHashMap<>();

            arraylistSenderIdNames = arrayList;

            if (arraylistSenderIdNames != null) {

                SenderIdNamesFromList senderIdNamesFromList1 = arraylistSenderIdNames.get(senderName);

                if (senderIdNamesFromList1!=null) {

                    /*if (senderIdNamesFromList1.getChangeNameOfSender().isEmpty()){
                        return null;
                    }*/

                    senderIdNamesFromList.setSenderNameLogo(senderIdNamesFromList1.getSenderNameLogo());
                    senderIdNamesFromList.setSixCharacterSender(senderIdNamesFromList1.getSixCharacterSender());
                    senderIdNamesFromList.setSenderIDPresent(true);
                    senderIdNamesFromList.setSenderNameFindWhere(senderIdNamesFromList1.getSenderNameFindWhere());
                    senderIdNamesFromList.setChangeNameOfSender(senderIdNamesFromList1.getChangeNameOfSender());
                    senderIdNamesFromList.setCheckIfBankID(senderIdNamesFromList1.getCheckIfBankID());

                }else {
                    return null;
                }
            }else {
                return null;
            }

        }catch (Exception e){
            logger.warning(e.getMessage());
        }


        return senderIdNamesFromList;
    }





/*    public static native String decrypt(String val1);

    public static native String encrypt(String val1);*/

}

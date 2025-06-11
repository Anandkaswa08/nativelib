package com.createlibrary.nativelib;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AttachmentPreviewInsight {


    Context mContext;
    Logger logger = Logger.getLogger("AttachmentPreviewInsight");



    /** This function Check if SMS is transaction SMS or Not.
     * <p>
     * SMS goes through different module of finding Account number , credit debit module
     * to check if its bank transaction</p>
     *
     * @param incomingSender - SMS senderID.
     * @param incomingSms - Text SMS.
     * @return BlockResult
     * */
    public BlockResult isBankTransaction(String incomingSender, String incomingSms,
                                         Context context, int iGEtSTAT, String changeSender,
                                         String withOutUrlSMS, String checkIfBankID, String[] extra10,
                                         long timeOfSMS) {


        boolean your_word_present = false;

        mContext = context;

        FrameworkWords frameworkWords = new FrameworkWords(mContext);

        CommonLogicFunction commonLogicFunction = new CommonLogicFunction();

        String tempSender = incomingSender;

        BlockResult blockResult = new BlockResult();

        String[] sendersToAvoid = frameworkWords.sendersToAvoid();
        String[] sendersToAvoidChangedName = frameworkWords.sendersToAvoidChangedName();

        boolean checkIfIgnoredSender = false;

        try {
            Matcher matchSenders2 = Pattern.compile("(?i)(" + sendersToAvoidChangedName[0] + "|" +
                    "" + sendersToAvoidChangedName[1] + "|" + sendersToAvoidChangedName[2] + "|" +
                    "" + sendersToAvoidChangedName[3] + "|" + sendersToAvoidChangedName[4] + "|" +
                    "" + sendersToAvoidChangedName[5] + "|" + sendersToAvoidChangedName[6] + "|" +
                    "" + sendersToAvoidChangedName[7] + "|^" + sendersToAvoidChangedName[8] + "|" +
                    "" + sendersToAvoidChangedName[9] + "|" + sendersToAvoidChangedName[10] + "|" +
                    "" + sendersToAvoidChangedName[11] + "|" + sendersToAvoidChangedName[12] + "|" +
                    "" + sendersToAvoidChangedName[13] + "|" + sendersToAvoidChangedName[14] + "|" +
                    "" + sendersToAvoidChangedName[15] + "|" + sendersToAvoidChangedName[16] + "|" +
                    "" + sendersToAvoidChangedName[17] + "|" + sendersToAvoidChangedName[18] + "|" +
                    "" + sendersToAvoidChangedName[19] + "|" + sendersToAvoidChangedName[20] + "|" +
                    "^" + sendersToAvoidChangedName[21] + "$|" + sendersToAvoidChangedName[22] + "|" +
                    "" + sendersToAvoidChangedName[23] + "|" + sendersToAvoidChangedName[24] + "|" +
                    "" + sendersToAvoidChangedName[25] + "|" + sendersToAvoidChangedName[26] + "|" +
                    "" + sendersToAvoidChangedName[27] + "|" + sendersToAvoidChangedName[28] + ")").matcher(changeSender);
            Matcher matchSenders = Pattern.compile("(?i)(" + sendersToAvoid[0] + "|" + sendersToAvoid[1] + "|" + sendersToAvoid[2] + "|" + sendersToAvoid[3] + "|" + sendersToAvoid[4] + "|" + sendersToAvoid[5] + "|" + sendersToAvoid[6] + "|" + sendersToAvoid[7] + "|" + sendersToAvoid[9] + "|" + sendersToAvoid[10] + "|" + sendersToAvoid[11] + "|" + sendersToAvoid[12] + "|" + sendersToAvoid[13] + "|" + sendersToAvoid[14] + "|" + sendersToAvoid[15] + ")").matcher(incomingSender);

            if (matchSenders.find()){
                if (!checkIfBankID.equals("1")) {
                    checkIfIgnoredSender = true;
                }
            }else if (matchSenders2.find()){
                //String dsjbdssj= matchSenders2.group();
                checkIfIgnoredSender = true;
            }


        }catch (Exception e){

        }

        if (checkIfIgnoredSender || TextUtils.isDigitsOnly(tempSender)) {
            blockResult.setPass_output(0);
            return blockResult;

        } else {


            try {

                String[] account_1 = frameworkWords.account_1();
                String[] CASE15 = frameworkWords.CASE15();


                String actualAvailableBalance = "";
                String availableBalance1 = "";
                String availableBalance2 = "";


                String available_bal1_text="";
                String available_bal2_text="";


                String where_at = "";
                String mode_of_trans = "";
                String accountNO = "";
                String accountNODigitsOnly = "";

                String cardNO = "";
                String cardNODigitsOnly = "";

                incomingSms=incomingSms.replaceAll("\\n"," _______ ").trim();
                withOutUrlSMS=withOutUrlSMS.replaceAll("\\n"," _______ ").trim();
                String complete_SMS = incomingSms;

                String[] bal_amt3 = frameworkWords.balAmount3();
                String[] wat4 = frameworkWords.wat4();
                String[] card_2 = frameworkWords.card_2();
                String[] bncd8 = frameworkWords.bncd8();

                SubClassAttachmentPreview subClassAttachmentPreview = new SubClassAttachmentPreview();

                incomingSms = subClassAttachmentPreview.changeIncomingSMS(incomingSms, account_1,
                        bal_amt3, wat4, extra10, CASE15, card_2, bncd8);

                withOutUrlSMS=withOutUrlSMS.replaceAll("(?i)"+wat4[37]+"\\/"+CASE15[113]+"","").trim();

                String msg_text = incomingSms;

                boolean check_for_more = false;

                boolean act_next = false;
                boolean will_be_case = false;

                String myIncomingText = incomingSms;


                myIncomingText = myIncomingText.toLowerCase();

                //deleted case


                String temp_account_no = "";
                String temp_account_no_digits = "";

                String temp_account_no_2 = "";
                String temp_account_no_digits_2 = "";

                String loan_account_no = "";
                String loan_account_no_2 = "";


                try {

                    blockResult.setLoan_or_other("-");

                    Matcher match44 = Pattern.compile("(?i)(?<!(" + account_1[2] + "|" + account_1[24] + ")(\\w|\\W){1,3})(a\\/c|" + account_1[3] + "|" + account_1[4] + "|" + account_1[5] + "|" + account_1[6] + "|[ |.|-](?<!(" + account_1[2] + "|" + account_1[24] + ")(\\w|\\W){1,3})" + account_1[7] + "|^" + account_1[7] + ")(\\s|[[" + account_1[15] + "]]+)(" + account_1[8] + "|[[" + account_1[15] + "]]+|" + account_1[9] + "|)(\\W+|)([[" + account_1[15] + "]]+|" + card_2[3] + "|" + card_2[4] + "|" + card_2[5] + "|)\\s*([[" + account_1[15] + "]]+|" + card_2[6] + "|)([[" + account_1[15] + "]]+|" + account_1[16] + "|)(((\\w|\\W){0,12}((\\.|\\*){2,}|(x){1,}))|\\s*)\\s*[" + account_1[13] + "\\/]{2,}").matcher(msg_text);


                    while (match44.find()) {


                        if (accountNO.isEmpty()) {
                            String accountNumber = match44.group();


                            Matcher match5 = Pattern.compile("(?i)((\\.|\\*|){2,}|(x){1,})\\s*[" + account_1[13] + "\\/]{2,}").matcher(accountNumber);

                            String otherToDelete = "";

                            String string_to_match = "";

                            if (match5.find()) {

                                String match5string = match5.group().trim();
                                if (match5string.startsWith(". ")) {
                                    match5string = match5string.replaceFirst("\\.\\s", "").trim();
                                }
                                Matcher matcherTest = Pattern.compile("(?i)[^\\s]+").matcher(accountNumber);

                                while (matcherTest.find()) {

                                    String gotItGroup = matcherTest.group();
                                    if (gotItGroup.contains(match5string)) {

                                        gotItGroup = gotItGroup.replaceAll("[" + account_1[14] + "]", "");
                                        if (temp_account_no.isEmpty()) {
                                            temp_account_no = gotItGroup.trim();
                                            //multiple_match=multiple_match+match5.group();
                                            string_to_match = gotItGroup.trim();
                                            loan_account_no = accountNumber;
                                        } else {
                                            temp_account_no_2 = gotItGroup.trim();
                                            string_to_match = gotItGroup.trim();
                                            loan_account_no_2 = accountNumber;
                                        }

                                        otherToDelete = gotItGroup;
                                        break;
                                    }
                                }

                                if (string_to_match.isEmpty()) {

                                    if (temp_account_no.isEmpty()) {
                                        temp_account_no = match5string;
                                        //multiple_match=multiple_match+match5.group();
                                        string_to_match = match5string;
                                    } else {
                                        temp_account_no_2 = match5string;
                                        string_to_match = match5string;
                                    }
                                    otherToDelete = match5string;
                                }


                                String abc2 = "";
                                try {
                                    int index2 = msg_text.indexOf(string_to_match) - 30;

                                    if (index2 < 0) {
                                        index2 = 0;
                                    }
                                    abc2 = msg_text.substring(index2, msg_text.indexOf(string_to_match));
                                } catch (Exception e) {

                                    try {
                                        int index2 = msg_text.indexOf(match5string) - 30;

                                        if (index2 < 0) {
                                            index2 = 0;
                                        }
                                        abc2 = msg_text.substring(index2, msg_text.indexOf(match5string));
                                    } catch (Exception ed) {
                                        logger.warning(ed.getMessage());
                                    }

                                }


                                Matcher match52 = Pattern.compile("(?i)[" + account_1[13] + "]{2,}").matcher(string_to_match);

                                while (match52.find()) {

                                    if (!match52.hitEnd()) {
                                        continue;
                                    }

                                    if (abc2.toLowerCase().contains(account_1[10])) {
                                        your_word_present = true;
                                        accountNO = temp_account_no;

                                        accountNODigitsOnly = match52.group();

                                        if (accountNODigitsOnly.length() > 4) {
                                            accountNODigitsOnly = accountNODigitsOnly.substring(accountNODigitsOnly.length() - 4);
                                        }

                                        try {

                                            int stringLength = incomingSms.toLowerCase().indexOf(accountNumber.toLowerCase());

                                            int start_index = stringLength - 10;
                                            if (start_index<0){
                                                start_index = 0;
                                            }

                                            String isl = incomingSms.toLowerCase().substring(start_index, stringLength);
                                            if (isl.contains(account_1[17])||isl.contains(account_1[25])) {
                                                blockResult.setLoan_or_other(account_1[17]);
                                            }else if (isl.contains(account_1[26])){
                                                blockResult.setLoan_or_other(account_1[26]);
                                            }else {

                                                Matcher matcher = Pattern.compile("(?i)(^|\\W)("+CASE15[96]+"|"+CASE15[97]+"|"+CASE15[98]+")(\\W|$)").matcher(isl);

                                                if (matcher.find()){
                                                    blockResult.setLoan_or_other(""+CASE15[99]+" "+CASE15[96]+"");
                                                }
                                            }


                                        } catch (Exception e) {
                                            // logger.warning(e.getMessage());
                                        }

                                        blockResult.setPass_acc_no(accountNODigitsOnly);

                                    } else if (accountNO.isEmpty()) {

                                        if (temp_account_no_digits.isEmpty()) {
                                            temp_account_no_digits = match52.group().trim();
                                            loan_account_no = accountNumber;
                                        } else {
                                            temp_account_no_digits_2 = match52.group().trim();
                                            loan_account_no_2 = accountNumber;
                                        }
                                    }


                                    myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");
                                }

                            }
                        }

                    }

                } catch (Exception e) {
                    logger.warning(e.getMessage());
                }
                if (accountNO.isEmpty()) {


                    if (msg_text.toLowerCase().contains(account_1[4]) || msg_text.toLowerCase().contains(account_1[7]) || msg_text.toLowerCase().contains("" + account_1[18] + "")) {


                        //Matcher match4 = Pattern.compile("(?i)(?<!"+account_1[2]+"(\\w|\\W){1,3})(a\\/c|"+account_1[3]+"|"+account_1[4]+"|"+account_1[5]+"|"+account_1[6]+"|[ |.|-](?<!"+account_1[2]+"(\\w|\\W){1,3})"+account_1[7]+"|^"+account_1[7]+")(\\s|[["+account_1[15]+"]]+)("+account_1[8]+"|[["+account_1[15]+"]]+|"+account_1[9]+"|)\\s*([["+account_1[15]+"]]+|)\\s*.*?((\\.|\\*){2,}|(x){1,})\\s*["+account_1[13]+"]{2,}").matcher(msg_text);
                        Matcher match4 = Pattern.compile("(?i)(?<!(" + account_1[2] + "|" + account_1[24] + ")(\\w|\\W){1,3})(a\\/c|" + account_1[3] + "|" + account_1[4] + "|" + account_1[5] + "|" + account_1[6] + "|[ |.|-](?<!(" + account_1[2] + "|" + account_1[24] + ")(\\w|\\W){1,3})" + account_1[7] + "|^" + account_1[7] + ")(\\s|[[" + account_1[15] + "]]+)(" + account_1[8] + "|[[" + account_1[15] + "]]+|" + account_1[9] + "|)\\s*([[" + account_1[15] + "]]+|)\\s*(\\W|\\w){0,20}((\\.|\\*){2,}|(x){1,})\\s*[" + account_1[13] + "\\/]{2,}").matcher(msg_text);


                        //String multiple_match="";

                        while (match4.find()) {

                            if (accountNO.isEmpty()) {
                                String accountNumber = match4.group();


                                Matcher match5 = Pattern.compile("(?i)((\\.|\\*){2,}|(x){1,})\\s*[" + account_1[13] + "]{2,}").matcher(accountNumber);

                                String otherToDelete = "";

                                String string_to_match = "";

                                if (match5.find()) {

                                    String match5string = match5.group().trim();
                                    Matcher matcherTest = Pattern.compile("(?i)[^\\s]+").matcher(accountNumber);

                                    while (matcherTest.find()) {

                                        String gotItGroup = matcherTest.group();
                                        if (gotItGroup.contains(match5string)) {

                                            gotItGroup = gotItGroup.replaceAll("[" + account_1[14] + "]", "");
                                            if (temp_account_no.isEmpty()) {
                                                temp_account_no = gotItGroup.trim();
                                                //multiple_match=multiple_match+match5.group();
                                                string_to_match = gotItGroup.trim();
                                            } else {
                                                temp_account_no_2 = gotItGroup.trim();
                                                string_to_match = gotItGroup.trim();
                                            }

                                            otherToDelete = gotItGroup;
                                            break;

                                        }

                                    }

                                    if (string_to_match.isEmpty()) {

                                        if (temp_account_no.isEmpty()) {
                                            temp_account_no = match5string;
                                            //multiple_match=multiple_match+match5.group();
                                            string_to_match = match5string;
                                        } else {
                                            temp_account_no_2 = match5string;
                                            string_to_match = match5string;
                                        }

                                        otherToDelete = match5string;


                                    }

                                    String abc2 = "";
                                    try {
                                        int index2 = msg_text.indexOf(string_to_match) - 30;

                                        if (index2 < 0) {
                                            index2 = 0;
                                        }
                                        abc2 = msg_text.substring(index2, msg_text.indexOf(string_to_match));
                                    } catch (Exception e) {

                                        try {
                                            int index2 = msg_text.indexOf(match5string) - 30;

                                            if (index2 < 0) {
                                                index2 = 0;
                                            }
                                            abc2 = msg_text.substring(index2, msg_text.indexOf(match5string));
                                        } catch (Exception ed) {
                                            logger.warning(ed.getMessage());
                                        }

                                    }


                                    Matcher match52 = Pattern.compile("(?i)[" + account_1[13] + "]{2,}").matcher(string_to_match);

                                    while (match52.find()) {

                                        if (!match52.hitEnd()) {
                                            continue;
                                        }

                                        if (abc2.toLowerCase().contains(account_1[10])) {
                                            your_word_present = true;
                                            accountNO = temp_account_no;

                                            accountNODigitsOnly = match52.group();

                                            if (accountNODigitsOnly.length() > 4) {
                                                accountNODigitsOnly = accountNODigitsOnly.substring(accountNODigitsOnly.length() - 4);
                                            }

                                            try {

                                                int stringLength = incomingSms.toLowerCase().indexOf(accountNumber.toLowerCase());

                                                int start_index = stringLength - 10;
                                                if (start_index<0){
                                                    start_index = 0;
                                                }
                                                String isl = incomingSms.toLowerCase().substring(start_index, stringLength);
                                                if (isl.contains(account_1[17])||isl.contains(account_1[25])) {
                                                    blockResult.setLoan_or_other(account_1[17]);
                                                }else if (isl.contains(account_1[26])){
                                                    blockResult.setLoan_or_other(account_1[26]);
                                                }else {

                                                    Matcher matcher = Pattern.compile("(?i)(^|\\W)("+CASE15[96]+"|"+CASE15[97]+"|"+CASE15[98]+")(\\W|$)").matcher(isl);

                                                    if (matcher.find()){
                                                        blockResult.setLoan_or_other(""+CASE15[99]+" "+CASE15[96]+"");
                                                    }
                                                }


                                            } catch (Exception e) {
                                                logger.warning(e.getMessage());
                                            }

                                            blockResult.setPass_acc_no(accountNODigitsOnly);

                                        } else if (accountNO.isEmpty()) {

                                            if (temp_account_no_digits.isEmpty()) {
                                                temp_account_no_digits = match52.group().trim();
                                                loan_account_no = accountNumber;
                                            } else {
                                                temp_account_no_digits_2 = match52.group().trim();
                                                loan_account_no_2 = accountNumber;
                                            }
                                        }
                                        myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");
                                    }

                                }
                            }

                        }
                    }

                }
                if (accountNO.isEmpty()) {

                    if (!temp_account_no.isEmpty()) {


                        accountNO = temp_account_no;
                        accountNODigitsOnly = temp_account_no_digits;

                        if (accountNODigitsOnly.length() > 4) {
                            accountNODigitsOnly = accountNODigitsOnly.substring(accountNODigitsOnly.length() - 4);
                        }

                        try {

                            int stringLength = incomingSms.toLowerCase().indexOf(loan_account_no.toLowerCase());

                            int start_index = stringLength - 10;
                            if (start_index<0){
                                start_index = 0;
                            }
                            String isl = incomingSms.toLowerCase().substring(start_index, stringLength);
                            if (isl.contains(account_1[17])||isl.contains(account_1[25])) {

                                blockResult.setLoan_or_other(account_1[17]);
                            }else if (isl.contains(account_1[26])){
                                blockResult.setLoan_or_other(account_1[26]);
                            }else {

                                Matcher matcher = Pattern.compile("(?i)(^|\\W)("+CASE15[96]+"|"+CASE15[97]+"|"+CASE15[98]+")(\\W|$)").matcher(isl);

                                if (matcher.find()){
                                    blockResult.setLoan_or_other(""+CASE15[99]+" "+CASE15[96]+"");
                                }
                            }


                        } catch (Exception e) {
                            logger.warning(e.getMessage());
                        }

                        blockResult.setPass_acc_no(accountNODigitsOnly);


                    } else if (!temp_account_no_2.isEmpty()) {

                        accountNO = temp_account_no_2;
                        accountNODigitsOnly = temp_account_no_digits_2;

                        if (accountNODigitsOnly.length() > 4) {
                            accountNODigitsOnly = accountNODigitsOnly.substring(accountNODigitsOnly.length() - 4);
                        }

                        try {

                            int stringLength = incomingSms.toLowerCase().indexOf(loan_account_no_2.toLowerCase());

                            int start_index = stringLength - 10;
                            if (start_index<0){
                                start_index = 0;
                            }

                            String isl = incomingSms.toLowerCase().substring(start_index, stringLength);
                            if (isl.contains(account_1[17])||isl.contains(account_1[25])) {

                                blockResult.setLoan_or_other(account_1[17]);
                            }else if (isl.contains(account_1[26])){
                                blockResult.setLoan_or_other(account_1[26]);
                            }else {

                                Matcher matcher = Pattern.compile("(?i)(^|\\W)("+CASE15[96]+"|"+CASE15[97]+"|"+CASE15[98]+")(\\W|$)").matcher(isl);

                                if (matcher.find()){
                                    blockResult.setLoan_or_other(""+CASE15[99]+" "+CASE15[96]+"");
                                }
                            }


                        } catch (Exception e) {
                            logger.warning(e.getMessage());
                        }

                        blockResult.setPass_acc_no(accountNODigitsOnly);

                    }


                }

                if (accountNO.isEmpty()) {
                    try {

                        Matcher match4 = Pattern.compile("(?i)(?<!(" + account_1[2] + "|" + account_1[24] + ")(\\w|\\W){1,3})(a\\/c|" + account_1[3] + "|" + account_1[4] + "|" + account_1[5] + "|" + account_1[6] + "|[ |.|-](?<!(" + account_1[2] + "|" + account_1[24] + ")(\\w|\\W){1,3})" + account_1[7] + "|^" + account_1[7] + ")((\\.|\\*){2,}|(x){1,}|)\\s*([" + account_1[13] + "\\/]{4,})( |\\.|\\:)").matcher(msg_text);

                        if (match4.find()) {


                            String complete_match = match4.group();
                            String acc_nos = match4.group(9);
                            String xString = match4.group(6);

                            temp_account_no = xString + acc_nos;
                            loan_account_no = complete_match;

                            accountNO = temp_account_no.trim();
                            accountNODigitsOnly = acc_nos.trim();

                            if (accountNODigitsOnly.length() > 4) {
                                accountNODigitsOnly = accountNODigitsOnly.substring(accountNODigitsOnly.length() - 4);
                            }

                            try {

                                int stringLength = incomingSms.toLowerCase().indexOf(loan_account_no.toLowerCase());
                                int start_index = stringLength - 10;
                                if (start_index<0){
                                    start_index = 0;
                                }
                                String isl = incomingSms.toLowerCase().substring(start_index, stringLength);
                                if (isl.contains(account_1[17])||isl.contains(account_1[25])) {

                                    blockResult.setLoan_or_other(account_1[17]);
                                }else if (isl.contains(account_1[26])){
                                    blockResult.setLoan_or_other(account_1[26]);
                                }else {

                                    Matcher matcher = Pattern.compile("(?i)(^|\\W)("+CASE15[96]+"|"+CASE15[97]+"|"+CASE15[98]+")(\\W|$)").matcher(isl);

                                    if (matcher.find()){
                                        blockResult.setLoan_or_other(""+CASE15[99]+" "+CASE15[96]+"");
                                    }
                                }


                            } catch (Exception e) {
                                logger.warning(e.getMessage());
                            }

                            blockResult.setPass_acc_no(accountNODigitsOnly);


                        }


                    } catch (Exception e) {
                        logger.warning(e.getMessage());
                    }
                }

                //"card"
                if (msg_text.toLowerCase().contains(CASE15[37])) {


                    //Matcher match499 = Pattern.compile("(?i)("+card_2[1]+"|"+card_2[2]+"|)(\\s*|[["+account_1[15]+"]]+)("+card_2[0]+")\\s*("+card_2[9]+"|"+card_2[10]+")\\s*([["+account_1[15]+"]]+|"+card_2[3]+"|"+card_2[4]+"|"+card_2[5]+")\\s*([["+account_1[15]+"]]+|"+card_2[6]+"|)\\s*.*?((\\.|\\*){2,}|(x){1,})\\s*["+account_1[13]+"]{2,}").matcher(msg_text);
                    Matcher match499 = Pattern.compile("(?i)(" + card_2[1] + "|" + card_2[2] + "|)(\\s*|[[" + account_1[15] + "]]+)(" + card_2[0] + ")\\s*(" + card_2[9] + "|" + card_2[10] + "|" + card_2[11] + ")\\s*([[" + account_1[15] + "]]+|" + card_2[3] + "|" + card_2[4] + "|" + card_2[5] + ")\\s*([[" + account_1[15] + "]]+|" + card_2[6] + "|)\\s*(\\W|\\w){0,20}((\\.|\\*){2,}|(x){1,})\\s*[" + account_1[13] + "]{2,}").matcher(msg_text);

                    if (match499.find()) {
                        String accountNumber = match499.group();

                        Matcher match5 = Pattern.compile("(?i)((\\.|\\*){2,}|(x){1,})\\s*[" + account_1[13] + "]{2,}").matcher(accountNumber);
                        String otherToDelete = "";
                        if (match5.find()) {

                            String match5string = match5.group().trim();
                            Matcher matcherTest = Pattern.compile("(?i)[^\\s]+").matcher(accountNumber);

                            while (matcherTest.find()) {
                                String gotItGroup = matcherTest.group();
                                gotItGroup = gotItGroup.replaceAll("[" + account_1[14] + "]", "");
                                if (gotItGroup.contains(match5string)) {

                                    otherToDelete = match5.group();
                                    cardNO = gotItGroup;

                                    break;
                                }
                            }


                            if (cardNO.isEmpty()) {

                                otherToDelete = match5.group();
                                cardNO = match5.group().trim();

                            }

                            if (!cardNO.equals(accountNO)) {

                                Matcher match52 = Pattern.compile("(?i)[" + account_1[13] + "]{2,}").matcher(cardNO);

                                while (match52.find()) {
                                    if (!match52.hitEnd()) {
                                        continue;
                                    }
                                    cardNODigitsOnly = match52.group();



                                    if (cardNODigitsOnly.length() > 4) {
                                        cardNODigitsOnly = cardNODigitsOnly.substring(cardNODigitsOnly.length() - 4);
                                    }

                                    blockResult.setPass_card_no(cardNODigitsOnly);
                                    myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");
                                    myIncomingText = myIncomingText.replaceAll("(?i)(" + card_2[2] + "|" + card_2[1] + ")\\s*" + card_2[0], "");


                                    /*if (!accountNumber.toLowerCase().contains(card_2[1]) && !accountNumber.toLowerCase().contains(card_2[2]) && (blockResult.getOut_standing() > 0 || !limit_check.equals(""))) {
                                        blockResult.setPass_card_type(card_2[7]);
                                    } else*/
                                    if (!accountNumber.toLowerCase().contains(card_2[1]) && !accountNumber.toLowerCase().contains(card_2[2])) {
                                        blockResult.setPass_card_type(card_2[8]);
                                    } else if (accountNumber.toLowerCase().contains(card_2[1])) {

                                        blockResult.setPass_card_type(card_2[8]);
                                    } else {
                                        blockResult.setPass_card_type(card_2[7]);
                                    }
                                }
                            } else if (cardNO.equals(accountNO)) {
                                try {


                                    Matcher matcher = Pattern.compile("(?i)(" + card_2[1] + "|" + card_2[2] + ")\\s" + card_2[0] + "\\s(a\\/c|" + account_1[3] + "|" + account_1[4] + "|" + account_1[5] + "|" + account_1[6] + "|[ |.|-]" + account_1[7] + "|^" + account_1[7] + ")").matcher(accountNumber);

                                    if (matcher.find()) {
                                        Matcher match52 = Pattern.compile("(?i)[" + account_1[13] + "]{2,}").matcher(cardNO);

                                        while (match52.find()) {
                                            if (!match52.hitEnd()) {
                                                continue;
                                            }
                                            cardNODigitsOnly = match52.group().trim();



                                            if (cardNODigitsOnly.length() > 4) {
                                                cardNODigitsOnly = cardNODigitsOnly.substring(cardNODigitsOnly.length() - 4);
                                            }

                                            blockResult.setPass_card_no(cardNODigitsOnly);
                                            myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");
                                            myIncomingText = myIncomingText.replaceAll("(?i)(" + card_2[2] + "|" + card_2[1] + ")\\s*" + card_2[0], "");


                                     /*   if (!accountNumber.toLowerCase().contains(card_2[1]) && !accountNumber.toLowerCase().contains(card_2[2]) && (blockResult.getOut_standing() > 0 || !limit_check.equals(""))) {
                                            blockResult.setPass_card_type(card_2[7]);
                                        } else*/
                                            if (!accountNumber.toLowerCase().contains(card_2[1]) && !accountNumber.toLowerCase().contains(card_2[2])) {
                                                blockResult.setPass_card_type(card_2[8]);
                                            } else if (accountNumber.toLowerCase().contains(card_2[1])) {

                                                blockResult.setPass_card_type(card_2[8]);
                                            } else {
                                                blockResult.setPass_card_type(card_2[7]);
                                            }

                                            blockResult.setPass_acc_no("-1");
                                            blockResult.setPass_acc_full_name("");
                                            accountNO = "";
                                            temp_account_no = "";
                                            temp_account_no_2 = "";
                                            accountNODigitsOnly = "";
                                        }
                                    }

                                } catch (Exception ee) {
                                    logger.warning(ee.getMessage());
                                }
                            }


                        }

                    } else {

                        //card not with XXXX

                        Matcher match4993 = Pattern.compile("(?i)(" + card_2[1] + "|" + card_2[2] + "|)(\\s*|[[" + account_1[15] + "]]+)(" + card_2[0] + ")\\s*(" + card_2[9] + "|" + card_2[10] + "|" + card_2[11] + ")\\s*([[" + account_1[15] + "]]+|" + card_2[3] + "|" + card_2[4] + "|" + card_2[5] + ")\\s*([[" + account_1[15] + "]]+|" + card_2[6] + "|)\\s*[" + account_1[19] + "]{0,5}\\s*((\\.|\\*|){2,}|(x){1,})\\s*[" + account_1[13] + "]{2,}").matcher(msg_text);

                        if (match4993.find()) {
                            String accountNumber = match4993.group();

                            Matcher match5 = Pattern.compile("(?i)((\\.|\\*){2,}|(x){1,})\\s*[" + account_1[13] + "]{2,}").matcher(accountNumber);

                            String otherToDelete = "";
                            if (match5.find()) {

                                String match5string = match5.group().trim();
                                Matcher matcherTest = Pattern.compile("(?i)[^\\s]+").matcher(accountNumber);

                                while (matcherTest.find()) {

                                    String gotItGroup = matcherTest.group();
                                    gotItGroup = gotItGroup.replaceAll("[" + account_1[14] + "]", "");
                                    if (gotItGroup.contains(match5string)) {

                                        otherToDelete = match5.group();
                                        cardNO = gotItGroup;

                                        break;
                                    }
                                }

                                if (cardNO.isEmpty()) {

                                    otherToDelete = match5.group();
                                    cardNO = match5.group().trim();

                                }


                                if (!cardNO.equals(accountNO)) {

                                    Matcher match52 = Pattern.compile("(?i)[" + account_1[13] + "]{2,}").matcher(cardNO);


                                    while (match52.find()) {
                                        if (!match52.hitEnd()) {
                                            continue;
                                        }
                                        cardNODigitsOnly = match52.group().trim();

                                        if (cardNODigitsOnly.length() > 4) {
                                            cardNODigitsOnly = cardNODigitsOnly.substring(cardNODigitsOnly.length() - 4);
                                        }

                                        blockResult.setPass_card_no(cardNODigitsOnly);
                                        myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");
                                        myIncomingText = myIncomingText.replaceAll("(?i)(" + card_2[2] + "|" + card_2[1] + ")\\s*" + card_2[0], "");


                                       /* if (!accountNumber.toLowerCase().contains(card_2[1]) && !accountNumber.toLowerCase().contains(card_2[2]) && (blockResult.getOut_standing() > 0 || !limit_check.equals(""))) {
                                            blockResult.setPass_card_type(card_2[7]);
                                        } else*/
                                        if (!accountNumber.toLowerCase().contains(card_2[1]) && !accountNumber.toLowerCase().contains(card_2[2])) {
                                            blockResult.setPass_card_type(card_2[8]);
                                        } else if (accountNumber.toLowerCase().contains(card_2[1])) {

                                            blockResult.setPass_card_type(card_2[8]);
                                        } else {
                                            blockResult.setPass_card_type(card_2[7]);
                                        }

                                    }
                                } else if (cardNO.equals(accountNO)) {

                                    try {


                                        Matcher matcher = Pattern.compile("(?i)(" + card_2[1] + "|" + card_2[2] + ")\\s" + card_2[0] + "\\s(a\\/c|" + account_1[3] + "|" + account_1[4] + "|" + account_1[5] + "|" + account_1[6] + "|[ |.|-]" + account_1[7] + "|^" + account_1[7] + ")").matcher(accountNumber);

                                        if (matcher.find()) {
                                            Matcher match52 = Pattern.compile("(?i)[" + account_1[13] + "]{2,}").matcher(cardNO);

                                            while (match52.find()) {
                                                if (!match52.hitEnd()) {
                                                    continue;
                                                }
                                                cardNODigitsOnly = match52.group().trim();



                                                if (cardNODigitsOnly.length() > 4) {
                                                    cardNODigitsOnly = cardNODigitsOnly.substring(cardNODigitsOnly.length() - 4);
                                                }

                                                blockResult.setPass_card_no(cardNODigitsOnly);
                                                myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");
                                                myIncomingText = myIncomingText.replaceAll("(?i)(" + card_2[2] + "|" + card_2[1] + ")\\s*" + card_2[0], "");


                                     /*   if (!accountNumber.toLowerCase().contains(card_2[1]) && !accountNumber.toLowerCase().contains(card_2[2]) && (blockResult.getOut_standing() > 0 || !limit_check.equals(""))) {
                                            blockResult.setPass_card_type(card_2[7]);
                                        } else*/
                                                if (!accountNumber.toLowerCase().contains(card_2[1]) && !accountNumber.toLowerCase().contains(card_2[2])) {
                                                    blockResult.setPass_card_type(card_2[8]);
                                                } else if (accountNumber.toLowerCase().contains(card_2[1])) {

                                                    blockResult.setPass_card_type(card_2[8]);
                                                } else {
                                                    blockResult.setPass_card_type(card_2[7]);
                                                }

                                                blockResult.setPass_acc_no("-1");
                                                blockResult.setPass_acc_full_name("");
                                                accountNO = "";
                                                temp_account_no = "";
                                                temp_account_no_2 = "";
                                                accountNODigitsOnly = "";
                                            }
                                        }

                                    } catch (Exception ee) {
                                        logger.warning(ee.getMessage());
                                    }
                                }


                            } else {

                                if (accountNumber.endsWith(".")) {
                                    accountNumber = accountNumber.substring(0, accountNumber.length() - 1);
                                }
                                Matcher match53 = Pattern.compile("(?i)\\s*[" + account_1[13] + "]{2,}").matcher(accountNumber);

                                String otherDelete11 = "";
                                if (match53.find()) {
                                    otherDelete11 = match53.group();
                                    cardNODigitsOnly = match53.group().trim();
                                    cardNO = match53.group();



                                    if (cardNODigitsOnly.length() > 4) {
                                        cardNODigitsOnly = cardNODigitsOnly.substring(cardNODigitsOnly.length() - 4);
                                    }

                                    blockResult.setPass_card_no(cardNODigitsOnly);

                                    myIncomingText = myIncomingText.replaceAll("(?i)(" + card_2[2] + "|" + card_2[1] + ")\\s*" + card_2[0], "");


                                   /* if (!accountNumber.toLowerCase().contains(card_2[1]) && !accountNumber.toLowerCase().contains(card_2[2]) && (blockResult.getOut_standing() > 0 || !limit_check.equals(""))) {
                                        blockResult.setPass_card_type(card_2[7]);
                                    } else */
                                    if (!accountNumber.toLowerCase().contains(card_2[1]) && !accountNumber.toLowerCase().contains(card_2[2])) {
                                        blockResult.setPass_card_type(card_2[8]);
                                    } else if (accountNumber.toLowerCase().contains(card_2[1])) {

                                        blockResult.setPass_card_type(card_2[8]);
                                    } else {
                                        blockResult.setPass_card_type(card_2[7]);
                                    }

                                    myIncomingText = myIncomingText.replace(otherDelete11.toLowerCase(), "");

                                }
                            }

                        }


                    }



                    if (cardNODigitsOnly.isEmpty()) {

                        Matcher match49119 = Pattern.compile("(?i)(" + card_2[1] + "|" + card_2[2] + "|)(\\s*|[[" + account_1[15] + "]]+)(" + card_2[0] + ")\\s*(|[[" + account_1[15] + "]]+|" + card_2[3] + "|" + card_2[4] + "|" + card_2[5] + ")\\s*(\\W|\\w){0,20}((\\.|\\*){2,}|(x){1,})\\s*[" + account_1[13] + "]{2,}").matcher(msg_text);

                        if (match49119.find()) {
                            String accountNumber = match49119.group();

                            Matcher match5 = Pattern.compile("(?i)((\\.|\\*){2,}|(x){1,})\\s*[" + account_1[13] + "]{2,}").matcher(accountNumber);
                            String otherToDelete = "";
                            if (match5.find()) {

                                String match5string = match5.group().trim();
                                Matcher matcherTest = Pattern.compile("(?i)[^\\s]+").matcher(accountNumber);

                                while (matcherTest.find()) {

                                    String gotItGroup = matcherTest.group();
                                    gotItGroup = gotItGroup.replaceAll("[" + account_1[14] + "]", "");
                                    if (gotItGroup.contains(match5string)) {

                                        otherToDelete = match5.group();
                                        cardNO = gotItGroup;

                                        break;
                                    }
                                }


                                if (cardNO.isEmpty()) {

                                    otherToDelete = match5.group();
                                    cardNO = match5.group().trim();

                                }




                                if (!cardNO.equals(accountNO)) {

                                    Matcher match52 = Pattern.compile("(?i)[" + account_1[13] + "]{2,}").matcher(cardNO);

                                    while (match52.find()) {
                                        if (!match52.hitEnd()) {
                                            continue;
                                        }
                                        cardNODigitsOnly = match52.group().trim();



                                        if (cardNODigitsOnly.length() > 4) {
                                            cardNODigitsOnly = cardNODigitsOnly.substring(cardNODigitsOnly.length() - 4);
                                        }

                                        blockResult.setPass_card_no(cardNODigitsOnly);
                                        myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");
                                        myIncomingText = myIncomingText.replaceAll("(?i)(" + card_2[2] + "|" + card_2[1] + ")\\s*" + card_2[0], "");


                                     /*   if (!accountNumber.toLowerCase().contains(card_2[1]) && !accountNumber.toLowerCase().contains(card_2[2]) && (blockResult.getOut_standing() > 0 || !limit_check.equals(""))) {
                                            blockResult.setPass_card_type(card_2[7]);
                                        } else*/
                                        if (!accountNumber.toLowerCase().contains(card_2[1]) && !accountNumber.toLowerCase().contains(card_2[2])) {
                                            blockResult.setPass_card_type(card_2[8]);
                                        } else if (accountNumber.toLowerCase().contains(card_2[1])) {

                                            blockResult.setPass_card_type(card_2[8]);
                                        } else {
                                            blockResult.setPass_card_type(card_2[7]);
                                        }
                                    }
                                } else if (cardNO.equals(accountNO)) {
                                    try {


                                        Matcher matcher = Pattern.compile("(?i)(" + card_2[1] + "|" + card_2[2] + ")\\s" + card_2[0] + "\\s(a\\/c|" + account_1[3] + "|" + account_1[4] + "|" + account_1[5] + "|" + account_1[6] + "|[ |.|-]" + account_1[7] + "|^" + account_1[7] + ")").matcher(accountNumber);

                                        if (matcher.find()) {
                                            Matcher match52 = Pattern.compile("(?i)[" + account_1[13] + "]{2,}").matcher(cardNO);

                                            while (match52.find()) {
                                                if (!match52.hitEnd()) {
                                                    continue;
                                                }
                                                cardNODigitsOnly = match52.group().trim();



                                                if (cardNODigitsOnly.length() > 4) {
                                                    cardNODigitsOnly = cardNODigitsOnly.substring(cardNODigitsOnly.length() - 4);
                                                }

                                                blockResult.setPass_card_no(cardNODigitsOnly);
                                                myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");
                                                myIncomingText = myIncomingText.replaceAll("(?i)(" + card_2[2] + "|" + card_2[1] + ")\\s*" + card_2[0], "");


                                     /*   if (!accountNumber.toLowerCase().contains(card_2[1]) && !accountNumber.toLowerCase().contains(card_2[2]) && (blockResult.getOut_standing() > 0 || !limit_check.equals(""))) {
                                            blockResult.setPass_card_type(card_2[7]);
                                        } else*/
                                                if (!accountNumber.toLowerCase().contains(card_2[1]) && !accountNumber.toLowerCase().contains(card_2[2])) {
                                                    blockResult.setPass_card_type(card_2[8]);
                                                } else if (accountNumber.toLowerCase().contains(card_2[1])) {

                                                    blockResult.setPass_card_type(card_2[8]);
                                                } else {
                                                    blockResult.setPass_card_type(card_2[7]);
                                                }

                                                blockResult.setPass_acc_no("-1");
                                                blockResult.setPass_acc_full_name("");
                                                accountNO = "";
                                                temp_account_no_2 = "";
                                                temp_account_no = "";
                                                accountNODigitsOnly = "";
                                            }
                                        }

                                    } catch (Exception ee) {
                                        logger.warning(ee.getMessage());
                                    }

                                }

                            }

                        } else {

                            Matcher match4993 = Pattern.compile("(?i)(" + card_2[1] + "|" + card_2[2] + "|)(\\s*|[[" + account_1[15] + "]]+)(" + card_2[0] + ")\\s*([[" + account_1[15] + "]]+|" + card_2[3] + "|" + card_2[4] + "|" + card_2[5] + ")\\s*([[" + account_1[15] + "]]+|" + card_2[6] + "|)\\s*[" + account_1[19] + "]{0,5}\\s*((\\.|\\*|){2,}|(x){1,})\\s*[" + account_1[13] + "]{2,}").matcher(msg_text);

                            if (match4993.find()) {
                                String accountNumber = match4993.group();

                                Matcher match5 = Pattern.compile("(?i)((\\.|\\*){2,}|(x){1,})\\s*[" + account_1[13] + "]{2,}").matcher(accountNumber);

                                String otherToDelete = "";
                                if (match5.find()) {

                                    String match5string = match5.group().trim();
                                    Matcher matcherTest = Pattern.compile("(?i)[^\\s]+").matcher(accountNumber);

                                    while (matcherTest.find()) {

                                        String gotItGroup = matcherTest.group();
                                        gotItGroup = gotItGroup.replaceAll("[" + account_1[14] + "]", "");
                                        if (gotItGroup.contains(match5string)) {

                                            otherToDelete = match5.group();
                                            cardNO = gotItGroup;
                                            break;
                                        }
                                    }

                                    if (cardNO.isEmpty()) {

                                        otherToDelete = match5.group();
                                        cardNO = match5.group().trim();

                                    }



                                    if (!cardNO.equals(accountNO)) {

                                        Matcher match52 = Pattern.compile("(?i)[" + account_1[13] + "]{2,}").matcher(cardNO);


                                        while (match52.find()) {
                                            if (!match52.hitEnd()) {
                                                continue;
                                            }
                                            cardNODigitsOnly = match52.group().trim();

                                            if (cardNODigitsOnly.length() > 4) {
                                                cardNODigitsOnly = cardNODigitsOnly.substring(cardNODigitsOnly.length() - 4);
                                            }

                                            blockResult.setPass_card_no(cardNODigitsOnly);
                                            myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");
                                            myIncomingText = myIncomingText.replaceAll("(?i)(" + card_2[2] + "|" + card_2[1] + ")\\s*" + card_2[0], "");


                                           /* if (!accountNumber.toLowerCase().contains(card_2[1]) && !accountNumber.toLowerCase().contains(card_2[2]) && (blockResult.getOut_standing() > 0 || !limit_check.equals(""))) {
                                                blockResult.setPass_card_type(card_2[7]);
                                            } else*/
                                            if (!accountNumber.toLowerCase().contains(card_2[1]) && !accountNumber.toLowerCase().contains(card_2[2])) {
                                                blockResult.setPass_card_type(card_2[8]);
                                            } else if (accountNumber.toLowerCase().contains(card_2[1])) {

                                                blockResult.setPass_card_type(card_2[8]);
                                            } else {
                                                blockResult.setPass_card_type(card_2[7]);
                                            }
                                        }
                                    } else if (cardNO.equals(accountNO)) {
                                        try {


                                            Matcher matcher = Pattern.compile("(?i)(" + card_2[1] + "|" + card_2[2] + ")\\s" + card_2[0] + "\\s(a\\/c|" + account_1[3] + "|" + account_1[4] + "|" + account_1[5] + "|" + account_1[6] + "|[ |.|-]" + account_1[7] + "|^" + account_1[7] + ")").matcher(accountNumber);

                                            if (matcher.find()) {
                                                Matcher match52 = Pattern.compile("(?i)[" + account_1[13] + "]{2,}").matcher(cardNO);

                                                while (match52.find()) {
                                                    if (!match52.hitEnd()) {
                                                        continue;
                                                    }
                                                    cardNODigitsOnly = match52.group().trim();



                                                    if (cardNODigitsOnly.length() > 4) {
                                                        cardNODigitsOnly = cardNODigitsOnly.substring(cardNODigitsOnly.length() - 4);
                                                    }

                                                    blockResult.setPass_card_no(cardNODigitsOnly);
                                                    myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");
                                                    myIncomingText = myIncomingText.replaceAll("(?i)(" + card_2[2] + "|" + card_2[1] + ")\\s*" + card_2[0], "");


                                     /*   if (!accountNumber.toLowerCase().contains(card_2[1]) && !accountNumber.toLowerCase().contains(card_2[2]) && (blockResult.getOut_standing() > 0 || !limit_check.equals(""))) {
                                            blockResult.setPass_card_type(card_2[7]);
                                        } else*/
                                                    if (!accountNumber.toLowerCase().contains(card_2[1]) && !accountNumber.toLowerCase().contains(card_2[2])) {
                                                        blockResult.setPass_card_type(card_2[8]);
                                                    } else if (accountNumber.toLowerCase().contains(card_2[1])) {

                                                        blockResult.setPass_card_type(card_2[8]);
                                                    } else {
                                                        blockResult.setPass_card_type(card_2[7]);
                                                    }

                                                    blockResult.setPass_acc_no("-1");
                                                    blockResult.setPass_acc_full_name("");
                                                    accountNO = "";
                                                    temp_account_no_2 = "";
                                                    temp_account_no = "";
                                                    accountNODigitsOnly = "";
                                                }
                                            }

                                        } catch (Exception ee) {
                                            logger.warning(ee.getMessage());
                                        }

                                    }


                                } else {

                                    if (accountNumber.endsWith(".")) {
                                        accountNumber = accountNumber.substring(0, accountNumber.length() - 1);
                                    }
                                    Matcher match53 = Pattern.compile("(?i)\\s*[" + account_1[13] + "]{2,}").matcher(accountNumber);

                                    String otherDelete11;
                                    if (match53.find()) {
                                        otherDelete11 = match53.group();
                                        cardNO = match53.group();
                                        cardNODigitsOnly = match53.group().trim();



                                        if (cardNODigitsOnly.length() > 4) {
                                            cardNODigitsOnly = cardNODigitsOnly.substring(cardNODigitsOnly.length() - 4);
                                        }

                                        blockResult.setPass_card_no(cardNODigitsOnly);

                                        myIncomingText = myIncomingText.replaceAll("(?i)(" + card_2[2] + "|" + card_2[1] + ")\\s*" + card_2[0], "");


                                        /*if (!accountNumber.toLowerCase().contains(card_2[1]) && !accountNumber.toLowerCase().contains(card_2[2]) && (blockResult.getOut_standing() > 0 || !limit_check.equals(""))) {
                                            blockResult.setPass_card_type(card_2[7]);
                                        } else*/
                                        if (!accountNumber.toLowerCase().contains(card_2[1]) && !accountNumber.toLowerCase().contains(card_2[2])) {
                                            blockResult.setPass_card_type(card_2[8]);
                                        } else if (accountNumber.toLowerCase().contains(card_2[1])) {

                                            blockResult.setPass_card_type(card_2[8]);
                                        } else {
                                            blockResult.setPass_card_type(card_2[7]);
                                        }

                                        myIncomingText = myIncomingText.replace(otherDelete11.toLowerCase(), "");

                                    }
                                }

                            }


                        }


                    }

                    if (cardNODigitsOnly.isEmpty()) {

                        Matcher match4993 = Pattern.compile("(?i)(" + card_2[1] + "|" + card_2[2] + ")(\\s*|[[" + account_1[15] + "]]+)(" + card_2[0] + ")\\s*(" + card_2[9] + "|" + card_2[10] + "|" + card_2[11] + "|)\\s*(\\W+|" + card_2[3] + "|" + card_2[4] + "|" + card_2[5] + "|)\\s*([[" + account_1[15] + "]]+|" + card_2[6] + "|)\\s*([" + account_1[13] + "]{2,})").matcher(msg_text);

                        if (match4993.find()) {

                            String card = match4993.group();


                            if (cardNO.isEmpty()) {


                                cardNODigitsOnly = match4993.group(7).trim();
                                cardNO = match4993.group(7).trim();

                                if (cardNODigitsOnly.length() > 4) {
                                    cardNODigitsOnly = cardNODigitsOnly.substring(cardNODigitsOnly.length() - 4);
                                }

                                blockResult.setPass_card_no(cardNODigitsOnly);
                                myIncomingText = myIncomingText.replace(card.toLowerCase(), "");
                                myIncomingText = myIncomingText.replaceAll("(?i)(" + card_2[2] + "|" + card_2[1] + ")\\s*" + card_2[0], "");

                                if (!card.toLowerCase().contains(card_2[1]) && !card.toLowerCase().contains(card_2[2])) {
                                    blockResult.setPass_card_type(card_2[8]);
                                } else if (card.toLowerCase().contains(card_2[1])) {

                                    blockResult.setPass_card_type(card_2[8]);
                                } else {
                                    blockResult.setPass_card_type(card_2[7]);
                                }

                            }

                        }


                    }

                    if (cardNODigitsOnly.isEmpty()) {

                        Matcher match4993 = Pattern.compile("(?i)(" + card_2[0] + ")\\s*([" + account_1[13] + "]{4,})( |,|\\.|\\:)").matcher(msg_text);

                        if (match4993.find()) {

                            String card = match4993.group();

                            if (cardNO.isEmpty()) {


                                cardNODigitsOnly = match4993.group(2).trim();
                                cardNO = match4993.group(2).trim();

                                if (cardNODigitsOnly.length() > 4) {
                                    cardNODigitsOnly = cardNODigitsOnly.substring(cardNODigitsOnly.length() - 4);
                                }

                                blockResult.setPass_card_no(cardNODigitsOnly);
                                myIncomingText = myIncomingText.replace(card.toLowerCase(), "");
                                myIncomingText = myIncomingText.replaceAll("(?i)(" + card_2[2] + "|" + card_2[1] + ")\\s*" + card_2[0], "");

                                if (!card.toLowerCase().contains(card_2[1]) && !card.toLowerCase().contains(card_2[2])) {
                                    blockResult.setPass_card_type(card_2[8]);
                                } else if (card.toLowerCase().contains(card_2[1])) {

                                    blockResult.setPass_card_type(card_2[8]);
                                } else {
                                    blockResult.setPass_card_type(card_2[7]);
                                }

                            }

                        }


                    }


                }


                //myIncomingText = myIncomingText.replaceAll("(?i)(credit|debit)\\s*card", "");
                myIncomingText = myIncomingText.replaceAll("(?i)("+CASE15[36]+"|"+CASE15[35]+")\\s*"+CASE15[37]+"", "");


                if (accountNODigitsOnly.isEmpty()) {

                    if (msg_text.toLowerCase().contains(account_1[4]) || msg_text.toLowerCase().contains(account_1[7])
                            || msg_text.toLowerCase().contains(account_1[18])) {


                        Matcher match43 = Pattern.compile("(?i)(?<!(" + account_1[2] + "|" + account_1[24] + ")(\\w|\\W){1,3})((a\\/c|" + account_1[3] + "|" + account_1[4] + "|" + account_1[5] + "|" + account_1[6] + "|[ |.|-](?<!(" + account_1[2] + "|" + account_1[24] + ")(\\w|\\W){1,3})" + account_1[7] + "|^" + account_1[7] + ")(\\s|[[" + account_1[15] + "]]+)(" + account_1[8] + "|[[" + account_1[15] + "]]+|" + account_1[9] + "|[^" + account_1[20] + "])\\s*([[" + account_1[15] + "]]+|)\\s*[" + account_1[19] + "]{0,5}\\s*((\\.|\\*|){2,}|(x|-|\\/){1,})\\s*[" + account_1[13] + "]{2,}( |\\. |\\.\\w|.*?([" + account_1[13] + "]+( |\\.|[" + account_1[19] + "])))|((?<!(" + account_1[2] + "|" + account_1[24] + ")(\\w|\\W){1,3})(a\\/c|" + account_1[3] + "|" + account_1[4] + "|" + account_1[5] + "|" + account_1[6] + "|[ |.|-](?<!(" + account_1[2] + "|" + account_1[24] + ")(\\w|\\W){1,3})" + account_1[7] + "|^" + account_1[7] + ")(\\s|[[" + account_1[15] + "]]+)(" + account_1[8] + "|[[" + account_1[15] + "]]+|" + account_1[9] + "|)\\s*([[" + account_1[15] + "]]+|" + card_2[3] + "|" + card_2[4] + "|" + card_2[5] + ")\\s*([[" + account_1[15] + "]]+|" + card_2[6] + "|)\\s*[" + account_1[19] + "]{0,5}\\s*((\\.|\\*|){2,}|(x|-|\\/){1,})\\s*[" + account_1[13] + "]{2,}))").matcher(msg_text);

                        while (match43.find()) {

                            if (accountNO.isEmpty()) {
                                String accountNumber = match43.group().trim();

                                if (accountNumber.length() > 50){
                                    continue;
                                }

                                Matcher match5 = Pattern.compile("(?i)((\\.|\\*){2,}|(x|-|\\/){1,})\\s*[" + account_1[13] + "]{2,}").matcher(accountNumber);

                                String otherToDelete = "";
                                if (match5.find()) {


                                    String match5string = match5.group().trim();
                                    Matcher matcherTest = Pattern.compile("(?i)[^\\s]+").matcher(accountNumber);

                                    String string_to_match = "";
                                    while (matcherTest.find()) {

                                        String gotItGroup = matcherTest.group();
                                        gotItGroup = gotItGroup.replaceAll("[" + account_1[14] + "]", "");
                                        if (gotItGroup.contains(match5string)) {


                                            otherToDelete = match5.group();
                                            //accountNO = match5.group();
                                            if (temp_account_no.isEmpty()) {
                                                temp_account_no = gotItGroup;
                                                string_to_match = gotItGroup;
                                            } else {
                                                temp_account_no_2 = gotItGroup;
                                                string_to_match = gotItGroup;
                                            }
                                            break;
                                        }
                                    }


                                    if (string_to_match.isEmpty()) {

                                        otherToDelete = match5string;
                                        if (temp_account_no.isEmpty()) {
                                            temp_account_no = match5string;
                                            string_to_match = match5string;
                                        } else {
                                            temp_account_no_2 = match5string;
                                            string_to_match = match5string;
                                        }

                                    }





                                    String abc2 = "";
                                    try {
                                        int index2 = msg_text.indexOf(string_to_match) - 30;

                                        if (index2 < 0) {
                                            index2 = 0;
                                        }
                                        abc2 = msg_text.substring(index2, msg_text.indexOf(string_to_match));
                                    } catch (Exception e) {

                                        try {
                                            int index2 = msg_text.indexOf(match5string) - 30;

                                            if (index2 < 0) {
                                                index2 = 0;
                                            }
                                            abc2 = msg_text.substring(index2, msg_text.indexOf(match5string));
                                        } catch (Exception ed) {
                                            logger.warning(ed.getMessage());
                                        }

                                    }

                                    Matcher match52 = Pattern.compile("(?i)[" + account_1[13] + "]{2,}").matcher(string_to_match);

                                    while (match52.find()) {
                                        if (!match52.hitEnd()) {
                                            continue;
                                        }


                                        if (abc2.toLowerCase().contains(account_1[10])) {
                                            your_word_present = true;
                                            accountNO = temp_account_no;
                                            accountNODigitsOnly = match52.group();

                                            if (accountNODigitsOnly.length() > 4) {
                                                accountNODigitsOnly = accountNODigitsOnly.substring(accountNODigitsOnly.length() - 4);
                                            }


                                            try {

                                                int stringLength = incomingSms.toLowerCase().indexOf(accountNumber.toLowerCase());

                                                int start_index = stringLength - 10;
                                                if (start_index<0){
                                                    start_index = 0;
                                                }
                                                String isl = incomingSms.toLowerCase().substring(start_index, stringLength);
                                                if (isl.contains(account_1[17])||isl.contains(account_1[25])) {

                                                    blockResult.setLoan_or_other(account_1[17]);
                                                }else if (isl.contains(account_1[26])){
                                                    blockResult.setLoan_or_other(account_1[26]);
                                                }else {

                                                    Matcher matcher = Pattern.compile("(?i)(^|\\W)("+CASE15[96]+"|"+CASE15[97]+"|"+CASE15[98]+")(\\W|$)").matcher(isl);

                                                    if (matcher.find()){
                                                        blockResult.setLoan_or_other(""+CASE15[99]+" "+CASE15[96]+"");
                                                    }
                                                }


                                            } catch (Exception e) {
                                                logger.warning(e.getMessage());
                                            }
                                            blockResult.setPass_acc_no(accountNODigitsOnly);

                                        } else if (accountNO.isEmpty()) {

                                            if (temp_account_no_digits.isEmpty()) {
                                                temp_account_no_digits = match52.group().trim();
                                                loan_account_no = accountNumber;
                                            } else {
                                                temp_account_no_digits_2 = match52.group().trim();
                                                loan_account_no_2 = accountNumber;
                                            }
                                        }

                                        myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");
                                    }

                                } else {

                                    if (accountNumber.endsWith(".")) {
                                        accountNumber = accountNumber.substring(0, accountNumber.length() - 1);
                                    }
                                    Matcher match53 = Pattern.compile("(?i)\\s*[" + account_1[13] + "]{2,}").matcher(accountNumber);

                                    String otherDelete11 = "";
                                    while (match53.find()) {

                                        // accountNO = match53.group();

                                        if (!match53.hitEnd()) {
                                            continue;
                                        }

                                        String string_to_match = "";


                                        String match5string = match53.group().trim();
                                        Matcher matcherTest = Pattern.compile("(?i)[^\\s]+").matcher(accountNumber);

                                        while (matcherTest.find()) {

                                            String gotItGroup = matcherTest.group();
                                            gotItGroup = gotItGroup.replaceAll("[" + account_1[14] + "]", "");

                                            if (gotItGroup.contains(".") && !gotItGroup.startsWith(".")) {

                                                continue;
                                            }


                                            if (gotItGroup.contains(match5string)) {


                                                if (temp_account_no.isEmpty()) {
                                                    temp_account_no = gotItGroup;
                                                    string_to_match = gotItGroup;
                                                } else {
                                                    temp_account_no_2 = gotItGroup;
                                                    string_to_match = gotItGroup;
                                                }

                                                break;
                                            }
                                        }


                                        if (string_to_match.isEmpty()) {

                                            otherDelete11 = string_to_match;
                                            if (temp_account_no.isEmpty()) {
                                                temp_account_no = match5string;
                                                string_to_match = match5string;
                                            } else {
                                                temp_account_no_2 = match5string;
                                                string_to_match = match5string;
                                            }

                                        }



                                        String abc2 = "";
                                        try {
                                            int index2 = msg_text.indexOf(string_to_match) - 30;

                                            if (index2 < 0) {
                                                index2 = 0;
                                            }
                                            abc2 = msg_text.substring(index2, msg_text.indexOf(string_to_match));
                                        } catch (Exception e) {

                                            try {
                                                int index2 = msg_text.indexOf(match5string) - 30;

                                                if (index2 < 0) {
                                                    index2 = 0;
                                                }
                                                abc2 = msg_text.substring(index2, msg_text.indexOf(match5string));
                                            } catch (Exception ed) {
                                                logger.warning(ed.getMessage());
                                            }

                                        }




                                        Matcher match52 = Pattern.compile("(?i)[" + account_1[13] + "]{2,}").matcher(string_to_match);

                                        while (match52.find()) {

                                            if (!match52.hitEnd()) {
                                                continue;
                                            }

                                            if (abc2.toLowerCase().contains(account_1[10])) {
                                                your_word_present = true;
                                                accountNO = temp_account_no;
                                                accountNODigitsOnly = match52.group();

                                                if (accountNODigitsOnly.length() > 4) {
                                                    accountNODigitsOnly = accountNODigitsOnly.substring(accountNODigitsOnly.length() - 4);
                                                }


                                                try {

                                                    int stringLength = incomingSms.toLowerCase().indexOf(accountNumber.toLowerCase());

                                                    int start_index = stringLength - 10;
                                                    if (start_index<0){
                                                        start_index = 0;
                                                    }

                                                    String isl = incomingSms.toLowerCase().substring(start_index, stringLength);
                                                    if (isl.contains(account_1[17])||isl.contains(account_1[25])) {

                                                        blockResult.setLoan_or_other(account_1[17]);
                                                    }else if (isl.contains(account_1[26])){
                                                        blockResult.setLoan_or_other(account_1[26]);
                                                    }else {

                                                        Matcher matcher = Pattern.compile("(?i)(^|\\W)("+CASE15[96]+"|"+CASE15[97]+"|"+CASE15[98]+")(\\W|$)").matcher(isl);

                                                        if (matcher.find()){
                                                            blockResult.setLoan_or_other(""+CASE15[99]+" "+CASE15[96]+"");
                                                        }
                                                    }


                                                } catch (Exception e) {
                                                    logger.warning(e.getMessage());
                                                }
                                                blockResult.setPass_acc_no(accountNODigitsOnly);

                                            } else if (accountNO.isEmpty()) {

                                                if (temp_account_no_digits.isEmpty()) {
                                                    temp_account_no_digits = match52.group().trim();
                                                    loan_account_no = accountNumber;
                                                } else {
                                                    temp_account_no_digits_2 = match52.group().trim();
                                                    loan_account_no_2 = accountNumber;
                                                }
                                            }

                                            myIncomingText = myIncomingText.replace(otherDelete11.toLowerCase(), "");
                                        }


                                    }
                                }

                            }

                        }

                        if (accountNO.isEmpty()) {

                            if (!temp_account_no.isEmpty()) {


                                accountNO = temp_account_no;
                                accountNODigitsOnly = temp_account_no_digits;

                                if (accountNODigitsOnly.length() > 4) {
                                    accountNODigitsOnly = accountNODigitsOnly.substring(accountNODigitsOnly.length() - 4);
                                }

                                try {

                                    int stringLength = incomingSms.toLowerCase().indexOf(loan_account_no.toLowerCase());

                                    int start_index = stringLength - 10;
                                    if (start_index<0){
                                        start_index = 0;
                                    }
                                    String isl = incomingSms.toLowerCase().substring(start_index, stringLength);
                                    if (isl.contains(account_1[17])||isl.contains(account_1[25])) {

                                        blockResult.setLoan_or_other(account_1[17]);
                                    }else if (isl.contains(account_1[26])){
                                        blockResult.setLoan_or_other(account_1[26]);
                                    }else {

                                        Matcher matcher = Pattern.compile("(?i)(^|\\W)("+CASE15[96]+"|"+CASE15[97]+"|"+CASE15[98]+")(\\W|$)").matcher(isl);

                                        if (matcher.find()){
                                            blockResult.setLoan_or_other(""+CASE15[99]+" "+CASE15[96]+"");
                                        }
                                    }


                                } catch (Exception e) {
                                    logger.warning(e.getMessage());
                                }

                                blockResult.setPass_acc_no(accountNODigitsOnly);


                            } else if (!temp_account_no_2.isEmpty()) {

                                accountNO = temp_account_no_2;
                                accountNODigitsOnly = temp_account_no_digits_2;

                                if (accountNODigitsOnly.length() > 4) {
                                    accountNODigitsOnly = accountNODigitsOnly.substring(accountNODigitsOnly.length() - 4);
                                }
                                try {

                                    int stringLength = incomingSms.toLowerCase().indexOf(loan_account_no_2.toLowerCase());

                                    int start_index = stringLength - 10;
                                    if (start_index<0){
                                        start_index = 0;
                                    }
                                    String isl = incomingSms.toLowerCase().substring(start_index, stringLength);
                                    if (isl.contains(account_1[17])||isl.contains(account_1[25])) {

                                        blockResult.setLoan_or_other(account_1[17]);
                                    }else if (isl.contains(account_1[26])){
                                        blockResult.setLoan_or_other(account_1[26]);
                                    }else {

                                        Matcher matcher = Pattern.compile("(?i)(^|\\W)("+CASE15[96]+"|"+CASE15[97]+"|"+CASE15[98]+")(\\W|$)").matcher(isl);

                                        if (matcher.find()){
                                            blockResult.setLoan_or_other(""+CASE15[99]+" "+CASE15[96]+"");
                                        }
                                    }


                                } catch (Exception e) {
                                    logger.warning(e.getMessage());
                                }

                                blockResult.setPass_acc_no(accountNODigitsOnly);

                            }


                        }
                    }
                }

                blockResult.setPass_acc_type("");

                double amount_credited = 0.0;
                double amount_debited = 0.0;



                if ((accountNODigitsOnly.isEmpty() && cardNODigitsOnly.isEmpty() && !msg_text.toLowerCase().contains(account_1[2]))
                        && (msg_text.toLowerCase().contains("xx") || msg_text.toLowerCase().contains("..")
                        || msg_text.toLowerCase().contains("**"))) {


                    Matcher match5 = Pattern.compile("(?i)(x|\\.|\\*){2,}\\s*[" + account_1[13] + "]{2,}\\W").matcher(msg_text);

                    String otherToDelete = "";

                    String string_to_match = "";

                    if (match5.find()) {

                        String match5string = match5.group().trim();


                        match5string = match5string.replaceAll("[" + account_1[14] + "]", "");
                        if (temp_account_no.isEmpty()) {
                            temp_account_no = match5string.trim();
                            //multiple_match=multiple_match+match5.group();
                            string_to_match = match5string.trim();
                        } else {
                            temp_account_no_2 = match5string.trim();
                            string_to_match = match5string.trim();
                        }

                        otherToDelete = match5string;


                        if (string_to_match.isEmpty()) {

                            if (temp_account_no.isEmpty()) {
                                temp_account_no = match5string;
                                //multiple_match=multiple_match+match5.group();
                                string_to_match = match5string;
                            } else {
                                temp_account_no_2 = match5string;
                                string_to_match = match5string;
                            }

                            otherToDelete = match5string;


                        }


                        String prev15Character = "";
                        try {
                            int index2 = msg_text.indexOf(string_to_match) - 15;

                            if (index2 < 0) {
                                index2 = 0;
                            }
                            prev15Character = msg_text.substring(index2, msg_text.indexOf(string_to_match));

                            //Matcher matcher = Pattern.compile("(?i)(reference|\\Wref\\W|\\Wutr\\W|\\Wfolio|\\Wpan\\W|aadhar|dmat|\\WID\\W|application)").matcher(prev15Character);
                            Matcher matcher = Pattern.compile("(?i)("+extra10[13]+"|\\W"+extra10[12]+"\\W|\\W"+extra10[10]+"\\W|\\W"+extra10[77]+"|\\W"+extra10[78]+"\\W|"+extra10[79]+"|"+extra10[80]+"|\\W"+extra10[81]+"\\W|"+extra10[82]+"|" + account_1[2] + "|\\W" + account_1[24] + "|"+CASE15[116]+")").matcher(prev15Character);

                            if (matcher.find()){

                                blockResult = new BlockResult();
                                accountNODigitsOnly = "";
                                cardNODigitsOnly = "";
                                accountNO = "";
                                cardNO = "";
                                string_to_match = "";
                            }


                        } catch (Exception e) {
                            logger.warning(e.getMessage());
                        }


                        Matcher match52 = Pattern.compile("(?i)[" + account_1[13] + "]{2,}").matcher(string_to_match);

                        while (match52.find()) {

                            if (!match52.hitEnd()) {
                                continue;
                            }
                            your_word_present = true;

                            //if (abc2.toLowerCase().contains(account_1[10])) {
                            accountNO = temp_account_no;

                            accountNODigitsOnly = match52.group();

                            if (accountNODigitsOnly.length() > 4) {
                                accountNODigitsOnly = accountNODigitsOnly.substring(accountNODigitsOnly.length() - 4);
                            }

                            blockResult.setPass_acc_no(accountNODigitsOnly);
                            blockResult.setPass_acc_type("NS");

                            try {
                                //String check_NS=match5.group().trim();

                                int last_index=myIncomingText.indexOf(match5.group());
                                int first_index=last_index-5;
                                if (first_index<0){
                                    first_index=0;
                                }

                                if (first_index<last_index) {
                                    String check_NS_new_s = myIncomingText.substring(first_index, last_index);

                                    Matcher matcher_ns = Pattern.compile("\\Wsb\\W").matcher(check_NS_new_s);
                                    if (matcher_ns.find()) {
                                        blockResult.setPass_acc_type("");
                                    }
                                }

                            }catch (Exception e){
                                logger.warning(e.getMessage());
                            }

                            try {

                                int stringLength = incomingSms.toLowerCase().indexOf(match5.group().toLowerCase());

                                int start_index = stringLength - 20;
                                if (start_index<0){
                                    start_index = 0;
                                }

                                String isl = incomingSms.toLowerCase().substring(start_index, stringLength);
                                if (isl.contains(account_1[17])||isl.contains(account_1[25])) {
                                    blockResult.setLoan_or_other(account_1[17]);
                                }else if (isl.contains(account_1[26])){
                                    blockResult.setLoan_or_other(account_1[26]);
                                }else {

                                    Matcher matcher = Pattern.compile("(?i)(^|\\W)("+CASE15[96]+"|"+CASE15[97]+"|"+CASE15[98]+")(\\W|$)").matcher(isl);

                                    if (matcher.find()){
                                        blockResult.setLoan_or_other(""+CASE15[99]+" "+CASE15[96]+"");
                                    }
                                }


                            } catch (Exception e) {
                                // logger.warning(e.getMessage());
                            }
                            myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");
                        }

                    }
                }
//

                if (blockResult.getLoan_or_other().equals(account_1[26])){
                    blockResult = new BlockResult();
                    accountNODigitsOnly = "";
                    cardNODigitsOnly = "";
                    accountNO = "";
                    cardNO = "";
                }

                //false case

                if (!accountNODigitsOnly.isEmpty() || !cardNODigitsOnly.isEmpty()) {


                    try{

                        Matcher debited_by = Pattern.compile("(?i)(" + CASE15[35] + "(|" + CASE15[58] + ")\\s(" + CASE15[57] + "|" + CASE15[31] + "))(\\W+)(\\d+\\.\\d+|\\d+)(\\W)").matcher(msg_text);

                        if (debited_by.find()) {
                            String amount_group5 = debited_by.group(5);
                            String debited_by_group1 = debited_by.group(1);
                            String debited_by_group4 = debited_by.group(4);
                            String debited_by_group6 = debited_by.group(6);
                            String entire_thing = debited_by.group();

                            String replacedString = debited_by_group1 + debited_by_group4 + "" + CASE15[48] + " "+amount_group5 + debited_by_group6;
                            msg_text = msg_text.replaceAll(entire_thing, replacedString);
                            myIncomingText = myIncomingText.replaceAll(entire_thing, replacedString);


                        }



                    }catch (Exception exception){
                        logger.warning(exception.getMessage());
                    }




                    int all_factor1 = 0;
                    int all_factor2 = 0;
                    int proxy1 = 0;
                    int proxy2 = 0;
                    // if (false) {

                    //added Later top cases


                    //  long time1=System.currentTimeMillis();


                    String lower_case_sms = msg_text.toLowerCase();

                    if (lower_case_sms.contains(bal_amt3[0]) || lower_case_sms.contains(bal_amt3[1]) || lower_case_sms.contains(bal_amt3[2]) || lower_case_sms.contains(bal_amt3[3])) {

                        Matcher match99 = Pattern.compile("(?i)(" + bal_amt3[0] + "|" + bal_amt3[1] + "|" + bal_amt3[2] + "|" + bal_amt3[3] + ")\\s*" + bal_amt3[4] + ".*?" + bal_amt3[5] + "\\s*(" + bal_amt3[6] + "|" + bal_amt3[7] + ")\\s*[\\W]{0,3}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\)|\\{|<| )").matcher(msg_text);

                        if (match99.find()) {
                            int startIndex = 0;
                            String testBalanceAmount = match99.group();
                            String test = testBalanceAmount;

                            startIndex = match99.start();
                            Matcher match3 = Pattern.compile("(?i)(" + bal_amt3[6] + "|" + bal_amt3[7] + ")\\s*[\\W]{0,3}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\)|\\{|<| )").matcher(testBalanceAmount);
                            String otherToDelete = "";

                            while (match3.find()) {

                                otherToDelete = match3.group();
                                test = match3.group();
                                Matcher match33 = Pattern.compile("(?i)((" + bal_amt3[6] + "|" + bal_amt3[7] + ")\\.|[" + account_1[19] + "]|(?!\\.)[\\W])").matcher(test);

                                while (match33.find()) {

                                    try {
                                        test = test.replace(match33.group(), "").trim();
                                    } catch (Exception e) {
                                        logger.warning(e.getMessage());

                                    }
                                    if (test.endsWith(".")) {
                                        test = test.substring(0, test.length() - 1);
                                    }
                                }
                            }

                            available_bal1_text=testBalanceAmount;
                            availableBalance1 = test;

                            blockResult.setPass_avl_amount(Double.parseDouble(availableBalance1));

                            try {

                                otherToDelete = otherToDelete.substring(0, otherToDelete.length() - 1);
                                int count = 0;
                                Matcher matcherDelete = Pattern.compile("(?i)"+otherToDelete).matcher(myIncomingText);
                                while (matcherDelete.find()){
                                    count = count+1;
                                }
                                if (count == 1) {
                                    myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");
                                }else {
                                    try {
                                        if (myIncomingText.toLowerCase().contains(testBalanceAmount.toLowerCase())){
                                            startIndex = myIncomingText.toLowerCase().indexOf(testBalanceAmount.toLowerCase());

                                        }
                                        String test_delete = myIncomingText.substring(startIndex,(startIndex+testBalanceAmount.length()));
                                        String test_delete2 = test_delete.replace(otherToDelete.toLowerCase(), "");
                                        myIncomingText = myIncomingText.replace(test_delete.toLowerCase(), test_delete2);

                                        //Log.d("ATTTQQQ","3-- "+myIncomingText +" --"+testBalanceAmount);
                                    }catch (Exception e){
                                        logger.warning(e.getMessage());
                                        //Log.d("ATTTQQQ","crash3-- "+myIncomingText +" --"+testBalanceAmount);
                                    }
                                }

                            } catch (Exception e) {
                                logger.warning(e.getMessage());
                            }


                        }
                    }

                    if ((availableBalance1.isEmpty() || availableBalance2.isEmpty()) && (lower_case_sms.contains(bal_amt3[0])
                            || lower_case_sms.contains(bal_amt3[1]))) {


                        Matcher match = Pattern.compile("(?i)(" + bal_amt3[0] + "|" + bal_amt3[1] + ")\\s*.*?(" + bal_amt3[6] + "|" + bal_amt3[7] + ")\\s*([\\W\\_]+|\\s*)\\s*[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\)|\\{|<| )").matcher(msg_text);

                        while (match.find()) {
                            int startIndex = 0;
                            String testBalanceAmount = match.group();
                            startIndex = match.start();
                            //int end_index = match.start();
                            String test = testBalanceAmount;


                            Matcher matcherBalanceTransfer = Pattern.compile("(?i)^" + bal_amt3[1] + "\\s" + CASE15[56]).matcher(test);

                            if (matcherBalanceTransfer.find()){
                                test = "";
                                testBalanceAmount = "";
                                blockResult.setPass_card_type(card_2[7]);
                                continue;
                            }


                            Matcher match3 = Pattern.compile("(?i)(" + bal_amt3[6] + "|" + bal_amt3[7] + ")\\s*([\\W\\_]+|\\s*)\\s*[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\)|\\{|<| )").matcher(testBalanceAmount);

                            String otherToDelete = "";
                            while (match3.find()) {

                                otherToDelete = match3.group();
                                test = match3.group();
                                Matcher match33 = Pattern.compile("(?i)((" + bal_amt3[6] + "|" + bal_amt3[7] + ")\\.|[" + account_1[19] + "]|(?!\\.)[\\W])").matcher(test);

                                while (match33.find()) {

                                    try {
                                        test = test.replace(match33.group(), "").trim();
                                    } catch (Exception e) {
                                        logger.warning(e.getMessage());

                                    }
                                    if (test.endsWith(".")) {
                                        test = test.substring(0, test.length() - 1);
                                    }
                                }

                            }


                            if (availableBalance1.isEmpty()) {
                                all_factor1 = testBalanceAmount.length();
                                available_bal1_text=testBalanceAmount;
                                try {

                                    availableBalance1 = test;
                                    blockResult.setPass_avl_amount(Double.parseDouble(availableBalance1));
                                    otherToDelete = otherToDelete.substring(0, otherToDelete.length() - 1);

                                    int count = 0;
                                    Matcher matcherDelete = Pattern.compile("(?i)"+otherToDelete).matcher(myIncomingText);
                                    while (matcherDelete.find()){
                                        count = count+1;
                                    }
                                    if (count == 1) {
                                        myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");
                                    }else {
                                        try {
                                            if (myIncomingText.toLowerCase().contains(testBalanceAmount.toLowerCase())){
                                                startIndex = myIncomingText.toLowerCase().indexOf(testBalanceAmount.toLowerCase());

                                            }
                                            String test_delete = myIncomingText.substring(startIndex,(startIndex+testBalanceAmount.length()));
                                            String test_delete2 = test_delete.replace(otherToDelete.toLowerCase(), "");
                                            myIncomingText = myIncomingText.replace(test_delete.toLowerCase(), test_delete2);

                                            ////Log.d("ATTTQQQ","4-- "+myIncomingText +" --"+testBalanceAmount);
                                        }catch (Exception e){
                                            logger.warning(e.getMessage());
                                            ////Log.d("ATTTQQQ","crash4-- "+myIncomingText +" --"+testBalanceAmount);
                                        }
                                    }

                                } catch (Exception e) {
                                    logger.warning(e.getMessage());
                                }
                            } else {

                                if (availableBalance2.isEmpty() && cardNODigitsOnly.isEmpty()) {

                                    otherToDelete = otherToDelete.substring(0, otherToDelete.length() - 1);
                                    myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");
                                    available_bal2_text=testBalanceAmount;


                                    try {

                                        int index1_for_bal1=msg_text.indexOf(available_bal1_text)-15;
                                        if (index1_for_bal1<0){
                                            index1_for_bal1=0;
                                        }
                                        String first_String_to_check=msg_text.substring(index1_for_bal1,msg_text.indexOf(available_bal1_text));

                                        first_String_to_check=first_String_to_check.toLowerCase();

                                        if (first_String_to_check.contains(CASE15[52])||first_String_to_check.contains(CASE15[53])||
                                                first_String_to_check.contains(CASE15[54])||first_String_to_check.contains(CASE15[55]))
                                        {

                                            proxy1=proxy1+50;

                                        }

                                        int index1_for_bal2 = msg_text.indexOf(available_bal2_text) - 15;
                                        if (index1_for_bal2 < 0) {
                                            index1_for_bal2 = 0;
                                        }
                                        String second_String_to_check = msg_text.substring(index1_for_bal2, msg_text.indexOf(available_bal2_text));

                                        second_String_to_check = second_String_to_check.toLowerCase();

                                        if (second_String_to_check.contains(CASE15[52]) || second_String_to_check.contains(CASE15[53]) ||
                                                second_String_to_check.contains(CASE15[54]) || second_String_to_check.contains(CASE15[55])) {

                                            proxy2 = proxy2 + 50;

                                        }


                                    }catch (Exception e){
                                        logger.warning(e.getMessage());
                                    }

                                    all_factor2 = testBalanceAmount.length();
                                    if (all_factor1 > all_factor2) {
                                        proxy2 = proxy2 + 1;
                                    } else {
                                        proxy1 = proxy1 + 1;
                                    }

                                    availableBalance2 = test;

                                    try {
                                        if (Double.parseDouble(availableBalance1) > Double.parseDouble(availableBalance2)) {
                                            proxy2 = proxy2 + 1;

                                        } else {

                                            proxy1 = proxy1 + 1;
                                        }

                                        char cha = availableBalance1.charAt(availableBalance1.length() - 1);
                                        boolean check1 = true;
                                        int till_what = availableBalance1.length() - 3;
                                        if (availableBalance1.contains(".")) {
                                            till_what = availableBalance1.length() - 6;
                                            proxy1 = proxy1 + 1;
                                        }

                                        if (till_what < 0) {
                                            till_what = 0;
                                        }

                                        for (int index = availableBalance1.length() - 1; index > till_what; index--) {

                                            char a = availableBalance1.charAt(index);
                                            if (a != cha && a != '.') {
                                                check1 = false;
                                                proxy1 = proxy1 + 1;
                                                break;
                                            }
                                        }


                                        char cha2 = availableBalance2.charAt(availableBalance2.length() - 1);
                                        boolean check2 = true;

                                        int till_what2 = availableBalance2.length() - 3;
                                        if (availableBalance2.contains(".")) {
                                            till_what2 = availableBalance2.length() - 6;
                                            proxy2 = proxy2 + 1;
                                        }
                                        if (till_what2 < 0) {
                                            till_what2 = 0;
                                        }


                                        for (int index = availableBalance2.length() - 1; index > till_what2; index--) {

                                            char a2 = availableBalance2.charAt(index);
                                            if (a2 != cha2 && a2 != '.') {
                                                check2 = false;
                                                proxy2 = proxy2 + 1;
                                                break;
                                            }
                                        }


                                        if (proxy1 == proxy2) {

                                            if (!check1) {

                                                actualAvailableBalance = availableBalance1;
                                                blockResult.setPass_avl_amount(Double.parseDouble(actualAvailableBalance));


                                            } else {

                                                actualAvailableBalance = availableBalance2;
                                                blockResult.setPass_avl_amount(Double.parseDouble(actualAvailableBalance));
                                                otherToDelete = otherToDelete.substring(0, otherToDelete.length() - 1);
                                                myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");

                                            }


                                        } else if (proxy1 > proxy2) {

                                            actualAvailableBalance = availableBalance1;
                                            blockResult.setPass_avl_amount(Double.parseDouble(actualAvailableBalance));
                                        } else {

                                            actualAvailableBalance = availableBalance2;

                                            blockResult.setPass_avl_amount(Double.parseDouble(actualAvailableBalance));

                                            otherToDelete = otherToDelete.substring(0, otherToDelete.length() - 1);
                                            myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");
                                        }

                                    } catch (Exception e) {

                                        logger.warning(e.getMessage());


                                    }
                                }

                            }

                        }
                    }

                    if ((availableBalance1.isEmpty() || availableBalance2.isEmpty()) && (lower_case_sms.contains(bal_amt3[0])
                            || lower_case_sms.contains(bal_amt3[1]) || lower_case_sms.contains(bal_amt3[2])
                            || lower_case_sms.contains(bal_amt3[3]))) {


                        Matcher match = Pattern.compile("(?i)(" + bal_amt3[0] + "|" + bal_amt3[1] + "|" + bal_amt3[2] + "|" + bal_amt3[3] + ")\\s*([[" + account_1[15] + "]]+|\\s*|" + bal_amt3[5] + ")\\s*(\\W){0,2}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|%|_|\\(|\\)|\\{|<| )").matcher(withOutUrlSMS);

                        while (match.find()) {

                            int startIndex =0;
                            if (match.group().contains("@")){
                                continue;
                            }
                            String testBalanceAmount = match.group();


                            String test = testBalanceAmount;

                            startIndex = match.start();
                            Matcher match3 = Pattern.compile("(?i)([[" + account_1[15] + "]]+|\\s*)(\\W){0,2}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|%|_|\\(|\\)|\\{|<| )").matcher(testBalanceAmount);

                            String otherToDelete = "";
                            while (match3.find()) {

                                otherToDelete = match3.group();
                                test = match3.group();
                                Matcher match33 = Pattern.compile("(?i)((" + bal_amt3[6] + "|" + bal_amt3[7] + ")\\.|[" + account_1[19] + "]|(?!\\.)[\\W])").matcher(test);

                                while (match33.find()) {

                                    try {
                                        test = test.replace(match33.group(), "").trim();
                                    } catch (Exception e) {
                                        logger.warning(e.getMessage());

                                    }
                                    if (test.endsWith(".")) {
                                        test = test.substring(0, test.length() - 1);
                                    }
                                }


                            }


                            if (availableBalance1.isEmpty()) {

                                available_bal1_text=testBalanceAmount;
                                all_factor1 = testBalanceAmount.length();
                                try {

                                    availableBalance1 = test;
                                    actualAvailableBalance = availableBalance1;


                                    blockResult.setPass_avl_amount(Double.parseDouble(actualAvailableBalance));

                                    otherToDelete = otherToDelete.substring(0, otherToDelete.length() - 1);

                                    int count = 0;
                                    Matcher matcherDelete = Pattern.compile("(?i)"+otherToDelete).matcher(myIncomingText);
                                    while (matcherDelete.find()){
                                        count = count+1;
                                    }
                                    if (count == 1) {
                                        myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");
                                    }else {
                                        try {
                                            if (myIncomingText.toLowerCase().contains(testBalanceAmount.toLowerCase())){
                                                startIndex = myIncomingText.toLowerCase().indexOf(testBalanceAmount.toLowerCase());

                                            }
                                            String test_delete = myIncomingText.substring(startIndex,(startIndex+testBalanceAmount.length()));
                                            String test_delete2 = test_delete.replace(otherToDelete.toLowerCase(), "");
                                            myIncomingText = myIncomingText.replace(test_delete.toLowerCase(), test_delete2);

                                            //Log.d("ATTTQQQ","5-- "+myIncomingText +" --"+testBalanceAmount);
                                        }catch (Exception e){
                                            logger.warning(e.getMessage());
                                            //Log.d("ATTTQQQ","crash5-- "+myIncomingText +" --"+testBalanceAmount);
                                        }
                                    }

                                } catch (Exception e) {
                                    logger.warning(e.getMessage());
                                }
                            } else {

                                if (availableBalance2.isEmpty() && cardNODigitsOnly.isEmpty()) {

                                    availableBalance2 = test;
                                    myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");
                                    available_bal2_text=testBalanceAmount;


                                    try {

                                        int index1_for_bal1=msg_text.indexOf(available_bal1_text)-15;
                                        if (index1_for_bal1<0){
                                            index1_for_bal1=0;
                                        }
                                        String first_String_to_check=msg_text.substring(index1_for_bal1,msg_text.indexOf(available_bal1_text));

                                        first_String_to_check=first_String_to_check.toLowerCase();

                                        if (first_String_to_check.contains(CASE15[52])||first_String_to_check.contains(CASE15[53])||
                                                first_String_to_check.contains(CASE15[54])||first_String_to_check.contains(CASE15[55]))
                                        {

                                            proxy1=proxy1+50;

                                        }

                                        int index1_for_bal2 = msg_text.indexOf(available_bal2_text) - 15;
                                        if (index1_for_bal2 < 0) {
                                            index1_for_bal2 = 0;
                                        }
                                        String second_String_to_check = msg_text.substring(index1_for_bal2, msg_text.indexOf(available_bal2_text));

                                        second_String_to_check = second_String_to_check.toLowerCase();

                                        if (second_String_to_check.contains(CASE15[52]) || second_String_to_check.contains(CASE15[53]) ||
                                                second_String_to_check.contains(CASE15[54]) || second_String_to_check.contains(CASE15[55])) {

                                            proxy2 = proxy2 + 50;

                                        }


                                    }catch (Exception e){
                                        logger.warning(e.getMessage());
                                    }

                                    all_factor2 = testBalanceAmount.length();

                                    try {

                                        if (all_factor1 > all_factor2) {
                                            proxy2 = proxy2 + 1;
                                        } else {
                                            proxy1 = proxy1 + 1;
                                        }

                                        if (Double.parseDouble(availableBalance1) > Double.parseDouble(availableBalance2)) {
                                            proxy2 = proxy2 + 1;

                                        } else {

                                            proxy1 = proxy1 + 1;
                                        }

                                        char cha = availableBalance1.charAt(availableBalance1.length() - 1);
                                        boolean check1 = true;
                                        int till_what = availableBalance1.length() - 3;
                                        if (availableBalance1.contains(".")) {
                                            till_what = availableBalance1.length() - 6;
                                            proxy1 = proxy1 + 1;
                                        }

                                        if (till_what < 0) {
                                            till_what = 0;
                                        }

                                        for (int index = availableBalance1.length() - 1; index > till_what; index--) {

                                            char a = availableBalance1.charAt(index);
                                            if (a != cha && a != '.') {
                                                check1 = false;
                                                proxy1 = proxy1 + 1;
                                                break;
                                            }
                                        }


                                        char cha2 = availableBalance2.charAt(availableBalance2.length() - 1);
                                        boolean check2 = true;

                                        int till_what2 = availableBalance2.length() - 3;
                                        if (availableBalance2.contains(".")) {
                                            till_what2 = availableBalance2.length() - 6;
                                            proxy2 = proxy2 + 1;
                                        }
                                        if (till_what2 < 0) {
                                            till_what2 = 0;
                                        }


                                        for (int index = availableBalance2.length() - 1; index > till_what2; index--) {

                                            char a2 = availableBalance2.charAt(index);
                                            if (a2 != cha2 && a2 != '.') {
                                                check2 = false;
                                                proxy2 = proxy2 + 1;
                                                break;
                                            }
                                        }


                                        if (proxy1 == proxy2) {

                                            if (!check1) {
                                                actualAvailableBalance = availableBalance1;
                                                blockResult.setPass_avl_amount(Double.parseDouble(actualAvailableBalance));

                                            } else {

                                                actualAvailableBalance = availableBalance2;

                                                blockResult.setPass_avl_amount(Double.parseDouble(actualAvailableBalance));
                                                otherToDelete = otherToDelete.substring(0, otherToDelete.length() - 1);
                                                myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");

                                            }

                                        } else if (proxy2 > proxy1) {
                                            actualAvailableBalance = availableBalance2;
                                            blockResult.setPass_avl_amount(Double.parseDouble(actualAvailableBalance));
                                            otherToDelete = otherToDelete.substring(0, otherToDelete.length() - 1);
                                            myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");

                                        } else {

                                            actualAvailableBalance = availableBalance1;
                                            blockResult.setPass_avl_amount(Double.parseDouble(actualAvailableBalance));
                                        }
                                    } catch (Exception e) {
                                         logger.warning(e.getMessage());

                                    }
                                }

                            }

                        }
                    }

                    //new case balance. is 900.01
                    if ((availableBalance1.isEmpty() || availableBalance2.isEmpty()) && (lower_case_sms.contains(bal_amt3[0])
                            || lower_case_sms.contains(bal_amt3[1]) || lower_case_sms.contains(bal_amt3[2])
                            || lower_case_sms.contains(bal_amt3[3]))) {


                        Matcher match = Pattern.compile("(?i)(" + bal_amt3[0] + "|" + bal_amt3[1] + "|" + bal_amt3[2] + "|" + bal_amt3[3] + ")(\\W+|\\s*)" + bal_amt3[5] + "\\s*(\\W){0,2}(\\d+\\.\\d+)").matcher(msg_text);

                        while (match.find()) {

                            int startIndex =0;
                            String testBalanceAmount = match.group();
                            String test;

                            startIndex = match.start();
                            String otherToDelete = match.group(4);
                            test = match.group(4);

                            if (availableBalance1.isEmpty()) {
                                available_bal1_text=testBalanceAmount;
                                all_factor1 = testBalanceAmount.length();
                                try {

                                    availableBalance1 = test;
                                    actualAvailableBalance = availableBalance1;


                                    blockResult.setPass_avl_amount(Double.parseDouble(actualAvailableBalance));

                                    otherToDelete = otherToDelete.substring(0, otherToDelete.length() - 1);

                                    int count = 0;
                                    Matcher matcherDelete = Pattern.compile("(?i)"+otherToDelete).matcher(myIncomingText);
                                    while (matcherDelete.find()){
                                        count = count+1;
                                    }
                                    if (count == 1) {
                                        myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");
                                    }else {
                                        try {
                                            if (myIncomingText.toLowerCase().contains(testBalanceAmount.toLowerCase())){
                                                startIndex = myIncomingText.toLowerCase().indexOf(testBalanceAmount.toLowerCase());

                                            }
                                            String test_delete = myIncomingText.substring(startIndex,(startIndex+testBalanceAmount.length()));
                                            String test_delete2 = test_delete.replace(otherToDelete.toLowerCase(), "");
                                            myIncomingText = myIncomingText.replace(test_delete.toLowerCase(), test_delete2);

                                            //Log.d("ATTTQQQ","6-- "+myIncomingText +" --"+testBalanceAmount);
                                        }catch (Exception e){
                                            logger.warning(e.getMessage());
                                            //Log.d("ATTTQQQ","crash6-- "+myIncomingText +" --"+testBalanceAmount);
                                        }
                                    }

                                } catch (Exception e) {
                                    logger.warning(e.getMessage());
                                }
                            } else {

                                if (availableBalance2.isEmpty() && cardNODigitsOnly.isEmpty()) {

                                    availableBalance2 = test;
                                    available_bal2_text=testBalanceAmount;
                                    myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");

                                    try {

                                        int index1_for_bal1=msg_text.indexOf(available_bal1_text)-15;
                                        if (index1_for_bal1<0){
                                            index1_for_bal1=0;
                                        }
                                        String first_String_to_check=msg_text.substring(index1_for_bal1,msg_text.indexOf(available_bal1_text));

                                        first_String_to_check=first_String_to_check.toLowerCase();

                                        if (first_String_to_check.contains(CASE15[52])||first_String_to_check.contains(CASE15[53])||
                                                first_String_to_check.contains(CASE15[54])||first_String_to_check.contains(CASE15[55]))
                                        {

                                            proxy1=proxy1+50;

                                        }

                                        int index1_for_bal2 = msg_text.indexOf(available_bal2_text) - 15;
                                        if (index1_for_bal2 < 0) {
                                            index1_for_bal2 = 0;
                                        }
                                        String second_String_to_check = msg_text.substring(index1_for_bal2, msg_text.indexOf(available_bal2_text));

                                        second_String_to_check = second_String_to_check.toLowerCase();

                                        if (second_String_to_check.contains(CASE15[52]) || second_String_to_check.contains(CASE15[53]) ||
                                                second_String_to_check.contains(CASE15[54]) || second_String_to_check.contains(CASE15[55])) {

                                            proxy2 = proxy2 + 50;

                                        }


                                    }catch (Exception e){
                                        logger.warning(e.getMessage());
                                    }

                                    all_factor2 = testBalanceAmount.length();

                                    try {

                                        if (all_factor1 > all_factor2) {
                                            proxy2 = proxy2 + 1;
                                        } else {
                                            proxy1 = proxy1 + 1;
                                        }

                                        if (Double.parseDouble(availableBalance1) > Double.parseDouble(availableBalance2)) {
                                            proxy2 = proxy2 + 1;

                                        } else {

                                            proxy1 = proxy1 + 1;
                                        }

                                        char cha = availableBalance1.charAt(availableBalance1.length() - 1);
                                        boolean check1 = true;
                                        int till_what = availableBalance1.length() - 3;
                                        if (availableBalance1.contains(".")) {
                                            till_what = availableBalance1.length() - 6;
                                            proxy1 = proxy1 + 1;
                                        }

                                        if (till_what < 0) {
                                            till_what = 0;
                                        }

                                        for (int index = availableBalance1.length() - 1; index > till_what; index--) {

                                            char a = availableBalance1.charAt(index);
                                            if (a != cha && a != '.') {
                                                check1 = false;
                                                proxy1 = proxy1 + 1;
                                                break;
                                            }
                                        }


                                        char cha2 = availableBalance2.charAt(availableBalance2.length() - 1);
                                        boolean check2 = true;

                                        int till_what2 = availableBalance2.length() - 3;
                                        if (availableBalance2.contains(".")) {
                                            till_what2 = availableBalance2.length() - 6;
                                            proxy2 = proxy2 + 1;
                                        }
                                        if (till_what2 < 0) {
                                            till_what2 = 0;
                                        }


                                        for (int index = availableBalance2.length() - 1; index > till_what2; index--) {

                                            char a2 = availableBalance2.charAt(index);
                                            if (a2 != cha2 && a2 != '.') {
                                                check2 = false;
                                                proxy2 = proxy2 + 1;
                                                break;
                                            }
                                        }


                                        if (proxy1 == proxy2) {

                                            if (!check1) {

                                                actualAvailableBalance = availableBalance1;
                                                blockResult.setPass_avl_amount(Double.parseDouble(actualAvailableBalance));


                                            } else {

                                                actualAvailableBalance = availableBalance2;
                                                blockResult.setPass_avl_amount(Double.parseDouble(actualAvailableBalance));
                                                otherToDelete = otherToDelete.substring(0, otherToDelete.length() - 1);
                                                myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");


                                            }


                                        } else if (proxy2 > proxy1) {

                                            actualAvailableBalance = availableBalance2;
                                            blockResult.setPass_avl_amount(Double.parseDouble(actualAvailableBalance));
                                            otherToDelete = otherToDelete.substring(0, otherToDelete.length() - 1);
                                            myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");


                                        } else {

                                            actualAvailableBalance = availableBalance1;
                                            blockResult.setPass_avl_amount(Double.parseDouble(actualAvailableBalance));
                                        }
                                    } catch (Exception e) {

                                        logger.warning(e.getMessage());
                                    }
                                }

                            }

                        }
                    }


                    //new case 5 for Rs 123.22 is your balance

                    if ((availableBalance1.isEmpty() || availableBalance2.isEmpty()) && (lower_case_sms.contains(bal_amt3[0]) || lower_case_sms.contains(bal_amt3[1]) || lower_case_sms.contains(bal_amt3[2]) || lower_case_sms.contains(bal_amt3[3]))) {


                        Matcher match = Pattern.compile("(?i)(" + bal_amt3[6] + "|" + bal_amt3[7] + ")\\s*[\\W]{0,3}([0-9,.]+)\\s" + bal_amt3[5] + "\\s(\\W|\\w){0,15}(" + bal_amt3[0] + "\\W|" + bal_amt3[1] + ")").matcher(msg_text);

                        while (match.find()) {

                            String testBalanceAmount = match.group();
                            String test;

                            String otherToDelete = match.group(2);
                            test = match.group(2).trim().replaceAll(",","");

                            if (availableBalance1.isEmpty()) {

                                if (test.contains(".")) {
                                    available_bal1_text=testBalanceAmount;
                                    all_factor1 = testBalanceAmount.length();
                                    try {

                                        availableBalance1 = test;
                                        actualAvailableBalance = availableBalance1;


                                        blockResult.setPass_avl_amount(Double.parseDouble(actualAvailableBalance));
                                        myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");// delete figure too
                                        myIncomingText = myIncomingText.replace(match.group(1).toLowerCase(), " ");// delete Rs Inr To
                                        myIncomingText = myIncomingText.replace(match.group(4).toLowerCase(), " ");// delete balance word To

                                    } catch (Exception e) {
                                        logger.warning(e.getMessage());
                                    }
                                }
                            } else {

                                if (availableBalance2.isEmpty() && cardNODigitsOnly.isEmpty()) {

                                    availableBalance2 = test;
                                    available_bal2_text=testBalanceAmount;
                                    myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");

                                    try {

                                        int index1_for_bal1=msg_text.indexOf(available_bal1_text)-15;
                                        if (index1_for_bal1<0){
                                            index1_for_bal1=0;
                                        }
                                        String first_String_to_check=msg_text.substring(index1_for_bal1,msg_text.indexOf(available_bal1_text));

                                        first_String_to_check=first_String_to_check.toLowerCase();

                                        if (first_String_to_check.contains(CASE15[52])||first_String_to_check.contains(CASE15[53])||
                                                first_String_to_check.contains(CASE15[54])||first_String_to_check.contains(CASE15[55]))
                                        {

                                            proxy1=proxy1+50;

                                        }

                                        int index1_for_bal2 = msg_text.indexOf(available_bal2_text) - 15;
                                        if (index1_for_bal2 < 0) {
                                            index1_for_bal2 = 0;
                                        }
                                        String second_String_to_check = msg_text.substring(index1_for_bal2, msg_text.indexOf(available_bal2_text));

                                        second_String_to_check = second_String_to_check.toLowerCase();

                                        if (second_String_to_check.contains(CASE15[52]) || second_String_to_check.contains(CASE15[53]) ||
                                                second_String_to_check.contains(CASE15[54]) || second_String_to_check.contains(CASE15[55])) {

                                            proxy2 = proxy2 + 50;

                                        }


                                    }catch (Exception e){
                                        logger.warning(e.getMessage());
                                    }

                                    all_factor2 = testBalanceAmount.length();

                                    try {

                                        if (all_factor1 > all_factor2) {
                                            proxy2 = proxy2 + 1;
                                        } else {
                                            proxy1 = proxy1 + 1;
                                        }

                                        if (Double.parseDouble(availableBalance1) > Double.parseDouble(availableBalance2)) {
                                            proxy2 = proxy2 + 1;

                                        } else {

                                            proxy1 = proxy1 + 1;
                                        }

                                        char cha = availableBalance1.charAt(availableBalance1.length() - 1);
                                        boolean check1 = true;
                                        int till_what = availableBalance1.length() - 3;
                                        if (availableBalance1.contains(".")) {
                                            till_what = availableBalance1.length() - 6;
                                            proxy1 = proxy1 + 1;
                                        }

                                        if (till_what < 0) {
                                            till_what = 0;
                                        }

                                        for (int index = availableBalance1.length() - 1; index > till_what; index--) {

                                            char a = availableBalance1.charAt(index);
                                            if (a != cha && a != '.') {
                                                check1 = false;
                                                proxy1 = proxy1 + 1;
                                                break;
                                            }
                                        }


                                        char cha2 = availableBalance2.charAt(availableBalance2.length() - 1);
                                        boolean check2 = true;

                                        int till_what2 = availableBalance2.length() - 3;
                                        if (availableBalance2.contains(".")) {
                                            till_what2 = availableBalance2.length() - 6;
                                            proxy2 = proxy2 + 1;
                                        }
                                        if (till_what2 < 0) {
                                            till_what2 = 0;
                                        }


                                        for (int index = availableBalance2.length() - 1; index > till_what2; index--) {

                                            char a2 = availableBalance2.charAt(index);
                                            if (a2 != cha2 && a2 != '.') {
                                                check2 = false;
                                                proxy2 = proxy2 + 1;
                                                break;
                                            }
                                        }


                                        if (proxy1 == proxy2) {

                                            if (!check1) {
                                                actualAvailableBalance = availableBalance1;
                                                blockResult.setPass_avl_amount(Double.parseDouble(actualAvailableBalance));


                                            } else {
                                                actualAvailableBalance = availableBalance2;
                                                blockResult.setPass_avl_amount(Double.parseDouble(actualAvailableBalance));
                                                otherToDelete = otherToDelete.substring(0, otherToDelete.length() - 1);
                                                myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");

                                            }


                                        } else if (proxy2 > proxy1) {

                                            actualAvailableBalance = availableBalance2;
                                            blockResult.setPass_avl_amount(Double.parseDouble(actualAvailableBalance));
                                            otherToDelete = otherToDelete.substring(0, otherToDelete.length() - 1);
                                            myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");


                                        } else {

                                            actualAvailableBalance = availableBalance1;
                                            blockResult.setPass_avl_amount(Double.parseDouble(actualAvailableBalance));
                                        }
                                    } catch (Exception e) {
                                        logger.warning(e.getMessage());
                                    }
                                }

                            }

                        }
                    }

//removed (" + bal_amt3[9] + "|-)\\s*(\\W|\\w){0,10}
                    Matcher matcherAmount77 = Pattern.compile("(?i)((" + bal_amt3[8] + "|o\\/s| os)\\s*(\\W|\\w){0,10}(" + bal_amt3[6] + "|" + bal_amt3[7] + ")([[" + account_1[15] + "]]+|\\s*)(\\W){0,3}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\)|\\{|<| ))").matcher(myIncomingText);

                    if (matcherAmount77.find()&&(!availableBalance1.isEmpty()||!availableBalance2.isEmpty())) {
                        int startIndex = 0;
                        String test = "0";
                        double out_standng_amount;
                        String amountText = matcherAmount77.group();
                        startIndex= matcherAmount77.start();
                        Matcher match3 = Pattern.compile("(?i)(" + bal_amt3[6] + "|" + bal_amt3[7] + ")\\s*([[" + account_1[15] + "]]+|\\s*)(\\W){0,3}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\)|\\{|<| )").matcher(amountText);

                        String otherToDelete = "";
                        while (match3.find()) {

                            test = match3.group();
                            Matcher match33 = Pattern.compile("(?i)((" + bal_amt3[6] + "|" + bal_amt3[7] + ")\\.|[" + account_1[19] + "]|(?!\\.)[\\W])").matcher(test);

                            while (match33.find()) {
                                otherToDelete = match3.group();
                                try {
                                    test = test.replace(match33.group(), "").trim();
                                } catch (Exception e) {
                                    logger.warning(e.getMessage());

                                }
                                if (test.endsWith(".")) {
                                    test = test.substring(0, test.length() - 1);
                                }
                            }
                        }


                        try {
                            out_standng_amount = Double.parseDouble(test);
                        } catch (Exception e) {
                            out_standng_amount = 0.000;
                        }

                        try {

                            blockResult.setPass_card_type(card_2[7]);

                            otherToDelete = otherToDelete.substring(0, otherToDelete.length() - 1);
                            int count = 0;
                            Matcher matcherDelete = Pattern.compile("(?i)"+otherToDelete).matcher(myIncomingText);
                            while (matcherDelete.find()){
                                count = count+1;
                            }
                            if (count == 1) {
                                myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");
                            }else {
                                try {
                                    if (myIncomingText.toLowerCase().contains(amountText.toLowerCase())){
                                        startIndex = myIncomingText.toLowerCase().indexOf(amountText.toLowerCase());

                                    }
                                    String test_delete = myIncomingText.substring(startIndex,(startIndex+amountText.length()));
                                    String test_delete2 = test_delete.replace(otherToDelete.toLowerCase(), "");
                                    myIncomingText = myIncomingText.replace(test_delete.toLowerCase(), test_delete2);

                                    //Log.d("ATTTQQQ","7-- "+myIncomingText +" --"+amountText);
                                }catch (Exception e){
                                    logger.warning(e.getMessage());
                                    //Log.d("ATTTQQQ","crash7-- "+myIncomingText +" --"+amountText);
                                }
                            }

                        } catch (Exception e) {
                            logger.warning(e.getMessage());
                        }


                        blockResult.setOut_standing(out_standng_amount);
                    } else {

                        Matcher matcherAmount771 = Pattern.compile("(?i)\\W(" + bal_amt3[10] + "|" + account_1[22] + ")(\\W)\\s*(\\W|\\w){0,10}(" + bal_amt3[5] + "|\\W+)\\s*(\\W|\\w){0,10}(" + bal_amt3[6] + "|" + bal_amt3[7] + "|)([[" + account_1[15] + "]]+|\\s*)(\\W){0,3}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\)|\\{|<|\n| )").matcher(myIncomingText);

                        if (matcherAmount771.find()) {
                            int startIndex = 0;
                            String testBalanceAmount = matcherAmount771.group();
                            String test = testBalanceAmount;

                            startIndex = matcherAmount771.start();
                            Matcher match3 = Pattern.compile("(?i)(" + bal_amt3[6] + "|" + bal_amt3[7] + "|)\\s*([[" + account_1[15] + "]]+|\\s*)(\\W){0,3}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\)|\\{|<| )").matcher(testBalanceAmount);

                            String otherToDelete = "";
                            while (match3.find()) {

                                otherToDelete = match3.group();
                                test = match3.group();
                                Matcher match33 = Pattern.compile("(?i)((" + bal_amt3[6] + "|" + bal_amt3[7] + ")\\.|[" + account_1[19] + "]|(?!\\.)[\\W])").matcher(test);

                                while (match33.find()) {

                                    try {
                                        test = test.replace(match33.group(), "").trim();
                                    } catch (Exception e) {
                                        logger.warning(e.getMessage());

                                    }
                                    if (test.endsWith(".")) {
                                        test = test.substring(0, test.length() - 1);
                                    }
                                }

                                if (test.contains(".") && (otherToDelete.contains(bal_amt3[6].toLowerCase()) || otherToDelete.contains(bal_amt3[7].toLowerCase()))) {

                                    break;
                                }

                            }

                            if (!test.contains(".") && changeSender.toLowerCase().contains(CASE15[117])){
                                test = test + ".00";
                            }

                            if (test.contains(".")) {

                                availableBalance1 = test;
                                blockResult.setPass_card_type(card_2[7]);

                                try {
                                    blockResult.setPass_avl_amount(Double.parseDouble(availableBalance1));
                                    otherToDelete = otherToDelete.substring(0, otherToDelete.length() - 1);
                                    int count = 0;
                                    Matcher matcherDelete = Pattern.compile("(?i)"+otherToDelete).matcher(myIncomingText);
                                    while (matcherDelete.find()){
                                        count = count+1;
                                    }
                                    if (count == 1) {
                                        myIncomingText = myIncomingText.replace(otherToDelete.toLowerCase(), "");
                                    }else {
                                        try {
                                            if (myIncomingText.toLowerCase().contains(testBalanceAmount.toLowerCase())){
                                                startIndex = myIncomingText.toLowerCase().indexOf(testBalanceAmount.toLowerCase());

                                            }
                                            String test_delete = myIncomingText.substring(startIndex,(startIndex+testBalanceAmount.length()));
                                            String test_delete2 = test_delete.replace(otherToDelete.toLowerCase(), "");
                                            myIncomingText = myIncomingText.replace(test_delete.toLowerCase(), test_delete2);

                                        }catch (Exception e){
                                            logger.warning(e.getMessage());
                                        }
                                    }

                                } catch (Exception e) {

                                    logger.warning(e.getMessage());

                                }
                            }
                        }

                    }






                    boolean chq_clearing = false;
                    if (where_at.isEmpty()) {

                        Matcher match2 = Pattern.compile("(?i)(\\W(" + wat4[0] + "|" + wat4[1] + "))\\W+([" + account_1[19] + "]|\\+|-).*?(\\.(" + wat4[2] + "|" + wat4[3] + "|" + wat4[4] + "|" + wat4[5] + "|" + wat4[6] + "|" + wat4[7] + "|" + wat4[8] + "))([\\W])").matcher(msg_text);
                        if (match2.find()) {
                            where_at = match2.group().trim();

                            int size = 0;

                            if (where_at.contains(".")) {
                                size = where_at.length();

                            }

                            if (size < 25) {

                                myIncomingText = myIncomingText.replace(where_at.toLowerCase(), "");
                                where_at = where_at.replaceFirst(wat4[0] + "\\W+", "");
                                where_at = where_at.replace(wat4[1], "");
                                where_at = where_at.replaceAll("(?i)(\\.(" + wat4[2] + "|" + wat4[3] + "|" + wat4[4] + "|" + wat4[5] + "|" + wat4[6] + "|" + wat4[7] + "|" + wat4[8] + ")|,|-|(?i)(" + wat4[9] + "|" + wat4[10] + "))", "");
                                where_at = where_at.replaceAll("__+", "");
                                where_at = where_at.replaceAll("\\s\\s+", " ");

                                if (where_at.endsWith(".")) {

                                    where_at = where_at.substring(0, where_at.length() - 1);
                                }

                            } else {
                                where_at = "";
                            }

                        }

                    }

                    if (where_at.isEmpty()) {

                        Matcher match2 = Pattern.compile("(?i)(" + wat4[9] + "|" + wat4[11] + "\\s|" + wat4[13] + "[\\W]|" + wat4[14] + " |" + wat4[15] + "|" + wat4[16] + "|" + wat4[17] + "| " + wat4[18] + "|" + wat4[19] + "\\s*" + wat4[20] + "|" + wat4[22] + "|" + wat4[12] + "|" + wat4[21] + ")").matcher(msg_text);
                        while (match2.find() && where_at.isEmpty()) {
                            String group2 = match2.group();
                            if (group2.toLowerCase().contains(wat4[12]) || group2.toLowerCase().contains(wat4[21])){

                                Matcher match_clear = Pattern.compile("(?i)(" + wat4[12] + "|" + wat4[21] + ")(.*?)" + wat4[45]).matcher(msg_text);

                                if (match_clear.find()){
                                    String match_clear_group2 = match_clear.group(2);

                                    if (!match_clear_group2.contains(".")) {
                                        chq_clearing= true;
                                        continue;
                                    }
                                }

                            }


                            where_at = match2.group().trim();
                            if(!where_at.toLowerCase().contains(wat4[9]) &&
                                    !where_at.toLowerCase().contains(CASE15[56])) {
                                myIncomingText = myIncomingText.replace(where_at.toLowerCase(), "");
                            }
                            if (where_at.toLowerCase().equals(wat4[21])) {

                                where_at = wat4[12];
                            }

                            where_at = where_at.replaceAll("__+", "");
                            where_at = where_at.replaceAll("\\s\\s+", " ");


                        }

                    }
                    if (where_at.isEmpty() || where_at.equalsIgnoreCase(wat4[9])) {
//removed '-'
                        Matcher match2 = Pattern.compile("((?i)\\W(" + wat4[0] + "|" + wat4[1] + "))\\W+([" + account_1[19] + "]|\\+|-).*?(\\.|_|,|:|$| (" + CASE15[6] + "|" + CASE15[7] + "|" + CASE15[8] + "|" + CASE15[9] + "|"+card_2[6]+"|" + CASE15[2] + ") )").matcher(msg_text);
                        if (match2.find()) {
                            where_at = match2.group().trim();
                            myIncomingText = myIncomingText.replace(where_at.toLowerCase(), "");
                            where_at = where_at.replaceFirst("(?i)"+wat4[0] + "\\W+", "");
                            where_at = where_at.replaceFirst("(?i)"+wat4[1], "");
                            where_at = where_at.replaceAll("(\\.|,|_|-|:)", "");


                            try {
                                if (where_at.toLowerCase().startsWith(wat4[64])){
                                    where_at = "";
                                }

                                where_at = where_at.trim();
                                if (match2.group(5)!=null) {
                                    String match4 = match2.group(5);
                                    where_at = where_at.replaceAll("(?i)\\W" + match4, "");
                                }
                            } catch (Exception e) {
                                logger.warning(e.getMessage());
                            }
                            where_at = where_at.replaceAll("__+", "");
                            where_at = where_at.replaceAll("\\s\\s+", " ");

                            if (where_at.endsWith(".")) {

                                where_at = where_at.substring(0, where_at.length() - 1);
                            }




                        }

                    }


                    if (where_at.isEmpty()){

                        try {
                            Matcher matcherDetails = Pattern.compile("(?i)"+wat4[65]+"\\:\\-(\\W|)(.*?)\\.\\(").matcher(msg_text);

                            if (matcherDetails.find()){

                                String group2 = matcherDetails.group(2);
                                where_at = group2;

                            }


                        }catch (Exception e){
                            logger.warning(e.getMessage());
                        }

                    }




                    if (where_at.isEmpty()) {

                        //removed '-'
                        Matcher match277 = Pattern.compile("((?i)(\\W" + wat4[23] + "|" + wat4[24] + ":)\\s*((?!" + wat4[25] + "|" + wat4[26] + "|" + wat4[27] + "|" + wat4[28] + "|"+wat4[48]+"|" + wat4[15] + "|" + wat4[16] + ")))[[:upper:]].*?(\\.|,|:|(?i)(" + wat4[9] + "|trans)|$)").matcher(msg_text);

                        if (match277.find()) {
                            where_at = match277.group().trim();
                            where_at = where_at.replaceFirst("(?i)"+wat4[23], "");
                            where_at = where_at.replace(wat4[29], "");
                            where_at = where_at.replaceAll("(?i)" + wat4[24] + ":", "");
                            where_at = where_at.replaceAll("(,|-|" + wat4[9] + ")", "");
                            where_at = where_at.replaceAll("__+", "");
                            where_at = where_at.replaceAll("\\s\\s+", " ");

                            if (where_at.endsWith(".")) {

                                where_at = where_at.substring(0, where_at.length() - 1);
                            }

                        }

                    }


                    try {

                        //HSBC

                        Matcher matcherDebitedFor = Pattern.compile("(?i)x{2,}["+account_1[13]+"]+["+account_1[19]+"\\s]+"+extra10[95]+"\\s+"+extra10[5]+"\\s+(.*?)\\s"+extra10[5]+"\\s("+extra10[44]+"|"+extra10[45]+")(\\W+|)["+account_1[13]+"]").matcher(msg_text);

                        if (matcherDebitedFor.find()){

                            String group1 = matcherDebitedFor.group(1);

                            String[] spiltSpacesOnly3 = group1.split("\\s");

                            if (spiltSpacesOnly3.length > 2){

                                group1 = spiltSpacesOnly3[0]+" "+spiltSpacesOnly3[1]+" "+spiltSpacesOnly3[2];

                            }
                            where_at = group1;

                        }




                    }catch (Exception exception){
                        logger.warning(exception.getMessage());
                    }







                    try {

                        Matcher matcherXX = Pattern.compile("(?i)(\\W)" + wat4[39] + "\\s*(\\W+|)[0-9]+").matcher(where_at);
                        if (matcherXX.find()) {

                            where_at = where_at.substring(0, matcherXX.start());

                        }

                    } catch (Exception e) {
                        logger.warning(e.getMessage());
                    }


                    Matcher match2452 = Pattern.compile("(?i)(" + CASE15[71] + "|" + wat4[11] + "\\W|" + wat4[13] + "[\\W]|" + wat4[37] + "|" + wat4[15] + "|" + wat4[16] + "|" + wat4[17] + "| " + wat4[18] + "|" + wat4[19] + "\\s*" + wat4[20] + "|" + wat4[22] + "|\\W" + wat4[14] + "\\W|" + wat4[12] + "|" + wat4[21] + "|" + wat4[38] + ")").matcher(msg_text);

                    if (match2452.find()) {
                        check_for_more = true;

                        String modes = match2452.group();


                        if ((modes.toLowerCase().contains(wat4[12]) || modes.toLowerCase().contains(wat4[21]))&& chq_clearing){

                        }else {
                            mode_of_trans = match2452.group();

                            if (!mode_of_trans.toLowerCase().contains(CASE15[56])) {
                                myIncomingText = myIncomingText.replace(mode_of_trans.toLowerCase(), "");
                            }
                            if (mode_of_trans.equals(wat4[21])) {

                                mode_of_trans = wat4[12];
                            } else if (mode_of_trans.equalsIgnoreCase(" " + wat4[18])) {

                                mode_of_trans = wat4[30];
                            } else if (mode_of_trans.toLowerCase().contains(wat4[13])
                                    || mode_of_trans.toLowerCase().contains(wat4[14] + " ")
                                    || mode_of_trans.toLowerCase().contains(wat4[11])) {

                                mode_of_trans = mode_of_trans.substring(0, mode_of_trans.length() - 1);
                                check_for_more = false;
                            }

                            mode_of_trans = mode_of_trans.trim();

                        }

                    }

                    if (mode_of_trans.isEmpty()){

                        Matcher matcher_transferred = Pattern.compile("(?i)(" + wat4[44]+"|"+CASE15[56]+"\\s" + wat4[29]+")").matcher(msg_text);

                        if (matcher_transferred.find()) {
                            check_for_more = true;
                            //mode_of_trans = matcher_transferred.group().trim();
                        }

                    }



                    if (mode_of_trans.isEmpty()) {

                        Matcher match24523 = Pattern.compile("(?i)(" + wat4[31] + "|" + wat4[32] + ")").matcher(msg_text);

                        if (match24523.find()) {
                            mode_of_trans = wat4[33];

                        }
                    }
                    // long time2=System.currentTimeMillis();
                    //------------------------------------------------------------------------------------
                    String[] trx5 = frameworkWords.trx5();
                    String[] crd6 = frameworkWords.crd6();
                    String[] dbt7 = frameworkWords.dbt7();

                    //if SMS contain Debited/ Credited WORD

                    try {


                        if (!your_word_present && cardNODigitsOnly.isEmpty() && msg_text.toLowerCase().contains(dbt7[3])
                                && msg_text.toLowerCase().contains(crd6[0]) &&
                                (temp_account_no.isEmpty() || temp_account_no_2.isEmpty() || temp_account_no_2.equals(temp_account_no))) {


                            int index_dbtd = msg_text.toLowerCase().indexOf(dbt7[3]);

                            int first_40 = index_dbtd - 40;
                            if (first_40 < 0) {
                                first_40 = 0;
                            }

                            int next_40 = index_dbtd + 40;
                            if (next_40 > msg_text.length()) {
                                next_40 = msg_text.length();
                            }

                            String subString = msg_text.toLowerCase().substring(first_40, next_40);

                            if (subString.contains(account_1[10])) {

                                Matcher matcher = Pattern.compile("(?i)(?<!(" + account_1[2] + "|" + account_1[24] + ")(\\w|\\W){1,3})(a\\/c|" + account_1[3] + "|" + account_1[4] + "|" + account_1[5] + "|" + account_1[6] + "|[ |.|-](?<!(" + account_1[2] + "|" + account_1[24] + ")(\\w|\\W){1,3})" + account_1[7] + "|^" + account_1[7] + ")(\\s|[[" + account_1[15] + "]]+)").matcher(subString);
                                if (matcher.find()) {
                                    accountNODigitsOnly = "";
                                    cardNODigitsOnly = "";
                                    blockResult.setOutput(0);
                                    blockResult.setPass_output(0);
                                    return blockResult;
                                }
                            }
                        }

                    } catch (Exception e) {
                        logger.warning(e.getMessage());
                    }


                    if (iGEtSTAT == 4) {

                        try {

                            Matcher match3 = Pattern.compile("(?i)(" + account_1[23] + "|" + wat4[23] + ")\\s*(\\W|\\w){0,10}(" + account_1[21] + "|" + trx5[11] + "|" + card_2[1] + "|" + trx5[0] + "|" + trx5[1] + "|" + trx5[2] + "|" + trx5[3] + "|" + trx5[4] + "(\\w+|))\\s*(\\W|\\w){0,6}(\\W|^)(" + wat4[26] + "|" + wat4[27] + ")(\\W+)[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| )").matcher(myIncomingText);

                            if (match3.find()) {
                                String test = match3.group();
                                Matcher match33 = Pattern.compile("(?i)(" + wat4[26] + "|" + wat4[27] + ")(\\W+)\\s*[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| )").matcher(test);
                                while (match33.find()) {

                                    test = match33.group();
                                    Matcher match331 = Pattern.compile("(?i)((" + wat4[26] + "|" + wat4[27] + ")\\.|[" + account_1[19] + "]|(?!\\.)[\\W])").matcher(test);

                                    while (match331.find()) {
                                        try {
                                            test = test.replace(match331.group(), "").trim();
                                        } catch (Exception e) {
                                            logger.warning(e.getMessage());

                                        }
                                        if (test.endsWith(".")) {
                                            test = test.substring(0, test.length() - 1);
                                        }
                                    }
                                }


                                try {
                                    amount_debited = Double.parseDouble(test);
                                } catch (Exception e) {
                                    amount_debited = 0.000;
                                }


                                blockResult.setPass_amount(amount_debited);
                                blockResult.setPass_status(dbt7[3]);

                                if (mode_of_trans.isEmpty()) {

                                    mode_of_trans = dbt7[0];
                                }

                                check_for_more = true;
                                blockResult.setAmount_int_status(1);

                            }

                        } catch (Exception e) {

                            logger.warning(e.getMessage());
                        }


                    }



                    try {


                        Matcher matcherAmount = Pattern.compile("(?i)(\\W|^)((((" + trx5[0] + "|" + trx5[1] + "|" + trx5[2] + "|" + trx5[3] + "|" + trx5[4] + "|" + trx5[5] + "|" + trx5[6] + "|" + trx5[7] + "|" + trx5[8] + "|" + trx5[9] + "|" + trx5[10] + "|" + trx5[11] + "|" + trx5[20] + "|" + trx5[21] + ")(\\s|\\.)*" + trx5[12] + ")|(" + trx5[11] + "red))\\s*(\\W|^)(" + trx5[13] + "|" + trx5[14] + ")([[" + account_1[15] + "]]+|\\s*)\\s*[" + account_1[13] + "].*?( (" + trx5[15] + "|" + trx5[16] + "|" + trx5[17] + "|" + trx5[18] + "|" + trx5[19] + ") ))").matcher(myIncomingText);

                        if (matcherAmount.find()) {
                            String test = "0";
                            String amountText = matcherAmount.group();

                            int indexOfAmount=myIncomingText.indexOf(amountText);
                            int startIndex=indexOfAmount-25;
                            if (startIndex<0){
                                startIndex=0;
                            }
                            String subst=myIncomingText.substring(startIndex,indexOfAmount)+"  "+amountText;

                            Matcher matcher_will=Pattern.compile("(" + crd6[10] + " (\\w| |-){2,12}\\s|" + crd6[11] + " (\\w| |-){2,12}\\s)(" + dbt7[1] + "|" + dbt7[3] + "|" + dbt7[11] + ")").matcher(subst);

                            if (matcher_will.find()||subst.contains(trx5[22])){
                                amountText="";
                                throw new Exception();
                            }else {

                                Matcher matcherScheduledOn = Pattern.compile("(?i)" + extra10[37] + "\\s" + wat4[39]).matcher(subst);

                                if (matcherScheduledOn.find()){
                                    amountText="";
                                    throw new Exception();
                                }

                            }


                            Matcher match3 = Pattern.compile("(?i)(" + trx5[13] + "|" + trx5[14] + ")\\s*([[" + account_1[15] + "]]+|\\s*)\\s*[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| )").matcher(amountText);


                            while (match3.find()) {

                                test = match3.group();
                                Matcher match33 = Pattern.compile("(?i)((" + trx5[13] + "|" + trx5[14] + ")\\.|[" + account_1[19] + "]|(?!\\.)[\\W]|" + trx5[15] + "|" + trx5[16] + "|" + trx5[17] + "|" + trx5[18] + "|" + trx5[19] + ")").matcher(test);

                                while (match33.find()) {
                                    try {
                                        test = test.replace(match33.group(), "").trim();
                                    } catch (Exception e) {
                                        logger.warning(e.getMessage());

                                    }
                                    if (test.endsWith(".")) {
                                        test = test.substring(0, test.length() - 1);
                                    }
                                }
                            }

                            int index = myIncomingText.indexOf(amountText) + amountText.length() + 15;
                            int index2 = myIncomingText.indexOf(amountText) - 15;
                            if (msg_text.length() < index) {
                                index = msg_text.length();
                            }
                            if (index2 < 0) {
                                index2 = 0;
                            }
                            String abc = "";
                            String abc2 = "";
                            try {
                                abc = myIncomingText.substring(myIncomingText.indexOf(amountText), index);
                            } catch (Exception e) {
                                abc = amountText;
                            }
                            try {
                                abc2 = myIncomingText.toLowerCase().substring(index2, myIncomingText.indexOf(amountText));
                            } catch (Exception e) {
                                abc = amountText;
                            }


                            Matcher matcher = Pattern.compile("(?i)(" + crd6[0] + "|" + crd6[1] + "|" + crd6[2] + "|" + crd6[3] + "|" + crd6[4] + "|" + crd6[5] + ")").matcher(abc);
                            Matcher matcherTest2 = Pattern.compile("(?i)(" + crd6[0] + "|" + crd6[1] + "|" + crd6[2] + "|" + crd6[3] + "|" + crd6[4] + "|" + crd6[5] + ")").matcher(abc2);

                            Matcher matcher_towards = Pattern.compile("(?i)(" + wat4[1] + ")").matcher(abc);
                            Matcher matcher2_towards = Pattern.compile("(?i)(" + wat4[1] + ")").matcher(abc2);


                            if (matcher.find() || matcherTest2.find()) {

                                try {
                                    amount_credited = Double.parseDouble(test);
                                } catch (Exception e) {
                                    amount_credited = 0.0;
                                }


                                blockResult.setPass_amount(amount_credited);
                                blockResult.setPass_status(crd6[0]);
                                if (blockResult.getPass_card_type().equals(card_2[8])) {
                                    blockResult.setPass_card_type(card_2[7]);
                                }

                                if (mode_of_trans.isEmpty()) {

                                    mode_of_trans = crd6[6];
                                }

                                blockResult.setAmount_int_status(2);


                            } else if (matcher_towards.find() || matcher2_towards.find() && blockResult.getPass_card_type().equals(card_2[7])) {


                                try {
                                    amount_credited = Double.parseDouble(test);


                                    blockResult.setPass_amount(amount_credited);
                                    blockResult.setPass_status(crd6[0]);

                                    if (mode_of_trans.isEmpty()) {

                                        mode_of_trans = crd6[6];
                                    }

                                    blockResult.setAmount_int_status(2);
                                } catch (Exception e) {
                                    amount_credited = 0.0;
                                }


                            } else {

                                //new logic payment of rs received

                                index2 = msg_text.indexOf(myIncomingText) - 15;

                                if (index2 < 0) {
                                    index2 = 0;
                                }
                                try {
                                    abc2 = myIncomingText.toLowerCase().substring(index2, myIncomingText.toLowerCase().indexOf(amountText.toLowerCase()));
                                } catch (Exception e) {
                                    abc2 = "";
                                }

                                Matcher matcher_new = Pattern.compile("(?i)(" + crd6[0] + "|" + crd6[1] + "|" + crd6[2] + "|" + crd6[3] + "|" + crd6[4] + "|" + crd6[5] + ")").matcher(abc2);

                                if (matcher_new.find()&& blockResult.getPass_card_type().equals(card_2[7])) {

                                    try {
                                        amount_credited = Double.parseDouble(test);
                                    } catch (Exception e) {
                                        amount_credited = 0.0;
                                    }


                                    blockResult.setPass_amount(amount_credited);
                                    blockResult.setPass_status(crd6[0]);
                                    if (blockResult.getPass_card_type().equals(card_2[8])) {
                                        blockResult.setPass_card_type(card_2[7]);
                                    }

                                    if (mode_of_trans.isEmpty()) {

                                        mode_of_trans = crd6[6];
                                    }

                                    blockResult.setAmount_int_status(2);


                                } else {
                                    try {
                                        amount_debited = Double.parseDouble(test);
                                    } catch (Exception e) {
                                        amount_debited = 0.0;
                                    }


                                    blockResult.setPass_amount(amount_debited);
                                    blockResult.setPass_status(dbt7[3]);

                                    if (mode_of_trans.isEmpty()) {

                                        mode_of_trans = dbt7[0];
                                    }

                                    blockResult.setAmount_int_status(1);
                                }
                            }
                        }

                    } catch (Exception ee) {
                        //logger.warning(ee.getMessage());
                    }



                    if (amount_debited == 0.0 && amount_credited == 0.0) {
                        try {


                            Matcher matcherAmount = Pattern.compile("(?i)\\W" + CASE15[10] + "\\s*" + trx5[12] + "\\s*(\\W|^)(" + trx5[13] + "|" + trx5[14] + ")([[" + account_1[15] + "]]+|\\s*)\\s*[" + account_1[13] + "].*?" + CASE15[11] + "").matcher(myIncomingText);

                            if (matcherAmount.find()) {
                                String test = "0";
                                String amountText = matcherAmount.group();

                                Matcher match3 = Pattern.compile("(?i)(" + trx5[13] + "|" + trx5[14] + ")\\s*([[" + account_1[15] + "]]+|\\s*)\\s*[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| )").matcher(amountText);


                                while (match3.find()) {

                                    test = match3.group();
                                    Matcher match33 = Pattern.compile("(?i)((" + trx5[13] + "|" + trx5[14] + ")\\.|[" + account_1[19] + "]|(?!\\.)[\\W]|" + trx5[15] + "|" + trx5[16] + "|" + trx5[17] + "|" + trx5[18] + "|" + trx5[19] + ")").matcher(test);

                                    while (match33.find()) {
                                        try {
                                            test = test.replace(match33.group(), "").trim();
                                        } catch (Exception e) {
                                            logger.warning(e.getMessage());

                                        }
                                        if (test.endsWith(".")) {
                                            test = test.substring(0, test.length() - 1);
                                        }
                                    }
                                }

                                try {
                                    amount_debited = Double.parseDouble(test);
                                } catch (Exception e) {
                                    amount_debited = 0.0;
                                    amount_debited = 0.0;
                                }


                                blockResult.setPass_amount(amount_debited);
                                blockResult.setPass_status(dbt7[3]);

                                if (mode_of_trans.isEmpty()) {

                                    mode_of_trans = dbt7[0];
                                }

                                blockResult.setAmount_int_status(1);


                            }

                        } catch (Exception ee) {
                            logger.warning(ee.getMessage());
                        }

                    }
                    boolean dbtd_extra = false;
                    boolean crdt_extra = false;

                    if (amount_debited == 0.0 && amount_credited == 0.0) {
                        int index = msg_text.indexOf(accountNODigitsOnly);
                        String to_match="";
                        try {


                            if (index >0) {
                                to_match = msg_text.substring(0, index);

                                Matcher matcher = Pattern.compile("(?i)((" + trx5[13] + "|" + trx5[14] + ")\\s*([[" + account_1[15] + "]]+\\s*|\\s*)([0-9,\\.]+)((\\w|\\W){0,12})(" + dbt7[1] + "|" + dbt7[2] + "|" + dbt7[3] + "|" + dbt7[5] + "|" + dbt7[9] + "|" + dbt7[11] + "|" + CASE15[45] + ")\\s" + trx5[17] + ")").matcher(to_match);
                                if (matcher.find()) {
                                    String test;

                                    test = matcher.group(4);
                                    test = test.replaceAll(",","");
                                    boolean is_willbe = false;
                                    try {
                                        String group5 = matcher.group(5);
                                        Matcher matcher_will = Pattern.compile("(?i)(" + crd6[8] + "|" + crd6[9] + ")").matcher(group5);

                                        if (matcher_will.find()) {
                                            test = "";
                                            is_willbe = true;

                                        }
                                    } catch (Exception e) {
                                        logger.warning(e.getMessage());
                                    }


                                    if (!is_willbe) {
                                        try {
                                            amount_debited = Double.parseDouble(test);
                                        } catch (Exception e) {
                                            amount_debited = 0.000;
                                        }

                                        blockResult.setPass_amount(amount_debited);
                                        blockResult.setPass_status(dbt7[3]);

                                        if (mode_of_trans.isEmpty()) {

                                            mode_of_trans = dbt7[0];
                                        }

                                        blockResult.setAmount_int_status(1);
                                    }
                                }
                            }

                        } catch (Exception e) {
                            logger.warning(e.getMessage());
                        }

                    }


                    if (amount_debited == 0.0 && amount_credited == 0.0) {



                        if (!accountNO.isEmpty()) {
                            if (myIncomingText.contains(crd6[0]) || myIncomingText.contains(crd6[7]) || myIncomingText.contains(crd6[2]) || (myIncomingText.contains(dbt7[1]) || myIncomingText.contains(dbt7[2])|| myIncomingText.contains(dbt7[11]) || myIncomingText.contains(dbt7[5]) || myIncomingText.contains(dbt7[6]) || myIncomingText.contains(" " + dbt7[7]) || myIncomingText.contains(dbt7[8]) || myIncomingText.contains(dbt7[9]))) {

                                if (!accountNO.isEmpty()) {
                                    String accountDigit = accountNODigitsOnly;
                                    int index = msg_text.indexOf(accountDigit) + 30;
                                    int index2 = msg_text.indexOf(accountNO) - 30;
                                    if (msg_text.length() < index) {
                                        index = msg_text.length();
                                    }
                                    if (index2 < 0) {
                                        index2 = 0;
                                    }
                                    String abc = "";
                                    String abc2 = "";
                                    try {

                                        int start_index= msg_text.indexOf(accountDigit);
                                        if(start_index>0){
                                            abc = msg_text.substring(msg_text.indexOf(accountDigit), index);
                                        }


                                    } catch (Exception e) {
                                        logger.warning(e.getMessage());


                                    }
                                    try {

                                        int end_index= msg_text.indexOf(accountDigit);
                                        if(end_index>index2){
                                            abc2 = msg_text.substring(index2, end_index);
                                        }

                                    } catch (Exception e) {
                                        logger.warning(e.getMessage());
                                    }

                                    Matcher matcher = Pattern.compile("(?i)(" + dbt7[1] + "|" + dbt7[3] + "|" + dbt7[2] + "|" + dbt7[4] + "|" + dbt7[5] + "|" + dbt7[6] + "|" + dbt7[7] + "[^" + account_1[20] + "]|" + dbt7[8] + "|" + dbt7[9] + "|" + dbt7[10] + "|" + dbt7[11] + ")").matcher(abc);
                                    Matcher matcher2 = Pattern.compile("(?i)(" + crd6[0] + "|" + crd6[7] + "|" + crd6[2] + "|" + crd6[3] + ")").matcher(abc);
                                    String first_debited = "";
                                    String first_debited_2 = "";
                                    String second_credited = "";
                                    String second_credited_2 = "";
                                    if (matcher.find()) {
                                        first_debited = dbt7[3];
                                        dbtd_extra = true;
                                    } else if (matcher2.find()) {
                                        second_credited = crd6[0];
                                        crdt_extra = true;
                                    } else {
                                        Matcher matcher_2 = Pattern.compile("(?i)(" + dbt7[1] + "|" + dbt7[3] + "|" + dbt7[2] + "|" + dbt7[4] + "|" + dbt7[5] + "|" + dbt7[6] + "|" + dbt7[7] + "[^" + account_1[20] + "]|" + dbt7[8] + "|" + dbt7[9] + "|" + dbt7[10] + "|" + dbt7[11] + ")").matcher(abc2);
                                        Matcher matcher2_2 = Pattern.compile("(?i)(" + crd6[0] + "|" + crd6[7] + "|" + crd6[2] + "|" + crd6[3] + ")").matcher(abc2);

                                        if (matcher_2.find()) {
                                            first_debited_2 = dbt7[3];
                                            dbtd_extra = true;
                                        } else if (matcher2_2.find()) {
                                            second_credited_2 = crd6[0];
                                            crdt_extra = true;
                                        }

                                    }



                                    if (!second_credited.isEmpty() || !second_credited_2.isEmpty()) {

                                        Matcher matcherAmount33 = Pattern.compile("(?i)((" + crd6[0] + "|" + crd6[7] + "|" + crd6[2] + "|" + crd6[3] + ").*?(\\W|^)(" + trx5[13] + "|" + trx5[14] + ")([[" + account_1[15] + "]]+|\\s*)(\\W){0,3}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| )|(\\W|^)((" + trx5[13] + "|" + trx5[14] + ")([[" + account_1[15] + "]]+|\\s*)\\s*[" + account_1[13] + "].*?(" + crd6[0] + "|" + crd6[7] + "|" + crd6[2] + "|" + crd6[3] + ")))").matcher(myIncomingText);

                                        if (matcherAmount33.find()) {
                                            String test = "0";
                                            String amountText = matcherAmount33.group();

                                            Matcher match3 = Pattern.compile("(?i)(" + trx5[13] + "|" + trx5[14] + ")\\s*([[" + account_1[15] + "]]+\\s*|\\s*)(\\W){0,3}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| )").matcher(amountText);


                                            while (match3.find()) {

                                                test = match3.group();
                                                Matcher match33 = Pattern.compile("(?i)((" + trx5[13] + "|" + trx5[14] + ")\\.|[" + account_1[19] + "]|(?!\\.)[\\W])").matcher(test);

                                                while (match33.find()) {
                                                    try {
                                                        test = test.replace(match33.group(), "").trim();
                                                    } catch (Exception e) {
                                                        logger.warning(e.getMessage());

                                                    }
                                                    if (test.endsWith(".")) {
                                                        test = test.substring(0, test.length() - 1);
                                                    }
                                                }
                                            }


                                            try {
                                                amount_credited = Double.parseDouble(test);
                                            } catch (Exception e) {
                                                amount_credited = 0.00;
                                            }


                                            blockResult.setPass_status(crd6[0]);
                                            blockResult.setPass_amount(amount_credited);

                                            if (blockResult.getPass_card_type().equals(card_2[8])) {
                                                blockResult.setPass_card_type(card_2[7]);
                                            }


                                            if (mode_of_trans.isEmpty()) {

                                                mode_of_trans = crd6[6];
                                            }
                                            blockResult.setAmount_int_status(2);
                                        }
                                    } else if (!first_debited.isEmpty() || !first_debited_2.isEmpty()) {

                                        //(?i)(((((?<!will be )(?<!shall be ))(debit|debited))|spent|purchased|withdrawn|withdrawal|dr[^a-z]|purchase|paid|charged).*?(Rs|INR)([[:punct:]]+|\s*)(\W){0,3}[0-9].*?([a-z]|$|:|=|-|_|\(|\{|<| )|((Rs|INR)([[:punct:]]+|\s*)(\W){0,3}[0-9].*?((((?<!will (\w| |-){2,12}\s)(?<!shall (\w| |-){2,12}\s)(?<!would (\w| |-){2,12}\s))(debit|debited))|spent|purchased|withdrawn|withdrawal|dr[^a-z]|purchase|paid|charged)))
                                        Matcher matcherAmount66 = Pattern.compile("(?i)((((?<!" + crd6[10] + " (\\w| |-){2,12}\\s)(?<!" + crd6[11] + " (\\w| |-){2,12}\\s)(?<!" + crd6[12] + " (\\w| |-){2,12}\\s))(" + dbt7[1] + "|" + dbt7[3] + "|" + dbt7[11] + "))|" + dbt7[2] + "|" + dbt7[4] + "|" + dbt7[5] + "|" + dbt7[6] + "|" + dbt7[7] + "[^" + account_1[20] + "]|" + dbt7[8] + "|" + dbt7[9] + "|" + dbt7[10] + ")(\\w|\\W){0,35}(\\W|^)(" + trx5[13] + "|" + trx5[14] + ")([[" + account_1[15] + "]]+|\\s*)(\\W){0,3}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| )").matcher(myIncomingText);

                                        if (matcherAmount66.find()) {



                                            String test = "0";
                                            String amountText = matcherAmount66.group();

                                            String checkInString = amountText;

                                            int indexAmountText = myIncomingText.indexOf(amountText) - 12;

                                            if (indexAmountText < 0) {
                                                indexAmountText = 0;
                                            }

                                            checkInString = myIncomingText.substring(indexAmountText, (indexAmountText + 12 +amountText.length()));


                                            Matcher matcher_check_prev = Pattern.compile("(?i)(" + trx5[23] + "|" + trx5[25] + "\\.|" + trx5[24] + "|" + trx5[26] + "(\\.|))\\s*(" + dbt7[1] + "|" + dbt7[3] + "|" + dbt7[11] + "|" + dbt7[2] + "|" + dbt7[4] + "|" + dbt7[5] + "|" + dbt7[6] + "|" + dbt7[7] + "[^" + account_1[20] + "]|" + dbt7[8] + "|" + dbt7[9] + "|" + dbt7[10] + ")").matcher(checkInString);

                                            if (matcher_check_prev.find()){

                                                blockResult = new BlockResult();
                                                blockResult.setPass_output(iGEtSTAT);
                                                blockResult.setOutput(iGEtSTAT);
                                                return blockResult;
                                            }

                                            Matcher match3 = Pattern.compile("(?i)(" + trx5[13] + "|" + trx5[14] + ")\\s*([[" + account_1[15] + "]]+|\\s*)(\\W){0,3}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| )").matcher(amountText);


                                            while (match3.find()) {

                                                test = match3.group();
                                                Matcher match33 = Pattern.compile("(?i)((" + trx5[13] + "|" + trx5[14] + ")\\.|[" + account_1[19] + "]|(?!\\.)[\\W])").matcher(test);

                                                while (match33.find()) {
                                                    try {
                                                        test = test.replace(match33.group(), "").trim();
                                                    } catch (Exception e) {
                                                        logger.warning(e.getMessage());

                                                    }
                                                    if (test.endsWith(".")) {
                                                        test = test.substring(0, test.length() - 1);
                                                    }
                                                }
                                            }


                                            try {
                                                amount_debited = Double.parseDouble(test);
                                            } catch (Exception e) {
                                                amount_debited = 0.000;
                                            }


                                            blockResult.setPass_amount(amount_debited);
                                            blockResult.setPass_status(dbt7[3]);

                                            if (mode_of_trans.isEmpty()) {

                                                mode_of_trans = dbt7[0];
                                            }

                                            blockResult.setAmount_int_status(1);

                                        } else {

                                            Matcher matcherAmount626 = Pattern.compile("(?i)(\\W|^)(" + trx5[13] + "|" + trx5[14] + ")([[" + account_1[15] + "]]+|\\s*)(\\W){0,3}[" + account_1[13] + "].*?((((?<!" + crd6[10] + " (\\w| |-){2,12}\\s)(?<!" + crd6[11] + " (\\w| |-){2,12}\\s)(?<!" + crd6[12] + " (\\w| |-){2,12}\\s))(" + dbt7[1] + "|" + dbt7[3] + "|" + dbt7[11] + "))|" + dbt7[2] + "|" + dbt7[4] + "|" + dbt7[5] + "|" + dbt7[6] + "|" + dbt7[7] + "[^" + account_1[20] + "]|" + dbt7[8] + "|" + dbt7[9] + "|" + dbt7[10] + ")").matcher(myIncomingText);

                                            if (matcherAmount626.find()) {

                                                String test = "0";
                                                String amountText = matcherAmount626.group();


                                                String checkInString = amountText;

                                                int indexAmountText = myIncomingText.indexOf(amountText) - 12;

                                                if (indexAmountText < 0) {
                                                    indexAmountText = 0;
                                                }

                                                checkInString = myIncomingText.substring(indexAmountText, (indexAmountText + 12 +amountText.length()));


                                                Matcher matcher_check_prev = Pattern.compile("(?i)(" + trx5[23] + "|" + trx5[25] + "\\.|" + trx5[24] + "|" + trx5[26] + "(\\.|))\\s*(" + dbt7[1] + "|" + dbt7[3] + "|" + dbt7[11] + "|" + dbt7[2] + "|" + dbt7[4] + "|" + dbt7[5] + "|" + dbt7[6] + "|" + dbt7[7] + "[^" + account_1[20] + "]|" + dbt7[8] + "|" + dbt7[9] + "|" + dbt7[10] + ")").matcher(checkInString);

                                                if (matcher_check_prev.find()){

                                                    blockResult = new BlockResult();
                                                    blockResult.setPass_output(iGEtSTAT);
                                                    blockResult.setOutput(iGEtSTAT);
                                                    return blockResult;
                                                }


                                                Matcher match3 = Pattern.compile("(?i)(" + trx5[13] + "|" + trx5[14] + ")\\s*([[" + account_1[15] + "]]+|\\s*)(\\W){0,3}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| )").matcher(amountText);


                                                while (match3.find()) {

                                                    test = match3.group();
                                                    Matcher match33 = Pattern.compile("(?i)((" + trx5[13] + "|" + trx5[14] + ")\\.|[" + account_1[19] + "]|(?!\\.)[\\W])").matcher(test);

                                                    while (match33.find()) {
                                                        try {
                                                            test = test.replace(match33.group(), "").trim();
                                                        } catch (Exception e) {
                                                            logger.warning(e.getMessage());

                                                        }
                                                        if (test.endsWith(".")) {
                                                            test = test.substring(0, test.length() - 1);
                                                        }
                                                    }
                                                }


                                                try {
                                                    amount_debited = Double.parseDouble(test);
                                                } catch (Exception e) {
                                                    amount_debited = 0.000;
                                                }


                                                blockResult.setPass_amount(amount_debited);
                                                blockResult.setPass_status(dbt7[3]);

                                                if (mode_of_trans.isEmpty()) {

                                                    mode_of_trans = dbt7[0];
                                                }

                                                blockResult.setAmount_int_status(1);

                                            }
                                        }


                                    }


                                }
                            }

                        }
                        if (blockResult.getPass_amount() <= 0.0) {

                            myIncomingText=myIncomingText.replaceAll("(?i)" + CASE15[6] + "\\s" + CASE15[20] + "\\s" + CASE15[44] + "",""+crd6[0]);

                            if (myIncomingText.contains(crd6[0]) || myIncomingText.contains(crd6[7]) || myIncomingText.contains(crd6[2])) {


                                Matcher matcherAmount33 = Pattern.compile("(?i)((" + crd6[0] + "|" + crd6[7] + "|" + crd6[2] + "|" + crd6[3] + ").*?(\\W|^)(" + trx5[13] + "|" + trx5[14] + ")([[" + account_1[15] + "]]+|\\s*)(\\W){0,3}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| )|(\\W|^)(" + trx5[13] + "|" + trx5[14] + ")([[" + account_1[15] + "]]+|\\s*)(\\W){0,3}[" + account_1[13] + "].*?(" + crd6[0] + "|" + crd6[7] + "|" + crd6[2] + "|" + crd6[3] + "))").matcher(myIncomingText);

                                if (matcherAmount33.find()) {
                                    String test = "0";
                                    String amountText = matcherAmount33.group();

                                    Matcher match3 = Pattern.compile("(?i)(" + trx5[13] + "|" + trx5[14] + ")\\s*([[" + account_1[15] + "]]+|\\s*)(\\W){0,3}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| )").matcher(amountText);

                                    while (match3.find()) {

                                        test = match3.group();
                                        Matcher match33 = Pattern.compile("(?i)((" + trx5[13] + "|" + trx5[14] + ")\\.|[" + account_1[19] + "]|(?!\\.)[\\W])").matcher(test);

                                        while (match33.find()) {
                                            try {
                                                test = test.replace(match33.group(), "").trim();
                                            } catch (Exception e) {
                                                logger.warning(e.getMessage());

                                            }
                                            if (test.endsWith(".")) {
                                                test = test.substring(0, test.length() - 1);
                                            }
                                        }
                                    }


                                    try {
                                        amount_credited = Double.parseDouble(test);
                                    } catch (Exception e) {
                                        amount_credited = 0.00;
                                    }


                                    blockResult.setPass_status(crd6[0]);
                                    blockResult.setPass_amount(amount_credited);

                                    if (blockResult.getPass_card_type().equals(card_2[8])) {
                                        blockResult.setPass_card_type(card_2[7]);
                                    }


                                    if (mode_of_trans.isEmpty()) {

                                        mode_of_trans = crd6[6];
                                    }
                                    blockResult.setAmount_int_status(2);
                                } else {


                                    if (crdt_extra) {

                                        //extra case
                                        Matcher matcherAmount334 = Pattern.compile("(?i)((" + crd6[0] + "|" + crd6[7] + "|" + crd6[2] + "|" + crd6[3] + ").*?(\\d+.\\d+|\\d+)\\s*(" + trx5[13] + "|" + trx5[14] + ")(\\W|$)|(\\d+.\\d+|\\d+)\\s*(" + trx5[13] + "|" + trx5[14] + ")(\\W).*?(" + crd6[0] + "|" + crd6[7] + "|" + crd6[2] + "|" + crd6[3] + "))").matcher(myIncomingText);

                                        if (matcherAmount334.find()) {


                                            String test = "0";
                                            String amountText = matcherAmount334.group();

                                            Matcher match3 = Pattern.compile("(?i)(\\d+.\\d+|\\d+)\\s*(" + trx5[13] + "|" + trx5[14] + ")").matcher(amountText);


                                            while (match3.find()) {

                                                test = match3.group();
                                                Matcher match33 = Pattern.compile("(?i)((" + trx5[13] + "|" + trx5[14] + ")\\.|[" + account_1[19] + "]|(?!\\.)[\\W])").matcher(test);

                                                while (match33.find()) {
                                                    try {
                                                        test = test.replace(match33.group(), "").trim();
                                                    } catch (Exception e) {
                                                        logger.warning(e.getMessage());

                                                    }
                                                    if (test.endsWith(".")) {
                                                        test = test.substring(0, test.length() - 1);
                                                    }
                                                }
                                            }


                                            try {
                                                amount_credited = Double.parseDouble(test);
                                            } catch (Exception e) {
                                                amount_credited = 0.00;
                                            }


                                            blockResult.setPass_status(crd6[0]);
                                            blockResult.setPass_amount(amount_credited);

                                            if (blockResult.getPass_card_type().equals(card_2[8])) {
                                                blockResult.setPass_card_type(card_2[7]);
                                            }


                                            if (mode_of_trans.isEmpty()) {

                                                mode_of_trans = crd6[6];
                                            }
                                            blockResult.setAmount_int_status(2);
                                        }
                                    }
                                }


                            } else if (myIncomingText.contains(dbt7[1]) || myIncomingText.contains(dbt7[2])
                                    || myIncomingText.contains(dbt7[8]) || myIncomingText.contains(dbt7[5])
                                    || myIncomingText.contains(dbt7[6]) || myIncomingText.contains(" " + dbt7[7]) || myIncomingText.contains(dbt7[9])
                                    || myIncomingText.contains(dbt7[10])|| myIncomingText.contains(dbt7[11])) {

//charged
                                Matcher matcherAmount66 = Pattern.compile("(?i)(((((?<!" + crd6[10] + " (\\w| |-){2,12}\\s)(?<!" + crd6[11] + " (\\w| |-){2,12}\\s)(?<!" + crd6[12] + " (\\w| |-){2,12}\\s))(" + dbt7[1] + "|" + dbt7[3] + "|" + dbt7[11] + "))|" + dbt7[2] + "|" + dbt7[4] + "|" + dbt7[5] + "|" + dbt7[6] + "|" + dbt7[7] + "[^" + account_1[20] + "]|" + dbt7[8] + "|" + dbt7[9] + "|" + dbt7[10] + ").*?(\\W|^)(" + trx5[13] + "|" + trx5[14] + ")([[" + account_1[15] + "]]+|\\s*)(\\W){0,3}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| )|((\\W|^)(" + trx5[13] + "|" + trx5[14] + ")([[" + account_1[15] + "]]+|\\s*)(\\W){0,3}[" + account_1[13] + "].*?((((?<!" + crd6[10] + " (\\w| |-){2,12}\\s)(?<!" + crd6[11] + " (\\w| |-){2,12}\\s)(?<!" + crd6[12] + " (\\w| |-){2,12}\\s))(" + dbt7[1] + "|" + dbt7[3] + "|" + dbt7[11] + "))|" + dbt7[2] + "|" + dbt7[4] + "|" + dbt7[5] + "|" + dbt7[6] + "|" + dbt7[7] + "[^" + account_1[20] + "]|" + dbt7[8] + "|" + dbt7[9] + "|" + dbt7[10] + ")))").matcher(myIncomingText);

                                if (matcherAmount66.find()) {


                                    String test = "0";
                                    String amountText = matcherAmount66.group();

                                    String checkInString = amountText;

                                    int indexAmountText = myIncomingText.indexOf(amountText) - 12;

                                    if (indexAmountText < 0) {
                                        indexAmountText = 0;
                                    }

                                    checkInString = myIncomingText.substring(indexAmountText, (indexAmountText + 12 +amountText.length()));


                                    Matcher matcher_check_prev = Pattern.compile("(?i)(" + trx5[23] + "|" + trx5[25] + "\\.|" + trx5[24] + "|" + trx5[26] + "(\\.|))\\s*(" + dbt7[1] + "|" + dbt7[3] + "|" + dbt7[11] + "|" + dbt7[2] + "|" + dbt7[4] + "|" + dbt7[5] + "|" + dbt7[6] + "|" + dbt7[7] + "[^" + account_1[20] + "]|" + dbt7[8] + "|" + dbt7[9] + "|" + dbt7[10] + ")").matcher(checkInString);

                                    if (matcher_check_prev.find()){

                                        blockResult = new BlockResult();
                                        blockResult.setPass_output(iGEtSTAT);
                                        blockResult.setOutput(iGEtSTAT);
                                        return blockResult;
                                    }



                                    Matcher match3 = Pattern.compile("(?i)(" + trx5[13] + "|" + trx5[14] + ")\\s*([[" + account_1[15] + "]]+|\\s*)(\\W){0,3}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| )").matcher(amountText);


                                    while (match3.find()) {

                                        test = match3.group();
                                        Matcher match33 = Pattern.compile("(?i)((" + trx5[13] + "|" + trx5[14] + ")\\.|[" + account_1[19] + "]|(?!\\.)[\\W])").matcher(test);

                                        while (match33.find()) {
                                            try {
                                                test = test.replace(match33.group(), "").trim();
                                            } catch (Exception e) {
                                                logger.warning(e.getMessage());

                                            }
                                            if (test.endsWith(".")) {
                                                test = test.substring(0, test.length() - 1);
                                            }
                                        }
                                    }


                                    try {
                                        amount_debited = Double.parseDouble(test);
                                    } catch (Exception e) {
                                        amount_debited = 0.000;
                                    }


                                    blockResult.setPass_amount(amount_debited);
                                    blockResult.setPass_status(dbt7[3]);

                                    if (mode_of_trans.isEmpty()) {

                                        mode_of_trans = dbt7[0];
                                    }

                                    blockResult.setAmount_int_status(1);

                                } else {

                                    //extra case

                                    if (dbtd_extra) {


                                        Matcher matcherAmount663 = Pattern.compile("(?i)(((((?<!" + crd6[10] + " (\\w| |-){2,12}\\s)(?<!" + crd6[11] + " (\\w| |-){2,12}\\s)(?<!" + crd6[12] + " (\\w| |-){2,12}\\s))(" + dbt7[1] + "|" + dbt7[3] + "|" + dbt7[11] + "))|" + dbt7[2] + "|" + dbt7[4] + "|" + dbt7[5] + "|" + dbt7[6] + "|" + dbt7[7] + "[^" + account_1[20] + "]|" + dbt7[8] + "|" + dbt7[9] + "|" + dbt7[10] + ").*?(\\d+.\\d+|\\d+)\\s*(" + trx5[13] + "|" + trx5[14] + ")(\\W|$)|((\\d+.\\d+|\\d+)\\s*(" + trx5[13] + "|" + trx5[14] + ")(\\W).*?((((?<!" + crd6[10] + " (\\w| |-){2,12}\\s)(?<!" + crd6[11] + " (\\w| |-){2,12}\\s)(?<!" + crd6[12] + " (\\w| |-){2,12}\\s))(" + dbt7[1] + "|" + dbt7[3] + "|" + dbt7[11] + "))|" + dbt7[2] + "|" + dbt7[4] + "|" + dbt7[5] + "|" + dbt7[6] + "|" + dbt7[7] + "[^" + account_1[20] + "]|" + dbt7[8] + "|" + dbt7[9] + "|" + dbt7[10] + ")))").matcher(myIncomingText);

                                        if (matcherAmount663.find()) {


                                            String test = "0";
                                            String amountText = matcherAmount663.group();


                                            String checkInString = amountText;

                                            int indexAmountText = myIncomingText.indexOf(amountText) - 12;

                                            if (indexAmountText < 0) {
                                                indexAmountText = 0;
                                            }

                                            checkInString = myIncomingText.substring(indexAmountText, (indexAmountText + 12 +amountText.length()));


                                            Matcher matcher_check_prev = Pattern.compile("(?i)(" + trx5[23] + "|" + trx5[25] + "\\.|" + trx5[24] + "|" + trx5[26] + "(\\.|))\\s*(" + dbt7[1] + "|" + dbt7[3] + "|" + dbt7[11] + "|" + dbt7[2] + "|" + dbt7[4] + "|" + dbt7[5] + "|" + dbt7[6] + "|" + dbt7[7] + "[^" + account_1[20] + "]|" + dbt7[8] + "|" + dbt7[9] + "|" + dbt7[10] + ")").matcher(checkInString);

                                            if (matcher_check_prev.find()){

                                                blockResult = new BlockResult();
                                                blockResult.setPass_output(iGEtSTAT);
                                                blockResult.setOutput(iGEtSTAT);
                                                return blockResult;
                                            }

                                            Matcher match3 = Pattern.compile("(?i)(\\d+.\\d+|\\d+)\\s*(" + trx5[13] + "|" + trx5[14] + ")").matcher(amountText);


                                            while (match3.find()) {

                                                test = match3.group();
                                                Matcher match33 = Pattern.compile("(?i)((" + trx5[13] + "|" + trx5[14] + ")\\.|[" + account_1[19] + "]|(?!\\.)[[" + account_1[15] + "]])").matcher(test);

                                                while (match33.find()) {
                                                    try {
                                                        test = test.replace(match33.group(), "").trim();
                                                    } catch (Exception e) {
                                                        logger.warning(e.getMessage());

                                                    }
                                                    if (test.endsWith(".")) {
                                                        test = test.substring(0, test.length() - 1);
                                                    }
                                                }
                                            }


                                            try {
                                                amount_debited = Double.parseDouble(test);
                                            } catch (Exception e) {
                                                amount_debited = 0.000;
                                            }


                                            blockResult.setPass_amount(amount_debited);
                                            blockResult.setPass_status(dbt7[3]);

                                            if (mode_of_trans.isEmpty()) {

                                                mode_of_trans = dbt7[0];
                                            }

                                            blockResult.setAmount_int_status(1);

                                        }

                                    }
                                }


                            }
                        }

                    }


                    //receive credit in case


                    if (amount_debited == 0.0 && amount_credited == 0.0) {
                        try {


                            Matcher matcherAmount = Pattern.compile("(?i)\\W" + crd6[4] + "d(\\w|\\W){0,6}\\s*(" + crd6[1] + " in\\W)\\s*(\\W|\\w){0,8}(xx|\\.\\.|\\*\\*)+[0-9]{2,8}.*?((\\W|^)(" + trx5[13] + "|" + trx5[14] + ")\\s*([[" + account_1[15] + "]]+|\\s*)\\s*[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| ))").matcher(incomingSms);

                            if (matcherAmount.find()) {
                                String test = "0";
                                test = matcherAmount.group(5);

                                Matcher match33 = Pattern.compile("(?i)((" + trx5[13] + "|" + trx5[14] + ")\\.|[" + account_1[19] + "]|(?!\\.)[\\W]|" + trx5[15] + "|" + trx5[16] + "|" + trx5[17] + "|" + trx5[18] + "|" + trx5[19] + ")").matcher(test);

                                while (match33.find()) {
                                    try {
                                        test = test.replace(match33.group(), "").trim();
                                    } catch (Exception e) {
                                        logger.warning(e.getMessage());

                                    }
                                    if (test.endsWith(".")) {
                                        test = test.substring(0, test.length() - 1);
                                    }
                                }


                                try {
                                    amount_credited = Double.parseDouble(test);
                                } catch (Exception e) {
                                    amount_credited = 0.0;
                                }


                                blockResult.setPass_amount(amount_credited);
                                blockResult.setPass_status(crd6[0]);

                                if (mode_of_trans.isEmpty()) {

                                    mode_of_trans = crd6[6];
                                }

                                blockResult.setAmount_int_status(2);


                            }

                        } catch (Exception ee) {
                            logger.warning(ee.getMessage());
                        }

                    }



                    //receive credit With DOP Bank
                    if (amount_debited == 0.0 && amount_credited == 0.0 && checkIfBankID.equals("1")) {
                        try {

                            Matcher matcherAmount = Pattern.compile("(?i)\\W" + crd6[1] + " "+card_2[6]+"(\\W|\\w){1,10}(" + trx5[13] + "|" + trx5[14] + ")\\W+(\\d+\\.\\d+|\\d+)").matcher(incomingSms);

                            if (matcherAmount.find()) {
                                String test = "0";
                                test = matcherAmount.group(3);

                                try {
                                    amount_credited = Double.parseDouble(test);

                                    blockResult.setPass_amount(amount_credited);
                                    blockResult.setPass_status(crd6[0]);

                                    if (mode_of_trans.isEmpty()) {

                                        mode_of_trans = crd6[6];
                                    }

                                    blockResult.setAmount_int_status(2);
                                } catch (Exception e) {
                                    amount_credited = 0.0;
                                }

                            }

                        } catch (Exception ee) {
                            logger.warning(ee.getMessage());
                        }


                        try {

                            if (amount_debited == 0.0 && amount_credited == 0.0) {
                                Matcher matcherAmount = Pattern.compile("(?i)\\W(" + trx5[13] + "|" + trx5[14] + ")\\W+(\\d+\\.\\d+|\\d+)\\W"+ CASE15[11] +"\\s"+CASE15[46]+"(\\W|\\w){1,35}"+trx5[15]+"\\W").matcher(incomingSms);

                                if (matcherAmount.find()) {
                                    String test = "0";
                                    test = matcherAmount.group(2);

                                    try {
                                        amount_debited = Double.parseDouble(test);

                                        blockResult.setPass_amount(amount_debited);
                                        blockResult.setPass_status(dbt7[3]);

                                        if (mode_of_trans.isEmpty()) {

                                            mode_of_trans = dbt7[0];
                                        }

                                        blockResult.setAmount_int_status(1);
                                    } catch (Exception e) {
                                        amount_debited = 0.0;
                                    }





                                }
                            }

                        } catch (Exception ee) {
                            logger.warning(ee.getMessage());
                        }

                    }



                    if ((!accountNODigitsOnly.isEmpty() || !cardNODigitsOnly.isEmpty()) && !where_at.isEmpty() && (blockResult.getPass_amount() <= 0)) {


                        Matcher matcherAmount66 = Pattern.compile("(?i)((" + wat4[23] + " (" + trx5[19] + "|" + wat4[36] + ")).*?(\\W|^)(" + trx5[13] + "|" + trx5[14] + ")([[" + account_1[15] + "]]+|\\s*)\\s*[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| )|(" + trx5[13] + "|" + trx5[14] + ")([[" + account_1[15] + "]]+|\\s*)\\s*[" + account_1[13] + "].*?(" + wat4[23] + " (" + trx5[19] + "|" + wat4[36] + ")))").matcher(myIncomingText);

                        if (matcherAmount66.find()) {
                            String test = "0";
                            String amountText = matcherAmount66.group();

                            boolean isEMITransaction = false;

                            try {
                                //For EMI option

                                Matcher matcherEMIOption = Pattern.compile("(?i)" + wat4[23] + " (" + trx5[19] + "|" + wat4[36] + ")\\s" + account_1[25] + "").matcher(amountText);

                                if (matcherEMIOption.find() && lower_case_sms.contains(CASE15[119])){
                                    amountText = "";
                                    test = "";
                                    isEMITransaction = true;
                                }


                            }catch (Exception exception){
                                logger.warning(exception.getMessage());
                            }

                            if (!isEMITransaction) {

                                Matcher match3 = Pattern.compile("(?i)(" + trx5[13] + "|" + trx5[14] + ")\\s*([[" + account_1[15] + "]]+|\\s*)\\s*[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| )").matcher(amountText);


                                while (match3.find()) {

                                    test = match3.group();
                                    Matcher match33 = Pattern.compile("(?i)((" + trx5[13] + "|" + trx5[14] + ")\\.|[" + account_1[19] + "]|(?!\\.)[\\W])").matcher(test);

                                    while (match33.find()) {
                                        try {
                                            test = test.replace(match33.group(), "").trim();
                                        } catch (Exception e) {
                                            logger.warning(e.getMessage());

                                        }
                                        if (test.endsWith(".")) {
                                            test = test.substring(0, test.length() - 1);
                                        }
                                    }
                                }


                                try {
                                    amount_debited = Double.parseDouble(test);
                                } catch (Exception e) {
                                    amount_debited = 0.000;
                                }

                                blockResult.setPass_amount(amount_debited);
                                blockResult.setPass_status(dbt7[3]);

                                if (mode_of_trans.isEmpty()) {

                                    mode_of_trans = dbt7[0];
                                }

                                blockResult.setAmount_int_status(1);
                            }

                        }

                    }


                    if (!cardNODigitsOnly.isEmpty() && blockResult.getPass_amount() <= 0) {

                        try {
                            //indulsand bank Mr. Rasu SMS
                            Matcher matcherAmount = Pattern.compile("(?i)(" + trx5[0] + "|" + trx5[1] + "|" + trx5[2] + "|" + trx5[3] + "|" + trx5[4] + "|" + trx5[5] + ").*?(\\W|^)(" + trx5[13] + "|" + trx5[14] + ")(\\W+|)\\s*([" + account_1[13] + "].*?)( |[a-z]).*?( " + CASE15[12] + "| " + CASE15[26] + ")").matcher(myIncomingText);

                            if (matcherAmount.find()) {

                                String amount = matcherAmount.group(5).trim();

                                try {
                                    amount_debited = Double.parseDouble(amount);
                                } catch (Exception e) {
                                    amount_debited = 0.000;
                                }


                                blockResult.setPass_amount(amount_debited);
                                blockResult.setPass_status(dbt7[3]);

                                if (mode_of_trans.isEmpty()) {

                                    mode_of_trans = dbt7[0];
                                }

                                blockResult.setAmount_int_status(1);


                            }


                        } catch (Exception e) {
                            logger.warning(e.getMessage());

                        }


                    }

                    try {

                        if (blockResult.getPass_amount() <= 0 && blockResult.getPass_card_type().equals(card_2[7])) {

                            Matcher matcherAmount = Pattern.compile("(?i)(\\W|^)(" + trx5[13] + "|" + trx5[14] + ")(\\W+|)([0-9,\\.]+)\\s" + crd6[4] + "((\\W|\\w){0,30})").matcher(myIncomingText);

                            if (matcherAmount.find()) {

                                String value_rec = matcherAmount.group(4).trim();
                                String value_for = matcherAmount.group(5).toLowerCase();

                                if (value_for.contains(" " + wat4[23])) {

                                    value_rec = value_rec.replaceAll("(?i)\\,", "");


                                    try {
                                        amount_credited = Double.parseDouble(value_rec);

                                        blockResult.setPass_amount(amount_credited);
                                        blockResult.setPass_status(crd6[0]);

                                        if (mode_of_trans.isEmpty()) {

                                            mode_of_trans = crd6[6];
                                        }

                                        blockResult.setAmount_int_status(2);
                                    } catch (Exception e) {
                                        //  amount_credited = 0.0;
                                    }


                                }


                            }


                        }

                    } catch (Exception e) {
                        logger.warning(e.getMessage());
                    }



                    try {

                        //Federal bank Hardcoded case like received inr 111.3 in your acc xxx123 and date

                        if (blockResult.getPass_amount() <= 0 && checkIfBankID.equals("1")) {

                            Matcher matcherAmount = Pattern.compile("(?i)"+crd6[4]+"d\\s("+trx5[13]+"|"+trx5[14]+")(\\W+|)([0-9,.]+)\\s"+wat4[3]+"\\s"+wat4[28]+"\\s((\\w|\\W){3,10})\\sx{1,}[0-9]{3,}").matcher(complete_SMS);

                            if (matcherAmount.find()) {

                                String date_pre = commonLogicFunction.getReplaceDateText(context, complete_SMS);

                                if (!date_pre.equals("~")) {
                                    String amount = matcherAmount.group(3).trim();

                                    amount = amount.replaceAll("(?i)\\,", "");


                                    try {
                                        amount_credited = Double.parseDouble(amount);

                                        //Log.d("ATTTQQQ","2-- "+complete_SMS);

                                        blockResult.setPass_amount(amount_credited);
                                        blockResult.setPass_status(crd6[0]);

                                        if (mode_of_trans.isEmpty()) {

                                            mode_of_trans = crd6[6];
                                        }
                                        blockResult.setAmount_int_status(2);
                                    } catch (Exception e) {
                                        //  amount_credited = 0.0;
                                        //Log.d("ATTTQQQ","crash2-- "+complete_SMS +" --");
                                    }
                                }

                            }


                        }

                    } catch (Exception e) {
                        logger.warning(e.getMessage());
                    }


                    try {

                        //Txn Rs.70.00

                        if (blockResult.getPass_amount() <= 0 && checkIfBankID.equals("1") && changeSender.contains(""+extra10[94]+"")) {

                            try {
                                Matcher matcherAmount = Pattern.compile("^(?i)(" + trx5[0] + "|" + trx5[1] + "|" + trx5[2] + "|" + trx5[3] + "|" + trx5[4] + "|" + trx5[5] + "|" + trx5[20] + ")\\W+(" + trx5[13] + "|" + trx5[14] + ")(\\W+|)([0-9\\,\\.]+)\\W").matcher(complete_SMS);

                                if (matcherAmount.find()) {

                                    String amountFrom = matcherAmount.group(4);
                                    amountFrom = amountFrom.replaceAll(",", "");

                                    try {
                                        amount_debited = Double.parseDouble(amountFrom);
                                    } catch (Exception e) {
                                        amount_debited = 0.000;
                                    }

                                    blockResult.setPass_amount(amount_debited);
                                    blockResult.setPass_status(dbt7[3]);

                                    if (mode_of_trans.isEmpty()) {

                                        mode_of_trans = dbt7[0];
                                    }

                                    blockResult.setAmount_int_status(1);
                                }
                            } catch (Exception e) {
                                logger.warning(e.getMessage());
                            }


                            try {

                                // Sent Rs25.00
                                if (blockResult.getPass_amount() <= 0) {
                                    Matcher matcherAmount = Pattern.compile("^(?i)("+CASE15[84]+"\\s*|)(" + CASE15[59] + ")\\W+(" + trx5[13] + "|" + trx5[14] + ")(\\W+|)([0-9\\,\\.]+)\\W").matcher(complete_SMS);

                                    if (matcherAmount.find()) {

                                        String amountFrom = matcherAmount.group(5);
                                        amountFrom = amountFrom.replaceAll(",", "");

                                        try {
                                            amount_debited = Double.parseDouble(amountFrom);
                                        } catch (Exception e) {
                                            amount_debited = 0.000;
                                        }

                                        blockResult.setPass_amount(amount_debited);
                                        blockResult.setPass_status(dbt7[3]);

                                        if (mode_of_trans.isEmpty()) {

                                            mode_of_trans = dbt7[0];
                                        }

                                        blockResult.setAmount_int_status(1);
                                    }
                                }

                            } catch (Exception e) {
                                logger.warning(e.getMessage());
                            }

                        }


                        //SBI income tax message
                        if (changeSender.contains(""+extra10[89]+"")){

                            //Matcher matcherIncomeTax = Pattern.compile("(?i)\\W"+extra10[78]+"\\W["+account_1[19]+"]([a-zA-Z0-9]{7})[0-9]["+account_1[19]+"]").matcher(incomingSms);
                            Matcher matcherIncomeTax = Pattern.compile("(?i)\\W"+extra10[78]+"\\W").matcher(incomingSms);

                            if (matcherIncomeTax.find()){

                                Matcher matcherIncomeTaxReturn = Pattern.compile("(?i)(\\W"+extra10[85]+"\\W|"+extra10[86]+"|"+extra10[87]+")\\s*"+extra10[35]+"").matcher(incomingSms);
                                Matcher matcherItrRegistered = Pattern.compile("(?i)("+extra10[90]+")\\s*"+extra10[91]+"").matcher(incomingSms);

                                if ((matcherIncomeTaxReturn.find() || matcherItrRegistered.find() )&& incomingSms.contains(""+extra10[88]+"") && blockResult.getAmount_int_status() == 2){

                                    blockResult = new BlockResult();
                                    accountNODigitsOnly = "";
                                    cardNODigitsOnly = "";
                                    accountNO = "";
                                    cardNO = "";

                                }

                            }

                        }

                    } catch (Exception e) {
                        logger.warning(e.getMessage());
                    }





                    if (mode_of_trans.toLowerCase().equals(wat4[11])) {

                        Matcher match24523 = Pattern.compile("(?i)(" + wat4[31] + "|" + wat4[32] + ")").matcher(msg_text);

                        if (match24523.find() && blockResult.getPass_amount() > 24000) {

                            where_at = wat4[13].toUpperCase();


                        }


                    }

                    if (where_at.equalsIgnoreCase(wat4[9])){

                        Matcher matcherTXN = Pattern.compile("(?i)(?<!"+CASE15[120]+")\\s"+wat4[9]+"").matcher(where_at);
                        if (matcherTXN.find()) {

                            check_for_more = true;
                        }else {
                            where_at = "";
                        }
                    }


                    try {


                        Matcher match277TPT = Pattern.compile("((?i)(\\W" + wat4[23] + "|" + wat4[24] + ":)(\\W+|)((?!" + wat4[25] + "|" + wat4[26] + "|" + wat4[27] + "|" + wat4[28] + "|" + wat4[48] + "|" + wat4[15] + "|" + wat4[16] + ")))[[:upper:]].*?(TPT)\\W(\\w+(.*?)[[:upper:]].*?)(\\.|$|-)").matcher(msg_text);


                        if (match277TPT.find()) {
                            where_at = match277TPT.group(6).trim();
                            //where_at = where_at.replaceAll("(?i)Trans-", "Transfer-");
                            where_at = where_at.replaceAll("(?i)"+trx5[4]+"-", CASE15[56]+"-");
                            where_at = where_at.replaceAll("D-", "").trim();

                            check_for_more = false;
                        }


                    }catch (Exception e){
                        logger.warning(e.getMessage());
                    }

                    /*if (where_at.isEmpty()){
                        check_for_more = true;
                    }*/

                    if (where_at.isEmpty() && blockResult.getAmount_int_status() == 2){
                        check_for_more = true;
                    }


                    if (check_for_more) {

                        boolean upiMerchantCheck = false;


                        if (mode_of_trans.equalsIgnoreCase(wat4[37]) || mode_of_trans.equalsIgnoreCase(wat4[38])) {

                            try {


                                Matcher matcherVPA = Pattern.compile("((?i)(\\W|\\w){0,15})\\W" + wat4[38].toUpperCase() + "\\W").matcher(msg_text);



                                while (matcherVPA.find()) {

                                    boolean dontCheckMore = false;
                                    String checkTextForVPA= msg_text;


                                    String group1 = matcherVPA.group(1);

                                    if (group1.toLowerCase().contains("" + wat4[28] + "")) {

                                        dontCheckMore = false;
                                        continue;
                                    } else if (group1.matches(".*\\W" + wat4[40] + ".*")) {

                                        dontCheckMore = true;

                                        int startIndex = matcherVPA.start();

                                        checkTextForVPA =checkTextForVPA.substring(startIndex);

                                    } else {

                                        //dontCheckMore = true;

                                        int startIndex = matcherVPA.start();

                                        checkTextForVPA =checkTextForVPA.substring(startIndex);

                                    }


                                    Matcher matcherVPA2 = Pattern.compile("(?i)\\W" + wat4[38] + "\\W+([" + account_1[19] + "0-9.-]+)(@[" + account_1[19] + "]+)").matcher(checkTextForVPA);

                                    if (matcherVPA2.find()) {

                                        where_at = matcherVPA2.group(1);
                                        where_at = where_at.replaceAll("-[0-9]+$", "");

                                        if (TextUtils.isDigitsOnly(where_at.trim())) {

                                            //where_at = wat4[41] + " - "+where_at;




                                        } else {
                                            where_at = where_at.replaceAll("__+", "");
                                            where_at = where_at.replaceAll("-+", " ");
                                            where_at = where_at.replaceAll("\\.", " ");
                                            where_at = where_at.replaceAll("\\s\\s+", " ");


                                            Matcher matcherQ = Pattern.compile("(?i)q[0-9]+").matcher(where_at);

                                            if (matcherQ.find()) {
                                                where_at = wat4[46]+" " + where_at;
                                            } else {
                                                //where_at = where_at.replaceAll("[0-9]+", "");
                                                String tempWhere = where_at;
                                                where_at = where_at.replaceAll("[0-9]+", "");

                                                if (tempWhere.length() - where_at.length() > 10){
                                                    where_at = wat4[46]+" "+wat4[63];
                                                }
                                            }

                                            if (where_at.toLowerCase().contains(wat4[42])) {

                                                String tempWhere = where_at.replaceAll("(?i)"+wat4[42],"");

                                                if (tempWhere.length() > 5){
                                                    where_at = tempWhere;
                                                }else {
                                                    where_at = wat4[43];
                                                }
                                            }

                                        }
                                        upiMerchantCheck = true;

                                    } else {

                                        String getStringForUpiId = frameworkWords.getStringForUpiId();

                                        Matcher matcherVPA3 = Pattern.compile("(?i)\\W" + wat4[38] + "\\W+([" + account_1[19] + "0-9.-]+)(" + getStringForUpiId + ")\\W").matcher(withOutUrlSMS);

                                        if (matcherVPA3.find()) {

                                            where_at = matcherVPA3.group(1);
                                            where_at = where_at.replaceAll("__+", "");
                                            //where_at = where_at.replaceAll("[0-9]+", "");
                                            where_at = where_at.replaceAll("-+", " ");
                                            where_at = where_at.replaceAll("\\.", " ");
                                            where_at = where_at.replaceAll("\\s\\s+", " ");

                                            Matcher matcherQ = Pattern.compile("(?i)q[0-9]+").matcher(where_at);

                                            if (matcherQ.find()) {
                                                where_at = wat4[46]+" " + where_at;
                                            } else {
                                                //where_at = where_at.replaceAll("[0-9]+", "");
                                                String tempWhere = where_at;
                                                where_at = where_at.replaceAll("[0-9]+", "");

                                                if (tempWhere.length() - where_at.length() > 10){
                                                    where_at = wat4[46]+" "+wat4[63];
                                                }
                                            }

                                            upiMerchantCheck = true;

                                        }


                                    }


                                    if (dontCheckMore) {
                                        break;
                                    }


                                }


                                if (where_at.isEmpty() || !upiMerchantCheck){

                                    String getStringForUpiId = frameworkWords.getStringForUpiId();
                                    Matcher matcherVPA2 = Pattern.compile("(?i)\\W([" + account_1[19] + "0-9.-]+)[@_](" + getStringForUpiId + ")\\W").matcher(withOutUrlSMS);

                                    if (matcherVPA2.find()) {

                                        String tempGroup = matcherVPA2.group(1);

                                        if (!tempGroup.toLowerCase().contains("xxx")){
                                            where_at = matcherVPA2.group(1);
                                        }

                                        if (where_at.matches(".*[a-zA-Z].*")) {


                                            where_at = where_at.replaceAll("__+", "");
                                            where_at = where_at.replaceAll("-+", " ");
                                            //where_at = where_at.replaceAll("[0-9]+", "");
                                            where_at = where_at.replaceAll("\\.", " ");
                                            where_at = where_at.replaceAll("\\s\\s+", " ");


                                            Matcher matcherQ = Pattern.compile("(?i)q[0-9]+").matcher(where_at);

                                            if (matcherQ.find()) {
                                                where_at = wat4[46]+" " + where_at;
                                            } else {
                                                String tempWhere = where_at;
                                                where_at = where_at.replaceAll("[0-9]+", "");

                                                if (tempWhere.length() - where_at.length() > 10){
                                                    where_at = wat4[46]+" "+wat4[63];
                                                }
                                            }

                                            if (where_at.toLowerCase().contains(wat4[42])) {

                                                String tempWhere = where_at.replaceAll("(?i)"+wat4[42],"");

                                                if (tempWhere.length() > 5){
                                                    where_at = tempWhere;
                                                }else {
                                                    where_at = wat4[43];
                                                }


                                            }

                                        }else {

                                            Matcher matcherUpiMobile = Pattern.compile("(?i)([0-9]{10}(-\\d+|))([@_][" + account_1[19] + "]+)").matcher(withOutUrlSMS);

                                            if (matcherUpiMobile.find()){

                                                String numberArray = matcherUpiMobile.group(1);
                                                numberArray =  numberArray.replaceAll("-\\d+","");

                                                //where_at = wat4[41] + " - "+numberArray;




                                            }

                                        }
                                        upiMerchantCheck = true;
                                    }else {

                                        if (incomingSender.contains("BOB")) {
                                            Matcher matcherUpiBob = Pattern.compile("(?i)\\W" + wat4[0] + "\\W(" + wat4[37] + "|)(\\W|)([a-zA-Z0-9]+)\\W([a-zA-Z0-9]+).*?(\\W" + wat4[39] + "|)").matcher(withOutUrlSMS);

                                            if (matcherUpiBob.find()) {
                                                String group4 = matcherUpiBob.group(4).trim();

                                                if (group4.equalsIgnoreCase(wat4[39])) {

                                                    group4 = "";
                                                }

                                                where_at = matcherUpiBob.group(3) + " " + group4;
                                                upiMerchantCheck = true;
                                            }else {

                                                try {

                                                    Matcher matcherOk = Pattern.compile("(?i)" + wat4[34] + "\\s([" + account_1[19] + "0-9.-]+)[@_][" + account_1[19] + "]+\\W").matcher(withOutUrlSMS);

                                                    if (matcherOk.find()){

                                                        where_at = matcherOk.group(1);

                                                        if (TextUtils.isDigitsOnly(where_at.trim())) {

                                                            //where_at = wat4[41] + " - "+where_at;



                                                        } else {
                                                            where_at = where_at.replaceAll("__+", "");
                                                            where_at = where_at.replaceAll("-+", " ");
                                                            where_at = where_at.replaceAll("\\.", " ");
                                                            where_at = where_at.replaceAll("\\s\\s+", " ");


                                                            Matcher matcherQ = Pattern.compile("(?i)q[0-9]+").matcher(where_at);

                                                            if (matcherQ.find()) {
                                                                where_at = wat4[46]+" " + where_at;
                                                            } else {
                                                                //where_at = where_at.replaceAll("[0-9]+", "");
                                                                String tempWhere = where_at;
                                                                where_at = where_at.replaceAll("[0-9]+", "");

                                                                if (tempWhere.length() - where_at.length() > 10){
                                                                    where_at = wat4[46]+" "+wat4[63];
                                                                }
                                                            }

                                                            if (where_at.toLowerCase().contains(wat4[42])) {

                                                                String tempWhere = where_at.replaceAll("(?i)"+wat4[42],"");

                                                                if (tempWhere.length() > 5){
                                                                    where_at = tempWhere;
                                                                }else {
                                                                    where_at = wat4[43];
                                                                }
                                                            }

                                                        }
                                                        upiMerchantCheck = true;

                                                    }



                                                }catch (Exception e){
                                                    logger.warning(e.getMessage());
                                                }


                                            }

                                        }else {

                                            Matcher matcherUpiMobile = Pattern.compile("(?i)([0-9]{10}(-\\d+|))([@_][" + account_1[19] + "]+)").matcher(withOutUrlSMS);

                                            if (matcherUpiMobile.find()){

                                                String numberArray = matcherUpiMobile.group(1);
                                                numberArray =  numberArray.replaceAll("-\\d+","");

                                                //where_at = wat4[41] + " - "+numberArray;




                                            }



                                        }

                                    }

                                }

                                if (where_at.isEmpty()){

                                    // Hardcoded for Yes Bank UPI
                                    try {
                                        Matcher matcherYesBankUPI = Pattern.compile("(?i)\\W\\@"+wat4[37]+"\\_(.*?)(\\s\\W|\\W\\s|[0-9]{2})").matcher(withOutUrlSMS);

                                        if (matcherYesBankUPI.find()){

                                            String group1 = matcherYesBankUPI.group(1);

                                            where_at = group1;
                                            upiMerchantCheck = true;
                                        }

                                    }catch (Exception e){
                                        logger.warning(e.getMessage());
                                    }





                                }

                                if (where_at.isEmpty()) {

                                    // Hardcoded for BOB UPI
                                    try {
                                        Matcher matcherBOBUPI = Pattern.compile("(?i)\\W" + wat4[37] + "\\/(.*?)(\\.|,|-|:|\\_|(?i)(" + wat4[9] + "|" + trx5[4] + "|\\W"+wat4[34]+")|$)").matcher(withOutUrlSMS);

                                        if (matcherBOBUPI.find()) {

                                            String group1 = matcherBOBUPI.group(1);
                                            where_at = group1;

                                            Matcher matcherRemoveNumber = Pattern.compile("^[0-9]+\\s").matcher(group1);

                                            if (matcherRemoveNumber.find()){

                                                where_at = where_at.replace(matcherRemoveNumber.group(),"");
                                            }


                                            upiMerchantCheck = true;
                                        }

                                    } catch (Exception e) {
                                        logger.warning(e.getMessage());
                                    }


                                }

                                if (where_at.isEmpty()) {

                                    // Hardcoded for Axis Bank UPI
                                    try {
                                        Matcher matcherAxisBankUPI = Pattern.compile("(?i)\\W" + wat4[37] + "\\/(.*?)(\\.|,|-|:|\\_|(?i)(" + wat4[9] + "|" + trx5[4] + "|\\W"+wat4[34]+")|$)").matcher(withOutUrlSMS);

                                        if (matcherAxisBankUPI.find()) {

                                            String group1 = matcherAxisBankUPI.group(1);

                                            where_at = group1;
                                            upiMerchantCheck = true;
                                        }

                                    } catch (Exception e) {
                                        logger.warning(e.getMessage());
                                    }


                                }



                                /*if (where_at.isEmpty()){

                                    Matcher matcherUPiBobDigit = Pattern.compile("(?i)\\W" + wat4[37] + "\\W+([0-9]+)").matcher(msg_text);

                                    if (matcherUPiBobDigit.find()){
                                        where_at = wat4[41] +" - "+matcherUPiBobDigit.group(1);
                                        upiMerchantCheck = true;
                                    }

                                }*/

                            } catch (Exception e) {
                                logger.warning(e.getMessage());
                            }



                            try {
                                //HardCoded Case for ICICI UPI -456858- Anand
                                if (!upiMerchantCheck){

                                    Matcher matcherICICIBankUPI = Pattern.compile("\\W"+wat4[37].toUpperCase()+"[-\\/][0-9]{11,}[-\\/](.*?)\\.").matcher(incomingSms);

                                    if (matcherICICIBankUPI.find()) {

                                        String group1 = matcherICICIBankUPI.group(1);
                                        where_at = group1;
                                        upiMerchantCheck = true;
                                    }
                                }



                            }catch (Exception er){
                                logger.warning(er.getMessage());
                            }


                        }


                        if (!upiMerchantCheck && iGEtSTAT !=4) {

                            if (blockResult.getPass_status().equals(dbt7[3])) {
//removed '-'
                                Matcher match2 = Pattern.compile("((?i)\\W(" + wat4[40] + "|" + wat4[1] + "))(\\W+|)(((?i)(?!" + wat4[25] + "|" + wat4[26] + "|" + wat4[27] + "|" + wat4[28] + "|" + wat4[48] + "|" + wat4[15] + "))("+account_1[2]+"\\W+|)[[:upper:]])(\\s|)([" + account_1[19] + "]|\\+|-|\\/).*?(\\.|,|:|(?i)\\W(" + wat4[39] + "|" + wat4[35] + "|" +extra10[10] + "|" +extra10[12] + "|" +extra10[5] + "\\W)|\\W" + CASE15[83] + "|$)").matcher(msg_text);

                                if (match2.find()) {
                                    where_at = match2.group();
                                    where_at = where_at.replaceFirst("(?i)a\\/c","");
                                    where_at = where_at.replaceFirst("(?i)\\W" + wat4[32], "");
                                    where_at = where_at.replaceFirst("\\W" + wat4[1]+"(\\W+|)", "");
                                    where_at = where_at.replaceFirst("(?i)("+account_1[2]+"\\W+|)", "");
                                    where_at = where_at.replaceFirst("(?i)\\W" + wat4[40]+"(\\W+|)", "");
                                    where_at = where_at.replaceFirst("(?i)\\W" + CASE15[83], "");
                                    where_at = where_at.replace(mode_of_trans, "");
                                    where_at = where_at.replaceAll("(\\.|,|-|:|(?i)\\W(" + wat4[39] + "|" + wat4[35] + "|" +extra10[10] + "|" +extra10[12] + "|" +extra10[5] + "\\W))", "").trim();
                                    //where_at = mode_of_trans.trim() + " " + where_at;
                                    where_at = where_at.replaceAll("__+", "");
                                    where_at = where_at.replace("/", " ");
                                    where_at = where_at.replaceAll("\\s\\s+", " ");

                                    if (where_at.endsWith(".") || where_at.endsWith("(")) {

                                        where_at = where_at.substring(0, where_at.length() - 1).trim();
                                    }

                                    try {
                                        if (TextUtils.isDigitsOnly(where_at)){

                                            if (match2.group().matches(".*(?i)a\\/c.*?"+where_at+".*")){
                                                where_at = account_1[3]+" "+where_at;
                                            }else {
                                                where_at = mode_of_trans;
                                            }
                                        }
                                    }catch (Exception e){
                                        logger.warning(e.getMessage());
                                    }


                                }else {


                                    Matcher match277 = Pattern.compile("((?i)(\\W" + wat4[23] + "|" + wat4[24] + ":)(\\W+|)((?!" + wat4[25] + "|" + wat4[26] + "|" + wat4[27] + "|" + wat4[28] + "|"+wat4[48]+"|" + wat4[15] + "|" + wat4[16] + ")))[[:upper:]].*?(\\.|,|-|:|(?i)(" + wat4[9] + "|" + trx5[4] + "))").matcher(msg_text);

                                    if (match277.find()) {
                                        where_at = match277.group().trim();
                                        where_at = where_at.replaceFirst("(?i)\\W"+wat4[23]+"(\\W+|)", "");
                                        where_at = where_at.replace(wat4[29], "");
                                        where_at = where_at.replaceAll("(?i)" + wat4[24] + "(\\W+|)", "");
                                        where_at = where_at.replaceAll("(,|-|" + wat4[9] + ")", "");
                                        where_at = where_at.replaceAll("__+", "");
                                        where_at = where_at.replaceAll("\\s\\s+", " ");

                                        if (where_at.endsWith(".")) {

                                            where_at = where_at.substring(0, where_at.length() - 1);
                                        }

                                    }else {


                                        Matcher matcherTransferredTo = Pattern.compile("(?i)\\W" + wat4[44] + "\\W(" + wat4[40] + "|)(\\W|)([a-zA-Z0-9]+)\\W([a-zA-Z0-9]+).*?(\\W" + wat4[39] + "|)").matcher(incomingSms);

                                        if (matcherTransferredTo.find()){
                                            String group4 = matcherTransferredTo.group(4).trim();

                                            if (group4.length() > 4 ) {
                                                where_at = matcherTransferredTo.group(3) + " " + group4;
                                            }

                                        }
                                    }
                                }


                            } else {


                                Matcher match2 = Pattern.compile("((?i)\\W(" + wat4[34] + "|" + wat4[35] + "))\\W+(((?i)(?!" + wat4[25] + "|" + wat4[26] + "|" + wat4[27] + "|" + wat4[28] + "|"+wat4[48]+"|" + wat4[15] + "))[[:upper:]])(\\s|)([" + account_1[19] + "]|\\+|-).*?(\\.|,|:|(?i)\\W" + wat4[39] + "|(?i)\\W"+extra10[12]+"|(?i)\\W("+extra10[7]+"|"+extra10[9]+")\\W|"+CASE15[112]+"|-|$)").matcher(msg_text);
                                if (match2.find()) {
                                    where_at = match2.group();
                                    where_at = where_at.replaceFirst("(?i)\\W" + wat4[34], "");
                                    where_at = where_at.replaceFirst("(?i)\\W" + wat4[35], "");
                                    where_at = where_at.replaceFirst("(?i)\\W" + extra10[12], "");
                                    where_at = where_at.replaceFirst("(?i)\\W" + extra10[7]+"\\W", "");
                                    where_at = where_at.replaceFirst("(?i)\\W" + extra10[9]+"\\W", "");
                                    where_at = where_at.replaceFirst("(?i)\\W"+CASE15[112]+"", "");
                                    //where_at = where_at.replace(mode_of_trans, "");
                                    where_at = where_at.replaceAll("(\\.|,|-|:|(?i)\\W" + wat4[39] + ")", "").trim();
                                    //  where_at = mode_of_trans.trim() + " " + where_at;
                                    where_at = where_at.replaceAll("__+", "");
                                    where_at = where_at.replaceAll("\\s\\s+", " ");

                                    if (where_at.endsWith(".")) {

                                        where_at = where_at.substring(0, where_at.length() - 1);
                                    }

                                }else {

                                    Matcher match277 = Pattern.compile("((?i)(\\W" + wat4[23] + "|" + wat4[24] + ":)(\\W+|)((?!" + wat4[25] + "|" + wat4[26] + "|" + wat4[27] + "|" + wat4[28] + "|"+wat4[48]+"|" + wat4[15] + "|" + wat4[16] + ")))[[:upper:]].*?(\\.|,|-|:|(?i)(" + wat4[9] + "|" + trx5[4] + ")|$)").matcher(msg_text);

                                    if (match277.find()) {
                                        where_at = match277.group().trim();
                                        where_at = where_at.replaceFirst("(?i)\\W"+wat4[23]+"(\\W+|)", "");
                                        where_at = where_at.replace(wat4[29], "");
                                        where_at = where_at.replaceAll("(?i)" + wat4[24] + "(\\W+|)", "");
                                        where_at = where_at.replaceAll("(,|-|" + wat4[9] + ")", "");
                                        where_at = where_at.replaceAll("__+", "");
                                        where_at = where_at.replaceAll("\\s\\s+", " ");

                                        if (where_at.endsWith(".")) {

                                            where_at = where_at.substring(0, where_at.length() - 1);
                                        }

                                    }else {

                                        //Via Auto Debit

                                        Matcher matcherAutoDebit = Pattern.compile("(?i)"+trx5[18]+"\\W+"+CASE15[60]+"(\\W+|)"+CASE15[35]+"").matcher(withOutUrlSMS);

                                        if (matcherAutoDebit.find()){
                                            where_at = CASE15[60]+" "+CASE15[35];
                                        }



                                    }


                                }

                            }

                        }else if (iGEtSTAT == 4){

                            //if (iGEtSTAT == 4){

                                Matcher matcherUpiBob = Pattern.compile("(?i)\\W" + wat4[0] + "\\W(" + wat4[37] + "|)(\\W|)([a-zA-Z0-9]+)\\W+([a-zA-Z0-9]+).*?(\\W" + wat4[39] + "|)").matcher(withOutUrlSMS);

                                if (matcherUpiBob.find()){
                                    String group4 = matcherUpiBob.group(4).trim();

                                    if (group4.equalsIgnoreCase(wat4[39])){

                                        group4 = "";
                                    }

                                    where_at = matcherUpiBob.group(3) + " "+group4;

                                }else if (blockResult.getPass_status().equals(dbt7[3]) && !upiMerchantCheck) {

                                    Matcher match2 = Pattern.compile("((?i)\\W(" + wat4[40] + "|" + wat4[1] + "))(\\W+|)(((?i)(?!" + wat4[25] + "|" + wat4[26] + "|" + wat4[27] + "|" + wat4[28] + "|" + wat4[48] + "|" + wat4[15] + "))("+account_1[2]+"\\W+|)[[:upper:]])(\\s|)([" + account_1[19] + "]|\\+|-).*?(\\.|,|:|(?i)\\W(" + wat4[39] + "|" + wat4[35] + "|" +extra10[10] + "|" +extra10[12] + ")|\\W" + CASE15[83] + "|-|$)").matcher(msg_text);
                                    if (match2.find()) {
                                        where_at = match2.group();
                                        where_at = where_at.replaceFirst("(?i)\\W" + wat4[32], "");
                                        where_at = where_at.replaceFirst("(?i)("+account_1[2]+"\\W+|)", "");
                                        where_at = where_at.replaceFirst("\\W" + wat4[1]+"(\\W+|)", "");
                                        where_at = where_at.replaceFirst("(?i)\\W" + wat4[40]+"(\\W+|)", "");
                                        where_at = where_at.replaceFirst("(?i)\\W" + CASE15[83], "");
                                        where_at = where_at.replace(mode_of_trans, "");
                                        //where_at = where_at.replaceAll("(\\.|,|-|:|(?i)\\W" + wat4[39] + ")", "").trim();
                                        where_at = where_at.replaceAll("(\\.|,|-|:|(?i)\\W(" + wat4[39] + "|" + wat4[35] + "|" +extra10[10] + "|" +extra10[12] + "))", "").trim();

                                        //where_at = mode_of_trans.trim() + " " + where_at;
                                        where_at = where_at.replaceAll("__+", "");
                                        where_at = where_at.replace("/", "");
                                        where_at = where_at.replaceAll("\\s\\s+", " ");

                                        if (where_at.endsWith(".")) {

                                            where_at = where_at.substring(0, where_at.length() - 1);
                                        }

                                        try {
                                            if (TextUtils.isDigitsOnly(where_at)){

                                                where_at = mode_of_trans;
                                            }
                                        }catch (Exception e){
                                            logger.warning(e.getMessage());
                                        }

                                    }else {

                                        Matcher match277 = Pattern.compile("((?i)(\\W" + wat4[23] + "|" + wat4[24] + ":)(\\W+|)((?!" + wat4[25] + "|" + wat4[26] + "|" + wat4[27] + "|" + wat4[28] + "|" + wat4[48] + "|" + wat4[15] + "|" + wat4[16] + ")))[[:upper:]].*?(\\.|,|-|:|(?i)(" + wat4[9] + "|" + trx5[4] + "))").matcher(msg_text);
                                        if (match277.find()) {
                                            where_at = match277.group().trim();
                                            where_at = where_at.replaceFirst("(?i)\\W"+wat4[23]+"(\\W+|)", "");
                                            where_at = where_at.replace(wat4[29], "");
                                            where_at = where_at.replaceAll("(?i)" + wat4[24] + "(\\W+|)", "");
                                            where_at = where_at.replaceAll("(,|-|" + wat4[9] + ")", "");
                                            where_at = where_at.replaceAll("__+", "");
                                            where_at = where_at.replaceAll("\\s\\s+", " ");

                                            if (where_at.endsWith(".")) {
                                                where_at = where_at.substring(0, where_at.length() - 1);
                                            }

                                        }else {

                                            Matcher matcherTransferredTo = Pattern.compile("(?i)\\W" + wat4[44] + "\\W(" + wat4[40] + "|)(\\W|)([a-zA-Z0-9]+)\\W([a-zA-Z0-9]+).*?(\\W" + wat4[39] + "|)").matcher(incomingSms);
                                            if (matcherTransferredTo.find()){
                                                String group4 = matcherTransferredTo.group(4).trim();
                                                if (group4.length() > 4 ) {
                                                    where_at = matcherTransferredTo.group(3) + " " + group4;
                                                }
                                            }
                                        }
                                    }

                                }
                            //}

                        }

                    }

                    // Yes Bank

                    if (where_at.isEmpty()){
                        // Hardcoded for Yes Bank UPI
                        try {
                            Matcher matcherYesBankUPI = Pattern.compile("(?i)[0-9]{2}\\W\\@(.*?)(\\s[0-9])").matcher(withOutUrlSMS);
                            if (matcherYesBankUPI.find()){
                                where_at = matcherYesBankUPI.group(1);
                            }

                        }catch (Exception e){
                            logger.warning(e.getMessage());
                        }
                    }

                    //BOB

                    if (where_at.isEmpty()){

                        if (blockResult.getPass_status().equals(dbt7[3])) {
//removed '-'
                            Matcher match2 = Pattern.compile("(?i)\\W"+wat4[40]+"\\:([0-9]+)(\\W|\\$|\\w)").matcher(msg_text);

                            if (match2.find()) {
                                where_at = match2.group(1);

                            }
                        }
                    }

                    try {
                        Matcher matcherBOI = Pattern.compile("(?i)\\W(" + wat4[34] + "|" + wat4[35] + ")\\W+" + wat4[14] + "\\W+(.*?)\\s").matcher(withOutUrlSMS);

                        if (matcherBOI.find()){
                            String group2 = matcherBOI.group(2);
                            where_at = group2;
                        }

                    }catch (Exception e){
                        logger.warning(e.getMessage());
                    }

                    try {

                        if (where_at.isEmpty() || where_at.toLowerCase().equals(wat4[15])){

                            Matcher matcherUnionBank = Pattern.compile("(?i)\\W+(" + wat4[60] + "|" + CASE15[56] + ")\\:+(.*?)(\\:|\\W" + wat4[39] + "\\W)").matcher(withOutUrlSMS);

                            if (matcherUnionBank.find()){
                                String group2 = matcherUnionBank.group(2);
                                where_at = group2;
                            }else {

                                Matcher matcherDashNEFT = Pattern.compile("(?i)\\s-\\s" + wat4[15] + "\\s" + CASE15[33] + "\\s(\\w+\\s\\w+)").matcher(withOutUrlSMS);

                                if (matcherDashNEFT.find()){
                                    String group1 = matcherDashNEFT.group(1);
                                    where_at = group1;
                                }



                            }




                        }
                    }catch (Exception e){
                        logger.warning(e.getMessage());
                    }


                    try {

                        //NACH
                        if (where_at.isEmpty()) {
                            Matcher matcherNACH = Pattern.compile("(?i)"+CASE15[71]+"\\s"+CASE15[34]+"\\W(.*?)\\W"+CASE15[2]+"").matcher(withOutUrlSMS);
                            if (matcherNACH.find()){
                                where_at = matcherNACH.group(1);
                            }
                        }

                        //SpayBBPS

                        if (where_at.isEmpty()){

                            Matcher matcherSpayBBPS = Pattern.compile("(?i)"+account_1[10]+"\\s("+CASE15[111]+".*?)\\s"+extra10[0]+"").matcher(withOutUrlSMS);

                            if (matcherSpayBBPS.find()){

                                where_at = matcherSpayBBPS.group(1);

                            }

                        }

                        //Bill Paid :
                        if (where_at.isEmpty()){

                            Matcher matcherBillPaid = Pattern.compile("(?i)"+extra10[0]+"\\s"+extra10[43]+"\\W+(.*?\\s"+extra10[0]+")\\s\\d").matcher(withOutUrlSMS);

                            if (matcherBillPaid.find()){

                                where_at = matcherBillPaid.group(1);

                            }

                        }


                    }catch (Exception e){
                        logger.warning(e.getMessage());
                    }


                    if (msg_text.contains("_____") && where_at.isEmpty()){

                        Matcher spent_for_merchant = Pattern.compile("(?i)"+dbt7[2]+"\\W\\_{7}.*?\\_{7}.*?\\_{7}.*?\\_{7}(.*?)\\_{7}").matcher(msg_text);

                        if (spent_for_merchant.find()){
                            try {
                                String groupMerchantName = spent_for_merchant.group(1);

                                if (groupMerchantName.length()<20) {

                                    String replaceDigit = groupMerchantName.replaceAll("\\d","");

                                    if ((groupMerchantName.length() - replaceDigit.length()) < 4) {
                                        where_at = groupMerchantName.trim();
                                    }
                                }
                            }catch (Exception e){
                                logger.warning(e.getMessage());
                            }
                        }
                    }
                    else {

                        if (where_at.matches(".*\\W"+wat4[39]+"\\W.*")) {
                            where_at = where_at.replaceAll("\\W"+wat4[39]+".*", "");

                        }

                    }

                    where_at = where_at.replaceAll("(?i)"+wat4[41],wat4[41].toUpperCase());


                    if ((where_at.trim().isEmpty() && mode_of_trans.equalsIgnoreCase(wat4[22])) ||
                    where_at.equalsIgnoreCase(wat4[22])){

                        //For SBI IMPS

                        Matcher matcherSBIIMPS = Pattern.compile("(?i)x{3,}\\d+\\-(.*?)\\("+wat4[22]+"").matcher(incomingSms);

                        if (matcherSBIIMPS.find()){

                            where_at = matcherSBIIMPS.group(1).trim();
                        }
                    }

                    if (where_at.equalsIgnoreCase(wat4[15]) ||
                            where_at.equalsIgnoreCase(wat4[16]) ||
                    where_at.isEmpty()){


                        try {
                            //NEFT Cr|dr-

                            Matcher match277 = Pattern.compile("(?i)\\W(" + wat4[23] + "|" + wat4[1] + ")\\s"+wat4[15]+"\\s("+CASE15[33]+"|"+CASE15[34]+")\\s*\\-.*?\\-(.*?)\\-").matcher(msg_text);
                            if (match277.find()) {
                                where_at = match277.group(3).trim();
                                where_at = where_at.replaceAll("__+", "");
                                where_at = where_at.replaceAll("\\s\\s+", " ");

                                if (where_at.endsWith(".") || where_at.endsWith("-")) {
                                    where_at = where_at.substring(0, where_at.length() - 1);
                                }

                            }
                        }catch (Exception e){
                            logger.warning(e.getMessage());
                        }

                    }

                    if (where_at.equalsIgnoreCase(wat4[15]) ||
                            where_at.equalsIgnoreCase(wat4[16]) ||
                    where_at.isEmpty()){


                        try {
                            Matcher match277 = Pattern.compile("(?i)(\\W" + wat4[23] + "|" + wat4[24] + ":)(\\W+|)(" + wat4[15] + "|" + wat4[16] + ")\\W+(.*?)\\.").matcher(msg_text);
                            if (match277.find()) {
                                where_at = match277.group(4).trim();
                                where_at = where_at.replaceFirst("(?i)\\W"+wat4[23]+"(\\W+|)", "");
                                where_at = where_at.replace(wat4[29], "");
                                where_at = where_at.replaceAll("(?i)" + wat4[24] + "(\\W+|)", "");
                                where_at = where_at.replaceAll("(" + wat4[9] + ")", "");
                                where_at = where_at.replaceAll("__+", "");
                                where_at = where_at.replaceAll("\\s\\s+", " ");

                                if (where_at.endsWith(".") || where_at.endsWith("-")) {
                                    where_at = where_at.substring(0, where_at.length() - 1);
                                }

                            }
                        }catch (Exception e){
                            logger.warning(e.getMessage());
                        }

                    }



                    try {

                        if (where_at.contains("@") || (where_at.isEmpty() && incomingSms.contains("@"))) {


                            String getStringForUpiId = frameworkWords.getStringForUpiId();
                            Matcher matcherVPA2 = Pattern.compile("(?i)([" + account_1[19] + "0-9.-]+)[@_](" + getStringForUpiId + ")").matcher(where_at);


                            if (!matcherVPA2.find()) {
                                matcherVPA2 = Pattern.compile("(?i)\\W([" + account_1[19] + "0-9.-]+)[@_](" + getStringForUpiId + ")\\W").matcher(withOutUrlSMS);
                            }else {
                                matcherVPA2 = Pattern.compile("(?i)([" + account_1[19] + "0-9.-]+)[@_](" + getStringForUpiId + ")").matcher(where_at);
                            }

                            if (matcherVPA2.find()) {

                                where_at = matcherVPA2.group(1);

                                if (where_at.matches(".*[a-zA-Z].*")) {


                                    where_at = where_at.replaceAll("__+", "");
                                    where_at = where_at.replaceAll("-+", " ");
                                    //where_at = where_at.replaceAll("[0-9]+", "");
                                    where_at = where_at.replaceAll("\\.", " ");
                                    where_at = where_at.replaceAll("\\s\\s+", " ");


                                    Matcher matcherQ = Pattern.compile("(?i)q[0-9]+").matcher(where_at);

                                    if (matcherQ.find()) {
                                        where_at = wat4[46] + " " + where_at;
                                    } else {
                                        //where_at = where_at.replaceAll("[0-9]+", "");
                                        String tempWhere = where_at;
                                        where_at = where_at.replaceAll("[0-9]+", "");

                                        if (tempWhere.length() - where_at.length() > 10){
                                            //where_at = "Merchant Pay";
                                            where_at = wat4[46]+" "+wat4[63];
                                        }
                                    }

                                    if (where_at.toLowerCase().contains(wat4[42])) {

                                        String tempWhere = where_at.replaceAll("(?i)"+wat4[42],"");

                                        if (tempWhere.length() > 5){
                                            where_at = tempWhere;
                                        }else {
                                            where_at = wat4[43];
                                        }
                                    }

                                } else {

                                    Matcher matcherUpiMobile = Pattern.compile("(?i)([0-9]{10}(-\\d+|))(@[" + account_1[19] + "]+)").matcher(withOutUrlSMS);

                                    if (matcherUpiMobile.find()) {

                                        String numberArray = matcherUpiMobile.group(1);
                                        numberArray = numberArray.replaceAll("-\\d+", "");

                                        //where_at = wat4[41] + " - "+numberArray;




                                    }

                                }

                            }


                        }


                    }catch (Exception e){
                        logger.warning(e.getMessage());
                    }



                    // transaction number 1234 for rs1000.00 case

                    if ((!accountNODigitsOnly.isEmpty() || !cardNODigitsOnly.isEmpty()) && (blockResult.getPass_amount() <= 0)) {

                        Matcher matcherAmount = Pattern.compile("(?i)(" + trx5[0] + "|" + trx5[1] + "|" + trx5[2] + "|" + trx5[3] + "|" + trx5[4] + "|" + trx5[5] + "|" + trx5[20] + ")(\\s*|\\.\\s*)(\\w+|){0,2}\\s*[A-Z0-9]{8,}\\s*" + CASE15[1] + "\\s*(\\W|^)(" + trx5[13] + "|" + trx5[14] + ")([[" + account_1[15] + "]]+|\\s*)\\s*([" + account_1[13] + "\\.\\,]+)").matcher(myIncomingText);

                        if (matcherAmount.find()){
                            String found_string=matcherAmount.group(7);

                            try {
                                found_string=found_string.replaceAll("\\,","");

                                if (found_string.endsWith(".")) {
                                    found_string = found_string.substring(0, found_string.length() - 1);
                                }

                                amount_debited = Double.parseDouble(found_string);
                            } catch (Exception e) {
                                amount_debited = 0.000;
                            }

                            blockResult.setPass_amount(amount_debited);
                            blockResult.setPass_status(dbt7[3]);

                            if (mode_of_trans.isEmpty()) {

                                mode_of_trans = dbt7[0];
                            }

                            blockResult.setAmount_int_status(1);

                        }

                    }




                    Matcher matcherBounce = Pattern.compile("(?i)(" + bncd8[0] + "|" + bncd8[1] + "|" + bncd8[2] + "|" + bncd8[3] + "|" + bncd8[4] + "|" + bncd8[5] + "|" + bncd8[6] + "|" + bncd8[7] + "|" + CASE15[24] + "|" + CASE15[25] + "|" + bncd8[9] + "\\s" + bncd8[10] + "\\s" + bncd8[11] + ")").matcher(msg_text);
                    if (matcherBounce.find()) {

                        //accountNODigitsOnly = "";
                        //cardNODigitsOnly = "";


                        //Delete Last OTP

                        //Delete Last OTP
                        String accountCardNumber = accountNODigitsOnly;
                        if (accountCardNumber.isEmpty()){
                            accountCardNumber = cardNODigitsOnly;
                        }



                        blockResult = new BlockResult();

                        blockResult.setOutput(3);
                        blockResult.setPass_output(3);
                        return blockResult;

                    }else {

                        Matcher matcherWithHeld = Pattern.compile("(?i)" + CASE15[9] + "\\s" + bncd8[8]).matcher(msg_text);
                        if (matcherWithHeld.find()) {
                            //accountNODigitsOnly = "";
                            //cardNODigitsOnly = "";

                            blockResult = new BlockResult();

                            blockResult.setOutput(3);
                            blockResult.setPass_output(3);
                            return blockResult;

                        }else {

                            Matcher matcherConfirm_following = Pattern.compile("(?i)" + CASE15[65] + "\\s" + CASE15[66] + "\\s(" + trx5[0] + "|" + trx5[1] + "|" + trx5[2] + "|" + trx5[3] + "|" + trx5[4] + "|" + trx5[5] + "|" + trx5[6] + "|" + trx5[7] + "|" + trx5[8] + "|" + trx5[9] + "|" + trx5[10] + "|" + trx5[11] + "|" + trx5[20] + "|" + trx5[21] + ")").matcher(msg_text);
                            if (matcherConfirm_following.find()) {
                                //accountNODigitsOnly = "";
                                //cardNODigitsOnly = "";

                                blockResult = new BlockResult();

                                blockResult.setOutput(3);
                                blockResult.setPass_output(3);
                                return blockResult;

                            }else {

                                //Reversed, returned

                                Matcher matcherReversed = Pattern.compile("(?i)"+extra10[7]+"\\s"+extra10[8]+"\\s"+bncd8[12]+"").matcher(msg_text);

                                if (matcherReversed.find()){

                                    if (blockResult.getAmount_int_status() == 1){

                                        blockResult.setAmount_int_status(2);
                                        blockResult.setPass_status(crd6[0]);
                                        mode_of_trans = crd6[6];
                                    }


                                }else {

                                    //Refunded

                                    try {
                                        Matcher matcherRefunded = Pattern.compile("(?i)("+extra10[44]+"|"+extra10[45]+")(\\W+)([0-9,\\.]+)\\s"+extra10[35]+""+CASE15[58]+"").matcher(msg_text);

                                        if (matcherRefunded.find()){

                                            String group3 = matcherRefunded.group(3);

                                            group3 = group3.replaceAll(",","");

                                            blockResult.setPass_amount(Double.parseDouble(group3));
                                            blockResult.setAmount_int_status(2);
                                            blockResult.setPass_status(crd6[0]);
                                            mode_of_trans = crd6[6];

                                        }else {
                                            //Transaction reversed

                                                Matcher matcherTReversed = Pattern.compile("(?i)"+CASE15[50]+"\\s"+bncd8[12]+"").matcher(msg_text);

                                                if (matcherTReversed.find()){

                                                    Matcher matcherOnDate = Pattern.compile("(?i)\\s"+trx5[15]+"\\s[0-9]{2}").matcher(msg_text);

                                                    if (!matcherOnDate.find()) {

                                                        Matcher matcherRsINR = Pattern.compile("(?i)("+trx5[13]+"|"+trx5[14]+")(\\W+|)([0-9,\\.]+)\\s").matcher(msg_text);

                                                        if (matcherRsINR.find()) {


                                                            String group3 = matcherRsINR.group(3);

                                                            group3 = group3.replaceAll(",", "");
                                                            blockResult.setPass_amount(Double.parseDouble(group3));
                                                            blockResult.setAmount_int_status(2);
                                                            blockResult.setPass_status(crd6[0]);
                                                            mode_of_trans = crd6[6];
                                                            where_at = trx5[5]+" "+bncd8[12];

                                                        }
                                                    }

                                                }

                                        }

                                    }catch (Exception e){
                                        logger.warning(e.getMessage());
                                    }

                                }




                            }

                        }

                    }


                    try {

                        Matcher matcherBounce1 = Pattern.compile("(?i)(" + CASE15[13] + "|" + CASE15[14] + "|" + CASE15[15] + "(\\'|)t|" + CASE15[16] + "(\\'|)t|" + CASE15[17] + "(\\'|)t|" + CASE15[18] + "(\\'|)t|" + CASE15[19] + ")\\s*(-|)\\s*(" + CASE15[20] + "|)\\s*(" + CASE15[21] + "|" + CASE15[22] + "|" + CASE15[12] + ")").matcher(msg_text);
                        if (matcherBounce1.find()) {



                            //Delete Last OTP
                            String accountCardNumber = accountNODigitsOnly;
                            if (accountCardNumber.isEmpty()){
                                accountCardNumber = cardNODigitsOnly;
                            }




                            accountNODigitsOnly = "";
                            cardNODigitsOnly = "";
                            blockResult = new BlockResult();

                            blockResult.setOutput(3);
                            blockResult.setPass_output(3);
                            return blockResult;

                        }
                    } catch (Exception e) {
                        logger.warning(e.getMessage());
                    }


                    try {
                        String[] bldu9 = frameworkWords.bldu9();

                        Matcher matcherIgnore = Pattern.compile("(?i)(" + bldu9[0] + "|" + bldu9[1] + "|" + bldu9[2] + "|" + bldu9[3] + "|" + bldu9[4] + "|" + bldu9[5] + "|" + bldu9[6] + "|" + bldu9[7] + "|" + bldu9[20] + ")").matcher(msg_text);
                        if (matcherIgnore.find()) {

                            if (msg_text.toLowerCase().contains(bldu9[16])) {
                                accountNODigitsOnly = "";
                                cardNODigitsOnly = "";

                                blockResult = new BlockResult();

                                blockResult.setOutput(iGEtSTAT);
                                blockResult.setPass_output(iGEtSTAT);
                                return blockResult;
                            } else {

                                Matcher matcherIgnore1 = Pattern.compile("(?i)(" + bldu9[8] + ")[\\W]{1,3}(" + bldu9[9] + "|" + bldu9[10] + "|" + bldu9[11] + "|" + bldu9[12] + "|" + bldu9[13] + "|" + bldu9[14] + "|" + bldu9[15] + "|" + bal_amt3[5] + "(\\W)|" + bldu9[18] + "(\\W)|" + CASE15[7] + "(\\W)|" + bldu9[19] + "|" + bldu9[21] + "|" + bldu9[22] + ")").matcher(msg_text);
                                if (matcherIgnore1.find()) {

                                    boolean dontClear = false;

                                    try {
                                        Matcher matcherReversal = Pattern.compile("(?i)(" + bldu9[23] + "|" + bldu9[24] + ")\\s"+CASE15[31]+"\\s("+CASE15[47]+"|"+CASE15[48]+")").matcher(msg_text);

                                        if (matcherReversal.find() && blockResult.getAmount_int_status() == 2){

                                            dontClear = true;
                                        }

                                    }catch (Exception exception){
                                        logger.warning(exception.getMessage());
                                    }


                                    if (!dontClear) {

                                        accountNODigitsOnly = "";
                                        cardNODigitsOnly = "";

                                        blockResult = new BlockResult();

                                        blockResult.setOutput(iGEtSTAT);
                                        blockResult.setPass_output(iGEtSTAT);
                                        return blockResult;
                                    }
                                } else {
                                    Matcher matcherIgnore2 = Pattern.compile("(?i)(\\W|^)(" + bldu9[17] + "\\s*(\\w|\\W){0,25}" + dbt7[9] + ")").matcher(msg_text);
                                    if (matcherIgnore2.find()) {
                                        accountNODigitsOnly = "";
                                        cardNODigitsOnly = "";
                                        blockResult.setPass_amount(0.0);

                                        blockResult = new BlockResult();

                                        blockResult.setOutput(iGEtSTAT);
                                        blockResult.setPass_output(iGEtSTAT);
                                        return blockResult;

                                    }else {

                                        Matcher matcherIgnore3 = Pattern.compile("(?i)" + bldu9[8] + "\\s(" + CASE15[31] + "|\\W+|)\\s*(" + bldu9[11] + "|" + bldu9[12] + ")(\\W+|)(\\d+\\.\\d+|\\d+)\\W+" + bldu9[14] + "").matcher(msg_text);
                                        if (matcherIgnore3.find()) {
                                            accountNODigitsOnly = "";
                                            cardNODigitsOnly = "";

                                            blockResult = new BlockResult();

                                            blockResult.setOutput(iGEtSTAT);
                                            blockResult.setPass_output(iGEtSTAT);
                                            return blockResult;
                                        }

                                    }
                                }

                            }


                        }
                    } catch (Exception eee) {
                        logger.warning(eee.getMessage());
                    }

                    try {
                        Matcher matcherAutoPay = Pattern.compile("(?i)"+CASE15[60]+"(\\W+|)"+account_1[21]+"(\\w+|)\\W("+CASE15[85]+"|"+CASE15[86]+")").matcher(msg_text);

                        if (matcherAutoPay.find()){

                            accountNODigitsOnly = "";
                            cardNODigitsOnly = "";

                            blockResult = new BlockResult();

                            blockResult.setOutput(iGEtSTAT);
                            blockResult.setPass_output(iGEtSTAT);
                            return blockResult;


                        }else {

                            Matcher matcherAutoPay2 = Pattern.compile("(?i)"+CASE15[85]+"\\W+"+CASE15[87]+"\\W+"+CASE15[60]+"(\\W+|)"+account_1[21]+"(\\w+|)").matcher(msg_text);

                            if (matcherAutoPay2.find()){

                                accountNODigitsOnly = "";
                                cardNODigitsOnly = "";

                                blockResult = new BlockResult();

                                blockResult.setOutput(iGEtSTAT);
                                blockResult.setPass_output(iGEtSTAT);
                                return blockResult;


                            }



                        }


                    }catch (Exception e){
                        logger.warning(e.getMessage());
                    }


                    try {
                        if (blockResult.getPass_avl_amount() < 0 && blockResult.getPass_amount() <= 0 && where_at.isEmpty()) {
                            Matcher match991 = Pattern.compile("(?i)(" + bal_amt3[0] + "|" + bal_amt3[1] + "|" + bal_amt3[2] + "|" + bal_amt3[3] + ")\\s*" + bal_amt3[4] + ".*?" + bal_amt3[5] + "\\s*[\\W]{0,3}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| )").matcher(msg_text);

                            if (match991.find()) {
                                String testBalanceAmount = match991.group();
                                String test = testBalanceAmount;

                                Matcher match3 = Pattern.compile("(?i)[\\W]{0,3}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| )").matcher(testBalanceAmount);
                                String otherToDelete = "";

                                while (match3.find()) {

                                    otherToDelete = match3.group();
                                    test = match3.group();
                                    Matcher match33 = Pattern.compile("(?i)((" + bal_amt3[6] + "|" + bal_amt3[7] + ")\\.|[" + account_1[19] + "]|(?!\\.)[\\W])").matcher(test);

                                    while (match33.find()) {

                                        try {
                                            test = test.replace(match33.group(), "").trim();
                                        } catch (Exception e) {
                                            logger.warning(e.getMessage());

                                        }
                                        if (test.endsWith(".")) {
                                            test = test.substring(0, test.length() - 1);
                                        }
                                    }
                                }

                                availableBalance1 = test;
                                blockResult.setPass_acc_type("NS");

                                blockResult.setPass_avl_amount(Double.parseDouble(availableBalance1));


                                try {

                                    otherToDelete = otherToDelete.substring(0, otherToDelete.length() - 1);

                                } catch (Exception e) {
                                    logger.warning(e.getMessage());
                                }


                            }
                        }
                    } catch (Exception e) {
                        logger.warning(e.getMessage());
                    }
                    try {
                        if (blockResult.getPass_avl_amount() < 0 && blockResult.getPass_amount() <= 0 && where_at.isEmpty()) {

                            Matcher match991 = Pattern.compile("(?i)(" + bal_amt3[0] + "|" + bal_amt3[1] + "|" + bal_amt3[2] + "|" + bal_amt3[3] + ")\\s*" + bal_amt3[4] + ".*?[\\n]+.*" + bal_amt3[5] + "\\s*[\\W]{0,3}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| |,\n)").matcher(msg_text);

                            if (match991.find()) {
                                String testBalanceAmount = match991.group();
                                String test = testBalanceAmount;

                                Matcher match3 = Pattern.compile("(?i)[\\W]{0,3}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| )").matcher(testBalanceAmount);
                                String otherToDelete = "";

                                while (match3.find()) {

                                    otherToDelete = match3.group();
                                    test = match3.group();
                                    Matcher match33 = Pattern.compile("(?i)((" + bal_amt3[6] + "|" + bal_amt3[7] + ")\\.|[" + account_1[19] + "]|(?!\\.)[\\W])").matcher(test);

                                    while (match33.find()) {

                                        try {
                                            test = test.replace(match33.group(), "").trim();
                                        } catch (Exception e) {
                                            logger.warning(e.getMessage());

                                        }
                                        if (test.endsWith(".")) {
                                            test = test.substring(0, test.length() - 1);
                                        }
                                    }
                                }

                                availableBalance1 = test;
                                blockResult.setPass_acc_type("NS");

                                blockResult.setPass_avl_amount(Double.parseDouble(availableBalance1));


                                try {

                                    otherToDelete = otherToDelete.substring(0, otherToDelete.length() - 1);

                                } catch (Exception e) {
                                    logger.warning(e.getMessage());
                                }


                            }
                        }
                    } catch (Exception e) {
                        logger.warning(e.getMessage());
                    }

                    //balances
                    try {
                        if (blockResult.getPass_avl_amount() < 0 && blockResult.getPass_amount() <= 0) {
                            Matcher match991 = Pattern.compile("(?i)(" + bal_amt3[1] + "s)\\s*"+CASE15[88]+".*?(" + bal_amt3[6] + "|" + bal_amt3[7] + "|-|:)\\s*[\\W]{0,3}(.*?)([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| )").matcher(msg_text);

                            if (match991.find()) {
                                String testBalanceAmount = match991.group(3);

                                testBalanceAmount = testBalanceAmount.replace(",", "");


                                if (testBalanceAmount.endsWith(".")) {
                                    testBalanceAmount = testBalanceAmount.substring(0, testBalanceAmount.length() - 1);
                                }

                                availableBalance1 = testBalanceAmount;
                                blockResult.setPass_acc_type("NS");


                                try {
                                    blockResult.setPass_avl_amount(Double.parseDouble(availableBalance1));

                                } catch (Exception e) {
                                    logger.warning(e.getMessage());
                                }


                            }
                        }
                    } catch (Exception e) {
                        logger.warning(e.getMessage());
                    }


                    try {

                        if (blockResult.getPass_avl_amount() < 0 && blockResult.getPass_amount() <= 0 && !cardNODigitsOnly.isEmpty()) {


                            complete_SMS = complete_SMS.replaceAll("(?i)" + account_1[0], "" + account_1[11] + "");
                            complete_SMS = complete_SMS.replaceAll("(?i)" + account_1[1], "" + account_1[12] + "");

                            if (complete_SMS.toLowerCase().contains(CASE15[26]) || complete_SMS.toLowerCase().contains("" + CASE15[27] + "")) {

                                if (complete_SMS.toLowerCase().contains(CASE15[26])) {


                                    int index = complete_SMS.toLowerCase().indexOf(CASE15[26]);
                                    int index2 = index + 50;
                                    int index3 = index - 50;

                                    if (index2 > complete_SMS.length()) {
                                        index2 = complete_SMS.length();
                                    }

                                    if (index3 < 0) {
                                        index3 = 0;
                                    }

                                    String subString = complete_SMS.substring(index3, index2).toLowerCase();

                                    if (subString.contains(CASE15[28]) || subString.contains(CASE15[29] + "-")
                                            || subString.contains(" " + CASE15[29] + " ") || subString.contains(CASE15[30])) {

                                    } else {

                                        String date_pre = commonLogicFunction.getReplaceDateText(context,complete_SMS);

                                        if (!date_pre.equals("~")) {

                                            String[] all = complete_SMS.toLowerCase().split("\\.(?!\\d)|(?<!\\d)\\.");

                                            for (String text : all) {

                                                if (text.contains(CASE15[26])) {

                                                    Matcher match33 = Pattern.compile("(?i)(\\W|^)(" + bal_amt3[6] + "|" + bal_amt3[7] + ")(\\W+|)(\\d.*?([a-z]| ))").matcher(text);

                                                    if (match33.find()) {

                                                        String amountDetected = match33.group(4).trim();

                                                        if (amountDetected.endsWith(".")) {
                                                            amountDetected = amountDetected.substring(0, amountDetected.length() - 1);
                                                        }

                                                        amountDetected = amountDetected.replaceAll(",", "");

                                                        try {
                                                            amount_debited = Double.parseDouble(amountDetected);
                                                        } catch (Exception e) {
                                                            amount_debited = 0.000;
                                                        }


                                                        blockResult.setPass_amount(amount_debited);
                                                        blockResult.setPass_status(dbt7[3]);

                                                        if (mode_of_trans.isEmpty()) {

                                                            mode_of_trans = dbt7[0];
                                                        }

                                                        blockResult.setAmount_int_status(1);

                                                        act_next = true;
                                                    }

                                                    break;
                                                }

                                            }

                                        }


                                    }


                                } else {


                                    int index = complete_SMS.toLowerCase().indexOf(CASE15[27]);
                                    int index2 = index + 50;
                                    int index3 = index - 50;

                                    if (index2 > complete_SMS.length()) {
                                        index2 = complete_SMS.length();
                                    }

                                    if (index3 < 0) {
                                        index3 = 0;
                                    }

                                    String subString = complete_SMS.substring(index3, index2).toLowerCase();

                                    if (subString.contains(CASE15[28]) || subString.contains(CASE15[29] + "-")) {

                                    } else {

                                        String date_pre = commonLogicFunction.getReplaceDateText(context,complete_SMS);

                                        if (!date_pre.equals("~")) {

                                            String[] all = complete_SMS.toLowerCase().split("\\.(?!\\d)|(?<!\\d)\\.");

                                            for (String text : all) {

                                                if (text.contains(CASE15[37])) {

                                                    Matcher match33 = Pattern.compile("(?i)(\\W|^)(" + bal_amt3[6] + "|" + bal_amt3[7] + ")(\\W+|)(\\d.*?([a-z]| ))").matcher(text);

                                                    if (match33.find()) {

                                                        String amountDetected = match33.group(4).trim();

                                                        if (amountDetected.endsWith(".")) {
                                                            amountDetected = amountDetected.substring(0, amountDetected.length() - 1);
                                                        }

                                                        amountDetected = amountDetected.replaceAll(",", "");

                                                        try {
                                                            amount_debited = Double.parseDouble(amountDetected);
                                                        } catch (Exception e) {
                                                            amount_debited = 0.000;
                                                        }


                                                        blockResult.setPass_amount(amount_debited);
                                                        blockResult.setPass_status(dbt7[3]);

                                                        if (mode_of_trans.isEmpty()) {

                                                            mode_of_trans = dbt7[0];
                                                        }

                                                        blockResult.setAmount_int_status(1);

                                                        act_next = true;
                                                    }

                                                    break;
                                                }

                                            }

                                        }


                                    }


                                }
                            }


                        }


                        if (blockResult.getPass_amount() <= 0 && !cardNODigitsOnly.isEmpty()) {

                            Matcher match33 = Pattern.compile("(?i)\\W(" + CASE15[10] + " " + CASE15[31] + " )(" + trx5[13] + "|" + trx5[14] + ")(\\W+|)(\\d.*?)( )(\\w+|\\W+){0,14}" + CASE15[11] + "").matcher(msg_text);
                            if (match33.find()) {
                                String amountDetected = match33.group(4).trim();

                                if (amountDetected.endsWith(".")) {
                                    amountDetected = amountDetected.substring(0, amountDetected.length() - 1);
                                }

                                amountDetected = amountDetected.replaceAll(",", "");

                                try {
                                    amount_debited = Double.parseDouble(amountDetected);
                                } catch (Exception e) {
                                    amount_debited = 0.000;
                                }

                                blockResult.setPass_amount(amount_debited);
                                blockResult.setPass_status(dbt7[3]);
                                blockResult.setAmount_int_status(1);
                                act_next = true;
                            }


                        }


                    } catch (Exception e) {
                        logger.warning(e.getMessage());

                    }


                    try {

                        if ((!blockResult.getCARD_ACCOUNT_NO().isEmpty() || !blockResult.getPass_acc_no().isEmpty()
                                && blockResult.getPass_amount() <= 0)) {


                            try {


                                Matcher matcherAmount66 = Pattern.compile("(?i)(" + crd6[10] + " (\\w| |-){2,12}\\s|" + crd6[11] + " (\\w| |-){2,12}\\s|" + crd6[12] + " (\\w| |-){2,12}\\s|" + CASE15[32] + " )(" + dbt7[1] + "|" + dbt7[3] + "|" + dbt7[11] + ").*?(\\W|^)(" + trx5[13] + "|" + trx5[14] + ")([[" + account_1[15] + "]]+|\\s*)(\\W){0,3}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| )").matcher(myIncomingText);

                                if (matcherAmount66.find()) {

                                    String test = "0";
                                    String amountText = matcherAmount66.group();

                                    String checkInString = amountText;

                                    int indexAmountText = myIncomingText.indexOf(amountText) - 12;

                                    if (indexAmountText < 0) {
                                        indexAmountText = 0;
                                    }

                                    checkInString = myIncomingText.substring(indexAmountText, (indexAmountText + 12 +amountText.length()));


                                    Matcher matcher_check_prev = Pattern.compile("(?i)(" + trx5[23] + "|" + trx5[25] + "\\.|" + trx5[24] + "|" + trx5[26] + "(\\.|))\\s*(" + dbt7[1] + "|" + dbt7[3] + "|" + dbt7[11] + "|" + dbt7[2] + "|" + dbt7[4] + "|" + dbt7[5] + "|" + dbt7[6] + "|" + dbt7[7] + "[^" + account_1[20] + "]|" + dbt7[8] + "|" + dbt7[9] + "|" + dbt7[10] + ")").matcher(checkInString);

                                    if (matcher_check_prev.find()){

                                        blockResult = new BlockResult();
                                        blockResult.setPass_output(iGEtSTAT);
                                        blockResult.setOutput(iGEtSTAT);
                                        return blockResult;
                                    }

                                    Matcher match3 = Pattern.compile("(?i)(" + trx5[13] + "|" + trx5[14] + ")\\s*([[" + account_1[15] + "]]+|\\s*)(\\W){0,3}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| )").matcher(amountText);


                                    while (match3.find()) {

                                        test = match3.group();
                                        Matcher match33 = Pattern.compile("(?i)((" + trx5[13] + "|" + trx5[14] + ")\\.|[" + account_1[19] + "]|(?!\\.)[\\W])").matcher(test);

                                        while (match33.find()) {
                                            try {
                                                test = test.replace(match33.group(), "").trim();
                                            } catch (Exception e) {
                                                logger.warning(e.getMessage());

                                            }
                                            if (test.endsWith(".")) {
                                                test = test.substring(0, test.length() - 1);
                                            }
                                        }
                                    }


                                    try {
                                        amount_debited = Double.parseDouble(test);
                                    } catch (Exception e) {
                                        amount_debited = 0.000;
                                    }


                                    blockResult.setPass_amount(amount_debited);
                                    blockResult.setPass_status(dbt7[3]);
                                    //blockResult.setAmount_int_status(1);
                                    if (mode_of_trans.isEmpty()) {

                                        mode_of_trans = dbt7[0];
                                    }


                                    Matcher matcher = Pattern.compile("(?i)\\W(" + trx5[15] + "|" + trx5[29] + ")(\\W{1,2})(\\w+|\\W+){5,10}").matcher(complete_SMS);

                                    while (matcher.find()) {

                                        String text = matcher.group();
                                        String date_pre = commonLogicFunction.getReplaceDateText(context,text);
                                        if (!date_pre.equals("~")) {

                                            will_be_case = true;
                                            cardNODigitsOnly = blockResult.getCARD_ACCOUNT_NO();
                                            accountNODigitsOnly = blockResult.getPass_acc_no();
                                            blockResult.setAmount_int_status(1);


                                            String[] date_format = date_pre.split("~");
                                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                                            try {
                                                Date mDate = simpleDateFormat.parse(date_format[0]);
                                                long timeInMilliseconds = mDate.getTime();

                                                Calendar calendar = Calendar.getInstance();
                                                calendar.setTimeInMillis(timeInMilliseconds);
                                                calendar.set(Calendar.HOUR_OF_DAY, 15);
                                                calendar.set(Calendar.MINUTE, 58);
                                                calendar.set(Calendar.SECOND, 58);
                                                blockResult.setDUE_DATE(calendar.getTimeInMillis());

                                            } catch (Exception e) {
                                                logger.warning(e.getMessage());
                                            }
                                            break;
                                        }
                                    }

                                    if (!will_be_case){
                                        accountNODigitsOnly = "";
                                        cardNODigitsOnly = "";

                                        blockResult = new BlockResult();

                                        blockResult.setOutput(iGEtSTAT);
                                        blockResult.setPass_output(iGEtSTAT);
                                    }


                                } else {

                                    Matcher matcherAmount626 = Pattern.compile("(?i)(\\W|^)(" + trx5[13] + "|" + trx5[14] + ")([[" + account_1[15] + "]]+|\\s*)(\\W){0,3}[" + account_1[13] + "].*?(" + crd6[10] + " (\\w| |-){2,12}\\s|" + crd6[11] + " (\\w| |-){2,12}\\s|" + crd6[12] + " (\\w| |-){2,12}\\s|" + CASE15[32] + " )(" + dbt7[1] + "|" + dbt7[3] + "|" + dbt7[11] + ")").matcher(myIncomingText);

                                    if (matcherAmount626.find()) {


                                        String test = "0";
                                        String amountText = matcherAmount626.group();

                                        String checkInString = amountText;

                                        int indexAmountText = myIncomingText.indexOf(amountText) - 12;

                                        if (indexAmountText < 0) {
                                            indexAmountText = 0;
                                        }

                                        checkInString = myIncomingText.substring(indexAmountText, (indexAmountText + 12 +amountText.length()));


                                        Matcher matcher_check_prev = Pattern.compile("(?i)(" + trx5[23] + "|" + trx5[25] + "\\.|" + trx5[24] + "|" + trx5[26] + "(\\.|))\\s*(" + dbt7[1] + "|" + dbt7[3] + "|" + dbt7[11] + "|" + dbt7[2] + "|" + dbt7[4] + "|" + dbt7[5] + "|" + dbt7[6] + "|" + dbt7[7] + "[^" + account_1[20] + "]|" + dbt7[8] + "|" + dbt7[9] + "|" + dbt7[10] + ")").matcher(checkInString);

                                        if (matcher_check_prev.find()){

                                            blockResult = new BlockResult();
                                            blockResult.setPass_output(iGEtSTAT);
                                            blockResult.setOutput(iGEtSTAT);
                                            return blockResult;
                                        }


                                        Matcher match3 = Pattern.compile("(?i)(" + trx5[13] + "|" + trx5[14] + ")\\s*([[" + account_1[15] + "]]+|\\s*)(\\W){0,3}[" + account_1[13] + "].*?([" + account_1[20] + "]|$|:|=|-|_|\\(|\\{|<| )").matcher(amountText);


                                        while (match3.find()) {

                                            test = match3.group();
                                            Matcher match33 = Pattern.compile("(?i)((" + trx5[13] + "|" + trx5[14] + ")\\.|[" + account_1[19] + "]|(?!\\.)[\\W])").matcher(test);

                                            while (match33.find()) {
                                                try {
                                                    test = test.replace(match33.group(), "").trim();
                                                } catch (Exception e) {
                                                    logger.warning(e.getMessage());

                                                }
                                                if (test.endsWith(".")) {
                                                    test = test.substring(0, test.length() - 1);
                                                }
                                            }
                                        }


                                        try {
                                            amount_debited = Double.parseDouble(test);
                                        } catch (Exception e) {
                                            amount_debited = 0.000;
                                        }


                                        blockResult.setPass_amount(amount_debited);
                                        blockResult.setPass_status(dbt7[3]);
                                        //blockResult.setAmount_int_status(1);
                                        if (mode_of_trans.isEmpty()) {

                                            mode_of_trans = dbt7[0];
                                        }
                                        Matcher matcher = Pattern.compile("(?i)\\W(" + trx5[15] + "|" + trx5[29] + ")(\\W{1,2})(\\w+|\\W+){5,10}").matcher(complete_SMS);

                                        while (matcher.find()) {

                                            String text = matcher.group();
                                            String date_pre = commonLogicFunction.getReplaceDateText(context,text);
                                            if (!date_pre.equals("~")) {

                                                will_be_case = true;
                                                cardNODigitsOnly = blockResult.getCARD_ACCOUNT_NO();
                                                accountNODigitsOnly = blockResult.getPass_acc_no();
                                                blockResult.setAmount_int_status(1);


                                                String[] date_format = date_pre.split("~");
                                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                                                try {
                                                    Date mDate = simpleDateFormat.parse(date_format[0]);
                                                    long timeInMilliseconds = mDate.getTime();

                                                    Calendar calendar = Calendar.getInstance();
                                                    calendar.setTimeInMillis(timeInMilliseconds);
                                                    calendar.set(Calendar.HOUR_OF_DAY, 15);
                                                    calendar.set(Calendar.MINUTE, 58);
                                                    calendar.set(Calendar.SECOND, 58);
                                                    blockResult.setDUE_DATE(calendar.getTimeInMillis());

                                                } catch (Exception e) {
                                                    logger.warning(e.getMessage());
                                                }
                                                break;
                                            }
                                        }

                                        if (!will_be_case){
                                            accountNODigitsOnly = "";
                                            cardNODigitsOnly = "";

                                            blockResult = new BlockResult();

                                            blockResult.setOutput(iGEtSTAT);
                                            blockResult.setPass_output(iGEtSTAT);
                                        }
                                    }
                                }


                            } catch (Exception e) {
                                logger.warning(e.getMessage());
                            }

                            if (blockResult.getPass_amount() <= 0) {


                                //extra case

                                if (dbtd_extra) {

                                    Matcher matcherAmount663 = Pattern.compile("(?i)(" + crd6[10] + " (\\w| |-){2,12}\\s|" + crd6[11] + " (\\w| |-){2,12}\\s|" + crd6[12] + " (\\w| |-){2,12}\\s)(" + dbt7[1] + "|" + dbt7[3] + "|" + dbt7[11] + ").*?(\\d+.\\d+|\\d+)\\s*(" + trx5[13] + "|" + trx5[14] + ")(\\W|$)|((\\d+.\\d+|\\d+)\\s*(" + trx5[13] + "|" + trx5[14] + ")(\\W).*?(" + crd6[10] + " (\\w| |-){2,12}\\s|" + crd6[11] + " (\\w| |-){2,12}\\s|" + crd6[12] + " (\\w| |-){2,12}\\s)(" + dbt7[1] + "|" + dbt7[3] + "|" + dbt7[11] + "))").matcher(myIncomingText);

                                    if (matcherAmount663.find()) {

                                        String test = "0";
                                        String amountText = matcherAmount663.group();


                                        String checkInString = amountText;

                                        int indexAmountText = myIncomingText.indexOf(amountText) - 12;

                                        if (indexAmountText < 0) {
                                            indexAmountText = 0;
                                        }

                                        checkInString = myIncomingText.substring(indexAmountText, (indexAmountText + 12 +amountText.length()));


                                        Matcher matcher_check_prev = Pattern.compile("(?i)(" + trx5[23] + "|" + trx5[25] + "\\.|" + trx5[24] + "|" + trx5[26] + "(\\.|))\\s*(" + dbt7[1] + "|" + dbt7[3] + "|" + dbt7[11] + "|" + dbt7[2] + "|" + dbt7[4] + "|" + dbt7[5] + "|" + dbt7[6] + "|" + dbt7[7] + "[^" + account_1[20] + "]|" + dbt7[8] + "|" + dbt7[9] + "|" + dbt7[10] + ")").matcher(checkInString);

                                        if (matcher_check_prev.find()){

                                            blockResult = new BlockResult();
                                            blockResult.setPass_output(iGEtSTAT);
                                            blockResult.setOutput(iGEtSTAT);
                                            return blockResult;
                                        }



                                        Matcher match3 = Pattern.compile("(?i)(\\d+.\\d+|\\d+)\\s*(" + trx5[13] + "|" + trx5[14] + ")").matcher(amountText);


                                        while (match3.find()) {

                                            test = match3.group();
                                            Matcher match33 = Pattern.compile("(?i)((" + trx5[13] + "|" + trx5[14] + ")\\.|[" + account_1[19] + "]|(?!\\.)[[" + account_1[15] + "]])").matcher(test);

                                            while (match33.find()) {
                                                try {
                                                    test = test.replace(match33.group(), "").trim();
                                                } catch (Exception e) {
                                                    logger.warning(e.getMessage());

                                                }
                                                if (test.endsWith(".")) {
                                                    test = test.substring(0, test.length() - 1);
                                                }
                                            }
                                        }


                                        try {
                                            amount_debited = Double.parseDouble(test);
                                        } catch (Exception e) {
                                            amount_debited = 0.000;
                                        }


                                        blockResult.setPass_amount(amount_debited);
                                        blockResult.setPass_status(dbt7[3]);
                                        //blockResult.setAmount_int_status(1);
                                        if (mode_of_trans.isEmpty()) {

                                            mode_of_trans = dbt7[0];
                                        }

                                        Matcher matcher = Pattern.compile("(?i)\\W(" + trx5[15] + "|" + trx5[29] + ")(\\W{1,2})(\\w+|\\W+){5,10}").matcher(complete_SMS);

                                        while (matcher.find()) {

                                            String text = matcher.group();
                                            String date_pre = commonLogicFunction.getReplaceDateText(context,text);
                                            if (!date_pre.equals("~")) {

                                                will_be_case = true;
                                                cardNODigitsOnly = blockResult.getCARD_ACCOUNT_NO();
                                                accountNODigitsOnly = blockResult.getPass_acc_no();
                                                blockResult.setAmount_int_status(1);


                                                String[] date_format = date_pre.split("~");
                                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                                                try {
                                                    Date mDate = simpleDateFormat.parse(date_format[0]);
                                                    long timeInMilliseconds = mDate.getTime();

                                                    Calendar calendar = Calendar.getInstance();
                                                    calendar.setTimeInMillis(timeInMilliseconds);
                                                    calendar.set(Calendar.HOUR_OF_DAY, 15);
                                                    calendar.set(Calendar.MINUTE, 58);
                                                    calendar.set(Calendar.SECOND, 58);
                                                    blockResult.setDUE_DATE(calendar.getTimeInMillis());

                                                } catch (Exception e) {
                                                    logger.warning(e.getMessage());
                                                }
                                                break;
                                            }
                                        }

                                        if (!will_be_case){
                                            accountNODigitsOnly = "";
                                            cardNODigitsOnly = "";

                                            blockResult = new BlockResult();

                                            blockResult.setOutput(iGEtSTAT);
                                            blockResult.setPass_output(iGEtSTAT);
                                        }


                                    }

                                }


                            }


                        }


                    } catch (Exception e) {
                        logger.warning(e.getMessage());
                    }


                    try {

                        if (blockResult.getAmount_int_status() == 1) {

                            Matcher matcher = Pattern.compile("(?i)(" + CASE15[6] + "\\s" + CASE15[20] + "|" + CASE15[9] + ")(\\W|\\w){0,20}" + CASE15[40] + "\\s(" + CASE15[42] + "" + CASE15[43] + "|" + CASE15[42] + "|" + CASE15[43] + ")(\\W|\\w){0,10}" + CASE15[41] + "").matcher(incomingSms);

                            if (matcher.find()) {

                                accountNODigitsOnly = "";
                                cardNODigitsOnly = "";
                                accountNO = "";
                                cardNO = "";
                            }


                        }


                    } catch (Exception e) {
                        logger.warning(e.getMessage());
                    }

                }

                if (changeSender.contains(extra10[89]) && mode_of_trans.contains(extra10[95])
                && msg_text.contains(extra10[96])){
                    mode_of_trans = ""+wat4[19]+"" +wat4[20]+"";
                }

                blockResult.setPass_acc_full_name(accountNO);
                blockResult.setMode_name(mode_of_trans);

                blockResult.setPass_card_full_name(cardNO);


                if ((!accountNODigitsOnly.isEmpty() || !cardNODigitsOnly.isEmpty()) && (!availableBalance1.isEmpty() || blockResult.getPass_amount() > 0 || blockResult.getOut_standing() > 0)) {

                    if (!mode_of_trans.contains("------")){
                        try {
                            if (where_at.trim().isEmpty()){

                                String date_pre = commonLogicFunction.getReplaceDateText(context,complete_SMS);

                                if (!date_pre.equals("~")) {
                                    String date = date_pre.split("~")[1];
                                    Matcher matcher = Pattern.compile("(?i)\\W" + CASE15[2] + "\\W"+date+"\\W" + CASE15[2] + "\\W(.*?)(\\.|,|-|:)").matcher(complete_SMS);

                                    if (matcher.find()){

                                        where_at = matcher.group(1);

                                    }else {

                                        try {
                                            //on 20-Jan-24; MOHD MONISH RAI credited.
                                            Matcher matcherNewCase = Pattern.compile("(?i)\\W" + CASE15[2] + "\\W"+date+"\\W(.*?)(" + CASE15[73] + ")").matcher(complete_SMS);

                                            if (matcherNewCase.find()){
                                                where_at = matcherNewCase.group(1).trim();

                                                if (where_at.equalsIgnoreCase(""+CASE15[115]+"")){
                                                    where_at = "";
                                                }
                                            }

                                        }catch (Exception e){
                                            logger.warning(e.getMessage());
                                        }


                                    }
                                }
                            }
                            where_at = where_at.trim();

                            try {

                                if (where_at.isEmpty()){

                                    //ATM
                                    if (mode_of_trans.equalsIgnoreCase(wat4[33])){
                                        where_at = wat4[33];
                                    }


                                }

                                if (where_at.endsWith("*")) {

                                    where_at = where_at.substring(0, where_at.length() - 1);
                                }

                                if (where_at.isEmpty() || where_at.equalsIgnoreCase(wat4[15])){

                                    if (blockResult.getAmount_int_status() == 1){

                                        Matcher matcherCreditedTo = Pattern.compile("(?i)"+CASE15[73]+"\\s"+CASE15[43]+"\\sX{2,}([0-9]+)").matcher(withOutUrlSMS);

                                        if (matcherCreditedTo.find()){
                                            where_at = ""+CASE15[73]+" "+CASE15[43]+" "+CASE15[114]+" " +matcherCreditedTo.group(1);
                                        }else {

                                            Matcher matcherCreditedTo2 = Pattern.compile("(?i)"+CASE15[73]+"\\s"+CASE15[43]+"\\s(\\W|\\w){0,10}X{2,}([0-9]+)").matcher(withOutUrlSMS);

                                            if (matcherCreditedTo2.find()){
                                                where_at = ""+CASE15[73]+" "+CASE15[43]+" "+CASE15[114]+" " +matcherCreditedTo2.group(2);
                                            }

                                        }

                                    }

                                }

                                if (where_at.isEmpty()){

                                    Matcher matcherDebitedTRF = Pattern.compile("(?i)\\("+wat4[60]+"\\)(.*?)"+wat4[3]+"\\s"+wat4[28]+"").matcher(msg_text);

                                    if (matcherDebitedTRF.find()){

                                        where_at = matcherDebitedTRF.group(1);
                                    }
                                }

                                if (/*mode_of_trans.equalsIgnoreCase(wat4[15]) && */msg_text.toLowerCase().contains(CASE15[106])){

                                    try {

                                        Matcher matcherFVG = Pattern.compile("(?i)\\W"+wat4[15]+"\\s"+CASE15[106]+"\\s"+account_1[24]+"(\\w+|)\\s(.*?)(\\.|\\,)").matcher(withOutUrlSMS);

                                        if (matcherFVG.find()){
                                            where_at = matcherFVG.group(2);
                                        }


                                    }catch (Exception e){
                                        logger.warning(e.getMessage());
                                    }


                                }

                                if ((incomingSms.contains(CASE15[104]) ||incomingSms.contains(CASE15[108])
                                        || incomingSms.contains(CASE15[105])) &&
                                    changeSender.contains(CASE15[107])){


                                    Matcher matcherP2A = Pattern.compile("\\s("+CASE15[104]+"|"+CASE15[105]+"|"+CASE15[108]+")\\W(.*?)(\\.|\\,|\\-)").matcher(incomingSms);

                                    if (matcherP2A.find()){

                                        where_at = matcherP2A.group(2);
                                    }



                                }


                            }catch (Exception e){
                                logger.warning(e.getMessage());
                            }


                            String[] trx5 = frameworkWords.trx5();

                            blockResult = subClassAttachmentPreview.changeSenderName(where_at, frameworkWords.getStringChangeMerchant(),
                                    blockResult,msg_text,frameworkWords.getStringChangeMerchantCategory(),frameworkWords,
                                    CASE15, trx5, wat4);

                            /*blockResult = changeSenderName(where_at, frameworkWords.getStringChangeMerchant(),
                                    blockResult,msg_text,frameworkWords.getStringChangeMerchantCategory(),frameworkWords,
                                    CASE15);*/
                        }catch (Exception e){
                            logger.warning(e.getMessage());
                        }

                    }else {
                        //String[] wat4 = frameworkWords.wat4();
                        blockResult.setPass_name(where_at.trim());
                        blockResult.setMode_name(wat4[41]);
                        blockResult.setMerchantCategory(wat4[47]);
                    }

                    /*if ((blockResult.getPass_name().equals("") && mode_of_trans.trim().toLowerCase().contains("debited"))){
                        Log.d("djhdsjhjhdfs","--"+msg_text);
                        Matcher matcherON = Pattern.compile("(?i)(^|\\W)on(\\W)").matcher(msg_text);
                        if (matcherON.find()){
                            blockResult.setDictonaryWords(msg_text);
                        }
                    }*/

                    if (!accountNODigitsOnly.isEmpty()) {

                        blockResult.setPass_card_type("");
                    }


                    try {

                        Matcher matcherUPI = Pattern.compile("(?i)"+CASE15[89]+"\\W("+CASE15[90]+"|"+CASE15[91]+"|)(\\W+|)("+account_1[8]+"|"+CASE15[51]+"|)(\\W+|)([A-Z0-9]+\\W|)([0-9]{6,20})").matcher(msg_text);

                        if (matcherUPI.find()){

                            String upiID = matcherUPI.group(6);

                            blockResult.setUpiIDNumber(upiID);

                        }

                    }catch (Exception e){
                        logger.warning(e.getMessage());
                    }


                    if (will_be_case) {

                        blockResult.setPass_output(31);
                    } else if (!act_next) {

                        blockResult.setPass_output(33);
                    } else {
                        blockResult.setPass_output(34);
                    }
                } else {
                    blockResult.setPass_output(0);
                }

            } catch (Exception esd) {
                blockResult.setPass_output(0);
                //Crashlytics.logException(esd.getCause());
            }


            return blockResult;
        }
    }





}

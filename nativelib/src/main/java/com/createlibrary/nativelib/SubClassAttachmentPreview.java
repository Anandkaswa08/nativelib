package com.createlibrary.nativelib;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubClassAttachmentPreview {

    Logger logger = Logger.getLogger("AttachmentPreviewInsight1");



    public String changeIncomingSMS(String incomingSms, String[] account_1,
                                    String[] bal_amt3, String[] wat4, String[] extra10, String[] CASE15,
                                    String[] card_2,String[] bncd8){


        incomingSms = incomingSms.replaceAll("(?i)" + account_1[0], "" + account_1[11] + "");
        incomingSms = incomingSms.replaceAll("(?i)" + account_1[1], "" + account_1[12] + "");
        incomingSms = incomingSms.replaceAll("[" + account_1[13] + "]{4}[-|\\/][" + account_1[13] + "]{2}[-|\\/][" + account_1[13] + "]{2}", "");
        incomingSms = incomingSms.replaceAll("[" + account_1[13] + "]{2}[-|\\/][" + account_1[13] + "]{2}[-|\\/][" + account_1[13] + "]{4}", "");
        incomingSms = incomingSms.replaceAll("(?i)(sb|ca)(\\/|-)[" + account_1[14] + "]{0,4}(\\/|-|)", "XXXX");
        incomingSms = incomingSms.replaceAll("(?i)(" + CASE15[34] + "\\s*" + CASE15[37] + ")", " " + CASE15[35] + " " + CASE15[37] + "");
        incomingSms = incomingSms.replaceAll("(?i)(" + CASE15[33] + "\\s*" + CASE15[37] + ")", " " + CASE15[36] + " " + CASE15[37] + "");
        incomingSms = incomingSms.replaceAll("(?i)(" + CASE15[39] + ")", " " + CASE15[38] + "");
        incomingSms = incomingSms.replaceAll("(?i)" + CASE15[0] + "\\s(" + CASE15[1] + "|" + CASE15[2] + "|" + CASE15[3] + ")", " " + CASE15[4] + "");
        incomingSms = incomingSms.replaceAll("(?i)" + CASE15[49] + "\\s*\\#", "" + CASE15[50] + " " + CASE15[51] + " ");
        incomingSms = incomingSms.replaceAll("(?i)" + CASE15[56] + "\\s*(-|:)", "" + CASE15[56] + " " + CASE15[31] + " ");
        incomingSms = incomingSms.replaceAll("(?i)" + CASE15[0] + "\\s(" + CASE15[1] + "|" + CASE15[2] + "|" + CASE15[3] + ")", " " + CASE15[4] + "");
        incomingSms = incomingSms.replaceAll("(?i)(\\W|^)" + CASE15[60] + "(\\W|)" + CASE15[35] + "\\W", " " + CASE15[61] + " ");
        incomingSms = incomingSms.replaceAll("(?i)" + CASE15[80], "");
        incomingSms = incomingSms.replaceAll("(?i)" + CASE15[8] + "\\s" + CASE15[101] + "\\s" + CASE15[60] + "(\\W|)" + CASE15[35] + "", "" + CASE15[8] + " be " + CASE15[35] + "");
        incomingSms = incomingSms.replaceAll("(?i)"+wat4[37]+"\\/"+CASE15[113]+"","");



        try {
            //Indus Bank Cr with Rs Inr

            Matcher matcherCrWithInr = Pattern.compile("(?i)(\\W)(" + CASE15[33] + ")\\s("+card_2[6]+"\\W(" + CASE15[47] + "|" + CASE15[48] + "))").matcher(incomingSms);

            if (matcherCrWithInr.find()){

                String group = matcherCrWithInr.group();
                String group1 = matcherCrWithInr.group(1);
                String group3 = matcherCrWithInr.group(3);

                incomingSms = incomingSms.replace(group,group1 +" " + CASE15[73] + " "+group3);


            }



        }catch (Exception e){
            logger.warning(e.getMessage());
        }

        try {
            //SBA7788

            Matcher matcherSBA = Pattern.compile("" + CASE15[100] + "(\\d+)").matcher(incomingSms);

            if (matcherSBA.find()){

                String group1 = matcherSBA.group(1);

                incomingSms = incomingSms.replaceAll(matcherSBA.group(),"XXXX"+group1);


            }

        }catch (Exception e){
            logger.warning(e.getMessage());
        }



        // HardcodedFor SBI

        try {

            Matcher matcher = Pattern.compile("(?i)(" + CASE15[81] + "|" + wat4[15] + ")\\s" + CASE15[46] + "\\s*(a\\/c|" + account_1[3] + "|" + account_1[4] + "|" + account_1[5] + "|" + account_1[6] + "|[ |.|-](?<!(" + account_1[2] + "|" + account_1[24] + ")(\\w|\\W){1,3})" + account_1[7] + "|^" + account_1[7] + ")(\\W|\\w){3,20}\\s*" + CASE15[1]).matcher(incomingSms);

            if (matcher.find()){
                String replace_msgText = matcher.group();
                incomingSms = incomingSms.replace(replace_msgText,CASE15[35] + CASE15[58] + " "+replace_msgText);

            }



        }catch (Exception e){
            logger.warning(e.getMessage());
        }

        try {

            Matcher matcher = Pattern.compile("(?i)[\\(]("+CASE15[47]+"|"+CASE15[47]+")[\\)]").matcher(incomingSms);

            if (matcher.find()){
                String replace_msgText = matcher.group();
                String replaceWith = matcher.group(1);
                incomingSms = incomingSms.replace(replace_msgText," "+replaceWith+" ");

            }



        }catch (Exception e){
            logger.warning(e.getMessage());
        }




        try {

            Matcher matcherAvailableCase = Pattern.compile("(?i)(" + CASE15[52] + "|" + CASE15[53] + "|" + CASE15[54] + "|" + CASE15[55] + ")\\s*(" + bal_amt3[2] + "|" + bal_amt3[3] + ")").matcher(incomingSms);
            if (matcherAvailableCase.find()) {

                String founded_match = matcherAvailableCase.group();

                incomingSms = incomingSms.replace(founded_match, CASE15[53] + " " + bal_amt3[1]);


            }
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }



        Matcher matcher_new_case=Pattern.compile("(?i)((" + CASE15[35] + "|" + CASE15[36] + ")ed\\s" + CASE15[43] + "\\s)((xx+|\\*\\*+|\\.\\.+)[0-9]{2,8}\\W)").matcher(incomingSms);
        if (matcher_new_case.find()){

            String founded_match=matcher_new_case.group();
            if (founded_match.length()<30){

                String group1=matcher_new_case.group(1);
                String group3=matcher_new_case.group(3);
                incomingSms =incomingSms.replace(founded_match,group1+" A/c "+group3);

            }
        }

        try {

            // rs .12345
            Matcher matcherRsInr = Pattern.compile("(?i)(" + CASE15[47] + "|" + CASE15[48] + ")(\\W)(\\.)(\\d)").matcher(incomingSms);
            if (matcherRsInr.find()) {

                String found_string = matcherRsInr.group();
                String group1 = matcherRsInr.group(1);
                String group3 = matcherRsInr.group(3);
                String group4 = matcherRsInr.group(4);

                incomingSms = incomingSms.replace(found_string, group1 + "" + group3 + " " + group4);

            }

        }catch (Exception e){
            logger.warning(e.getMessage());
        }


        try {

            // rs.150.00 debited from account xx11123
            Matcher matcherDebitedFrom = Pattern.compile("(?i)((" + CASE15[47] + "|" + CASE15[48] + ")(\\W+|)(\\d+\\.\\d+|\\d+)\\s" + CASE15[35] + "ed)(\\s(a\\/c|" + account_1[3] + "|" + account_1[4] + "|" + account_1[5] + "|" + account_1[6] + "|[ |.|-]" + account_1[7] + "|^" + account_1[7] + ")\\s*((\\.|\\*){2,}|x+|\\s*)\\s*[" + account_1[13] + "\\/]{2,})").matcher(incomingSms);
            if (matcherDebitedFrom.find()) {

                String found_string = matcherDebitedFrom.group();
                String group1 = matcherDebitedFrom.group(1);
                String group5 = matcherDebitedFrom.group(5);
                incomingSms = incomingSms.replace(found_string, group1 + " " + CASE15[46] + "" + group5);

            }

        }catch (Exception e){
            logger.warning(e.getMessage());
        }


        try {

            // credited to bene 01-10-2024
            Matcher matcherDebitedFrom = Pattern.compile("(?i)(" + CASE15[73] + ")\\s(" + CASE15[43] + " " + account_1[2] + ")").matcher(incomingSms);
            if (matcherDebitedFrom.find()) {

                String found_string = matcherDebitedFrom.group();

                String group2 = matcherDebitedFrom.group(2);
                incomingSms = incomingSms.replace(found_string, account_1[27] + " "+ group2);

            }

        }catch (Exception e){
            logger.warning(e.getMessage());
        }


        try {

            // used rs

            Matcher matcher_used = Pattern.compile("(?i)(\\W|^)(" + CASE15[0] + ")\\s*((" + CASE15[47] + "|" + CASE15[48] + ")(\\W+|)\\d+)").matcher(incomingSms);

            if(matcher_used.find()){

                String found_string = matcher_used.group();
                String group1 = matcher_used.group(1);
                String group3 = matcher_used.group(3);
                incomingSms =incomingSms.replace(found_string,group1+"" + CASE15[4] + " "+group3);

            }

        }catch (Exception e){
            logger.warning(e.getMessage());
        }


        try {

            // used rs

            Matcher matcher_used = Pattern.compile("(?i)(\\W|^)(" + bal_amt3[2] + "|" + bal_amt3[3] + ")\\s*" + CASE15[59] + "\\s*((" + CASE15[47] + "|" + CASE15[48] + ")(\\W+|)\\d+)").matcher(incomingSms);

            if(matcher_used.find()){

                String found_string = matcher_used.group();

                String group1 = matcher_used.group(1);
                String group3 = matcher_used.group(3);
                incomingSms =incomingSms.replace(found_string,group1+"" + CASE15[4] + " "+group3);


            }



        }catch (Exception e){
            logger.warning(e.getMessage());
        }

        try {

            // kotak received

            Matcher matcher_used = Pattern.compile("(?i)^(" + CASE15[84] + "\\s*|)(" + CASE15[82] + ")(\\W+(" + CASE15[47] + "|" + CASE15[48] + ")(\\W+|)[0-9,\\.]+\\s*(" + CASE15[2] + "\\s(\\W|\\w){8,15}|)\\s*" + CASE15[42] + ")").matcher(incomingSms);

            if(matcher_used.find()){

                String found_string = matcher_used.group();
                String group3 = matcher_used.group(3);
                incomingSms =incomingSms.replace(found_string,  CASE15[73] +group3);
            }

        }catch (Exception e){
            logger.warning(e.getMessage());
        }

        try {

            // kotak sent

            Matcher matcher_used = Pattern.compile("(?i)^(" + CASE15[59] + ")(\\s*(" + CASE15[47] + "|" + CASE15[48] + ")(\\W+|)[0-9,\\.]+\\s*" + CASE15[46] + ")").matcher(incomingSms);

            if(matcher_used.find()){

                String found_string = matcher_used.group();
                String group2 = matcher_used.group(2);
                incomingSms =incomingSms.replace(found_string,  CASE15[4] +group2);
            }

        }catch (Exception e){
            logger.warning(e.getMessage());
        }


        try {

            // Imps Rs70000 sent from

            Matcher matcher_used = Pattern.compile("(?i)^("+CASE15[81]+"\\s*(" + CASE15[47] + "|" + CASE15[48] + ")(\\W+|)[0-9,\\.]+)[\\W\\_]+(" + CASE15[59] + "\\s" + CASE15[46] + ")").matcher(incomingSms);

            if(matcher_used.find()){

                String found_string = matcher_used.group();
                String group1 = matcher_used.group(1);
                //String group4 = matcher_used.group(4);
                incomingSms =incomingSms.replace(found_string,  group1 + " "+CASE15[35]+"" + CASE15[58] + " " + CASE15[46] + "");
            }

        }catch (Exception e){
            logger.warning(e.getMessage());
        }

        try {

            // Mr. Anand

            Matcher matcher_used = Pattern.compile("(?i)(\\W|^)(" + CASE15[62] + "|" + CASE15[63] + "|" + CASE15[64] + "|" + CASE15[34] + "|m\\/s)\\.(\\W|\\w)").matcher(incomingSms);

            if(matcher_used.find()){

                String found_string = matcher_used.group();

                String group1 = matcher_used.group(1);
                String group2 = matcher_used.group(2);
                group2 = group2.replaceAll("\\W","");
                String group3 = matcher_used.group(3);
                incomingSms =incomingSms.replaceAll("(?i)"+found_string,group1+group2+group3);

            }

        }catch (Exception e){
            logger.warning(e.getMessage());
        }

        try {
            // Has a credit by
            Matcher matcher_used = Pattern.compile("(?i)(\\W|^)(" + CASE15[6] + "\\s" + CASE15[72] + "\\s" + CASE15[36] + "\\s" + CASE15[57] +")").matcher(incomingSms);

            if(matcher_used.find()){

                String found_string = matcher_used.group();

                String group1 = matcher_used.group(1);
                //String group2 = matcher_used.group(2);

                incomingSms =incomingSms.replaceAll("(?i)"+found_string,group1 + "" + CASE15[73] + " " + CASE15[57]);
                incomingSms =incomingSms.replaceAll("(?i)" + CASE15[71] + "\\W",CASE15[71] + " ");

            }

        }catch (Exception e){
            logger.warning(e.getMessage());
        }

        try {
            // remove false INR

            //Rs.Inr Off.
            Matcher matcherRsOff = Pattern.compile("(?i)(\\W|^)(" + CASE15[47] + "|" + CASE15[48] + ")(\\W+|)[0-9,.]+" + CASE15[74]).matcher(incomingSms);

            while (matcherRsOff.find()) {

                String found_string = matcherRsOff.group();

                incomingSms = incomingSms.replaceAll("(?i)" + found_string, " ");



            }


            //Upto Rs. 1200
            Matcher matcherUpToRs = Pattern.compile("(?i)(\\W|^)" + CASE15[75] + "(\\W+|)" + CASE15[43] + "\\W(" + CASE15[47] + "|" + CASE15[48] + ")(\\W+|)[0-9,.]+").matcher(incomingSms);

            while (matcherUpToRs.find()) {

                String found_string = matcherUpToRs.group();

                incomingSms = incomingSms.replaceAll("(?i)" + found_string, " ");

            }

            //Voucher Worth Rs 100
            Matcher matcherVoucher = Pattern.compile("(?i)(\\W|^)" + CASE15[76] + "\\W+" + CASE15[77] + "\\W(" + CASE15[47] + "|" + CASE15[48] + ")(\\W+|)[0-9,.]+").matcher(incomingSms);

            while (matcherVoucher.find()) {

                String found_string = matcherVoucher.group();

                incomingSms = incomingSms.replaceAll("(?i)" + found_string, " ");

            }

            //enjoy Rs500 , get rs 500
            Matcher matcherEnjoyGet = Pattern.compile("(?i)(\\W|^)(" + CASE15[78] + "|" + CASE15[79] + ")\\W+(" + CASE15[72] + "\\W|)(" + CASE15[47] + "|" + CASE15[48] + ")(\\W+|)[0-9,.]+").matcher(incomingSms);

            while (matcherEnjoyGet.find()) {

                String found_string = matcherEnjoyGet.group();

                incomingSms = incomingSms.replaceAll("(?i)" + found_string, " ");

            }



        } catch (Exception e) {
            logger.warning(e.getMessage());
        }


        try {
            //Credit card account

            Matcher matcherCreditCardAccount = Pattern.compile("(?i)("+CASE15[36]+"(\\W+|)"+CASE15[37]+")\\s(a\\/c|" + account_1[3] + "|" + account_1[4] + "|" + account_1[5] + "|" + account_1[6] + "|" + account_1[7] + ")").matcher(incomingSms);
            while (matcherCreditCardAccount.find()){

                String findGroup = matcherCreditCardAccount.group();
                String findGroup1 = matcherCreditCardAccount.group(1);
                incomingSms = incomingSms.replaceAll("(?i)" + findGroup, findGroup1);
            }

        }catch (Exception e){
            logger.warning(e.getMessage());
        }


        try {
            //HSBC Credit account

            Matcher matcherHsbc = Pattern.compile("(?i)"+extra10[92]+"\\s(\\W|\\w){2,15}\\s([0-9\\-]+)+([\\*\\-0-9]+)").matcher(incomingSms);

            if (matcherHsbc.find()){

                String group2 = matcherHsbc.group(2);
                String group3 = matcherHsbc.group(3);

                String group22 = group2.replaceAll("\\W","");
                String group33 = group3.replaceAll("\\-","*");

                incomingSms = incomingSms.replace(group2,group22);
                incomingSms = incomingSms.replace(group3,group33);

            }



        }catch (Exception e){
            logger.warning(e.getMessage());
        }


        try {
            //SuperCard 2276

            Matcher matcherHsbc = Pattern.compile("(?i)("+extra10[93]+")\\s*("+CASE15[37]+")\\s([0-9]+)").matcher(incomingSms);

            if (matcherHsbc.find()){
                String group = matcherHsbc.group();
                String group2 = matcherHsbc.group(2);
                String group3 = matcherHsbc.group(3);

                incomingSms = incomingSms.replace(group,""+CASE15[36]+" "+group2+" "+group3);

            }

        }catch (Exception e){
            logger.warning(e.getMessage());
        }


        try {
            // You are eligible

            incomingSms = incomingSms.replaceAll("(?i)(\\W|^)" + extra10[44] + "\\.", " "+bal_amt3[6]+ "");
            incomingSms = incomingSms.replaceAll("(?i)" + extra10[45] + "\\.", bal_amt3[7]+ "");

            String myMessageToDelete = incomingSms;
            String[] spiltSentence = myMessageToDelete.split("\\.(?!\\d)|(?<!\\d)\\.");

            for (String sentence : spiltSentence) {

                Matcher matcher = Pattern.compile("(?i)" + CASE15[95] + "(\\w|\\W){1,4}\\s*(" + extra10[5] + "|" + extra10[6] + ")").matcher(sentence);

                if (matcher.find()) {

                    incomingSms = incomingSms.replaceAll("(?i)"+sentence,"");


                }

            }
        }catch (Exception e){
            logger.warning(e.getMessage());
        }

        try{

            String myMessageToDelete = incomingSms;
            String[] spiltSentence = myMessageToDelete.split("\\.(?!\\d)|(?<!\\d)\\.");

            for (String sentence : spiltSentence) {

                Matcher matcher = Pattern.compile("(?i)(" + CASE15[94] + "(|d)|" + CASE15[93] + "|" + CASE15[21] + ")(\\w|\\W){1,10}\\s*(" + CASE15[36] + "|)(" + bal_amt3[10] + "|" + account_1[22] + ")").matcher(sentence);

                if (matcher.find()) {

                    incomingSms = incomingSms.replaceAll("(?i)"+sentence,"");

                }

            }
        }catch (Exception e){
            logger.warning(e.getMessage());
        }

        try {
            //Loan,wallet Limit

            Matcher matcherLoanLimit = Pattern.compile("(?i)("+account_1[17]+"|"+account_1[26]+"|" + CASE15[94] + "(|d))\\W+("+bal_amt3[10]+"|"+account_1[22]+")").matcher(incomingSms);

            while (matcherLoanLimit.find()){

                String found_string = matcherLoanLimit.group();

                incomingSms = incomingSms.replaceAll("(?i)" + found_string, " ");

            }
        }catch (Exception e){
            logger.warning(e.getMessage());
        }

        try {
            //EMI OF RS INR

            Matcher matcherEmiOf = Pattern.compile("(?i)"+CASE15[41]+"\\s"+CASE15[31]+"\\s("+CASE15[47]+"|"+CASE15[48]+")(\\W+|)[0-9,\\.]+").matcher(incomingSms);

            while (matcherEmiOf.find()){

                String found_string = matcherEmiOf.group();

                incomingSms = incomingSms.replaceAll("(?i)" + found_string, " ");

            }
        }catch (Exception e){
            logger.warning(e.getMessage());
        }


        try {
            //Credit:Rs

            Matcher creditOf = Pattern.compile("(?i)" + CASE15[36] + "\\s*:\\s*(" + CASE15[47] + "|" + CASE15[48] + ")").matcher(incomingSms);

            while (creditOf.find()) {

                String found_string = creditOf.group();
                String group1 = creditOf.group(1);

                incomingSms = incomingSms.replaceAll("(?i)" + found_string, CASE15[36] + " " +CASE15[31] +" "+group1);

            }
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }


        try {
            //Credit balance of Rs.5585

            Matcher creditBalanceOf = Pattern.compile("(?i)" + CASE15[36] + "\\s("+bal_amt3[0]+"|"+bal_amt3[1]+")(\\W+|)"+bal_amt3[9]+"\\s(" + CASE15[47] + "|" + CASE15[48] + ")\\W+(\\d+\\.\\d+|\\d+)").matcher(incomingSms);

            while (creditBalanceOf.find()) {

                String found_string = creditBalanceOf.group();

                incomingSms = incomingSms.replaceAll("(?i)" + found_string, " ");

            }
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }



        try {
            //InfoAch*

            Matcher infoAch = Pattern.compile("(?i)(\\W)("+wat4[24]+")\\s*("+wat4[49]+"|"+wat4[50]+"|"+wat4[51]+"|"+wat4[52]+"|"+wat4[15]+"|"+wat4[53]+"|"+wat4[54]+"|"+wat4[55]+"|"+wat4[56]+"|"+wat4[16]+"|"+wat4[57]+"|"+wat4[58]+"|"+wat4[59]+"|"+wat4[60]+")(\\W)").matcher(incomingSms);

            while (infoAch.find()) {

                String found_string = infoAch.group();
                String group1 = infoAch.group(1);
                String group2 = infoAch.group(2);
                String group3 = infoAch.group(3);
                String group4 = infoAch.group(4);

                incomingSms = incomingSms.replaceAll("(?i)" + found_string, group1+""+group2+":"+group3+""+group4);

            }
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }

        try {
            //InfoAch*

            Matcher infoAch = Pattern.compile("(\\W)((?i)" + wat4[24] + ")\\s*([A-Z]{3})(\\*)").matcher(incomingSms);

            while (infoAch.find()) {

                String found_string = infoAch.group();
                String group1 = infoAch.group(1);
                String group2 = infoAch.group(2);
                String group3 = infoAch.group(3);
                String group4 = infoAch.group(4);

                incomingSms = incomingSms.replaceAll("(?i)" + found_string, group1 + "" + group2 + ":" + group3 + "" + group4);

            }
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }

        try {
            //Info -
            Matcher infoAch = Pattern.compile("(?i)(\\W)" + wat4[24] + "\\s*\\-").matcher(incomingSms);

            while (infoAch.find()) {

                String found_string = infoAch.group();
                String group1 = infoAch.group(1);
                incomingSms = incomingSms.replaceAll("(?i)" + found_string, group1 + "" + wat4[24] + ":");

            }
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }


        try {

            // If you have not authorized

            Matcher matcherAuthorized = Pattern.compile("(?i)" + CASE15[120] + "(\\syou\\s" + extra10[9] + "|)\\s(" + CASE15[13] + "|" + CASE15[14] + "|" + CASE15[15] + "(\\'|)t|" + CASE15[16] + "(\\'|)t|" + CASE15[17] + "(\\'|)t|" + CASE15[18] + "(\\'|)t|" + CASE15[19] + ")\\s*(-|)\\s*(" + CASE15[20] + "|)\\s*(" + CASE15[21] + "|" + CASE15[22] + "|" + CASE15[12] + ")").matcher(incomingSms);

            if (matcherAuthorized.find()){

                incomingSms = incomingSms.replaceAll(matcherAuthorized.group(), " ");


            }



        }catch (Exception e){
            logger.warning(e.getMessage());
        }


        return incomingSms;
    }



    public BlockResult changeSenderName(String where_at, String[] stringChangeMerchant, BlockResult blockResult,
                                        String messageText, String[] stringChangeMerchantCategory, FrameworkWords frameworkWords,
                                        String[] CASE15, String[] trx5,String[] wat4) {


        String merchantCategory = "";


        try {
            if (where_at.isEmpty() || where_at.equalsIgnoreCase(trx5[0])){

                //reversal of txn
                Matcher matcherReversal = Pattern.compile("(?i)"+trx5[28]+"\\s"+trx5[12]+"\\s("+trx5[4]+"|"+trx5[0]+")").matcher(messageText);

                if (matcherReversal.find()){

                    where_at = ""+trx5[27]+" "+trx5[28]+"";
                }



            }
        }catch (Exception e){
            logger.warning(e.getMessage());
        }

        try {
            if (where_at.isEmpty()){

                //VPS*
                Matcher matcherVPS = Pattern.compile("("+wat4[61]+"|"+wat4[62]+")\\*(.*?)\\.").matcher(messageText);

                if (matcherVPS.find()){

                    where_at = matcherVPS.group(2).trim();
                }
            }
        }catch (Exception e){
            logger.warning(e.getMessage());
        }
        try {
            if (where_at.isEmpty()){

                //LPG SUBSIDY
                Matcher matcherVPS = Pattern.compile("(?i)"+stringChangeMerchant[180]+"\\s*"+stringChangeMerchant[181]+"").matcher(messageText);

                if (matcherVPS.find()){

                    where_at = ""+stringChangeMerchant[180]+" "+stringChangeMerchant[181]+"";
                }
            }
        }catch (Exception e){
            logger.warning(e.getMessage());
        }


        try {
            if (where_at.isEmpty()){

                //Auto Debit
                Matcher matcherVPS = Pattern.compile("(?i)"+trx5[18]+"\\s"+CASE15[60]+"(\\W+|)"+CASE15[35]+"").matcher(messageText);

                if (matcherVPS.find()){

                    where_at = ""+stringChangeMerchant[162]+"";
                }
            }
        }catch (Exception e){
            logger.warning(e.getMessage());
        }



        try {
            if (where_at.isEmpty()){

                //spent @ dream
                Matcher matcherSpentAt = Pattern.compile("(?i)"+stringChangeMerchant[182]+"\\s@\\s*(.*?)"+trx5[15]+"").matcher(messageText);

                if (matcherSpentAt.find()){
                    where_at = matcherSpentAt.group(1);
                }

            }
        }catch (Exception e){
            logger.warning(e.getMessage());
        }


        try {
            if (where_at.isEmpty()){

                if (blockResult.getMode_name().equalsIgnoreCase(CASE15[71])){
                    where_at = CASE15[71];
                    merchantCategory = stringChangeMerchantCategory[12];
                    blockResult.setMerchantCategory(merchantCategory);
                }

            }
        }catch (Exception e){
            logger.warning(e.getMessage());
        }


        try {

            Matcher matcherCredPay = Pattern.compile("(?i)("+stringChangeMerchant[30]+"\\s*"+stringChangeMerchant[123]+")\\s(.*?)$").matcher(where_at);

            if (matcherCredPay.find()){

                where_at = matcherCredPay.group(2);
            }



        }catch (Exception e){
            logger.warning(e.getMessage());
        }

        try {
            if (where_at.isEmpty()) {
                if (blockResult.getAmount_int_status() == 2 && blockResult.getPass_card_type().contains(CASE15[37])) {
                    Matcher matcherThroughCCBill = Pattern.compile("(?i)" + wat4[66] + "\\s(" + CASE15[118] + "|" + stringChangeMerchant[42] + "\\s*" + stringChangeMerchant[195] + "\\s*" + stringChangeMerchant[201] + ")").matcher(messageText);
                    if (matcherThroughCCBill.find()) {
                        where_at = stringChangeMerchantCategory[17];
                        merchantCategory = stringChangeMerchantCategory[17];

                        blockResult.setMerchantCategory(merchantCategory);
                        blockResult.setPass_name(where_at.trim());
                        return blockResult;
                    }
                }

            }
        }catch (Exception e){
            logger.warning(e.getMessage());
        }



        String actualWhereAt = where_at;
        try {

            if (where_at.isEmpty()){
                return blockResult;
            }

            actualWhereAt = where_at;
            where_at = where_at.replaceAll("(?i)^"+stringChangeMerchant[68]+"\\W","");

            String whereAtLowercase = where_at.toLowerCase();

            Matcher removeAfterStar = Pattern.compile("^[a-zA-Z]+(\\*|_)\\d{4}").matcher(where_at);
            if (removeAfterStar.find()){

                where_at = where_at.replaceAll("(\\*|_)\\d+", "");

            }

            if (whereAtLowercase.contains(stringChangeMerchant[40])){
                where_at = stringChangeMerchant[41];
            }
            if (whereAtLowercase.contains(""+stringChangeMerchant[183].toLowerCase())){
                where_at = ""+stringChangeMerchant[183]+"";
                merchantCategory = "Income";
            }

            Matcher matcherCreditCard = Pattern.compile("(?i)"+CASE15[36]+""+CASE15[37]).matcher(where_at);
            if (matcherCreditCard.find()){

                String group = matcherCreditCard.group();
                where_at = where_at.replace(group, CASE15[36]+" "+CASE15[37]);

            }



            where_at = where_at.replaceAll("^[a-zA-Z]+(\\*|_)", "");


            Matcher matcherRemoveDigit =Pattern.compile("\\*[0-9]+$").matcher(where_at);
            if (matcherRemoveDigit.find()){

                String tempDigit = matcherRemoveDigit.group();

                where_at = where_at.replaceAll("\\*[0-9]+$", "");

                if (where_at.isEmpty()){
                    where_at = tempDigit;
                }

            }

            try {
                if (where_at.toUpperCase().contains(stringChangeMerchant[307])) {

                    String VEHREG11 = frameworkWords.VEHREG11();

                    Matcher match222 = Pattern.compile("(?i)(\\W|^)((" + VEHREG11 + ")(\\s*|-)([0-9]{1,2})(\\s*|-)([a-zA-Z]{1,3})(\\s*|-)([0-9]{1,4}))(\\W|$)").matcher(where_at);

                    if (match222.find()) {

                        where_at = stringChangeMerchant[229] + " - " + match222.group(2);

                    }else {
                        where_at = stringChangeMerchant[229];
                    }



                }

            }catch (Exception e){
                logger.warning(e.getMessage());
            }

            try {
                Matcher medicalStore = Pattern.compile("(?i)(\\w+)("+stringChangeMerchant[264]+")(\\w+|)").matcher(where_at);

                if (medicalStore.find()){

                    String group = medicalStore.group();
                    String group1 = medicalStore.group(1);
                    String group2 = medicalStore.group(2);
                    String group3 = medicalStore.group(3);

                    where_at = where_at.replaceAll(group, group1 +" "+group2+ " "+group3);

                }

            }catch (Exception e){
                logger.warning(e.getMessage());
            }

            try {
                Matcher matcherICICILom = Pattern.compile("(?i)"+CASE15[67]+"(\\W+|)"+stringChangeMerchant[243]+"").matcher(where_at);

                if (matcherICICILom.find()){

                    where_at = ""+CASE15[67]+" "+stringChangeMerchant[242]+"";
                    merchantCategory = stringChangeMerchantCategory[11];

                }

                Matcher matcherRelianceRetail = Pattern.compile("(?i)"+stringChangeMerchant[15]+"(\\W+|)"+stringChangeMerchant[241]+"").matcher(where_at);
                if (matcherRelianceRetail.find()){

                    where_at = ""+stringChangeMerchant[15]+" "+stringChangeMerchant[240]+"";
                    merchantCategory = stringChangeMerchantCategory[3];

                }

                if (whereAtLowercase.contains(""+stringChangeMerchant[237]+"")|| whereAtLowercase.contains(""+stringChangeMerchant[238]+"")){

                    Matcher matcherCCA = Pattern.compile("(?i)("+stringChangeMerchant[237]+"|"+stringChangeMerchant[238]+")(\\W+|)[0-9]{4}").matcher(messageText);

                    if (matcherCCA.find()){
                        where_at = stringChangeMerchantCategory[12];
                        merchantCategory = stringChangeMerchantCategory[12];
                    }

                }

                if (whereAtLowercase.contains(stringChangeMerchant[26])) {


                    Matcher matcherPayu = Pattern.compile("(?i)(^"+stringChangeMerchant[26]+")(\\w+)").matcher(where_at);

                    if (matcherPayu.find()){

                        String group = matcherPayu.group();
                        String group1 = matcherPayu.group(1);
                        String group2 = matcherPayu.group(2);

                        where_at = where_at.replaceAll(group,group1 +" "+group2);

                    }


                }


            }catch (Exception e){
                logger.warning(e.getMessage());
            }


            where_at = where_at.trim();
            where_at = where_at.replaceAll("(\\.|\\(|\\)|\\-)$", "");
            where_at = where_at.replaceAll("^\\W", "");
            where_at = where_at.replaceAll("\\/$", "");
            where_at = where_at.replaceAll("(?i)"+stringChangeMerchant[109]+"(\\W|$)", stringChangeMerchant[110]+" ");
            where_at = where_at.replaceAll(""+stringChangeMerchant[174]+"(\\W+|)$", "").trim();
            where_at = where_at.replaceAll(""+stringChangeMerchant[175]+"(\\W+|)\\s*$", "").trim();
            where_at = where_at.replaceAll("(?i)"+stringChangeMerchant[24]+"\\s*"+stringChangeMerchant[25]+"", "").trim();
            where_at = where_at.replaceAll("(?i)"+stringChangeMerchant[24]+"(\\w+|)\\s*$", "").trim();
            where_at = where_at.replaceAll("(?i)"+stringChangeMerchant[26]+"(\\w+|)\\s*$", ""+stringChangeMerchant[235]+"").trim();
            where_at = where_at.replaceAll("(?i)"+stringChangeMerchant[184]+"(\\w+|)\\s*$", ""+stringChangeMerchant[185]+"").trim();
            where_at = where_at.replaceAll("(?i)"+stringChangeMerchant[186]+"(\\w+|)\\s*$", ""+stringChangeMerchant[187]+"").trim();
            where_at = where_at.replaceAll("(?i)"+stringChangeMerchant[188]+"(\\w+|)\\s*$", stringChangeMerchant[102]).trim();
            //where_at = where_at.replaceAll("(?i)^"+stringChangeMerchant[189]+"\\s", "").trim();
            where_at = where_at.replaceAll("\\W"+stringChangeMerchant[222]+"$", " "+stringChangeMerchant[223]+" "+stringChangeMerchant[224]+"").trim();
            where_at = where_at.replaceAll("(?i)\\W"+stringChangeMerchant[226]+"(\\w+|)$", " "+stringChangeMerchant[225]+"").trim();
            where_at = where_at.replaceAll("(?i)\\W"+stringChangeMerchant[280]+"(\\w+|)$", " ").trim();
            where_at = where_at.replaceAll("(?i)\\W"+stringChangeMerchant[281]+"$", " ").trim();
            where_at = where_at.replaceAll("(?i)\\W\\("+wat4[41]+"$", " ").trim();
            where_at = where_at.replaceAll("(?i)\\W\\("+stringChangeMerchant[206]+"$", " ").trim();
            where_at = where_at.replaceAll("^"+CASE15[110] , CASE15[110]+" ");
            where_at = where_at.replaceAll("(?i)\\/(\\w+)\\s"+CASE15[109]+"(\\w+|)$" , " ").trim();
            where_at = where_at.replaceAll("(?i)\\/"+CASE15[68]+"[\\sa-zA-Z]+$" , " ").trim();
            where_at = where_at.replaceAll("(?i)\\W"+stringChangeMerchant[297]+"[a-zA-Z]+$" , " "+stringChangeMerchant[296]+"").trim();
            where_at = where_at.replaceAll("(?i)\\W"+stringChangeMerchant[295]+"[a-zA-Z]+$" , " "+stringChangeMerchantCategory[21]).trim();
            where_at = where_at.replaceAll("(?i)\\W"+stringChangeMerchant[294]+"[a-zA-Z]+$" , " "+stringChangeMerchant[27]).trim();
            where_at = where_at.replaceAll("(?i)\\W"+stringChangeMerchant[293]+"$" , " "+stringChangeMerchant[229].toUpperCase()).trim();
            where_at = where_at.replaceAll("(?i)\\/(("+stringChangeMerchant[316]+"|"+stringChangeMerchant[317]+")[a-zA-Z0-9]+)$" , "");

            Matcher matcherDeleteLast = Pattern.compile("[a-zA-z0-9]{2,}\\W([A-Z](\\W|)$)").matcher(where_at);

            if (matcherDeleteLast.find()){
                String group2 = matcherDeleteLast.group(1);
                //if (!group2.toLowerCase().contains("qr")) {
                //Log.d("AAAVVVV", "Last---" + where_at + "-- " + group2);
                where_at = where_at.replaceAll(group2+"$", "").trim();
                //}
            }

            Matcher matcherUPIWithName = Pattern.compile("(?i)^("+stringChangeMerchant[159]+")(\\w+)").matcher(where_at);

            if (matcherUPIWithName.find()){
                String group1 = matcherUPIWithName.group(1);
                String group2 = matcherUPIWithName.group(2);
                where_at = where_at.replaceAll(matcherUPIWithName.group(), group1+" "+group2);

            }


            try {
                Matcher matcherRecharge = Pattern.compile("(?i)("+stringChangeMerchant[190]+")\\W+("+stringChangeMerchant[191]+"|"+stringChangeMerchant[192]+"|"+stringChangeMerchant[193]+"|"+CASE15[29]+")").matcher(where_at);

                if (matcherRecharge.find()){
                    merchantCategory = stringChangeMerchantCategory[7];
                }

                Matcher matcherHindustan = Pattern.compile("(?i)("+stringChangeMerchant[194]+")(\\w+)").matcher(where_at);

                if (matcherHindustan.find()){

                    String group = matcherHindustan.group();
                    String group1 = matcherHindustan.group(1);
                    String group2 = matcherHindustan.group(2);

                    where_at = where_at.replaceAll(group, group1+" "+group2);


                }


                Matcher matcherBillJunction = Pattern.compile("(?i)("+stringChangeMerchant[195]+")(\\W+|)"+stringChangeMerchant[197]+"\\w+").matcher(where_at);

                if (matcherBillJunction.find()){
                    where_at = where_at.replaceAll("(?i)"+matcherBillJunction.group(),""+stringChangeMerchant[195]+" "+stringChangeMerchant[196]+"");
                }



                Matcher matcherPhonePeCard = Pattern.compile("(?i)"+stringChangeMerchant[198]+"").matcher(where_at);

                if (matcherPhonePeCard.find()){
                    where_at = ""+stringChangeMerchant[199]+" "+stringChangeMerchant[200]+" "+stringChangeMerchant[201]+"";
                }

                Matcher matcherAmazonGrocery = Pattern.compile("(?i)"+stringChangeMerchant[71]+"(\\W+|)"+stringChangeMerchant[203]+"").matcher(where_at);

                if (matcherAmazonGrocery.find()){
                    where_at = ""+stringChangeMerchant[74]+" "+stringChangeMerchant[202]+"";
                    merchantCategory = stringChangeMerchantCategory[20];
                }


                Matcher matcherFoundation = Pattern.compile("(?i)(\\w+)"+stringChangeMerchant[185]+"(\\w+|)").matcher(where_at);

                if (matcherFoundation.find()){

                    String group1 = matcherFoundation.group(1);
                    String group2 = matcherFoundation.group(2);

                    where_at = where_at.replaceAll(matcherFoundation.group(),group1+" "+stringChangeMerchant[185]+" "+group2);

                }

                Matcher matcherIRCTC = Pattern.compile("(?i)"+stringChangeMerchant[204]+"\\s*"+stringChangeMerchant[205]+"").matcher(where_at);

                if (matcherIRCTC.find()){

                    where_at = stringChangeMerchant[41];
                    merchantCategory = stringChangeMerchantCategory[1];

                }

                Matcher matcherRemoveAnd = Pattern.compile("\\W"+stringChangeMerchant[206]+"\\W").matcher(where_at);

                if (matcherRemoveAnd.find()){

                    where_at = where_at.replaceAll(matcherRemoveAnd.group()," ");

                }

                Matcher matcherGooglePayment = Pattern.compile("(?i)"+stringChangeMerchant[208]+"(\\W+|)"+stringChangeMerchant[207]+"(\\w+|)").matcher(where_at);

                if (matcherGooglePayment.find()){

                    where_at = where_at.replaceAll(matcherGooglePayment.group()," "+stringChangeMerchant[244]+" "+stringChangeMerchant[201]);

                }

                Matcher matcherCredClub = Pattern.compile("(?i)"+stringChangeMerchant[30]+"(\\W+|)("+stringChangeMerchant[209]+"|"+stringChangeMerchant[210]+"|"+stringChangeMerchant[211]+"|"+stringChangeMerchant[212]+"|"+stringChangeMerchant[213]+"|"+stringChangeMerchant[214]+")").matcher(where_at);

                if (matcherCredClub.find()){

                    where_at =stringChangeMerchant[30];

                }

                Matcher matcherAnnualMain = Pattern.compile("(?i)"+stringChangeMerchant[215]+"(\\W+|)"+stringChangeMerchant[216]+"").matcher(where_at);

                if (matcherAnnualMain.find()){

                    where_at = ""+stringChangeMerchant[215]+" "+stringChangeMerchant[216]+"";

                }

                Matcher matcherBlinkIt = Pattern.compile("(?i)"+stringChangeMerchant[236]+"(\\W+|)"+stringChangeMerchant[90]+"").matcher(where_at);

                if (matcherBlinkIt.find()){

                    where_at = stringChangeMerchant[221];
                    merchantCategory = ""+stringChangeMerchant[217]+" "+stringChangeMerchant[202]+"";

                }


                if (merchantCategory.isEmpty()) {

                    Matcher matcherKisanConnect = Pattern.compile("(?i)"+stringChangeMerchant[277]+"(\\W+|)(c|K)"+stringChangeMerchant[279]+"").matcher(where_at);

                    if (matcherKisanConnect.find()) {

                        where_at = ""+stringChangeMerchant[277]+" "+stringChangeMerchant[278]+"";
                        merchantCategory = "" + stringChangeMerchant[217] + " " + stringChangeMerchant[202] + "";

                    }
                }

                if (merchantCategory.isEmpty()) {
                    Matcher matcherAxisSecurities = Pattern.compile("(?i)" + stringChangeMerchant[253] + "\\s*" + stringChangeMerchant[254] + "").matcher(where_at);

                    if (matcherAxisSecurities.find()) {

                        merchantCategory = stringChangeMerchantCategory[21];
                    }
                }

                if (merchantCategory.isEmpty()){

                    Matcher matcherAxisSecurities = Pattern.compile("(?i)" + stringChangeMerchant[254]).matcher(where_at);

                    if (matcherAxisSecurities.find()) {

                        merchantCategory = stringChangeMerchantCategory[21];
                    }
                }



                Matcher matcherStandingInstruction = Pattern.compile("(?i)"+stringChangeMerchant[255]+"\\s*("+stringChangeMerchant[256]+"|"+stringChangeMerchant[257]+")").matcher(where_at);

                if (matcherStandingInstruction.find()){
                    where_at = stringChangeMerchantCategory[14];
                    merchantCategory = stringChangeMerchantCategory[14];
                }

                Matcher matcherAutoDebit = Pattern.compile("(?i)"+CASE15[60]+"(\\W+|)("+CASE15[35]+"|"+stringChangeMerchant[276]+")").matcher(where_at);

                if (matcherAutoDebit.find()){
                    merchantCategory = stringChangeMerchantCategory[14];
                }

                Matcher matcherThroughMandate = Pattern.compile("(?i)(\\W+)("+CASE15[61]+"\\s"+CASE15[46]+")").matcher(where_at);

                if (matcherThroughMandate.find()){
                    where_at = ""+CASE15[60]+" "+CASE15[35];
                    merchantCategory = stringChangeMerchantCategory[14];
                }


            }catch (Exception e){
                logger.warning(e.getMessage());
            }

            Matcher matcherReplaceDigits = Pattern.compile("^[A-WY-Z]+(\\d{4,})").matcher(where_at);

            if (matcherReplaceDigits.find()){

                String group1 = matcherReplaceDigits.group(1);
                if (group1!= null) {
                    where_at = where_at.replaceAll(group1, " ");
                }
            }

            //where_at = where_at.replaceAll("\\W$", "");

            if (where_at.matches(".*\\/.*\\/.*")) {
                if (!where_at.matches(".*\\/[0-9]+$.*")) {

                    Matcher matcher = Pattern.compile("(?i)[a-zA-Z0-9]+\\/").matcher(where_at);

                    while (matcher.find()) {

                        where_at = where_at.replace(matcher.group(), "").trim();
                        //return where_at;
                    }
                }
            }

            try {
                if (where_at.matches(".*\\*.*\\*.*")) {
                    if (!where_at.matches(".*\\*[0-9]+$.*")) {

                        Matcher matcher = Pattern.compile("(?i)[a-zA-Z0-9]+\\*").matcher(where_at);

                        while (matcher.find()) {

                            where_at = where_at.replace(matcher.group(), "").trim();
                            //return where_at;
                        }
                    }
                }
            }catch (Exception r){
                logger.warning(r.getMessage());
            }

            Matcher matcher = Pattern.compile("(?i)\\s("+stringChangeMerchant[0]+"|"+stringChangeMerchant[1]+"|"+stringChangeMerchant[2]+"|"+stringChangeMerchant[57]+")\\s").matcher(where_at);
            while (matcher.find()){

                String matcherFound = matcher.group();
                if (!matcherFound.contains(stringChangeMerchant[3].toUpperCase())) {
                    where_at = where_at.substring(0, matcher.start());
                }

            }

            Matcher matcher1 = Pattern.compile("(?i)(^|\\W)("+stringChangeMerchant[3]+"|"+stringChangeMerchant[4]+"|"+stringChangeMerchant[5]+"" +
                    "|"+stringChangeMerchant[6]+"|"+stringChangeMerchant[7]+"|"+stringChangeMerchant[8]+"|"+stringChangeMerchant[9]+"|"+stringChangeMerchant[10]+"" +
                    "|"+stringChangeMerchant[11]+"|"+stringChangeMerchant[12]+"|"+stringChangeMerchant[13]+")(\\W)").matcher(where_at);
            while (matcher1.find()){
                where_at = where_at.replaceAll(matcher1.group()," ");
            }

            Matcher matcher2 = Pattern.compile("(?i)(^|\\W)("+stringChangeMerchant[3]+"|"+stringChangeMerchant[4]+"|"+stringChangeMerchant[5]+"" +
                    "|"+stringChangeMerchant[6]+"|"+stringChangeMerchant[7]+"|"+stringChangeMerchant[8]+"|"+stringChangeMerchant[9]+"|"+stringChangeMerchant[10]+"" +
                    "|"+stringChangeMerchant[11]+"|"+stringChangeMerchant[12]+"|"+stringChangeMerchant[13]+")(\\W)").matcher(where_at);
            while (matcher2.find()){
                where_at = where_at.replaceAll(matcher2.group()," ");
            }

            Matcher matcherTataPayments = Pattern.compile("(?i)("+stringChangeMerchant[292]+")\\s*("+stringChangeMerchant[201]+"(s|))").matcher(where_at);

            if (matcherTataPayments.find()){

                String group = matcherTataPayments.group();
                String group1 = matcherTataPayments.group(1);
                String group2 = matcherTataPayments.group(2);

                where_at = where_at.replaceAll(group, group1+" "+group2+" ");

            }

            where_at = where_at.trim();
            Matcher matcherRemoveUPI = Pattern.compile("(?i)(^"+CASE15[89]+"\\W)(\\w+)").matcher(where_at);
            if (matcherRemoveUPI.find()){

                String group1 = matcherRemoveUPI.group(1);
                //String group = matcherRemoveUPI.group();

                if (group1 != null) {
                    where_at = where_at.replaceAll("(?i)^"+group1, "");
                }
            }



            where_at = where_at.replaceAll("(?i)"+stringChangeMerchant[14]+"(\\w+|)",""+stringChangeMerchant[15]+"");
            where_at = where_at.replaceAll("(?i)"+stringChangeMerchant[16]+"(\\w+|)",""+stringChangeMerchant[17]+"");
            where_at = where_at.replaceAll("(?i)"+stringChangeMerchant[18]+"(\\w+|)",""+stringChangeMerchant[19]+"");
            where_at = where_at.replaceAll("(?i)"+stringChangeMerchant[20]+"(\\w+|)",""+stringChangeMerchant[21]+"");
            where_at = where_at.replaceAll("(?i)"+stringChangeMerchant[22]+"(\\w+|)",""+stringChangeMerchant[23]+"");


            Matcher matcherAmazonPay = Pattern.compile("(?i)("+stringChangeMerchant[71]+"(\\W+|)"+stringChangeMerchant[123]+")(\\w+)").matcher(where_at);

            if (matcherAmazonPay.find()) {

                String group1 = matcherAmazonPay.group(1);
                String group3 = matcherAmazonPay.group(3);

                where_at = where_at.replaceAll(matcherAmazonPay.group(), group1 + " " + group3);

                if (group3!= null) {
                    if (group3.toLowerCase().contains(stringChangeMerchant[169])) {
                        merchantCategory = stringChangeMerchant[170];
                    }
                }
            }

            Matcher matcherAmazonBillPay = Pattern.compile("(?i)("+stringChangeMerchant[71]+"(\\W+|)"+stringChangeMerchant[195]+"(\\W+|)"+stringChangeMerchant[123]+")").matcher(where_at);

            if (matcherAmazonBillPay.find()) {

                merchantCategory = stringChangeMerchantCategory[7];
            }


            whereAtLowercase = where_at.toLowerCase();
            if (where_at.startsWith("_")) {

                where_at = where_at.replaceAll("_", "");
            }
            if (whereAtLowercase.matches(".*"+stringChangeMerchant[24]+"\\W+"+stringChangeMerchant[25]+".*")) {

                where_at = where_at.replaceAll("(?i)"+stringChangeMerchant[24]+"\\W+"+stringChangeMerchant[25], "");
            }
            if (whereAtLowercase.contains(stringChangeMerchant[26])) {

                where_at = where_at.replaceAll("(?i)\\W+"+stringChangeMerchant[26], "");
            }

            where_at = where_at.trim();

            where_at = where_at.replaceAll("(?i)("+stringChangeMerchant[25]+"|"+stringChangeMerchant[27]+")$", "").trim();
            where_at = where_at.replaceAll("(?i)("+stringChangeMerchant[24]+"|"+stringChangeMerchant[171]+"\\w+)$", "").trim();


            where_at = where_at.trim();
            whereAtLowercase = where_at.toLowerCase();
            if (whereAtLowercase.contains(stringChangeMerchant[28])) {// +" "+stringChangeMerchant[29]
                where_at = stringChangeMerchant[30];
            }else if (whereAtLowercase.contains(stringChangeMerchant[31])) {
                where_at = stringChangeMerchant[32];
            }else if (whereAtLowercase.matches("(?i).*"+stringChangeMerchant[33]+"(\\W+|)"+stringChangeMerchant[34]+".*")) {
                where_at = stringChangeMerchant[35];
            }else if (whereAtLowercase.contains(stringChangeMerchant[36])) {
                where_at = stringChangeMerchant[37];
                merchantCategory = stringChangeMerchantCategory[0];

            }else if (whereAtLowercase.contains(stringChangeMerchant[38])) {
                where_at = stringChangeMerchant[39];
            }else if (whereAtLowercase.contains(stringChangeMerchant[40])) {
                where_at = stringChangeMerchant[41];
                merchantCategory = stringChangeMerchantCategory[1];
            }else if (whereAtLowercase.contains(stringChangeMerchant[42]+" "+stringChangeMerchant[43])) {
                where_at = stringChangeMerchant[44];
                merchantCategory = stringChangeMerchantCategory[2];

            }else if (whereAtLowercase.contains(stringChangeMerchant[45])) {
                where_at = stringChangeMerchant[46];
                merchantCategory = stringChangeMerchantCategory[3];
            }else if (whereAtLowercase.contains(stringChangeMerchant[47]) ||
                    whereAtLowercase.contains(stringChangeMerchant[111])) {
                where_at = stringChangeMerchant[48];
                merchantCategory = stringChangeMerchantCategory[4];
            }else if (whereAtLowercase.contains(stringChangeMerchant[49])) {
                where_at = stringChangeMerchant[50];
                merchantCategory = stringChangeMerchantCategory[5];
            }else if (whereAtLowercase.contains(stringChangeMerchant[51])) {
                where_at = stringChangeMerchant[52];
                merchantCategory = stringChangeMerchantCategory[6];
            }else if (whereAtLowercase.contains(stringChangeMerchant[53])) {
                where_at = stringChangeMerchant[54];
                merchantCategory = stringChangeMerchantCategory[1];

            }else if (whereAtLowercase.contains(stringChangeMerchant[55])) {
                where_at = stringChangeMerchant[56];
                merchantCategory = stringChangeMerchantCategory[7];
            }else if (whereAtLowercase.contains(stringChangeMerchant[33]+" "+stringChangeMerchant[58])) {
                where_at = stringChangeMerchant[59];
            }else if (whereAtLowercase.contains(stringChangeMerchant[60])) {
                where_at = stringChangeMerchant[61];
                merchantCategory = stringChangeMerchantCategory[8];

            }else if (whereAtLowercase.contains(stringChangeMerchant[62])) {
                where_at = stringChangeMerchant[63];
            }else if (whereAtLowercase.contains(stringChangeMerchant[64])) {
                where_at = stringChangeMerchant[65];
                merchantCategory = stringChangeMerchantCategory[9];
            }else if (whereAtLowercase.contains(stringChangeMerchant[66])) {
                where_at = stringChangeMerchant[67];
                merchantCategory = stringChangeMerchantCategory[6];
            }else if (whereAtLowercase.contains(stringChangeMerchant[68]+" "+stringChangeMerchant[69])) {
                where_at = stringChangeMerchant[70];
                merchantCategory = stringChangeMerchantCategory[7];
            }else if (whereAtLowercase.contains(stringChangeMerchant[71]+" "+stringChangeMerchant[72])
                    ||whereAtLowercase.contains(stringChangeMerchant[71]+""+stringChangeMerchant[72])) {
                where_at = stringChangeMerchant[73]+" - "+stringChangeMerchant[74];
                merchantCategory = stringChangeMerchantCategory[7];
            }else if (whereAtLowercase.contains(stringChangeMerchant[71]+""+stringChangeMerchant[160]+"") ||
                    whereAtLowercase.contains(stringChangeMerchant[71]+" "+stringChangeMerchant[160]+"")) {
                where_at = stringChangeMerchant[74];
            }else if (whereAtLowercase.contains(stringChangeMerchant[75])) {
                where_at = stringChangeMerchant[76];
                merchantCategory = stringChangeMerchantCategory[3];
            }else if (whereAtLowercase.contains(stringChangeMerchant[77])) {
                where_at = stringChangeMerchant[78];
                merchantCategory = stringChangeMerchantCategory[4];
            }else if (whereAtLowercase.contains(stringChangeMerchant[79])) {
                where_at = stringChangeMerchant[80];
            }else if (whereAtLowercase.contains(stringChangeMerchant[81])) {
                where_at = stringChangeMerchant[82];
                merchantCategory = stringChangeMerchantCategory[3];
            }else if (whereAtLowercase.contains(stringChangeMerchant[112]+" "+stringChangeMerchant[113])) {
                where_at = stringChangeMerchant[114];
                merchantCategory = stringChangeMerchantCategory[9];
            }else if (whereAtLowercase.contains(stringChangeMerchant[115].toLowerCase())) {
                where_at = stringChangeMerchant[115];
                merchantCategory = stringChangeMerchantCategory[3];
            }
            else if (whereAtLowercase.matches(".*(?i)"+stringChangeMerchant[114]+"\\s*"+CASE15[69]+".*")) {
                where_at = stringChangeMerchant[114] +" "+stringChangeMerchant[300]+"";
                merchantCategory = stringChangeMerchantCategory[67];
            }else if (whereAtLowercase.matches(".*(?i)"+stringChangeMerchant[83]+".*")) {
                where_at = stringChangeMerchant[84];
                merchantCategory = stringChangeMerchantCategory[10];
            }else if (whereAtLowercase.matches(".*(?i)"+stringChangeMerchant[85]+".*")) {
                where_at = stringChangeMerchant[86];
            }else if (whereAtLowercase.matches(".*(?i)"+stringChangeMerchant[87]+".*")) {
                where_at = stringChangeMerchant[88];
            }else if (whereAtLowercase.matches(".*(?i)"+stringChangeMerchant[89]+"\\W+"+stringChangeMerchant[90]+".*")) {
                where_at = stringChangeMerchant[89]+" "+stringChangeMerchant[91];
            }else if (whereAtLowercase.matches(".*(?i)"+stringChangeMerchant[93]+"\\W("+stringChangeMerchant[94]+"|"+stringChangeMerchant[95]+")(\\W"+stringChangeMerchant[96]+"|).*")) {
                where_at = stringChangeMerchant[92];
            }else if (whereAtLowercase.matches(".*(?i)"+stringChangeMerchant[92]+"\\W\\w+.*")) {
                where_at = stringChangeMerchant[92];
                merchantCategory = stringChangeMerchantCategory[9];
            }else if (whereAtLowercase.matches(".*(?i)"+stringChangeMerchant[97]+"\\W("+stringChangeMerchant[98]+"|"+stringChangeMerchant[99]+").*")) {
                where_at = stringChangeMerchant[97]+" "+stringChangeMerchant[102];
                merchantCategory = stringChangeMerchantCategory[11];
            }else if (whereAtLowercase.matches(".*(?i)"+stringChangeMerchant[100]+"\\W"+stringChangeMerchant[101]+"\\W"+stringChangeMerchant[99]+".*")) {
                where_at = stringChangeMerchant[100]+" "+stringChangeMerchant[101]+" "+stringChangeMerchant[102];
                merchantCategory = stringChangeMerchantCategory[11];
            }else if (whereAtLowercase.matches(".*(?i)"+stringChangeMerchant[103]+"(\\.|)("+stringChangeMerchant[104]+"|)\\W[a-zA-Z].*")) {
                where_at = where_at.replaceAll("(?i)"+stringChangeMerchant[103]+"(\\.|)("+stringChangeMerchant[104]+"|)","");
            }else if (whereAtLowercase.matches(".*(?i)"+stringChangeMerchant[105]+"(\\W+|)[0-9].*")) {
                where_at = stringChangeMerchant[105]+" "+stringChangeMerchant[106];
            }else if (whereAtLowercase.matches(".*(?i)"+stringChangeMerchant[70]+"[0-9].*")) {
                where_at = stringChangeMerchant[70];
                merchantCategory = stringChangeMerchantCategory[7];
            }else if (whereAtLowercase.matches(".*(?i)"+stringChangeMerchant[163]+"(\\W+|)"+stringChangeMerchant[164]+".*")) {
                where_at = stringChangeMerchant[70];
                merchantCategory = stringChangeMerchantCategory[7];
            }else if (whereAtLowercase.matches(".*(?i)"+stringChangeMerchant[69]+"(\\W+|)"+stringChangeMerchant[7]+".*")) {
                where_at = stringChangeMerchant[70];
                merchantCategory = stringChangeMerchantCategory[7];
            }else if (whereAtLowercase.matches(".*(?i)"+stringChangeMerchant[107]+"(\\W+|)"+stringChangeMerchant[12]+".*")) {
                where_at = stringChangeMerchant[107]+" "+stringChangeMerchant[108];
                merchantCategory = stringChangeMerchantCategory[6];
            }else if (whereAtLowercase.matches(".*(?i)"+stringChangeMerchant[116]+"\\W"+stringChangeMerchant[117]+".*")) {
                where_at = stringChangeMerchant[67];
                merchantCategory = stringChangeMerchantCategory[6];
            }else if (whereAtLowercase.matches(".*(?i)("+stringChangeMerchant[118]+"|"+stringChangeMerchant[119]+").*")) {
                where_at = ""+stringChangeMerchant[122];

            }else if (whereAtLowercase.matches(".*(?i)"+stringChangeMerchant[120]+"(\\W+|)"+stringChangeMerchant[121]+".*")) {
                where_at = ""+stringChangeMerchant[120]+" "+stringChangeMerchant[121]+"";
                merchantCategory = stringChangeMerchantCategory[12];
            }else if (whereAtLowercase.matches(".*(?i)("+stringChangeMerchant[154]+"(\\W|)"+stringChangeMerchant[155]+"(\\W|)"+stringChangeMerchant[156]+"(\\W|)"+stringChangeMerchant[157]+"(\\W|)"+stringChangeMerchant[158]+").*")) {
                where_at = ""+stringChangeMerchant[153]+"";
                merchantCategory = stringChangeMerchantCategory[1];
            }else if (whereAtLowercase.matches(".*(?i)("+stringChangeMerchant[133]+"|"+stringChangeMerchant[134]+"|"+stringChangeMerchant[135]+"(\\W+|)"+stringChangeMerchant[136]+"|"+stringChangeMerchant[137]+").*")) {
                //where_at = stringChangeMerchant[67];
                merchantCategory = stringChangeMerchantCategory[13];
            }else if (whereAtLowercase.matches(".*(?i)"+stringChangeMerchant[24]+"\\s*$")) {
                where_at = where_at.replaceAll("(?i)\\W+"+stringChangeMerchant[24]+"\\s*$", "").trim();
            }else if (whereAtLowercase.contains(""+stringChangeMerchant[161]+"")) {
                where_at = stringChangeMerchant[162];
                merchantCategory = stringChangeMerchantCategory[14];
            }else if (whereAtLowercase.contains(""+stringChangeMerchant[138]) ||
                    whereAtLowercase.contains(""+stringChangeMerchant[139].toLowerCase())) {
                where_at = stringChangeMerchant[139];
                merchantCategory = stringChangeMerchantCategory[3];
            }else if (whereAtLowercase.contains(""+stringChangeMerchant[140]+"")) {
                where_at = stringChangeMerchant[141];
                merchantCategory = stringChangeMerchantCategory[9];
            }else if (whereAtLowercase.contains(""+stringChangeMerchant[142]+"")) {
                where_at = ""+stringChangeMerchant[143]+"";
            }else if (whereAtLowercase.contains(""+stringChangeMerchant[144]+"")) {
                where_at = ""+stringChangeMerchant[145]+"";
                merchantCategory = stringChangeMerchantCategory[3];
            }else if (whereAtLowercase.contains(""+stringChangeMerchant[146]+"")) {
                where_at = ""+stringChangeMerchant[147]+"";
                merchantCategory = stringChangeMerchantCategory[3];
            }else if (whereAtLowercase.contains(""+stringChangeMerchant[148]+"")) {
                where_at = ""+stringChangeMerchant[149]+"";
                merchantCategory = stringChangeMerchantCategory[7];
            }else if (whereAtLowercase.contains(""+stringChangeMerchant[150]+"")) {
                where_at = ""+stringChangeMerchant[151]+"";
                merchantCategory = stringChangeMerchantCategory[7];
            }else if (whereAtLowercase.contains(""+stringChangeMerchant[176]+"")) {
                merchantCategory = ""+stringChangeMerchant[177]+"";
            }else if (whereAtLowercase.contains(stringChangeMerchant[178])) {
                where_at = stringChangeMerchant[179];
                merchantCategory = ""+stringChangeMerchant[217]+" "+stringChangeMerchant[202]+"";
            }else if (whereAtLowercase.contains(""+stringChangeMerchant[218].toLowerCase())) {
                where_at = ""+stringChangeMerchant[218]+"";
                merchantCategory = stringChangeMerchantCategory[21];
            }else if (whereAtLowercase.contains(""+stringChangeMerchant[219].toLowerCase())) {
                where_at = ""+stringChangeMerchant[219]+"";
                merchantCategory = stringChangeMerchantCategory[21];
            }else if (whereAtLowercase.contains(""+stringChangeMerchant[220].toLowerCase())) {
                where_at = ""+stringChangeMerchant[220]+"";
                merchantCategory = stringChangeMerchantCategory[21];
            }else if (whereAtLowercase.contains(""+stringChangeMerchant[221].toLowerCase())) {
                where_at = ""+stringChangeMerchant[221]+"";
                merchantCategory = ""+stringChangeMerchant[217]+" "+stringChangeMerchant[202]+"";
            }else if (whereAtLowercase.contains(wat4[13]) || whereAtLowercase.contains(wat4[11])) {
                String cash = wat4[13];
                merchantCategory = cash.substring(0,1).toUpperCase() + cash.substring(1).toLowerCase();
            }else if (whereAtLowercase.contains(""+stringChangeMerchant[234]+"")) {
                merchantCategory = stringChangeMerchantCategory[9];
            }else if (whereAtLowercase.matches(".*(?i)"+stringChangeMerchant[231]+"(\\W+|)"+stringChangeMerchant[232]+".*")) {
                where_at = ""+stringChangeMerchant[231]+" "+stringChangeMerchant[233]+"";
                merchantCategory = stringChangeMerchantCategory[20];
            }else if (whereAtLowercase.equals(""+stringChangeMerchant[230]+"")) {
                merchantCategory = stringChangeMerchantCategory[31];
            }else if (whereAtLowercase.contains(""+stringChangeMerchant[229]+"")) {
                merchantCategory = stringChangeMerchantCategory[0];
            }else if (whereAtLowercase.contains(""+stringChangeMerchant[228].toLowerCase()+"")) {
                where_at = ""+stringChangeMerchant[228]+"";
            }else if (whereAtLowercase.contains(""+stringChangeMerchant[258].toLowerCase()+"")) {
                where_at = ""+stringChangeMerchant[258]+"";
                merchantCategory = stringChangeMerchantCategory[9];
            }else if (whereAtLowercase.contains(""+stringChangeMerchant[259].toLowerCase()+"")) {
                where_at = ""+stringChangeMerchant[259]+"";
                merchantCategory = stringChangeMerchantCategory[4];
            }else if (whereAtLowercase.contains(""+stringChangeMerchant[261].toLowerCase()+"")) {
                where_at = ""+stringChangeMerchant[260]+" + "+stringChangeMerchant[261]+"";
                merchantCategory = stringChangeMerchantCategory[10];
            }else if (whereAtLowercase.contains(""+stringChangeMerchant[263]+"")) {
                where_at = ""+stringChangeMerchant[262]+" "+stringChangeMerchant[101]+" "+stringChangeMerchant[102]+"";
                merchantCategory = stringChangeMerchantCategory[11];
            }else if (whereAtLowercase.contains(""+stringChangeMerchant[262].toLowerCase()+" "+stringChangeMerchant[101].toLowerCase())) {
                where_at = stringChangeMerchant[262]+" "+stringChangeMerchant[101]+" "+stringChangeMerchant[102];
                merchantCategory = stringChangeMerchantCategory[11];
            }else if (whereAtLowercase.contains(""+stringChangeMerchant[291]+"")) {
                merchantCategory = stringChangeMerchantCategory[22];
            }else if (whereAtLowercase.contains(""+stringChangeMerchant[290]+"")) {
                merchantCategory = stringChangeMerchantCategory[5];
            }else if (whereAtLowercase.matches(".*(?i)"+stringChangeMerchant[289]+"\\s*"+stringChangeMerchant[128]+".*")) {
                merchantCategory = stringChangeMerchantCategory[11];
            }else if (whereAtLowercase.matches(".*(?i)\\W"+stringChangeMerchant[288]+".*")) {
                merchantCategory = stringChangeMerchantCategory[29];
            }else if (whereAtLowercase.matches(".*(?i)\\w+\\W"+CASE15[60]+".*")) {
                merchantCategory = stringChangeMerchantCategory[0];
            }else if (whereAtLowercase.matches(".*(?i)"+stringChangeMerchant[287]+"\\s*"+stringChangeMerchant[286]+".*")) {
                where_at = ""+stringChangeMerchant[287]+" "+stringChangeMerchant[286]+"";
            }else if (whereAtLowercase.contains(stringChangeMerchant[298])) {
                merchantCategory = stringChangeMerchantCategory[20];
            }else if (whereAtLowercase.matches(".*(?i).*"+stringChangeMerchant[301]+"\\s*"+stringChangeMerchant[302]+"")) {
                where_at = ""+stringChangeMerchant[299]+"";
                merchantCategory = stringChangeMerchantCategory[28];
            }else if (whereAtLowercase.matches(".*(?i).*"+stringChangeMerchant[300]+"")) {
                where_at = stringChangeMerchant[114] +" "+stringChangeMerchant[300]+"";
                merchantCategory = stringChangeMerchantCategory[67];
            }else if (whereAtLowercase.matches(".*(?i)"+stringChangeMerchant[303]+"\\s*"+stringChangeMerchant[304]+".*")) {
                merchantCategory = stringChangeMerchantCategory[67];
            }else if (whereAtLowercase.matches(".*(?i)"+stringChangeMerchant[308]+"\\s*"+stringChangeMerchant[128]+".*")) {
                merchantCategory = stringChangeMerchantCategory[2];
            }else if (whereAtLowercase.matches(".*(?i)("+stringChangeMerchant[309]+"|"+stringChangeMerchant[310]+"(\\w+|))(\\W+|)"+stringChangeMerchant[311]+".*")) {
                merchantCategory = stringChangeMerchantCategory[21];
            }else if (whereAtLowercase.contains(" "+stringChangeMerchant[311])) {
                merchantCategory = stringChangeMerchantCategory[20];
            }else if (whereAtLowercase.contains(stringChangeMerchant[312])) {
                where_at = stringChangeMerchant[313];
            }else if (whereAtLowercase.matches(".*(?i)("+stringChangeMerchant[314]+"\\s*"+stringChangeMerchant[315]+"\\s*("+stringChangeMerchant[222]+"|"+stringChangeMerchant[223]+"\\s*f)).*")) {

                where_at = ""+stringChangeMerchant[314]+" "+stringChangeMerchant[315]+" "+stringChangeMerchant[222]+"";
                merchantCategory = stringChangeMerchantCategory[21];
            }

            if (whereAtLowercase.equalsIgnoreCase(stringChangeMerchant[89])){
                where_at = stringChangeMerchant[89]+" "+stringChangeMerchant[91];

            }

            if (merchantCategory.isEmpty()){

                String getStringChangeMerchantCategoryInvestment= frameworkWords.getStringChangeMerchantCategoryInvestment();
                //NUVAMA|INVESTMENT|NATIONAL\s*PEN
                //NUVAMA|INVESTMENT|NATIONAL\s*PEN|dsp|div\s*\d
                Matcher matcherInvestment = Pattern.compile("(?i)("+getStringChangeMerchantCategoryInvestment+")").matcher(where_at);

                if (matcherInvestment.find()){
                    merchantCategory = stringChangeMerchantCategory[21];
                }
            }

            if (merchantCategory.isEmpty()){

                String getStringChangeMerchantCategoryHospital= frameworkWords.getStringChangeMerchantCategoryHospital();
                //Columbia\s*as
                Matcher matcherHospital = Pattern.compile("(?i)("+getStringChangeMerchantCategoryHospital+")").matcher(where_at);

                if (matcherHospital.find()){
                    merchantCategory = stringChangeMerchantCategory[6];
                }
            }

            if (merchantCategory.isEmpty()){

                String getStringChangeMerchantCategoryTransportation = frameworkWords.getStringChangeMerchantCategoryTransportation();
                //confirm\s*(tkt|tick)|honda|automob|motors|BLU\s*SMART|park\s*plus
                Matcher matcherTransportation = Pattern.compile("(?i)("+getStringChangeMerchantCategoryTransportation+")").matcher(where_at);

                if (matcherTransportation.find()){
                    merchantCategory = stringChangeMerchantCategory[0];
                }
            }


            if (merchantCategory.isEmpty()){
                try{
                    Matcher matcherICCL = Pattern.compile("(?i)"+stringChangeMerchant[204]+"(\\W+|)"+wat4[45]+"(\\W+|)C").matcher(where_at);

                    if (matcherICCL.find()){

                        where_at = stringChangeMerchant[282];
                        merchantCategory = stringChangeMerchantCategory[21];


                    }


                }catch (Exception e){
                    logger.warning(e.getMessage());
                }


            }

            if (whereAtLowercase.matches(".*(?i)("+stringChangeMerchant[124]+"|"+stringChangeMerchant[125]+"|"+stringChangeMerchant[126]+"|"+stringChangeMerchant[127]+"|"+stringChangeMerchant[26]+"(\\W|)("+stringChangeMerchant[128]+"|"+stringChangeMerchant[90]+")|"+stringChangeMerchant[129]+"|"+stringChangeMerchant[130]+"|"+stringChangeMerchant[131]+"|"+stringChangeMerchant[132]+"|"+stringChangeMerchant[284]+").*")) {
                //where_at = stringChangeMerchant[67];
                if (merchantCategory.isEmpty()) {
                    merchantCategory = stringChangeMerchantCategory[12];
                }

                try {
                    //
                    Matcher matcherRazorPay = Pattern.compile("(?i)^("+stringChangeMerchant[124]+"|"+stringChangeMerchant[125]+"|"+stringChangeMerchant[126]+"|"+stringChangeMerchant[127]+"|"+stringChangeMerchant[26]+"(\\W|)("+stringChangeMerchant[128]+"|"+stringChangeMerchant[90]+")|"+stringChangeMerchant[129]+"|"+stringChangeMerchant[130]+"|"+stringChangeMerchant[131]+"|"+stringChangeMerchant[132]+"\\s*"+stringChangeMerchant[285]+"|"+stringChangeMerchant[132]+"|"+stringChangeMerchant[284]+")(\\W+|)\\w+").matcher(where_at);

                    if (matcherRazorPay.find()){

                        String group1 = matcherRazorPay.group(1);

                        where_at = where_at.replaceAll("(?i)"+group1,"");

                        if (where_at.length() < 4){
                            where_at = stringChangeMerchantCategory[12];
                        }


                    }else {

                        Matcher matcherRazorPay1 = Pattern.compile("(?i)\\W("+stringChangeMerchant[124]+"|"+stringChangeMerchant[125]+"|"+stringChangeMerchant[126]+"|"+stringChangeMerchant[127]+"|"+stringChangeMerchant[26]+"(\\W|)("+stringChangeMerchant[128]+"|"+stringChangeMerchant[90]+")|"+stringChangeMerchant[129]+"|"+stringChangeMerchant[130]+"|"+stringChangeMerchant[131]+"|"+stringChangeMerchant[132]+"\\s*"+stringChangeMerchant[285]+"|"+stringChangeMerchant[132]+"|"+stringChangeMerchant[284]+")$").matcher(where_at);

                        if (matcherRazorPay1.find()){

                            String group1 = matcherRazorPay1.group(1);

                            where_at = where_at.replaceAll("(?i)"+group1,"");

                            if (where_at.length() < 4){
                                where_at = stringChangeMerchantCategory[12];
                            }


                        }

                    }


                }catch (Exception e){
                    logger.warning(e.getMessage());
                }


            }

            where_at = where_at.replaceAll("(?i)"+stringChangeMerchant[152]+"","");

            if (merchantCategory.isEmpty()){

                Matcher matcherHealthcare = Pattern.compile("(?i)("+stringChangeMerchant[245]+"|"+stringChangeMerchant[246]+"|"+stringChangeMerchant[247]+"|"+stringChangeMerchant[248]+"|"+stringChangeMerchant[249]+")").matcher(where_at);

                if (matcherHealthcare.find()){

                    merchantCategory = stringChangeMerchantCategory[6];
                }

            }


            try {
                String tempWhereAt = where_at;
                where_at = where_at.replaceAll("(?i)x+\\d+","");

                if (where_at.trim().isEmpty()){
                    where_at = tempWhereAt;
                }

            }catch (Exception e){
                logger.warning(e.getMessage());
            }
            where_at = where_at.replaceAll("(?i)\\W"+stringChangeMerchant[131]+"","");


            if (merchantCategory.isEmpty() || merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){

                String getStringMerchantCategoryEleUtilityBill = frameworkWords.getStringMerchantCategoryEleUtilityBill();
                Matcher matcherElectricity = Pattern.compile("(?i)"+getStringMerchantCategoryEleUtilityBill).matcher(where_at);
                if (matcherElectricity.find()){
                    merchantCategory = stringChangeMerchantCategory[7];
                }else {

                    String getStringChangeMerchantCategoryUtilityBill = frameworkWords.getStringChangeMerchantCategoryUtilityBill();
                    Matcher matcherUtilityBill = Pattern.compile("(?i)"+getStringChangeMerchantCategoryUtilityBill).matcher(where_at);
                    if (matcherUtilityBill.find()){
                        merchantCategory = stringChangeMerchantCategory[7];
                    }

                }


            }


            if (merchantCategory.isEmpty() || merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){

                Matcher matcherMerchantPay = Pattern.compile("(?i)("+stringChangeMerchant[165]+"|"+stringChangeMerchant[166]+"\\s*"+stringChangeMerchant[106]+"|"+stringChangeMerchant[121]+"\\sq)").matcher(where_at);

                if (matcherMerchantPay.find()){

                    merchantCategory = stringChangeMerchantCategory[12];

                }


            }

            if (merchantCategory.isEmpty() || merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){

                if (whereAtLowercase.contains(CASE15[71].toLowerCase())){


                    where_at = where_at.replaceAll("(?i)^"+CASE15[71],"");

                    merchantCategory = stringChangeMerchantCategory[13];
                }


            }

            if (merchantCategory.isEmpty() || merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){

                //loan
                Matcher matcherLoan = Pattern.compile("(?i)"+CASE15[121]+"\\s*"+CASE15[122]+"").matcher(where_at);

                if (matcherLoan.find()){

                    merchantCategory = stringChangeMerchantCategory[24];
                }


            }


            if (merchantCategory.isEmpty() || merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){

                Matcher mutualFund = Pattern.compile("(?i)"+stringChangeMerchant[223]+"\\W"+stringChangeMerchant[275]+"(\\w+|)").matcher(where_at);
                if (mutualFund.find()){
                    where_at = where_at.replaceAll(mutualFund.group(),""+stringChangeMerchant[223]+" "+stringChangeMerchant[224]+"");
                    merchantCategory = stringChangeMerchantCategory[21];
                }

            }

            if (merchantCategory.isEmpty() || merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){

                if (whereAtLowercase.matches(".*(?i)(^|\\W)"+stringChangeMerchant[239]+".*")){
                    merchantCategory = stringChangeMerchantCategory[9];
                }

            }
            if (merchantCategory.isEmpty() || merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){

                if (where_at.equalsIgnoreCase(stringChangeMerchantCategory[12])){
                    merchantCategory = stringChangeMerchantCategory[12];
                }

            }

            if (merchantCategory.isEmpty() || merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){

                Matcher matcherTRTR = Pattern.compile("^(?i)("+stringChangeMerchant[250]+"|"+stringChangeMerchant[251]+")(\\w+|)").matcher(where_at);
                if (matcherTRTR.find()){

                    String group = matcherTRTR.group();
                    String group1 = matcherTRTR.group(1);
                    String group2 = matcherTRTR.group(2);

                    if (!group2.trim().isEmpty()) {
                        where_at = where_at.replaceAll(group, group1 + " " + group2);
                    }
                    merchantCategory = stringChangeMerchantCategory[13];

                }

            }
            if (merchantCategory.isEmpty() || merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){

                Matcher matcherTRTR = Pattern.compile("(?i)"+stringChangeMerchant[252]+"(\\W|$)").matcher(where_at);
                if (matcherTRTR.find()){

                    merchantCategory = stringChangeMerchantCategory[21];

                }

            }


            if (merchantCategory.isEmpty() || merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){

                try {

                    Matcher matcherPlanGrowth = Pattern.compile("(?i)("+stringChangeMerchant[265]+"\\s*"+stringChangeMerchant[224]+"|"+stringChangeMerchant[224]+"\\s*"+stringChangeMerchant[266]+"|"+stringChangeMerchant[266]+"\\s*"+stringChangeMerchant[267]+")").matcher(where_at);

                    if (matcherPlanGrowth.find()){
                        merchantCategory = stringChangeMerchantCategory[21];
                    }

                }catch (Exception e){
                    logger.warning(e.getMessage());
                }


            }
            if (merchantCategory.isEmpty() || merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){

                if (whereAtLowercase.contains(""+stringChangeMerchant[268]+"")){
                    merchantCategory = stringChangeMerchantCategory[9];
                }

                if (merchantCategory.isEmpty() || merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){

                    Matcher matcherLifestyle = Pattern.compile("(?i)"+stringChangeMerchant[101]+"(\\W+|)("+stringChangeMerchant[269]+"|"+stringChangeMerchant[270]+")").matcher(where_at);

                    if (matcherLifestyle.find()){
                        where_at = stringChangeMerchantCategory[23];
                        merchantCategory = stringChangeMerchantCategory[3];
                    }

                }

            }

            if (merchantCategory.isEmpty() || merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){

                Matcher matcherInsurance = Pattern.compile("(?i)"+stringChangeMerchant[271]+"\\s*"+stringChangeMerchant[34]+"\\s*"+stringChangeMerchant[272]+"").matcher(where_at);

                if (matcherInsurance.find()){
                    merchantCategory = stringChangeMerchantCategory[11];
                }

            }
            if (merchantCategory.isEmpty() || merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){

                Matcher matcherMetro = Pattern.compile("(?i)\\w+\\s*"+stringChangeMerchant[273]+"").matcher(where_at);

                if (matcherMetro.find()){
                    merchantCategory = stringChangeMerchantCategory[0];
                }

            }

            if (whereAtLowercase.contains(stringChangeMerchant[274].toLowerCase())){

                if (merchantCategory.isEmpty() ||
                        merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){
                    where_at = stringChangeMerchant[274];
                    merchantCategory = stringChangeMerchantCategory[7];
                }
            }

            if (where_at.contains(stringChangeMerchant[89])) {

                where_at = stringChangeMerchant[166];
                if (merchantCategory.isEmpty()) {
                    merchantCategory = stringChangeMerchantCategory[12];

                }
            }


            if (merchantCategory.isEmpty() || merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){


                Matcher matcherYourBillPayment = Pattern.compile("(?i)"+stringChangeMerchant[189]+"(.*?)"+CASE15[36]+"\\s*"+CASE15[37]+"").matcher(where_at);

                if (matcherYourBillPayment.find()){
                    where_at = stringChangeMerchantCategory[17];
                    merchantCategory = stringChangeMerchantCategory[17];
                }


                if (merchantCategory.isEmpty() || merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){

                    Matcher matcherCCBillPayment = Pattern.compile("(?i)"+CASE15[36]+"\\s*"+CASE15[37]+"\\s*"+stringChangeMerchant[195]+"").matcher(where_at);

                    if (matcherCCBillPayment.find()){
                        merchantCategory = stringChangeMerchantCategory[17];
                    }

                }

                if (merchantCategory.isEmpty() || merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){
                    Matcher matcherCCBillEnding = Pattern.compile("(?i)"+CASE15[36]+"\\s*"+CASE15[37]+"\\s"+stringChangeMerchant[283]+".*?[0-9]").matcher(where_at);
                    if (matcherCCBillEnding.find()){
                        merchantCategory = stringChangeMerchantCategory[17];
                    }
                }
            }




        } catch (Exception e) {
            logger.warning(e.getMessage());
        }


        try {
            //AllCombinedCategory

            if (merchantCategory.isEmpty() || merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){

                String getStringChangeMerchantCategoryFood = frameworkWords.getStringChangeMerchantCategoryFood();//DINING
                Matcher matcherFood = Pattern.compile("(?i)("+getStringChangeMerchantCategoryFood+")").matcher(where_at);

                if (matcherFood.find()){

                    merchantCategory = stringChangeMerchantCategory[9];
                }


                if (merchantCategory.isEmpty() || merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){

                    String getStringChangeMerchantCategoryShopping= frameworkWords.getStringChangeMerchantCategoryShopping();

                    Matcher matcherShopping = Pattern.compile("(?i)("+getStringChangeMerchantCategoryShopping+")").matcher(where_at);

                    if (matcherShopping.find()){

                        merchantCategory = stringChangeMerchantCategory[3];
                    }
                }

                if (merchantCategory.isEmpty() || merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){

                    String getStringChangeMerchantCategoryTravel= frameworkWords.getStringChangeMerchantCategoryTravel();
                    Matcher matcherTollPlaza = Pattern.compile("(?i)("+getStringChangeMerchantCategoryTravel+")").matcher(where_at);

                    if (matcherTollPlaza.find()){
                        merchantCategory = stringChangeMerchantCategory[1];
                    }
                }

                if (merchantCategory.isEmpty() || merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){

                    String getStringChangeMerchantCategoryTravelHotel = frameworkWords.getStringChangeMerchantCategoryTravelHotel();
                    //FAIRFIELD
                    Matcher matcherTravelHotel = Pattern.compile("(?i)("+getStringChangeMerchantCategoryTravelHotel+")").matcher(where_at);

                    if (matcherTravelHotel.find()){
                        merchantCategory = stringChangeMerchantCategory[4];
                    }
                }

                if (merchantCategory.isEmpty() || merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){

                    String getStringChangeMerchantCategoryEducation = frameworkWords.getStringChangeMerchantCategoryEducation();
                    //educat
                    Matcher matcherEducation = Pattern.compile("(?i)("+getStringChangeMerchantCategoryEducation+")").matcher(where_at);

                    if (matcherEducation.find()){
                        merchantCategory = stringChangeMerchantCategory[19];
                    }

                }

                if (merchantCategory.isEmpty() || merchantCategory.equalsIgnoreCase(stringChangeMerchantCategory[12])){

                    String getStringChangeMerchantCategoryEntertainment = frameworkWords.getStringChangeMerchantCategoryEntertainment();
                    //game|Winzo|bigtree\s*En|dsp|div\s*\d
                    Matcher matcherEntertainment = Pattern.compile("(?i)("+getStringChangeMerchantCategoryEntertainment+")").matcher(where_at);

                    if (matcherEntertainment.find()){
                        merchantCategory = stringChangeMerchantCategory[10];
                    }

                }


                where_at = where_at.replaceAll("(?i)^"+stringChangeMerchant[189]+"\\s", "").trim();

            }
        }catch (Exception e){
            logger.warning(e.getMessage());
        }



        if (merchantCategory.isEmpty()){
            merchantCategory = merchantCategory(merchantCategory,where_at.trim(),blockResult.getPass_amount(),stringChangeMerchantCategory,
                    frameworkWords);
        }

        if (merchantCategory.isEmpty()) {
            merchantCategory = merchantCategoryFromDictionaryForBrands(where_at.trim(),stringChangeMerchantCategory,frameworkWords);
            //String dictionaryWords = merchantCategoryFromDictionaryForBrands(where_at);
            //blockResult.setDictonaryWords(dictionaryWords);

        }

        if (merchantCategory.isEmpty()){
            merchantCategory = merchantCategoryFromDictionary(where_at.trim(),stringChangeMerchantCategory, frameworkWords);

            //String dictionaryWords = merchantCategoryFromDictionary(where_at.trim());
            //blockResult.setDictonaryWords(dictionaryWords);
        }


        if (merchantCategory.isEmpty()){
            Matcher removeAfterStar = Pattern.compile("^("+stringChangeMerchant[167]+"|"+stringChangeMerchant[168]+")(\\*|_)").matcher(actualWhereAt);
            if (removeAfterStar.find()){
                merchantCategory = stringChangeMerchantCategory[12];
            }

        }






        blockResult.setMerchantCategory(merchantCategory);

        blockResult.setPass_name(where_at.trim());
        return blockResult;

    }



    public String merchantCategory(String merchantCategory,String merchantName,double amount,
                                   String[] stringChangeMerchantCategory,FrameworkWords frameworkWords){

        String[] getStringChangeMerchantCategory3 = frameworkWords.getStringChangeMerchantCategory3();

        if (merchantName.equalsIgnoreCase(""+getStringChangeMerchantCategory3[3]) || merchantName.length() < 3){
            return "";
        }

        String olderMerchantName = merchantName;
        Matcher matcherDeleteLast3 = Pattern.compile("(?i)(\\W)([a-zA-Z]{1,3}(\\W|)$)").matcher(merchantName);

        if (matcherDeleteLast3.find()){

            String group2 = matcherDeleteLast3.group(2);
            if (!group2.toLowerCase().contains(""+getStringChangeMerchantCategory3[4])) {
                merchantName = merchantName.replaceAll(group2, "").trim();
            }


        }

        String getStringChangeMerchantCategory6 = frameworkWords.getStringChangeMerchantCategory6();
        String getStringChangeMerchantCategory7 = frameworkWords.getStringChangeMerchantCategory7();

        //String nameBrand = "Reliance Nippon Life Insurance,Standard Chartered Manhattan,Aditya Birla SL Mutual Fund,IDBI Federal Life Insurance,National Informatics Center,IndiaFirst Life Insurance,Shriram General Insurance,Canara Robeco Mutual Fund,Religare Health Insurance,Airtel Missed Call Alerts,Indraprastha Gas Limited,Vizmo Visitor Management,Birla Sunlife Insurance,Reliance Gen. Insurance,Apollo Munich Insurance,Traffic Police Echallan,BNP Paribas Mutual Fund,Malabar Gold & Diamonds,United India Insurance,ICICI Pru. Mutual Fund,Maharashtra Government,Aditya Birla Insurance,Aarogyasri Health Care,Family Health Plan TPA,Kolte Patil Developers,ICICI Pru. Mutual Fund,National Health Portal,Indian Railways IRCTC,Income Tax Department,Birla Sunlife M. Fund,Star Health Insurance,Motilal Oswal M. Fund,StanChart 360 Rewards,JITO Pimpri Chinchwad,Waman Hari Pethe Sons,Reliance Mutual Fund,Canara H O Insurance,Sundaram Mutual Fund,Passport Seva Kendra,Aegon Life Insurance,Aviva Life Insurance,Exide Life Insurance,Kotak Life Insurance,First Flight Courier,Income Tax Reporting,Paramount Health TPA,Health Insurance TPA,Central KYC Registry,Government of Punjab,Kohinoor Electronics,Shree Maruti Courier,Suburban Diagnostics,Shree Nandan Courier,New India Assurance,HDFC Life Insurance,PNB Housing Finance,The Bishop's School,Mangeshkar Hospital,Step By Step School,Universal Insurance,John Jacobs Eyewear,Reliance Securities,BOI AXA Mutual Fund,LIC Housing Finance,Kotak Mahindra Bank,Tata Tele Broadband,Reliance Smartmoney,Wockhardt Hospitals,Chola MS Insurance,Max Life Insurance,SBI Life Insurance,SUD Life Insurance,Oriental Insurance,National Insurance,SBI Gen. Insurance,Mirae Asset M Fund,VAHAN Vehicle Data,Quick Ride Carpool,Sargam Electronics,METRO Cash & Carry,Manappuram Finance,California Burrito,Marshalls Pet Zone,Chellaram Hospital,Franklin Templeton,Kotak Mutual Fund,SBICAP Securities,South Indian Bank,Godrej Properties,Vipul MedCorp TPA,Union Mutual Fund,Kotak Mutual Fund,Bajaj Electricals,HDFC Gift Voucher,Konduskar Travels,Sterling Holidays,UTI ITSL PAN Card,Govt. Marketplace,HDFC Mutual Fund,IDFC Mutual Fund,PMC Property Tax,ICICI Prudential,Ruby Hall Clinic,Tata Mutual Fund,Axis Mutual Fund,Kotak Securities,Gourmet Passport,Health India TPA,Wellness Forever,Poorvika Mobiles,Sangeetha Mobile,Dr. Lal PathLabs,BEST Electricity,SBI Gift Voucher,Reliance Digital,West Bengal IFMS,IDBI Mutual Fund,Volkswagen Noida,Citibank Rewards,Overnite Express,Dept. of Telecom,Airtel Fixedline,Ovenstory Pizzas,Bihar Government,SBI Mutual Fund,Ministry of I&B,IndiGo Airlines,DSP Mutual Fund,Indian Railways,CAMS Repository,Future Generali,Maharashtra GST,Fortis Hospital,HDFC Securities,Biryani By Kilo,Wills Lifestyle,SRL Diagnostics,Reliance Trends,L&T Mutual Fund,Marks & Spencer,Barbeque Nation,LIC Mutual Fund,Muthoot Finance,Delhi Jal Board,Behrouz Biryani,Unilever Pureit,IndiGo Airlines,Mad Over Donuts,UTI Mutual Fund,Vichare Express,Maharashtra PDS,Edelweiss Tokio,Revv Self Drive,SBI Fasttag ETC,OLX Cash My Car,Wagh Bakri Chai,Country Delight,Reliance Retail,Experian Credit,Apollo Pharmacy,Unlimited Store,Landmark Stores,Digit Insurance,Bank of Baroda,TDS Processing,GST E-Way Bill,Royal Sundaram,DHFL Pramerica,YOU Broadbacnd,Max Healthcare,Jai Hind Store,Ferns N Petals,Titan Encircle,Baskin Robbins,Mia by Tanishq,Acko Insurance,HomeTown Store,Louis Philippe,Govt. of India,Natures Basket,Hero Insurance,Foodhall Store,Tata Power DDL,Tommy Hilfiger,Metropolis Lab,IOC XtraReward,Cantabil Store,Orange Travels,Ammi's Biryani,industrybuying,Himalaya Store,insight.gov.in,Hasmukh Travel,TravelTriangle,Airtel Xstream,YOU Broadband,Bajaj Finserv,Bajaj Allianz,Maruti Suzuki,ICICI Lombard,ACT Broadband,Mosambee mPOS,BSES Rajdhani,Eureka Forbes,MediBuddy TPA,First Citizen,Shoppers Stop,Club Mahindra,Hyundai India,Dunkin Donuts,PVR Privilege,SBI E-Voucher,Saraswat Bank,BOB Financial,Peter England,Torrent Power,PH Diagnostic,Angel Broking,BikeDekho.com,sRide Carpool,HDFC SmartBuy,AB MyUniverse,Chumbak Store,Biryani Blues,Liberty Shoes,Bajaj Finserv,Brand Factory,Mahanagar Gas,Akshaya Patra,Kama Ayurveda,Daily Objects,Capital First,Motilal Oswal,Avail Finance,Urban Company,Future Group,ICICI Direct,Policybazaar,Urban Ladder,Payswiff POS,Ecom Express,Globus Store,Rupeek Loans,CarDekho.com,Viveks Store,EquityPandit,Easyday Club,Tata Capital,Jack & Jones,U C Benetton,Monster Jobs,Hans Travels,BookMyPacket,LT Insurance,JM Financial,Pickyourtail,Moneycontrol,CrelioHealth,Airtel Black,IFFCO Tokio,Jet Airways,BSE Limited,PNB MetLife,BSES Yamuna,Paisabazaar,Rastey Cabs,PVR Cinemas,FedEx India,Savaari Car,Max Fashion,Magicbricks,Home Centre,Veena World,Cox & Kings,IFFCO Tokio,Star Bazaar,Allen Solly,Croma Store,Bounce Bike,NSE Trading,WOW Express,Lakme Salon,TCI Express,Tata Motors,Haier India,Jawed Habib,Burger King,Dr. Batra's,@home Store,Thomas Cook,Mera Events,SBI Rewardz,C'lai World,Travelyaari,Gujarat Gas,Emaar India,RTO Gujarat,ClubFactory,Vijay Sales,MDIndia TPA,HealthifyMe,Lendingkart,Pune Police,VRL Travels,Mufti Store,Wok Express,EXL Service,Times Prime,Blackberrys,Airtel DTH,Mahavitran,Freecharge,Big Bazaar,MakeMyTrip,BookMyShow,India Post,Bharti AXA,Future Pay,VFS Global,XpressBees,Naukri.com,Chai Point,Mapmyindia,Wynk Music,InterMiles,Van Heusen,BankBazaar,MakeMyTrip,AxisDirect,Tata Power,FundzBazar,FundsIndia,ConfirmTkt,Ford India,HealthKart,Pantaloons,EaseMyTrip,BabyChakra,McDelivery,Safexpress,Milkbasket,Joyalukkas,Cottonking,Vistaprint,Printvenue,Homeshop18,McDonald's,BookMyShow,Walnut App,DigiLocker,Paytm Mall,MOJO Pizza,IndiaLends,Money View,Qwikcilver,Freecharge,Mahavitran,Zee Cinema,Healthians,Shiprocket,ITC Hotels,eMudra DSC,HealthPlix,SMC Assure,QuackQuack,SBI Buddy,Meru Cabs,Tata Play,Delhivery,Instamojo,foodpanda,bigbasket,GST India,Cigna TTK,HDFC ERGO,UrbanClap,PayUmoney,IndiaMART,Adani Gas,Delhivery,Pepperfry,Air India,Seniority,FabHotels,Cleartrip,FreshMenu,TicketNew,Starbucks,HyperCITY,Lifestyle,Pizza Hut,HDFC Bank,Decathlon,EazyDiner,Karvy MFS,Thyrocare,Shadowfax,PharmEasy,Sharekhan,JITO Pune,TimesJobs,BlaBlaCar,Patanjali,Edelweiss,MK Retail,SkoolBeep,Wow! Momo,ShareChat,INDwealth,ZestMoney,CPP India,Printstop,Flintobox,Hopscotch,Printland,Accu-Chek,MedsOnway,MNGL Pune,Shine.com,Airtel TV,bigbasket,RailYatri,Ninjacart,ALTBalaji,Voot Kids,OPPO Kash,Innisfree,Tata Play,PhoneCash,MX Player,Rentomojo,IndianOil,Akasa Air,OneApollo,TVS Motor,OLA Cabs,Vodafone,Snapdeal,SpiceJet,Bluedart,Max Bupa,Flipkart,WhatsApp,MobiKwik,Domino's,JustDial,Coverfox,Tata AIG,Tata AIA,Housejoy,Nestaway,FirstCry,CCAvenue,Razorpay,Avis Car,BharatPe,BillDesk,Westside,magicpin,HomeStop,Lenskart,NoBroker,Skechers,SBI YONO,Zee News,Religare,Bewakoof,JadeBlue,Fastrack,Limeroad,CarTrade,Khadim's,Scripbox,Fabindia,LifeCell,Hike App,SpiceJet,Goalwise,Holachef,Infibeam,Woodland,Orix Car,Club ITC,MoneyTap,RichFeel,OkCredit,SlicePay,Sony LIV,CashKaro,CashBean,Cure.fit,StarQuik,Telegram,JioFiber,Taj IHCL,DigiBoxx,Furlenco,Tata Neu,SBI Life,Flipkart,BeepKart,BillBook,SBI UPI,Zoomcar,Grofers,Vistara,GoIbibo,AirAsia,PhonePe,AADHAAR,Sun DTH,Dish TV,Hathway,APEPDCL,TSSPDCL,Medanta,Netmeds,Zerodha,Sulekha,Cashify,BCCL HR,AirAsia,Max Lab,YourBus,Lybrate,99acres,Raymond,CENTRAL,Samsung,Medlife,Tanishq,PayZapp,MedPlus,dineout,PAYBACK,Dream11,Hotstar,way2sms,ITC WLS,Servify,NPS CRA,Equitas,Purplle,LG Care,WBSEDCL,MeeSeva,Chhayos,DoctorC,AbhiBus,HipShip,Zoomcar,Jaypore,DT Plus,Babyhug,YAP Pay,LazyPay,ETMONEY,SBI CMP,Cuemath,JioMart,US Polo,Mintoak,EatSure,Taneira,Anumati,LivServ,Amazon,SWIGGY,ZOMATO,Go Air,Airtel,Jabong,Myntra,redBus,Xiaomi,Sodexo,HP Gas,Toyota,PRACTO,Treebo,Indane,Portea,Jabong,Zivame,Xiaomi,MyGate,Airtel,Rapido,PayPal,Enamor,Jockey,Aramex,Meesho,Godrej,Mswipe,Ezetap,BESCOM,DriveU,Mi Pay,Faasos,Clovia,CARS24,APSRTC,HESCOM,eCourt,SBPDCL,SUBWAY,BYJU'S,Reebok,adidas,Lenovo,Upstox,Haptik,Shuttl,HP Gas,Daikin,Kissht,realme,Vyapar,Helios,Bausch,Zudio!,Rediff,OnGrid,Levi's,Paytm,Yatra,Dunzo,Honda,eKart,IXIGO,MSRTC,Ridlr,Quikr,DMart,Nykaa,Veris,Karvy,Titan,KSRTC,Lloyd,NCDEX,GOQii,GSRTC,IXIGO,Yatra,TNSTC,Aviva,Amway,Bosch,UMANG,Udaan,TSRTC,Docon,Lewis,Arrow,CIBIL,GyFTR,Inc.5,CASIO,Dunzo,Zepto,Uber,DTDC,BSNL,IDEA,AMEX,PUMA,BPCL,BSNL,ICAI,MTNL,CESC,BHIM,BBMP,Zeta,NiYO,ICSI,IDEA,Bata,DTDC,CAMS,Box8,INOX,VLCC,BIBA,CBIC,AJIO,CDSL,NSDL,ZOHO,EPFO,PayU,TRAI,TNEB,KSEB,Kent,Xoom,DHFL,MPCZ,Abof,eBay,SEBI,Uber,GHMC,CGHS,IIFL,ZEE5,CRED,DGFT,JITO,NAVI,BPCL,CEAT,SPAR,NESL,Fibe,OLX,OLA,OYO,SBI,DHL,JIO,RBI,LIC,D2H,NSE,1mg,D2H,MCX,fbb,MCA,KFC,NSE,DHL,GAP,1mg,JIO,Via,MCB,UJS,aLL,GAS,IGP,Jar,HP,VI".toLowerCase();
        String nameBrand = getStringChangeMerchantCategory6.toLowerCase();
        //String merchantC = "Insurance,,Investment,Insurance,,Insurance,Insurance,Investment,Insurance,Utility Bill,Utility Bill,,Insurance,Insurance,Insurance,Challan,Investment,Shopping,Insurance,Investment,,Investment,Healthcare,Insurance,,Investment,,Travel,Tax,Investment,Insurance,Investment,,,Shopping,Investment,Insurance,Investment,Essential Service,Insurance,Insurance,Insurance,Insurance,Essential Service,Tax,Insurance,Insuracnce,,,Shopping,Essential Service,Healthcare,Essential Service,Insurance,Insurance,,Education,Healthcare,Education,Insurance,Shopping,Investment,Investment,,,Utility Bill,,Healthcare,Insurance,Insurance,Insurance,Insurance,Insurance,Insurance,Insurance,Investment,,Travel,Shopping,Food,,Food,Pet,Healthcare,Investment,Investment,Investment,,,Insurance,Investment,Investment,,,Travel,Travel,,,Investment,Investment,Tax,Insurance,Healthcare,Investment,Investment,Investment,Food,Insurance,Healthcare,Shopping,Shopping,Healthcare,Utility Bill,,Shopping,,Investment,Transportation,,Essential Service,,Utility Bill,Food,,Investment,,Travel,Investment,Travel,,Insurance,Tax,Healthcare,Investment,Food,Shopping,Healthcare,Shopping,Investment,Shopping,Food,Investment,,Utility Bill,Food,Essential Service,Travel,Food,Investment,Essential Service,,Insurance,Travel,Transportation,,Food,Food,Shopping,,Healthcare,Shopping,Shopping,Insurance,,Tax,,Insurance,Insurance,Utility Bill,Healthcare,Shopping,Shopping,,Food,Shopping,Insurance,Shopping,Shopping,,Food,Insurance,Shopping,Utility Bill,Shopping,Healthcare,Transportation,Shopping,Travel,Food,Professional,Healthcare,,Travel,Travel/Hotel,Utility Bill,Utility Bill,?,Insurance,Transportation,Insurance,Utility Bill,,Utility Bill,Essential Service,Healthcare,Shopping,Shopping,Hotel,Transportation,Food,Entertainment,,,,Shopping,Utility Bill,Healthcare,Investment,,Travel,,,Shopping,Food,Shopping,,Shopping,Utility Bill,,Wellness,Shopping,,Investment,,Essential Service,Shopping,Investment,Insurance,Shopping,,Essential Service,Shopping,,Transportation,Shopping,Investment,,,Shopping,Shopping,Professional,Travel,Essential Service,Insurance,Investment,Travel/Hotel,Professional,Healthcare,Utility Bill,Insurance,Travel,,Insurance,Utility Bill,Insurance,Transportation,Entertainment,Essential Service,Travel,Shopping,,Shopping,Travel,Travel,Insurance,Food,Shopping,Shopping,Transportation,Investment,Essential Service,Wellness,Essential Service,Transportation,Shopping,Wellness,Food,Healthcare,Shopping,Travel,Entertainment,,Shopping,Travel,Utility Bill,,,Shopping,Shopping,Healthcare,Healthcare,,,Travel,Shopping,Food,,Entertainment,Shopping,Utility Bill,Utility Bill,Utility Bill,Shopping,Travel/Hotel,Entertainment,Essential Service,Insurance,,Essential Service,Essential Service,Professional,Food,,Entertainment,,Shopping,,Travel/Hotel,Investment,Utility Bill,,,Travel,Transportation,Healthcare,Shopping,Travel/Hotel,Essential Service,Food,Essential Service,Food,Shopping,Shopping,Essential Service,Essential Service,Shopping,Food,Entertainment,,,Shopping,Food,,,Shopping,Utility Bill,Utility Bill,Entertainment,Healthcare,Essential Service,Hotel,,Healthcare,Insurance,Lifestyle,,Transportation,Utility Bill,Essential Service,,Food,Grocery,,Insurance,Insurance,Essential Service,,Professional,Food,Essential Service,Shopping,Travel,Healthcare,Hotel,Travel/Hotel,Food,Entertainment,Food,Shopping,Shopping,Food,,Sports,Food,Investment,Healthcare,Essential ,Healthcare,Investment,,Professional,Travel,Healthcare,,Shopping,,Food,,,,,Essential Service,Shopping,Shopping,Essential Service,Healthcare,Healthcare,Utility Bill,Professional,Utility Bill,Food,Travel,,Entertainment,Entertainment,,Shopping,Utility Bill,,,Shopping,Transportation,Travel,Healthcare,Transportation,Transportation,Utility Bill,Shopping,Travel,Essential Service,Insurance,Shopping,,,Food,,Insurance,Insurance,Insurance,Essential Service,Shopping,Shopping,,,Travel,,,Shopping,Shopping,Shopping,Shopping,?,Shopping,,Entertainment,Investment,Shopping,Shopping,Shopping,Shopping,Transportation,Shopping,,Shopping,Healthcare,,Travel,,Food,,Shopping,Travel,,,Wellness,,,Entertainment,,,Wellness,Food,,Utillity Bill,Hotel,,Shopping,Shopping,Insurance,Shopping,Shopping,,,Travel,?,Travel,Travel/Hotel,Travel,,,Utility Bill,Utility Bill,Utility Bill,Utility Bill,Utility Bill,Healthcare,Healthcare,Investment,,Shopping,,Travel,Healthcare,Travel,Healthcare,,Shopping,Shopping,Shopping,Healthcare,Shopping,,Healthcare,Food,,Entertainment,Entertainment,,Shopping,Essential Service,,,Shopping,Essential Service,Utility Bill,,Food,Healthcare,Travel,Essential Service,Travel,Shopping,,Shopping,,,,,Professional,Shopping,Shopping,,Food,Shopping,,,Shopping,Food,Food,Travel,Utility Bill,Shopping,Shopping,Travel,Shopping,Food,Food,Transportation,Healthcare,Travel/Hotel,Food,Healthcare,,Shopping,Shopping,Essential Service,Utility Bill,Transportation,,Shopping,Shopping,Essential Service,Shopping,,,,Utility Bill,Travel,,Food,Shopping,Transportation,Travel,Utility Bill,,Utility Bill,Food,Education,Shopping,Shopping,Shopping,Investment,,Transportation,Utility Bill,Essential Service,,Shopping,,Shopping,,Shopping,Professional,Professional,Shopping,,Travel,Essential Service,Transportation,Essential Service,Travel/Hotel,Travel,,Shopping,Food,Shopping,,Investment,Shopping,Travel,Shopping,,Healthcare,Travel,Travel,Travel,Travel,Insurance,Shopping,,,,Travel,,Shopping,Shopping,,Shopping,Shopping,Shopping,Essential Service,?,Transportation,Essential Service,Utility Bill,Utility Bill,,Shopping,?,Utility Bill,,Utility Bill,Utlity Bill,,,,,,Utility Bill,Shopping,Essential Service,,Food,Entertainment,Essential Service,Shopping,,Shopping,Investment,Investment,Professional,,,,Utility Bill,Utility Bill,Shopping,,,,Shopping,Shopping,,Transportation,,,,Entertainment,,,,,,Transportation,Shopping,,,Shopping,Transportation,Hotel,,Essential Service,Utility Bill,,Insurance,Utility Bill,Investment,Health,Utility Bill,Investment,Shopping,,Food,Investment,Essential Service,Shopping,Healthcare,Utility Bill,Travel,,,Shopping,Shopping,Shopping,,,Utility Bill";
        String merchantC = getStringChangeMerchantCategory7;


        //if (nameBrand.contains(merchantName.toLowerCase())){

        String[] array = nameBrand.split(",");

        for (int i =0; i<array.length; i++){

            String brandName = array[i];

            String[] howManyWords = brandName.split("\\W");

            if (howManyWords.length ==1) {


                //String[] howManyWordsInMerchant = merchantName.split("\\W");
                if (brandName.toLowerCase().startsWith(merchantName.toLowerCase())) {

                    String[] arrayMerchantC = merchantC.split(",");
                    merchantCategory = arrayMerchantC[i];

                    if (merchantCategory.isEmpty()) {
                        merchantCategory = stringChangeMerchantCategory[12];
                    }

                    //Log.d("AAAVVVV", "1 --- " + merchantName + " -- " + merchantCategory);

                    break;
                }/*else if (howManyWordsInMerchant.length > 1){


                    }*/
            }else {

                String lastWord = "~~";
                String lastWordToReplace = "~~";
                String createDynamicRegex = "^(?i)";
                for (String word : howManyWords){
                    createDynamicRegex = createDynamicRegex + "(\\W+|)" + word;
                    lastWord = word;
                    lastWordToReplace = word;
                    if (lastWord.length()>2){
                        lastWordToReplace = word.substring(0,2);
                    }
                }
                //createDynamicRegex = createDynamicRegex +"";
                createDynamicRegex = createDynamicRegex.replace(lastWord,lastWordToReplace);

                Matcher find = Pattern.compile(createDynamicRegex).matcher(merchantName);
                if (find.find()){

                    String[] arrayMerchantC = merchantC.split(",");
                    merchantCategory = arrayMerchantC[i];

                    if (merchantCategory.isEmpty()){
                        merchantCategory = stringChangeMerchantCategory[12];
                    }

                    //Log.d("AAAVVVV", "2 --- " + merchantName +" -- "+merchantCategory +" -- "+createDynamicRegex);
                    break;
                }
            }
        }

        //}


        if (merchantCategory.isEmpty()){


            String getStringChangeMerchantCategory1 = frameworkWords.getStringChangeMerchantCategory1();
            String names = ""+getStringChangeMerchantCategory1;
            //String names = "Hotel|Veg|Lab|Sport|Entert|Healt|Tyr|Transp|Fue|Coffe|Tea|Hospitali|Hospital|Resta|Bus|Petro|Hyun|Audi|Merced|Motors|Fitn|Clin|Cricket|Spor|Insu|IRCTC|YouTube|Loan|Paytm QR|Q\\d{4,}|BBPS|Cards|Bank Card|Medic|Patho|Variet|Enterpri|Store|Fashio|Currency|Forex|BharatPe|BBPSB|Munici|Linkedin|Archies|Service Sta|Trade|POS|Food|Adida|Nike|Sketche|Puma|Subway|Wheel|Netflix|Cookie|Choco|Desse|Retail|Shoe|Adobe|McDonal|Mc Dona|Pizza|Thali|Empori|College|Institu|Academ|Coachig|Tuitio|Industr|Mr DIY|Ikea|Halwai|Mithai|Mart|Vyapar|Sweet|pharma|Cine|Gold|sarf|mall|Klook|Caterer|Clinic";

            Matcher matcher = Pattern.compile("(?i)(^|\\W)("+names+")(\\w+|)(\\W|$)").matcher(olderMerchantName);

            if (matcher.find()){

                String foundGroup = matcher.group(2);

                if (foundGroup.equalsIgnoreCase(""+getStringChangeMerchantCategory3[2]) &&amount >5000){
                    merchantCategory = stringChangeMerchantCategory[1];
                    return merchantCategory;
                }

                String[] arrayForNames = names.split("\\|");

                for(int i= 0; i<arrayForNames.length; i++){

                    String forName = arrayForNames[i];

                    if (foundGroup.equalsIgnoreCase(forName)){

                        String getStringChangeMerchantCategory2 = frameworkWords.getStringChangeMerchantCategory2();

                        //String[] category = "Food|Food|Healthcare|Sports|Entertainment|Healthcare|Transportation|Transportation|Transportation|Food|Food|Travel|healthcare|Food|Travel|Transportation|Transportation|Transportation|Transportation|Transportation|Wellness|Healthcare|Sports|Entertainment|Insurance|Travel|Entertainment|Loan|Merchant Pay|Merchant Pay|Utility Bill|Credit Card Bill|Credit Card Bill|Healthcare|Healthcare|Shopping|Shopping|Shopping|Shopping|Forex|Forex|Merchant Pay|Utility Bill|Tax|Professional|Shopping|Transportation|Shopping|Merchant Pay|Food|Shopping|Shopping|Shopping|Shopping|Food|Transportation|Entertainment|Food|Food|Food|Shopping|Shopping|Professional|Food|Food|Food|Food|Shopping|Education|Education|Education|Education|Education|Shopping|Shopping|Shopping|Food|Food|Shopping|Shopping|Food|Healthcare|Entertainment|Jewellery|Jewellery|Entertainment|Travel|Food|Healthcare".split("\\|");
                        String[] category = getStringChangeMerchantCategory2.split("\\|");

                        merchantCategory = category[i];

                        break;
                    }

                }

            }else {

                //String spacesAround = "motor|Bar|Car|AND";
                String spacesAround = ""+getStringChangeMerchantCategory3[0];


                Matcher spaceAroundMatcher = Pattern.compile("(?i)(^|\\W)("+spacesAround+")(\\W|$)").matcher(olderMerchantName);

                if (spaceAroundMatcher.find()){

                    String foundGroup = spaceAroundMatcher.group(2);


                    String[] arrayForNames = spacesAround.split("\\|");

                    for(int i= 0; i<arrayForNames.length; i++){

                        String forName = arrayForNames[i];

                        if (foundGroup.equalsIgnoreCase(forName)){

                            //String[] category = "Transportation|Food|Transportation|Merchant Pay".split("\\|");
                            String[] category = getStringChangeMerchantCategory3[1].split("\\|");

                            merchantCategory = category[i];

                            break;
                        }

                    }

                }
            }

        }



        /*if (merchantCategory.isEmpty()){
            merchantCategory = merchantCategoryFromDictionary(merchantName);
        }*/

        return merchantCategory;
    }



    public String merchantCategoryFromDictionary(String where_at, String[] stringChangeMerchantCategory, FrameworkWords frameworkWords){

        String merchantCategory = "";

        String getStringChangeMerchantCategory4 = frameworkWords.getStringChangeMerchantCategory4();


        //String dictionary = ",aaron,ab,abandoned,abc,aberdeen,abilities,ability,able,aboriginal,abortion,about,above,abraham,abroad,abs,absence,absent,absolute,absolutely,absorption,abstract,abstracts,abu,abuse,ac,academic,academics,academy,acc,accent,accept,acceptable,acceptance,accepted,accepting,accepts,access,accessed,accessibility,accessible,accessing,accessories,accessory,accident,accidents,accommodate,accommodation,accommodations,accompanied,accompanying,accomplish,accomplished,accordance,according,accordingly,account,accountability,accounting,accounts,accreditation,accredited,accuracy,accurate,accurately,accused,acdbentity,ace,acer,achieve,achieved,achievement,achievements,achieving,acid,acids,acknowledge,acknowledged,acm,acne,acoustic,acquire,acquired,acquisition,acquisitions,acre,acres,acrobat,across,acrylic,act,acting,action,actions,activated,activation,active,actively,activists,activities,activity,actor,actors,actress,acts,actual,actually,acute,ad,ada,adam,adams,adaptation,adapted,adapter,adapters,adaptive,adaptor,add,added,addiction,adding,addition,additional,additionally,additions,address,addressed,addresses,addressing,adds,adelaide,adequate,adidas,adipex,adjacent,adjust,adjustable,adjusted,adjustment,adjustments,admin,administered,administration,administrative,administrator,administrators,admission,admissions,admit,admitted,adobe,adolescent,adopt,adopted,adoption,adrian,ads,adsl,adult,adults,advance,advanced,advancement,advances,advantage,advantages,adventure,adventures,adverse,advert,advertise,advertisement,advertisements,advertiser,advertisers,advertising,advice,advise,advised,advisor,advisors,advisory,advocacy,advocate,adware,ae,aerial,aerospace,af,affair,affairs,affect,affected,affecting,affects,affiliate,affiliated,affiliates,affiliation,afford,affordable,afghanistan,afraid,africa,african,after,afternoon,afterwards,ag,again,against,age,aged,agencies,agency,agenda,agent,agents,ages,aggregate,aggressive,aging,ago,agree,agreed,agreement,agreements,agrees,agricultural,agriculture,ah,ahead,ai,aid,aids,aim,aimed,aims,air,aircraft,airfare,airline,airlines,airplane,airport,airports,aj,ak,aka,al,ala,alabama,alan,alarm,alaska,albania,albany,albert,alberta,album,albums,albuquerque,alcohol,alert,alerts,alex,alexander,alexandria,alfred,algebra,algeria,algorithm,algorithms,ali,alias,alice,alien,align,alignment,alike,alive,all,allah,allan,alleged,allen,allergy,alliance,allied,allocated,allocation,allow,allowance,allowed,allowing,allows,alloy,almost,alone,along,alot,alpha,alphabetical,alpine,already,also,alt,alter,altered,alternate,alternative,alternatively,alternatives,although,alto,aluminium,aluminum,alumni,always,am,amanda,amateur,amazing,amazon,ambassador,amber,ambien,ambient,amd,amend,amended,amendment,amendments,amenities,america,american,americans,americas,amino,among,amongst,amount,amounts,amp,ampland,amplifier,amsterdam,amy,an,ana,anaheim,anal,analog,analyses,analysis,analyst,analysts,analytical,analyze,analyzed,anatomy,anchor,ancient,and,andale,anderson,andorra,andrea,andreas,andrew,andrews,andy,angel,angela,angeles,angels,anger,angle,angola,angry,animal,animals,animated,animation,anime,ann,anna,anne,annex,annie,anniversary,annotated,annotation,announce,announced,announcement,announcements,announces,annoying,annual,annually,anonymous,another,answer,answered,answering,answers,ant,antarctica,antenna,anthony,anthropology,anti,antibodies,antibody,anticipated,antigua,antique,antiques,antivirus,antonio,anxiety,any,anybody,anymore,anyone,anything,anytime,anyway,anywhere,aol,ap,apache,apart,apartment,apartments,api,apnic,apollo,app,apparatus,apparel,apparent,apparently,appeal,appeals,appear,appearance,appeared,appearing,appears,appendix,apple,appliance,appliances,applicable,applicant,applicants,application,applications,applied,applies,apply,applying,appointed,appointment,appointments,appraisal,appreciate,appreciated,appreciation,approach,approaches,appropriate,appropriations,approval,approve,approved,approx,approximate,approximately,apps,apr,april,apt,aqua,aquarium,aquatic,ar,arab,arabia,arabic,arbitrary,arbitration,arbor,arc,arcade,arch,architect,architects,architectural,architecture,archive,archived,archives,arctic,are,area,areas,arena,arg,argentina,argue,argued,argument,arguments,arise,arising,arizona,arkansas,arlington,arm,armed,armenia,armor,arms,armstrong,army,arnold,around,arrange,arranged,arrangement,arrangements,array,arrest,arrested,arrival,arrivals,arrive,arrived,arrives,arrow,art,arthritis,arthur,article,articles,artificial,artist,artistic,artists,arts,artwork,aruba,as,asbestos,ascii,ash,ashley,asia,asian,aside,asin,ask,asked,asking,asks,asn,asp,aspect,aspects,ass,assault,assembled,assembly,assess,assessed,assessing,assessment,assessments,asset,assets,assign,assigned,assignment,assignments,assist,assistance,assistant,assisted,assists,associate,associated,associates,association,associations,assume,assumed,assumes,assuming,assumption,assumptions,assurance,assure,assured,asthma,astrology,astronomy,asus,asylum,at,ata,ate,athens,athletes,athletic,athletics,ati,atlanta,atlantic,atlas,atm,atmosphere,atmospheric,atom,atomic,attach,attached,attachment,attachments,attack,attacked,attacks,attempt,attempted,attempting,attempts,attend,attendance,attended,attending,attention,attitude,attitudes,attorney,attorneys,attract,attraction,attractions,attractive,attribute,attributes,au,auburn,auckland,auction,auctions,aud,audi,audience,audio,audit,auditor,aug,august,aurora,aus,austin,australia,australian,austria,authentic,authentication,author,authorities,authority,authorization,authorized,authors,auto,automated,automatic,automatically,automation,automobile,automobiles,automotive,autos,autumn,av,availability,available,avatar,ave,avenue,average,avg,avi,aviation,avoid,avoiding,avon,aw,award,awarded,awards,aware,awareness,away,awesome,awful,axis,aye,az,azerbaijan,b,ba,babe,babes,babies,baby,bachelor,back,backed,background,backgrounds,backing,backup,bacon,bacteria,bacterial,bad,badge,badly,bag,baghdad,bags,bahamas,bahrain,bailey,baker,baking,balance,balanced,bald,bali,ball,ballet,balloon,ballot,balls,baltimore,ban,banana,band,bands,bandwidth,bang,bangbus,bangkok,bangladesh,bank,banking,bankruptcy,banks,banned,banner,banners,baptist,bar,barbados,barbara,barbie,barcelona,bare,barely,bargain,bargains,barn,barnes,barrel,barrier,barriers,barry,bars,base,baseball,based,baseline,basement,basename,bases,basic,basically,basics,basin,basis,basket,basketball,baskets,bass,bat,batch,bath,bathroom,bathrooms,baths,batman,batteries,battery,battle,battlefield,bay,bb,bbc,bbs,bbw,bc,bd,bdsm,be,beach,beaches,beads,beam,bean,beans,bear,bearing,bears,beast,beastality,beastiality,beat,beatles,beats,beautiful,beautifully,beauty,beaver,became,because,become,becomes,becoming,bed,bedding,bedford,bedroom,bedrooms,beds,bee,beef,been,beer,before,began,begin,beginner,beginners,beginning,begins,begun,behalf,behavior,behavioral,behaviour,behind,beijing,being,beings,belarus,belfast,belgium,belief,beliefs,believe,believed,believes,belize,belkin,bell,belle,belly,belong,belongs,below,belt,belts,ben,bench,benchmark,bend,beneath,beneficial,benefit,benefits,benjamin,bennett,bent,benz,berkeley,berlin,bermuda,bernard,berry,beside,besides,best,bestiality,bestsellers,bet,beta,beth,better,betting,betty,between,beverage,beverages,beverly,beyond,bg,bhutan,bi,bias,bible,biblical,bibliographic,bibliography,bicycle,bid,bidder,bidding,bids,big,bigger,biggest,bike,bikes,bikini,bill,billing,billion,bills,billy,bin,binary,bind,binding,bingo,bio,biodiversity,biographies,biography,biol,biological,biology,bios,biotechnology,bird,birds,birmingham,birth,birthday,bishop,bit,bitch,bite,bits,biz,bizarre,bizrate,bk,bl,black,blackberry,blackjack,blacks,blade,blades,blah,blair,blake,blame,blank,blanket,blast,bleeding,blend,bless,blessed,blind,blink,block,blocked,blocking,blocks,blog,blogger,bloggers,blogging,blogs,blond,blonde,blood,bloody,bloom,bloomberg,blow,blowing,blowjob,blowjobs,blue,blues,bluetooth,blvd,bm,bmw,bo,board,boards,boat,boating,boats,bob,bobby,boc,bodies,body,bold,bolivia,bolt,bomb,bon,bond,bondage,bonds,bone,bones,bonus,boob,boobs,book,booking,bookings,bookmark,bookmarks,books,bookstore,bool,boolean,boom,boost,boot,booth,boots,booty,border,borders,bored,boring,born,borough,bosnia,boss,boston,both,bother,botswana,bottle,bottles,bottom,bought,boulder,boulevard,bound,boundaries,boundary,bouquet,boutique,bow,bowl,bowling,box,boxed,boxes,boxing,boy,boys,bp,br,bra,bracelet,bracelets,bracket,brad,bradford,bradley,brain,brake,brakes,branch,branches,brand,brandon,brands,bras,brass,brave,brazil,brazilian,breach,bread,break,breakdown,breakfast,breaking,breaks,breast,breasts,breath,breathing,breed,breeding,breeds,brian,brick,bridal,bride,bridge,bridges,brief,briefing,briefly,briefs,bright,brighton,brilliant,bring,bringing,brings,brisbane,bristol,britain,britannica,british,britney,broad,broadband,broadcast,broadcasting,broader,broadway,brochure,brochures,broke,broken,broker,brokers,bronze,brook,brooklyn,brooks,brother,brothers,brought,brown,browse,browser,browsers,browsing,bruce,brunei,brunette,brunswick,brush,brussels,brutal,bryan,bryant,bs,bt,bubble,buck,bucks,budapest,buddy,budget,budgets,buf,buffalo,buffer,bufing,bug,bugs,build,builder,builders,building,buildings,builds,built,bukkake,bulgaria,bulgarian,bulk,bull,bullet,bulletin,bumper,bunch,bundle,bunny,burden,bureau,buried,burke,burlington,burn,burner,burning,burns,burst,burton,bus,buses,bush,business,businesses,busty,busy,but,butler,butt,butter,butterfly,button,buttons,butts,buy,buyer,buyers,buying,buys,buzz,bw,by,bye,byte,bytes,c,ca,cab,cabin,cabinet,cabinets,cable,cables,cache,cached,cad,cadillac,cafe,cage,cake,cakes,cal,calcium,calculate,calculated,calculation,calculations,calculator,calculators,calendar,calendars,calgary,calibration,california,call,called,calling,calls,calm,calvin,cam,cambodia,cambridge,camcorder,camcorders,came,camel,camera,cameras,cameron,cameroon,camp,campaign,campaigns,campbell,camping,camps,campus,cams,can,canada,canadian,canal,canberra,cancel,cancellation,cancelled,cancer,candidate,candidates,candle,candles,candy,cannon,canon,cant,canvas,canyon,cap,capabilities,capability,capable,capacity,cape,capital,capitol,caps,captain,capture,captured,car,carb,carbon,card,cardiac,cardiff,cardiovascular,cards,care,career,careers,careful,carefully,carey,cargo,caribbean,caring,carl,carlo,carlos,carmen,carnival,carol,carolina,caroline,carpet,carried,carrier,carriers,carries,carroll,carry,carrying,cars,cart,carter,cartoon,cartoons,cartridge,cartridges,cas,casa,case,cases,casey,cash,cashiers,casino,casinos,casio,cassette,cast,casting,castle,casual,cat,catalog,catalogs,catalogue,catalyst,catch,categories,category,catering,cathedral,catherine,catholic,cats,cattle,caught,cause,caused,causes,causing,caution,cave,cayman,cb,cbs,cc,ccd,cd,cdna,cds,cdt,ce,cedar,ceiling,celebrate,celebration,celebrities,celebrity,celebs,cell,cells,cellular,celtic,cement,cemetery,census,cent,center,centered,centers,central,centre,centres,cents,centuries,century,ceo,ceramic,ceremony,certain,certainly,certificate,certificates,certification,certified,cet,cf,cfr,cg,cgi,ch,chad,chain,chains,chair,chairman,chairs,challenge,challenged,challenges,challenging,chamber,chambers,champagne,champion,champions,championship,championships,chan,chance,chancellor,chances,change,changed,changelog,changes,changing,channel,channels,chaos,chapel,chapter,chapters,char,character,characteristic,characteristics,characterization,characterized,characters,charge,charged,charger,chargers,charges,charging,charitable,charity,charles,charleston,charlie,charlotte,charm,charming,charms,chart,charter,charts,chase,chassis,chat,cheap,cheaper,cheapest,cheat,cheats,check,checked,checking,checklist,checkout,checks,cheers,cheese,chef,chelsea,chem,chemical,chemicals,chemistry,chen,cheque,cherry,chess,chest,chester,chevrolet,chevy,chi,chicago,chick,chicken,chicks,chief,child,childhood,children,childrens,chile,china,chinese,chip,chips,cho,chocolate,choice,choices,choir,cholesterol,choose,choosing,chorus,chose,chosen,chris,christ,christian,christianity,christians,christina,christine,christmas,christopher,chrome,chronic,chronicle,chronicles,chrysler,chubby,chuck,church,churches,ci,cia,cialis,ciao,cigarette,cigarettes,cincinnati,cindy,cinema,cingular,cio,cir,circle,circles,circuit,circuits,circular,circulation,circumstances,circus,cisco,citation,citations,cite,cited,cities,citizen,citizens,citizenship,city,citysearch,civic,civil,civilian,civilization,cj,cl,claim,claimed,claims,claire,clan,clara,clarity,clark,clarke,class,classes,classic,classical,classics,classification,classified,classifieds,classroom,clause,clay,clean,cleaner,cleaners,cleaning,cleanup,clear,clearance,cleared,clearing,clearly,clerk,cleveland,click,clicking,clicks,client,clients,cliff,climate,climb,climbing,clinic,clinical,clinics,clinton,clip,clips,clock,clocks,clone,close,closed,closely,closer,closes,closest,closing,closure,cloth,clothes,clothing,cloud,clouds,cloudy,club,clubs,cluster,clusters,cm,cms,cn,cnet,cnn,co,coach,coaches,coaching,coal,coalition,coast,coastal,coat,coated,coating,cock,cocks,cocktail,cod,code,codes,coding,coffee,cognitive,cohen,coin,coins,col,cold,cole,coleman,colin,collaboration,collaborative,collapse,collar,colleague,colleagues,collect,collectables,collected,collectible,collectibles,collecting,collection,collections,collective,collector,collectors,college,colleges,collins,cologne,colombia,colon,colonial,colony,color,colorado,colored,colors,colour,colours,columbia,columbus,column,columnists,columns,com,combat,combination,combinations,combine,combined,combines,combining,combo,come,comedy,comes,comfort,comfortable,comic,comics,coming,comm,command,commander,commands,comment,commentary,commented,comments,commerce,commercial,commission,commissioner,commissioners,commissions,commit,commitment,commitments,committed,committee,committees,commodities,commodity,common,commonly,commons,commonwealth,communicate,communication,communications,communist,communities,community,comp,compact,companies,companion,company,compaq,comparable,comparative,compare,compared,comparing,comparison,comparisons,compatibility,compatible,compensation,compete,competent,competing,competition,competitions,competitive,competitors,compilation,compile,compiled,compiler,complaint,complaints,complement,complete,completed,completely,completing,completion,complex,complexity,compliance,compliant,complicated,complications,complimentary,comply,component,components,composed,composer,composite,composition,compound,compounds,comprehensive,compressed,compression,compromise,computation,computational,compute,computed,computer,computers,computing,con,concentrate,concentration,concentrations,concept,concepts,conceptual,concern,concerned,concerning,concerns,concert,concerts,conclude,concluded,conclusion,conclusions,concord,concrete,condition,conditional,conditioning,conditions,condo,condos,conduct,conducted,conducting,conf,conference,conferences,conferencing,confidence,confident,confidential,confidentiality,config,configuration,configurations,configure,configured,configuring,confirm,confirmation,confirmed,conflict,conflicts,confused,confusion,congo,congratulations,congress,congressional,conjunction,connect,connected,connecticut,connecting,connection,connections,connectivity,connector,connectors,cons,conscious,consciousness,consecutive,consensus,consent,consequence,consequences,consequently,conservation,conservative,consider,considerable,consideration,considerations,considered,considering,considers,consist,consistency,consistent,consistently,consisting,consists,console,consoles,consolidated,consolidation,consortium,conspiracy,const,constant,constantly,constitute,constitutes,constitution,constitutional,constraint,constraints,construct,constructed,construction,consult,consultancy,consultant,consultants,consultation,consulting,consumer,consumers,consumption,contact,contacted,contacting,contacts,contain,contained,container,containers,containing,contains,contamination,contemporary,content,contents,contest,contests,context,continent,continental,continually,continue,continued,continues,continuing,continuity,continuous,continuously,contract,contracting,contractor,contractors,contracts,contrary,contrast,contribute,contributed,contributing,contribution,contributions,contributor,contributors,control,controlled,controller,controllers,controlling,controls,controversial,controversy,convenience,convenient,convention,conventional,conventions,convergence,conversation,conversations,conversion,convert,converted,converter,convertible,convicted,conviction,convinced,cook,cookbook,cooked,cookie,cookies,cooking,cool,cooler,cooling,cooper,cooperation,cooperative,coordinate,coordinated,coordinates,coordination,coordinator,cop,cope,copied,copies,copper,copy,copying,copyright,copyrighted,copyrights,coral,cord,cordless,core,cork,corn,cornell,corner,corners,cornwall,corp,corporate,corporation,corporations,corps,corpus,correct,corrected,correction,corrections,correctly,correlation,correspondence,corresponding,corruption,cos,cosmetic,cosmetics,cost,costa,costs,costume,costumes,cottage,cottages,cotton,could,council,councils,counsel,counseling,count,counted,counter,counters,counties,counting,countries,country,counts,county,couple,coupled,couples,coupon,coupons,courage,courier,course,courses,court,courtesy,courts,cove,cover,coverage,covered,covering,covers,cow,cowboy,cox,cp,cpu,cr,crack,cradle,craft,crafts,craig,crap,craps,crash,crawford,crazy,cream,create,created,creates,creating,creation,creations,creative,creativity,creator,creature,creatures,credit,credits,creek,crest,crew,cricket,crime,crimes,criminal,crisis,criteria,criterion,critical,criticism,critics,crm,croatia,crop,crops,cross,crossing,crossword,crowd,crown,crucial,crude,cruise,cruises,cruz,cry,crystal,cs,css,cst,ct,ctrl,cu,cuba,cube,cubic,cuisine,cult,cultural,culture,cultures,cum,cumshot,cumshots,cumulative,cunt,cup,cups,cure,curious,currencies,currency,current,currently,curriculum,cursor,curtis,curve,curves,custody,custom,customer,customers,customise,customize,customized,customs,cut,cute,cuts,cutting,cv,cvs,cw,cyber,cycle,cycles,cycling,cylinder,cyprus,cz,czech,d,da,dad,daddy,daily,dairy,daisy,dakota,dale,dallas,dam,damage,damaged,damages,dame,damn,dan,dana,dance,dancing,danger,dangerous,daniel,danish,danny,dans,dare,dark,darkness,darwin,das,dash,dat,data,database,databases,date,dated,dates,dating,daughter,daughters,dave,david,davidson,davis,dawn,day,days,dayton,db,dc,dd,ddr,de,dead,deadline,deadly,deaf,deal,dealer,dealers,dealing,deals,dealt,dealtime,dean,dear,death,deaths,debate,debian,deborah,debt,debug,debut,dec,decade,decades,december,decent,decide,decided,decimal,decision,decisions,deck,declaration,declare,declared,decline,declined,decor,decorating,decorative,decrease,decreased,dedicated,dee,deemed,deep,deeper,deeply,deer,def,default,defeat,defects,defence,defend,defendant,defense,defensive,deferred,deficit,define,defined,defines,defining,definitely,definition,definitions,degree,degrees,del,delaware,delay,delayed,delays,delegation,delete,deleted,delhi,delicious,delight,deliver,delivered,delivering,delivers,delivery,dell,delta,deluxe,dem,demand,demanding,demands,demo,democracy,democrat,democratic,democrats,demographic,demonstrate,demonstrated,demonstrates,demonstration,den,denial,denied,denmark,dennis,dense,density,dental,dentists,denver,deny,department,departmental,departments,departure,depend,dependence,dependent,depending,depends,deployment,deposit,deposits,depot,depression,dept,depth,deputy,der,derby,derek,derived,des,descending,describe,described,describes,describing,description,descriptions,desert,deserve,design,designated,designation,designed,designer,designers,designing,designs,desirable,desire,desired,desk,desktop,desktops,desperate,despite,destination,destinations,destiny,destroy,destroyed,destruction,detail,detailed,details,detect,detected,detection,detective,detector,determination,determine,determined,determines,determining,detroit,deutsch,deutsche,deutschland,dev,devel,develop,developed,developer,developers,developing,development,developmental,developments,develops,deviant,deviation,device,devices,devil,devon,devoted,df,dg,dh,di,diabetes,diagnosis,diagnostic,diagram,dial,dialog,dialogue,diameter,diamond,diamonds,diana,diane,diary,dice,dick,dicke,dicks,dictionaries,dictionary,did,die,died,diego,dies,diesel,diet,dietary,diff,differ,difference,differences,different,differential,differently,difficult,difficulties,difficulty,diffs,dig,digest,digit,digital,dildo,dildos,dim,dimension,dimensional,dimensions,dining,dinner,dip,diploma,dir,direct,directed,direction,directions,directive,directly,director,directories,directors,directory,dirt,dirty,dis,disabilities,disability,disable,disabled,disagree,disappointed,disaster,disc,discharge,disciplinary,discipline,disciplines,disclaimer,disclaimers,disclose,disclosure,disco,discount,discounted,discounts,discover,discovered,discovery,discrete,discretion,discrimination,discs,discuss,discussed,discusses,discussing,discussion,discussions,disease,diseases,dish,dishes,disk,disks,disney,disorder,disorders,dispatch,dispatched,display,displayed,displaying,displays,disposal,disposition,dispute,disputes,dist,distance,distances,distant,distinct,distinction,distinguished,distribute,distributed,distribution,distributions,distributor,distributors,district,districts,disturbed,div,dive,diverse,diversity,divide,divided,dividend,divine,diving,division,divisions,divorce,divx,diy,dj,dk,dl,dm,dna,dns,do,doc,dock,docs,doctor,doctors,doctrine,document,documentary,documentation,documented,documents,dod,dodge,doe,does,dog,dogs,doing,doll,dollar,dollars,dolls,dom,domain,domains,dome,domestic,dominant,dominican,don,donald,donate,donated,donation,donations,done,donna,donor,donors,dont,doom,door,doors,dos,dosage,dose,dot,double,doubt,doug,douglas,dover,dow,down,download,downloadable,downloaded,downloading,downloads,downtown,dozen,dozens,dp,dpi,dr,draft,drag,dragon,drain,drainage,drama,dramatic,dramatically,draw,drawing,drawings,drawn,draws,dream,dreams,dress,dressed,dresses,dressing,drew,dried,drill,drilling,drink,drinking,drinks,drive,driven,driver,drivers,drives,driving,drop,dropped,drops,drove,drug,drugs,drum,drums,drunk,dry,dryer,ds,dsc,dsl,dt,dts,du,dual,dubai,dublin,duck,dude,due,dui,duke,dumb,dump,duncan,duo,duplicate,durable,duration,durham,during,dust,dutch,duties,duty,dv,dvd,dvds,dx,dying,dylan,dynamic,dynamics,e,ea,each,eagle,eagles,ear,earl,earlier,earliest,early,earn,earned,earning,earnings,earrings,ears,earth,earthquake,ease,easier,easily,east,easter,eastern,easy,eat,eating,eau,ebay,ebony,ebook,ebooks,ec,echo,eclipse,eco,ecological,ecology,ecommerce,economic,economics,economies,economy,ecuador,ed,eddie,eden,edgar,edge,edges,edinburgh,edit,edited,editing,edition,editions,editor,editorial,editorials,editors,edmonton,eds,edt,educated,education,educational,educators,edward,edwards,ee,ef,effect,effective,effectively,effectiveness,effects,efficiency,efficient,efficiently,effort,efforts,eg,egg,eggs,egypt,egyptian,eh,eight,either,ejaculation,el,elder,elderly,elect,elected,election,elections,electoral,electric,electrical,electricity,electro,electron,electronic,electronics,elegant,element,elementary,elements,elephant,elevation,eleven,eligibility,eligible,eliminate,elimination,elite,elizabeth,ellen,elliott,ellis,else,elsewhere,elvis,em,emacs,email,emails,embassy,embedded,emerald,emergency,emerging,emily,eminem,emirates,emission,emissions,emma,emotional,emotions,emperor,emphasis,empire,empirical,employ,employed,employee,employees,employer,employers,employment,empty,en,enable,enabled,enables,enabling,enb,enclosed,enclosure,encoding,encounter,encountered,encourage,encouraged,encourages,encouraging,encryption,encyclopedia,end,endangered,ended,endif,ending,endless,endorsed,endorsement,ends,enemies,enemy,energy,enforcement,eng,engage,engaged,engagement,engaging,engine,engineer,engineering,engineers,engines,england,english,enhance,enhanced,enhancement,enhancements,enhancing,enjoy,enjoyed,enjoying,enlarge,enlargement,enormous,enough,enquiries,enquiry,enrolled,enrollment,ensemble,ensure,ensures,ensuring,ent,enter,entered,entering,enterprise,enterprises,enters,entertaining,entertainment,entire,entirely,entities,entitled,entity,entrance,entrepreneur,entrepreneurs,entries,entry,envelope,environment,environmental,environments,enzyme,eos,ep,epa,epic,epinions,episode,episodes,epson,eq,equal,equality,equally,equation,equations,equilibrium,equipment,equipped,equity,equivalent,er,era,eric,ericsson,erik,erotic,erotica,erp,error,errors,es,escape,escort,escorts,especially,espn,essay,essays,essence,essential,essentially,essentials,essex,est,establish,established,establishing,establishment,estate,estates,estimate,estimated,estimates,estimation,estonia,et,etc,eternal,ethernet,ethical,ethics,ethiopia,ethnic,eu,eugene,eur,euro,europe,european,euros,ev,eva,eval,evaluate,evaluated,evaluating,evaluation,evaluations,evanescence,evans,eve,even,evening,event,events,eventually,ever,every,everybody,everyday,everyone,everything,everywhere,evidence,evident,evil,evolution,ex,exact,exactly,exam,examination,examinations,examine,examined,examines,examining,example,examples,exams,exceed,excel,excellence,excellent,except,exception,exceptional,exceptions,excerpt,excess,excessive,exchange,exchanges,excited,excitement,exciting,exclude,excluded,excluding,exclusion,exclusive,exclusively,excuse,exec,execute,executed,execution,executive,executives,exempt,exemption,exercise,exercises,exhaust,exhibit,exhibition,exhibitions,exhibits,exist,existed,existence,existing,exists,exit,exotic,exp,expand,expanded,expanding,expansion,expansys,expect,expectations,expected,expects,expedia,expenditure,expenditures,expense,expenses,expensive,experience,experienced,experiences,experiencing,experiment,experimental,experiments,expert,expertise,experts,expiration,expired,expires,explain,explained,explaining,explains,explanation,explicit,explicitly,exploration,explore,explorer,exploring,explosion,expo,export,exports,exposed,exposure,express,expressed,expression,expressions,ext,extend,extended,extending,extends,extension,extensions,extensive,extent,exterior,external,extra,extract,extraction,extraordinary,extras,extreme,extremely,eye,eyed,eyes,ez,f,fa,fabric,fabrics,fabulous,face,faced,faces,facial,facilitate,facilities,facility,facing,fact,factor,factors,factory,facts,faculty,fail,failed,failing,fails,failure,failures,fair,fairfield,fairly,fairy,faith,fake,fall,fallen,falling,falls,FALSE,fame,familiar,families,family,famous,fan,fancy,fans,fantastic,fantasy,faq,faqs,far,fare,fares,farm,farmer,farmers,farming,farms,fascinating,fashion,fast,faster,fastest,fat,fatal,fate,father,fathers,fatty,fault,favor,favorite,favorites,favors,favour,favourite,favourites,fax,fbi,fc,fcc,fd,fda,fe,fear,fears,feat,feature,featured,features,featuring,feb,february,fed,federal,federation,fee,feed,feedback,feeding,feeds,feel,feeling,feelings,feels,fees,feet,fell,fellow,fellowship,felt,female,females,fence,feof,ferrari,ferry,festival,festivals,fetish,fever,few,fewer,ff,fg,fi,fiber,fibre,fiction,field,fields,fifteen,fifth,fifty,fig,fight,fighter,fighters,fighting,figure,figured,figures,fiji,file,filed,filename,files,filing,fill,filled,filling,film,filme,films,filter,filtering,filters,fin,final,finally,finals,finance,finances,financial,financing,find,findarticles,finder,finding,findings,findlaw,finds,fine,finest,finger,fingering,fingers,finish,finished,finishing,finite,finland,finnish,fioricet,fire,fired,firefox,fireplace,fires,firewall,firewire,firm,firms,firmware,first,fiscal,fish,fisher,fisheries,fishing,fist,fisting,fit,fitness,fits,fitted,fitting,five,fix,fixed,fixes,fixtures,fl,flag,flags,flame,flash,flashers,flashing,flat,flavor,fleece,fleet,flesh,flex,flexibility,flexible,flickr,flight,flights,flip,float,floating,flood,floor,flooring,floors,floppy,floral,florence,florida,florist,florists,flour,flow,flower,flowers,flows,floyd,flu,fluid,flush,flux,fly,flyer,flying,fm,fo,foam,focal,focus,focused,focuses,focusing,fog,fold,folder,folders,folding,folk,folks,follow,followed,following,follows,font,fonts,foo,food,foods,fool,foot,footage,football,footwear,for,forbes,forbidden,force,forced,forces,ford,forecast,forecasts,foreign,forest,forestry,forests,forever,forge,forget,forgot,forgotten,fork,form,formal,format,formation,formats,formatting,formed,former,formerly,forming,forms,formula,fort,forth,fortune,forty,forum,forums,forward,forwarding,fossil,foster,foto,fotos,fought,foul,found,foundation,foundations,founded,founder,fountain,four,fourth,fox,fp,fr,fraction,fragrance,fragrances,frame,framed,frames,framework,framing,france,franchise,francis,francisco,frank,frankfurt,franklin,fraser,fraud,fred,frederick,free,freebsd,freedom,freelance,freely,freeware,freeze,freight,french,frequencies,frequency,frequent,frequently,fresh,fri,friday,fridge,friend,friendly,friends,friendship,frog,from,front,frontier,frontpage,frost,frozen,fruit,fruits,fs,ft,ftp,fu,fuck,fucked,fucking,fuel,fuji,fujitsu,full,fully,fun,function,functional,functionality,functioning,functions,fund,fundamental,fundamentals,funded,funding,fundraising,funds,funeral,funk,funky,funny,fur,furnished,furnishings,furniture,further,furthermore,fusion,future,futures,fuzzy,fw,fwd,fx,fy,g,ga,gabriel,gadgets,gage,gain,gained,gains,galaxy,gale,galleries,gallery,gambling,game,gamecube,games,gamespot,gaming,gamma,gang,gangbang,gap,gaps,garage,garbage,garcia,garden,gardening,gardens,garlic,garmin,gary,gas,gasoline,gate,gates,gateway,gather,gathered,gathering,gauge,gave,gay,gays,gazette,gb,gba,gbp,gc,gcc,gd,gdp,ge,gear,geek,gel,gem,gen,gender,gene,genealogy,general,generally,generate,generated,generates,generating,generation,generations,generator,generators,generic,generous,genes,genesis,genetic,genetics,geneva,genius,genome,genre,genres,gentle,gentleman,gently,genuine,geo,geographic,geographical,geography,geological,geology,geometry,george,georgia,gerald,german,germany,get,gets,getting,gg,ghana,ghost,ghz,gi,giant,giants,gibraltar,gibson,gif,gift,gifts,gig,gilbert,girl,girlfriend,girls,gis,give,given,gives,giving,gl,glad,glance,glasgow,glass,glasses,glen,glenn,global,globe,glory,glossary,gloves,glow,glucose,gm,gmbh,gmc,gmt,gnome,gnu,go,goal,goals,goat,god,gods,goes,going,gold,golden,golf,gone,gonna,good,goods,google,gordon,gore,gorgeous,gospel,gossip,got,gothic,goto,gotta,gotten,gourmet,governance,governing,government,governmental,governments,governor,gp,gpl,gps,gr,grab,grace,grad,grade,grades,gradually,graduate,graduated,graduates,graduation,graham,grain,grammar,grams,grand,grande,granny,grant,granted,grants,graph,graphic,graphical,graphics,graphs,gras,grass,grateful,gratis,gratuit,grave,gravity,gray,great,greater,greatest,greatly,greece,greek,green,greene,greenhouse,greensboro,greeting,greetings,greg,gregory,grenada,grew,grey,grid,griffin,grill,grip,grocery,groove,gross,ground,grounds,groundwater,group,groups,grove,grow,growing,grown,grows,growth,gs,gsm,gst,gt,gtk,guam,guarantee,guaranteed,guarantees,guard,guardian,guards,guatemala,guess,guest,guestbook,guests,gui,guidance,guide,guided,guidelines,guides,guild,guilty,guinea,guitar,guitars,gulf,gun,guns,guru,guy,guyana,guys,gym,gzip,h,ha,habitat,habits,hack,hacker,had,hair,hairy,haiti,half,halifax,hall,halloween,halo,ham,hamburg,hamilton,hammer,hampshire,hampton,hand,handbags,handbook,handed,handheld,handhelds,handjob,handjobs,handle,handled,handles,handling,handmade,hands,handy,hang,hanging,hans,hansen,happen,happened,happening,happens,happiness,happy,harassment,harbor,harbour,hard,hardcore,hardcover,harder,hardly,hardware,hardwood,harley,harm,harmful,harmony,harold,harper,harris,harrison,harry,hart,hartford,harvard,harvest,harvey,has,hash,hat,hate,hats,have,haven,having,hawaii,hawaiian,hawk,hay,hayes,hazard,hazardous,hazards,hb,hc,hd,hdtv,he,head,headed,header,headers,heading,headline,headlines,headphones,headquarters,heads,headset,healing,health,healthcare,healthy,hear,heard,hearing,hearings,heart,hearts,heat,heated,heater,heath,heather,heating,heaven,heavily,heavy,hebrew,heel,height,heights,held,helen,helena,helicopter,hell,hello,helmet,help,helped,helpful,helping,helps,hence,henderson,henry,hentai,hepatitis,her,herald,herb,herbal,herbs,here,hereby,herein,heritage,hero,heroes,herself,hewlett,hey,hh,hi,hidden,hide,hierarchy,high,higher,highest,highland,highlight,highlighted,highlights,highly,highs,highway,highways,hiking,hill,hills,hilton,him,himself,hindu,hint,hints,hip,hire,hired,hiring,his,hispanic,hist,historic,historical,history,hit,hitachi,hits,hitting,hiv,hk,hl,ho,hobbies,hobby,hockey,hold,holdem,holder,holders,holding,holdings,holds,hole,holes,holiday,holidays,holland,hollow,holly,hollywood,holmes,holocaust,holy,home,homeland,homeless,homepage,homes,hometown,homework,hon,honda,honduras,honest,honey,hong,honolulu,honor,honors,hood,hook,hop,hope,hoped,hopefully,hopes,hoping,hopkins,horizon,horizontal,hormone,horn,horny,horrible,horror,horse,horses,hose,hospital,hospitality,hospitals,host,hosted,hostel,hostels,hosting,hosts,hot,hotel,hotels,hotmail,hottest,hour,hourly,hours,house,household,households,houses,housewares,housewives,housing,houston,how,howard,however,howto,hp,hq,hr,href,hrs,hs,ht,html,http,hu,hub,hudson,huge,hugh,hughes,hugo,hull,human,humanitarian,humanities,humanity,humans,humidity,humor,hundred,hundreds,hung,hungarian,hungary,hunger,hungry,hunt,hunter,hunting,huntington,hurricane,hurt,husband,hwy,hybrid,hydraulic,hydrocodone,hydrogen,hygiene,hypothesis,hypothetical,hyundai,ia,ian,ibm,ic,ice,iceland,icon,icons,icq,ict,id,idaho,ide,idea,ideal,ideas,identical,identification,identified,identifier,identifies,identify,identifying,identity,idle,idol,ids,ie,ieee,if,ignore,ignored,ii,iii,il,ill,illegal,illinois,illness,illustrated,illustration,illustrations,im,image,images,imagination,imagine,imaging,img,immediate,immediately,immigrants,immigration,immune,immunology,impact,impacts,impaired,imperial,implement,implementation,implemented,implementing,implications,implied,implies,import,importance,important,importantly,imported,imports,impose,imposed,impossible,impressed,impression,impressive,improve,improved,improvement,improvements,improving,in,inappropriate,inbox,inc,incentive,incentives,incest,inch,inches,incidence,incident,incidents,incl,include,included,includes,including,inclusion,inclusive,income,incoming,incomplete,incorporate,incorporated,incorrect,increase,increased,increases,increasing,increasingly,incredible,incurred,ind,indeed,independence,independent,independently,index,indexed,indexes,india,indian,indiana,indianapolis,indians,indicate,indicated,indicates,indicating,indication,indicator,indicators,indices,indie,indigenous,indirect,individual,individually,individuals,indonesia,indonesian,indoor,induced,induction,industrial,industries,industry,inexpensive,inf,infant,infants,infected,infection,infections,infectious,infinite,inflation,influence,influenced,influences,info,inform,informal,information,informational,informative,informed,infrared,infrastructure,infringement,ing,ingredients,inherited,initial,initially,initiated,initiative,initiatives,injection,injured,injuries,injury,ink,inkjet,inline,inn,inner,innocent,innovation,innovations,innovative,inns,input,inputs,inquire,inquiries,inquiry,ins,insects,insert,inserted,insertion,inside,insider,insight,insights,inspection,inspections,inspector,inspiration,inspired,install,installation,installations,installed,installing,instance,instances,instant,instantly,instead,institute,institutes,institution,institutional,institutions,instruction,instructional,instructions,instructor,instructors,instrument,instrumental,instrumentation,instruments,insulation,insulin,insurance,insured,int,intake,integer,integral,integrate,integrated,integrating,integration,integrity,intel,intellectual,intelligence,intelligent,intend,intended,intense,intensity,intensive,intent,intention,inter,interact,interaction,interactions,interactive,interest,interested,interesting,interests,interface,interfaces,interference,interim,interior,intermediate,internal,international,internationally,internet,internship,interpretation,interpreted,interracial,intersection,interstate,interval,intervals,intervention,interventions,interview,interviews,intimate,intl,into,intranet,intro,introduce,introduced,introduces,introducing,introduction,introductory,invalid,invasion,invention,inventory,invest,investigate,investigated,investigation,investigations,investigator,investigators,investing,investment,investments,investor,investors,invisible,invision,invitation,invitations,invite,invited,invoice,involve,involved,involvement,involves,involving,io,ion,iowa,ip,ipaq,ipod,ips,ir,ira,iran,iraq,iraqi,irc,ireland,irish,iron,irrigation,irs,is,isa,isaac,isbn,islam,islamic,island,islands,isle,iso,isolated,isolation,isp,israel,israeli,issn,issue,issued,issues,ist,istanbul,it,italia,italian,italiano,italic,italy,item,items,its,itself,itunes,iv,ivory,ix,j,ja,jack,jacket,jackets,jackie,jackson,jacksonville,jacob,jade,jaguar,jail,jake,jam,jamaica,james,jamie,jan,jane,janet,january,japan,japanese,jar,jason,java,javascript,jay,jazz,jc,jd,je,jean,jeans,jeep,jeff,jefferson,jeffrey,jelsoft,jennifer,jenny,jeremy,jerry,jersey,jerusalem,jesse,jessica,jesus,jet,jets,jewel,jewellery,jewelry,jewish,jews,jill,jim,jimmy,jj,jm,jo,joan,job,jobs,joe,joel,john,johnny,johns,johnson,johnston,join,joined,joining,joins,joint,joke,jokes,jon,jonathan,jones,jordan,jose,joseph,josh,joshua,journal,journalism,journalist,journalists,journals,journey,joy,joyce,jp,jpeg,jpg,jr,js,juan,judge,judges,judgment,judicial,judy,juice,jul,julia,julian,julie,july,jump,jumping,jun,junction,june,jungle,junior,junk,jurisdiction,jury,just,justice,justify,justin,juvenile,jvc,k,ka,kai,kansas,karaoke,karen,karl,karma,kate,kathy,katie,katrina,kay,kazakhstan,kb,kde,keen,keep,keeping,keeps,keith,kelkoo,kelly,ken,kennedy,kenneth,kenny,keno,kent,kentucky,kenya,kept,kernel,kerry,kevin,key,keyboard,keyboards,keys,keyword,keywords,kg,kick,kid,kidney,kids,kijiji,kill,killed,killer,killing,kills,kilometers,kim,kinase,kind,kinda,kinds,king,kingdom,kings,kingston,kirk,kiss,kissing,kit,kitchen,kits,kitty,klein,km,knee,knew,knife,knight,knights,knit,knitting,knives,knock,know,knowing,knowledge,knowledgestorm,known,knows,ko,kodak,kong,korea,korean,kruger,ks,kurt,kuwait,kw,ky,kyle,".toLowerCase();
        String dictionary = ""+getStringChangeMerchantCategory4.toLowerCase();

        String[] splitMerchantName = where_at.split("\\W");

        for (String wordInMerchantName : splitMerchantName){

            if (wordInMerchantName.length()>2) {

                if (dictionary.contains(","+wordInMerchantName.toLowerCase()+",")) {
                    merchantCategory = stringChangeMerchantCategory[12];
                    break;

                }

            }

        }

        if (merchantCategory.isEmpty()){

            String getStringChangeMerchantCategory5 = frameworkWords.getStringChangeMerchantCategory5();
            //String dictionary2 = ",lab,label,labeled,labels,labor,laboratories,laboratory,labour,labs,lace,lack,ladder,laden,ladies,lady,lafayette,laid,lake,lakes,lamb,lambda,lamp,lamps,lan,lancaster,lance,land,landing,lands,landscape,landscapes,lane,lanes,lang,language,languages,lanka,laos,lap,laptop,laptops,large,largely,larger,largest,larry,las,laser,last,lasting,lat,late,lately,later,latest,latex,latin,latina,latinas,latino,latitude,latter,latvia,lauderdale,laugh,laughing,launch,launched,launches,laundry,laura,lauren,law,lawn,lawrence,laws,lawsuit,lawyer,lawyers,lay,layer,layers,layout,lazy,lb,lbs,lc,lcd,ld,le,lead,leader,leaders,leadership,leading,leads,leaf,league,lean,learn,learned,learners,learning,lease,leasing,least,leather,leave,leaves,leaving,lebanon,lecture,lectures,led,lee,leeds,left,leg,legacy,legal,legally,legend,legendary,legends,legislation,legislative,legislature,legitimate,legs,leisure,lemon,len,lender,lenders,lending,length,lens,lenses,leo,leon,leonard,leone,les,lesbian,lesbians,leslie,less,lesser,lesson,lessons,let,lets,letter,letters,letting,leu,level,levels,levitra,levy,lewis,lexington,lexmark,lexus,lf,lg,li,liabilities,liability,liable,lib,liberal,liberia,liberty,librarian,libraries,library,libs,licence,license,licensed,licenses,licensing,licking,lid,lie,liechtenstein,lies,life,lifestyle,lifetime,lift,light,lightbox,lighter,lighting,lightning,lights,lightweight,like,liked,likelihood,likely,likes,likewise,lil,lime,limit,limitation,limitations,limited,limiting,limits,limousines,lincoln,linda,lindsay,line,linear,lined,lines,lingerie,link,linked,linking,links,linux,lion,lions,lip,lips,liquid,lisa,list,listed,listen,listening,listing,listings,listprice,lists,lit,lite,literacy,literally,literary,literature,lithuania,litigation,little,live,livecam,lived,liver,liverpool,lives,livesex,livestock,living,liz,ll,llc,lloyd,llp,lm,ln,lo,load,loaded,loading,loads,loan,loans,lobby,loc,local,locale,locally,locate,located,location,locations,locator,lock,locked,locking,locks,lodge,lodging,log,logan,logged,logging,logic,logical,login,logistics,logitech,logo,logos,logs,lol,lolita,london,lone,lonely,long,longer,longest,longitude,look,looked,looking,looks,looksmart,lookup,loop,loops,loose,lopez,lord,los,lose,losing,loss,losses,lost,lot,lots,lottery,lotus,lou,loud,louis,louise,louisiana,louisville,lounge,love,loved,lovely,lover,lovers,loves,loving,low,lower,lowest,lows,lp,ls,lt,ltd,lu,lucas,lucia,luck,lucky,lucy,luggage,luis,luke,lunch,lung,luther,luxembourg,luxury,lycos,lying,lynn,lyric,lyrics,m,ma,mac,macedonia,machine,machinery,machines,macintosh,macro,macromedia,mad,madagascar,made,madison,madness,madonna,madrid,mae,mag,magazine,magazines,magic,magical,magnet,magnetic,magnificent,magnitude,mai,maiden,mail,mailed,mailing,mailman,mails,mailto,main,maine,mainland,mainly,mainstream,maintain,maintained,maintaining,maintains,maintenance,major,majority,make,maker,makers,makes,makeup,making,malawi,malaysia,maldives,male,males,mali,mall,malpractice,malta,mambo,man,manage,managed,management,manager,managers,managing,manchester,mandate,mandatory,manga,manhattan,manitoba,manner,manor,manual,manually,manuals,manufacture,manufactured,manufacturer,manufacturers,manufacturing,many,map,maple,mapping,maps,mar,marathon,marble,marc,march,marco,marcus,mardi,margaret,margin,maria,mariah,marie,marijuana,marilyn,marina,marine,mario,marion,maritime,mark,marked,marker,markers,market,marketing,marketplace,markets,marking,marks,marriage,married,marriott,mars,marsh,marshall,mart,martha,martial,martin,marvel,mary,maryland,mas,mask,mason,mass,massachusetts,massage,massive,master,mastercard,masters,masturbating,masturbation,mat,match,matched,matches,matching,mate,material,materials,maternity,math,mathematical,mathematics,mating,matrix,mats,matt,matter,matters,matthew,mattress,mature,maui,mauritius,max,maximize,maximum,may,maybe,mayor,mazda,mb,mba,mc,mcdonald,md,me,meal,meals,mean,meaning,meaningful,means,meant,meanwhile,measure,measured,measurement,measurements,measures,measuring,meat,mechanical,mechanics,mechanism,mechanisms,med,medal,media,median,mediawiki,medicaid,medical,medicare,medication,medications,medicine,medicines,medieval,meditation,mediterranean,medium,medline,meet,meeting,meetings,meets,meetup,mega,mel,melbourne,melissa,mem,member,members,membership,membrane,memo,memorabilia,memorial,memories,memory,memphis,men,mens,ment,mental,mention,mentioned,mentor,menu,menus,mercedes,merchandise,merchant,merchants,mercury,mercy,mere,merely,merge,merger,merit,merry,mesa,mesh,mess,message,messages,messaging,messenger,met,meta,metabolism,metadata,metal,metallic,metallica,metals,meter,meters,method,methodology,methods,metres,metric,metro,metropolitan,mexican,mexico,meyer,mf,mg,mh,mhz,mi,mia,miami,mic,mice,michael,michel,michelle,michigan,micro,microphone,microsoft,microwave,mid,middle,midi,midlands,midnight,midwest,might,mighty,migration,mike,mil,milan,mild,mile,mileage,miles,milf,milfhunter,milfs,military,milk,mill,millennium,miller,million,millions,mills,milton,milwaukee,mime,min,mind,minds,mine,mineral,minerals,mines,mini,miniature,minimal,minimize,minimum,mining,minister,ministers,ministries,ministry,minneapolis,minnesota,minolta,minor,minority,mins,mint,minus,minute,minutes,miracle,mirror,mirrors,misc,miscellaneous,miss,missed,missile,missing,mission,missions,mississippi,missouri,mistake,mistakes,mistress,mit,mitchell,mitsubishi,mix,mixed,mixer,mixing,mixture,mj,ml,mlb,mls,mm,mn,mo,mobile,mobiles,mobility,mod,mode,model,modeling,modelling,models,modem,modems,moderate,moderator,moderators,modern,modes,modification,modifications,modified,modify,mods,modular,module,modules,moisture,mold,moldova,molecular,molecules,mom,moment,moments,momentum,moms,mon,monaco,monday,monetary,money,mongolia,monica,monitor,monitored,monitoring,monitors,monkey,mono,monroe,monster,monsters,montana,monte,montgomery,month,monthly,months,montreal,mood,moon,moore,moral,more,moreover,morgan,morning,morocco,morris,morrison,mortality,mortgage,mortgages,moscow,moses,moss,most,mostly,motel,motels,mother,motherboard,mothers,motion,motivated,motivation,motor,motorcycle,motorcycles,motorola,motors,mount,mountain,mountains,mounted,mounting,mounts,mouse,mouth,move,moved,movement,movements,movers,moves,movie,movies,moving,mozambique,mozilla,mp,mpeg,mpegs,mpg,mph,mr,mrna,mrs,ms,msg,msgid,msgstr,msie,msn,mt,mtv,mu,much,mud,mug,multi,multimedia,multiple,mumbai,munich,municipal,municipality,murder,murphy,murray,muscle,muscles,museum,museums,music,musical,musician,musicians,muslim,muslims,must,mustang,mutual,muze,mv,mw,mx,my,myanmar,myers,myrtle,myself,mysimon,myspace,mysql,mysterious,mystery,myth,n,na,nail,nails,naked,nam,name,named,namely,names,namespace,namibia,nancy,nano,naples,narrative,narrow,nasa,nascar,nasdaq,nashville,nasty,nat,nathan,nation,national,nationally,nations,nationwide,native,nato,natural,naturally,naturals,nature,naughty,nav,naval,navigate,navigation,navigator,navy,nb,nba,nbc,nc,ncaa,nd,ne,near,nearby,nearest,nearly,nebraska,nec,necessarily,necessary,necessity,neck,necklace,need,needed,needle,needs,negative,negotiation,negotiations,neighbor,neighborhood,neighbors,neil,neither,nelson,neo,neon,nepal,nerve,nervous,nest,nested,net,netherlands,netscape,network,networking,networks,neural,neutral,nevada,never,nevertheless,new,newark,newbie,newcastle,newer,newest,newfoundland,newly,newman,newport,news,newsletter,newsletters,newspaper,newspapers,newton,next,nextel,nfl,ng,nh,nhl,nhs,ni,niagara,nicaragua,nice,nicholas,nick,nickel,nickname,nicole,niger,nigeria,night,nightlife,nightmare,nights,nike,nikon,nil,nine,nintendo,nipple,nipples,nirvana,nissan,nitrogen,nj,nl,nm,nn,no,noble,nobody,node,nodes,noise,nokia,nominated,nomination,nominations,non,none,nonprofit,noon,nor,norfolk,norm,normal,normally,norman,north,northeast,northern,northwest,norton,norway,norwegian,nose,not,note,notebook,notebooks,noted,notes,nothing,notice,noticed,notices,notification,notifications,notified,notify,notion,notre,nottingham,nov,nova,novel,novels,novelty,november,now,nowhere,np,nr,ns,nsw,nt,ntsc,nu,nuclear,nude,nudist,nudity,nuke,null,number,numbers,numeric,numerical,numerous,nurse,nursery,nurses,nursing,nut,nutrition,nutritional,nuts,nutten,nv,nvidia,nw,ny,nyc,nylon,nz,o,oak,oakland,oaks,oasis,ob,obesity,obituaries,obj,object,objective,objectives,objects,obligation,obligations,observation,observations,observe,observed,observer,obtain,obtained,obtaining,obvious,obviously,oc,occasion,occasional,occasionally,occasions,occupation,occupational,occupations,occupied,occur,occurred,occurrence,occurring,occurs,ocean,oclc,oct,october,odd,odds,oe,oecd,oem,of,off,offense,offensive,offer,offered,offering,offerings,offers,office,officer,officers,offices,official,officially,officials,offline,offset,offshore,often,og,oh,ohio,oil,oils,ok,okay,oklahoma,ol,old,older,oldest,olive,oliver,olympic,olympics,olympus,om,omaha,oman,omega,omissions,on,once,one,ones,ongoing,onion,online,only,ons,ontario,onto,oo,ooo,oops,op,open,opened,opening,openings,opens,opera,operate,operated,operates,operating,operation,operational,operations,operator,operators,opinion,opinions,opponent,opponents,opportunities,opportunity,opposed,opposite,opposition,opt,optical,optics,optimal,optimization,optimize,optimum,option,optional,options,or,oracle,oral,orange,orbit,orchestra,order,ordered,ordering,orders,ordinance,ordinary,oregon,org,organ,organic,organisation,organisations,organised,organisms,organization,organizational,organizations,organize,organized,organizer,organizing,orgasm,orgy,oriental,orientation,oriented,origin,original,originally,origins,orlando,orleans,os,oscar,ot,other,others,otherwise,ottawa,ou,ought,our,ours,ourselves,out,outcome,outcomes,outdoor,outdoors,outer,outlet,outlets,outline,outlined,outlook,output,outputs,outreach,outside,outsourcing,outstanding,oval,oven,over,overall,overcome,overhead,overnight,overseas,overview,owen,own,owned,owner,owners,ownership,owns,oxford,oxide,oxygen,oz,ozone,pace,pacific,pack,package,packages,packaging,packard,packed,packet,packets,packing,packs,pad,pads,page,pages,paid,pain,painful,paint,paintball,painted,painting,paintings,pair,pairs,pakistan,pal,palace,pale,palestine,palestinian,palm,palmer,pam,pamela,pan,panama,panasonic,panel,panels,panic,panties,pants,pantyhose,paper,paperback,paperbacks,papers,papua,par,para,parade,paradise,paragraph,paragraphs,paraguay,parallel,parameter,parameters,parcel,parent,parental,parenting,parents,paris,parish,park,parker,parking,parks,parliament,parliamentary,part,partial,partially,participant,participants,participate,participated,participating,participation,particle,particles,particular,particularly,parties,partition,partly,partner,partners,partnership,partnerships,parts,party,pas,paso,pass,passage,passed,passenger,passengers,passes,passing,passion,passive,passport,password,passwords,past,pasta,paste,pastor,pat,patch,patches,patent,patents,path,pathology,paths,patient,patients,patio,patricia,patrick,patrol,pattern,patterns,paul,pavilion,paxil,pay,payable,payday,paying,payment,payments,paypal,payroll,pays,pb,pc,pci,pcs,pct,pd,pda,pdas,pdf,pdt,pe,peace,peaceful,peak,pearl,peas,pediatric,pee,peeing,peer,peers,pen,penalties,penalty,pencil,pendant,pending,penetration,penguin,peninsula,penis,penn,pennsylvania,penny,pens,pension,pensions,pentium,people,peoples,pepper,per,perceived,percent,percentage,perception,perfect,perfectly,perform,performance,performances,performed,performer,performing,performs,perfume,perhaps,period,periodic,periodically,periods,peripheral,peripherals,perl,permalink,permanent,permission,permissions,permit,permits,permitted,perry,persian,persistent,person,personal,personality,personalized,personally,personals,personnel,persons,perspective,perspectives,perth,peru,pest,pet,pete,peter,petersburg,peterson,petite,petition,petroleum,pets,pf,pg,pgp,ph,phantom,pharmaceutical,pharmaceuticals,pharmacies,pharmacology,pharmacy,phase,phases,phd,phenomenon,phentermine,phi,phil,philadelphia,philip,philippines,philips,phillips,philosophy,phoenix,phone,phones,photo,photograph,photographer,photographers,photographic,photographs,photography,photos,photoshop,php,phpbb,phrase,phrases,phys,physical,physically,physician,physicians,physics,physiology,pi,piano,pic,pichunter,pick,picked,picking,picks,pickup,picnic,pics,picture,pictures,pie,piece,pieces,pierce,pierre,pig,pike,pill,pillow,pills,pilot,pin,pine,ping,pink,pins,pioneer,pipe,pipeline,pipes,pirates,piss,pissing,pit,pitch,pittsburgh,pix,pixel,pixels,pizza,pj,pk,pl,place,placed,placement,places,placing,plain,plains,plaintiff,plan,plane,planes,planet,planets,planned,planner,planners,planning,plans,plant,plants,plasma,plastic,plastics,plate,plates,platform,platforms,platinum,play,playback,playboy,played,player,players,playing,playlist,plays,playstation,plaza,plc,pleasant,please,pleased,pleasure,pledge,plenty,plot,plots,plug,plugin,plugins,plumbing,plus,plymouth,pm,pmc,pmid,pn,po,pocket,pockets,pod,podcast,podcasts,poem,poems,poet,poetry,point,pointed,pointer,pointing,points,poison,pokemon,poker,poland,polar,pole,police,policies,policy,polish,polished,political,politicians,politics,poll,polls,pollution,polo,poly,polyester,polymer,polyphonic,pond,pontiac,pool,pools,poor,pop,pope,popular,popularity,population,populations,por,porcelain,pork,porn,porno,porsche,port,portable,portal,porter,portfolio,portion,portions,portland,portrait,portraits,ports,portsmouth,portugal,portuguese,pos,pose,posing,position,positioning,positions,positive,possess,possession,possibilities,possibility,possible,possibly,post,postage,postal,postcard,postcards,posted,poster,posters,posting,postings,postposted,posts,pot,potato,potatoes,potential,potentially,potter,pottery,poultry,pound,pounds,pour,poverty,powder,powell,power,powered,powerful,powerpoint,powers,powerseller,pp,ppc,ppm,pr,practical,practice,practices,practitioner,practitioners,prague,prairie,praise,pray,prayer,prayers,pre,preceding,precious,precipitation,precise,precisely,precision,predict,predicted,prediction,predictions,prefer,preference,preferences,preferred,prefers,prefix,pregnancy,pregnant,preliminary,premier,premiere,premises,premium,prep,prepaid,preparation,prepare,prepared,preparing,prerequisite,prescribed,prescription,presence,present,presentation,presentations,presented,presenting,presently,presents,preservation,preserve,president,presidential,press,pressed,pressing,pressure,preston,pretty,prev,prevent,preventing,prevention,preview,previews,previous,previously,price,priced,prices,pricing,pride,priest,primarily,primary,prime,prince,princess,princeton,principal,principle,principles,print,printable,printed,printer,printers,printing,prints,prior,priorities,priority,prison,prisoner,prisoners,privacy,private,privilege,privileges,prix,prize,prizes,pro,probability,probably,probe,problem,problems,proc,procedure,procedures,proceed,proceeding,proceedings,proceeds,process,processed,processes,processing,processor,processors,procurement,produce,produced,producer,producers,produces,producing,product,production,productions,productive,productivity,products,profession,professional,professionals,professor,profile,profiles,profit,profits,program,programme,programmer,programmers,programmes,programming,programs,progress,progressive,prohibited,project,projected,projection,projector,projectors,projects,prominent,promise,promised,promises,promising,promo,promote,promoted,promotes,promoting,promotion,promotional,promotions,prompt,promptly,proof,propecia,proper,properly,properties,property,prophet,proportion,proposal,proposals,propose,proposed,proposition,proprietary,pros,prospect,prospective,prospects,prostate,prostores,prot,protect,protected,protecting,protection,protective,protein,proteins,protest,protocol,protocols,prototype,proud,proudly,prove,proved,proven,provide,provided,providence,provider,providers,provides,providing,province,provinces,provincial,provision,provisions,proxy,prozac,ps,psi,psp,pst,psychiatry,psychological,psychology,pt,pts,pty,pub,public,publication,publications,publicity,publicly,publish,published,publisher,publishers,publishing,pubmed,pubs,puerto,pull,pulled,pulling,pulse,pump,pumps,punch,punishment,punk,pupils,puppy,purchase,purchased,purchases,purchasing,pure,purple,purpose,purposes,purse,pursuant,pursue,pursuit,push,pushed,pushing,pussy,put,puts,putting,puzzle,puzzles,pvc,python,q,qatar,qc,qld,qt,qty,quad,qualification,qualifications,qualified,qualify,qualifying,qualities,quality,quantitative,quantities,quantity,quantum,quarter,quarterly,quarters,que,quebec,queen,queens,queensland,queries,query,quest,question,questionnaire,questions,queue,qui,quick,quickly,quiet,quilt,quit,quite,quiz,quizzes,quotations,quote,quoted,quotes,r,ra,rabbit,race,races,rachel,racial,racing,rack,racks,radar,radiation,radical,radio,radios,radius,rage,raid,rail,railroad,railway,rain,rainbow,raise,raised,raises,raising,raleigh,rally,ralph,ram,ran,ranch,rand,random,randy,range,ranger,rangers,ranges,ranging,rank,ranked,ranking,rankings,ranks,rap,rape,rapid,rapidly,rapids,rare,rarely,rat,rate,rated,rates,rather,rating,ratings,ratio,rational,ratios,rats,raw,ray,raymond,rays,rb,rc,rca,rd,re,reach,reached,reaches,reaching,reaction,reactions,read,reader,readers,readily,reading,readings,reads,ready,real,realistic,reality,realize,realized,really,realm,realtor,realtors,realty,rear,reason,reasonable,reasonably,reasoning,reasons,rebate,rebates,rebecca,rebel,rebound,rec,recall,receipt,receive,received,receiver,receivers,receives,receiving,recent,recently,reception,receptor,receptors,recipe,recipes,recipient,recipients,recognised,recognition,recognize,recognized,recommend,recommendation,recommendations,recommended,recommends,reconstruction,record,recorded,recorder,recorders,recording,recordings,records,recover,recovered,recovery,recreation,recreational,recruiting,recruitment,recycling,red,redeem,redhead,reduce,reduced,reduces,reducing,reduction,reductions,reed,reef,reel,ref,refer,reference,referenced,references,referral,referrals,referred,referring,refers,refinance,refine,refined,reflect,reflected,reflection,reflections,reflects,reform,reforms,refresh,refrigerator,refugees,refund,refurbished,refuse,refused,reg,regard,regarded,regarding,regardless,regards,reggae,regime,region,regional,regions,register,registered,registrar,registration,registry,regression,regular,regularly,regulated,regulation,regulations,regulatory,rehab,rehabilitation,reid,reject,rejected,relate,related,relates,relating,relation,relations,relationship,relationships,relative,relatively,relatives,relax,relaxation,relay,release,released,releases,relevance,relevant,reliability,reliable,reliance,relief,religion,religions,religious,reload,relocation,rely,relying,remain,remainder,remained,remaining,remains,remark,remarkable,remarks,remedies,remedy,remember,remembered,remind,reminder,remix,remote,removable,removal,remove,removed,removing,renaissance,render,rendered,rendering,renew,renewable,renewal,reno,rent,rental,rentals,rep,repair,repairs,repeat,repeated,replace,replaced,replacement,replacing,replica,replication,replied,replies,reply,report,reported,reporter,reporters,reporting,reports,repository,represent,representation,representations,representative,representatives,represented,representing,represents,reprint,reprints,reproduce,reproduced,reproduction,reproductive,republic,republican,republicans,reputation,request,requested,requesting,requests,require,required,requirement,requirements,requires,requiring,res,rescue,research,researcher,researchers,reseller,reservation,reservations,reserve,reserved,reserves,reservoir,reset,residence,resident,residential,residents,resist,resistance,resistant,resolution,resolutions,resolve,resolved,resort,resorts,resource,resources,respect,respected,respective,respectively,respiratory,respond,responded,respondent,respondents,responding,response,responses,responsibilities,responsibility,responsible,rest,restaurant,restaurants,restoration,restore,restored,restrict,restricted,restriction,restrictions,restructuring,result,resulted,resulting,results,resume,resumes,retail,retailer,retailers,retain,retained,retention,retired,retirement,retreat,retrieval,retrieve,retrieved,retro,return,returned,returning,returns,reunion,reuters,rev,reveal,revealed,reveals,revelation,revenge,revenue,revenues,reverse,review,reviewed,reviewer,reviewing,reviews,revised,revision,revisions,revolution,revolutionary,reward,rewards,reynolds,rf,rfc,rg,rh,rhode,rhythm,ri,ribbon,rica,rice,rich,richard,richards,richardson,richmond,rick,ricky,rico,rid,ride,rider,riders,rides,ridge,riding,right,rights,rim,ring,rings,ringtone,ringtones,rio,rip,ripe,rise,rising,risk,risks,river,rivers,riverside,rj,rl,rm,rn,rna,ro,road,roads,rob,robbie,robert,roberts,robertson,robin,robinson,robot,robots,robust,rochester,rock,rocket,rocks,rocky,rod,roger,rogers,roland,role,roles,roll,rolled,roller,rolling,rolls,rom,roman,romance,romania,romantic,rome,ron,ronald,roof,room,roommate,roommates,rooms,root,roots,rope,rosa,rose,roses,ross,roster,rotary,rotation,rouge,rough,roughly,roulette,round,rounds,route,router,routers,routes,routine,routines,routing,rover,row,rows,roy,royal,royalty,rp,rpg,rpm,rr,rrp,rs,rss,rt,ru,rubber,ruby,rug,rugby,rugs,rule,ruled,rules,ruling,run,runner,running,runs,runtime,rural,rush,russell,russia,russian,ruth,rv,rw,rwanda,rx,ryan,sacramento,sacred,sacrifice,sad,saddam,safari,safe,safely,safer,safety,sage,sagem,said,sail,sailing,saint,saints,sake,salad,salaries,salary,sale,salem,sales,sally,salmon,salon,salt,salvador,salvation,sam,samba,same,samoa,sample,samples,sampling,samsung,samuel,san,sand,sandra,sandwich,sandy,sans,santa,sanyo,sao,sap,sapphire,sara,sarah,sas,saskatchewan,sat,satellite,satin,satisfaction,satisfactory,satisfied,satisfy,saturday,saturn,sauce,saudi,savage,savannah,save,saved,saver,saves,saving,savings,saw,say,saying,says,sb,sbjct,sc,scale,scales,scan,scanned,scanner,scanners,scanning,scared,scary,scenario,scenarios,scene,scenes,scenic,schedule,scheduled,schedules,scheduling,schema,scheme,schemes,scholar,scholars,scholarship,scholarships,school,schools,sci,science,sciences,scientific,scientist,scientists,scoop,scope,score,scored,scores,scoring,scotia,scotland,scott,scottish,scout,scratch,screen,screening,screens,screensaver,screensavers,screenshot,screenshots,screw,script,scripting,scripts,scroll,scsi,scuba,sculpture,sd,se,sea,seafood,seal,sealed,sean,search,searched,searches,searching,seas,season,seasonal,seasons,seat,seating,seats,seattle,sec,second,secondary,seconds,secret,secretariat,secretary,secrets,section,sections,sector,sectors,secure,secured,securely,securities,security,see,seed,seeds,seeing,seek,seeker,seekers,seeking,seeks,seem,seemed,seems,seen,sees,sega,segment,segments,select,selected,selecting,selection,selections,selective,self,sell,seller,sellers,selling,sells,semester,semi,semiconductor,seminar,seminars,sen,senate,senator,senators,send,sender,sending,sends,senegal,senior,seniors,sense,sensitive,sensitivity,sensor,sensors,sent,sentence,sentences,seo,sep,separate,separated,separately,separation,sept,september,seq,sequence,sequences,ser,serbia,serial,series,serious,seriously,serum,serve,served,server,servers,serves,service,services,serving,session,sessions,set,sets,setting,settings,settle,settled,settlement,setup,seven,seventh,several,severe,sewing,sex,sexcam,sexo,sexual,sexuality,sexually,sexy,sf,sg,sh,shade,shades,shadow,shadows,shaft,shake,shakespeare,shakira,shall,shame,shanghai,shannon,shape,shaped,shapes,share,shared,shareholders,shares,shareware,sharing,shark,sharon,sharp,shaved,shaw,she,shed,sheep,sheer,sheet,sheets,sheffield,shelf,shell,shelter,shemale,shemales,shepherd,sheriff,sherman,shield,shift,shine,ship,shipment,shipments,shipped,shipping,ships,shirt,shirts,shit,shock,shoe,shoes,shoot,shooting,shop,shopper,shoppers,shopping,shops,shopzilla,shore,short,shortcuts,shorter,shortly,shorts,shot,shots,should,shoulder,show,showcase,showed,shower,showers,showing,shown,shows,showtimes,shut,shuttle,si,sic,sick,side,sides,sie,siemens,sierra,sig,sight,sigma,sign,signal,signals,signature,signatures,signed,significance,significant,significantly,signing,signs,signup,silence,silent,silicon,silk,silly,silver,sim,similar,similarly,simon,simple,simplified,simply,simpson,simpsons,sims,simulation,simulations,simultaneously,sin,since,sing,singapore,singer,singh,singing,single,singles,sink,sip,sir,sister,sisters,sit,site,sitemap,sites,sitting,situated,situation,situations,six,sixth,size,sized,sizes,sk,skating,ski,skiing,skill,skilled,skills,skin,skins,skip,skirt,skirts,sku,sky,skype,sl,slave,sleep,sleeping,sleeps,sleeve,slide,slides,slideshow,slight,slightly,slim,slip,slope,slot,slots,slovak,slovakia,slovenia,slow,slowly,slut,sluts,sm,small,smaller,smallest,smart,smell,smile,smilies,smith,smithsonian,smoke,smoking,smooth,sms,smtp,sn,snake,snap,snapshot,snow,snowboard,so,soa,soap,soc,soccer,social,societies,society,sociology,socket,socks,sodium,sofa,soft,softball,software,soil,sol,solar,solaris,sold,soldier,soldiers,sole,solely,solid,solo,solomon,solution,solutions,solve,solved,solving,soma,somalia,some,somebody,somehow,someone,somerset,something,sometimes,somewhat,somewhere,son,song,songs,sonic,sons,sony,soon,soonest,sophisticated,sorry,sort,sorted,sorts,sought,soul,souls,sound,sounds,soundtrack,soup,source,sources,south,southampton,southeast,southern,southwest,soviet,sox,sp,spa,space,spaces,spain,spam,span,spanish,spank,spanking,sparc,spare,spas,spatial,speak,speaker,speakers,speaking,speaks,spears,spec,special,specialist,specialists,specialized,specializing,specially,specials,specialties,specialty,species,specific,specifically,specification,specifications,specifics,specified,specifies,specify,specs,spectacular,spectrum,speech,speeches,speed,speeds,spell,spelling,spencer,spend,spending,spent,sperm,sphere,spice,spider,spies,spin,spine,spirit,spirits,spiritual,spirituality,split,spoke,spoken,spokesman,sponsor,sponsored,sponsors,sponsorship,sport,sporting,sports,spot,spotlight,spots,spouse,spray,spread,spreading,spring,springer,springfield,springs,sprint,spy,spyware,sq,sql,squad,square,squirt,squirting,sr,src,sri,ss,ssl,st,stability,stable,stack,stadium,staff,staffing,stage,stages,stainless,stake,stakeholders,stamp,stamps,stan,stand,standard,standards,standing,standings,stands,stanford,stanley,star,starring,stars,starsmerchant,start,started,starter,starting,starts,startup,stat,state,stated,statement,statements,states,statewide,static,stating,station,stationery,stations,statistical,statistics,stats,status,statute,statutes,statutory,stay,stayed,staying,stays,std,ste,steady,steal,steam,steel,steering,stem,step,stephanie,stephen,steps,stereo,sterling,steve,steven,stevens,stewart,stick,sticker,stickers,sticks,sticky,still,stock,stockholm,stockings,stocks,stolen,stomach,stone,stones,stood,stop,stopped,stopping,stops,storage,store,stored,stores,stories,storm,story,str,straight,strain,strand,strange,stranger,strap,strategic,strategies,strategy,stream,streaming,streams,street,streets,strength,strengthen,strengthening,strengths,stress,stretch,strict,strictly,strike,strikes,striking,string,strings,strip,stripes,strips,stroke,strong,stronger,strongly,struck,struct,structural,structure,structured,structures,struggle,stuart,stuck,stud,student,students,studied,studies,studio,studios,study,studying,stuff,stuffed,stunning,stupid,style,styles,stylish,stylus,su,sub,subaru,subcommittee,subdivision,subject,subjective,subjects,sublime,sublimedirectory,submission,submissions,submit,submitted,submitting,subscribe,subscriber,subscribers,subscription,subscriptions,subsection,subsequent,subsequently,subsidiaries,subsidiary,substance,substances,substantial,substantially,substitute,subtle,suburban,succeed,success,successful,successfully,such,suck,sucking,sucks,sudan,sudden,suddenly,sue,suffer,suffered,suffering,sufficient,sufficiently,sugar,suggest,suggested,suggesting,suggestion,suggestions,suggests,suicide,suit,suitable,suite,suited,suites,suits,sullivan,sum,summaries,summary,summer,summit,sun,sunday,sunglasses,sunny,sunrise,sunset,sunshine,super,superb,superintendent,superior,supervision,supervisor,supervisors,supplement,supplemental,supplements,supplied,supplier,suppliers,supplies,supply,support,supported,supporters,supporting,supports,suppose,supposed,supreme,sur,sure,surely,surf,surface,surfaces,surfing,surge,surgeon,surgeons,surgery,surgical,surname,surplus,surprise,surprised,surprising,surrey,surround,surrounded,surrounding,surveillance,survey,surveys,survival,survive,survivor,survivors,susan,suse,suspect,suspected,suspended,suspension,sussex,sustainability,sustainable,sustained,suzuki,sv,sw,swap,swaziland,sweden,swedish,sweet,swift,swim,swimming,swing,swingers,swiss,switch,switched,switches,switching,switzerland,sword,sydney,symantec,symbol,symbols,sympathy,symphony,symposium,symptoms,sync,syndicate,syndication,syndrome,synopsis,syntax,synthesis,synthetic,syracuse,syria,sys,system,systematic,systems,t,ta,tab,table,tables,tablet,tablets,tabs,tackle,tactics,tag,tagged,tags,tahoe,tail,taiwan,take,taken,takes,taking,tale,talent,talented,tales,talk,talked,talking,talks,tall,tamil,tampa,tan,tank,tanks,tanzania,tap,tape,tapes,tar,target,targeted,targets,tariff,task,tasks,taste,tattoo,taught,tax,taxation,taxes,taxi,taylor,tb,tba,tc,tcp,td,te,tea,teach,teacher,teachers,teaches,teaching,team,teams,tear,tears,tech,technical,technician,technique,techniques,techno,technological,technologies,technology,techrepublic,ted,teddy,tee,teen,teenage,teens,teeth,tel,telecharger,telecom,telecommunications,telephone,telephony,telescope,television,televisions,tell,telling,tells,temp,temperature,temperatures,template,templates,temple,temporal,temporarily,temporary,ten,tenant,tend,tender,tennessee,tennis,tension,tent,term,terminal,terminals,termination,terminology,terms,terrace,terrain,terrible,territories,territory,terror,terrorism,terrorist,terrorists,terry,test,testament,tested,testimonials,testimony,testing,tests,tex,texas,text,textbook,textbooks,textile,textiles,texts,texture,tf,tft,tgp,th,thai,thailand,than,thank,thanks,thanksgiving,that,thats,the,theater,theaters,theatre,thee,theft,thehun,their,them,theme,themes,themselves,then,theology,theorem,theoretical,theories,theory,therapeutic,therapist,therapy,there,thereafter,thereby,therefore,thereof,thermal,thesaurus,these,thesis,theta,they,thick,thickness,thin,thing,things,think,thinking,thinkpad,thinks,third,thirty,this,thomas,thompson,thomson,thong,thongs,thorough,thoroughly,those,thou,though,thought,thoughts,thousand,thousands,thread,threaded,threads,threat,threatened,threatening,threats,three,threesome,threshold,thriller,throat,through,throughout,throw,throwing,thrown,throws,thru,thu,thumb,thumbnail,thumbnails,thumbs,thumbzilla,thunder,thursday,thus,thy,ti,ticket,tickets,tide,tie,tied,tier,ties,tiffany,tiger,tigers,tight,til,tile,tiles,till,tim,timber,time,timeline,timely,timer,times,timing,timothy,tin,tiny,tion,tions,tip,tips,tire,tired,tires,tissue,tit,titanium,titans,title,titled,titles,tits,titten,tm,tmp,tn,to,tobacco,tobago,today,todd,toddler,toe,together,toilet,token,tokyo,told,tolerance,toll,tom,tomato,tomatoes,tommy,tomorrow,ton,tone,toner,tones,tongue,tonight,tons,tony,too,took,tool,toolbar,toolbox,toolkit,tools,tooth,top,topic,topics,topless,tops,toronto,torture,toshiba,total,totally,totals,touch,touched,tough,tour,touring,tourism,tourist,tournament,tournaments,tours,toward,towards,tower,towers,town,towns,township,toxic,toy,toyota,toys,tp,tr,trace,track,trackback,trackbacks,tracked,tracker,tracking,tracks,tract,tractor,tracy,trade,trademark,trademarks,trader,trades,trading,tradition,traditional,traditions,traffic,tragedy,trail,trailer,trailers,trails,train,trained,trainer,trainers,training,trains,tramadol,trance,tranny,trans,transaction,transactions,transcript,transcription,transcripts,transexual,transexuales,transfer,transferred,transfers,transform,transformation,transit,transition,translate,translated,translation,translations,translator,transmission,transmit,transmitted,transparency,transparent,transport,Transportation,transsexual,trap,trash,trauma,Travel,Traveler,travelers,traveling,traveller,travelling,travels,travesti,travis,tray,treasure,treasurer,treasures,treasury,treat,treated,treating,treatment,treatments,treaty,tree,trees,trek,trembl,tremendous,trend,trends,treo,tri,trial,trials,triangle,tribal,tribe,tribes,tribunal,tribune,tribute,trick,tricks,tried,tries,trigger,trim,trinidad,trinity,trio,trip,tripadvisor,triple,trips,triumph,trivia,troops,tropical,trouble,troubleshooting,trout,troy,truck,trucks,TRUE,truly,trunk,trust,trusted,trustee,trustees,trusts,truth,try,trying,ts,tsunami,tt,tu,tub,tube,tubes,tucson,tue,tuesday,tuition,tulsa,tumor,tune,tuner,tunes,tuning,tunisia,tunnel,turbo,turkey,turkish,turn,turned,turner,turning,turns,turtle,tutorial,tutorials,tv,tvs,twelve,twenty,twice,twiki,twin,twinks,twins,twist,twisted,two,tx,ty,tyler,type,types,typical,typically,typing,u,uc,uganda,ugly,uh,ui,uk,ukraine,ul,ultimate,ultimately,ultra,ultram,um,un,una,unable,unauthorized,unavailable,uncertainty,uncle,und,undefined,under,undergraduate,underground,underlying,understand,understanding,understood,undertake,undertaken,underwear,undo,une,unemployment,unexpected,unfortunately,uni,unified,uniform,union,unions,uniprotkb,unique,unit,united,units,unity,univ,universal,universe,universities,university,unix,unknown,unless,unlike,unlikely,unlimited,unlock,unnecessary,unsigned,unsubscribe,until,untitled,unto,unusual,unwrap,up,upc,upcoming,update,updated,updates,updating,upgrade,upgrades,upgrading,upload,uploaded,upon,upper,ups,upset,upskirt,upskirts,ur,urban,urge,urgent,uri,url,urls,uruguay,urw,us,usa,usage,usb,usc,usd,usda,use,used,useful,user,username,users,uses,usgs,using,usps,usr,usual,usually,ut,utah,utc,utilities,utility,utilization,utilize,utils,uv,uw,uzbekistan,v,va,vacancies,vacation,vacations,vaccine,vacuum,vagina,val,valentine,valid,validation,validity,valium,valley,valuable,valuation,value,valued,values,valve,valves,vampire,van,vancouver,vanilla,var,variable,variables,variance,variation,variations,varied,varies,varieties,variety,various,vary,varying,vast,vat,vatican,vault,vb,vbulletin,vc,vcr,ve,vector,vegas,vegetable,vegetables,vegetarian,vegetation,vehicle,vehicles,velocity,velvet,vendor,vendors,venezuela,venice,venture,ventures,venue,venues,ver,verbal,verde,verification,verified,verify,verizon,vermont,vernon,verse,version,versions,versus,vertex,vertical,very,verzeichnis,vessel,vessels,veteran,veterans,veterinary,vg,vhs,vi,via,viagra,vibrator,vibrators,vic,vice,victim,victims,victor,victoria,victorian,victory,vid,video,videos,vids,vienna,vietnam,vietnamese,view,viewed,viewer,viewers,viewing,viewpicture,views,vii,viii,viking,villa,village,villages,villas,vincent,vintage,vinyl,violation,violations,violence,violent,violin,vip,viral,virgin,virginia,virtual,virtually,virtue,virus,viruses,visa,visibility,visible,vision,visit,visited,visiting,visitor,visitors,visits,vista,visual,vital,vitamin,vitamins,vocabulary,vocal,vocals,vocational,voice,voices,void,voip,vol,volkswagen,volleyball,volt,voltage,volume,volumes,voluntary,volunteer,volunteers,volvo,von,vote,voted,voters,votes,voting,voyeur,voyeurweb,voyuer,vp,vpn,vs,vsnet,vt,vulnerability,vulnerable,w,wa,wage,wages,wagner,wagon,wait,waiting,waiver,wake,wal,wales,walk,walked,walker,walking,walks,wall,wallace,wallet,wallpaper,wallpapers,walls,walnut,walt,walter,wan,wang,wanna,want,wanted,wanting,wants,war,warcraft,ward,ware,warehouse,warm,warming,warned,warner,warning,warnings,warrant,warranties,warranty,warren,warrior,warriors,wars,was,wash,washer,washing,washington,waste,watch,watched,watches,watching,water,waterproof,waters,watershed,watson,watt,watts,wav,wave,waves,wax,way,wayne,ways,wb,wc,we,weak,wealth,weapon,weapons,wear,wearing,weather,web,webcam,webcams,webcast,weblog,weblogs,webmaster,webmasters,webpage,webshots,website,websites,webster,wed,wedding,weddings,wednesday,weed,week,weekend,weekends,weekly,weeks,weight,weighted,weights,weird,welcome,welding,welfare,well,wellington,wellness,wells,welsh,wendy,went,were,wesley,west,western,westminster,wet,whale,what,whatever,whats,wheat,wheel,wheels,when,whenever,where,whereas,wherever,whether,which,while,whilst,white,who,whole,wholesale,whom,whore,whose,why,wi,wichita,wicked,wide,widely,wider,widescreen,widespread,width,wife,wifi,wiki,wikipedia,wild,wilderness,wildlife,wiley,will,william,williams,willing,willow,wilson,win,wind,window,windows,winds,windsor,wine,wines,wing,wings,winner,winners,winning,wins,winston,winter,wire,wired,wireless,wires,wiring,wisconsin,wisdom,wise,wish,wishes,wishing,wishlist,wit,witch,with,withdrawal,within,without,witness,witnesses,wives,wizard,wm,wma,wn,wolf,woman,women,womens,won,wonder,wonderful,wondering,wood,wooden,woods,wool,worcester,word,wordpress,words,work,worked,worker,workers,workflow,workforce,working,workout,workplace,works,workshop,workshops,workstation,world,worldcat,worlds,worldsex,worldwide,worm,worn,worried,worry,worse,worship,worst,worth,worthy,would,wound,wow,wp,wr,wrap,wrapped,wrapping,wrestling,wright,wrist,write,writer,writers,writes,writing,writings,written,wrong,wrote,ws,wt,wto,wu,wv,ww,www,wx,wy,wyoming,x,xanax,xbox,xerox,xhtml,xi,xl,xml,xnxx,xp,xx,xxx,y,ya,yacht,yahoo,yale,yamaha,yang,yard,yards,yarn,ye,yea,yeah,year,yearly,years,yeast,yellow,yemen,yen,yes,yesterday,yet,yield,yields,yn,yo,yoga,york,yorkshire,you,young,younger,your,yours,yourself,youth,yr,yrs,yu,yugoslavia,yukon,z,za,zambia,zdnet,zealand,zen,zero,zimbabwe,zinc,zip,zoloft,zone,zones,zoning,zoo,zoom,".toLowerCase();
            String dictionary2 = ""+getStringChangeMerchantCategory5.toLowerCase();

            String[] splitMerchantName2 = where_at.split("\\W");

            for (String wordInMerchantName : splitMerchantName2){

                if (wordInMerchantName.length()>2) {
                    if (dictionary2.contains(","+wordInMerchantName.toLowerCase()+",")) {
                        merchantCategory = stringChangeMerchantCategory[12];
                        break;
                    }
                }
            }

        }


        //merchantCategory = merchantCategory.replaceFirst("---","");


        return merchantCategory;
    }

    public String merchantCategoryFromDictionaryForBrands(String where_at, String[] stringChangeMerchantCategory, FrameworkWords frameworkWords){


        String merchantCategory = "";


        /*Matcher mattttt = Pattern.compile("(?i)(IMPS|NEFT|upi|RTGS|txn|NetBanking|xxxxx|\\d{5})").matcher(where_at);
        if (!mattttt.find()) {
            Log.d("AAAVVVV", "4 --- " + where_at);
        }*/
        //StringBuilder dictionary = new StringBuilder("aaa,aaron,ab,abandoned,abc,aberdeen,abilities,ability,able,aboriginal,abortion,about,above,abraham,abroad,,abs,absence,absent,absolute,absolutely,absorption,abstract,abstracts,abu,abuse,ac,academic,academics,academy,acc,accent,accept,acceptable,acceptance,accepted,accepting,accepts,access,accessed,accessibility,accessible,accessing,accessories,accessory,accident,accidents,accommodate,accommodation,accommodations,accompanied,accompanying,accomplish,accomplished,accordance,according,accordingly,account,accountability,accounting,accounts,accreditation,accredited,accuracy,accurate,accurately,accused,acdbentity,ace,acer,achieve,achieved,achievement,achievements,achieving,acid,acids,acknowledge,acknowledged,acm,acne,acoustic,acquire,acquired,acquisition,acquisitions,acre,acres,acrobat,across,acrylic,act,acting,action,actions,activated,activation,active,actively,activists,activities,activity,actor,actors,actress,acts,actual,actually,acute,ad,ada,adam,adams,adaptation,adapted,adapter,adapters,adaptive,adaptor,add,added,addiction,adding,addition,additional,additionally,additions,address,addressed,addresses,addressing,adds,adelaide,adequate,adidas,adipex,adjacent,adjust,adjustable,adjusted,adjustment,adjustments,admin,administered,administration,administrative,administrator,administrators,admission,admissions,admit,admitted,adobe,adolescent,adopt,adopted,adoption,adrian,ads,adsl,adult,adults,advance,advanced,advancement,advances,advantage,advantages,adventure,adventures,adverse,advert,advertise,advertisement,advertisements,advertiser,advertisers,advertising,advice,advise,advised,advisor,advisors,advisory,advocacy,advocate,adware,ae,aerial,aerospace,af,affair,affairs,affect,affected,affecting,affects,affiliate,affiliated,affiliates,affiliation,afford,affordable,afghanistan,afraid,africa,african,after,afternoon,afterwards,ag,again,against,age,aged,agencies,agency,agenda,agent,agents,ages,aggregate,aggressive,aging,ago,agree,agreed,agreement,agreements,agrees,agricultural,agriculture,ah,ahead,ai,aid,aids,aim,aimed,aims,air,aircraft,airfare,airline,airlines,airplane,airport,airports,aj,ak,aka,al,ala,alabama,alan,alarm,alaska,albania,albany,albert,alberta,album,albums,albuquerque,alcohol,alert,alerts,alex,alexander,alexandria,alfred,algebra,algeria,algorithm,algorithms,ali,alias,alice,alien,align,alignment,alike,alive,all,allah,allan,alleged,allen,allergy,alliance,allied,allocated,allocation,allow,allowance,allowed,allowing,allows,alloy,almost,alone,along,alot,alpha,alphabetical,alpine,already,also,alt,alter,altered,alternate,alternative,alternatively,alternatives,although,alto,aluminium,aluminum,alumni,always,am,amanda,amateur,amazing,amazon,ambassador,amber,ambien,ambient,amd,amend,amended,amendment,amendments,amenities,america,american,americans,americas,amino,among,amongst,amount,amounts,amp,ampland,amplifier,amsterdam,amy,an,ana,anaheim,anal,analog,analyses,analysis,analyst,analysts,analytical,analyze,analyzed,anatomy,anchor,ancient,and,andale,anderson,andorra,andrea,andreas,andrew,andrews,andy,angel,angela,angeles,angels,anger,angle,angola,angry,animal,animals,animated,animation,anime,ann,anna,anne,annex,annie,anniversary,annotated,annotation,announce,announced,announcement,announcements,announces,annoying,annual,annually,anonymous,another,answer,answered,answering,answers,ant,antarctica,antenna,anthony,anthropology,anti,antibodies,antibody,anticipated,antigua,antique,antiques,antivirus,antonio,anxiety,any,anybody,anymore,anyone,anything,anytime,anyway,anywhere,aol,ap,apache,apart,apartment,apartments,api,apnic,apollo,app,apparatus,apparel,apparent,apparently,appeal,appeals,appear,appearance,appeared,appearing,appears,appendix,apple,appliance,appliances,applicable,applicant,applicants,application,applications,applied,applies,apply,applying,appointed,appointment,appointments,appraisal,appreciate,appreciated,appreciation,approach,approaches,appropriate,appropriations,approval,approve,approved,approx,approximate,approximately,apps,apr,april,apt,aqua,aquarium,aquatic,ar,arab,arabia,arabic,arbitrary,arbitration,arbor,arc,arcade,arch,architect,architects,architectural,architecture,archive,archived,archives,arctic,are,area,areas,arena,arg,argentina,argue,argued,argument,arguments,arise,arising,arizona,arkansas,arlington,arm,armed,armenia,armor,arms,armstrong,army,arnold,around,arrange,arranged,arrangement,arrangements,array,arrest,arrested,arrival,arrivals,arrive,arrived,arrives,arrow,art,arthritis,arthur,article,articles,artificial,artist,artistic,artists,arts,artwork,aruba,as,asbestos,ascii,ash,ashley,asia,asian,aside,asin,ask,asked,asking,asks,asn,asp,aspect,aspects,ass,assault,assembled,assembly,assess,assessed,assessing,assessment,assessments,asset,assets,assign,assigned,assignment,assignments,assist,assistance,assistant,assisted,assists,associate,associated,associates,association,associations,assume,assumed,assumes,assuming,assumption,assumptions,assurance,assure,assured,asthma,astrology,astronomy,asus,asylum,at,ata,ate,athens,athletes,athletic,athletics,ati,atlanta,atlantic,atlas,atm,atmosphere,atmospheric,atom,atomic,attach,attached,attachment,attachments,attack,attacked,attacks,attempt,attempted,attempting,attempts,attend,attendance,attended,attending,attention,attitude,attitudes,attorney,attorneys,attract,attraction,attractions,attractive,attribute,attributes,au,auburn,auckland,auction,auctions,aud,audi,audience,audio,audit,auditor,aug,august,aurora,aus,austin,australia,australian,austria,authentic,authentication,author,authorities,authority,authorization,authorized,authors,auto,automated,automatic,automatically,automation,automobile,automobiles,automotive,autos,autumn,av,availability,available,avatar,ave,avenue,average,avg,avi,aviation,avoid,avoiding,avon,aw,award,awarded,awards,aware,awareness,away,awesome,awful,axis,aye,az,azerbaijan,b,ba,babe,babes,babies,baby,bachelor,back,backed,background,backgrounds,backing,backup,bacon,bacteria,bacterial,bad,badge,badly,bag,baghdad,bags,bahamas,bahrain,bailey,baker,baking,balance,balanced,bald,bali,ball,ballet,balloon,ballot,balls,baltimore,ban,banana,band,bands,bandwidth,bang,bangbus,bangkok,bangladesh,bank,banking,bankruptcy,banks,banned,banner,banners,baptist,bar,barbados,barbara,barbie,barcelona,bare,barely,bargain,bargains,barn,barnes,barrel,barrier,barriers,barry,bars,base,baseball,based,baseline,basement,basename,bases,basic,basically,basics,basin,basis,basket,basketball,baskets,bass,bat,batch,bath,bathroom,bathrooms,baths,batman,batteries,battery,battle,battlefield,bay,bb,bbc,bbs,bbw,bc,bd,bdsm,be,beach,beaches,beads,beam,bean,beans,bear,bearing,bears,beast,beastality,beastiality,beat,beatles,beats,beautiful,beautifully,beauty,beaver,became,because,become,becomes,becoming,bed,bedding,bedford,bedroom,bedrooms,beds,bee,beef,been,beer,before,began,begin,beginner,beginners,beginning,begins,begun,behalf,behavior,behavioral,behaviour,behind,beijing,being,beings,belarus,belfast,belgium,belief,beliefs,believe,believed,believes,belize,belkin,bell,belle,belly,belong,belongs,below,belt,belts,ben,bench,benchmark,bend,beneath,beneficial,benefit,benefits,benjamin,bennett,bent,benz,berkeley,berlin,bermuda,bernard,berry,beside,besides,best,bestiality,bestsellers,bet,beta,beth,better,betting,betty,between,beverage,beverages,beverly,beyond,bg,bhutan,bi,bias,bible,biblical,bibliographic,bibliography,bicycle,bid,bidder,bidding,bids,big,bigger,biggest,bike,bikes,bikini,bill,billing,billion,bills,billy,bin,binary,bind,binding,bingo,bio,biodiversity,biographies,biography,biol,biological,biology,bios,biotechnology,bird,birds,birmingham,birth,birthday,bishop,bit,bitch,bite,bits,biz,bizarre,bizrate,bk,bl,black,blackberry,blackjack,blacks,blade,blades,blah,blair,blake,blame,blank,blanket,blast,bleeding,blend,bless,blessed,blind,blink,block,blocked,blocking,blocks,blog,blogger,bloggers,blogging,blogs,blond,blonde,blood,bloody,bloom,bloomberg,blow,blowing,blowjob,blowjobs,blue,blues,bluetooth,blvd,bm,bmw,bo,board,boards,boat,boating,boats,bob,bobby,boc,bodies,body,bold,bolivia,bolt,bomb,bon,bond,bondage,bonds,bone,bones,bonus,boob,boobs,book,booking,bookings,bookmark,bookmarks,books,bookstore,bool,boolean,boom,boost,boot,booth,boots,booty,border,borders,bored,boring,born,borough,bosnia,boss,boston,both,bother,botswana,bottle,bottles,bottom,bought,boulder,boulevard,bound,boundaries,boundary,bouquet,boutique,bow,bowl,bowling,box,boxed,boxes,boxing,boy,boys,bp,br,bra,bracelet,bracelets,bracket,brad,bradford,bradley,brain,brake,brakes,branch,branches,brand,brandon,brands,bras,brass,brave,brazil,brazilian,breach,bread,break,breakdown,breakfast,breaking,breaks,breast,breasts,breath,breathing,breed,breeding,breeds,brian,brick,bridal,bride,bridge,bridges,brief,briefing,briefly,briefs,bright,brighton,brilliant,bring,bringing,brings,brisbane,bristol,britain,britannica,british,britney,broad,broadband,broadcast,broadcasting,broader,broadway,brochure,brochures,broke,broken,broker,brokers,bronze,brook,brooklyn,brooks,brother,brothers,brought,brown,browse,browser,browsers,browsing,bruce,brunei,brunette,brunswick,brush,brussels,brutal,bryan,bryant,bs,bt,bubble,buck,bucks,budapest,buddy,budget,budgets,buf,buffalo,buffer,bufing,bug,bugs,build,builder,builders,building,buildings,builds,built,bukkake,bulgaria,bulgarian,bulk,bull,bullet,bulletin,bumper,bunch,bundle,bunny,burden,bureau,buried,burke,burlington,burn,burner,burning,burns,burst,burton,bus,buses,bush,business,businesses,busty,busy,but,butler,butt,butter,butterfly,button,buttons,butts,buy,buyer,buyers,buying,buys,buzz,bw,by,bye,byte,bytes,c,ca,cab,cabin,cabinet,cabinets,cable,cables,cache,cached,cad,cadillac,cafe,cage,cake,cakes,cal,calcium,calculate,calculated,calculation,calculations,calculator,calculators,calendar,calendars,calgary,calibration,california,call,called,calling,calls,calm,calvin,cam,cambodia,cambridge,camcorder,camcorders,came,camel,camera,cameras,cameron,cameroon,camp,campaign,campaigns,campbell,camping,camps,campus,cams,can,canada,canadian,canal,canberra,cancel,cancellation,cancelled,cancer,candidate,candidates,candle,candles,candy,cannon,canon,cant,canvas,canyon,cap,capabilities,capability,capable,capacity,cape,capital,capitol,caps,captain,capture,captured,car,carb,carbon,card,cardiac,cardiff,cardiovascular,cards,care,career,careers,careful,carefully,carey,cargo,caribbean,caring,carl,carlo,carlos,carmen,carnival,carol,carolina,caroline,carpet,carried,carrier,carriers,carries,carroll,carry,carrying,cars,cart,carter,cartoon,cartoons,cartridge,cartridges,cas,casa,case,cases,casey,cash,cashiers,casino,casinos,casio,cassette,cast,casting,castle,casual,cat,catalog,catalogs,catalogue,catalyst,catch,categories,category,catering,cathedral,catherine,catholic,cats,cattle,caught,cause,caused,causes,causing,caution,cave,cayman,cb,cbs,cc,ccd,cd,cdna,cds,cdt,ce,cedar,ceiling,celebrate,celebration,celebrities,celebrity,celebs,cell,cells,cellular,celtic,cement,cemetery,census,cent,center,centered,centers,central,centre,centres,cents,centuries,century,ceo,ceramic,ceremony,certain,certainly,certificate,certificates,certification,certified,cet,cf,cfr,cg,cgi,ch,chad,chain,chains,chair,chairman,chairs,challenge,challenged,challenges,challenging,chamber,chambers,champagne,champion,champions,championship,championships,chan,chance,chancellor,chances,change,changed,changelog,changes,changing,channel,channels,chaos,chapel,chapter,chapters,char,character,characteristic,characteristics,characterization,characterized,characters,charge,charged,charger,chargers,charges,charging,charitable,charity,charles,charleston,charlie,charlotte,charm,charming,charms,chart,charter,charts,chase,chassis,chat,cheap,cheaper,cheapest,cheat,cheats,check,checked,checking,checklist,checkout,checks,cheers,cheese,chef,chelsea,chem,chemical,chemicals,chemistry,chen,cheque,cherry,chess,chest,chester,chevrolet,chevy,chi,chicago,chick,chicken,chicks,chief,child,childhood,children,childrens,chile,china,chinese,chip,chips,cho,chocolate,choice,choices,choir,cholesterol,choose,choosing,chorus,chose,chosen,chris,christ,christian,christianity,christians,christina,christine,christmas,christopher,chrome,chronic,chronicle,chronicles,chrysler,chubby,chuck,church,churches,ci,cia,cialis,ciao,cigarette,cigarettes,cincinnati,cindy,cinema,cingular,cio,cir,circle,circles,circuit,circuits,circular,circulation,circumstances,circus,cisco,citation,citations,cite,cited,cities,citizen,citizens,citizenship,city,citysearch,civic,civil,civilian,civilization,cj,cl,claim,claimed,claims,claire,clan,clara,clarity,clark,clarke,class,classes,classic,classical,classics,classification,classified,classifieds,classroom,clause,clay,clean,cleaner,cleaners,cleaning,cleanup,clear,clearance,cleared,clearing,clearly,clerk,cleveland,click,clicking,clicks,client,clients,cliff,climate,climb,climbing,clinic,clinical,clinics,clinton,clip,clips,clock,clocks,clone,close,closed,closely,closer,closes,closest,closing,closure,cloth,clothes,clothing,cloud,clouds,cloudy,club,clubs,cluster,clusters,cm,cms,cn,cnet,cnn,co,coach,coaches,coaching,coal,coalition,coast,coastal,coat,coated,coating,cock,cocks,cocktail,cod,code,codes,coding,coffee,cognitive,cohen,coin,coins,col,cold,cole,coleman,colin,collaboration,collaborative,collapse,collar,colleague,colleagues,collect,collectables,collected,collectible,collectibles,collecting,collection,collections,collective,collector,collectors,college,colleges,collins,cologne,colombia,colon,colonial,colony,color,colorado,colored,colors,colour,colours,columbia,columbus,column,columnists,columns,com,combat,combination,combinations,combine,combined,combines,combining,combo,come,comedy,comes,comfort,comfortable,comic,comics,coming,comm,command,commander,commands,comment,commentary,commented,comments,commerce,commercial,commission,commissioner,commissioners,commissions,commit,commitment,commitments,committed,committee,committees,commodities,commodity,common,commonly,commons,commonwealth,communicate,communication,communications,communist,communities,community,comp,compact,companies,companion,company,compaq,comparable,comparative,compare,compared,comparing,comparison,comparisons,compatibility,compatible,compensation,compete,competent,competing,competition,competitions,competitive,competitors,compilation,compile,compiled,compiler,complaint,complaints,complement,complete,completed,completely,completing,completion,complex,complexity,compliance,compliant,complicated,complications,complimentary,comply,component,components,composed,composer,composite,composition,compound,compounds,comprehensive,compressed,compression,compromise,computation,computational,compute,computed,computer,computers,computing,con,concentrate,concentration,concentrations,concept,concepts,conceptual,concern,concerned,concerning,concerns,concert,concerts,conclude,concluded,conclusion,conclusions,concord,concrete,condition,conditional,conditioning,conditions,condo,condos,conduct,conducted,conducting,conf,conference,conferences,conferencing,confidence,confident,confidential,confidentiality,config,configuration,configurations,configure,configured,configuring,confirm,confirmation,confirmed,conflict,conflicts,confused,confusion,congo,congratulations,congress,congressional,conjunction,connect,connected,connecticut,connecting,connection,connections,connectivity,connector,connectors,cons,conscious,consciousness,consecutive,consensus,consent,consequence,consequences,consequently,conservation,conservative,consider,considerable,consideration,considerations,considered,considering,considers,consist,consistency,consistent,consistently,consisting,consists,console,consoles,consolidated,consolidation,consortium,conspiracy,const,constant,constantly,constitute,constitutes,constitution,constitutional,constraint,constraints,construct,constructed,construction,consult,consultancy,consultant,consultants,consultation,consulting,consumer,consumers,consumption,contact,contacted,contacting,contacts,contain,contained,container,containers,containing,contains,contamination,contemporary,content,contents,contest,contests,context,continent,continental,continually,continue,continued,continues,continuing,continuity,continuous,continuously,contract,contracting,contractor,contractors,contracts,contrary,contrast,contribute,contributed,contributing,contribution,contributions,contributor,contributors,control,controlled,controller,controllers,controlling,controls,controversial,controversy,convenience,convenient,convention,conventional,conventions,convergence,conversation,conversations,conversion,convert,converted,converter,convertible,convicted,conviction,convinced,cook,cookbook,cooked,cookie,cookies,cooking,cool,cooler,cooling,cooper,cooperation,cooperative,coordinate,coordinated,coordinates,coordination,coordinator,cop,cope,copied,copies,copper,copy,copying,copyright,copyrighted,copyrights,coral,cord,cordless,core,cork,corn,cornell,corner,corners,cornwall,corp,corporate,corporation,corporations,corps,corpus,correct,corrected,correction,corrections,correctly,correlation,correspondence,corresponding,corruption,cos,cosmetic,cosmetics,cost,costa,costs,costume,costumes,cottage,cottages,cotton,could,council,councils,counsel,counseling,count,counted,counter,counters,counties,counting,countries,country,counts,county,couple,coupled,couples,coupon,coupons,courage,courier,course,courses,court,courtesy,courts,cove,cover,coverage,covered,covering,covers,cow,cowboy,cox,cp,cpu,cr,crack,cradle,craft,crafts,craig,crap,craps,crash,crawford,crazy,cream,create,created,creates,creating,creation,creations,creative,creativity,creator,creature,creatures,credit,credits,creek,crest,crew,cricket,crime,crimes,criminal,crisis,criteria,criterion,critical,criticism,critics,crm,croatia,crop,crops,cross,crossing,crossword,crowd,crown,crucial,crude,cruise,cruises,cruz,cry,crystal,cs,css,cst,ct,ctrl,cu,cuba,cube,cubic,cuisine,cult,cultural,culture,cultures,cum,cumshot,cumshots,cumulative,cunt,cup,cups,cure,curious,currencies,currency,current,currently,curriculum,cursor,curtis,curve,curves,custody,custom,customer,customers,customise,customize,customized,customs,cut,cute,cuts,cutting,cv,cvs,cw,cyber,cycle,cycles,cycling,cylinder,cyprus,cz,czech,d,da,dad,daddy,daily,dairy,daisy,dakota,dale,dallas,dam,damage,damaged,damages,dame,damn,dan,dana,dance,dancing,danger,dangerous,daniel,danish,danny,dans,dare,dark,darkness,darwin,das,dash,dat,data,database,databases,date,dated,dates,dating,daughter,daughters,dave,david,davidson,davis,dawn,day,days,dayton,db,dc,dd,ddr,de,dead,deadline,deadly,deaf,deal,dealer,dealers,dealing,deals,dealt,dealtime,dean,dear,death,deaths,debate,debian,deborah,debt,debug,debut,dec,decade,decades,december,decent,decide,decided,decimal,decision,decisions,deck,declaration,declare,declared,decline,declined,decor,decorating,decorative,decrease,decreased,dedicated,dee,deemed,deep,deeper,deeply,deer,def,default,defeat,defects,defence,defend,defendant,defense,defensive,deferred,deficit,define,defined,defines,defining,definitely,definition,definitions,degree,degrees,del,delaware,delay,delayed,delays,delegation,delete,deleted,delhi,delicious,delight,deliver,delivered,delivering,delivers,delivery,dell,delta,deluxe,dem,demand,demanding,demands,demo,democracy,democrat,democratic,democrats,demographic,demonstrate,demonstrated,demonstrates,demonstration,den,denial,denied,denmark,dennis,dense,density,dental,dentists,denver,deny,department,departmental,departments,departure,depend,dependence,dependent,depending,depends,deployment,deposit,deposits,depot,depression,dept,depth,deputy,der,derby,derek,derived,des,descending,describe,described,describes,describing,description,descriptions,desert,deserve,design,designated,designation,designed,designer,designers,designing,designs,desirable,desire,desired,desk,desktop,desktops,desperate,despite,destination,destinations,destiny,destroy,destroyed,destruction,detail,detailed,details,detect,detected,detection,detective,detector,determination,determine,determined,determines,determining,detroit,deutsch,deutsche,deutschland,dev,devel,develop,developed,developer,developers,developing,development,developmental,developments,develops,deviant,deviation,device,devices,devil,devon,devoted,df,dg,dh,di,diabetes,diagnosis,diagnostic,diagram,dial,dialog,dialogue,diameter,diamond,diamonds,diana,diane,diary,dice,dick,dicke,dicks,dictionaries,dictionary,did,die,died,diego,dies,diesel,diet,dietary,diff,differ,difference,differences,different,differential,differently,difficult,difficulties,difficulty,diffs,dig,digest,digit,digital,dildo,dildos,dim,dimension,dimensional,dimensions,dining,dinner,dip,diploma,dir,direct,directed,direction,directions,directive,directly,director,directories,directors,directory,dirt,dirty,dis,disabilities,disability,disable,disabled,disagree,disappointed,disaster,disc,discharge,disciplinary,discipline,disciplines,disclaimer,disclaimers,disclose,disclosure,disco,discount,discounted,discounts,discover,discovered,discovery,discrete,discretion,discrimination,discs,discuss,discussed,discusses,discussing,discussion,discussions,disease,diseases,dish,dishes,disk,disks,disney,disorder,disorders,dispatch,dispatched,display,displayed,displaying,displays,disposal,disposition,dispute,disputes,dist,distance,distances,distant,distinct,distinction,distinguished,distribute,distributed,distribution,distributions,distributor,distributors,district,districts,disturbed,div,dive,diverse,diversity,divide,divided,dividend,divine,diving,division,divisions,divorce,divx,diy,dj,dk,dl,dm,dna,dns,do,doc,dock,docs,doctor,doctors,doctrine,document,documentary,documentation,documented,documents,dod,dodge,doe,does,dog,dogs,doing,doll,dollar,dollars,dolls,dom,domain,domains,dome,domestic,dominant,dominican,don,donald,donate,donated,donation,donations,done,donna,donor,donors,dont,doom,door,doors,dos,dosage,dose,dot,double,doubt,doug,douglas,dover,dow,down,download,downloadable,downloaded,downloading,downloads,downtown,dozen,dozens,dp,dpi,dr,draft,drag,dragon,drain,drainage,drama,dramatic,dramatically,draw,drawing,drawings,drawn,draws,dream,dreams,dress,dressed,dresses,dressing,drew,dried,drill,drilling,drink,drinking,drinks,drive,driven,driver,drivers,drives,driving,drop,dropped,drops,drove,drug,drugs,drum,drums,drunk,dry,dryer,ds,dsc,dsl,dt,dts,du,dual,dubai,dublin,duck,dude,due,dui,duke,dumb,dump,duncan,duo,duplicate,durable,duration,durham,during,dust,dutch,duties,duty,dv,dvd,dvds,dx,dying,dylan,dynamic,dynamics,e,ea,each,eagle,eagles,ear,earl,earlier,earliest,early,earn,earned,earning,earnings,earrings,ears,earth,earthquake,ease,easier,easily,east,easter,eastern,easy,eat,eating,eau,ebay,ebony,ebook,ebooks,ec,echo,eclipse,eco,ecological,ecology,ecommerce,economic,economics,economies,economy,ecuador,ed,eddie,eden,edgar,edge,edges,edinburgh,edit,edited,editing,edition,editions,editor,editorial,editorials,editors,edmonton,eds,edt,educated,education,educational,educators,edward,edwards,ee,ef,effect,effective,effectively,effectiveness,effects,efficiency,efficient,efficiently,effort,efforts,eg,egg,eggs,egypt,egyptian,eh,eight,either,ejaculation,el,elder,elderly,elect,elected,election,elections,electoral,electric,electrical,electricity,electro,electron,electronic,electronics,elegant,element,elementary,elements,elephant,elevation,eleven,eligibility,eligible,eliminate,elimination,elite,elizabeth,ellen,elliott,ellis,else,elsewhere,elvis,em,emacs,email,emails,embassy,embedded,emerald,emergency,emerging,emily,eminem,emirates,emission,emissions,emma,emotional,emotions,emperor,emphasis,empire,empirical,employ,employed,employee,employees,employer,employers,employment,empty,en,enable,enabled,enables,enabling,enb,enclosed,enclosure,encoding,encounter,encountered,encourage,encouraged,encourages,encouraging,encryption,encyclopedia,end,endangered,ended,endif,ending,endless,endorsed,endorsement,ends,enemies,enemy,energy,enforcement,eng,engage,engaged,engagement,engaging,engine,engineer,engineering,engineers,engines,england,english,enhance,enhanced,enhancement,enhancements,enhancing,enjoy,enjoyed,enjoying,enlarge,enlargement,enormous,enough,enquiries,enquiry,enrolled,enrollment,ensemble,ensure,ensures,ensuring,ent,enter,entered,entering,enterprise,enterprises,enters,entertaining,entertainment,entire,entirely,entities,entitled,entity,entrance,entrepreneur,entrepreneurs,entries,entry,envelope,environment,environmental,environments,enzyme,eos,ep,epa,epic,epinions,episode,episodes,epson,eq,equal,equality,equally,equation,equations,equilibrium,equipment,equipped,equity,equivalent,er,era,eric,ericsson,erik,erotic,erotica,erp,error,errors,es,escape,escort,escorts,especially,espn,essay,essays,essence,essential,essentially,essentials,essex,est,establish,established,establishing,establishment,estate,estates,estimate,estimated,estimates,estimation,estonia,et,etc,eternal,ethernet,ethical,ethics,ethiopia,ethnic,eu,eugene,eur,euro,europe,european,euros,ev,eva,eval,evaluate,evaluated,evaluating,evaluation,evaluations,evanescence,evans,eve,even,evening,event,events,eventually,ever,every,everybody,everyday,everyone,everything,everywhere,evidence,evident,evil,evolution,ex,exact,exactly,exam,examination,examinations,examine,examined,examines,examining,example,examples,exams,exceed,excel,excellence,excellent,except,exception,exceptional,exceptions,excerpt,excess,excessive,exchange,exchanges,excited,excitement,exciting,exclude,excluded,excluding,exclusion,exclusive,exclusively,excuse,exec,execute,executed,execution,executive,executives,exempt,exemption,exercise,exercises,exhaust,exhibit,exhibition,exhibitions,exhibits,exist,existed,existence,existing,exists,exit,exotic,exp,expand,expanded,expanding,expansion,expansys,expect,expectations,expected,expects,expedia,expenditure,expenditures,expense,expenses,expensive,experience,experienced,experiences,experiencing,experiment,experimental,experiments,expert,expertise,experts,expiration,expired,expires,explain,explained,explaining,explains,explanation,explicit,explicitly,exploration,explore,explorer,exploring,explosion,expo,export,exports,exposed,exposure,express,expressed,expression,expressions,ext,extend,extended,extending,extends,extension,extensions,extensive,extent,exterior,external,extra,extract,extraction,extraordinary,extras,extreme,extremely,eye,eyed,eyes,ez,f,fa,fabric,fabrics,fabulous,face,faced,faces,facial,facilitate,facilities,facility,facing,fact,factor,factors,factory,facts,faculty,fail,failed,failing,fails,failure,failures,fair,fairfield,fairly,fairy,faith,fake,fall,fallen,falling,falls,FALSE,fame,familiar,families,family,famous,fan,fancy,fans,fantastic,fantasy,faq,faqs,far,fare,fares,farm,farmer,farmers,farming,farms,fascinating,fashion,fast,faster,fastest,fat,fatal,fate,father,fathers,fatty,fault,favor,favorite,favorites,favors,favour,favourite,favourites,fax,fbi,fc,fcc,fd,fda,fe,fear,fears,feat,feature,featured,features,featuring,feb,february,fed,federal,federation,fee,feed,feedback,feeding,feeds,feel,feeling,feelings,feels,fees,feet,fell,fellow,fellowship,felt,female,females,fence,feof,ferrari,ferry,festival,festivals,fetish,fever,few,fewer,ff,fg,fi,fiber,fibre,fiction,field,fields,fifteen,fifth,fifty,fig,fight,fighter,fighters,fighting,figure,figured,figures,fiji,file,filed,filename,files,filing,fill,filled,filling,film,filme,films,filter,filtering,filters,fin,final,finally,finals,finance,finances,financial,financing,find,findarticles,finder,finding,findings,findlaw,finds,fine,finest,finger,fingering,fingers,finish,finished,finishing,finite,finland,finnish,fioricet,fire,fired,firefox,fireplace,fires,firewall,firewire,firm,firms,firmware,first,fiscal,fish,fisher,fisheries,fishing,fist,fisting,fit,fitness,fits,fitted,fitting,five,fix,fixed,fixes,fixtures,fl,flag,flags,flame,flash,flashers,flashing,flat,flavor,fleece,fleet,flesh,flex,flexibility,flexible,flickr,flight,flights,flip,float,floating,flood,floor,flooring,floors,floppy,floral,florence,florida,florist,florists,flour,flow,flower,flowers,flows,floyd,flu,fluid,flush,flux,fly,flyer,flying,fm,fo,foam,focal,focus,focused,focuses,focusing,fog,fold,folder,folders,folding,folk,folks,follow,followed,following,follows,font,fonts,foo,food,foods,fool,foot,footage,football,footwear,for,forbes,forbidden,force,forced,forces,ford,forecast,forecasts,foreign,forest,forestry,forests,forever,forge,forget,forgot,forgotten,fork,form,formal,format,formation,formats,formatting,formed,former,formerly,forming,forms,formula,fort,forth,fortune,forty,forum,forums,forward,forwarding,fossil,foster,foto,fotos,fought,foul,found,foundation,foundations,founded,founder,fountain,four,fourth,fox,fp,fr,fraction,fragrance,fragrances,frame,framed,frames,framework,framing,france,franchise,francis,francisco,frank,frankfurt,franklin,fraser,fraud,fred,frederick,free,freebsd,freedom,freelance,freely,freeware,freeze,freight,french,frequencies,frequency,frequent,frequently,fresh,fri,friday,fridge,friend,friendly,friends,friendship,frog,from,front,frontier,frontpage,frost,frozen,fruit,fruits,fs,ft,ftp,fu,fuck,fucked,fucking,fuel,fuji,fujitsu,full,fully,fun,function,functional,functionality,functioning,functions,fund,fundamental,fundamentals,funded,funding,fundraising,funds,funeral,funk,funky,funny,fur,furnished,furnishings,furniture,further,furthermore,fusion,future,futures,fuzzy,fw,fwd,fx,fy,g,ga,gabriel,gadgets,gage,gain,gained,gains,galaxy,gale,galleries,gallery,gambling,game,gamecube,games,gamespot,gaming,gamma,gang,gangbang,gap,gaps,garage,garbage,garcia,garden,gardening,gardens,garlic,garmin,gary,gas,gasoline,gate,gates,gateway,gather,gathered,gathering,gauge,gave,gay,gays,gazette,gb,gba,gbp,gc,gcc,gd,gdp,ge,gear,geek,gel,gem,gen,gender,gene,genealogy,general,generally,generate,generated,generates,generating,generation,generations,generator,generators,generic,generous,genes,genesis,genetic,genetics,geneva,genius,genome,genre,genres,gentle,gentleman,gently,genuine,geo,geographic,geographical,geography,geological,geology,geometry,george,georgia,gerald,german,germany,get,gets,getting,gg,ghana,ghost,ghz,gi,giant,giants,gibraltar,gibson,gif,gift,gifts,gig,gilbert,girl,girlfriend,girls,gis,give,given,gives,giving,gl,glad,glance,glasgow,glass,glasses,glen,glenn,global,globe,glory,glossary,gloves,glow,glucose,gm,gmbh,gmc,gmt,gnome,gnu,go,goal,goals,goat,god,gods,goes,going,gold,golden,golf,gone,gonna,good,goods,google,gordon,gore,gorgeous,gospel,gossip,got,gothic,goto,gotta,gotten,gourmet,governance,governing,government,governmental,governments,governor,gp,gpl,gps,gr,grab,grace,grad,grade,grades,gradually,graduate,graduated,graduates,graduation,graham,grain,grammar,grams,grand,grande,granny,grant,granted,grants,graph,graphic,graphical,graphics,graphs,gras,grass,grateful,gratis,gratuit,grave,gravity,gray,great,greater,greatest,greatly,greece,greek,green,greene,greenhouse,greensboro,greeting,greetings,greg,gregory,grenada,grew,grey,grid,griffin,grill,grip,grocery,groove,gross,ground,grounds,groundwater,group,groups,grove,grow,growing,grown,grows,growth,gs,gsm,gst,gt,gtk,guam,guarantee,guaranteed,guarantees,guard,guardian,guards,guatemala,guess,guest,guestbook,guests,gui,guidance,guide,guided,guidelines,guides,guild,guilty,guinea,guitar,guitars,gulf,gun,guns,guru,guy,guyana,guys,gym,gzip,h,ha,habitat,habits,hack,hacker,had,hair,hairy,haiti,half,halifax,hall,halloween,halo,ham,hamburg,hamilton,hammer,hampshire,hampton,hand,handbags,handbook,handed,handheld,handhelds,handjob,handjobs,handle,handled,handles,handling,handmade,hands,handy,hang,hanging,hans,hansen,happen,happened,happening,happens,happiness,happy,harassment,harbor,harbour,hard,hardcore,hardcover,harder,hardly,hardware,hardwood,harley,harm,harmful,harmony,harold,harper,harris,harrison,harry,hart,hartford,harvard,harvest,harvey,has,hash,hat,hate,hats,have,haven,having,hawaii,hawaiian,hawk,hay,hayes,hazard,hazardous,hazards,hb,hc,hd,hdtv,he,head,headed,header,headers,heading,headline,headlines,headphones,headquarters,heads,headset,healing,health,healthcare,healthy,hear,heard,hearing,hearings,heart,hearts,heat,heated,heater,heath,heather,heating,heaven,heavily,heavy,hebrew,heel,height,heights,held,helen,helena,helicopter,hell,hello,helmet,help,helped,helpful,helping,helps,hence,henderson,henry,hentai,hepatitis,her,herald,herb,herbal,herbs,here,hereby,herein,heritage,hero,heroes,herself,hewlett,hey,hh,hi,hidden,hide,hierarchy,high,higher,highest,highland,highlight,highlighted,highlights,highly,highs,highway,highways,hiking,hill,hills,hilton,him,himself,hindu,hint,hints,hip,hire,hired,hiring,his,hispanic,hist,historic,historical,history,hit,hitachi,hits,hitting,hiv,hk,hl,ho,hobbies,hobby,hockey,hold,holdem,holder,holders,holding,holdings,holds,hole,holes,holiday,holidays,holland,hollow,holly,hollywood,holmes,holocaust,holy,home,homeland,homeless,homepage,homes,hometown,homework,hon,honda,honduras,honest,honey,hong,honolulu,honor,honors,hood,hook,hop,hope,hoped,hopefully,hopes,hoping,hopkins,horizon,horizontal,hormone,horn,horny,horrible,horror,horse,horses,hose,hospital,hospitality,hospitals,host,hosted,hostel,hostels,hosting,hosts,hot,hotel,hotels,hotmail,hottest,hour,hourly,hours,house,household,households,houses,housewares,housewives,housing,houston,how,howard,however,howto,hp,hq,hr,href,hrs,hs,ht,html,http,hu,hub,hudson,huge,hugh,hughes,hugo,hull,human,humanitarian,humanities,humanity,humans,humidity,humor,hundred,hundreds,hung,hungarian,hungary,hunger,hungry,hunt,hunter,hunting,huntington,hurricane,hurt,husband,hwy,hybrid,hydraulic,hydrocodone,hydrogen,hygiene,hypothesis,hypothetical,hyundai,ia,ian,ibm,ic,ice,iceland,icon,icons,icq,ict,id,idaho,ide,idea,ideal,ideas,identical,identification,identified,identifier,identifies,identify,identifying,identity,idle,idol,ids,ie,ieee,if,ignore,ignored,ii,iii,il,ill,illegal,illinois,illness,illustrated,illustration,illustrations,im,image,images,imagination,imagine,imaging,img,immediate,immediately,immigrants,immigration,immune,immunology,impact,impacts,impaired,imperial,implement,implementation,implemented,implementing,implications,implied,implies,import,importance,important,importantly,imported,imports,impose,imposed,impossible,impressed,impression,impressive,improve,improved,improvement,improvements,improving,in,inappropriate,inbox,inc,incentive,incentives,incest,inch,inches,incidence,incident,incidents,incl,include,included,includes,including,inclusion,inclusive,income,incoming,incomplete,incorporate,incorporated,incorrect,increase,increased,increases,increasing,increasingly,incredible,incurred,ind,indeed,independence,independent,independently,index,indexed,indexes,india,indian,indiana,indianapolis,indians,indicate,indicated,indicates,indicating,indication,indicator,indicators,indices,indie,indigenous,indirect,individual,individually,individuals,indonesia,indonesian,indoor,induced,induction,industrial,industries,industry,inexpensive,inf,infant,infants,infected,infection,infections,infectious,infinite,inflation,influence,influenced,influences,info,inform,informal,information,informational,informative,informed,infrared,infrastructure,infringement,ing,ingredients,inherited,initial,initially,initiated,initiative,initiatives,injection,injured,injuries,injury,ink,inkjet,inline,inn,inner,innocent,innovation,innovations,innovative,inns,input,inputs,inquire,inquiries,inquiry,ins,insects,insert,inserted,insertion,inside,insider,insight,insights,inspection,inspections,inspector,inspiration,inspired,install,installation,installations,installed,installing,instance,instances,instant,instantly,instead,institute,institutes,institution,institutional,institutions,instruction,instructional,instructions,instructor,instructors,instrument,instrumental,instrumentation,instruments,insulation,insulin,insurance,insured,int,intake,integer,integral,integrate,integrated,integrating,integration,integrity,intel,intellectual,intelligence,intelligent,intend,intended,intense,intensity,intensive,intent,intention,inter,interact,interaction,interactions,interactive,interest,interested,interesting,interests,interface,interfaces,interference,interim,interior,intermediate,internal,international,internationally,internet,internship,interpretation,interpreted,interracial,intersection,interstate,interval,intervals,intervention,interventions,interview,interviews,intimate,intl,into,intranet,intro,introduce,introduced,introduces,introducing,introduction,introductory,invalid,invasion,invention,inventory,invest,investigate,investigated,investigation,investigations,investigator,investigators,investing,investment,investments,investor,investors,invisible,invision,invitation,invitations,invite,invited,invoice,involve,involved,involvement,involves,involving,io,ion,iowa,ip,ipaq,ipod,ips,ir,ira,iran,iraq,iraqi,irc,ireland,irish,iron,irrigation,irs,is,isa,isaac,isbn,islam,islamic,island,islands,isle,iso,isolated,isolation,isp,israel,israeli,issn,issue,issued,issues,ist,istanbul,it,italia,italian,italiano,italic,italy,item,items,its,itself,itunes,iv,ivory,ix,j,ja,jack,jacket,jackets,jackie,jackson,jacksonville,jacob,jade,jaguar,jail,jake,jam,jamaica,james,jamie,jan,jane,janet,january,japan,japanese,jar,jason,java,javascript,jay,jazz,jc,jd,je,jean,jeans,jeep,jeff,jefferson,jeffrey,jelsoft,jennifer,jenny,jeremy,jerry,jersey,jerusalem,jesse,jessica,jesus,jet,jets,jewel,jewellery,jewelry,jewish,jews,jill,jim,jimmy,jj,jm,jo,joan,job,jobs,joe,joel,john,johnny,johns,johnson,johnston,join,joined,joining,joins,joint,joke,jokes,jon,jonathan,jones,jordan,jose,joseph,josh,joshua,journal,journalism,journalist,journalists,journals,journey,joy,joyce,jp,jpeg,jpg,jr,js,juan,judge,judges,judgment,judicial,judy,juice,jul,julia,julian,julie,july,jump,jumping,jun,junction,june,jungle,junior,junk,jurisdiction,jury,just,justice,justify,justin,juvenile,jvc,k,ka,kai,kansas,karaoke,karen,karl,karma,kate,kathy,katie,katrina,kay,kazakhstan,kb,kde,keen,keep,keeping,keeps,keith,kelkoo,kelly,ken,kennedy,kenneth,kenny,keno,kent,kentucky,kenya,kept,kernel,kerry,kevin,key,keyboard,keyboards,keys,keyword,keywords,kg,kick,kid,kidney,kids,kijiji,kill,killed,killer,killing,kills,kilometers,kim,kinase,kind,kinda,kinds,king,kingdom,kings,kingston,kirk,kiss,kissing,kit,kitchen,kits,kitty,klein,km,knee,knew,knife,knight,knights,knit,knitting,knives,knock,know,knowing,knowledge,knowledgestorm,known,knows,ko,kodak,kong,korea,korean,kruger,ks,kurt,kuwait,kw,ky,kyle,l,la,lab,label,labeled,labels,labor,laboratories,laboratory,labour,labs,lace,lack,ladder,laden,ladies,lady,lafayette,laid,lake,lakes,lamb,lambda,lamp,lamps,lan,lancaster,lance,land,landing,lands,landscape,landscapes,lane,lanes,lang,language,languages,lanka,laos,lap,laptop,laptops,large,largely,larger,largest,larry,las,laser,last,lasting,lat,late,lately,later,latest,latex,latin,latina,latinas,latino,latitude,latter,latvia,lauderdale,laugh,laughing,launch,launched,launches,laundry,laura,lauren,law,lawn,lawrence,laws,lawsuit,lawyer,lawyers,lay,layer,layers,layout,lazy,lb,lbs,lc,lcd,ld,le,lead,leader,leaders,leadership,leading,leads,leaf,league,lean,learn,learned,learners,learning,lease,leasing,least,leather,leave,leaves,leaving,lebanon,lecture,lectures,led,lee,leeds,left,leg,legacy,legal,legally,legend,legendary,legends,legislation,legislative,legislature,legitimate,legs,leisure,lemon,len,lender,lenders,lending,length,lens,lenses,leo,leon,leonard,leone,les,lesbian,lesbians,leslie,less,lesser,lesson,lessons,let,lets,letter,letters,letting,leu,level,levels,levitra,levy,lewis,lexington,lexmark,lexus,lf,lg,li,liabilities,liability,liable,lib,liberal,liberia,liberty,librarian,libraries,library,libs,licence,license,licensed,licenses,licensing,licking,lid,lie,liechtenstein,lies,life,lifestyle,lifetime,lift,light,lightbox,lighter,lighting,lightning,lights,lightweight,like,liked,likelihood,likely,likes,likewise,lil,lime,limit,limitation,limitations,limited,limiting,limits,limousines,lincoln,linda,lindsay,line,linear,lined,lines,lingerie,link,linked,linking,links,linux,lion,lions,lip,lips,liquid,lisa,list,listed,listen,listening,listing,listings,listprice,lists,lit,lite,literacy,literally,literary,literature,lithuania,litigation,little,live,livecam,lived,liver,liverpool,lives,livesex,livestock,living,liz,ll,llc,lloyd,llp,lm,ln,lo,load,loaded,loading,loads,loan,loans,lobby,loc,local,locale,locally,locate,located,location,locations,locator,lock,locked,locking,locks,lodge,lodging,log,logan,logged,logging,logic,logical,login,logistics,logitech,logo,logos,logs,lol,lolita,london,lone,lonely,long,longer,longest,longitude,look,looked,looking,looks,looksmart,lookup,loop,loops,loose,lopez,lord,los,lose,losing,loss,losses,lost,lot,lots,lottery,lotus,lou,loud,louis,louise,louisiana,louisville,lounge,love,loved,lovely,lover,lovers,loves,loving,low,lower,lowest,lows,lp,ls,lt,ltd,lu,lucas,lucia,luck,lucky,lucy,luggage,luis,luke,lunch,lung,luther,luxembourg,luxury,lycos,lying,lynn,lyric,lyrics,m,ma,mac,macedonia,machine,machinery,machines,macintosh,macro,macromedia,mad,madagascar,made,madison,madness,madonna,madrid,mae,mag,magazine,magazines,magic,magical,magnet,magnetic,magnificent,magnitude,mai,maiden,mail,mailed,mailing,mailman,mails,mailto,main,maine,mainland,mainly,mainstream,maintain,maintained,maintaining,maintains,maintenance,major,majority,make,maker,makers,makes,makeup,making,malawi,malaysia,maldives,male,males,mali,mall,malpractice,malta,mambo,man,manage,managed,management,manager,managers,managing,manchester,mandate,mandatory,manga,manhattan,manitoba,manner,manor,manual,manually,manuals,manufacture,manufactured,manufacturer,manufacturers,manufacturing,many,map,maple,mapping,maps,mar,marathon,marble,marc,march,marco,marcus,mardi,margaret,margin,maria,mariah,marie,marijuana,marilyn,marina,marine,mario,marion,maritime,mark,marked,marker,markers,market,marketing,marketplace,markets,marking,marks,marriage,married,marriott,mars,marsh,marshall,mart,martha,martial,martin,marvel,mary,maryland,mas,mask,mason,mass,massachusetts,massage,massive,master,mastercard,masters,masturbating,masturbation,mat,match,matched,matches,matching,mate,material,materials,maternity,math,mathematical,mathematics,mating,matrix,mats,matt,matter,matters,matthew,mattress,mature,maui,mauritius,max,maximize,maximum,may,maybe,mayor,mazda,mb,mba,mc,mcdonald,md,me,meal,meals,mean,meaning,meaningful,means,meant,meanwhile,measure,measured,measurement,measurements,measures,measuring,meat,mechanical,mechanics,mechanism,mechanisms,med,medal,media,median,mediawiki,medicaid,medical,medicare,medication,medications,medicine,medicines,medieval,meditation,mediterranean,medium,medline,meet,meeting,meetings,meets,meetup,mega,mel,melbourne,melissa,mem,member,members,membership,membrane,memo,memorabilia,memorial,memories,memory,memphis,men,mens,ment,mental,mention,mentioned,mentor,menu,menus,mercedes,merchandise,merchant,merchants,mercury,mercy,mere,merely,merge,merger,merit,merry,mesa,mesh,mess,message,messages,messaging,messenger,met,meta,metabolism,metadata,metal,metallic,metallica,metals,meter,meters,method,methodology,methods,metres,metric,metro,metropolitan,mexican,mexico,meyer,mf,mg,mh,mhz,mi,mia,miami,mic,mice,michael,michel,michelle,michigan,micro,microphone,microsoft,microwave,mid,middle,midi,midlands,midnight,midwest,might,mighty,migration,mike,mil,milan,mild,mile,mileage,miles,milf,milfhunter,milfs,military,milk,mill,millennium,miller,million,millions,mills,milton,milwaukee,mime,min,mind,minds,mine,mineral,minerals,mines,mini,miniature,minimal,minimize,minimum,mining,minister,ministers,ministries,ministry,minneapolis,minnesota,minolta,minor,minority,mins,mint,minus,minute,minutes,miracle,mirror,mirrors,misc,miscellaneous,miss,missed,missile,missing,mission,missions,mississippi,missouri,mistake,mistakes,mistress,mit,mitchell,mitsubishi,mix,mixed,mixer,mixing,mixture,mj,ml,mlb,mls,mm,mn,mo,mobile,mobiles,mobility,mod,mode,model,modeling,modelling,models,modem,modems,moderate,moderator,moderators,modern,modes,modification,modifications,modified,modify,mods,modular,module,modules,moisture,mold,moldova,molecular,molecules,mom,moment,moments,momentum,moms,mon,monaco,monday,monetary,money,mongolia,monica,monitor,monitored,monitoring,monitors,monkey,mono,monroe,monster,monsters,montana,monte,montgomery,month,monthly,months,montreal,mood,moon,moore,moral,more,moreover,morgan,morning,morocco,morris,morrison,mortality,mortgage,mortgages,moscow,moses,moss,most,mostly,motel,motels,mother,motherboard,mothers,motion,motivated,motivation,motor,motorcycle,motorcycles,motorola,motors,mount,mountain,mountains,mounted,mounting,mounts,mouse,mouth,move,moved,movement,movements,movers,moves,movie,movies,moving,mozambique,mozilla,mp,mpeg,mpegs,mpg,mph,mr,mrna,mrs,ms,msg,msgid,msgstr,msie,msn,mt,mtv,mu,much,mud,mug,multi,multimedia,multiple,mumbai,munich,municipal,municipality,murder,murphy,murray,muscle,muscles,museum,museums,music,musical,musician,musicians,muslim,muslims,must,mustang,mutual,muze,mv,mw,mx,my,myanmar,myers,myrtle,myself,mysimon,myspace,mysql,mysterious,mystery,myth,n,na,nail,nails,naked,nam,name,named,namely,names,namespace,namibia,nancy,nano,naples,narrative,narrow,nasa,nascar,nasdaq,nashville,nasty,nat,nathan,nation,national,nationally,nations,nationwide,native,nato,natural,naturally,naturals,nature,naughty,nav,naval,navigate,navigation,navigator,navy,nb,nba,nbc,nc,ncaa,nd,ne,near,nearby,nearest,nearly,nebraska,nec,necessarily,necessary,necessity,neck,necklace,need,needed,needle,needs,negative,negotiation,negotiations,neighbor,neighborhood,neighbors,neil,neither,nelson,neo,neon,nepal,nerve,nervous,nest,nested,net,netherlands,netscape,network,networking,networks,neural,neutral,nevada,never,nevertheless,new,newark,newbie,newcastle,newer,newest,newfoundland,newly,newman,newport,news,newsletter,newsletters,newspaper,newspapers,newton,next,nextel,nfl,ng,nh,nhl,nhs,ni,niagara,nicaragua,nice,nicholas,nick,nickel,nickname,nicole,niger,nigeria,night,nightlife,nightmare,nights,nike,nikon,nil,nine,nintendo,nipple,nipples,nirvana,nissan,nitrogen,nj,nl,nm,nn,no,noble,nobody,node,nodes,noise,nokia,nominated,nomination,nominations,non,none,nonprofit,noon,nor,norfolk,norm,normal,normally,norman,north,northeast,northern,northwest,norton,norway,norwegian,nose,not,note,notebook,notebooks,noted,notes,nothing,notice,noticed,notices,notification,notifications,notified,notify,notion,notre,nottingham,nov,nova,novel,novels,novelty,november,now,nowhere,np,nr,ns,nsw,nt,ntsc,nu,nuclear,nude,nudist,nudity,nuke,null,number,numbers,numeric,numerical,numerous,nurse,nursery,nurses,nursing,nut,nutrition,nutritional,nuts,nutten,nv,nvidia,nw,ny,nyc,nylon,nz,o,oak,oakland,oaks,oasis,ob,obesity,obituaries,obj,object,objective,objectives,objects,obligation,obligations,observation,observations,observe,observed,observer,obtain,obtained,obtaining,obvious,obviously,oc,occasion,occasional,occasionally,occasions,occupation,occupational,occupations,occupied,occur,occurred,occurrence,occurring,occurs,ocean,oclc,oct,october,odd,odds,oe,oecd,oem,of,off,offense,offensive,offer,offered,offering,offerings,offers,office,officer,officers,offices,official,officially,officials,offline,offset,offshore,often,og,oh,ohio,oil,oils,ok,okay,oklahoma,ol,old,older,oldest,olive,oliver,olympic,olympics,olympus,om,omaha,oman,omega,omissions,on,once,one,ones,ongoing,onion,online,only,ons,ontario,onto,oo,ooo,oops,op,open,opened,opening,openings,opens,opera,operate,operated,operates,operating,operation,operational,operations,operator,operators,opinion,opinions,opponent,opponents,opportunities,opportunity,opposed,opposite,opposition,opt,optical,optics,optimal,optimization,optimize,optimum,option,optional,options,or,oracle,oral,orange,orbit,orchestra,order,ordered,ordering,orders,ordinance,ordinary,oregon,org,organ,organic,organisation,organisations,organised,organisms,organization,organizational,organizations,organize,organized,organizer,organizing,orgasm,orgy,oriental,orientation,oriented,origin,original,originally,origins,orlando,orleans,os,oscar,ot,other,others,otherwise,ottawa,ou,ought,our,ours,ourselves,out,outcome,outcomes,outdoor,outdoors,outer,outlet,outlets,outline,outlined,outlook,output,outputs,outreach,outside,outsourcing,outstanding,oval,oven,over,overall,overcome,overhead,overnight,overseas,overview,owen,own,owned,owner,owners,ownership,owns,oxford,oxide,oxygen,oz,ozone,pace,pacific,pack,package,packages,packaging,packard,packed,packet,packets,packing,packs,pad,pads,page,pages,paid,pain,painful,paint,paintball,painted,painting,paintings,pair,pairs,pakistan,pal,palace,pale,palestine,palestinian,palm,palmer,pam,pamela,pan,panama,panasonic,panel,panels,panic,panties,pants,pantyhose,paper,paperback,paperbacks,papers,papua,par,para,parade,paradise,paragraph,paragraphs,paraguay,parallel,parameter,parameters,parcel,parent,parental,parenting,parents,paris,parish,park,parker,parking,parks,parliament,parliamentary,part,partial,partially,participant,participants,participate,participated,participating,participation,particle,particles,particular,particularly,parties,partition,partly,partner,partners,partnership,partnerships,parts,party,pas,paso,pass,passage,passed,passenger,passengers,passes,passing,passion,passive,passport,password,passwords,past,pasta,paste,pastor,pat,patch,patches,patent,patents,path,pathology,paths,patient,patients,patio,patricia,patrick,patrol,pattern,patterns,paul,pavilion,paxil,pay,payable,payday,paying,payment,payments,paypal,payroll,pays,pb,pc,pci,pcs,pct,pd,pda,pdas,pdf,pdt,pe,peace,peaceful,peak,pearl,peas,pediatric,pee,peeing,peer,peers,pen,penalties,penalty,pencil,pendant,pending,penetration,penguin,peninsula,penis,penn,pennsylvania,penny,pens,pension,pensions,pentium,people,peoples,pepper,per,perceived,percent,percentage,perception,perfect,perfectly,perform,performance,performances,performed,performer,performing,performs,perfume,perhaps,period,periodic,periodically,periods,peripheral,peripherals,perl,permalink,permanent,permission,permissions,permit,permits,permitted,perry,persian,persistent,person,personal,personality,personalized,personally,personals,personnel,persons,perspective,perspectives,perth,peru,pest,pet,pete,peter,petersburg,peterson,petite,petition,petroleum,pets,pf,pg,pgp,ph,phantom,pharmaceutical,pharmaceuticals,pharmacies,pharmacology,pharmacy,phase,phases,phd,phenomenon,phentermine,phi,phil,philadelphia,philip,philippines,philips,phillips,philosophy,phoenix,phone,phones,photo,photograph,photographer,photographers,photographic,photographs,photography,photos,photoshop,php,phpbb,phrase,phrases,phys,physical,physically,physician,physicians,physics,physiology,pi,piano,pic,pichunter,pick,picked,picking,picks,pickup,picnic,pics,picture,pictures,pie,piece,pieces,pierce,pierre,pig,pike,pill,pillow,pills,pilot,pin,pine,ping,pink,pins,pioneer,pipe,pipeline,pipes,pirates,piss,pissing,pit,pitch,pittsburgh,pix,pixel,pixels,pizza,pj,pk,pl,place,placed,placement,places,placing,plain,plains,plaintiff,plan,plane,planes,planet,planets,planned,planner,planners,planning,plans,plant,plants,plasma,plastic,plastics,plate,plates,platform,platforms,platinum,play,playback,playboy,played,player,players,playing,playlist,plays,playstation,plaza,plc,pleasant,please,pleased,pleasure,pledge,plenty,plot,plots,plug,plugin,plugins,plumbing,plus,plymouth,pm,pmc,pmid,pn,po,pocket,pockets,pod,podcast,podcasts,poem,poems,poet,poetry,point,pointed,pointer,pointing,points,poison,pokemon,poker,poland,polar,pole,police,policies,policy,polish,polished,political,politicians,politics,poll,polls,pollution,polo,poly,polyester,polymer,polyphonic,pond,pontiac,pool,pools,poor,pop,pope,popular,popularity,population,populations,por,porcelain,pork,porn,porno,porsche,port,portable,portal,porter,portfolio,portion,portions,portland,portrait,portraits,ports,portsmouth,portugal,portuguese,pos,pose,posing,position,positioning,positions,positive,possess,possession,possibilities,possibility,possible,possibly,post,postage,postal,postcard,postcards,posted,poster,posters,posting,postings,postposted,posts,pot,potato,potatoes,potential,potentially,potter,pottery,poultry,pound,pounds,pour,poverty,powder,powell,power,powered,powerful,powerpoint,powers,powerseller,pp,ppc,ppm,pr,practical,practice,practices,practitioner,practitioners,prague,prairie,praise,pray,prayer,prayers,pre,preceding,precious,precipitation,precise,precisely,precision,predict,predicted,prediction,predictions,prefer,preference,preferences,preferred,prefers,prefix,pregnancy,pregnant,preliminary,premier,premiere,premises,premium,prep,prepaid,preparation,prepare,prepared,preparing,prerequisite,prescribed,prescription,presence,present,presentation,presentations,presented,presenting,presently,presents,preservation,preserve,president,presidential,press,pressed,pressing,pressure,preston,pretty,prev,prevent,preventing,prevention,preview,previews,previous,previously,price,priced,prices,pricing,pride,priest,primarily,primary,prime,prince,princess,princeton,principal,principle,principles,print,printable,printed,printer,printers,printing,prints,prior,priorities,priority,prison,prisoner,prisoners,privacy,private,privilege,privileges,prix,prize,prizes,pro,probability,probably,probe,problem,problems,proc,procedure,procedures,proceed,proceeding,proceedings,proceeds,process,processed,processes,processing,processor,processors,procurement,produce,produced,producer,producers,produces,producing,product,production,productions,productive,productivity,products,profession,professional,professionals,professor,profile,profiles,profit,profits,program,programme,programmer,programmers,programmes,programming,programs,progress,progressive,prohibited,project,projected,projection,projector,projectors,projects,prominent,promise,promised,promises,promising,promo,promote,promoted,promotes,promoting,promotion,promotional,promotions,prompt,promptly,proof,propecia,proper,properly,properties,property,prophet,proportion,proposal,proposals,propose,proposed,proposition,proprietary,pros,prospect,prospective,prospects,prostate,prostores,prot,protect,protected,protecting,protection,protective,protein,proteins,protest,protocol,protocols,prototype,proud,proudly,prove,proved,proven,provide,provided,providence,provider,providers,provides,providing,province,provinces,provincial,provision,provisions,proxy,prozac,ps,psi,psp,pst,psychiatry,psychological,psychology,pt,pts,pty,pub,public,publication,publications,publicity,publicly,publish,published,publisher,publishers,publishing,pubmed,pubs,puerto,pull,pulled,pulling,pulse,pump,pumps,punch,punishment,punk,pupils,puppy,purchase,purchased,purchases,purchasing,pure,purple,purpose,purposes,purse,pursuant,pursue,pursuit,push,pushed,pushing,pussy,put,puts,putting,puzzle,puzzles,pvc,python,q,qatar,qc,qld,qt,qty,quad,qualification,qualifications,qualified,qualify,qualifying,qualities,quality,quantitative,quantities,quantity,quantum,quarter,quarterly,quarters,que,quebec,queen,queens,queensland,queries,query,quest,question,questionnaire,questions,queue,qui,quick,quickly,quiet,quilt,quit,quite,quiz,quizzes,quotations,quote,quoted,quotes,r,ra,rabbit,race,races,rachel,racial,racing,rack,racks,radar,radiation,radical,radio,radios,radius,rage,raid,rail,railroad,railway,rain,rainbow,raise,raised,raises,raising,raleigh,rally,ralph,ram,ran,ranch,rand,random,randy,range,ranger,rangers,ranges,ranging,rank,ranked,ranking,rankings,ranks,rap,rape,rapid,rapidly,rapids,rare,rarely,rat,rate,rated,rates,rather,rating,ratings,ratio,rational,ratios,rats,raw,ray,raymond,rays,rb,rc,rca,rd,re,reach,reached,reaches,reaching,reaction,reactions,read,reader,readers,readily,reading,readings,reads,ready,real,realistic,reality,realize,realized,really,realm,realtor,realtors,realty,rear,reason,reasonable,reasonably,reasoning,reasons,rebate,rebates,rebecca,rebel,rebound,rec,recall,receipt,receive,received,receiver,receivers,receives,receiving,recent,recently,reception,receptor,receptors,recipe,recipes,recipient,recipients,recognised,recognition,recognize,recognized,recommend,recommendation,recommendations,recommended,recommends,reconstruction,record,recorded,recorder,recorders,recording,recordings,records,recover,recovered,recovery,recreation,recreational,recruiting,recruitment,recycling,red,redeem,redhead,reduce,reduced,reduces,reducing,reduction,reductions,reed,reef,reel,ref,refer,reference,referenced,references,referral,referrals,referred,referring,refers,refinance,refine,refined,reflect,reflected,reflection,reflections,reflects,reform,reforms,refresh,refrigerator,refugees,refund,refurbished,refuse,refused,reg,regard,regarded,regarding,regardless,regards,reggae,regime,region,regional,regions,register,registered,registrar,registration,registry,regression,regular,regularly,regulated,regulation,regulations,regulatory,rehab,rehabilitation,reid,reject,rejected,relate,related,relates,relating,relation,relations,relationship,relationships,relative,relatively,relatives,relax,relaxation,relay,release,released,releases,relevance,relevant,reliability,reliable,reliance,relief,religion,religions,religious,reload,relocation,rely,relying,remain,remainder,remained,remaining,remains,remark,remarkable,remarks,remedies,remedy,remember,remembered,remind,reminder,remix,remote,removable,removal,remove,removed,removing,renaissance,render,rendered,rendering,renew,renewable,renewal,reno,rent,rental,rentals,rep,repair,repairs,repeat,repeated,replace,replaced,replacement,replacing,replica,replication,replied,replies,reply,report,reported,reporter,reporters,reporting,reports,repository,represent,representation,representations,representative,representatives,represented,representing,represents,reprint,reprints,reproduce,reproduced,reproduction,reproductive,republic,republican,republicans,reputation,request,requested,requesting,requests,require,required,requirement,requirements,requires,requiring,res,rescue,research,researcher,researchers,reseller,reservation,reservations,reserve,reserved,reserves,reservoir,reset,residence,resident,residential,residents,resist,resistance,resistant,resolution,resolutions,resolve,resolved,resort,resorts,resource,resources,respect,respected,respective,respectively,respiratory,respond,responded,respondent,respondents,responding,response,responses,responsibilities,responsibility,responsible,rest,restaurant,restaurants,restoration,restore,restored,restrict,restricted,restriction,restrictions,restructuring,result,resulted,resulting,results,resume,resumes,retail,retailer,retailers,retain,retained,retention,retired,retirement,retreat,retrieval,retrieve,retrieved,retro,return,returned,returning,returns,reunion,reuters,rev,reveal,revealed,reveals,revelation,revenge,revenue,revenues,reverse,review,reviewed,reviewer,reviewing,reviews,revised,revision,revisions,revolution,revolutionary,reward,rewards,reynolds,rf,rfc,rg,rh,rhode,rhythm,ri,ribbon,rica,rice,rich,richard,richards,richardson,richmond,rick,ricky,rico,rid,ride,rider,riders,rides,ridge,riding,right,rights,rim,ring,rings,ringtone,ringtones,rio,rip,ripe,rise,rising,risk,risks,river,rivers,riverside,rj,rl,rm,rn,rna,ro,road,roads,rob,robbie,robert,roberts,robertson,robin,robinson,robot,robots,robust,rochester,rock,rocket,rocks,rocky,rod,roger,rogers,roland,role,roles,roll,rolled,roller,rolling,rolls,rom,roman,romance,romania,romantic,rome,ron,ronald,roof,room,roommate,roommates,rooms,root,roots,rope,rosa,rose,roses,ross,roster,rotary,rotation,rouge,rough,roughly,roulette,round,rounds,route,router,routers,routes,routine,routines,routing,rover,row,rows,roy,royal,royalty,rp,rpg,rpm,rr,rrp,rs,rss,rt,ru,rubber,ruby,rug,rugby,rugs,rule,ruled,rules,ruling,run,runner,running,runs,runtime,rural,rush,russell,russia,russian,ruth,rv,rw,rwanda,rx,ryan,sacramento,sacred,sacrifice,sad,saddam,safari,safe,safely,safer,safety,sage,sagem,said,sail,sailing,saint,saints,sake,salad,salaries,salary,sale,salem,sales,sally,salmon,salon,salt,salvador,salvation,sam,samba,same,samoa,sample,samples,sampling,samsung,samuel,san,sand,sandra,sandwich,sandy,sans,santa,sanyo,sao,sap,sapphire,sara,sarah,sas,saskatchewan,sat,satellite,satin,satisfaction,satisfactory,satisfied,satisfy,saturday,saturn,sauce,saudi,savage,savannah,save,saved,saver,saves,saving,savings,saw,say,saying,says,sb,sbjct,sc,scale,scales,scan,scanned,scanner,scanners,scanning,scared,scary,scenario,scenarios,scene,scenes,scenic,schedule,scheduled,schedules,scheduling,schema,scheme,schemes,scholar,scholars,scholarship,scholarships,school,schools,sci,science,sciences,scientific,scientist,scientists,scoop,scope,score,scored,scores,scoring,scotia,scotland,scott,scottish,scout,scratch,screen,screening,screens,screensaver,screensavers,screenshot,screenshots,screw,script,scripting,scripts,scroll,scsi,scuba,sculpture,sd,se,sea,seafood,seal,sealed,sean,search,searched,searches,searching,seas,season,seasonal,seasons,seat,seating,seats,seattle,sec,second,secondary,seconds,secret,secretariat,secretary,secrets,section,sections,sector,sectors,secure,secured,securely,securities,security,see,seed,seeds,seeing,seek,seeker,seekers,seeking,seeks,seem,seemed,seems,seen,sees,sega,segment,segments,select,selected,selecting,selection,selections,selective,self,sell,seller,sellers,selling,sells,semester,semi,semiconductor,seminar,seminars,sen,senate,senator,senators,send,sender,sending,sends,senegal,senior,seniors,sense,sensitive,sensitivity,sensor,sensors,sent,sentence,sentences,seo,sep,separate,separated,separately,separation,sept,september,seq,sequence,sequences,ser,serbia,serial,series,serious,seriously,serum,serve,served,server,servers,serves,service,services,serving,session,sessions,set,sets,setting,settings,settle,settled,settlement,setup,seven,seventh,several,severe,sewing,sex,sexcam,sexo,sexual,sexuality,sexually,sexy,sf,sg,sh,shade,shades,shadow,shadows,shaft,shake,shakespeare,shakira,shall,shame,shanghai,shannon,shape,shaped,shapes,share,shared,shareholders,shares,shareware,sharing,shark,sharon,sharp,shaved,shaw,she,shed,sheep,sheer,sheet,sheets,sheffield,shelf,shell,shelter,shemale,shemales,shepherd,sheriff,sherman,shield,shift,shine,ship,shipment,shipments,shipped,shipping,ships,shirt,shirts,shit,shock,shoe,shoes,shoot,shooting,shop,shopper,shoppers,shopping,shops,shopzilla,shore,short,shortcuts,shorter,shortly,shorts,shot,shots,should,shoulder,show,showcase,showed,shower,showers,showing,shown,shows,showtimes,shut,shuttle,si,sic,sick,side,sides,sie,siemens,sierra,sig,sight,sigma,sign,signal,signals,signature,signatures,signed,significance,significant,significantly,signing,signs,signup,silence,silent,silicon,silk,silly,silver,sim,similar,similarly,simon,simple,simplified,simply,simpson,simpsons,sims,simulation,simulations,simultaneously,sin,since,sing,singapore,singer,singh,singing,single,singles,sink,sip,sir,sister,sisters,sit,site,sitemap,sites,sitting,situated,situation,situations,six,sixth,size,sized,sizes,sk,skating,ski,skiing,skill,skilled,skills,skin,skins,skip,skirt,skirts,sku,sky,skype,sl,slave,sleep,sleeping,sleeps,sleeve,slide,slides,slideshow,slight,slightly,slim,slip,slope,slot,slots,slovak,slovakia,slovenia,slow,slowly,slut,sluts,sm,small,smaller,smallest,smart,smell,smile,smilies,smith,smithsonian,smoke,smoking,smooth,sms,smtp,sn,snake,snap,snapshot,snow,snowboard,so,soa,soap,soc,soccer,social,societies,society,sociology,socket,socks,sodium,sofa,soft,softball,software,soil,sol,solar,solaris,sold,soldier,soldiers,sole,solely,solid,solo,solomon,solution,solutions,solve,solved,solving,soma,somalia,some,somebody,somehow,someone,somerset,something,sometimes,somewhat,somewhere,son,song,songs,sonic,sons,sony,soon,soonest,sophisticated,sorry,sort,sorted,sorts,sought,soul,souls,sound,sounds,soundtrack,soup,source,sources,south,southampton,southeast,southern,southwest,soviet,sox,sp,spa,space,spaces,spain,spam,span,spanish,spank,spanking,sparc,spare,spas,spatial,speak,speaker,speakers,speaking,speaks,spears,spec,special,specialist,specialists,specialized,specializing,specially,specials,specialties,specialty,species,specific,specifically,specification,specifications,specifics,specified,specifies,specify,specs,spectacular,spectrum,speech,speeches,speed,speeds,spell,spelling,spencer,spend,spending,spent,sperm,sphere,spice,spider,spies,spin,spine,spirit,spirits,spiritual,spirituality,split,spoke,spoken,spokesman,sponsor,sponsored,sponsors,sponsorship,sport,sporting,sports,spot,spotlight,spots,spouse,spray,spread,spreading,spring,springer,springfield,springs,sprint,spy,spyware,sq,sql,squad,square,squirt,squirting,sr,src,sri,ss,ssl,st,stability,stable,stack,stadium,staff,staffing,stage,stages,stainless,stake,stakeholders,stamp,stamps,stan,stand,standard,standards,standing,standings,stands,stanford,stanley,star,starring,stars,starsmerchant,start,started,starter,starting,starts,startup,stat,state,stated,statement,statements,states,statewide,static,stating,station,stationery,stations,statistical,statistics,stats,status,statute,statutes,statutory,stay,stayed,staying,stays,std,ste,steady,steal,steam,steel,steering,stem,step,stephanie,stephen,steps,stereo,sterling,steve,steven,stevens,stewart,stick,sticker,stickers,sticks,sticky,still,stock,stockholm,stockings,stocks,stolen,stomach,stone,stones,stood,stop,stopped,stopping,stops,storage,store,stored,stores,stories,storm,story,str,straight,strain,strand,strange,stranger,strap,strategic,strategies,strategy,stream,streaming,streams,street,streets,strength,strengthen,strengthening,strengths,stress,stretch,strict,strictly,strike,strikes,striking,string,strings,strip,stripes,strips,stroke,strong,stronger,strongly,struck,struct,structural,structure,structured,structures,struggle,stuart,stuck,stud,student,students,studied,studies,studio,studios,study,studying,stuff,stuffed,stunning,stupid,style,styles,stylish,stylus,su,sub,subaru,subcommittee,subdivision,subject,subjective,subjects,sublime,sublimedirectory,submission,submissions,submit,submitted,submitting,subscribe,subscriber,subscribers,subscription,subscriptions,subsection,subsequent,subsequently,subsidiaries,subsidiary,substance,substances,substantial,substantially,substitute,subtle,suburban,succeed,success,successful,successfully,such,suck,sucking,sucks,sudan,sudden,suddenly,sue,suffer,suffered,suffering,sufficient,sufficiently,sugar,suggest,suggested,suggesting,suggestion,suggestions,suggests,suicide,suit,suitable,suite,suited,suites,suits,sullivan,sum,summaries,summary,summer,summit,sun,sunday,sunglasses,sunny,sunrise,sunset,sunshine,super,superb,superintendent,superior,supervision,supervisor,supervisors,supplement,supplemental,supplements,supplied,supplier,suppliers,supplies,supply,support,supported,supporters,supporting,supports,suppose,supposed,supreme,sur,sure,surely,surf,surface,surfaces,surfing,surge,surgeon,surgeons,surgery,surgical,surname,surplus,surprise,surprised,surprising,surrey,surround,surrounded,surrounding,surveillance,survey,surveys,survival,survive,survivor,survivors,susan,suse,suspect,suspected,suspended,suspension,sussex,sustainability,sustainable,sustained,suzuki,sv,sw,swap,swaziland,sweden,swedish,sweet,swift,swim,swimming,swing,swingers,swiss,switch,switched,switches,switching,switzerland,sword,sydney,symantec,symbol,symbols,sympathy,symphony,symposium,symptoms,sync,syndicate,syndication,syndrome,synopsis,syntax,synthesis,synthetic,syracuse,syria,sys,system,systematic,systems,t,ta,tab,table,tables,tablet,tablets,tabs,tackle,tactics,tag,tagged,tags,tahoe,tail,taiwan,take,taken,takes,taking,tale,talent,talented,tales,talk,talked,talking,talks,tall,tamil,tampa,tan,tank,tanks,tanzania,tap,tape,tapes,tar,target,targeted,targets,tariff,task,tasks,taste,tattoo,taught,tax,taxation,taxes,taxi,taylor,tb,tba,tc,tcp,td,te,tea,teach,teacher,teachers,teaches,teaching,team,teams,tear,tears,tech,technical,technician,technique,techniques,techno,technological,technologies,technology,techrepublic,ted,teddy,tee,teen,teenage,teens,teeth,tel,telecharger,telecom,telecommunications,telephone,telephony,telescope,television,televisions,tell,telling,tells,temp,temperature,temperatures,template,templates,temple,temporal,temporarily,temporary,ten,tenant,tend,tender,tennessee,tennis,tension,tent,term,terminal,terminals,termination,terminology,terms,terrace,terrain,terrible,territories,territory,terror,terrorism,terrorist,terrorists,terry,test,testament,tested,testimonials,testimony,testing,tests,tex,texas,text,textbook,textbooks,textile,textiles,texts,texture,tf,tft,tgp,th,thai,thailand,than,thank,thanks,thanksgiving,that,thats,the,theater,theaters,theatre,thee,theft,thehun,their,them,theme,themes,themselves,then,theology,theorem,theoretical,theories,theory,therapeutic,therapist,therapy,there,thereafter,thereby,therefore,thereof,thermal,thesaurus,these,thesis,theta,they,thick,thickness,thin,thing,things,think,thinking,thinkpad,thinks,third,thirty,this,thomas,thompson,thomson,thong,thongs,thorough,thoroughly,those,thou,though,thought,thoughts,thousand,thousands,thread,threaded,threads,threat,threatened,threatening,threats,three,threesome,threshold,thriller,throat,through,throughout,throw,throwing,thrown,throws,thru,thu,thumb,thumbnail,thumbnails,thumbs,thumbzilla,thunder,thursday,thus,thy,ti,ticket,tickets,tide,tie,tied,tier,ties,tiffany,tiger,tigers,tight,til,tile,tiles,till,tim,timber,time,timeline,timely,timer,times,timing,timothy,tin,tiny,tion,tions,tip,tips,tire,tired,tires,tissue,tit,titanium,titans,title,titled,titles,tits,titten,tm,tmp,tn,to,tobacco,tobago,today,todd,toddler,toe,together,toilet,token,tokyo,told,tolerance,toll,tom,tomato,tomatoes,tommy,tomorrow,ton,tone,toner,tones,tongue,tonight,tons,tony,too,took,tool,toolbar,toolbox,toolkit,tools,tooth,top,topic,topics,topless,tops,toronto,torture,toshiba,total,totally,totals,touch,touched,tough,tour,touring,tourism,tourist,tournament,tournaments,tours,toward,towards,tower,towers,town,towns,township,toxic,toy,toyota,toys,tp,tr,trace,track,trackback,trackbacks,tracked,tracker,tracking,tracks,tract,tractor,tracy,trade,trademark,trademarks,trader,trades,trading,tradition,traditional,traditions,traffic,tragedy,trail,trailer,trailers,trails,train,trained,trainer,trainers,training,trains,tramadol,trance,tranny,trans,transaction,transactions,transcript,transcription,transcripts,transexual,transexuales,transfer,transferred,transfers,transform,transformation,transit,transition,translate,translated,translation,translations,translator,transmission,transmit,transmitted,transparency,transparent,transport,Transportation,transsexual,trap,trash,trauma,travel,traveler,travelers,traveling,traveller,travelling,travels,travesti,travis,tray,treasure,treasurer,treasures,treasury,treat,treated,treating,treatment,treatments,treaty,tree,trees,trek,trembl,tremendous,trend,trends,treo,tri,trial,trials,triangle,tribal,tribe,tribes,tribunal,tribune,tribute,trick,tricks,tried,tries,trigger,trim,trinidad,trinity,trio,trip,tripadvisor,triple,trips,triumph,trivia,troops,tropical,trouble,troubleshooting,trout,troy,truck,trucks,TRUE,truly,trunk,trust,trusted,trustee,trustees,trusts,truth,try,trying,ts,tsunami,tt,tu,tub,tube,tubes,tucson,tue,tuesday,tuition,tulsa,tumor,tune,tuner,tunes,tuning,tunisia,tunnel,turbo,turkey,turkish,turn,turned,turner,turning,turns,turtle,tutorial,tutorials,tv,tvs,twelve,twenty,twice,twiki,twin,twinks,twins,twist,twisted,two,tx,ty,tyler,type,types,typical,typically,typing,u,uc,uganda,ugly,uh,ui,uk,ukraine,ul,ultimate,ultimately,ultra,ultram,um,un,una,unable,unauthorized,unavailable,uncertainty,uncle,und,undefined,under,undergraduate,underground,underlying,understand,understanding,understood,undertake,undertaken,underwear,undo,une,unemployment,unexpected,unfortunately,uni,unified,uniform,union,unions,uniprotkb,unique,unit,united,units,unity,univ,universal,universe,universities,university,unix,unknown,unless,unlike,unlikely,unlimited,unlock,unnecessary,unsigned,unsubscribe,until,untitled,unto,unusual,unwrap,up,upc,upcoming,update,updated,updates,updating,upgrade,upgrades,upgrading,upload,uploaded,upon,upper,ups,upset,upskirt,upskirts,ur,urban,urge,urgent,uri,url,urls,uruguay,urw,us,usa,usage,usb,usc,usd,usda,use,used,useful,user,username,users,uses,usgs,using,usps,usr,usual,usually,ut,utah,utc,utilities,utility,utilization,utilize,utils,uv,uw,uzbekistan,v,va,vacancies,vacation,vacations,vaccine,vacuum,vagina,val,valentine,valid,validation,validity,valium,valley,valuable,valuation,value,valued,values,valve,valves,vampire,van,vancouver,vanilla,var,variable,variables,variance,variation,variations,varied,varies,varieties,variety,various,vary,varying,vast,vat,vatican,vault,vb,vbulletin,vc,vcr,ve,vector,vegas,vegetable,vegetables,vegetarian,vegetation,vehicle,vehicles,velocity,velvet,vendor,vendors,venezuela,venice,venture,ventures,venue,venues,ver,verbal,verde,verification,verified,verify,verizon,vermont,vernon,verse,version,versions,versus,vertex,vertical,very,verzeichnis,vessel,vessels,veteran,veterans,veterinary,vg,vhs,vi,via,viagra,vibrator,vibrators,vic,vice,victim,victims,victor,victoria,victorian,victory,vid,video,videos,vids,vienna,vietnam,vietnamese,view,viewed,viewer,viewers,viewing,viewpicture,views,vii,viii,viking,villa,village,villages,villas,vincent,vintage,vinyl,violation,violations,violence,violent,violin,vip,viral,virgin,virginia,virtual,virtually,virtue,virus,viruses,visa,visibility,visible,vision,visit,visited,visiting,visitor,visitors,visits,vista,visual,vital,vitamin,vitamins,vocabulary,vocal,vocals,vocational,voice,voices,void,voip,vol,volkswagen,volleyball,volt,voltage,volume,volumes,voluntary,volunteer,volunteers,volvo,von,vote,voted,voters,votes,voting,voyeur,voyeurweb,voyuer,vp,vpn,vs,vsnet,vt,vulnerability,vulnerable,w,wa,wage,wages,wagner,wagon,wait,waiting,waiver,wake,wal,wales,walk,walked,walker,walking,walks,wall,wallace,wallet,wallpaper,wallpapers,walls,walnut,walt,walter,wan,wang,wanna,want,wanted,wanting,wants,war,warcraft,ward,ware,warehouse,warm,warming,warned,warner,warning,warnings,warrant,warranties,warranty,warren,warrior,warriors,wars,was,wash,washer,washing,washington,waste,watch,watched,watches,watching,water,waterproof,waters,watershed,watson,watt,watts,wav,wave,waves,wax,way,wayne,ways,wb,wc,we,weak,wealth,weapon,weapons,wear,wearing,weather,web,webcam,webcams,webcast,weblog,weblogs,webmaster,webmasters,webpage,webshots,website,websites,webster,wed,wedding,weddings,wednesday,weed,week,weekend,weekends,weekly,weeks,weight,weighted,weights,weird,welcome,welding,welfare,well,wellington,wellness,wells,welsh,wendy,went,were,wesley,west,western,westminster,wet,whale,what,whatever,whats,wheat,wheel,wheels,when,whenever,where,whereas,wherever,whether,which,while,whilst,white,who,whole,wholesale,whom,whore,whose,why,wi,wichita,wicked,wide,widely,wider,widescreen,widespread,width,wife,wifi,wiki,wikipedia,wild,wilderness,wildlife,wiley,will,william,williams,willing,willow,wilson,win,wind,window,windows,winds,windsor,wine,wines,wing,wings,winner,winners,winning,wins,winston,winter,wire,wired,wireless,wires,wiring,wisconsin,wisdom,wise,wish,wishes,wishing,wishlist,wit,witch,with,withdrawal,within,without,witness,witnesses,wives,wizard,wm,wma,wn,wolf,woman,women,womens,won,wonder,wonderful,wondering,wood,wooden,woods,wool,worcester,word,wordpress,words,work,worked,worker,workers,workflow,workforce,working,workout,workplace,works,workshop,workshops,workstation,world,worldcat,worlds,worldsex,worldwide,worm,worn,worried,worry,worse,worship,worst,worth,worthy,would,wound,wow,wp,wr,wrap,wrapped,wrapping,wrestling,wright,wrist,write,writer,writers,writes,writing,writings,written,wrong,wrote,ws,wt,wto,wu,wv,ww,www,wx,wy,wyoming,x,xanax,xbox,xerox,xhtml,xi,xl,xml,xnxx,xp,xx,xxx,y,ya,yacht,yahoo,yale,yamaha,yang,yard,yards,yarn,ye,yea,yeah,year,yearly,years,yeast,yellow,yemen,yen,yes,yesterday,yet,yield,yields,yn,yo,yoga,york,yorkshire,you,young,younger,your,yours,yourself,youth,yr,yrs,yu,yugoslavia,yukon,z,za,zambia,zdnet,zealand,zen,zero,zimbabwe,zinc,zip,zoloft,zone,zones,zoning,zoo,zoom");

        String getStringChangeMerchantCategory8 = frameworkWords.getStringChangeMerchantCategory8();
        String getStringChangeMerchantCategory9 = frameworkWords.getStringChangeMerchantCategory9();

        //String dictionary = ",LATA MEDICAL RESEARCH FOUNDATION,NIC HONESTLY CRAFTED ICE CREAMS,PATANJALI NUTRELA ORGANIC OMEGA,DR. AGARWALS EYE HOSPITAL,UNITED COLORS OF BENETTON,FORTUNE CHAKKI FRESH ATTA,DEEPAK MEMORIAL HOSPITAL,SUNFEAST YIPPEE NOODLES,RELIANCE INFRASTRUCTURE,BROOKE BOND TAJ MAHAL,RELIANCE SMART BAZAAR,BROOKE BOND RED LABEL,MARUTI SUZUKI WAGON R,ADITYA BIRLA SUN LIFE,TOYOTA INNOVA HYCROSS,CENTRAL BANK OF INDIA,SGB-SMIT TRANSFORMERS,AVIVA LIFE INSURANCE,PATANJALI DANT KANTI,PATANJALI KESH KANTI,ROYAL ENFIELD BULLET,PUNJAB NATIONAL BANK,INDIAN OVERSEAS BANK,MARUTI SUZUKI ERTIGA,ARAVIND LABORATORIES,STATE BANK OF INDIA,MARUTI SUZUKI SWIFT,MAHINDRA & MAHINDRA,KOTAK MAHINDRA BANK,HINDUSTAN PETROLEUM,RASHTRIYA CHEMICALS,BANK OF MAHARASHTRA,CADBURY DAIRY MILK,RAMCO CONSTRUCTION,METRO CASH & CARRY,HINDUSTAN UNILEVER,THE TIMES OF INDIA,TRENDZ BY MAFATLAL,SINGAPORE AIRLINES,SHAPOORJI PALLONJI,AMERICAN TOURISTER,OYO HOTELS & HOMES,MICROSOFT SURFACE,BAJAJ ELECTRICALS,SURUCHI CHANACHUR,BRITANNIA GOODDAY,BROOKE BOND TAZZA,BRITANNIA BOURBON,AASHIRVAAD SVASTI,LALITHA JEWELLERY,NAVRATNA COOL OIL,HBL POWER SYSTEMS,FORTIS HEALTHCARE,YEWALE AMRUTTULYA,BILLY BOOT POLISH,CADBURY CHOCLAIRS,JOHNSON & JOHNSON,AMERICAN EXPRESS,THE CAPITAL MALL,HEAD & SHOULDERS,RELIANCE JIOMART,RELIANCE DIGITAL,KALYAN JEWELLERS,APOLLO HOSPITALS,ULTRATECH CEMENT,SUNDARAM FINANCE,MALABAR DIAMONDS,VIMAL PAN MASALA,HINDUSTAN MOTORS,BHARAT PETROLEUM,VICCO VAJRADANTI,ICICI PRUDENTIAL,MAHINDRA SCORPIO,HEWLETT PACkARD,MUTHOOT FINANCE,RELIANCE TRENDS,CYCLE AGARBATTI,TOYOTA FORTUNER,HERO HONDA HUNK,BARBEQUE NATION,INDIGO AIRLINES,SHRIRAM FINANCE,CAFÉ COFFEE DAY,ZIVA COLLECTION,FALCON COURIERS,SUZUKI HAYABUSA,BRITANNIA TIGER,GODREJ INTERIO,BANK OF BARODA,HONDA CB SHINE,ARUN ICECREAMS,CADBURY 5 STAR,FLORANCE FLORA,COLGATE CIBACA,GOWARDHAN GHEE,SURUCHI SPICES,RELIANCE FRESH,CHERRY BLOSSOM,FLYING MACHINE,RATH VANASPATI,DOUBLE DIAMOND,MANKIND PHARMA,RAAGA BOUTIQUE,TTK HEALTHCARE,PATEK PHILIPPE,BRITISH PAINTS,DATSUN REDI-GO,LOOKS GARMENTS,DHANLAXMI BANK,BHARAT BIOTECH,LOUIS PHILIPPE,MARUTI SUZUKI,APPLE MacBOOK,HERO MOTOCORP,ROYAL ENFIELD,AMBUJA CEMENT,NESTLE KITKAT,BALAJI WAFERS,MYSORE SANDAL,SUNRISE FOODS,PETER ENGLAND,BERGER PAINTS,BANK OF INDIA,KWALITY WALLS,ASHOK LEYLAND,SREE LEATHERS,SUHANA MASALA,BAJAJ FINANCE,RAJESH SPICES,HYUNDAI CRETA,TOYOTA INNOVA,LOUIS VUITTON,TOP 10 MOBILE,ONE PLUS NORD,CLEAN & CLEAR,BAJAJ ALLIANZ,ROOP BOUTIQUE,DIAMOND SNACS,HYUNDAI VERNA,SUGAR & SPICE,FORD ECOSPORT,BAJAJ CAPITAL,BOMBAY DYEING,INDIA CEMENTS,CAMLIN PAINTS,RELIANCE JIO,GKB OPTICALS,HONDA ACTIVA,ASIAN PAINTS,TTK PRESTIGE,NESTLE MAGGI,BAJAJ PULSAR,APPLE iWATCH,WILLIAM PENN,MANGO FROOTI,SHREE MARUTI,LIJJAT PAPAD,APOLLO TYRES,DABUR ALMOND,BIRLA CEMENT,MOUNT LITERA,SAINT GOBAIN,CADBURY GEMS,ROYAL MIRAGE,NESTLE MUNCH,HUSH PUPPIES,JOHN PLAYERS,MOTHER DAIRY,PARLE MELODY,BLACK BEAUTY,SHREE CEMENT,CALVIN KLEIN,DABUR VATIKA,AMAZON PRIME,DARK FANTASY,PP JEWELLERS,GLOBE STEELS,POOJA MASALA,JINDAL PIPES,RASAYAN VATI,USHA SHRIRAM,TATA PRAVESH,RUMMY CIRCLE,STEVE MADDEN,TATA SHAKTEE,ROYAL SPICES,MAX HOSPITAL,CADBURY FUSE,ASHOK MASALE,BANDHAN BANK,APPLEiPHONE,DABUR HONEY,TATA MOTORS,ALLEN SOLLY,BURGER KING,ADANI POWER,ROLLS ROYCE,SOCIETY TEA,INDIAN BANK,CLINIC PLUS,STAR BAZAAR,PARK AVENUE,SHAKTI BHOG,KOLTE PATIL,HYUNDAI i20,VIJAY SALES,PC JEWELLER,GLOBAL DESI,TVS JUPITER,CANARA BANK,STAR HEALTH,BROOKE BOND,BIKANERVALA,PHILIPS LED,GINI & JONY,COTTON KING,HYUNDAI 110,TATA INDICA,MINU SAREES,PARLE MARIE,LAMBORGHINI,BAKE FOR ME,PARLE KISMI,METRO DAIRY,GODREJ NO.1,JOHN MILLER,BIRLA TYRES,A TO Z GOLD,TATA TISCON,HUDA BEAUTY,SAGAR RATNA,JET AIRWAYS,RAJNIGANDHA,INDIA TODAY,FRESHTOHOME,WAGH BAKRI,ICICI BANK,MAYBELLINE,ACC CEMENT,HALDIRAM'S,SENCO GOLD,GOOGLE PAY,TVS SCOOTY,TATA STEEL,GOKUL MILK,DABUR REAL,MCDONALD'S,CHAI POINT,SURF EXCEL,AASHIRVAAD,VOLKSWAGEN,INDIAN OIL,INDANE GAS,SUN PHARMA,JUST HERBS,BIG BAZAAR,VAN HEUSEN,WILD STONE,ROYAL STAG,KINGFISHER,PANTALOONS,APNA BAZAR,ARISTOCRAT,ZANDU BALM,INDIA GATE,AMRUTANJAN,NOVA CABLE,ITC HOTELS,BHARAT GAS,BIG BASKET,FIRE-BOLTT,TOP SPICES,MASTERCARD,COFFY BITE,HONDA CITY,MITSUBISHI,JAIN PIPES,TRUE POWER,BEEZ HONEY,RAM BANDHU,MANGO BITE,MOSER BAER,REDIFF.COM,VERKA MILK,AXIS BANK,BRITANNIA,WHIRLPOOL,PANASONIC,DISCOVERY,INSTAGRAM,ZEE LEARN,HDFC BANK,PATANJALI,BLUE DART,A O SMITH,BLUE STAR,STARBUCKS,PARACHUTE,SLEEPWELL,SONY OLED,IDBI BANK,MAMAEARTH,CAVINKARE,CLASSMATE,AIR INDIA,TATA AGNI,SENSODYNE,MICROSOFT,PEPSODENT,SIYARAM'S,AQUAGUARD,TROPICANA,BISK FARM,LIFESTYLE,MAHANANDA,CREAMBELL,FAB INDIA,HEMPUSHPA,MIO AMORE,PRIYAGOLD,FRONTIERS,MX PLAYER,SIGNATURE,B NATURAL,LEXI PENS,TATA NANO,ANNAPURNA,PARRYWARE,DABUR RED,TVS TYRES,WHITETONE,ACCENTURE,SONY VAIO,HDFC ERGO,SYSKA LED,SUNFLOWER,CAMBRIDGE,JUMBOKING,VERO MODA,BOURNVITA,COLORPLUS,COGNIZANT,FACEBOOK,FLIPKART,LENSKART,CITIBANK,DURACELL,COCA-COC,VIDEOCON,ONE PLUS,MERCEDES,HIMALAYA,DOMINO'S,GILLETTE,ZEE NEWS,WOODLAND,CLOSE UP,DCB BANK,BOROLINE,SYMPHONY,STAYFREE,VASELINE,NILKAMAL,YES BANK,LIFEBUOY,MICROMAX,BIOTIQUE,MOTOROLA,HORLICKS,RAJDHANI,ORIFLAME,KAWASAKI,LUMINOUS,GLENMARK,SUNFEAST,WHATSAPP,BBC NEWS,OLD MONK,RED BULL,REYNOLDS,THUMS UP,SONY LIV,ONESCORE,WRANGLER,ABP NEWS,CHOLA MS,CROMPTON,HINDALCO,ATOMBERG,RAJSHREE,RBL BANK,PROVOGUE,HINDWARE,DUROFLEX,MILKFOOD,MONGINIS,MAJITHIA,BURBERRY,COLORBAR,TELEGRAM,HARRISON,NATURALS,HERCULES,AQUAFINA,TATA AIG,SNAPDEAL,LITTLE'S,LINKEDIN,KOHINOOR,MOVIEMAX,SHALIMAR,SAMSUNG,NESCAFE,HYUNDAI,TANISHQ,PHONEPE,COLGATE,NATARAJ,CADBURY,TATATLA,MEDIMIX,CITIZEN,LIVPURE,PARLE G,PHILIPS,L'OREAL,ALLIANZ,RAYMOND,WHISPER,RAYMOND,EVEREST,SET WET,G-SHOCK,SUNSILK,PARAGON,YARDLEY,INFOSYS,FERRARI,GARNIER,AAJ TAK,PAMPERS,BISLERI,FORTUNE,SAFFOLA,NANDINI,HAWKINS,COMPLAN,FEVICOL,BUGATTI,BRUSTRO,SANTOOR,CHAMBOR,RENAULT,CARRIER,TOSHIBA,YOUTUBE,KURKURE,VESTIGE,BADSHAH,MYGLAMM,AIRWICK,HAVELLS,VISTARA,ROTOMAC,TWITTER,NEWS 24,FINOLEX,HAJMOLA,KHAITAN,GENERAL,GOLDIEE,NETFLIX,JK TYRE,GAYATRI,HITACHI,NOTHING,ALIBABA,TOOFAAN,CASTROL,CINTHOL,SUNDROP,US POLO,LAKHANI,NEROLAC,KARBONN,NAVNEET,HITKARY,LIBERTY,FREEDOM,SKYBAGS,DISH TV,CHING'S,VADILAL,CORELLE,SUPREME,DORITOS,POSTMAN,THOMSON,XIAOMI,AMAZON,LENOVO,ADIDAS,TOYOTA,D MART,AIRTEL,GOOGLE,MEESHO,REALME,DETTOL,YAMAHA,ASTRAL,GODREJ,VOLTAS,POND'S,NISSAN,SINGER,PUREIT,JAGUAR,KIDZEE,DAIKIN,LEVI'S,MYNTRA,SONATA,REEBOK,STREAX,APSARA,ZOMATO,SWIGGY,DISNEY,iGUARD,JOCKEY,FOSSIL,MONACO,SPRITE,BAPUJI,RAMRAJ,NESTLE,ORIENT,REXONA,REVLON,DENVER,LIPTON,SANSUI,KISSAN,CAMBIO,BESTON,COOKME,DATSUN,TETLEY,MADAME,JAQUAR,CAMLIN,RAYBAN,HP GAS,ANCHOR,DUNLOP,DAAWAT,MONTEX,VAT 69,RAMDEV,PORTER,TISSOT,GALAXY,MODERN,AJANTA,COSMIX,PRINCE,DURIAN,JAIPAN,KILLER,MILTON,ORAL-B,PAYPAL,PARKER,KHADIM,AFCONS,BYJU'S,TURTLE,HAVMOR,DUCATI,ZENITH,MERLIN,AMARON,KAMATS,HUBLOT,NAUKRI,AZORTE,COMPAQ,TITAN,NIVEA,HONDA,INTEL,LAKME,ONIDA,pTRON,REDMI,AACHI,NIPPO,SPARX,OKAYA,BAJAJ,NOKIA,SUGAR,CANON,ATLAS,BOOST,LOTUS,PAYTM,ROLEX,PEPSI,PEARS,NIKON,SYSKA,HELIX,HAIER,GUCCI,NYKAA,SKODA,NYKAA,CASIO,DABUR,PHOOL,MAAZA,LIBAS,ARIEL,ZUDIO,SUNTV,PARLE,CROMA,LIMCA,WIPRO,CATCH,CIPLA,FANTA,WHEEL,NIRMA,HANES,EXIDE,VICCO,BOSCH,ARROW,TIMEX,PRADA,GUESS,ORPAT,FLAIR,PRIYA,SLICE,ADOBE,CROSS,IODEX,CELLO,GHARI,VOLTA,DELTA,VIMAL,NOISE,NYCIL,SKYPE,APPLE,TOTAL,POWER,SURYA,SHREE,INTAS,KAYAM,RHEEM,KNORR,UDAAN,LIRIL,OMAXE,AMWAY,MARGO,OMEGA,HENKO,JASON,BINGO,ZANDU,VOLVO,DAMRO,PILOT,PMARK,LUXOR,MUFTI,FABER,DENIM,MAGIC,RINSO,MOKSH,GMMCO,KORES,NISHA,STING,DELL,BATA,FOGG,AMUL,TATA,PUMA,SONY,NIKE,OPPO,AUDI,boAt,VIVO,DOVE,JEEP,CEAT,RADO,KENT,USHA,ZEE5,POCO,HSBC,FORD,IKEA,OREO,ACER,SOFY,PARX,BIBA,LAYS,ASUS,DTDC,SITI,AJIO,UBER,ZIVA,CHIK,PEPE,CESC,AVON,TIDE,HERO,DOMS,LAVA,FILA,SULA,PURO,BSNL,NEXA,ONGC,VISA,BHIM,ONLY,HDFC,BELL,MERO,BOSS,AKAI,SOCH,DUTA,BOSE,NOVA,AYUR,GAIA,AMCO,WIBS,TREO,VEET,ENVY,Mar5,OLAY,CATL,MSEB,BHEL,BMW,LIC,TVS,BRU,KFC,MRF,MDH,LUX,AMD,SUN,AXE,RIN,MAX,OWO,H&M,MTR,HCL,IFB,IBM,KIA,VIP,LYF,TBZ,DHL,MAC,7UP,HMT,BMW,TOY,ITC,WOW,VSL,OLx,DLF,JBL,TCS,VIM,PVR,KTM,APC,GAP,MTV,BSA,RBI,LML,LG,VI,GE,";
        String dictionary = ""+getStringChangeMerchantCategory8;
        //String dictionaryCategory = ",Healthcare,Food,Wellness,Healthcare,Shopping,Food,Healthcare,Food,,Food,Shopping,Food,Transportation,Investment,Transportation,,,Insurance,Wellness,Wellness,Transportation,,,Transportation,,,Transportation,Transportation,,Transportation,,,Food,,Shopping,Shopping,,Shopping,Transportation,,Shopping,Hotel,Shopping,Shopping,Food,Food,Food,Food,,Shopping,Wellness,,Healthcare,Food,,Food,Wellness,,,Wellness,Shopping,Shopping,Shopping,Healthcare,,,Shopping,Food,Transportation,,Wellness,,Transportation,Shopping,,Shopping,Essential Service,Transportation,Transportation,Food,Transportation,,Food,Shopping,Essential Service,Transportation,Food,Shopping,,Transportation,Food,Food,Shopping,Wellness,Food,Food,Food,Shopping,Shopping,Food,,Wellness,Shopping,Healthcare,Shopping,,Transportation,Shopping,,,Shopping,Transportation,,Transportation,Transportation,,Food,Food,Wellness,Food,Shopping,Shopping,,Food,Transportation,,Food,,Food,Transportation,Transportation,Shopping,,Shopping,Wellness,,,Food,Transportation,Food,Transportation,,Shopping,,,,Healthcare,Transportation,,Shopping,Food,Transportation,Shopping,Shopping,Food,,Food,Transportation,Wellness,,,Shopping,Food,Wellness,Food,Shopping,Shopping,Food,Food,,,Shopping,Wellness,Shopping,Food,Shopping,,Food,,Food,,,Entertainment,,Shopping,Food,Healthcare,Food,Food,,,Food,Transportation,Shoppig,Food,Utility Bill,Transportation,Food,,Wellness,Food,Shopping,Food,,Transportation,Shopping,Shopping,Shopping,Transportation,,Healthcare,Food,Food,Shopping,Shopping,Shopping,Transportation,Transportation,Shopping,Food,Transportation,,Food,Food,,Shopping,Transportation,,,Wellness,Food,Transportation,Food,,Food,Food,,Shopping,,Food,Shopping,,Transportation,,Food,Wellness,Food,Food,Wellness,Food,Transportation,Transportation,Food,Healthcare,Wellness,,Shopping,Wellness,Food,Food,Shopping,Shopping,Shopping,Wellness,Food,Wellness,,Hotel,Food,Food,Shopping,Food,,Food,Transportation,,,,Food,Food,Food,Shopping,,Food,,Food,Shopping,Shoppig,Essential Service,,,,Healthcare,Essential Service,Shopping,Shopping,Food,Wellness,Wellness,Shopping,,Wellness,Wellness,Shopping,Transportation,Food,Wellness,Shopping,Wellness,Shopping,Wellness,Food,Food,Shopping,Food,Food,Shopping,Wellness,,Food,,Entertainment,,,Shopping,Transportation,Food,Shopping,Wellness,Transportation,,,Shopping,Insurance,Shopping,,,Food,SHopping,Food,,,,Shopping,Shopping,,Essential Service,,Utility Bill,Shopping,Transportation,,Food,Wellness,Entertainment,Shopping,Wellness,,Wellness,,Wellness,Wellness,Shopping,,Wellness,Shopping,Wellness,Shopping,Food,,Shopping,,Shopping,Healthcare,Food,,Entertainment,Food,Food,Shopping,Food,Entertainment,,Shopping,Entertainment,,Shopping,,Shopping,,,Shopping,Shopping,,Food,Food,,Shopping,Wellness,,,Food,,,Insurance,Shopping,,,,Entertainment,,Shopping,Food,Transportation,Shopping,,Wellness,Shopping,Food,,Wellness,,Shopping,Food,Shopping,Wellness,Insurance,Shopping,Wellness,Shopping,Food,Wellness,Shopping,Wellness,Shopping,Wellness,,Transportation,Wellness,Entertainment,Wellness,Food,,Food,,Shopping,Food,Shopping,Transportation,,Wellness,,Transportation,Shopping,Shopping,Entertainment,Food,,Food,Wellness,,Shopping,Transportation,Shopping,,Entertainment,,Food,,,Food,Entertainment,Transportation,,Shopping,Shopping,,,Transportation,Wellness,,Shopping,Shopping,,Shopping,,,,,Shopping,Utility Bill,Food,Food,,,Food,,,Shopping,Shopping,Shopping,Shopping,Transportation,Food,Utility Bill,Professional,Shopping,Shopping,Wellness,Transportation,,,Shopping,Wellness,Transportation,Shopping,Healthcare,,,Shopping,Shopping,Shopping,Shopping,Shopping,Wellness,Shopping,Food,Food,Entertainment,,Shopping,Shopping,Food,Food,,,Food,,Wellness,Shopping,,Food,Shopping,Food,,,,Transportation,Food,,Shopping,Shopping,Shopping,Food,,Transportation,Food,,,,Essential Service,Shopping,,,,,,Shopping,,Shopping,Shopping,Wellness,,Shopping,Shopping,,Education,,Food,Transportation,,,Transportation,,Shopping,,Shopping,,Shopping,Shopping,Transportation,Shopping,Wellness,Shoppig,,Shopping,,Shopping,Shopping,,,Shopping,,Shopping,,Food,,,Shopping,Food,Wellness,Shopping,Shopping,,,Shopping,Shopping,Transportation,Shopping,Shopping,Wellness,,Food,Shopping,Wellness,Shopping,Entertainment,Food,Shopping,Food,,,Healthcare,Food,,,,Transportation,Wellness,Shopping,Shopping,Shopping,Shopping,,Shopping,,,,Professional Service,,Wellness,Shopping,,,,,Shopping,Wellness,Professional Service,Shopping,,,,,,,,Food,,Wellness,,Shopping,Wellness,,,,,Wellness,Transportation,,,,,Shopping,Shopping,Shopping,,,,,,,,Shopping,Shopping,Shopping,Food,,Shopping,Shopping,Shopping,Shopping,Transportation,Shopping,Shopping,Wellness,Transportation,Transportation,Shopping,Shopping,Shopping,Entertainment,Shopping,,Transportation,Shopping,Food,Shopping,,Shopping,Shopping,Food,Shopping,Essential Service,,Shopping,,Shopping,Wellness,Shopping,,,Wellness,,,Shopping,Shopping,Food,,Utility Bill,Transportation,,,,Shopping,,,,,Shopping,Shopping,,Shopping,,Wellness,Shopping,Shopping,Food,Shopping,Wellness,Shopping,,Wellness,, Utility Bill,,Transportation,Insurance,Transportation,Food,Food,Transportation,Food,Wellness,Shopping,,Wellness,Wellness,,,Shopping,Food,,Shopping,,Transportation,,,Shopping, Essential Service,,Food,Shopping,Transportation,Shopping,,,,Shopping,,Shoppinh,,Shopping,Entertainment,Transportation,,Shopping,Entertainment,,,,Shopping,Utility Bill,Shopping,";
        String dictionaryCategory = ""+getStringChangeMerchantCategory9;

        String[] splitMerchantName = where_at.split("\\W");


        Matcher matcherDeleteLast3 = Pattern.compile("(?i)(\\W)([a-zA-Z]{1,3}(\\W|)$)").matcher(where_at);

        if (matcherDeleteLast3.find()){

            String group2 = matcherDeleteLast3.group(2);
            if (!group2.toLowerCase().contains("qr")) {
                where_at = where_at.replaceAll(group2, "");
            }
        }


        if (splitMerchantName.length == 1){

            //if (dictionary.contains(","+splitMerchantName[0]+",")) {

            String[] array = dictionary.split(",");

            for (int i =0; i<array.length; i++){

                String brandName = array[i];

                if (brandName.isEmpty()){
                    continue;
                }


                String[] howManyWords = brandName.split("\\W");

                String lastWord = "~~";
                String lastWordToReplace = "~~";
                String createDynamicRegex = "^(?i)";
                for (String word : howManyWords){
                    createDynamicRegex = createDynamicRegex + "(\\W+|)" + word;

                    if (howManyWords.length > 1) {
                        lastWord = word;
                        lastWordToReplace = word;
                        if (lastWord.length() > 2) {
                            lastWordToReplace = word.substring(0, 2);
                        }
                    }else {
                        if (word.length() > 2) {
                            //createDynamicRegex = createDynamicRegex + "$";
                        }else {
                            createDynamicRegex = createDynamicRegex + "$";
                        }

                    }
                }
                //createDynamicRegex = createDynamicRegex +"";
                createDynamicRegex = createDynamicRegex.replace(lastWord,lastWordToReplace);

                Matcher find = Pattern.compile(createDynamicRegex).matcher(where_at);
                if (find.find()){

                    String[] arrayMerchantC = dictionaryCategory.split(",");
                    merchantCategory = arrayMerchantC[i];


                    if (merchantCategory.isEmpty()){

                        merchantCategory = stringChangeMerchantCategory[12];


                    }

                    //Log.d("AAAVVVV", "3 --- " + where_at +" -- "+merchantCategory+" -- "+createDynamicRegex);

                    break;
                }


                    /*if (brandName.toLowerCase().contains(where_at.toLowerCase())){

                        String[] arrayMerchantC = dictionaryCategory.split(",");
                        merchantCategory = arrayMerchantC[i];


                        if (merchantCategory.isEmpty()){

                            merchantCategory = "Brand From List2";


                        }

                        break;
                    }*/


                // }

            }

        }else {


            //if (dictionary.toUpperCase().contains(","+where_at.toUpperCase())) {

            String[] array = dictionary.split(",");

            for (int i =0; i<array.length; i++){

                String brandName = array[i];

                if (brandName.isEmpty()){
                    continue;
                }

                String[] howManyWords = brandName.split("\\W");

                String lastWord = "~~";
                String lastWordToReplace = "~~";
                String createDynamicRegex = "^(?i)";
                for (String word : howManyWords){
                    createDynamicRegex = createDynamicRegex + "(\\W+|)" + word;

                    if (howManyWords.length > 1) {
                        lastWord = word;
                        lastWordToReplace = word;
                        if (lastWord.length() > 2) {
                            lastWordToReplace = word.substring(0, 2);
                        }
                    }
                    else {
                        if (word.length() > 2) {
                            //createDynamicRegex = createDynamicRegex + "$";
                        }else {
                            createDynamicRegex = createDynamicRegex + "$";
                        }

                    }
                }
                //createDynamicRegex = createDynamicRegex +"";
                createDynamicRegex = createDynamicRegex.replace(lastWord,lastWordToReplace);

                Matcher find = Pattern.compile(createDynamicRegex).matcher(where_at);
                if (find.find()){

                    String[] arrayMerchantC = dictionaryCategory.split(",");
                    merchantCategory = arrayMerchantC[i];

                    if (merchantCategory.isEmpty()){

                        merchantCategory = stringChangeMerchantCategory[12];


                    }

                    //Log.d("AAAVVVV", "4 --- " + where_at +" -- "+merchantCategory+" -- "+createDynamicRegex);
                    break;

                }

                    /*if (brandName.toLowerCase().contains(where_at.toLowerCase())){

                        String[] arrayMerchantC = dictionaryCategory.split(",");
                        merchantCategory = arrayMerchantC[i];

                        break;
                    }*/


                //}

            }

        }

        return merchantCategory;
    }





}

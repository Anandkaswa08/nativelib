package com.createlibrary.nativelib;

import android.content.Context;
import android.content.SharedPreferences;

public class FrameworkWords {

    Context context;
    SharedPreferences mySharedPassbook;

    public FrameworkWords(Context mAppContext){

        context = mAppContext;
        mySharedPassbook = context.getSharedPreferences("PSSBNK", Context.MODE_PRIVATE);

    }

    public String[] extra10(){

        String extra = mySharedPassbook.getString("extra10", "~");
        return extra.split(",");

    }
    public String[] allCase12(){

        String allCase = mySharedPassbook.getString("allcase12", "~");
        return allCase.split(",");

    }
    public String[] newCase13(){

        String newCase = mySharedPassbook.getString("newcase13", "~");
        return  newCase.split(",");

    }
    public String[] case14(){

        String CASE14 = mySharedPassbook.getString("case14", "~");
        return CASE14.split(",");

    }
    public String[] CASE15(){

        String case15 = mySharedPassbook.getString("case15", "~");
        return case15.split(",");

    }
    public String[] case16(){

        String CASE16 = mySharedPassbook.getString("case16", "~");
        return CASE16.split(",");

    }
    public String[] newCase18(){

        String case18 = mySharedPassbook.getString("case18", "~");
        return case18.split(",");

    }
    public String[] case19(){
        String CASE19 = mySharedPassbook.getString("case19", "~");
        return CASE19.split(",");

    }

    public String[] case20(){
        String CASE20 = mySharedPassbook.getString("case20", "~");
        return CASE20.split(",");

    }
    public String[] case21(){

        String CASE21 = mySharedPassbook.getString("case21", "~");
        return CASE21.split(",");

    }

    public String VEHREG11(){

        return mySharedPassbook.getString("regevh11", "~");

    }
    public String offCase14(){

        return mySharedPassbook.getString("offcase14", "~");

    }

    public String[] ENTRY(){

        String entryForAccountDetection = mySharedPassbook.getString("entrycrd1", "~");
        return entryForAccountDetection.split(",");
    }
    public String[] EntryForAlertDetection(){

        String entryForAlertDetection = mySharedPassbook.getString("altentt1", "~");
        return entryForAlertDetection.split(",");
    }
    public String[] sendersToAvoid(){
        String sender = mySharedPassbook.getString("senders", "~");
        return sender.split(",");
    }
    public String[] sendersToAvoidChangedName(){
        String sender = mySharedPassbook.getString("changeSenderAttachment", "~");
        return sender.split(",");
    }

    public String[] account_1(){
        String acc1 = mySharedPassbook.getString("acc1", "~");
        return acc1.split(",");
    }
    public String[] card_2(){
        String card2 = mySharedPassbook.getString("crd2", "~");
        return card2.split(",");
    }
    public String[] balAmount3(){
        String balAmount=mySharedPassbook.getString("bamt3","~");
        return balAmount.split(",");
    }
    public String[] wat4(){
        String wat = mySharedPassbook.getString("wat4", "~");
        return wat.split(",");
    }
    public String getStringForUpiId(){
        String getStringForUpiId = mySharedPassbook.getString("getStringForUpiId", "~");
        return getStringForUpiId;
    }
    public String[] getStringChangeMerchant(){
        String getStringChangeMerchant = mySharedPassbook.getString("getStringChangeMerchant", "~");
        return getStringChangeMerchant.split(",");
    }
    public String[] getStringChangeMerchantCategory(){
        String getStringChangeMerchant = mySharedPassbook.getString("getStringChangeMerchantCategory", "~");
        return getStringChangeMerchant.split(",");
    }
    public String getStringChangeMerchantCategory1(){
        String getStringChangeMerchant = mySharedPassbook.getString("getStringChangeMerchantCategory1", "~");
        return getStringChangeMerchant;
    }
    public String getStringChangeMerchantCategory2(){
        String getStringChangeMerchant = mySharedPassbook.getString("getStringChangeMerchantCategory2", "~");
        return getStringChangeMerchant;
    }

    public String[] getStringChangeMerchantCategory3(){
        String getStringChangeMerchant = mySharedPassbook.getString("getStringChangeMerchantCategory3", "~");
        return getStringChangeMerchant.split(",");
    }

    public String getStringChangeMerchantCategory4(){
        String getStringChangeMerchant = mySharedPassbook.getString("getStringChangeMerchantCategory4", "~");
        return getStringChangeMerchant;
    }

    public String getStringChangeMerchantCategory5(){
        String getStringChangeMerchant = mySharedPassbook.getString("getStringChangeMerchantCategory5", "~");
        return getStringChangeMerchant;
    }

    public String getStringChangeMerchantCategory6(){
        String getStringChangeMerchant = mySharedPassbook.getString("getStringChangeMerchantCategory6", "~");
        return getStringChangeMerchant;
    }

    public String getStringChangeMerchantCategory7(){
        String getStringChangeMerchant = mySharedPassbook.getString("getStringChangeMerchantCategory7", "~");
        return getStringChangeMerchant;
    }

    public String getStringChangeMerchantCategory8(){
        String getStringChangeMerchant = mySharedPassbook.getString("getStringChangeMerchantCategory8", "~");
        return getStringChangeMerchant;
    }

    public String getStringChangeMerchantCategory9(){
        String getStringChangeMerchant = mySharedPassbook.getString("getStringChangeMerchantCategory9", "~");
        return getStringChangeMerchant;
    }

    public String getStringChangeMerchantCategoryFood(){
        String getStringChangeMerchant = mySharedPassbook.getString("getStringChangeMerchantCategoryFood", "~");
        return getStringChangeMerchant;
    }

    public String getStringChangeMerchantCategoryShopping(){
        String getStringChangeMerchant = mySharedPassbook.getString("getStringChangeMerchantCategoryShopping", "~");
        return getStringChangeMerchant;
    }

    public String getStringChangeMerchantCategoryTravel(){
        String getStringChangeMerchant = mySharedPassbook.getString("getStringChangeMerchantCategoryTravel", "~");
        return getStringChangeMerchant;
    }

    public String getStringChangeMerchantCategoryInvestment(){
        String getStringChangeMerchant = mySharedPassbook.getString("getStringChangeMerchantCategoryInvestment", "~");
        return getStringChangeMerchant;
    }

    public String getStringChangeMerchantCategoryHospital(){
        String getStringChangeMerchant = mySharedPassbook.getString("getStringChangeMerchantCategoryHospital", "~");
        return getStringChangeMerchant;
    }

    public String getStringChangeMerchantCategoryTransportation(){
        String getStringChangeMerchant = mySharedPassbook.getString("getStringChangeMerchantCategoryTransportation", "~");
        return getStringChangeMerchant;
    }

    public String getStringChangeMerchantCategoryTravelHotel(){
        String getStringChangeMerchant = mySharedPassbook.getString("getStringChangeMerchantCategoryTravelHotel", "~");
        return getStringChangeMerchant;
    }

    public String getStringChangeMerchantCategoryEducation(){
        String getStringChangeMerchant = mySharedPassbook.getString("getStringChangeMerchantCategoryEducation", "~");
        return getStringChangeMerchant;
    }


    public String getStringChangeMerchantCategoryEntertainment(){
        String getStringChangeMerchant = mySharedPassbook.getString("getStringChangeMerchantCategoryEntertainment", "~");
        return getStringChangeMerchant;
    }

    public String getStringMerchantCategoryEleUtilityBill(){
        String getStringChangeMerchant = mySharedPassbook.getString("getStringMerchantCategoryEleUtilityBill", "~");
        return getStringChangeMerchant;
    }
    public String getStringChangeMerchantCategoryUtilityBill(){
        String getStringChangeMerchant = mySharedPassbook.getString("getStringChangeMerchantCategoryUtilityBill", "~");
        return getStringChangeMerchant;
    }

    public String[] trx5(){
        String trx = mySharedPassbook.getString("ttrexs5", "~");
        return trx.split(",");
    }
    public String[] crd6(){
        String crd = mySharedPassbook.getString("crd6", "~");
        return crd.split(",");
    }
    public String[] dbt7(){
        String dbt = mySharedPassbook.getString("dbt7", "~");
        return dbt.split(",");
    }
    public String[] bncd8(){
        String bounceCases = mySharedPassbook.getString("bncd8", "~");
        return bounceCases.split(",");
    }
    public String[] bldu9(){
        String bounceCases = mySharedPassbook.getString("bldu9", "~");
        return bounceCases.split(",");
    }


    public String[] ALTMVS1(){
        String alertBus = mySharedPassbook.getString("altmv1", "~");
        return alertBus.split(",");
    }
    public String[] ALTBUS1(){
        String alertForMovies = mySharedPassbook.getString("altbus1", "~");
        return alertForMovies.split(",");
    }

    public String[] ALTBLL1(){
        String alertForBills = mySharedPassbook.getString("altbll1", "~");
        return alertForBills.split(",");
    }
    public String[] ALTELCT1(){
        String alertForElectricity = mySharedPassbook.getString("altelct1", "~");
        return alertForElectricity.split(",");
    }
    public String[] ALTINCMTX1(){
        String alertForIncomeTax = mySharedPassbook.getString("altinctx1", "~");
        return alertForIncomeTax.split(",");
    }
    public String[] ALTPPTX1(){
        String alertForPropertyTax = mySharedPassbook.getString("altpptx1", "~");
        return alertForPropertyTax.split(",");
    }
    public String[] ALTPLC1(){
        String alertForPolicy = mySharedPassbook.getString("altplc1", "~");
        return alertForPolicy.split(",");
    }
    public String[] ALTDTH1(){
        String alertForDth = mySharedPassbook.getString("altdth1", "~");
        return alertForDth.split(",");
    }
    public String[] ALTAPDR1(){
        String alertForDrAppointment = mySharedPassbook.getString("altapdr1", "~");
        return alertForDrAppointment.split(",");
    }
    public String[] ALTFTDR1(){
        String alertForTdFdRd = mySharedPassbook.getString("altftdr1", "~");
        return alertForTdFdRd.split(",");
    }
    public String[] ALTCCB1(){
        String alertForCreditCard = mySharedPassbook.getString("altccb1", "~");
        return alertForCreditCard.split(",");
    }

    public String[] ALTTRN1(){
        String alertForTrain = mySharedPassbook.getString("alttrn1", "~");
        return alertForTrain.split(",");
    }
    public String[] ALTNAMES1(){
        String altNAMES = mySharedPassbook.getString("altnames1", "~");
        return altNAMES.split(",");
    }
    public String[] case17_DateFormat(){
        String case17DateFormats = mySharedPassbook.getString("case17_dtfmt", "~");
        return case17DateFormats.split(",");
    }




    public String getStringForDataBaseB(){
        String getStringForDataBaseB = mySharedPassbook.getString("getStringForDataBaseB", "~");
        return getStringForDataBaseB;
    }





}

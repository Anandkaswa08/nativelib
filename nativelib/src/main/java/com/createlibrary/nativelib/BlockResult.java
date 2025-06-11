package com.createlibrary.nativelib;

public class BlockResult {
	
	public int output=-1;
	public int reason=-1;
	public int personal_status=-1;
	public String otpFromMessage="";
	public  String keywordOfOtp;

	public int is_auto_delete=-1;

	public int is_fraud = 0;


	public String full_name_sender="";
	public String FindWhichCase="";

	public String getFindWhichCase() {
		return FindWhichCase;
	}

	public void setFindWhichCase(String full_name_sender) {
		this.FindWhichCase = full_name_sender;
	}

	public String getFull_name_sender() {
		return full_name_sender;
	}

	public void setFull_name_sender(String full_name_sender) {
		this.full_name_sender = full_name_sender;
	}

	public int isIs_fraud() {
		return is_fraud;
	}

	public void setIs_fraud(int is_fraud) {
		this.is_fraud = is_fraud;
	}

	public int getIs_auto_delete() {
		return is_auto_delete;
	}

	public void setIs_auto_delete(int is_auto_delete) {
		this.is_auto_delete = is_auto_delete;
	}
	
	public int getPersonal_status() {
		return personal_status;
	}
	public void setPersonal_status(int personal_status) {
		this.personal_status = personal_status;
	}
	public BlockResult()
	{
		
	}
	public int getOutput() {
		return output;
	}

	public void setOutput(int output) {
		this.output = output;
	}

	public int getReason() {
		return reason;
	}

	public void setReason(int reason) {
		this.reason = reason;
	}


	public String getOtpFromMessage() {
		return otpFromMessage;
	}

	public void setOtpFromMessage(String otpFromMessage) {
		this.otpFromMessage = otpFromMessage;
	}

	public String getKeywordOfOtp() {
		return keywordOfOtp;
	}

	public void setKeywordOfOtp(String keywordOfOtp) {
		this.keywordOfOtp = keywordOfOtp;
	}


	public double getPass_amount() {
		return pass_amount;
	}

	public void setPass_amount(double pass_amount) {
		this.pass_amount = pass_amount;
	}

	public double getPass_avl_amount() {
		return pass_avl_amount;
	}

	public void setPass_avl_amount(double pass_avl_amount) {
		this.pass_avl_amount = pass_avl_amount;
	}

	public String getPass_acc_no() {
		return pass_acc_no;
	}

	public void setPass_acc_no(String pass_acc_no) {
		this.pass_acc_no = pass_acc_no;
	}

	public String getPass_card_no() {
		return pass_card_no;
	}

	public void setPass_card_no(String pass_card_no) {
		this.pass_card_no = pass_card_no;
	}

	public String getPass_status() {
		return pass_status;
	}

	public void setPass_status(String pass_status) {
		this.pass_status = pass_status;
	}

	public String getPass_name() {
		return pass_name;
	}

	public void setPass_name(String pass_name) {
		this.pass_name = pass_name;
	}

	public String getPass_name_for2() {
		return pass_name_for2;
	}

	public void setPass_name_for2(String pass_name_for2) {
		this.pass_name_for2 = pass_name_for2;
	}

	public String getPass_acc_full_name() {
		return pass_acc_full_name;
	}

	public void setPass_acc_full_name(String pass_acc_full_name) {
		this.pass_acc_full_name = pass_acc_full_name;
	}

	public String getPass_acc_type() {
		return pass_acc_type;
	}

	public void setPass_acc_type(String pass_acc_type) {
		this.pass_acc_type = pass_acc_type;
	}

	public String getPass_card_type() {
		return pass_card_type;
	}

	public void setPass_card_type(String pass_card_type) {
		this.pass_card_type = pass_card_type;
	}

	public String getPass_card_full_name() {
		return pass_card_full_name;
	}

	public void setPass_card_full_name(String pass_card_full_name) {
		this.pass_card_full_name = pass_card_full_name;
	}

	double pass_amount=0.0;
	double pass_avl_amount=-1.0;


	double out_standing=-1.0;
	String pass_acc_no="-1";
	String pass_card_no="-1";
	String pass_status="";
	String pass_name="";
	String pass_name_for2="";
	String pass_acc_full_name="";
	String pass_card_full_name="";
	String pass_acc_type="";
	String pass_card_type="";
    public int pass_output=-1;
	String mode_name="";
	String merchantCategory="";
	String dictonaryWords="";
	String upiIDNumber="";

	public String getUpiIDNumber() {
		return upiIDNumber;
	}

	public void setUpiIDNumber(String upiIDNumber) {
		this.upiIDNumber = upiIDNumber;
	}

	public String getDictonaryWords() {
		return dictonaryWords;
	}

	public void setDictonaryWords(String dictonaryWords) {
		this.dictonaryWords = dictonaryWords;
	}

	public String getMerchantCategory() {
		return merchantCategory;
	}

	public void setMerchantCategory(String merchantCategory) {
		this.merchantCategory = merchantCategory;
	}

	public String getLoan_or_other() {
		return loan_or_other;
	}

	public void setLoan_or_other(String loan_or_other) {
		this.loan_or_other = loan_or_other;
	}

	String loan_or_other="";

	public String getMode_name() {
		return mode_name;
	}

	public void setMode_name(String mode_name) {
		this.mode_name = mode_name;
	}

	public int getAmount_int_status() {
        return amount_int_status;
    }

    public void setAmount_int_status(int amount_int_status) {
        this.amount_int_status = amount_int_status;
    }

    int amount_int_status=0;

    public int getPass_output() {
        return pass_output;
    }

    public void setPass_output(int pass_output) {
        this.pass_output = pass_output;
    }


	public double getOut_standing() {
		return out_standing;
	}

	public void setOut_standing(double out_standing) {
		this.out_standing = out_standing;
	}


	//alerts

	public String ALERT_LABLE = "";

	public String CARD_ACCOUNT_NO = "";

	public double DUE_AMOUNT =0.0;

	public long DUE_DATE ;

	public double OS_AMOUNT = 0.0;

	public double MIN_PAID_AMOUNT = 0.0;

	public String MOVIE_NAME = "";

	public String MOVIE_PLACE = "";

	public String BOOKING_ID = "";

	public String SCREEN = "";

	public String SEATS = "";

	public String TRAIN_FLIGHT_NAME_NO = "";

	public String TRAIN_FLIGHT_ROUTE = "";

	public String TRAIN_FLIGHT_DEPART = "";

	public String TRAIN_FLIGHT_FULL_NAME = "";

	public String TRAIN_FLIGHT_PNR_NO = "";

	public String TRAIN_FLIGHT_SEATS = "";

	public String TRAIN_FLIGHT_GATE = "";

	public String TRAIN_FLIGHT_PNR_STAT = "";

	public String TRAIN_FLIGHT_PASSENGER_DETAILS = "";

	public String QR_URL = "";

	public String MOVIE_PICKUPCODE = "";
	public String FLIGHT_COUNT = "";

	public String getFLIGHT_COUNT() {
		return FLIGHT_COUNT;
	}

	public void setFLIGHT_COUNT(String FLIGHT_COUNT) {
		this.FLIGHT_COUNT = FLIGHT_COUNT;
	}

	public String getALERT_LABLE() {
		return ALERT_LABLE;
	}

	public void setALERT_LABLE(String ALERT_LABLE) {
		this.ALERT_LABLE = ALERT_LABLE;
	}

	public String getCARD_ACCOUNT_NO() {
		return CARD_ACCOUNT_NO;
	}

	public void setCARD_ACCOUNT_NO(String CARD_ACCOUNT_NO) {
		this.CARD_ACCOUNT_NO = CARD_ACCOUNT_NO;
	}

	public double getDUE_AMOUNT() {
		return DUE_AMOUNT;
	}

	public void setDUE_AMOUNT(double DUE_AMOUNT) {
		this.DUE_AMOUNT = DUE_AMOUNT;
	}

	public long getDUE_DATE() {
		return DUE_DATE;
	}

	public void setDUE_DATE(long DUE_DATE) {
		this.DUE_DATE = DUE_DATE;
	}

	public double getOS_AMOUNT() {
		return OS_AMOUNT;
	}

	public void setOS_AMOUNT(double OS_AMOUNT) {
		this.OS_AMOUNT = OS_AMOUNT;
	}

	public double getMIN_PAID_AMOUNT() {
		return MIN_PAID_AMOUNT;
	}

	public void setMIN_PAID_AMOUNT(double MIN_PAID_AMOUNT) {
		this.MIN_PAID_AMOUNT = MIN_PAID_AMOUNT;
	}

	public String getMOVIE_NAME() {
		return MOVIE_NAME;
	}

	public void setMOVIE_NAME(String MOVIE_NAME) {
		this.MOVIE_NAME = MOVIE_NAME;
	}

	public String getMOVIE_PLACE() {
		return MOVIE_PLACE;
	}

	public void setMOVIE_PLACE(String MOVIE_PLACE) {
		this.MOVIE_PLACE = MOVIE_PLACE;
	}

	public String getBOOKING_ID() {
		return BOOKING_ID;
	}

	public void setBOOKING_ID(String BOOKING_ID) {
		this.BOOKING_ID = BOOKING_ID;
	}

	public String getSCREEN() {
		return SCREEN;
	}

	public void setSCREEN(String SCREEN) {
		this.SCREEN = SCREEN;
	}

	public String getSEATS() {
		return SEATS;
	}

	public void setSEATS(String SEATS) {
		this.SEATS = SEATS;
	}


	public String getQR_URL() {
		return QR_URL;
	}

	public void setQR_URL(String QR_URL) {
		this.QR_URL = QR_URL;
	}

	public String getMOVIE_PICKUPCODE() {
		return MOVIE_PICKUPCODE;
	}

	public void setMOVIE_PICKUPCODE(String MOVIE_PICKUPCODE) {
		this.MOVIE_PICKUPCODE = MOVIE_PICKUPCODE;
	}

	public String getTRAIN_FLIGHT_NAME_NO() {
		return TRAIN_FLIGHT_NAME_NO;
	}

	public void setTRAIN_FLIGHT_NAME_NO(String TRAIN_FLIGHT_NAME_NO) {
		this.TRAIN_FLIGHT_NAME_NO = TRAIN_FLIGHT_NAME_NO;
	}

	public String getTRAIN_FLIGHT_ROUTE() {
		return TRAIN_FLIGHT_ROUTE;
	}

	public void setTRAIN_FLIGHT_ROUTE(String TRAIN_FLIGHT_ROUTE) {
		this.TRAIN_FLIGHT_ROUTE = TRAIN_FLIGHT_ROUTE;
	}

	public String getTRAIN_FLIGHT_DEPART() {
		return TRAIN_FLIGHT_DEPART;
	}

	public void setTRAIN_FLIGHT_DEPART(String TRAIN_FLIGHT_DEPART) {
		this.TRAIN_FLIGHT_DEPART = TRAIN_FLIGHT_DEPART;
	}

	public String getTRAIN_FLIGHT_FULL_NAME() {
		return TRAIN_FLIGHT_FULL_NAME;
	}

	public void setTRAIN_FLIGHT_FULL_NAME(String TRAIN_FLIGHT_FULL_NAME) {
		this.TRAIN_FLIGHT_FULL_NAME = TRAIN_FLIGHT_FULL_NAME;
	}

	public String getTRAIN_FLIGHT_PNR_NO() {
		return TRAIN_FLIGHT_PNR_NO;
	}

	public void setTRAIN_FLIGHT_PNR_NO(String TRAIN_FLIGHT_PNR_NO) {
		this.TRAIN_FLIGHT_PNR_NO = TRAIN_FLIGHT_PNR_NO;
	}

	public String getTRAIN_FLIGHT_SEATS() {
		return TRAIN_FLIGHT_SEATS;
	}

	public void setTRAIN_FLIGHT_SEATS(String TRAIN_FLIGHT_SEATS) {
		this.TRAIN_FLIGHT_SEATS = TRAIN_FLIGHT_SEATS;
	}

	public String getTRAIN_FLIGHT_GATE() {
		return TRAIN_FLIGHT_GATE;
	}

	public void setTRAIN_FLIGHT_GATE(String TRAIN_FLIGHT_GATE) {
		this.TRAIN_FLIGHT_GATE = TRAIN_FLIGHT_GATE;
	}

	public String getTRAIN_FLIGHT_PNR_STAT() {
		return TRAIN_FLIGHT_PNR_STAT;
	}

	public void setTRAIN_FLIGHT_PNR_STAT(String TRAIN_FLIGHT_PNR_STAT) {
		this.TRAIN_FLIGHT_PNR_STAT = TRAIN_FLIGHT_PNR_STAT;
	}

	public String getTRAIN_FLIGHT_PASSENGER_DETAILS() {
		return TRAIN_FLIGHT_PASSENGER_DETAILS;
	}

	public void setTRAIN_FLIGHT_PASSENGER_DETAILS(String TRAIN_FLIGHT_PASSENGER_DETAILS) {
		this.TRAIN_FLIGHT_PASSENGER_DETAILS = TRAIN_FLIGHT_PASSENGER_DETAILS;
	}

	public long STATEMENT_DATE ;

	public long getSTATEMENT_DATE() {
		return STATEMENT_DATE;
	}

	public void setSTATEMENT_DATE(long STATEMENT_DATE) {
		this.STATEMENT_DATE = STATEMENT_DATE;
	}
}

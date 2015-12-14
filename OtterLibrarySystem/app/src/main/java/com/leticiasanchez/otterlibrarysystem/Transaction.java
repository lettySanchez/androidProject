package com.leticiasanchez.otterlibrarysystem;

/**
 * Created by leticiasanchez on 12/12/15.
 */
/*"id3";
    private static final String KEY_TRANSACTIONTYPE = "transactiontype";
    private static final String KEY_CUSTOMERUSERNAME = "customerusername";
    private static final String KEY_CURRENTDATETIME = "currentdatetime";
    private static final String KEY_PICKUPDATEHOUR = "pickupdatehour";
    private static final String KEY_RETURNDATEHOUR = "returndatehour";
    private static final String KEY_BOOKTITLE = "booktitle";
    private static final String KEY_RESERVATIONNUMBER = "reservationnumber";
    private static final String KEY_TOTALAMOUNT = "totalamount";
    private static final String KEY_TRANSACTIONDATE = "transactiondate"*/
public class Transaction {
    int id;
    String transactiontype, customerusername, currentdatetime, pickupdatehour, returndatehour, booktitle, reservationnumber, totalamount,
    transactiondate;
    public Transaction(){
        this.id = id;
        this.transactiontype = transactiontype;
        this.customerusername = customerusername;
        this.pickupdatehour = pickupdatehour;
        this.returndatehour = returndatehour;
        this.booktitle = booktitle;
        this.reservationnumber = reservationnumber;
        this.totalamount = totalamount;
        this.transactiondate = transactiondate;
    }
    public Transaction(String transactiontype, String customerusername, String currentdatetime, String pickupdatehour, String returndatehour,
                        String booktitle, String reservationnumber, String totalamount, String transactiondate){
        this.transactiontype = transactiontype;
        this.customerusername = customerusername;
        this.currentdatetime = currentdatetime;
        this.pickupdatehour = pickupdatehour;
        this.returndatehour = returndatehour;
        this.booktitle = booktitle;
        this.reservationnumber = reservationnumber;
        this.totalamount = totalamount;
        this.transactiondate = transactiondate;

    }
    public int getId(){
        return id;
    }
    public String getTransactiontype(){
        return transactiontype;
    }
    public String getCustomerusername(){
        return customerusername;
    }
    public String getCurrentdatetime(){
        return currentdatetime;
    }
    public String getPickupdatehour(){
        return pickupdatehour;
    }
    public String getReturndatehour(){
        return returndatehour;
    }
    public String getBooktitle(){
        return booktitle;
    }
    public String getReservationnumber(){
        return reservationnumber;
    }
    public String getTotalamount(){
        return totalamount;
    }
    public String getTransactiondate(){
        return transactiondate;
    }
    public void setId(int i){
        this.id = id;
    }
    public void setTransactiontype(String transactiontype){
        this.transactiontype = transactiontype;
    }
    public void setCustomerusername(String customerusername){
        this.customerusername = customerusername;
    }
    public void setCurrentdatetime(String currentdatetime){
        this.currentdatetime = currentdatetime;
    }
    public void setPickupdatehour(String pickupdatehour){
        this.pickupdatehour = pickupdatehour;
    }
    public void setReturndatehour(String returndatehour){
        this.returndatehour = returndatehour;
    }
    public void setBooktitle(String booktitle){
        this.booktitle = booktitle;
    }
    public void setReservationnumber(String reservationnumber){
        this.reservationnumber = reservationnumber;
    }
    public void setTotalamount(String totalamount){
        this.totalamount = totalamount;
    }
    public void setTransactiondate(String transactiondate){
        this.transactiondate =  transactiondate;
    }
    public String toString(){
        return "Transaction [customerusername=" + customerusername + ", currentdatetime=" + currentdatetime +
                ", pickupdatehour" + pickupdatehour+ ", returndatehour" + returndatehour + ", booktitle" + booktitle +
                ", reservationnumber" + reservationnumber + ", totalamount" + totalamount + ", transactiondate" +
                transactiondate+ "]";
    }

}



















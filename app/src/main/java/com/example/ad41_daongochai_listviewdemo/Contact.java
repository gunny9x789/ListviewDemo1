package com.example.ad41_daongochai_listviewdemo;

public class Contact {
    private String dateGD;
    private String maCCQ;
    private String gtMua;
    private String gttt;
    private String ln;

    public Contact(String dateGD, String maCCQ, String gtMua, String gttt, String ln) {
        this.dateGD = dateGD;
        this.maCCQ = maCCQ;
        this.gtMua = gtMua;
        this.gttt = gttt;
        this.ln = ln;
    }

    public String getDateGD() {
        return dateGD;
    }

    public void setDateGD(String dateGD) {
        this.dateGD = dateGD;
    }

    public String getMaCCQ() {
        return maCCQ;
    }

    public void setMaCCQ(String maCCQ) {
        this.maCCQ = maCCQ;
    }

    public String getGtMua() {
        return gtMua;
    }

    public void setGtMua(String gtMua) {
        this.gtMua = gtMua;
    }

    public String getGttt() {
        return gttt;
    }

    public void setGttt(String gttt) {
        this.gttt = gttt;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }
}

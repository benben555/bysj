package com.example.a19124.bysj.Bean;

import android.support.annotation.NonNull;

public class WenzhangBean {
    private int cihuiliang;
    private int number;
    private String title;
    private String text;

    public WenzhangBean(int cihuiliang, int number,String title, String text) {
        this.cihuiliang = cihuiliang;
        this.number = number;
        this.title = title;
        this.text = text;
    }
    public WenzhangBean(String str){
        String[] params = str.split(";");
        this.cihuiliang = Integer.parseInt(params[0]);
        this.number = Integer.parseInt(params[1]);
        this.title = params[2];
        this.text = params[3];
    }

    public int getCihuiliang() {
        return cihuiliang;
    }

    public void setCihuiliang(int cihuiliang) {
        this.cihuiliang = cihuiliang;
    }

    public int getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String toString() {
        return cihuiliang+";"+number+";"+title+";"+text;
    }
}

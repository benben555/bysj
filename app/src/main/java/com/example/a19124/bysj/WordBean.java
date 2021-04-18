package com.example.a19124.bysj;

import android.support.annotation.NonNull;

public class WordBean {
    private int UID;
    private String word;
    private String msg;
    private String yinbiao;
    private int flag;

    public WordBean(int UID,String word, String msg, String yinbiao, int flag) {
        this.UID = UID;
        this.word = word;
        this.msg = msg;
        this.yinbiao = yinbiao;
        this.flag = flag;
    }
    public WordBean(String str){
        String[] params = str.split(";");
        this.word = params[0];
        this.msg  = params[1];
        this.yinbiao = params[2];
        this.flag = Integer.parseInt(params[4]);
        this.UID = Integer.parseInt(params[3]);
    }
    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getYinbiao() {
        return yinbiao;
    }

    public void setYinbiao(String yinbiao) {
        this.yinbiao = yinbiao;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @NonNull
    @Override
    public String toString() {
        return word+";"+msg+";"+yinbiao+";"+flag+";"+UID;
    }
}

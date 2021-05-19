package com.example.a19124.bysj.Bean;

import com.example.a19124.bysj.Utils.DBConnection;

import java.util.List;

public class UserInfo {
    private static UserInfo INSTANCE = null;
    private String username;
    private int coinOver=100000;
    private int bj;
    private int cihuiliang;
    private String password;
    private String mobile;
    private String email;
    private String sex;

    private UserInfo() {

    }
    public static UserInfo getInstance() {
        if(INSTANCE == null) {
            synchronized (UserInfo.class){
                if(INSTANCE == null) {
                    return INSTANCE = new UserInfo();
                }
            }
        }
        return INSTANCE;
    }

//    public int getcihuiliang(){return cihuiliang;}
//
//    public void setCihuiliang(int cihuiliang) {this.cihuiliang=cihuiliang;}

    public int getbj(){return bj;}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void addcoin(int i){this.coinOver+=i;}

    public void addcihui(){this.cihuiliang++;}

    public int getCoinOver() {
        return coinOver;
    }

    public void setCoinOver(int coinOver) {
        this.coinOver = coinOver;
    }

    public void setCihuiliang(int cihuiliang) {
        this.cihuiliang = cihuiliang;
    }

    public int getCihuiliang() {
        return cihuiliang;
    }

    public boolean makeOrder(String name) {
        int productUID = 0;
        int spend = 0;
        switch (name) {
            case "腾讯会员":productUID = 1;spend = 1000; break;
            case "百度网盘":productUID = 2;spend = 1200;break;
            case "绿钻会员":productUID = 3;spend = 800;break;
            default:productUID =4 ;spend = 10000;
        }
        if(coinOver < spend) { return false; }
        try{
            DBConnection.buy(productUID);
            DBConnection.subCoin(spend);
            coinOver -= spend;
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return true;
    }

    public  UserInfo(String username,String password,int bj,String mobile,String email,int cihuiliang,String sex,int coinOver){
        this.coinOver=coinOver;
        this.password=password;
        this.bj=bj;
        this.mobile=mobile;
        this.email=email;
        this.cihuiliang=cihuiliang;
        this.sex=sex;
        this.coinOver=coinOver;
    }


    public int getBj() {
        return bj;
    }

    public void setBj(int bj) {
        this.bj = bj;
    }

    public String getDatabase() {
        String database = null;
        switch (bj){
            case 3:database = "gaokao";break;
            case 4:database = "siji";break;
            case 6:database = "liuji";break;
            case 8:database = "kaoyan";break;
            default:
        }
        return database;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public UserInfo(String str){
        String[] params = str.split(";");
        this.username = params[0];
        this.password  = params[1];
        this.bj = Integer.parseInt(params[2]);
        this.mobile = params[3];
        this.email= params[4];
        this.cihuiliang = Integer.parseInt(params[5]);
        this.sex= params[6];
        this.coinOver = Integer.parseInt(params[7]);
    }

    public String toString() {
        return username+";"+password+";"+bj+";"+mobile+";"+email+";"+cihuiliang+";"+sex+";"+coinOver;
    }
}

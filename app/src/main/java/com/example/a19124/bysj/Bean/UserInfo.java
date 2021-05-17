package com.example.a19124.bysj.Bean;

import com.example.a19124.bysj.Utils.DBConnection;

import java.util.List;

/**
 * @author : Jason Zhang
 * @date : 2021/01/19
 * version: 2.0
 * Description:
 */
public class UserInfo {
    private static UserInfo INSTANCE = null;
    private String username;
    private int coinOver;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCoinOver() {
        return coinOver;
    }

    public void setCoinOver(int coinOver) {
        this.coinOver = coinOver;
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

}

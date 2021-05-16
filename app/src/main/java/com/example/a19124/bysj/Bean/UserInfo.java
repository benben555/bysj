package com.example.a19124.bysj.Bean;

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

}

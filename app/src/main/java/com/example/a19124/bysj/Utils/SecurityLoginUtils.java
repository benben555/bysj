package com.example.a19124.bysj.Utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.a19124.bysj.Bean.UserInfo;

/**
 * @author : Jason Zhang
 * @date : 2021/01/19
 * version: 2.0
 * Description:
 */
public class SecurityLoginUtils {

    private static SecurityLoginUtils INSTANCE = null;


    private final String STATUS = "STATUS";
    private final String USERNAME = "USERNAME";
    private final String COIN = "COIN";
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @SuppressLint("CommitPrefEdits")
    private SecurityLoginUtils(Context context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        mEditor = mSharedPreferences.edit();
    }
    public static SecurityLoginUtils getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SecurityLoginUtils.class) {
                if (INSTANCE == null) {
                    return INSTANCE = new SecurityLoginUtils(context);
                }
            }
        }
        return INSTANCE;
    }
    public boolean login(String username,String pwd){
        boolean flag = false;
        try {
            flag = DBConnection.checkLogin(username,pwd);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        mEditor.putString(USERNAME,username);
        mEditor.putBoolean(STATUS,flag);
        mEditor.putInt(COIN,UserInfo.getInstance().getCoinOver());
        mEditor.apply();
        return flag;
    }
    public void logout() {
        mEditor.putBoolean(STATUS,false);
        mEditor.apply();
    }
    public boolean getLoginStatus() {
        boolean status = mSharedPreferences.getBoolean(STATUS,false);
        if(status){
            UserInfo.getInstance().setUsername(mSharedPreferences.getString(USERNAME,"null"));
            UserInfo.getInstance().setCoinOver(mSharedPreferences.getInt(COIN,0));
        }
        return status;
    }
}

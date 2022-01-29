package com.example.a19124.bysj.Utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.a19124.bysj.Bean.UserInfo;

public class SecurityLoginUtils {

    private static SecurityLoginUtils INSTANCE = null;
    private final String STATUS = "STATUS";
    private final String USERNAME = "USERNAME";
    private final String COIN = "COIN";
    private final String CIHUILIANG="CIHUILIANG";
    private final String BJ = "BJ";
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
        mEditor.putInt(CIHUILIANG,UserInfo.getInstance().getCihuiliang());
        mEditor.putInt(BJ,UserInfo.getInstance().getBj());
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
            UserInfo.getInstance().setCoinOver(mSharedPreferences.getInt(COIN,100000));
            UserInfo.getInstance().setCihuiliang(mSharedPreferences.getInt(CIHUILIANG,0));
            UserInfo.getInstance().setBj(mSharedPreferences.getInt(BJ,3));
        }
        return status;
    }
}

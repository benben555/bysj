package com.example.a19124.bysj.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * @author : Jason Zhang
 * @date : 2021/01/19
 * version: 2.0
 * Description:
 */
public class SecurityLoginUtils {
    private static final int  NOT_LOGGED = 0;
    private static final int LOGGED = 1;

    private static SecurityLoginUtils INSTANCE = null;

    private final String status = "STATUS";
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

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

        mEditor.putBoolean(status,true);
        return false;
    }
    public void logout() {
        mEditor.putBoolean(status,false);
    }
    public boolean getLoginStatus() {
        return mSharedPreferences.getBoolean(status,false);
    }
}

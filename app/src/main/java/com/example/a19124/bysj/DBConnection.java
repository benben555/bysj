package com.example.a19124.bysj;
import android.content.Context;
import android.util.Log;

import  java.sql.*;
import java.util.Random;

import static java.lang.Math.random;

public class DBConnection {
    private static final String TAG = "mysql11111";
    static Connection conn = null;
    private Context context;
  //  private int cinum=0;
    public static void mymysql() throws InterruptedException {
        final Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {

                while (!Thread.interrupted()) {
                    try {
                        Thread.sleep(100);  // 每隔0.1秒尝试连接
                    } catch (InterruptedException e) {
                        Log.e(TAG, e.toString());
                    }
// 1.加载JDBC驱动
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Log.v(TAG, "加载JDBC驱动成功");
                    } catch (ClassNotFoundException e) {
                        Log.e(TAG, "加载JDBC驱动失败");
                        return;
                    }
                    // 2.设置好IP/端口/数据库名/用户名/密码等必要的连接信息
                    String ip = "10.0.2.2";
                    int port = 3306;
                    String dbName = "bysj";
                    String url = "jdbc:mysql://" + ip + ":" + port
                            + "/" + dbName;
                    // 构建连接mysql的字符串
                    String user = "wyy";
                    String password = "root";

                    // 3.连接JDBC
                    try {
                        conn = DriverManager.getConnection(url, user, password);
                        Log.d(TAG, "数据库连接成功");
                        return;
                    }
                    catch (SQLException e) {
                        Log.e(TAG, e.getMessage());
                    }

                }
            }
        });
        thread.start();
        thread.join();
    }
    public static Connection getConnection(){
        if(conn == null)
            try {
                mymysql();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        return conn;
    }
    public static String findWord(final String word) throws InterruptedException {
        final Connection conn = getConnection();
        final WordBean[] wordBean = new WordBean[1];
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Statement state = null;
                try {
                    state = getConnection().createStatement();
                    //String sql = "select * from '"+Plan_switch.bj+"' where word = '"+ word + "';";
                    String sql = "select * from allck where word like '"+ word + "';";
                    ResultSet resultSet = state.executeQuery(sql);
                    while(resultSet.next()){
                        String word = resultSet.getString("word");
                        String msg = resultSet.getString("shiyi");
                        String yinbiao = resultSet.getString("yinbiao");
                        int UID = resultSet.getInt("number");
                        int flag = resultSet.getInt("bj");
                        wordBean[0] = new WordBean(UID,word,msg,yinbiao,flag);
                        Log.d(TAG, wordBean[0].toString());
                    }

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
        thread.start();
        thread.join();
        return wordBean[0].toString();
    }

    public static int getWordnum(final String sjk) throws InterruptedException {
        final int[] flag = {0};
        final Connection conn = getConnection();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Statement state = null;
                try {
                    state = getConnection().createStatement();
                    String sql = "select num from tongjinum where sjk='"+sjk+"' ;";
                    ResultSet resultSet = state.executeQuery(sql);
                    while(resultSet.next()){
                         flag[0] = resultSet.getInt("num");
    //                    Log.d(flag);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join();
        return flag[0];
    }



    public static String getWord(final String sjk) throws InterruptedException {
    final Connection conn = getConnection();
        final WordBean[] wordBean = new WordBean[1];
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Statement state = null;
                try {
                    Random r=new Random();
                 //   int randoms=r.nextInt(getWordnum(sjk));
                    int randoms=r.nextInt(1000);
                    state = getConnection().createStatement();
                    String sql = "select * from "+sjk+" where number ="+randoms+ ";";
                    ResultSet resultSet = state.executeQuery(sql);
                    while(resultSet.next()){
                        String word = resultSet.getString("word");
                        String msg = resultSet.getString("shiyi");
                        String yinbiao = resultSet.getString("yinbiao");
                        int UID = resultSet.getInt("number");
                        int flag = resultSet.getInt("bj");
                        wordBean[0] = new WordBean(UID,word,msg,yinbiao,flag);
                        Log.d(TAG, wordBean[0].toString());
                    }

                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join();
        return wordBean[0].toString();
    }
}

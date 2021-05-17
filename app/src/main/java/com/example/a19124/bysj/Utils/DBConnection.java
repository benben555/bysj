package com.example.a19124.bysj.Utils;
import android.content.Context;
import android.util.Log;

import com.example.a19124.bysj.Bean.OrderBean;
import com.example.a19124.bysj.Bean.UserInfo;
import com.example.a19124.bysj.Bean.WordBean;

import  java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
                    String user = "root";
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
                    String sql = "select * from youdao where word like '"+ word + "';";
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
                    String sql = "select num from ciku where sjk='"+sjk+"' ;";
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

    public static List<WordBean> getRandWord(final int num, final String database) throws InterruptedException  {
        final List<WordBean> list = new ArrayList<>();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Statement state = null;
                try {
                    Random r = new Random();
                    //   int randoms=r.nextInt(getWordnum(sjk));
                    int randoms = r.nextInt(1000);
                    state = getConnection().createStatement();
                    String sql = "select * from "+database+" order by RAND() limit "+num+ ";";
                    ResultSet resultSet = state.executeQuery(sql);
                    while(resultSet.next()){
                        String word = resultSet.getString("word");
                        String msg = resultSet.getString("shiyi");
                        String yinbiao = resultSet.getString("yinbiao");
                        int UID = resultSet.getInt("number");
                        int flag = resultSet.getInt("bj");
                        WordBean wordBean = new WordBean(UID,word,msg,yinbiao,flag);
                        list.add(wordBean);
//                        Log.d(TAG, wordBean.toString());
                    }

                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join();
        return list;
    }
    public static boolean checkLogin(final String username, final String pwd) throws InterruptedException{
        final boolean[] flag = {false};
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Statement state = null;
                try {
                    state = getConnection().createStatement();
                    String sql = "select * from user where username='"+username+"' and password='"+pwd+"'";
                    ResultSet resultSet = state.executeQuery(sql);
                    while(resultSet.next()){
                        flag[0] = true;
                        Log.d(TAG,"Login success");
                        UserInfo.getInstance().setUsername(username);
                        UserInfo.getInstance().setCoinOver(resultSet.getInt("coin"));
                    }

                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join();
        return flag[0];
    }
    public static void collectWord(final WordBean word,final String ciku) throws InterruptedException{
        final UserInfo user = UserInfo.getInstance();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Statement state = null;
                try {
                    state = getConnection().createStatement();
                    String sql = String.format("insert into shoucang(username,wordnumber,ciku) values('%s',%d,'%s');",user.getUsername(),word.getUID(),ciku);
                    Log.d(TAG,sql);
                    state.executeUpdate(sql);
                    Log.d(TAG,"collect word"+word.getWord());

                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join();
    }
    public static List<WordBean> getCollectWords(final String username, final String ciku) throws InterruptedException{
        final List<WordBean> list = new ArrayList<>();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Statement state = null;
                try {
                    state = getConnection().createStatement();
                    String sql = String.format("create or replace VIEW shoucangdanci \n" +
                            "as\n" +
                            "select *\n" +
                            "from %s,shoucang\n" +
                            "where %s.number = shoucang.wordnumber and shoucang.username = '%s';",ciku,ciku,username);
                    state.executeUpdate(sql);
                    String select = "select * from shoucangdanci;";
                    ResultSet resultSet = state.executeQuery(select);
                    while(resultSet.next()){
                        String word = resultSet.getString("word");
                        String msg = resultSet.getString("shiyi");
                        String yinbiao = resultSet.getString("yinbiao");
                        int UID = resultSet.getInt("number");
                        int flag = resultSet.getInt("bj");
                        WordBean wordBean = new WordBean(UID,word,msg,yinbiao,flag);
                        list.add(wordBean);
                        Log.d(TAG,"select collectedWord "+word);
                    }

                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join();
        return list;
    }


    /**
     * 商城订单
     */
    public static void buy(final int productId) throws InterruptedException{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Statement state = null;
                try {
                    state = getConnection().createStatement();
                    String sql = String.format("insert into dingdan(username,shangping) values('%s',%d);",UserInfo.getInstance().getUsername(),productId);
                    state.executeUpdate(sql);
                    Log.d(TAG,"buy "+productId);

                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join();
    }

    public static void subCoin(final int spend) throws InterruptedException{
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Statement state = null;
                try {
                    state = getConnection().createStatement();
                    String sql = String.format("update user set coin = coin-%d where username='%s';",spend,UserInfo.getInstance().getUsername());
                    state.executeUpdate(sql);

                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join();
    }
    public static List<OrderBean> getOrder(final String username) throws InterruptedException {
        final List<OrderBean> list = new ArrayList<>();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Statement state = null;
                try {
                    state = getConnection().createStatement();
                    String sql = String.format("select * from dingdan where username = '%s';",username);
                    ResultSet resultSet = state.executeQuery(sql);
                    while(resultSet.next()){

                        int UID = resultSet.getInt("id");
                        int flag = resultSet.getInt("shangping");
                        OrderBean order = new OrderBean(UID,flag);
                        list.add(order);
                        Log.d(TAG,"select order "+UID + " "+flag);
                    }

                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join();
        return list;
    }
}

package com.example.a19124.bysj.Bean;

import com.example.a19124.bysj.Utils.DBConnection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : Jason Zhang
 * @date : 2021/01/19
 * version: 2.0
 * Description:
 */
public class TestWordsRespository {
    private static TestWordsRespository INSTANCE = null;

    private int recognizedWordsCount = 0;
    private int num = 50;
    private String database;
    private Queue<WordBean> wordQueue;

    private TestWordsRespository(String database) {
        wordQueue = new LinkedList<>();
        recognizedWordsCount = 0;
        this.database = database;
    }

    public static TestWordsRespository getInstance(String database) {
        if (INSTANCE == null) {
            synchronized (TestWordsRespository.class) {
                if (INSTANCE == null) {
                    return INSTANCE = new TestWordsRespository(database);
                }
            }
        }
        return INSTANCE;
    }
    public boolean isTestWordsEmpty() { return wordQueue.isEmpty(); }
    public WordBean getWord() { return wordQueue.poll(); }
    public void recognizeWord() { recognizedWordsCount++; }
    public int getSize() { return wordQueue.size(); }
    public void resetRespoitory() {
        wordQueue.clear();
        recognizedWordsCount = 0;
    }
    public void initTestWords() {
        try{
            List<WordBean> list = DBConnection.getRandWord(num, database);
            wordQueue.addAll(list);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public List<WordBean> getConfusedWords() {
        List<WordBean> list = new ArrayList<>();
        try{
            list = DBConnection.getRandWord(4,database);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return list;
    }

}

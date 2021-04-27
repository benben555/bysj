package com.example.a19124.bysj.Bean;

import com.example.a19124.bysj.Utils.DBConnection;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReciteWordsRespository {
    public static final int RECOGNIZED = 1;
    public static final int UNCERTAIN = 2;
    public static final int UNRECOGNIZED = 3;

    private static ReciteWordsRespository INSTANCE;
    private String database;
    private int num = 50;
    private Queue<WordBeanEx> wordQueue;
    private Queue<WordBean> wordList;
    private WordBeanEx curWord;
    private ReciteWordsRespository(String database){
        wordList = new LinkedList<>();
        wordQueue = new LinkedList<>();
        this.database = database;
        initList();
    }
    public static ReciteWordsRespository getInstance(String database) {
        if(INSTANCE == null){
            synchronized (ReciteWordsRespository.class){
                if(INSTANCE == null) {
                    return INSTANCE = new ReciteWordsRespository(database);
                }
            }
        }
        return INSTANCE;
    }

    public void setWordNum(int num) {
        this.num = num;
    }
    public void setDatabase(String database) { this.database = database; }

    /**
     * 在这里初始化要背的单词
     * 用数据库 DBConnection获取数据，一次获取个数自己设置
     */
    private void initList() {
        //初始化List
        try {
            List<WordBean> words = DBConnection.getRandWord(num, database);
            wordList.addAll(words);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        //
        addWordToQueue(7);
    }

    /**
     * 拿到当前正在记忆的单词
     * @return wordBean
     */
    public WordBean getWord() {
        curWord = wordQueue.poll();
        assert curWord != null;
        return curWord.getWord();
    }

    /**
     * 根据选项调整出现概率
     * @param TAG 按钮标志
     */
    public void changeRate(int TAG) {
        switch (TAG){
            case UNCERTAIN:curWord.setRate(2);break;
            case UNRECOGNIZED:curWord.setRate(3);break;
            case RECOGNIZED:curWord.subRate();break;
            default:
        }
        if(curWord.getRate() > 0){
            wordQueue.add(curWord);
        }
        addWordToQueue(7);
    }

    /**
     * 检查 要背的单词列表是否全部背完，背完则执行操作
     * @return 两个带背单词列表均为空
     */
    public boolean remeberedAll(){
        return wordQueue.isEmpty() && wordList.isEmpty();
    }

    private void addWordToQueue(int size) {
        while(!wordList.isEmpty() && wordQueue.size() < size) {
            wordQueue.offer(new WordBeanEx(2,wordList.poll()));
        }
    }

}

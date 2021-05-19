package com.example.a19124.bysj.Bean;

public class WordBeanEx {
    // 0 - 3 ,每确定一次认识 -1
    private int rate;
    private WordBean word;

    public WordBeanEx(int rate, WordBean word) {
        this.rate = rate;
        this.word = word;
    }

    public WordBean getWord() {
        return word;
    }

    public void setWord(WordBean word) {
        this.word = word;
    }

    public int getRate() {
        return rate;
    }
    public void subRate() {
        this.rate --;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

}

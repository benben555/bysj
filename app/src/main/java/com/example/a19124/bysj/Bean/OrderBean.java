package com.example.a19124.bysj.Bean;

public class OrderBean {
    private int UID;
    private int flag;

    public OrderBean(int UID, int flag) {
        this.UID = UID;
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }
}

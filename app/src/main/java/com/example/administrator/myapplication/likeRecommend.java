package com.example.administrator.myapplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:LiaoChengbiao
 * Time:2018/5/7
 * Description:描述
 */

public class likeRecommend {
    private String img;
    private String dec;
    private String title;
    private List<likeRecommend> sendlist;

    public List<likeRecommend> getSendlist() {
        if (sendlist == null) {
            return new ArrayList<>();
        }
        return sendlist;
    }

    public void setSendlist(List<likeRecommend> sendlist) {
        this.sendlist = sendlist;
    }

    public String getImg() {
        return img == null ? "" : img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDec() {
        return dec == null ? "" : dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }

    public String getTitle() {
        return title == null ? "" : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}

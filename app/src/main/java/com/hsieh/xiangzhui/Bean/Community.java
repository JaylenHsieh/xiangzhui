package com.hsieh.xiangzhui.Bean;

public class Community {
    private int imgId;
    private String name;
    private String time;
    private String content;

    public Community(int imgId, String name, String time, String content) {
        this.imgId = imgId;
        this.name = name;
        this.time = time;
        this.content = content;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

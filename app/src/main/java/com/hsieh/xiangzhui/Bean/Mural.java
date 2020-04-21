package com.hsieh.xiangzhui.Bean;

public class Mural {
    private int ImageId;
    private String muralTheme;
    private String muralClass;
    private float muralScore;
    private int muralLength;
    private int muralWidth;


    public Mural(int imageId, String muralTheme, String muralClass, float muralScore, int muralLength, int muralWidth) {
        ImageId = imageId;
        this.muralTheme = muralTheme;
        this.muralClass = muralClass;
        this.muralScore = muralScore;
        this.muralLength = muralLength;
        this.muralWidth = muralWidth;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getMuralTheme() {
        return muralTheme;
    }

    public void setMuralTheme(String muralTheme) {
        this.muralTheme = muralTheme;
    }

    public String getMuralClass() {
        return muralClass;
    }

    public void setMuralClass(String muralClass) {
        this.muralClass = muralClass;
    }

    public double getMuralScore() {
        return muralScore;
    }

    public void setMuralScore(float muralScore) {
        this.muralScore = muralScore;
    }

    public int getMuralLength() {
        return muralLength;
    }

    public void setMuralLength(int muralLength) {
        this.muralLength = muralLength;
    }

    public int getMuralWidth() {
        return muralWidth;
    }

    public void setMuralWidth(int muralWidth) {
        this.muralWidth = muralWidth;
    }
}

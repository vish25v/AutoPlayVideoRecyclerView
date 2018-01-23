package com.hoanganhtuan95ptit.library_autoplayvideorecyclerview.mode;

import java.io.Serializable;

/**
 * Created by HoangAnhTuan on 1/21/2018.
 */

public abstract class Info implements Serializable {
    private String urlPhoto;

    public Info() {
    }

    public Info(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }
}

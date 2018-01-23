package com.hoanganhtuan95ptit.library_autoplayvideorecyclerview.mode;

import java.io.Serializable;

/**
 * Created by HoangAnhTuan on 1/21/2018.
 */

public class Feed implements Serializable {

    private Info info;
    private Model model;

    public Feed() {
    }

    public Feed(Info info, Model model) {
        this.info = info;
        this.model = model;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public enum Model {
        M1, M2
    }
}

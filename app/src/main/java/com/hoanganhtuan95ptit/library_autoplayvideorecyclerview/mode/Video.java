package com.hoanganhtuan95ptit.library_autoplayvideorecyclerview.mode;

/**
 * Created by HoangAnhTuan on 1/21/2018.
 */

public class Video extends Info {
    private String urlVideo;
    private String urlVideoLocal;
    private int seekTo;

    public Video(String urlVideo, int seekTo) {
        this.urlVideo = urlVideo;
        this.seekTo = seekTo;
    }

    public Video(String urlPhoto, String urlVideo, int seekTo) {
        super(urlPhoto);
        this.urlVideo = urlVideo;
        this.seekTo = seekTo;
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public String getUrlVideoLocal() {
        return urlVideoLocal;
    }

    public void setUrlVideoLocal(String urlVideoLocal) {
        this.urlVideoLocal = urlVideoLocal;
    }

    public int getSeekTo() {
        return seekTo;
    }

    public void setSeekTo(int seekTo) {
        this.seekTo = seekTo;
    }
}

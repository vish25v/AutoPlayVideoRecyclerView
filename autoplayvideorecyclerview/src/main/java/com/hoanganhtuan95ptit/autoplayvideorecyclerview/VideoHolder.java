package com.hoanganhtuan95ptit.autoplayvideorecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by tuanha00 on 1/23/2018.
 */

public abstract class VideoHolder extends RecyclerView.ViewHolder {

    public VideoHolder(View itemView) {
        super(itemView);
    }

    public abstract View getVideoLayout();

    public abstract void playVideo();

    public abstract void stopVideo();

}
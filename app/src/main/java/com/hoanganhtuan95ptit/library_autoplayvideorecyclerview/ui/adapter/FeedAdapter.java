package com.hoanganhtuan95ptit.library_autoplayvideorecyclerview.ui.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.hoanganhtuan95ptit.autoplayvideorecyclerview.VideoHolder;
import com.hoanganhtuan95ptit.library_autoplayvideorecyclerview.R;
import com.hoanganhtuan95ptit.library_autoplayvideorecyclerview.mode.Feed;
import com.hoanganhtuan95ptit.library_autoplayvideorecyclerview.mode.Photo;
import com.hoanganhtuan95ptit.library_autoplayvideorecyclerview.mode.Video;
import com.hoanganhtuan95ptit.library_autoplayvideorecyclerview.ui.view.CameraAnimation;
import com.hoanganhtuan95ptit.library_autoplayvideorecyclerview.ui.view.VideoView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HoangAnhTuan on 1/21/2018.
 */

public class FeedAdapter extends BaseAdapter<Feed> {

    private static final int PHOTO_M1 = 0;
    private static final int PHOTO_M2 = 1;
    private static final int VIDEO_M1 = 2;
    private static final int VIDEO_M2 = 3;

    private static int screenWight = 0;

    public FeedAdapter(Activity activity) {
        super(activity);
        screenWight = getScreenWight();
    }

    @Override
    public int getItemViewType(int position) {
        Feed feed = list.get(position);
        if (feed.getInfo() instanceof Photo) {
            if (feed.getModel() == Feed.Model.M1) return PHOTO_M1;
            return PHOTO_M2;
        } else {
            if (feed.getModel() == Feed.Model.M1) return VIDEO_M1;
            return VIDEO_M2;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case PHOTO_M1:
                view = activity.getLayoutInflater().inflate(R.layout.item_photo, parent, false);
                return new Photo11Holder(view);
            case PHOTO_M2:
                view = activity.getLayoutInflater().inflate(R.layout.item_photo, parent, false);
                return new Photo169Holder(view);
            case VIDEO_M1:
                view = activity.getLayoutInflater().inflate(R.layout.item_video, parent, false);
                return new Video11Holder(view);
            default:
                view = activity.getLayoutInflater().inflate(R.layout.item_video, parent, false);
                return new Video169Holder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Feed feed = list.get(position);
        if (holder instanceof Video11Holder) {
            onBindVideo11Holder((Video11Holder) holder, feed);
        } else if (holder instanceof Video169Holder) {
            onBindVideo169Holder((Video169Holder) holder, feed);
        } else if (holder instanceof Photo11Holder) {
            onBindPhoto11Holder((Photo11Holder) holder, feed);
        } else if (holder instanceof Photo169Holder) {
            onBindPhoto169Holder((Photo169Holder) holder, feed);
        }
    }

    private void onBindPhoto11Holder(Photo11Holder holder, Feed feed) {
        Picasso.with(activity)
                .load(feed.getInfo().getUrlPhoto())
                .resize(screenWight, screenWight)
                .centerCrop()
                .into(holder.ivInfo);
    }

    private void onBindPhoto169Holder(Photo169Holder holder, Feed feed) {
        Picasso.with(activity)
                .load(feed.getInfo().getUrlPhoto())
                .resize(screenWight, screenWight * 9 / 16)
                .centerCrop()
                .into(holder.ivInfo);
    }

    private void onBindVideo11Holder(final DemoVideoHolder holder, Feed feed) {
        holder.vvInfo.setVideo((Video) feed.getInfo());
        Picasso.with(activity)
                .load(feed.getInfo().getUrlPhoto())
                .resize(screenWight, screenWight)
                .centerCrop()
                .into(holder.ivInfo);
    }

    private void onBindVideo169Holder(final DemoVideoHolder holder, Feed feed) {
        holder.vvInfo.setVideo((Video) feed.getInfo());
        Picasso.with(activity)
                .load(feed.getInfo().getUrlPhoto())
                .resize(screenWight, screenWight * 9 / 16)
                .centerCrop()
                .into(holder.ivInfo);
    }

    private int getScreenWight() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static class PhotoHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivInfo)
        ImageView ivInfo;

        public PhotoHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    public static class Photo11Holder extends PhotoHolder {

        public Photo11Holder(View itemView) {
            super(itemView);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ivInfo.getLayoutParams();
            layoutParams.width = screenWight;
            layoutParams.height = screenWight;
            ivInfo.setLayoutParams(layoutParams);
        }
    }

    public static class Photo169Holder extends PhotoHolder {


        public Photo169Holder(View itemView) {
            super(itemView);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ivInfo.getLayoutParams();
            layoutParams.width = screenWight;
            layoutParams.height = screenWight * 9 / 16;
            ivInfo.setLayoutParams(layoutParams);
        }
    }

    public static class DemoVideoHolder extends VideoHolder {

        @BindView(R.id.vvInfo)
        VideoView vvInfo;
        @BindView(R.id.ivInfo)
        ImageView ivInfo;
        @BindView(R.id.ivCameraAnimation)
        CameraAnimation ivCameraAnimation;

        public DemoVideoHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public View getVideoLayout() {
            return vvInfo;
        }

        @Override
        public void playVideo() {
            ivInfo.setVisibility(View.VISIBLE);
            ivCameraAnimation.start();
            vvInfo.play(new VideoView.OnPreparedListener() {
                @Override
                public void onPrepared() {
                    ivInfo.setVisibility(View.GONE);
                    ivCameraAnimation.stop();
                }
            });
        }

        @Override
        public void stopVideo() {
            ivInfo.setVisibility(View.VISIBLE);
            ivCameraAnimation.stop();
            vvInfo.stop();
        }
    }

    public static class Video11Holder extends DemoVideoHolder {

        public Video11Holder(View itemView) {
            super(itemView);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) vvInfo.getLayoutParams();
            layoutParams.width = screenWight;
            layoutParams.height = screenWight;
            vvInfo.setLayoutParams(layoutParams);
        }

    }

    public static class Video169Holder extends DemoVideoHolder {

        public Video169Holder(View itemView) {
            super(itemView);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) vvInfo.getLayoutParams();
            layoutParams.width = screenWight;
            layoutParams.height = screenWight * 9 / 16;
            vvInfo.setLayoutParams(layoutParams);
        }
    }
}

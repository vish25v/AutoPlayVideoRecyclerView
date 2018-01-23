package com.hoanganhtuan95ptit.library_autoplayvideorecyclerview.ui.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.RelativeLayout;

import com.danikula.videocache.HttpProxyCacheServer;
import com.hoanganhtuan95ptit.library_autoplayvideorecyclerview.App;
import com.hoanganhtuan95ptit.library_autoplayvideorecyclerview.R;
import com.hoanganhtuan95ptit.library_autoplayvideorecyclerview.mode.Video;

/**
 * Created by tuanha00 on 1/22/2018.
 */

public class VideoView extends RelativeLayout implements TextureView.SurfaceTextureListener {

    private Video video;
    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;

    private OnCompletionListener onCompletionListener;

    public VideoView(Context context) {
        super(context);
        init(context);
    }

    public VideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public VideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.onCompletionListener = onCompletionListener;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    private void init(Context context) {
        inflate(context, R.layout.layout_video, this);
        TextureView textureView = findViewById(R.id.surfaceView);
        textureView.setSurfaceTextureListener(this);
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
        try {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setSurface(new Surface(surfaceTexture));
            HttpProxyCacheServer proxy = App.getProxy(getContext());
            String proxyUrl = proxy.getProxyUrl(video.getUrlVideo());
            mediaPlayer.setDataSource(proxyUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {
    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void play(final OnPreparedListener onPreparedListener) {
        if (isPlaying) return;
        isPlaying = true;
        try {
            this.mediaPlayer.prepareAsync();
            this.mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.seekTo(video.getSeekTo());
                    mediaPlayer.setLooping(true);
                    mediaPlayer.start();
                    if (onPreparedListener != null) onPreparedListener.onPrepared();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (!isPlaying) return;
        isPlaying = false;
        video.setSeekTo(mediaPlayer.getCurrentPosition() >= mediaPlayer.getDuration() ? 0 : mediaPlayer.getCurrentPosition());
        mediaPlayer.pause();
        mediaPlayer.stop();
    }

    public interface OnCompletionListener {
        void onCompletion();
    }


    public interface OnPreparedListener {
        void onPrepared();
    }

}


# AutoPlayVideoRecyclerView
library auto play video with recyclerView like Facebook, Instagram, Magisto..


## Demo

<img src="/demo.gif">

## Download

* Step 1. Add it in your root build.gradle at the end of repositories:
```java
    allprojects {
        repositories {
          ...
          maven { url 'https://jitpack.io' }
        }
    }
```
* Step 2. Add the dependency
```java
    dependencies {
	     compile 'com.github.hoanganhtuan95ptit:AutoPlayVideoRecyclerView:1.0.1'
    }
```

## Proguard

```java

    -dontwarn com.hoanganhtuan95ptit.autoplayvideorecyclerview.**
```

## Using

* xml

```java

    <com.hoanganhtuan95ptit.autoplayvideorecyclerview.AutoPlayVideoRecyclerView
        android:id="@+id/listFeed"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```

* VideoHolder

```java
    public abstract class VideoHolder extends RecyclerView.ViewHolder {

        public VideoHolder(View itemView) {
            super(itemView);
        }

        public abstract View getVideoLayout();

        public abstract void playVideo();

        public abstract void stopVideo();

    }

```

* Custom VideoHolder

```java
     public static class DemoVideoHolder extends VideoHolder {

            @BindView(R.id.vvInfo)
            VideoView vvInfo;

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
                vvInfo.stop();
            }
        }
```

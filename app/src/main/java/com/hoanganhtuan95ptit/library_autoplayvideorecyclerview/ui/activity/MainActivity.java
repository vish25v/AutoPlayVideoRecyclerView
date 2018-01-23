package com.hoanganhtuan95ptit.library_autoplayvideorecyclerview.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hoanganhtuan95ptit.autoplayvideorecyclerview.AutoPlayVideoRecyclerView;
import com.hoanganhtuan95ptit.library_autoplayvideorecyclerview.R;
import com.hoanganhtuan95ptit.library_autoplayvideorecyclerview.mode.Feed;
import com.hoanganhtuan95ptit.library_autoplayvideorecyclerview.mode.Photo;
import com.hoanganhtuan95ptit.library_autoplayvideorecyclerview.mode.Video;
import com.hoanganhtuan95ptit.library_autoplayvideorecyclerview.ui.adapter.FeedAdapter;
import com.hoanganhtuan95ptit.library_autoplayvideorecyclerview.ui.view.CenterLayoutManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listFeed)
    AutoPlayVideoRecyclerView listFeed;

    private FeedAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        adapter = new FeedAdapter(this);
        listFeed.setLayoutManager(new CenterLayoutManager(this));
        listFeed.setAdapter(adapter);

        initData();
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            adapter.add(new Feed(new Video("https://instagram.fhan3-1.fna.fbcdn.net/vp/fdac380ecfa349f38f4f1701abcc29b5/5A681B7A/t51.2885-15/e15/26226589_171205453644367_3851432199505051648_n.jpg",
                    "https://instagram.fhan3-1.fna.fbcdn.net/vp/cc9f81b0cd5c3100895184072dac16d5/5A68A1A0/t50.2886-16/19231638_185054565422809_5378340150369583104_n.mp4",
                    0), Feed.Model.M1));
            adapter.add(new Feed(new Video("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795681/2_rp0zyy.jpg",
                    "https://firebasestorage.googleapis.com/v0/b/flickering-heat-5334.appspot.com/o/demo1.mp4?alt=media&token=f6d82bb0-f61f-45bc-ab13-16970c7432c4",
                    0), Feed.Model.M2));
            adapter.add(new Feed(new Photo("https://instagram.fhan3-1.fna.fbcdn.net/vp/eda3c07414af6af5b63242572b6691d0/5AF3DAAF/t51.2885-15/s640x640/sh0.08/e35/26296225_2013411645646716_7530350444791463936_n.jpg"),
                    Feed.Model.M1));
            adapter.add(new Feed(new Video("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1481795675/3_yqeudi.jpg",
                    "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1481795675/3_yqeudi.mp4",
                    0), Feed.Model.M2));
            adapter.add(new Feed(new Video("https://instagram.fhan3-1.fna.fbcdn.net/vp/d0acc072a7333fe1dd27effe686fbfba/5A687F55/t51.2885-15/e15/26409479_1986649528267692_3453338561376419840_n.jpg",
                    "https://instagram.fhan3-1.fna.fbcdn.net/vp/b1728a20fdf1e3a07060565b8e16c7b5/5A683054/t50.2886-16/26691065_2029557753956918_1909061054097260544_n.mp4",
                    0), Feed.Model.M1));
            adapter.add(new Feed(new Photo("https://instagram.fhan3-1.fna.fbcdn.net/vp/44464d1c954f7a32c1ce974c5def7a15/5AEA1568/t51.2885-15/s640x640/sh0.08/e35/26863501_553136018374196_6715920436678361088_n.jpg"),
                    Feed.Model.M1));
            adapter.add(new Feed(new Video("http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70,so_0/v1491561340/hello_cuwgcb.jpg",
                    "http://res.cloudinary.com/krupen/video/upload/w_300,h_150,c_crop,q_70/v1491561340/hello_cuwgcb.mp4",
                    0), Feed.Model.M2));
            adapter.add(new Feed(new Video("https://instagram.fhan3-1.fna.fbcdn.net/vp/edc932372188896d32b39ce29b85baa6/5A68F1F7/t51.2885-15/e35/26071164_412111042577897_3016654672157999104_n.jpg",
                    "https://instagram.fhan3-1.fna.fbcdn.net/vp/d45509c5c691981913139b3319618564/5A681FE9/t50.2886-16/26821622_554234641576625_2150062079877406200_n.mp4",
                    0), Feed.Model.M2));
            adapter.add(new Feed(new Photo("https://instagram.fhan3-1.fna.fbcdn.net/vp/f72190a2129f384f5655277a6912aeda/5AF845DC/t51.2885-15/sh0.08/e35/p640x640/26153004_719204978284531_943265240148082688_n.jpg"),
                    Feed.Model.M1));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (listFeed.getHandingVideoHolder() != null) listFeed.getHandingVideoHolder().playVideo();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (listFeed.getHandingVideoHolder() != null) listFeed.getHandingVideoHolder().stopVideo();
    }

}

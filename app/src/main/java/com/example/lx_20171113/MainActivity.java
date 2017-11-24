package com.example.lx_20171113;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Banner banner;
    private List<Integer> images = new ArrayList<>();//存放本地图片的ID
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banner = (Banner) findViewById(R.id.fg_homepage_banner);
        setBanner();
    }
    /**
     * 显示Banner
     */
    private void setBanner() {
        /******显示本地图片********/
        //图片加载器中需要用到的path；
        images.add(R.drawable.banner_a);
        images.add(R.drawable.banner_b);
        images.add(R.drawable.banner_c);
        images.add(R.drawable.banner_d);

        //添加本地mipmap下的图片；
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                imageView.setImageResource((Integer) path);
            }
        });

        banner.setImages(images);
        banner.start();
    }
}

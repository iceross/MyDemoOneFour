package com.benhuan.mydemoonefour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.benhuan.imageloader.ImageLoaderManager;


public class MainActivity extends AppCompatActivity {

    ImageView imageView1,imageView2;

    private String url="http://tupian.enterdesk.com/2015/xu/08/13/1/11.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.iv_img1);
        imageView2 = (ImageView) findViewById(R.id.iv_img2);

        /*ImageLoaderOptions defeaulOptions1 = ImageLoaderManager.getDefaultOptions(imageView1, url);
        ImageLoaderOptions defeaulOptions2 = ImageLoaderManager.getDefaultOptions(imageView2, url);

        ImageLoaderManager.getInstance().showImage(defeaulOptions1);
        ImageLoaderManager.getInstance().showImage(defeaulOptions2);*/


        ImageLoaderManager.getInstance().showImage(ImageLoaderManager.getDefaultOptions(imageView1,url));
        ImageLoaderManager.getInstance().showImage(ImageLoaderManager.getDefaultOptions(imageView2,url));
    }
}

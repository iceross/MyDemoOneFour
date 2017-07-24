package com.benhuan.imageloader;

import android.content.Context;
import android.view.View;

/**
 * Created by XieMinFeng.
 * Date: 2017-07-13
 * Time: 17:46
 * Desc:
 */

public class ImageLoaderManager implements IImageLoaderstrategy {

    private static final ImageLoaderManager INSTANCE = new ImageLoaderManager();

    private IImageLoaderstrategy loaderstrategy;

    private ImageLoaderManager() {

    }

    public static ImageLoaderManager getInstance() {
        return INSTANCE;
    }

    public void setImageLoaderStrategy(IImageLoaderstrategy imageLoaderStrategy) {
        loaderstrategy = imageLoaderStrategy;
    }


    public static ImageLoaderOptions getDefaultOptions(View container,String url) {
        return new ImageLoaderOptions.Builder(container,url).isCrossFade(true).build();
    }

    @Override
    public void showImage(ImageLoaderOptions options) {
        if(loaderstrategy != null) {
            loaderstrategy.showImage(options);
        }
    }

    @Override
    public void cleanMemory(Context context) {
        loaderstrategy.cleanMemory(context);
    }

    @Override
    public void init(Context context) {
        loaderstrategy = new GlideImageLoader();

        loaderstrategy.init(context);
    }
}

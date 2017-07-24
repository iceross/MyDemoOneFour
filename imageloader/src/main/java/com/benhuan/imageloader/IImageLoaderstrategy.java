package com.benhuan.imageloader;

import android.content.Context;

/**
 * Created by XieMinFeng.
 * Date: 2017-07-13
 * Time: 16:55
 * Desc:
 */

public interface IImageLoaderstrategy {

    void showImage(ImageLoaderOptions options);

    void cleanMemory(Context context);

    void init(Context context);

}

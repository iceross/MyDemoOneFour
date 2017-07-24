package com.benhuan.imageloader;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.GifRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

/**
 * Created by XieMinFeng.
 * Date: 2017-07-13
 * Time: 16:56
 * Desc:
 */

public class GlideImageLoader implements IImageLoaderstrategy {
    @Override
    public void showImage(ImageLoaderOptions options) {
        GenericRequestBuilder mGenricRequestBuilder =
                init(options);

        if (mGenricRequestBuilder != null) {
            showImageLast(mGenricRequestBuilder, options);
        }
    }

    @Override
    public void cleanMemory(Context context) {
        if (Looper.myLooper() == Looper.getMainLooper()) {

            Glide.get(context).clearMemory();

        }

    }

    @Override
    public void init(Context context) {

    }

    public DrawableTypeRequest getGenericRequestBuilder(RequestManager manager, ImageLoaderOptions options) {

        if (!TextUtils.isEmpty(options.getUrl())) {
            return manager.load(options.getUrl());
        }

        return manager.load(options.getResource());

    }

    public RequestManager getRequesManager(Context context) {
        return Glide.with(context);
    }

    public GenericRequestBuilder init(ImageLoaderOptions options) {
        View v = options.getViewContainer();


        RequestManager manager = getRequesManager(v.getContext());

        if (v instanceof ImageView) {
            GenericRequestBuilder mDrawableTypeRequest =
                    getGenericRequestBuilder(manager, options).asBitmap();

            if (options.isAsGif()) {
                mDrawableTypeRequest = getGenericRequestBuilder(manager, options);
            }

            //装载参数
             mDrawableTypeRequest = loadGenericParams(mDrawableTypeRequest,options);
            return mDrawableTypeRequest;
        }

        return null;

    }


    private GenericRequestBuilder loadGenericParams(GenericRequestBuilder genericRequestBuilder, final ImageLoaderOptions options) {

        final View view = options.getViewContainer();

        GenericRequestBuilder builder = genericRequestBuilder;

        if (genericRequestBuilder instanceof DrawableTypeRequest) {

            if (options.isCrossFade()) {
                ((DrawableTypeRequest) genericRequestBuilder).crossFade();
            }

            if (options.isAsGif()) {
                builder = ((DrawableTypeRequest) genericRequestBuilder).asGif();
            }

        }

        builder.skipMemoryCache(options.isSkipMemoryCache());

        if (options.getImageSize() != null) {

            int width = getSize(options.getImageSize().getWidth(), view);

            int height = getSize(options.getImageSize().getHeight(), view);

            builder.override(width, height);

        }


        if (options.getHolderDrawable() != -1) {

            builder.placeholder(options.getHolderDrawable());

        }

        if (options.getErrorDrawable() != -1) {

            builder.error(options.getErrorDrawable());

        }

        if (options.getDiskCacheStrategy() != ImageLoaderOptions.DiskCacheStrategy.DEFAULT) {

            switch (options.getDiskCacheStrategy()) {
                case NONE:
                    builder.diskCacheStrategy(DiskCacheStrategy.NONE);
                    break;
                case All:
                    builder.diskCacheStrategy(DiskCacheStrategy.ALL);
                    break;
                case SOURCE:
                    builder.diskCacheStrategy(DiskCacheStrategy.SOURCE);
                    break;
                case RESULT:
                    builder.diskCacheStrategy(DiskCacheStrategy.RESULT);
                    break;
                default:
                    break;

            }


        }

        return builder;
    }


    private void showImageLast(GenericRequestBuilder mDrawableTypeRequest, ImageLoaderOptions options) {

        final ImageView img = (ImageView) options.getViewContainer();


        //是否使用高斯模糊
        if (options.isBlurImage()) {
            mDrawableTypeRequest.into(img);

            return;
        }

        //是否展示一个gif
        if (options.isAsGif()) {

            ((GifRequestBuilder)mDrawableTypeRequest).dontAnimate().into(new SimpleTarget<GifDrawable>() {

                @Override
                public void onResourceReady(GifDrawable resource, GlideAnimation<? super GifDrawable> glideAnimation) {
                    img.setImageDrawable(resource);
                    resource.start();
                }
            });

            return;

        }

        if(options.getTarget() != null) {

            mDrawableTypeRequest.into(options.getTarget());

            return;
        }

        mDrawableTypeRequest.into(img);


    }


    /**
     * 获取资源尺寸
     *
     * @param resSize
     * @param container
     * @return
     */
    private int getSize(int resSize, View container) {
        if (resSize <= 0) {
            return SimpleTarget.SIZE_ORIGINAL;
        } else {

            try {
                return container.getContext().getResources().getDimensionPixelOffset(resSize);
            } catch (Resources.NotFoundException e) {


                return resSize;
            }


        }
    }


}

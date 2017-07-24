package com.benhuan.imageloader;

import android.view.View;

import com.bumptech.glide.request.target.BaseTarget;

/**
 * Created by XieMinFeng.
 * Date: 2017-07-13
 * Time: 14:30
 * Desc:
 */

public class ImageLoaderOptions {

    private View viewContainer; //图片容器
    private String url; //图片地址
    private Integer resource; //图片资源地址
    private int holderDrawable; //设置占位图
    private ImageSize imageSize;    //设置图片的大小
    private int errorDrawable;       //加载错误展示图
    private boolean asGif = false;  //是否作为gif展示
    private boolean isSkipMemoryCache = false;  //是否跳过内存缓存
    private boolean isCrossFade = true;     //是否平滑显示图片
    private DiskCacheStrategy mDiskCacheStrategy = DiskCacheStrategy.DEFAULT; //磁盘缓存策略
    private boolean blurImage = false;  //是否使用高斯模糊
    private BaseTarget target = null;   //target


    private ImageLoaderOptions(Builder builder) {
        this.asGif = builder.asGif;
        this.errorDrawable = builder.errorDrawable;
        this.holderDrawable = builder.holderDrawable;
        this.imageSize = builder.mImageSize;
        this.isCrossFade = builder.isCrossFade;
        this.isSkipMemoryCache = builder.isSkipMemoryCache;
        this.mDiskCacheStrategy = builder.mDiskCacheStrategy;
        this.url = builder.url;
        this.resource = builder.resource;
        this.viewContainer = builder.mViewContainer;
        this.blurImage = builder.blurImage;
        this.target = builder.target;
    }

    public BaseTarget getTarget() {
        return target;
    }

    public Integer getResource() {
        return resource;
    }

    public boolean isBlurImage() {
        return blurImage;
    }

    public View getViewContainer() {
        return viewContainer;
    }

    public String getUrl() {
        return url;
    }

    public int getHolderDrawable() {
        return holderDrawable;
    }

    public ImageSize getImageSize() {
        return imageSize;
    }

    public int getErrorDrawable() {
        return errorDrawable;
    }



    public boolean isAsGif() {
        return asGif;
    }


    public boolean isCrossFade() {
        return isCrossFade;
    }



    public boolean isSkipMemoryCache() {
        return isSkipMemoryCache;
    }



    public DiskCacheStrategy getDiskCacheStrategy() {
        return mDiskCacheStrategy;
    }

    public final static class Builder {

        private int holderDrawable = -1;
        private View mViewContainer; //图片容器
        private String url; //图片地址
        private Integer resource; //图片资源地址
        private ImageSize mImageSize;
        private int errorDrawable=-1;
        private boolean asGif = false;
        private boolean isSkipMemoryCache = false;
        private boolean isCrossFade = true;
        private DiskCacheStrategy mDiskCacheStrategy = DiskCacheStrategy.DEFAULT;
        private boolean blurImage = false;
        private BaseTarget target = null;


        public Builder(View v,String url) {
            this.url = url;
            this.mViewContainer = v;
        }

        public Builder(View v,Integer resource) {
            this.resource = resource;
            this.mViewContainer = v;
        }

        public Builder placeholder(int holderDrawable) {
            this.holderDrawable = holderDrawable;
            return this;
        }

        public Builder isCrossFade(boolean isCrossFade) {
            this.isCrossFade = isCrossFade;
            return this;
        }

        public Builder blurImage(boolean blurImage) {
            this.blurImage = blurImage;
            return this;
        }

        public Builder isSkipMemoryCache(boolean isSkipMemoryCache) {
            this.isSkipMemoryCache = isSkipMemoryCache;
            return this;
        }

        public Builder override(int width,int heigth) {
            this.mImageSize = new ImageSize(width,heigth);
            return this;
        }

        public Builder asGif(boolean asGif) {
            this.asGif = asGif;
            return this;
        }

        public Builder error(int errorDrawable) {
            this.errorDrawable = errorDrawable;
            return this;
        }

        public Builder target(BaseTarget target) {
            this.target = target;
            return this;
        }

        public Builder diskCacheStategy(DiskCacheStrategy mDiskCacheStrategy) {
            this.mDiskCacheStrategy = mDiskCacheStrategy;
            return this;
        }

        public ImageLoaderOptions build() {
            return new ImageLoaderOptions(this);
        }
    }

    //对应重写图片 size
    public final static class ImageSize{

        private int width = 0;
        private int height = 0;

        public ImageSize(int width,int height) {
            this.width = width;
            this.height = height;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }

    }

    //对应磁盘缓存策略
    public enum DiskCacheStrategy {
        All,NONE,SOURCE,RESULT,DEFAULT
    }

}

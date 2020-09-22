package com.android.androidsplash;

import android.content.Context;
import android.nfc.Tag;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.VideoView;

public class FullScreenVideoView extends VideoView {
    private static final String TAG = "FullScreenVideoView";
    //用于直接new一个属性。
    public FullScreenVideoView(Context context) {
        super(context);
    }
    //用于xml文件，支持自定属性
    public FullScreenVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    //用于xml文件，支持自定义属性，也支持style属性。
    public FullScreenVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //widthMeasureSpec 测量的是视频宽度
        //heightMeasureSpec 测量的是视频高度

        Log.d(TAG,"width: "+widthMeasureSpec+",height:"+heightMeasureSpec);


        //默认值为0，第二参数为测量数据。
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width,height);
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}

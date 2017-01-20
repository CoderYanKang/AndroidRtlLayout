package com.yankang.rtldemo;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

public class RTLViewPager extends ViewPager {

    // direction
    private boolean mIsRtlOriented;

    public RTLViewPager(Context context){
        this(context, null);
    }
    public RTLViewPager(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    //rtl 时设置当前页码  自定义属性修改更好
    public void setRtlOriented(boolean isRtlOriented){
        mIsRtlOriented = isRtlOriented;
        if(mIsRtlOriented && getAdapter() != null){
            setCurrentItem(getAdapter().getCount() - 1);
        }else{
            setCurrentItem(0);
        }
    }
}

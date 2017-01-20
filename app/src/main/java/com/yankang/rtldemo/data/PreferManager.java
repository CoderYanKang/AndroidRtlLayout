package com.yankang.rtldemo.data;

import android.content.Context;

import com.yankang.rtldemo.Constant;


/**
 * Preference manager
 */
public class PreferManager {

    private Prefer mZJPrefer;
    private static PreferManager sInstance;

    public static PreferManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (Prefer.class) {
                sInstance = new PreferManager(context);
            }
        }
        return sInstance;
    }

    public PreferManager(Context context)
    {
        mZJPrefer = Prefer.getInstance(context.getApplicationContext(), Constant.PREF_NAME);
    }

    /**
     * 语言环境
     * @return
     */
    public long getLangType()
    {
        return mZJPrefer.getLong(Constant.LANG_TYPE , Constant.LANG_ZH);
    }
    public void setLangType(int langCode)
    {
        mZJPrefer.putLong(Constant.LANG_TYPE , langCode);
    }
}

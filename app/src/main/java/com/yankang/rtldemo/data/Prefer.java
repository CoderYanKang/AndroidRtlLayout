package com.yankang.rtldemo.data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Manage SharedPreferences data
 */
public class Prefer {


    private static Prefer sInstance;
    private static SharedPreferences mPref;


    private Prefer(Context context, String spName) {
        mPref = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
    }


    public static Prefer getInstance(Context context, String spName) {
        if (sInstance == null) {
            synchronized (Prefer.class) {
                sInstance = new Prefer(context, spName);
            }
        }
        return sInstance;
    }


    /**
     * 存字符串
     * @param key    key
     * @param value  value
     */
    public void putString(String key, String value) {
        mPref.edit().putString(key, value).apply();
    }


    /**
     * 取字符串
     * @param key   key
     * @return      value
     */
    public String getString(String key) {
        return mPref.getString(key, "");
    }


    /**
     * 存boolean
     * @param key    key
     * @param value  value
     */
    public void putBoolean(String key, boolean value) {
        mPref.edit().putBoolean(key, value).apply();
    }


    /**
     * 取 boolean
     * @param key       key
     * @param defValue  default value
     * @return    boolean
     */
    public boolean getBoolean(String key, boolean defValue) {
        return mPref.getBoolean(key, defValue);
    }


    public void putLong(String key, long value) {
        mPref.edit().putLong(key, value).apply();
    }

    public long getLong(String key, long defaultValue) {
        return mPref.getLong(key, defaultValue);
    }

    /**
     * 删除 key
     * @param key   key
     */
    public static void remove(String key) {
        mPref.edit().remove(key).commit();
    }


    /**
     * 清空sp
     * @return  boolean
     */
    public static boolean clear() {
        return mPref.edit().clear().commit();
    }


}

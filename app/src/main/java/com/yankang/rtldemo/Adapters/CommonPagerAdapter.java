package com.yankang.rtldemo.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewPager Adapter
 * Created by zj on 15/11/16.
 */
public class CommonPagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> mFragments = new ArrayList<>();
    private final List<String> mFragmentTitles = new ArrayList<>();

    private boolean mIsRtlOrientated;

    public CommonPagerAdapter(FragmentManager fm , boolean mIsRtlOrientated) {

        super(fm);
        this.mIsRtlOrientated = mIsRtlOrientated;

    }


    public void addFragment(Fragment fragment, String title) {

        mFragments.add(fragment);
        mFragmentTitles.add(title);

    }

    public void clearFrgment(){
        mFragments.clear();
        mFragmentTitles.clear();
    }


    @Override
    public Fragment getItem(int position) {

        if (mIsRtlOrientated && mFragments.size() > 0) {
            return mFragments.get(mFragments.size() - position - 1);
        } else {
            return mFragments.get(position);
        }

    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if (mIsRtlOrientated && mFragmentTitles.size() > 0) {
            return mFragmentTitles.get(mFragmentTitles.size() - position - 1);
        } else {
            return mFragmentTitles.get(position);
        }
    }

}

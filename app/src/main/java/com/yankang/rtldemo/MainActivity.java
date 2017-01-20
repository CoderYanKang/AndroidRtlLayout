package com.yankang.rtldemo;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import com.yankang.rtldemo.Adapters.CommonPagerAdapter;
import com.yankang.rtldemo.data.PreferManager;

import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
{

    @Bind(R.id.act_tab)
    TabLayout actTab;
    @Bind(R.id.act_viewpager)
    RTLViewPager actViewpager;

    private CommonPagerAdapter adapter;

    private boolean isRtl = false;
    private PreferManager preferManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferManager = PreferManager.getInstance(this);
        setLang();

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView()
    {
        isRtl = preferManager.getLangType() == Constant.LANG_EN;
        adapter = new CommonPagerAdapter(getSupportFragmentManager() , isRtl);

        for (int i = 0 ; i < 3 ; i ++)
        {
            Fragment fragment = new TestFragment();
            adapter.addFragment(fragment , "标签" + i);
        }

        actTab.setupWithViewPager(actViewpager);
        actViewpager.setAdapter(adapter);
        actViewpager.setRtlOriented(isRtl);
    }

    @OnClick(R.id.change_lang)
    public void change()
    {
        if (preferManager.getLangType() == Constant.LANG_EN)
        {
            preferManager.setLangType(Constant.LANG_ZH);

        }else
        {
            preferManager.setLangType(Constant.LANG_EN);
        }
        startActivity(new Intent(this , MainActivity.class));
        finish();
    }

    private void setLang(){

        // 获得res资源对象
        Resources resources = getResources();
        // 获得设置对象
        Configuration config = resources.getConfiguration();
        DisplayMetrics dm = resources.getDisplayMetrics();

        if (preferManager.getLangType() != Constant.LANG_EN)
        {
            config.locale = Locale.SIMPLIFIED_CHINESE;

        }else
        {
            config.locale = Locale.US;
        }
        resources.updateConfiguration(config, dm);
    }
}

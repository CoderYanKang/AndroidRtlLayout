package com.yankang.rtldemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yankang.rtldemo.Adapters.CommonAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by yankang on 2017/1/20.
 */

public class TestFragment extends Fragment implements CommonAdapter.ICommonAdapter{

    @Bind(R.id.list)
    RecyclerView list;

    private CommonAdapter mAdapter;
    private ArrayList<String> mData = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_test, container, false);
        ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void initView()
    {
        mData.clear();
        mData.add("");
        mData.add("");
        mData.add("");
        mData.add("");
        mData.add("");
        mData.add("");


        mAdapter = new CommonAdapter(mData , R.layout.list_item , this);
        list.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.VERTICAL , false));
        list.setAdapter(mAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @Override
    public void onBindView(View rootView, SparseArray<View> views, CommonAdapter.ViewHolder viewHolder) {

    }

    @Override
    public void onShowItem(CommonAdapter.ViewHolder holder, int position) {

    }

    @Override
    public void onItemClick(View rootView, View v, int item) {

    }


}

package com.yankang.rtldemo.Adapters;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 通用 Adapter
 * Created by yankang on 15/11/14.
 */
public class CommonAdapter<T> extends RecyclerView.Adapter<CommonAdapter.ViewHolder> {

    public void setRecycle(boolean recycle)
    {
        isRecycle = recycle;
    }

    public  boolean isRecycle = true;
    public interface ICommonAdapter {

        /**
         * bind view for view holder
         * @param rootView  root view of view holder
         * @param views  view map
         * @param viewHolder  holder
         */
        void onBindView(View rootView, SparseArray<View> views, ViewHolder viewHolder);

        /**
         * show item, onBindViewHolder
         * @param holder     view holder
         * @param position   position
         */
        void onShowItem(ViewHolder holder, int position);


        void onItemClick(View rootView, View v, int item);

    }


    private int mLayoutRes;
    private List<T> mDataSet;
    private ICommonAdapter mCallback;

    public CommonAdapter(List<T> dataSet, int layoutRes,
                         ICommonAdapter callback) {
        mLayoutRes = layoutRes;
        mDataSet = dataSet;
        mCallback = callback;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(mLayoutRes, parent, false);

        return new ViewHolder(view, mCallback);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (!isRecycle)
            holder.setIsRecyclable(false);

        holder.mItem = position;
        mCallback.onShowItem(holder, position);

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    @Override
    public long getItemId(int position) {

        return super.getItemId(position);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {

        public int mItem;
        private View mRootView;
        private ICommonAdapter mListener;
        private final SparseArray<View> mViewMap = new SparseArray<>();

        public ViewHolder(View view, ICommonAdapter listener) {
            super(view);
            mRootView = view;
            mListener = listener;
            mListener.onBindView(mRootView, mViewMap, this);
        }


        public View getView(int resId) {
            return mViewMap.get(resId);
        }


        @Override
        public void onClick(View v) {
            mListener.onItemClick(mRootView, v, mItem);
        }
    }

}

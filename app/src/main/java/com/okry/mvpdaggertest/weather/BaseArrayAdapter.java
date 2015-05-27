package com.okry.mvpdaggertest.weather;

import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by marui on 13-10-15.
 * BaseAdapter类封装，提供一个ArrayList保存数据，提供动态修改数据的方法
 */
public abstract class BaseArrayAdapter<T> extends BaseAdapter {

    private List<T> mList;

    public BaseArrayAdapter() {
        mList = new ArrayList<T>();
    }

    @Override
    public int getCount() {
        if (mList == null) {
            return 0;
        }

        return mList.size();
    }

    @Override
    public T getItem(int position) {
        if (position < 0 || position >= mList.size()) {
            return null;
        }
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void add(T item) {
        mList.add(item);
        notifyDataSetChanged();
    }

    public void add(int index, T item) {
        mList.add(index, item);
        notifyDataSetChanged();
    }

    public void addAll(Collection<T> array) {
        mList.addAll(array);
        notifyDataSetChanged();
    }

    public void set(List<T> list) {
        mList = list;
        notifyDataSetChanged();
    }

    public void remove(T item) {
        mList.remove(item);
        notifyDataSetChanged();
    }

    public void remove(int i) {
        if (i < 0 || i >= mList.size()) {
            return;
        }
        mList.remove(i);
        notifyDataSetChanged();
    }

    public void clear() {
        mList.clear();
        notifyDataSetChanged();
    }

}

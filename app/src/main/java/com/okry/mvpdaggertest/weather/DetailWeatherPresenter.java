package com.okry.mvpdaggertest.weather;

import android.util.Log;

import com.okry.mvpdaggertest.mvp.MvpView;
import com.okry.mvpdaggertest.weather.IWeatherCenter.OnWeatherChangeListener;

import javax.inject.Inject;

/**
 * Created by mr on 15/5/8.
 */
public class DetailWeatherPresenter implements IWeatherPresenter, OnWeatherChangeListener {

    IWeatherDetailView mWeatherView;

    // 表示WeatherCenter是由依赖注入实例化
    IWeatherCenter mWeatherCenter;

    @Inject
    DetailWeatherPresenter(IWeatherCenter weatherCenter) {
        mWeatherCenter = weatherCenter;
        mWeatherCenter.setOnWeatherChangeListener(this);
        Log.d("initial", "DetailWeatherPresenter initial");
    }

    @Override
    public void onWeatherChange() {
        if(mWeatherView != null) {
            mWeatherView.showTemp(mWeatherCenter.getTemp());
        }
    }

    @Override
    public void attachView(MvpView view) {
        mWeatherView = (IWeatherDetailView) view;
        mWeatherView.showTemp(mWeatherCenter.getTemp());
        mWeatherView.showCloud(mWeatherCenter.getCloudDirection(), mWeatherCenter.getCloudValue());
        mWeatherView.showHumidity("h" + mWeatherCenter.getHumidity());
    }

    @Override
    public void detachView() {
        mWeatherView = null;
    }

    @Override
    public void startWeatherDetect() {
        mWeatherCenter.startMonitoring();
    }

    @Override
    public void stopWeatherDetect() {
        mWeatherCenter.stopMonitoring();
    }
}

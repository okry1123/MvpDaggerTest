package com.okry.mvpdaggertest.weather;

import com.okry.mvpdaggertest.mvp.MvpView;
import com.okry.mvpdaggertest.weather.ChinaWeatherCenter.OnWeatherChangeListener;

import javax.inject.Inject;

/**
 * Created by mr on 15/5/8.
 */
public class BaseWeatherPresenter implements IWeatherPresenter, OnWeatherChangeListener {

    IWeatherView mWeatherView;

    ChinaWeatherCenter mWeatherCenter;

    BaseWeatherPresenter() {
        mWeatherCenter = new ChinaWeatherCenter();
        mWeatherCenter.setOnWeatherChangeListener(this);
    }

    @Override
    public void onWeatherChange() {
        if(mWeatherView != null) {
            mWeatherView.showTemp(mWeatherCenter.getTemp());
        }
    }

    @Override
    public void attachView(MvpView view) {
        mWeatherView = (IWeatherView) view;
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

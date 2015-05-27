package com.okry.mvpdaggertest.weather;

import com.okry.mvpdaggertest.mvp.MvpPresenter;
import com.okry.mvpdaggertest.mvp.MvpView;

import javax.inject.Inject;

/**
 * Created by mr on 15/5/27.
 */
public class WeatherListPresenter implements MvpPresenter {

    @Inject
    IWeatherCenter mWeatherCenter;

    IWeatherListView mWeatherListView;

    @Inject
    WeatherListPresenter() {
    }

    @Override
    public void attachView(MvpView view) {
        mWeatherListView = (IWeatherListView) view;
        mWeatherListView.showWeatherList(mWeatherCenter.getNextTemp());
    }

    @Override
    public void detachView() {
        mWeatherListView = null;
    }
}

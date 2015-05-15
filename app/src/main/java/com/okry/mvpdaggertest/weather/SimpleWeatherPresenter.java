package com.okry.mvpdaggertest.weather;

import android.util.Log;

import com.okry.mvpdaggertest.mvp.MvpPresenter;
import com.okry.mvpdaggertest.mvp.MvpView;

import javax.inject.Inject;

/**
 * Created by mr on 15/5/14.
 */
public class SimpleWeatherPresenter implements MvpPresenter {

    IWeatherSimpleView mView;

    private final IWeatherCenter mWeatherCenter;

    @Inject
    SimpleWeatherPresenter(IWeatherCenter weatherCenter) {
        Log.d("initial", "SimpleWeatherPresenter initial");
        mWeatherCenter = weatherCenter;
    }

    @Override
    public void attachView(MvpView view) {
        mView = (IWeatherSimpleView) view;
        mView.showSimpleWeather("T:" + mWeatherCenter.getTemp() + ", H:" + mWeatherCenter.getHumidity());
    }

    @Override
    public void detachView() {
        mView = null;
    }
}

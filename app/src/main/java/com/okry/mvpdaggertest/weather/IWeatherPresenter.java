package com.okry.mvpdaggertest.weather;

import com.okry.mvpdaggertest.mvp.MvpPresenter;

/**
 * Created by mr on 15/5/8.
 */
public interface IWeatherPresenter extends MvpPresenter {

    public void startWeatherDetect();

    public void stopWeatherDetect();

}

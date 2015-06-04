package com.okry.mvpdaggertest.weather;

import com.okry.mvpdaggertest.mvp.MvpView;

/**
 * Created by mr on 15/5/8.
 */
public interface IWeatherView extends MvpView {

    public void showTemp(int temp);

    public void showCloud(String cloudDirection, int cloud);

    public void showHumidity(String humidity);
}

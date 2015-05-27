package com.okry.mvpdaggertest.weather;

import com.okry.mvpdaggertest.mvp.MvpView;

import java.util.List;

/**
 * Created by mr on 15/5/27.
 */
public interface IWeatherListView extends MvpView {

    public void showWeatherList(List<Integer> weatherList);

}

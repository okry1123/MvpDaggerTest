package com.okry.mvpdaggertest.weather;

import com.okry.mvpdaggertest.mvp.MvpModel;

/**
 * Created by mr on 15/5/8.
 */
public interface IWeatherCenter extends MvpModel {

    public int getTemp();

    public String getCloudDirection();

    public int getCloudValue();

    public String getHumidity();

    public void setOnWeatherChangeListener(OnWeatherChangeListener listener);

    public void startMonitoring();

    public void stopMonitoring();

    public interface OnWeatherChangeListener {
        public void onWeatherChange();
    }

}
package com.okry.mvpdaggertest.weather;

import com.okry.mvpdaggertest.mvp.MvpModel;

import java.util.List;

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

    /**
     * get future 24 hour temp
     *
     * @return
     */
    public List<Integer> getNextTemp();

    public interface OnWeatherChangeListener {
        public void onWeatherChange();
    }

}
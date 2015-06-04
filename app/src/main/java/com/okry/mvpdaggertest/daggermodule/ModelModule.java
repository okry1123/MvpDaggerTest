package com.okry.mvpdaggertest.daggermodule;

import com.okry.mvpdaggertest.weather.ChinaWeatherCenter;
import com.okry.mvpdaggertest.weather.IWeatherCenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mr on 15/5/14.
 */
@Module
public class ModelModule {

    @Provides
    @Singleton
    IWeatherCenter provideWeatherCenter() {
        return new ChinaWeatherCenter();
    }

}

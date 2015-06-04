package com.okry.mvpdaggertest.daggermodule;

import com.okry.mvpdaggertest.weather.IWeatherPresenter;
import com.okry.mvpdaggertest.weather.SimpleWeatherPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mr on 15/5/14.
 */
@Module(includes = ModelModule.class)
public class PresenterModule {

    @Provides
    IWeatherPresenter provideWeatherPresenter(SimpleWeatherPresenter presenter) {
        return presenter;
    }

}

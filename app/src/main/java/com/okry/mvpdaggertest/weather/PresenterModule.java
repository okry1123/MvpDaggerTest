package com.okry.mvpdaggertest.weather;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mr on 15/5/14.
 */
@Module(injects = {WeatherFragment.class},
        includes = ModelModule.class)
public class PresenterModule {

    @Provides
    IWeatherPresenter provideWeaterhPresenter(DetailWeatherPresenter presenter) {
        return presenter;
    }

}

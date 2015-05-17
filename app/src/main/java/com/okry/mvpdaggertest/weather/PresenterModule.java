package com.okry.mvpdaggertest.weather;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mr on 15/5/14.
 */
@Module(includes = ModelModule.class)
public class PresenterModule {

    @Provides
    IWeatherPresenter provideWeatherPresenter(DetailWeatherPresenter presenter) {
        return presenter;
    }

}

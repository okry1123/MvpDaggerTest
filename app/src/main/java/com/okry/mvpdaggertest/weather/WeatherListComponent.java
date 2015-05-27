package com.okry.mvpdaggertest.weather;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mr on 15/5/27.
 */
@Component(modules = ModelModule.class)
@Singleton
public interface WeatherListComponent {
    public void inject(WeatherListFragment f);
}

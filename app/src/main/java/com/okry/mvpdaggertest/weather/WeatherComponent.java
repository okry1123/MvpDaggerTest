package com.okry.mvpdaggertest.weather;

import com.okry.mvpdaggertest.daggermodule.PresenterModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mr on 15/5/15.
 */
@Component(modules = PresenterModule.class)
@Singleton
interface WeatherComponent {
    void inject(WeatherFragment f);// 参数表示需要注入的类，不支持继承，如不能用Fragment替代WeatherFragment
}

package com.okry.mvpdaggertest.weather;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.okry.mvpdaggertest.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by mr on 15/5/8.
 */
public class WeatherFragment extends Fragment implements IWeatherDetailView, IWeatherSimpleView {

    @InjectView(R.id.temp_value)
    TextView tempView;
    @InjectView(R.id.cloud_value)
    TextView cloudView;
    @InjectView(R.id.humidity_value)
    TextView humidityView;
    @InjectView(R.id.simple_text)
    TextView simpleView;

    @Inject
    IWeatherPresenter mPresenter;
    @Inject
    SimpleWeatherPresenter mSimpleWeatherPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerWeatherComponent.create().inject(this);
        mPresenter.toString();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, null);
        ButterKnife.inject(this, view);
        mPresenter.attachView(this);
        mSimpleWeatherPresenter.attachView(this);
        return view;
    }

    @Override
    public void onDestroyView() {
        mPresenter.detachView();
        mPresenter.stopWeatherDetect();
        super.onDestroyView();
    }

    @Override
    public void showTemp(int temp) {
        tempView.setText(String.valueOf(temp));
    }

    @Override
    public void showCloud(String cloudDirection, int cloud) {
        cloudView.setText(cloudDirection + cloud);
    }

    @Override
    public void showHumidity(String humidity) {
        humidityView.setText(humidity);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.stopWeatherDetect();
    }

    @OnClick(R.id.start)
    void start() {
        mPresenter.startWeatherDetect();
    }

    @Override
    public void showSimpleWeather(String text) {
        simpleView.setText(text);
    }
}

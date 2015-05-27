package com.okry.mvpdaggertest.weather;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.okry.mvpdaggertest.R;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by mr on 15/5/8.
 */
public class WeatherListFragment extends Fragment implements IWeatherListView {

    @InjectView(R.id.weather_list)
    ListView mListView;

    @Inject
    WeatherListPresenter mPresenter;

    private WeatherListAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerWeatherListComponent.builder().modelModule(new ModelModule()).build().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = View.inflate(getActivity(), R.layout.fragment_weather_list, null);
        ButterKnife.inject(this, root);
        mAdapter = new WeatherListAdapter();
        mListView.setAdapter(mAdapter);
        mPresenter.attachView(this);
        return root;
    }

    @Override
    public void onDestroyView() {
        mPresenter.detachView();
        super.onDestroyView();
    }

    @Override
    public void showWeatherList(List<Integer> weatherList) {
        mAdapter.set(weatherList);
    }
}

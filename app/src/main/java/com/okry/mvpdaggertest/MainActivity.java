package com.okry.mvpdaggertest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_content);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.b1)
    public void gotoBoard() {
        Intent i = new Intent(this, WeatherBoardActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.b2)
    public void gotoList() {
        Intent i = new Intent(this, WeatherListActivity.class);
        startActivity(i);
    }
}

package com.okry.mvpdaggertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button b = new Button(this);
        b.setOnClickListener(this);
        b.setText("Click Goto Weather Board");
        setContentView(b);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, WeatherBoardActivity.class);
        startActivity(i);
    }
}

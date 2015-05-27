package com.okry.mvpdaggertest.weather;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.okry.mvpdaggertest.R;

/**
 * Created by mr on 15/5/27.
 */
public class WeatherListAdapter extends BaseArrayAdapter<Integer> {

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = View.inflate(viewGroup.getContext(), R.layout.weather_item_view, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        holder = (ViewHolder) view.getTag();
        holder.hour.setText("next " + i + " hour:");
        holder.temp.setText(String.valueOf(getItem(i)));
        return view;
    }

    private static final class ViewHolder {

        public TextView hour;
        public TextView temp;

        ViewHolder(View item) {
            hour = (TextView) item.findViewById(R.id.weather_item_hour);
            temp = (TextView) item.findViewById(R.id.weather_item_temp);
        }

    }
}

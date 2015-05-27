package com.okry.mvpdaggertest.weather;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mr on 15/5/8.
 */
public class ChinaWeatherCenter implements IWeatherCenter {

    private OnWeatherChangeListener mWeatherListener;
    private Thread mMonitorThread;
    private boolean mIsRunning;

    private byte[] meaninglessHugeMemory = new byte[2 * 1024 * 1024];

    ChinaWeatherCenter() {
        Log.d("initial", "ChinaWeatherCenter initial");
    }

    @Override
    public void startMonitoring() {
        if(mMonitorThread == null || !mMonitorThread.isAlive() || !mIsRunning) {
            mIsRunning = true;
            mMonitorThread = new SelfChangeWeatherThread();
            mMonitorThread.start();
        }
    }

    @Override
    public void stopMonitoring() {
        mIsRunning = false;
    }

    @Override
    public List<Integer> getNextTemp() {
        int next = 24;
        List<Integer> nextTemp = new ArrayList<>();
        for (int i = 0; i < next; i++) {
            int temp = (int) (Math.random() * 30);
            nextTemp.add(temp);
        }
        return nextTemp;
    }

    @Override
    public int getTemp() {
        return (int) (45 * Math.random()) - 10;
    }

    @Override
    public String getCloudDirection() {
        return "West";
    }

    @Override
    public int getCloudValue() {
        return (int) (9 * Math.random());
    }

    @Override
    public String getHumidity() {
        return this.toString();
    }

    public void setOnWeatherChangeListener(OnWeatherChangeListener listener) {
        mWeatherListener = listener;
    }


    private final class SelfChangeWeatherThread extends Thread{

        private Handler mMainHandler;

        SelfChangeWeatherThread() {
            mMainHandler = new Handler(Looper.getMainLooper());
        }

        @Override
        public void run() {
            while(mIsRunning) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mMainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (mWeatherListener != null) {
                            mWeatherListener.onWeatherChange();
                        }
                    }
                });
            }
        }
    }
}

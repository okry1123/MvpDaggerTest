package com.okry.mvpdaggertest.weather;

import android.os.Handler;
import android.os.Looper;

import javax.inject.Inject;

/**
 * Created by mr on 15/5/8.
 */
public class ChinaWeatherCenter implements IWeatherCenter {

    private OnWeatherChangeListener mWeatherListener;
    private Thread mMonitorThread;
    private boolean mIsRunning;

    ChinaWeatherCenter(){

    }

    public void startMonitoring() {
        if(mMonitorThread == null || !mMonitorThread.isAlive() || !mIsRunning) {
            mIsRunning = true;
            mMonitorThread = new SelfChangeWeatherThread();
            mMonitorThread.start();
        }
    }

    public void stopMonitoring() {

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
    public int getHumidity() {
        return 0;
    }

    public interface OnWeatherChangeListener {
        public void onWeatherChange();
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

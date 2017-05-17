package com.example.customview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadActivity extends AppCompatActivity {

    private static final String TAG = ThreadActivity.class.getSimpleName();
    ExecutorService fixedThreadPool;
    ExecutorService cachedThreadPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        int threadCount = Runtime.getRuntime().availableProcessors();
        Log.i(TAG, "threadCount: " + threadCount);
        fixedThreadPool = Executors.newFixedThreadPool(threadCount);
        cachedThreadPool = Executors.newCachedThreadPool();
        RippleBackground rippleBackground = (RippleBackground) findViewById(R.id.ripple_scan);
        rippleBackground.startRippleAnimation();
    }

    public void newFixedThreadPool(View view) {

        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    String threadName = Thread.currentThread().getName();
                    Log.i(TAG, "线程： " + threadName + " ,正在执行任务" + index);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void newCachedThreadPool(View view) {
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    String threadName = Thread.currentThread().getName();
                    Log.i(TAG, "线程： " + threadName + " ,正在执行任务" + index);
                    try {
                        long time = index * 500;
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}

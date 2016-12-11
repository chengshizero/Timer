package com.example.administrator.timer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Timer timer;
    private TimerTask task;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//               tv.setText("haha");
//            }
//        },2000);

        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText("cccc");
                    }
                });
            }
        };
        timer.schedule(task,2000,1000);
    }

    @Override
    protected void onDestroy() {
        timer.cancel();
        task.cancel();
        super.onDestroy();
    }
}

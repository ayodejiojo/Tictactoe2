package com.example.lola.tictactoe;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    private  int SPLASH_TIMER =4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        LogLauncher logLauncher = new LogLauncher();
        logLauncher.start();

    }

    private class LogLauncher extends Thread{
        public void run(){
            try{
                sleep(1000 * SPLASH_TIMER);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            SplashActivity.this.finish();

        }
    }
}

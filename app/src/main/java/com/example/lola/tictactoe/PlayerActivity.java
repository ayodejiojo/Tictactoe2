package com.example.lola.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
    }

    public void twoPlayer(View view){
        Intent intent = new Intent(PlayerActivity.this,TwoPlayerActivity.class);
        startActivity(intent);
    }

    public void singlePlayer(View view){
        Intent i = new Intent(PlayerActivity.this,SinglePlayerActivity.class);
        startActivity(i);
    }
    public  void twoPlayerFive(View view){
        Intent r = new Intent(PlayerActivity.this,TwoPlayer2Activity.class);
        startActivity(r);
    }
    public void singlePlayerFive(View view){
        Intent f = new Intent(PlayerActivity.this,Single2Activity.class);
        startActivity(f);
    }
}

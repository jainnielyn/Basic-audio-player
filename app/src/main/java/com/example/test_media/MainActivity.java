package com.example.test_media;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMediaPlayer = MediaPlayer.create(this, R.raw.shake);
    }

    public void play(View view){
        mMediaPlayer.start();
    }

    public void pause(View view){
        mMediaPlayer.pause();
    }

    @Override
    public void onBackPressed() {
        mMediaPlayer.release();
        mMediaPlayer = null;
        super.onBackPressed();
    }

    public void forward(View view){
        int curr = mMediaPlayer.getCurrentPosition();
        mMediaPlayer.seekTo(curr+10000);
    }

    public void back(View view){
        int curr = mMediaPlayer.getCurrentPosition();
        mMediaPlayer.seekTo(curr-10000);
    }
}

package com.android.androidsplash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.androidsplash.databinding.ActivitySplashBinding;

import java.io.File;

public class AndroidSplash extends AppCompatActivity {

    private ActivitySplashBinding binding;
    private CustomCountDownTimer timer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        //获得layout的根元素。
        View view = binding.getRoot();
        setContentView(view);

        binding.vvPlay.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.video1));
        //调用该方法可以检测视频是否准备好了，
        binding.vvPlay.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        binding.vvPlay.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
        timer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICustomCountDownTimer() {
            @Override
            public void onTicker(int time) {
                String t = time + "秒";
                binding.tvSplash.setText(t);
            }

            @Override
            public void finish() {
                binding.tvSplash.setText("跳过");
            }
        });
        timer.start();

        binding.tvSplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AndroidSplash.this,MainActivity.class));
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}

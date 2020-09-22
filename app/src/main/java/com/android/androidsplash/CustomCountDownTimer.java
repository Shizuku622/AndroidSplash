package com.android.androidsplash;


import android.os.Handler;

public class CustomCountDownTimer implements Runnable{

    private int time;
    private final ICustomCountDownTimer iCCDT;
    private final Handler handler;
    private Boolean isRun;


    public CustomCountDownTimer(int time, ICustomCountDownTimer timer){
        handler = new Handler();
        this.time = time;
        this.iCCDT = timer;

    }

    @Override
    public void run() {
        if(isRun){
            //检测接口实例是否为空
            if(iCCDT != null){
                iCCDT.onTicker(time);
            }

            if(time == 0){
                cancel();
                if(iCCDT != null){
                    iCCDT.finish();
                }
            }else {
                time--;
                handler.postDelayed(this,1000);
            }

        }
    }

    public void start(){
        isRun = true;
        handler.post(this);
    }

    public void cancel(){
        isRun = false;
        handler.removeCallbacks(this);
    }


    public interface ICustomCountDownTimer{
        void onTicker(int time);
        void finish();
    }


}

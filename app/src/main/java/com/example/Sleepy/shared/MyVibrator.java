package com.example.Sleepy.shared;

import static android.content.Context.VIBRATOR_SERVICE;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

public class MyVibrator{

    public static void vibrate(long ms, Context context){
        if(new MyPreferences.SettingsApp(context).isVibrated()){
            if (Build.VERSION.SDK_INT >= 26) {
                ((Vibrator) context.getSystemService(VIBRATOR_SERVICE))
                        .vibrate(VibrationEffect.createOneShot(ms, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                ((Vibrator) context.getSystemService(VIBRATOR_SERVICE)).vibrate(ms);
            }
        }
    }

    public static void vibrateAlarm(Context context, int repeat){
        ((Vibrator) context.getSystemService(VIBRATOR_SERVICE)).vibrate(new long[] { 1000, 1000, 1000, 1000, 1000 }, repeat);
    } //TODO реализовать
}
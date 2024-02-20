/*
Created By Cavin (https://github.com/Killercavin)
Date : 20/02/2024
 */

package com.example.helloworld;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;
import android.util.Log;

public class MyService extends Service {
    String msg = "Android : ";
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
        Log.d(msg, "The Service onStartCommand() event");
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The service onDestroy() event");
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }
}
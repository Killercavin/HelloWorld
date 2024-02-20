/*
Created By Cavin (https://github.com/Killercavin)
Date : 20/02/2024
 */

package com.example.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.content.Intent;
import android.view.View;


public class MainActivity extends Activity {
    String msg = "Android : ";

    /** Called when the activity, service is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(msg, "The onCreate() event");
        Log.d(msg, "The Activity onCreate() event"); /* Service onCreate **/
    }

    /** Called when the activity is about to become visible. */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() event");
    }

    /** Called when the activity has become visible. */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event");
    }

    /** Called when another activity is taking focus. */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event");
    }

    /** Called when the activity is no longer visible. */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event");
    }

    /** Called just before the activity is destroyed. */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }

    // Service start method/function
    public void startService(View view) {
        startService(new Intent(getBaseContext(), MyService.class));
        Log.d(msg, "The startService() event");
    }

    // Method to stop the service
    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), MyService.class));
        Log.d(msg, "The stopService() event");
    }

    public void broadcastIntent(View view){
        Intent intent = new Intent();
        intent.setAction("com.example.CUSTOM_INTENT"); sendBroadcast(intent);
    }


}

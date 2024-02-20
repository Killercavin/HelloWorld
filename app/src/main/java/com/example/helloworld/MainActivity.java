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
import android.net.Uri;
import android.content.ContentValues;
import android.database.Cursor;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    String msg = "Android: ";

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

    public void broadcastIntent(View view) {
        Intent intent = new Intent();
        intent.setAction("com.example.CUSTOM_INTENT");
        sendBroadcast(intent);
    }

    public void onClickAddName(View view) {
        // Add a new student record
        ContentValues values = new ContentValues();
        values.put(StudentsProvider.NAME, ((EditText) findViewById(R.id.editText2)).getText().toString());
        values.put(StudentsProvider.GRADE, ((EditText) findViewById(R.id.editText3)).getText().toString());

        // Use the correct CONTENT_URI from StudentsProvider
        Uri uri = getContentResolver().insert(StudentsProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_LONG).show();
    }

    /* public void onClickRetrieveStudents(View view) {
        // Retrieve student records
        // Use the correct CONTENT_URI from StudentsProvider
        Uri students = StudentsProvider.CONTENT_URI;
        Cursor c = getContentResolver().query(students, null, null, null, "name");

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    Toast.makeText(this,
                            c.getString(c.getColumnIndex(StudentsProvider._ID)) +
                                    ", " + c.getString(c.getColumnIndex(StudentsProvider.NAME)) +
                                    ", " + c.getString(c.getColumnIndex(StudentsProvider.GRADE)),
                            Toast.LENGTH_SHORT).show();
                } while (c.moveToNext());
            }
            c.close(); // Close the cursor when done
        }
    } */
    // I have a problem with fixing the Retrieve code
}

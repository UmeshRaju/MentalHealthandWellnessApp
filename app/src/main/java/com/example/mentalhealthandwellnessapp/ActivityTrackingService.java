package com.example.mentalhealthandwellnessapp;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class ActivityTrackingService extends Service implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private int stepCount = 0;

    private static final int SENSOR_DELAY_MICROS = 500 * 1000; // 500ms

    @Override
    public void onCreate() {
        super.onCreate();
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startAccelerometerTracking();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopAccelerometerTracking();
    }

    private void startAccelerometerTracking() {
        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SENSOR_DELAY_MICROS);
        } else {
            Toast.makeText(this, "Accelerometer not available on this device", Toast.LENGTH_SHORT).show();
            stopSelf();
        }
    }

    private void stopAccelerometerTracking() {
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float[] values = event.values;
            float x = values[0];
            float y = values[1];
            float z = values[2];

            // Use your algorithm to determine steps based on accelerometer data
            // Here, a simple step detection is demonstrated for illustrative purposes
            if (Math.sqrt(x * x + y * y + z * z) > 12) {
                // Threshold for step detection, adjust as needed
                stepCount++;
                notifyUserWithStepCount(stepCount);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // not used in this case
    }


    private void logUserSteps() {
        int userSteps = 0;
        Log.d("UserSteps", "User steps: " + userSteps);
        // Increment the user steps for demonstration purposes
        userSteps += 100;
    }
    private void notifyUserWithStepCount(int steps) {
        // Provide feedback or store the step count as needed
        // In this example, a Toast notification is used
        Toast.makeText(this, "Steps: " + steps, Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"current steps :"+0,Toast.LENGTH_SHORT).show();
    }

}

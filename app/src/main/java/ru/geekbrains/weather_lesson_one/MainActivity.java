package ru.geekbrains.weather_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String TAG = "WeatherApp";
    String[] cities = {"City_1", "City_2", "City_3", "City_4", "City_5"};
    ArrayAdapter<String> adapter;
    Spinner citySpinnerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        citySpinnerView = findViewById(R.id.spinner);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinnerView.setAdapter(adapter);

        Toast.makeText(this, "Created", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Created: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Started", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Started: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Resumed", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Resumed: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Paused: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Stopped", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Stopped: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Restarted", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Restarted: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Destroyed", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "Destroyed: ");
    }
    
}
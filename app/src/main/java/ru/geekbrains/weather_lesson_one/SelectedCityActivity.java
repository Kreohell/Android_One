package ru.geekbrains.weather_lesson_one;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SelectedCityActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_in_selected_city);
        setCity();
    }

    private void setCity(){
        TextView textView = findViewById(R.id.textView2);
        Bundle cityText = getIntent().getExtras();
        if(cityText != null){
            String name = cityText.get("name").toString();
            textView.setText(name);
        }
    }

}

package ru.geekbrains.weather_lesson_one.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import ru.geekbrains.weather_lesson_one.R;
import ru.geekbrains.weather_lesson_one.RecyclerDataAdapter;
import ru.geekbrains.weather_lesson_one.SelectedWeather;

public class ShowCityFragment extends Fragment {
    public final static String TAG = "ru.geekbrains.weather_lesson_one.ShowCityFragment";
    public final static String KEY = "text";
    private RecyclerView showCityRecyclerView;
    private RecyclerDataAdapter adapter;
    ArrayList<SelectedWeather> selectedWeathers = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        createWeatherList();
        View view = inflater.inflate(R.layout.fragment_show_city, container, false);
        showCityRecyclerView = view.findViewById(R.id.selectedCityRecyclerView);
        adapter = new RecyclerDataAdapter(selectedWeathers);
        showCityRecyclerView.setAdapter(adapter);

        TextView textView = view.findViewById(R.id.textView2);
        assert getArguments() != null;
        String textFromActivity = getArguments().getString(KEY);
        textView.setText(textFromActivity);
        return view;
    }

    private void createWeatherList() {
        selectedWeathers.add(new SelectedWeather("Day1", "temperature1"));
        selectedWeathers.add(new SelectedWeather("Day2", "temperature2"));
        selectedWeathers.add(new SelectedWeather("Day3", "temperature3"));
        selectedWeathers.add(new SelectedWeather("Day4", "temperature4"));
        selectedWeathers.add(new SelectedWeather("Day5", "temperature5"));
    }


}
package ru.geekbrains.weather_lesson_one.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.geekbrains.weather_lesson_one.R;

public class ShowCityFragment extends Fragment {
    public final static String TAG = "ru.geekbrains.weather_lesson_one.ShowCityFragment";
    public final static String KEY = "text";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_city, container, false);
        TextView textView = view.findViewById(R.id.textView2);
        assert getArguments() != null;
        String textFromActivity = getArguments().getString(KEY);
        textView.setText(textFromActivity);
        return view;
    }
}
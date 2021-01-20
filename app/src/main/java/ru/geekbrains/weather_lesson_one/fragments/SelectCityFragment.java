package ru.geekbrains.weather_lesson_one.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import ru.geekbrains.weather_lesson_one.R;
import ru.geekbrains.weather_lesson_one.SelectCityListener;


public class SelectCityFragment extends Fragment {

    public static final String KEY = "some";
    private int currentPosition = 0;
    private SelectCityListener selectCityListener;
    private EditText cityNameText;
    private Button findBtn;
    String[] cities = {"City_1", "City_2", "City_3", "City_4", "City_5"};
    ArrayAdapter<String> adapter;
    Spinner citySpinnerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_city, container, false);
        cityNameText = view.findViewById(R.id.editText2);
        findBtn = view.findViewById(R.id.button);

        findBtn.setOnClickListener(v -> {
            String s = cityNameText.getText().toString();
            selectCityListener.onOpenFragmentWeatherMain(s);
        });
        setRetainInstance(true);
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof SelectCityListener){
            selectCityListener = (SelectCityListener) context;
        }else {
            throw new RuntimeException(context.toString());
        }
    }
}
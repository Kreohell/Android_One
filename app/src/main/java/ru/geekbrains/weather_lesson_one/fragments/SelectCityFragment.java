package ru.geekbrains.weather_lesson_one.fragments;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;

import ru.geekbrains.weather_lesson_one.R;
import ru.geekbrains.weather_lesson_one.SelectCityListener;
import ru.geekbrains.weather_lesson_one.model.WeatherRequest;


public class SelectCityFragment extends Fragment {

    private SelectCityListener selectCityListener;
    private TextInputEditText cityNameText;
    private MaterialButton findBtn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_city, container, false);
        cityNameText = view.findViewById(R.id.inputTextFindCity);
        findBtn = view.findViewById(R.id.btnFindCity);

        findBtn.setOnClickListener(v -> {
            String s = Objects.requireNonNull(cityNameText.getText()).toString();
            Snackbar.make(view, "Finding city...", Snackbar.LENGTH_SHORT)
                    .show();
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
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





//    TextView cityText;
//
//    static ShowCityFragment create(WeatherContainer container){
//        ShowCityFragment fragment = new ShowCityFragment();    // создание
//
//        // Передача параметра
//        Bundle args = new Bundle();
//        args.putSerializable("index", container);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    String getCityName() {
//        WeatherContainer coatContainer = (WeatherContainer) (Objects.requireNonNull(getArguments())
//                .getSerializable("index"));
//        try {
//            return coatContainer.cityName;
//        } catch (Exception e) {
//            return "";
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_show_city, container, false);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        initViews(view);
//    }
//
//    private void initViews(View view) {
//        cityText = view.findViewById(R.id.textView2);
//      }

}
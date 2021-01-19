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

    private boolean isExist;
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
//        checkBoxSpeedWing = view.findViewById(R.id.cbWindSpeed);

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

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        initViews(view);
//
////        findBtn.setOnClickListener(v -> {
////            EditText cityNameText = v.findViewById(R.id.editText2);
////            String name = cityNameText.getText().toString();
////            Intent intent = new Intent(SelectCityFragment.this, ShowCityFragment.class);
////            intent.putExtra("name", name);
////            startActivity(intent);
////        });
//    }
//
//    @Override
//    public void onActivityCreated(Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        isExist = getResources().getConfiguration().orientation
//                == Configuration.ORIENTATION_LANDSCAPE;
//        if (savedInstanceState != null) {
//
//            currentPosition = savedInstanceState.getInt("CurrentCity", 0);
//        }
//        if (isExist) {
//            showCity();
//        }
//    }
//
//    private void initViews(View view) {
//        cityNameText = view.findViewById(R.id.editText2);
//        findBtn = view.findViewById(R.id.button);
//        citySpinnerView = view.findViewById(R.id.spinner);
//    }
//
//    private void showCity(){
//        if(isExist) {
//            ShowCityFragment detail = (ShowCityFragment)
//                    getFragmentManager().findFragmentById(R.id.weather_in_city);
//            if (detail == null) {
//                detail = ShowCityFragment.create(getWeatherContainer());
//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                ft.replace(R.id.weather_in_city, detail);
//                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//                //ft.addToBackStack(null);
//                ft.addToBackStack("Some_Key");
//                ft.commit();
//            }
//        }  else {
//        Intent intent = new Intent();
//        intent.setClass(getActivity(), ShowCityFragment.class);
//        // и передадим туда параметры
////        intent.putExtra("index", getCoatContainer());
//        startActivity(intent);
//    }
//
//    }
//
//    private WeatherContainer getWeatherContainer() {
//        WeatherContainer container = new WeatherContainer();
//        container.position = currentPosition;
//        container.cityName = cities[currentPosition];
//        return container;
//    }

}
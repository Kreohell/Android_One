package ru.geekbrains.weather_lesson_one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;

import android.widget.ArrayAdapter;

import android.widget.Spinner;


import ru.geekbrains.weather_lesson_one.fragments.SelectCityFragment;
import ru.geekbrains.weather_lesson_one.fragments.ShowCityFragment;

public class MainActivity extends AppCompatActivity implements SelectCityListener {

    String[] cities = {"City_1", "City_2", "City_3", "City_4", "City_5"};
    ArrayAdapter<String> adapter;
    Spinner citySpinnerView;
    boolean isExist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.cities);
        if (fragment == null) {
            fragment = new SelectCityFragment();
            fm.beginTransaction()
                    .add(R.id.cities, fragment)
                    .commit();
        }
    }

    @Override
    public void onOpenFragmentWeatherMain(String string) {
        if (string == null) throw new RuntimeException("Не выбран город");

        Bundle bundle = new Bundle();
        bundle.putString(ShowCityFragment.KEY, string);

        isExist = getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;
        if (isExist) {
            FragmentManager fm = getSupportFragmentManager();
                Fragment fragmentReplace;
                fragmentReplace = new ShowCityFragment();
                fragmentReplace.setArguments(bundle);
                fm.beginTransaction()
                        .replace(R.id.weather_in_city, fragmentReplace, ShowCityFragment.TAG)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .addToBackStack(ShowCityFragment.TAG)
                        .commit();

        } else {
            FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = fm.findFragmentById(R.id.cities);
            if (fragment instanceof SelectCityFragment) {
                Fragment fragmentReplace;
                fragmentReplace = new ShowCityFragment();
                fragmentReplace.setArguments(bundle);
                fm.beginTransaction()
                        .replace(R.id.cities, fragmentReplace, ShowCityFragment.TAG)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .addToBackStack(ShowCityFragment.TAG)
                        .commit();
            }
        }
    }
//    private void startSpinner(){
//        citySpinnerView = findViewById(R.id.spinner);
//        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cities);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        citySpinnerView.setAdapter(adapter);
//    }
}
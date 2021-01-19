package ru.geekbrains.weather_lesson_one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import ru.geekbrains.weather_lesson_one.fragments.SelectCityFragment;
import ru.geekbrains.weather_lesson_one.fragments.ShowCityFragment;

public class MainActivity extends AppCompatActivity implements SelectCityListener {

    String[] cities = {"City_1", "City_2", "City_3", "City_4", "City_5"};
    ArrayAdapter<String> adapter;
    Spinner citySpinnerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.cities);
        if (fragment == null) {
            fragment = new SelectCityFragment();
            fm.beginTransaction()
                    .add(R.id.cities, fragment, ShowCityFragment.TAG)
                    .commit();
        }

    }
    @Override
    public void onOpenFragmentWeatherMain(String string) {
        if(string == null)throw new RuntimeException("Не выбран город");

        FragmentManager fm = getSupportFragmentManager();

        Fragment fragment = fm.findFragmentById(R.id.cities);
        if (fragment instanceof SelectCityFragment) {
            Fragment fragmentReplace;
            fragmentReplace = new ShowCityFragment();

            Bundle bundle = new Bundle();
            bundle.putString(ShowCityFragment.KEY, string);
            fragmentReplace.setArguments(bundle);

            fm.beginTransaction()
                    .replace(R.id.cities, fragmentReplace, ShowCityFragment.TAG)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(ShowCityFragment.TAG)
                    .commit();
        }
    }





//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        int countOfFragmentInManager = getSupportFragmentManager().getBackStackEntryCount();
//        if(countOfFragmentInManager > 0) {
//            getSupportFragmentManager().popBackStack();
//        }
//    }

//    public void onClick(View v) {
//        EditText cityNameText = findViewById(R.id.editText2);
//        String name = cityNameText.getText().toString();
//        Intent intent = new Intent(MainActivity.this, SelectedCityActivity.class);
//        intent.putExtra("name", name);
//        startActivity(intent);
//    }
//
//    private void startSpinner(){
//        citySpinnerView = findViewById(R.id.spinner);
//        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cities);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        citySpinnerView.setAdapter(adapter);
//    }
}
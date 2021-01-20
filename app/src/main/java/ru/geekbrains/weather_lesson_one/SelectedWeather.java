package ru.geekbrains.weather_lesson_one;

public class SelectedWeather {
    private String day;
    private String temperature;

    public SelectedWeather(String day, String temperature) {
        this.day = day;
        this.temperature = temperature;
    }

    public String getDay() {
        return day;
    }

    public String getTemperature() {
        return temperature;
    }
}

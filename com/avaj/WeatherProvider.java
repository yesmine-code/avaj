package com.avaj;

import com.avaj.aircraft.Coordinates;

//singloton
public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider(){

    }

    public static WeatherProvider getProvider(){
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        Integer i = (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % 4;
        return weather[i];
    }
}

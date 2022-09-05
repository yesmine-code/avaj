package com.avaj;

import com.avaj.aircraft.Coordinates;
import com.avaj.aircraft.Flyable;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather(){
        this.conditionChanged();
    }
    @Override
    public void register(Flyable flyable){
        super.register(flyable);
        flyable.registerTower(this);
    }

    @Override
    public void unregister(Flyable flyable){
        super.unregister(flyable);
    }

}

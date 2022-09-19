package com.avaj;

import com.avaj.aircraft.Coordinates;
import com.avaj.aircraft.Flyable;
import com.avaj.exceptions.FileNotFoundException;


public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() throws FileNotFoundException{
        this.conditionChanged();
    }
    @Override
    public void register(Flyable flyable) throws FileNotFoundException{
        super.register(flyable);
        flyable.registerTower(this);
    }

    @Override
    public void unregister(Flyable flyable){
        super.unregister(flyable);
    }

}

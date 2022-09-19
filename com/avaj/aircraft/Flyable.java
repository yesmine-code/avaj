package com.avaj.aircraft;
import com.avaj.exceptions.FileNotFoundException;

import com.avaj.WeatherTower;

public interface Flyable {
    public void updateConditions() throws FileNotFoundException;
    public  void registerTower(WeatherTower weatherTower) throws FileNotFoundException;
}

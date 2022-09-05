package com.avaj.aircraft;

import com.avaj.WeatherTower;

public interface Flyable {
    public void updateConditions();
    public  void registerTower(WeatherTower weatherTower);
}

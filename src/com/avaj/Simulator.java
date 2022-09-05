package com.avaj;

import com.avaj.aircraft.Flyable;

public class Simulator {
    public static void main(String args[]) throws Exception {
        if (args.length != 1)
            System.out.println("Wrong number of arguments");
        else{
            AircraftConfig conf = new AircraftConfig();
            conf.parseConfig(args[0]);
            WeatherTower tower = new WeatherTower();
            for (Flyable f : conf.getFlyableList()){
                tower.register(f);
            }
            for (int i = 0; i < conf.getRunNumber() ; i++ ){
                tower.changeWeather();
            }
        }
    }
}

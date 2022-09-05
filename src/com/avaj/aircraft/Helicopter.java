package com.avaj.aircraft;

import com.avaj.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        if ("SUN".equalsIgnoreCase(weather)){
            System.out.println("Helicopter#" + this.name + "(" + this.id + "): This is hot.");
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
            this.coordinates.setHeight(this.coordinates.getHeight() + 2);
        } else if ("RAIN".equalsIgnoreCase(weather)) {
            System.out.println("Helicopter#" + this.name + "(" + this.id + "): it's raining cat and dog.");
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
        } else if ("SNOW".equalsIgnoreCase(weather)) {
            System.out.println("Helicopter#" + this.name + "(" + this.id + "): My rotor is going to freeze!");
            this.coordinates.setHeight(this.coordinates.getHeight() - 12);
        } else if ("FOG".equalsIgnoreCase(weather)) {
            System.out.println("Helicopter#" + this.name + "(" + this.id + "): i can't see clearly damnnnn!.");
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
        }
        if (this.coordinates.getLongitude() < 0)
            this.coordinates.setLongitude(0);
        if (this.coordinates.getLatitude() < 0)
            this.coordinates.setLatitude(0);
        if (this.coordinates.getHeight() <= 0){
            System.out.println("Helicopter#" + this.name + "(" + this.id + ") Landing.");
            this.weatherTower.unregister(this);
            System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower.");
        }
        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        System.out.println("Tower says: Helicopter#" + this.name+ "("+ this.id +") registered to weather tower.");
    }
}

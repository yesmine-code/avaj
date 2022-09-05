package com.avaj.aircraft;

import com.avaj.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        if ("SUN".equalsIgnoreCase(weather)){
            System.out.println("JetPlane#" + this.name + "(" + this.id + "): i love the sun but it's too hot for me.");
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
            this.coordinates.setHeight(this.coordinates.getHeight() + 2);
        } else if ("RAIN".equalsIgnoreCase(weather)) {
            System.out.println("JetPlane#" + this.name + "(" + this.id + "): It's raining. Better watch out for lightings.");
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
        } else if ("SNOW".equalsIgnoreCase(weather)) {
            System.out.println("JetPlane#" + this.name + "(" + this.id + "): OMG winter is coming.");
            this.coordinates.setHeight(this.coordinates.getHeight() - 7);
        } else if ("FOG".equalsIgnoreCase(weather)) {
            System.out.println("JetPlane#" + this.name + "(" + this.id + "): i wonder from where the fog is coming do you know!.");
            this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
        }
        if (this.coordinates.getLongitude() < 0)
            this.coordinates.setLongitude(0);
        if (this.coordinates.getLatitude() < 0)
            this.coordinates.setLatitude(0);
        if (this.coordinates.getHeight() <= 0){
            System.out.println("JetPlane#" + this.name + "(" + this.id + ") Landing.");
            this.weatherTower.unregister(this);
            System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower.");
        }
        if (this.coordinates.getHeight() > 100)
                this.coordinates.setHeight(100);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        System.out.println("Tower says: JetPlane#" + this.name+ "("+ this.id +") registered to weather tower.");
    }
}

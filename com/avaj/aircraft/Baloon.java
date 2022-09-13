package com.avaj.aircraft;

import com.avaj.WeatherTower;
import com.avaj.FileManaj;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        FileManaj.getFile();
        String weather = weatherTower.getWeather(this.coordinates);
        if ("SUN".equalsIgnoreCase(weather)){
            FileManaj.writeIntoFile("Baloon#" + this.name + "(" + this.id+ "): Let's enjoy the good weather and take some pics.");
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
            this.coordinates.setHeight(this.coordinates.getHeight() + 4);
        } else if ("RAIN".equalsIgnoreCase(weather)) {
            FileManaj.writeIntoFile("Baloon#" + this.name + "(" + this.id+ "): Damn you rain! You messed up my baloon.");
            this.coordinates.setHeight(this.coordinates.getHeight() - 5);
        } else if ("SNOW".equalsIgnoreCase(weather)) {
            FileManaj.writeIntoFile("Baloon#" + this.name + "(" + this.id+ "): OMG!! it's snowing! i can see santa from here.");
            this.coordinates.setHeight(this.coordinates.getHeight() - 15);
        } else if ("FOG".equalsIgnoreCase(weather)) {
            FileManaj.writeIntoFile("Baloon#" + this.name + "(" + this.id+ "): foggy! frog frog frog! hey is't not a song.");
            this.coordinates.setHeight(this.coordinates.getHeight() - 3);
        }
        if (this.coordinates.getLongitude() < 0)
            this.coordinates.setLongitude(0);
        if (this.coordinates.getLatitude() < 0)
            this.coordinates.setLatitude(0);
        if (this.coordinates.getHeight() <= 0) {
            FileManaj.writeIntoFile("Baloon#" + this.name + "(" + this.id + ") Landing.");
            this.weatherTower.unregister(this);
            FileManaj.writeIntoFile("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.");
        }
        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        FileManaj.getFile();
        this.weatherTower = weatherTower;
        FileManaj.writeIntoFile("Tower says: Baloon#" + this.name+ "("+ this.id +") registered to weather tower.");
    }
}

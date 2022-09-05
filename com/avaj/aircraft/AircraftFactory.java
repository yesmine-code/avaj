package com.avaj.aircraft;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, Integer longitude, Integer latitude, Integer height) throws Exception{
        checkType(type);
        checkCoordinates(longitude, latitude, height);
        Coordinates c = new Coordinates(longitude, latitude, height);
        if ("Helicopter".equalsIgnoreCase(type))
            return new Helicopter(name, c);
        if ("Baloon".equalsIgnoreCase(type))
            return  new Baloon(name, c);
        if ("JetPLane".equalsIgnoreCase(type))
            return  new JetPlane(name, c);
        return null;
    }
    private static void checkType(String type) throws Exception{
        String[] types = {"Baloon", "Helicopter", "JetPlane"};
        if (!type.equalsIgnoreCase(types[0]) && !type.equalsIgnoreCase(types[1]) && !type.equalsIgnoreCase(types[2]))
            throw new Exception("Aircraft type doesn't exist");
    }
    private static void checkCoordinates(Integer longitude, Integer latitude, Integer height) throws Exception{
        if (longitude < 0 || latitude < 0 || height < 0)
            throw new Exception("coordinates must be positive");
    }
}

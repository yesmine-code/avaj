package com.avaj.aircraft;

public class Aircraft {
    protected Long id;
    protected String name;
    protected Coordinates coordinates;
    private static Long idCounter = 0L;

    protected Aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        this.id = idCounter;
        idCounter++;
    }

    private Long nextId(){
            return idCounter;
    }
}

package com.avaj;

import com.avaj.aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;
import com.avaj.exceptions.FileNotFoundException;

public class Tower {
    private List<Flyable> observers;

    public void register(Flyable flyable) throws FileNotFoundException{
        if (observers == null)
            observers = new ArrayList<>();
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        if (observers != null)
            observers.remove(flyable);
    }

    protected void conditionChanged() throws FileNotFoundException{
        for (int i = 0; i < observers.size(); i++)
            observers.get(i).updateConditions();
    }

}

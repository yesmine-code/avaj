package com.avaj;

import com.avaj.aircraft.AircraftFactory;
import com.avaj.aircraft.Flyable;
import com.avaj.exceptions.FileCorruptedException;
import com.avaj.exceptions.FileNotFoundException;
import com.avaj.exceptions.WrongTypeOfDataException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AircraftConfig {
    private Integer runNumber;
    private List<Flyable> flyableList;

    public void parseConfig(String filename) throws Exception {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            if (line == null || line.length() == 0 || line.split(" ").length > 1){
                throw new FileCorruptedException();
            }
            runNumber = Integer.parseInt(line);
            if (runNumber < 0)
                throw new WrongTypeOfDataException();
            while (line != null) {
                line = br.readLine();
                if (line == null)
                    break;
                if (line.length() == 0)
                    continue;
                if (line.split(" ").length != 5){
                    throw new FileCorruptedException();
                }
                String[] tab = line.split(" ");
                Flyable f;
                try {
                    f = AircraftFactory.newAircraft(tab[0], tab[1], Integer.parseInt(tab[2]), Integer.parseInt(tab[3]), Integer.parseInt(tab[4]));
                }
                catch (WrongTypeOfDataException e){
                    throw new WrongTypeOfDataException();
                }
                if (flyableList == null)
                    flyableList = new ArrayList<>();
                flyableList.add(f);
            }
        } catch (IOException e) {
            throw new FileNotFoundException(filename);
        }
    }
    public Integer getRunNumber() {
        return runNumber;
    }

    public List<Flyable> getFlyableList() {
        return flyableList;
    }
}

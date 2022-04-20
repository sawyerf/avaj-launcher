package Flyable;

import Weather.WeatherTower;
import Weather.Coordinates;
import Airport.Aircraft;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println("Tower says: Helicopter" + "#" + super.name + "(" + super.id + ") registered to weather tower.");
    }
}
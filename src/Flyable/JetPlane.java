package Flyable;

import Weather.WeatherTower;
import Weather.Coordinates;
import Airport.Aircraft;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {

    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println("Tower says: JetPlane" + "#" + super.name + "(" + super.id + ") registered to weather tower.");
    }
}
package Flyable;

import Weather.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}
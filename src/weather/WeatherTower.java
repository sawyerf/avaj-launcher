package weather;

import weather.WeatherProvider;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        String weather = WeatherProvider
            .getProvider()
            .getCurrentWeather(coordinates);
        return weather;
    }

    public void changeWeather() {
        super.conditionsChanged();
    }
}
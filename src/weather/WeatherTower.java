package weather;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return "";
    }

    public void changeWeather() {
        // change Weather
        super.conditionsChanged();
    }
}
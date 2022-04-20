package Weather;

public class WeatherProvider {
    private WeatherProvider weatherProvider;
    private String weather;

    private WeatherProvider() {

    }

    public WeatherProvider getProvider() { 
        return (this);
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return weather;
    }
}
package avaj.weather;

import java.lang.Math;

public class WeatherProvider {
    private final static WeatherProvider weatherProvider = new WeatherProvider();
    private final static String[] weather = {
        "RAIN",
        "FOG",
        "SUN",
        "SNOW"
    };

    private WeatherProvider() {}

    public static WeatherProvider getProvider() { 
        return (weatherProvider);
    }

    public String getCurrentWeather(Coordinates coordinates) {
        double dindex = 0;
        dindex += coordinates.getLatitude() * Math.random() + Math.random() * 10;
        dindex += coordinates.getLongitude() * Math.random() + Math.random() * 10;
        int index = (int)dindex % 4;
        return weather[index];
    }
}
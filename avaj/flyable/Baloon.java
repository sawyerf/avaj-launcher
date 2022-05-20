package avaj.flyable;

import avaj.weather.WeatherTower;
import avaj.weather.Coordinates;
import avaj.airport.Aircraft;

public class Baloon extends Aircraft implements Flyable {
    private final static String TYPE = "Baloon";
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    private void checkCoord(Coordinates coord, String weather) {
        switch (weather) {
            case "SUN":
                weatherTower.writeLog(TYPE + "#" + super.name + "(" + super.id + "): " + COLOR_YELLOW + "Let's enjoy the good weather and take some pics." + COLOR_RESET);
                break;
            case "RAIN":
                weatherTower.writeLog(TYPE + "#" + super.name + "(" + super.id + "): " + COLOR_BLUE + "Damn you rain! You messed up my baloon." + COLOR_RESET);
                break;
            case "FOG":
                weatherTower.writeLog(TYPE + "#" + super.name + "(" + super.id + "): " + COLOR_GREY + "I can't see my own hand." + COLOR_RESET);
                break;
            case "SNOW":
                weatherTower.writeLog(TYPE + "#" + super.name + "(" + super.id + "): " + COLOR_WHITE + "It's snowing. We're gonna crash." + COLOR_RESET);
                break;
        }
            if (coord.getHeight() == 0) {
                weatherTower.writeLog(TYPE + "#" + super.name + "(" + super.id + "): Crash");
                weatherTower.unregister(this);
                weatherTower.writeLog(COLOR_RED + "Tower says: " + TYPE + "#" + super.name + "(" + super.id + ")(" + super.coordinates.getLongitude() + "," + super.coordinates.getLatitude() + "," + super.coordinates.getHeight() + ") unregistered from weather tower." + COLOR_RESET);
            }
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(super.coordinates);
        switch (weather) {
            case "SUN":
                super.coordinates.upLongitude(2);
                super.coordinates.upHeight(4);
                break;
            case "RAIN":
                super.coordinates.downHeight(5);
                break;
            case "FOG":
                super.coordinates.downHeight(3);
                break;
            case "SNOW":
                super.coordinates.downHeight(15);
            break;
        }
        checkCoord(super.coordinates, weather);
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        weatherTower.writeLog("Tower says: " + TYPE + "#" + super.name + "(" + super.id + ") registered to weather tower.");
    }
}
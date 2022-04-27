package avaj.flyable;

import avaj.weather.WeatherTower;
import avaj.weather.Coordinates;
import avaj.airport.Aircraft;

public class JetPlane extends Aircraft implements Flyable {
    private final static String TYPE = "JetPlane";
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    private void checkCoord(Coordinates coord, String weather) {
        if (coord.getHeight() == 0) {
            weatherTower.writeLog(TYPE + "#" + super.name + "(" + super.id + "): Crash");
            weatherTower.unregister(this);
            weatherTower.writeLog(COLOR_RED + "Tower says: " + TYPE + "#" + super.name + "(" + super.id + ")(" + super.coordinates.getLongitude() + "," + super.coordinates.getLatitude() + "," + super.coordinates.getHeight() + ") unregistered from weather tower." + COLOR_RESET);
        } else {
            switch (weather) {
                case "SUN":
                    weatherTower.writeLog(TYPE + "#" + super.name + "(" + super.id + "): " + COLOR_YELLOW + "Let's enjoy the good weather and take some pics." + COLOR_RESET);
                    break;
                case "RAIN":
                    weatherTower.writeLog(TYPE + "#" + super.name + "(" + super.id + "): " + COLOR_BLUE + "It's raining. Better watch out for lightings." + COLOR_RESET);
                    break;
                case "FOG":
                    weatherTower.writeLog(TYPE + "#" + super.name + "(" + super.id + "): " + COLOR_GREY + "I can't see my own hand." + COLOR_RESET);
                    break;
                case "SNOW":
                    weatherTower.writeLog(TYPE + "#" + super.name + "(" + super.id + "): " + COLOR_WHITE + "OMG! Winter is coming!" + COLOR_RESET);
                    break;
            }
        }
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(super.coordinates);
        switch (weather) {
            case "SUN":
                super.coordinates.upLatitude(10);
                super.coordinates.upHeight(2);
                break;
            case "RAIN":
                super.coordinates.upLatitude(5);
                break;
            case "FOG":
                super.coordinates.upLatitude(1);
                break;
            case "SNOW":
                super.coordinates.downHeight(7);
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
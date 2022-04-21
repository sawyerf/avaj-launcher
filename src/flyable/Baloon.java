package flyable;

import weather.WeatherTower;
import weather.Coordinates;
import airport.Aircraft;

public class Baloon extends Aircraft implements Flyable {
    private final static String TYPE = "Baloon";
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    private void checkCoord(Coordinates coord, String weather) {
        if (coord.getHeight() == 0) {
            System.out.println(TYPE + "#" + super.name + "(" + super.id + "): Crash");
            weatherTower.unregister(this);
            System.out.println("Tower says: " + TYPE + "#" + super.name + "(" + super.id + ") unregistered from weather tower.");
        } else {
            // System.out.println(TYPE + "#" + super.name + "(" + super.id + "): " + weather + "(" + super.coordinates.getLongitude() + "," + super.coordinates.getLatitude() + "," + super.coordinates.getHeight() + ")");
            switch (weather) {
                case "SUN":
                    System.out.println(TYPE + "#" + super.name + "(" + super.id + "): Let's enjoy the good weather and take some pics.");
                    break;
                case "RAIN":
                    System.out.println(TYPE + "#" + super.name + "(" + super.id + "): Damn you rain! You messed up my baloon.");
                    break;
                case "FOG":
                    System.out.println(TYPE + "#" + super.name + "(" + super.id + "): I can't see my own hand.");
                    break;
                case "SNOW":
                    System.out.println(TYPE + "#" + super.name + "(" + super.id + "): It's snowing. We're gonna crash.");
                    break;
            }
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
        System.out.println("Tower says: " + TYPE + "#" + super.name + "(" + super.id + ") registered to weather tower.");
    }
}
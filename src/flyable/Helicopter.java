package flyable;

import weather.WeatherTower;
import weather.Coordinates;
import airport.Aircraft;

public class Helicopter extends Aircraft implements Flyable {
    private final static String TYPE = "Helicopter";
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    private void checkCoord(Coordinates coord, String weather) {
        if (coord.getHeight() == 0) {
            System.out.println(TYPE + "#" + super.name + "(" + super.id + ") Crash");
            weatherTower.unregister(this);
            System.out.println("Tower says: " + TYPE + "#" + super.name + "(" + super.id + ") unregistered from weather tower.");
        } else {
            // System.out.println(TYPE + "#" + super.name + "(" + super.id + "): " + weather + "(" + super.coordinates.getLongitude() + "," + super.coordinates.getLatitude() + "," + super.coordinates.getHeight() + ")");
            switch (weather) {
                case "SUN":
                    System.out.println(TYPE + "#" + super.name + "(" + super.id + "): Let's enjoy the good weather and take some pics.");
                    break;
                case "RAIN":
                    System.out.println(TYPE + "#" + super.name + "(" + super.id + "): It's raining. Better watch out for lightings.");
                    break;
                case "FOG":
                    System.out.println(TYPE + "#" + super.name + "(" + super.id + "): I can't see my own hand.");
                    break;
                case "SNOW":
                    System.out.println(TYPE + "#" + super.name + "(" + super.id + "): My rotor is going to freeze!");
                    break;
            }
        }
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(super.coordinates);
        switch (weather) {
            case "SUN":
                super.coordinates.upLongitude(10);
                super.coordinates.upHeight(2);
                break;
            case "RAIN":
                super.coordinates.upLongitude(5);
                break;
            case "FOG":
                super.coordinates.upLongitude(1);
                break;
            case "SNOW":
                super.coordinates.downHeight(12);
                break;
        }
        checkCoord(super.coordinates, weather);
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println(
                "Tower says: Helicopter" + "#" + super.name + "(" + super.id + ") registered to weather tower.");
    }
}
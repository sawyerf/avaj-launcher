package flyable;

import weather.WeatherTower;
import weather.Coordinates;
import airport.Aircraft;

public class JetPlane extends Aircraft implements Flyable {
    private final static String TYPE = "JetPlane";
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    private void checkCoord(Coordinates coord, String weather) {
        if (coord.getHeight() == 0) {
            System.out.println(TYPE + "#" + super.name + "(" + super.id + "): Crash");
            weatherTower.unregister(this);
            System.out.println("Tower says: " + TYPE + "#" + super.name + "(" + super.id + ") unregistered from weather tower.");
        } else {
            System.out.println(TYPE + "#" + super.name + "(" + super.id + "): " + weather + "(" + super.coordinates.getLongitude() + "," + super.coordinates.getLatitude() + "," + super.coordinates.getHeight() + ")");
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
        System.out.println("Tower says: JetPlane" + "#" + super.name + "(" + super.id + ") registered to weather tower.");
    }
}
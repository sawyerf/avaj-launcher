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

    public void updateConditions() {
        String weather = weatherTower.getWeather(super.coordinates);
        switch (weather) {
            case "RAIN":
                System.out.println(TYPE + "#" + super.name + "(" + super.id + "): " + weather);
                break;
            case "FOG":
                System.out.println(TYPE + "#" + super.name + "(" + super.id + "): " + weather);
                break;
            case "SUN":
                System.out.println(TYPE + "#" + super.name + "(" + super.id + "): " + weather);
                break;
            case "SNOW":
                System.out.println(TYPE + "#" + super.name + "(" + super.id + "): " + weather);
                break;
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println("Tower says: JetPlane" + "#" + super.name + "(" + super.id + ") registered to weather tower.");
    }
}
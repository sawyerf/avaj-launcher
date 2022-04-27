package avaj.airport;

import avaj.weather.Coordinates;
import avaj.flyable.Helicopter;
import avaj.flyable.JetPlane;
import avaj.flyable.Baloon;
import avaj.flyable.Flyable;

public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coord = new Coordinates(longitude, latitude, height);
        if (type.equals("Helicopter")) {
            return (new Helicopter(name, coord));
        } else if (type.equals("JetPlane")) {
            return (new JetPlane(name, coord));
        } else if (type.equals("Baloon")) {
            return (new Baloon(name, coord));
        }
        return (null);
    }
}
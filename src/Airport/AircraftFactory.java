package Airport;

import Weather.Coordinates;
import Flyable.Helicopter;
import Flyable.JetPlane;
import Flyable.Baloon;
import Flyable.Flyable;

public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        System.out.println("NewAircraft: " + type + ": " + name);
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
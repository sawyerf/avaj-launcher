package airport;

import weather.Coordinates;
import flyable.Helicopter;
import flyable.JetPlane;
import flyable.Baloon;
import flyable.Flyable;

public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        // System.out.println("NewAircraft: " + type + ": " + name);
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
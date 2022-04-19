package Airport;

public class AircraftFactory {
    public void newAircraft(String type, String name, int longitude, int latitude, int height) {
        System.out.println("NewAircraft: " + type + ": " + name);
    }
}
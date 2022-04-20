package Weather;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int lon, int lat, int hei) {
        longitude = lon;
        latitude  = lat;
        height    = hei;
        System.out.println("Coordinates: " + longitude + " " + latitude + " " + height);
    }

    public int getLongitude() {
        return (longitude);
    }

    public int getLatitude() {
        return (latitude);
    }

    public int getHeight() {
        return (height);
    }
}
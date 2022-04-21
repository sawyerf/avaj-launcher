package weather;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int lon, int lat, int hei) {
        longitude = lon;
        latitude  = lat;
        height    = hei;
        if (height > 100) height = 100;
        if (height < 0) height = 0;
        if (longitude < 0) longitude = 100;
        if (latitude < 0) latitude = 100;
        // System.out.println("Coordinates: " + longitude + " " + latitude + " " + height);
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

    public void upLongitude(int up) {
        longitude += up;
    }

    public void upLatitude(int up) {
        latitude += up;
    }

    public void upHeight(int up) {
        height += up;
        if (height > 100) height = 100;
    }

    public void downLongitude(int down) {
        longitude -= down;
        if (longitude < 0) longitude = 0;
    }

    public void downLatitude(int down) {
        latitude -= down;
        if (latitude < 0) latitude = 0;
    }

    public void downHeight(int down) {
        height -= down;
        if (height < 0) height = 0;
    }
}
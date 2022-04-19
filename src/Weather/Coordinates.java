package Weather;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public void Coordinates(int longi, int lat, int hei) {
        this.longitude = longi;
        this.latitude  = lat;
        this.height    = hei;
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
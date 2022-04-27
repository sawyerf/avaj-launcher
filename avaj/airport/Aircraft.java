package avaj.airport;

import avaj.weather.Coordinates;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected static final String COLOR_RESET = "\033[0m";
    protected final static String COLOR_BLUE = "\033[0;34m🌧️ ";
    protected final static String COLOR_YELLOW = "\033[0;33m☀️ ";
    protected final static String COLOR_GREY = "\033[1;30m🌫️ ";
    protected final static String COLOR_WHITE = "\033[1;37m❄️ ";
    protected final static String COLOR_RED = "\033[0;31m";

    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId() {
        idCounter++;
        return idCounter;
    }
}
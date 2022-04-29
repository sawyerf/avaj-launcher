package avaj.weather;

import java.io.FileWriter;
import java.io.IOException;
import avaj.weather.WeatherProvider;

public class WeatherTower extends Tower {
    private static FileWriter fWriter = openLogFile();

    public String getWeather(Coordinates coordinates) {
        String weather = WeatherProvider
            .getProvider()
            .getCurrentWeather(coordinates);
        return weather;
    }

    public void changeWeather() {
        super.conditionsChanged();
    }

    private static FileWriter openLogFile() {
        try {
            return (new FileWriter("simulation.txt"));
        } catch (IOException e) {
            System.err.println("Error fail to open log file");
            return (null);
        }
    }

    public void writeLog(String log) {
        System.out.println(log);
        if (fWriter == null) return ;
        try {
            fWriter.write(log + "\n");
        } catch (IOException e) {
            return ;
        }
    }

    public void closeLog() {
        if (fWriter == null) return ;
        try {
            fWriter.close();
        } catch (IOException e) {
            return ;
        }
    }
}
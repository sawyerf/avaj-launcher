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
            System.out.println("Error fail to open log file");
            return (null);
        }
    }

    public void writeLog(String log) {
        if (fWriter == null) return ;
        System.out.println(log);
        try {
            fWriter.write(log + "\n");
        } catch (IOException e) {
            return ;
        }
    }

    public void closeLog() {
        try {
            fWriter.close();
        } catch (IOException e) {
            return ;
        }
    }
}
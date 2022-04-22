import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.RepaintManager;

import airport.AircraftFactory;

import flyable.Flyable;

import weather.WeatherTower;

public class Main {
    private static Boolean isLineValid(String line) {
        return (Pattern.compile("^[A-Za-z]+ [A-Za-z0-9]+ [0-9]+ [0-9]+ [0-9]+$", Pattern.CASE_INSENSITIVE)
            .matcher(line)
            .find());
    }

    private static Boolean isFirstLineValid(String line) {
        return (Pattern.compile("^[0-9]{1,5}$", Pattern.CASE_INSENSITIVE)
            .matcher(line)
            .find());
    }

    private static WeatherTower readLines(Scanner myReader) {
        WeatherTower weatherTower = new WeatherTower();
        int lineCount = 1;

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            AircraftFactory aircrafFactory = new AircraftFactory();

            lineCount++;
            if (isLineValid(data)) {
                String[] sdata = data.split(" ");
                Flyable flyable = aircrafFactory.newAircraft(sdata[0], sdata[1], Integer.parseInt(sdata[2]), Integer.parseInt(sdata[3]), Integer.parseInt(sdata[4]));
                flyable.registerTower(weatherTower);
            } else {
                System.out.println("Error in parsing file: Line " + lineCount + ": `" + data + "`");
                return (null);
            }
        }
        return (weatherTower);
    }

    private static Scanner openFile(String fileName){
        try {
            File myObj = new File(fileName);
            return new Scanner(myObj);
        } catch (FileNotFoundException e) {
            System.out.println("Fail to open file.");
            // e.printStackTrace();
            return null;
        }
    }

    private static void readFile(String fileName) {
        Scanner myReader = openFile(fileName);
        String data;

        if (myReader == null) return ;
        if (myReader.hasNextLine()) {
            data = myReader.nextLine();
            int repeat;
            if (!isFirstLineValid(data)) {
                System.out.println("Error in parsing file: Line 1: `" + data + "`");
            } else {
                repeat = Integer.parseInt(data);
                WeatherTower weatherTower = readLines(myReader);
                
                if (weatherTower == null) return ;
                for (int i = 1; i <= repeat; i++) {
                    if (weatherTower.isEmpty()) return ;
                    System.out.println("------------");
                    System.out.println(" Repeat: " + i);
                    System.out.println("------------");
                    weatherTower.changeWeather();
                }
                weatherTower.closeLog();
            }
        } else {
            System.out.println("Error file is empty");
        }
        myReader.close();
    }

    public static void main(String[] args) {
        int count = args.length;

        if (count == 1) {
            readFile(args[0]);
        } else {
            System.out.println("Usage");
            System.out.println("./a.out <FILE>");
        }
    }
}
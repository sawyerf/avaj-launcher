import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import airport.AircraftFactory;

import flyable.Flyable;

import weather.WeatherTower;

public class Main {
    private static Boolean isLineValid(String line) {
        return (Pattern.compile("^.+ .+ [0-9]+ [0-9]+ [0-9]+$", Pattern.CASE_INSENSITIVE)
            .matcher(line)
            .find());
    }

    private static void readLines(Scanner myReader) {
        WeatherTower weatherTower = new WeatherTower();

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            AircraftFactory aircrafFactory = new AircraftFactory();
            if (isLineValid(data)) {
                String[] sdata = data.split(" ");
                Flyable flyable = aircrafFactory.newAircraft(sdata[0], sdata[1], Integer.parseInt(sdata[2]), Integer.parseInt(sdata[3]), Integer.parseInt(sdata[4]));
                flyable.registerTower(weatherTower);
            }
        }
    }

    private static void readFile(String fileName) {
        String data;
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            if (myReader.hasNextLine()) {
                data = myReader.nextLine();
                try {
                    int lol = Integer.parseInt(data);
                    System.out.println(lol);
                } catch (NumberFormatException e){
                    System.out.println("Fail to parse file");
                    myReader.close();
                    return ;
                }
                readLines(myReader);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            // e.printStackTrace();
        }
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
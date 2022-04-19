import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Airport.AircraftFactory;

public class Main {
    private static Boolean isLineValid(String line) {
        return (Pattern.compile("^.+ .+ [0-9]+ [0-9]+ [0-9]+$", Pattern.CASE_INSENSITIVE)
            .matcher(line)
            .find());
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
                while (myReader.hasNextLine()) {
                    data = myReader.nextLine();
                    AircraftFactory aircrafFactory = new AircraftFactory();
                    if (isLineValid(data)) {
                        String[] sdata = data.split(" ");
                        aircrafFactory.newAircraft(sdata[0], sdata[1], Integer.parseInt(sdata[2]), Integer.parseInt(sdata[3]), Integer.parseInt(sdata[4]));
                        System.out.println("lol: " + data);
                    }
                }
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
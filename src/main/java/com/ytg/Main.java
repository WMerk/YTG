package com.ytg;

/**
 * Created by Waldemar on 01.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        if (args.length == 0){
            System.console().printf("Dateiname wurde nicht übergeben");
            return;
        }

        String csvFilePath = args[0];

        YouTrackParser parser = new YouTrackParser(csvFilePath);
        parser.writeToFile();
    }
}
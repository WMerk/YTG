/**
 * Created by Waldemar on 01.12.2016.
 */
public class Program {
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
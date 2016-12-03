import Gantt.GanttDiagramm;
import Gantt.Issue;
import Gantt.MsIssue;

import java.io.*;
import java.util.List;
import java.util.Vector;

/**
 * Created by Waldemar on 01.12.2016.
 */
public class YouTrackParser {

    private String FilePath;
    private GanttDiagramm ganttDiagramm;
    private List<Issue> Issues;
    private List<MsIssue> MsIssues;

    private static final String DELIMITER = ";";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "Nr" + DELIMITER +
            "Vorgangsmodus" + DELIMITER +
            "Name" + DELIMITER +
            "Dauer" + DELIMITER +
            "Geplante_Dauer" + DELIMITER +
            "Ende" + DELIMITER +
            "Vorgänger" + DELIMITER +
            "Ressourcennamen" + DELIMITER +
            "Gliederungsebene";

    public YouTrackParser(String filePath) {
        FilePath = filePath;
        Issues = new Vector<Issue>();
        ganttDiagramm = new GanttDiagramm();

        readCsvToIssueList();
        ganttDiagramm.createStructure(Issues);
        MsIssues = ganttDiagramm.convertForMSProject();

    }



    private void readCsvToIssueList() {

        String csvFile = FilePath;
        String line = "";
        int lineNumber = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                lineNumber++;
                // use comma as separator
                if(!line.startsWith("\""))
                {
                    System.out.println("WARNUNG: Zeile " + lineNumber + " beginnt nicht mit einem Anführungszeichen. CSV-Datei überprüfen.");
                }
                String[] csvIssue = line.split(DELIMITER);
                Issue tmp = new Issue();

                if(csvIssue.length < 19){
                   continue;
                }

                tmp.setIssueId(csvIssue[0]);
                tmp.setProject(csvIssue[1]);
                tmp.setTags(csvIssue[2]);
                tmp.setSummary(csvIssue[3]);
                tmp.setReporter(csvIssue[4]);
                tmp.setCreated(csvIssue[5]);
                tmp.setUpdated(csvIssue[6]);
                tmp.setResolved(csvIssue[7]);
                tmp.setPriority(csvIssue[8]);
                tmp.setType(csvIssue[9]);
                tmp.setState(csvIssue[10]);
                tmp.setAssignee(csvIssue[11]);
                tmp.setSprints(csvIssue[12]);
                tmp.setIdealDays(csvIssue[13]);
                tmp.setStoryPoints(csvIssue[14]);
                tmp.setEstimation(csvIssue[15]);
                tmp.setSpentTime(csvIssue[16]);
                tmp.setDescription(csvIssue[17]);
                tmp.setVotes(csvIssue[18]);

                Issues.add(tmp);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeToFile() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("result.csv");

            fileWriter.append(FILE_HEADER.toString());
            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);
            //Write a new student object list to the CSV file
            int n = 1;

            for (MsIssue issue : MsIssues) {
                // Nr
                fileWriter.append(String.valueOf(n));
                n++;
                fileWriter.append(DELIMITER);

                // Vorgangsmodus
                fileWriter.append(issue.getVorgangsmodus());
                fileWriter.append(DELIMITER);
                // Name
                fileWriter.append(issue.getName());
                fileWriter.append(DELIMITER);
                // Dauer
                fileWriter.append(issue.getDauer());
                fileWriter.append(DELIMITER);
                // Geplante_Dauer
                fileWriter.append(issue.getGeplante_Dauer());
                fileWriter.append(DELIMITER);
                // Ende
                fileWriter.append(issue.getEnde());
                fileWriter.append(DELIMITER);
                // Vorgänger
                fileWriter.append(issue.getVorgänger());
                fileWriter.append(DELIMITER);
                // Ressourcennamen
                fileWriter.append(issue.getRessourcennamen());
                fileWriter.append(DELIMITER);
                // Gliederungsebene
                fileWriter.append(String.valueOf(issue.getGliederungsebene()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
}

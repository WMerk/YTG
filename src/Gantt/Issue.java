package Gantt;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Waldemar on 01.12.2016.
 */
public class Issue {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");

    public String getIssueId() {
        return IssueId;
    }

    public void setIssueId(String issueId) {
        IssueId = issueId;
    }

    String IssueId;

    public String getProject() {
        return Project;
    }

    public void setProject(String project) {
        Project = project;
    }

    public String getTags() {
        return Tags;
    }

    public void setTags(String tags) {
        Tags = tags;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public String getReporter() {
        return Reporter;
    }

    public void setReporter(String reporter) {
        Reporter = reporter;
    }

    public String getCreated() {
        return Created;
    }

    public void setCreated(String created) {
        Created = created;
    }

    public String getUpdated() {
        return Updated;
    }

    public void setUpdated(String updated) {
        Updated = updated;
    }

    public String getResolved() {
        String[] tmp = Resolved.split("\\,");
        String result = "";

        if(tmp.length <= 1)
        {
            return  "";
        }

        String cutWeekDay = Resolved.split("\\,")[1]+ ", "+ Resolved.split("\\,")[2];
        if (cutWeekDay.contains("October"))
        {
            result = cutWeekDay.replace("October","10");
        }
        if (cutWeekDay.contains("November"))
        {
            result = cutWeekDay.replace("November","11");
        }
        if (cutWeekDay.contains("December"))
        {
            result = cutWeekDay.replace("December","12");
        }

        // Wednesday, November 30, 2016 7:21:15 AM +00:00
        //SimpleDateFormat format = new SimpleDateFormat("EEEE, MMMM dd, yyyy hh:mm:ss a");
        DateFormat format = new SimpleDateFormat("MM dd, yyyy hh:mm:ss a");


            try {
                Date date = format.parse(result);
                return sdf.format(new Timestamp(date.getTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

        return "ERROR";

    }

    public void setResolved(String resolved) {
        Resolved = resolved;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String priority) {
        Priority = priority;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getAssignee() {
        return Assignee;
    }

    public void setAssignee(String assignee) {
        Assignee = assignee;
    }

    public String getSprints() {
        return Sprints;
    }

    public void setSprints(String sprints) {
        Sprints = sprints;
    }

    public String getIdealDays() {
        return IdealDays;
    }

    public void setIdealDays(String idealDays) {
        IdealDays = idealDays;
    }

    public String getStoryPoints() {
        return StoryPoints;
    }

    public void setStoryPoints(String storyPoints) {
        StoryPoints = storyPoints;
    }

    public String getEstimation() {
        return Estimation.replace("m","min");
    }

    public void setEstimation(String estimation) {
        Estimation = estimation;
    }

    public String getSpentTime() {

        // Unnötige Anfürungszeichen entfernen
        String spentTime = SpentTime.replace("\"","");

        // Wenn keine Zeit gesetzt wurde wird ein leerer String zurückgegeben
        if(spentTime.contains("?")){
            return "";
        }

        // Umrechnung von gemischten Einträgen (z.B. 3d2h30m) in Minuten.
        int temp = 0;
        if(spentTime.contains("d"))
        {
            String[] days = spentTime.split("d");
            temp = Integer.parseInt(days[0]) * 60 * 24;
            if(days.length <=1){
                return Integer.toString(temp)+"min";
            }
            spentTime = days[1];
        }

        if (spentTime.contains("h")){
            String[] hs = spentTime.split("h");
            temp += Integer.parseInt(hs[0]) * 60;

            if (hs.length > 1 && hs[1].contains("m")){
                temp += Integer.parseInt(hs[1].replace("m",""));
            }
            return Integer.toString(temp)+"min";
        }

        return spentTime.replace("m","min");
    }

    public void setSpentTime(String spentTime) {
        SpentTime = spentTime;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getVotes() {
        return Votes;
    }

    public void setVotes(String votes) {
        Votes = votes;
    }

    String Project;
    String Tags;
    String Summary;
    String Reporter;
    String Created;
    String Updated;
    String Resolved;
    String Priority;
    String Type;
    String State;
    String Assignee;
    String Sprints;
    String IdealDays;
    String StoryPoints;
    String Estimation;
    String SpentTime;
    String Description;
    String Votes;
}

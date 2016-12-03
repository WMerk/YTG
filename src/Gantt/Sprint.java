package Gantt;
import Comperators.DateComperator;
import Comperators.TagComporator;

import java.util.List;
import java.util.Vector;

/**
 * Created by Waldemar on 01.12.2016.
 */
public class Sprint {
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    String Name;
    List<Issue> Issues;
    List<Tag> Tags;

    public void createTags() {
        String tagName = "";
        Tag tag = null;
        Issues.sort(new TagComporator());
        for (Issue issue: Issues){


            if (tagName.isEmpty()){
                tagName = issue.getTags();
                tag = new Tag();
                tag.setName(tagName);
                tag.Issues.add(issue);
                Tags = new Vector<Tag>();
                Tags.add(tag);
                continue;
            }

            if(!tagName.equals(issue.getTags())){
                tagName = issue.getTags();
                Tags.add(tag);
                tag = new Tag();
                tag.setName(tagName);
            }

            tag.Issues.add(issue);
        }
    }

    public List<MsIssue>  convert() {
        List<MsIssue> msIssues = new Vector<MsIssue>();
        MsIssue msIssue = new MsIssue();
        List<Issue> tmp = Issues;
        tmp.sort(new DateComperator());

        // TODO: Hier muss noch die Sprintdefinition richtig gemacht werden
        msIssue.setVorgangsmodus("Automatisch geplant");
        msIssue.setName(Name);
        msIssue.setDauer("7 Tage");
        msIssue.setGeplante_Dauer("0 Tage?");
        msIssue.setEnde(tmp.get(tmp.size()-1).getResolved());
        msIssue.setVorgänger("");
        msIssue.setRessourcennamen("");
        msIssue.setGliederungsebene("2");

        msIssues.add(msIssue);

        Tags.forEach(tag -> msIssues.addAll(tag.convert()));

        return msIssues;
    }


}


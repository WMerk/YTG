package com.ytg.Gantt;

import com.ytg.Comperators.DateComperator;

import java.util.*;

/**
 * Created by Waldemar on 01.12.2016.
 */
public class Tag {



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    String Name;
    List<Issue> Issues = new Vector<Issue>();

    public List<MsIssue> convert() {
        List<MsIssue> msIssues = new Vector<MsIssue>();
        MsIssue msIssue = new MsIssue();
        List<Issue> tmp = Issues;
        tmp.sort(new DateComperator());

        // TODO: Hier muss noch die Tagdefinition richtig gemacht werden
        msIssue.setVorgangsmodus("Automatisch geplant");
        msIssue.setName(Name);
        msIssue.setDauer("7 Tage");
        msIssue.setGeplante_Dauer("0 Tage?");
        msIssue.setEnde(tmp.get(tmp.size()-1).getResolved());
        msIssue.setVorgänger("");
        msIssue.setRessourcennamen("");
        msIssue.setGliederungsebene("3");

        msIssues.add(msIssue);

        for(Issue issue: Issues)
        {
            MsIssue ms = new MsIssue();

            ms.setVorgangsmodus("Manuell geplant");
            ms.setName(issue.getSummary());
            ms.setDauer(issue.getSpentTime());
            ms.setGeplante_Dauer(issue.getEstimation());
            ms.setEnde(issue.getResolved());
            ms.setVorgänger("");
            ms.setRessourcennamen(issue.getAssignee());
            ms.setGliederungsebene("4");

            msIssues.add(ms);
        }

        return msIssues;
    }
}


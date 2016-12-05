package com.ytg.Gantt;
import com.ytg.Comperators.SprintComporator;

import java.util.List;
import java.util.Vector;

/**
 * Created by Merk Waldemar on 03.12.2016.
 */
public class Milestone {

    String Name;
    List<Sprint> Sprints = new Vector<Sprint>();

    public void addSprint(Sprint sprint){
        if(Sprints.isEmpty()){
            Sprints = new Vector<Sprint>();
        }
        Sprints.add(sprint);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void createSprints(List<Issue> issues) {
        String sprintName = "";
        Sprint sprint = null;
        issues.sort(new SprintComporator());

        for (Issue issue: issues){

            if (sprintName.isEmpty()){
                sprintName = issue.getSprints();
                sprint = new Sprint();
                sprint.setName(sprintName);
                sprint.Issues = new Vector<Issue>();
                sprint.Issues.add(issue);
                continue;
            }

            if(!sprintName.equals(issue.getSprints())){
                sprintName = issue.getSprints();
                addSprint(sprint);
                sprint = new Sprint();
                sprint.setName(sprintName);
                sprint.Issues = new Vector<Issue>();
            }

            sprint.Issues.add(issue);
        }
    }

    public List<MsIssue> convertMilestone() {
        List<MsIssue> msIssues = new Vector<MsIssue>();
        MsIssue msIssue = new MsIssue();

        // TODO: Hier muss noch die Meilensteindefinition richtig gemacht werden
        msIssue.setVorgangsmodus("Automatisch geplant");
        msIssue.setName(Name);
        msIssue.setDauer("60 Tage");
        msIssue.setGeplante_Dauer("0 Tage?");
        msIssue.setEnde("Don 22.12.16");
        msIssue.setVorgänger("");
        msIssue.setRessourcennamen("");
        msIssue.setGliederungsebene("1");

        msIssues.add(msIssue);

        Sprints.forEach(sprint -> msIssues.addAll(sprint.convert()));

        return msIssues;
    }
}


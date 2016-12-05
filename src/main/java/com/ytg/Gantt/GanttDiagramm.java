package com.ytg.Gantt;

import java.util.List;
import java.util.Vector;

/**
 * Created by Merk Waldemar on 03.12.2016.
 */
public class GanttDiagramm {
    public List<Milestone> Milestones;

    public void createStructure(List<Issue> issues) {
        Milestones = new Vector<Milestone>();
        Milestone milestone = new Milestone();
        milestone.setName("Meilenstein 1");

        milestone.createSprints(issues);
        milestone.Sprints.forEach(s -> s.createTags());
        Milestones.add(milestone);
    }


    public List<MsIssue> convertForMSProject() {
        List<MsIssue> msIssues = new Vector<MsIssue>();
        Milestones.forEach((milestone) -> msIssues.addAll(milestone.convertMilestone()));
        return msIssues;
    }
}


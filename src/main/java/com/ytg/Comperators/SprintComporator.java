package com.ytg.Comperators;

import com.ytg.Gantt.Issue;

import java.util.Comparator;

/**
 * Created by Waldemar on 01.12.2016.
 */
public class SprintComporator implements Comparator<Issue>{

    @Override
    public int compare(Issue o1, Issue o2) {
        return o1.getSprints().compareTo(o2.getSprints());
    }
}

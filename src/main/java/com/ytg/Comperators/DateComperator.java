package com.ytg.Comperators;

import com.ytg.Gantt.Issue;

import java.util.Comparator;

/**
 * Created by Merk Waldemar on 03.12.2016.
 */
public class DateComperator implements Comparator<Issue> {
    @Override
    public int compare(Issue o1, Issue o2) {
        return o1.getResolved().compareTo(o2.getResolved());
    }
}
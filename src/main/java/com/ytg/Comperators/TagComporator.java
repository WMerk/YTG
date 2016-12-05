package com.ytg.Comperators;
import com.ytg.Gantt.Issue;
import java.util.Comparator;

/**
 * Created by Waldemar on 01.12.2016.
 */
public class TagComporator implements Comparator<Issue> {
    @Override
    public int compare(Issue o1, Issue o2) {
        return o1.getTags().compareTo(o2.getTags());
    }
}

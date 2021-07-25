package com.review.generic;

import java.util.Comparator;

public class CustomComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {

        if (o1.getName().equals(o2.getName())) {
            return o1.getBirthday().compareTo(o2.getBirthday());
        }

        return o1.getName().compareTo(o2.getName());
    }
}

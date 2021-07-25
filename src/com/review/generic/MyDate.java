package com.review.generic;

import java.util.Comparator;

public class MyDate implements Comparable<MyDate> {

    private int year;
    private int month;
    private int day;


    public MyDate(int year,int month, int day) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    @Override
    public int compareTo(MyDate o) {

        if (this.getYear() == o.getYear()) {
            if (this.getMonth() == o.getMonth()) {
                if (this.getDay() == o.getDay()) {
                    return 0;
                } else if (this.getDay() > o.getDay()) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (this.month > o.getMonth()) {
                return -1;
            }else {
                return 1;
            }
        } else if (this.getYear() > o.getYear()){
            return -1;
        } else {
            return 1;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}

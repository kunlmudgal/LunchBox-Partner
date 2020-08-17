package com.dscglbajaj.lunchboxpartner.models;

public class Student {

    public static final int LUNCH_STATUS_NOT_WANTED = -1;
    public static final int LUNCH_STATUS_WANTED = 0;
    public static final int LUNCH_STATUS_GIVEN = 1;
    public static final int LUNCH_STATUS_RETURNED = 2;
    private String name;
    private String hostel;
    private String college;
    private int lunchStatus;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostel() {
        return hostel;
    }

    public void setHostel(String hostel) {
        this.hostel = hostel;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getLunchStatus() {
        return lunchStatus;
    }

    public void setLunchStatus(int lunchStatus) {
        this.lunchStatus = lunchStatus;
    }
}

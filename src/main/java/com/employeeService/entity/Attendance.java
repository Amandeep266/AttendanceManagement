package com.employeeService.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="attendance")
public class Attendance {


    @EmbeddedId
    private AttendanceId  attendanceId;



    @Column
    private int year;
    @Column
    private int date;
    @Column
    private int present ;
    @Column
    private int lop;

public Attendance()
{

}
    public Attendance(AttendanceId attendanceId, int year, int lop,int date, int present) {
        this.attendanceId = attendanceId;
        this.year = year;
        this.lop = lop;
        this.date=date;
        this.present=present;



    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLop() {
        return lop;
    }

    public void setLop(int lop) {
        this.lop = lop;
    }

    public AttendanceId getAttendanceId() {
        return attendanceId;
    }


    public int getPresent() {
        return present;
    }

    public void setPresent(int present) {
        this.present = present;
    }

    public void setAttendanceId(AttendanceId attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

}

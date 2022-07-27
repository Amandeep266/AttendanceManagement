package com.employeeService.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.Month;

@Embeddable
public class AttendanceId implements Serializable {


    @Column
    private int emp_id;

    @Column
    private Month month;

    public AttendanceId()
    {
        super();
    }
    public AttendanceId(int empId, Month month) {
        this.emp_id= empId;
        this.month = month;
    }
    public int getId() {
        return emp_id;
    }

    public void setId(int id) {
        this.emp_id = id;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }
}

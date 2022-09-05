package com.employeeService.Repository;

import com.employeeService.entity.Attendance;
import com.employeeService.entity.AttendanceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, AttendanceId> {
    @Query(value="select emp_id,year,month,(select count(date) group by month) as "+
    "date,sum(present) as present ,sum(lop) as lop "+
    "from attendance group by emp_id,year,month having emp_id=:employeeId",
            nativeQuery = true)
    List<Attendance> getMonthlyAttendanceList(@Param("employeeId") int employeeId) ;

}

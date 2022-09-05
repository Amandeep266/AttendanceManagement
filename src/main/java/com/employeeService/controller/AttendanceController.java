package com.employeeService.controller;

import com.employeeService.dto.AttendanceFormDTO;
import com.employeeService.entity.Attendance;
import com.employeeService.entity.AttendanceId;
import com.employeeService.entity.Employee;
import com.employeeService.services.AttendanceServiceImpl;
import com.employeeService.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@Controller
public class AttendanceController {

    @Autowired
    AttendanceServiceImpl attendanceService;
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/attendanceForm")
    String showAttendanceForm(@RequestParam("id")int id, Model model)
    {
        AttendanceFormDTO attendanceFormDTO=new AttendanceFormDTO();
        attendanceFormDTO.setId(id);
        model.addAttribute("attendance",attendanceFormDTO);
        return "/attendanceForm";
    }
    @RequestMapping("/addAttendance")
    String addAttendance(@Valid @ModelAttribute("attendance") AttendanceFormDTO attendance , BindingResult bindingResult,Model model) throws ParseException {
        System.out.println(">>>>>>>>>>>>" + attendance.getDateOfAttendanceMark());
        System.out.println(attendance.getNumberOfHours());
        if (bindingResult.hasErrors())
            return "attendanceForm";
        else if (attendanceService.save(attendance))
            return "redirect:/showEmployees";
        else {
            ObjectError error = new ObjectError
                    ("dateOfAttendanceMark", "Invalid Date for attendance");

            bindingResult.addError(error);
            return "attendanceForm";
        }
    }
        @RequestMapping("/attendance")
        String showAttendance(@RequestParam("id")int id, Model model)
        {
            System.out.println("add attendance");
           Employee employee= employeeService.findById(id);
           model.addAttribute("employee",employee);

            return "/attendanceOption";
        }
    @RequestMapping("/yearly")
    String showYearly(@RequestParam("id") int id, Model model)
    {
        List<Attendance> attendance= attendanceService.getAttendanceById(id);
       Attendance att=attendance.get(0);
//        System.out.println(att.getAttendanceId().getDate());
//        System.out.println(att.getAttendanceId().getId());
//        System.out.println(attendance.get(0));
        model.addAttribute("attendanceList", attendance);
        return "/yearlyAttendanceList";
    }
    }

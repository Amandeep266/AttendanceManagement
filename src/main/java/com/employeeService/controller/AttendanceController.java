package com.employeeService.controller;

import com.employeeService.dto.AttendanceFormDTO;
import com.employeeService.entity.Attendance;
import com.employeeService.services.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.BindException;
import java.text.ParseException;

@Controller
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

//    String showAttendanceOfEmployee()
//    {
//
//
//return null;
//    }
    @RequestMapping("/attendanceForm")
    String showAttendanceForm(@RequestParam("id")int id, Model model)
    {
//        attendanceService.addAttendanceOfEmployee(attendance)
        AttendanceFormDTO attendanceFormDTO=new AttendanceFormDTO();
        attendanceFormDTO.setId(id);
        model.addAttribute("attendance",attendanceFormDTO);
        return "/attendanceForm";
    }
    @RequestMapping("/addAttendance")
    String addAttendance( @Valid @ModelAttribute("attendance") AttendanceFormDTO attendance ,BindingResult bindingResult) throws ParseException {
if(bindingResult.hasErrors())
    return "/attendanceForm";
else attendanceService.save(attendance);
         return "/showEmployees";


    }
    //
}

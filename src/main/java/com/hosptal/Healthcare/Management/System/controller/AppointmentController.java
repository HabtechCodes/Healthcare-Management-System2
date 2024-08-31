package com.hosptal.Healthcare.Management.System.controller;

import com.hosptal.Healthcare.Management.System.model.Appointment;
import com.hosptal.Healthcare.Management.System.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;


    @GetMapping("appointments/{patientId}")
    public Appointment getAppointmentByPatientId(@PathVariable int patientId) {
        return appointmentService.getAppointmentByPatientId(patientId);
    }
    @PostMapping("appointment")
    public String addAppointment(@RequestBody Appointment appointment) {
       return appointmentService.addAppointment(appointment);

    }


}
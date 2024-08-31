package com.hosptal.Healthcare.Management.System.controller;

import com.hosptal.Healthcare.Management.System.model.Patient;
import com.hosptal.Healthcare.Management.System.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;


    @GetMapping("patients")
    public List<Patient> getAllPatient() {
        return patientService.getAllPatient();
    }

    @GetMapping("patients/{patientId}")
    public Patient getPatientById(@PathVariable int patientId) {
       return patientService.getPatientById(patientId);
    }

    @PostMapping("patients")
    public Patient addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
        return patientService.getPatientById(patient.getId());
    }

    @DeleteMapping("patients/{patientId}")
    public String deletePatientById(@PathVariable int patientId) {
        return patientService.deletePatientById(patientId);
    }

    @PutMapping("patients/{patientId}")
    public String updatePatient(@RequestBody Patient patient,@PathVariable int patientId) {
        return patientService.updatePatient(patient,patientId);
    }

}

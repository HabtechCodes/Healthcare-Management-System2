package com.hosptal.Healthcare.Management.System.service;

import com.hosptal.Healthcare.Management.System.model.Patient;
import com.hosptal.Healthcare.Management.System.repository.AppointmentRepository;
import com.hosptal.Healthcare.Management.System.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;
    private AppointmentRepository appointmentRepository;

    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(int patientId) {

        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        return optionalPatient.orElse(new Patient());
    }


    public String updatePatient(Patient patient,int patientId) {

        var retrievedPatient = getPatientById(patientId);

       if(retrievedPatient != null) {
           retrievedPatient.setId(patient.getId());
           retrievedPatient.setAge(patient.getAge());
           retrievedPatient.setAppointmentDetails(patient.getAppointmentDetails());
           retrievedPatient.setUsername(patient.getUsername());
           retrievedPatient.setPassword(patient.getPassword());

           if(retrievedPatient.getId() <= 0) {
               return "ID Not Found";
           }
               patientRepository.save(retrievedPatient);
               return "Patient saved successfully";
       }
        return "";
    }

    public String deletePatientById(int patientId) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if (optionalPatient.isPresent()) {
            patientRepository.deleteById(patientId);
            return "Patient deleted successfully";
        } else {
            return "Patient not found";
        }
    }
}



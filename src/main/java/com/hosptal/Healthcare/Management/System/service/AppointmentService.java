package com.hosptal.Healthcare.Management.System.service;

import com.hosptal.Healthcare.Management.System.model.Appointment;
import com.hosptal.Healthcare.Management.System.repository.AppointmentRepository;
import com.hosptal.Healthcare.Management.System.repository.PatientRepository;
import org.hibernate.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientRepository patientRepository;

    public Appointment getAppointmentByPatientId(int patientId) {
        try{
        Optional<Appointment> retrievedAppointment =
                appointmentRepository.findAppointmentByPatientId(patientId);

            return retrievedAppointment.orElse(new Appointment());
        }catch (NonUniqueResultException e) {
            return new Appointment();
        }
    }
    public String addAppointment(Appointment appointment) {
        List<Appointment> appointmentList = appointmentRepository.findAll();

        for (Appointment currentAppointment : appointmentList) {
            Integer currentId = appointment.getAppointmentId();
            if (currentId != null && currentId.equals(currentAppointment.getAppointmentId())) {
                return "Id -> " + currentId + " already exists";
            }
        }

        appointmentRepository.save(appointment);
        return "Appointment created successfully!";
    }
}


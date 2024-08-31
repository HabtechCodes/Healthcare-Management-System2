package com.hosptal.Healthcare.Management.System.repository;

import com.hosptal.Healthcare.Management.System.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

    @Query(value = "SELECT * FROM appointment WHERE patient_id = :id", nativeQuery = true)
    Optional<Appointment> findAppointmentByPatientId(@Param("id") int id);

}

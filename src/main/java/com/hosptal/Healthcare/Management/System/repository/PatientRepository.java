package com.hosptal.Healthcare.Management.System.repository;

import com.hosptal.Healthcare.Management.System.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {


}

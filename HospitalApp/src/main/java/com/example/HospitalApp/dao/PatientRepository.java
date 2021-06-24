package com.example.HospitalApp.dao;

import com.example.HospitalApp.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface PatientRepository  extends JpaRepository<Patient,Integer> {
}

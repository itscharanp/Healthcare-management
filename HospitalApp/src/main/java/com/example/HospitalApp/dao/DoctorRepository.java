package com.example.HospitalApp.dao;


import com.example.HospitalApp.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("http://localhost:4200")
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}

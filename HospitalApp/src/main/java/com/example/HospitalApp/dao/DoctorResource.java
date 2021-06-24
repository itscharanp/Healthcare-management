package com.example.HospitalApp.dao;


import com.example.HospitalApp.entity.Doctor;
import com.example.HospitalApp.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.print.Doc;
import java.net.Inet4Address;
import java.net.URI;
import java.util.List;

@RestController
public class DoctorResource {

    @Autowired
    private DoctorRepository doctorRepository;


    @GetMapping("/doctors")
    @CrossOrigin("http://localhost:4200")
    public List<Doctor> getDoctors(){
        return(List<Doctor>) doctorRepository.findAll();

    }

    @DeleteMapping("/doctors/{did}")
    @CrossOrigin("http://localhost:4200")
    public void deleteStudent(@PathVariable Integer did) {
        doctorRepository.deleteById(did);
    }












    @PostMapping("/putdoctors")
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<Object> createStudent(@RequestBody Doctor student) {
        System.out.println(student);
        Doctor savedUser = doctorRepository.save(student);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getDid()).toUri();

        return ResponseEntity.created(location).build();

    }


    @PostMapping("/loginDoctor")
    @CrossOrigin("http://localhost:4200")
    public Integer checkDoctor(@RequestBody Doctor user){

        List<Doctor> u = (List<Doctor>) doctorRepository.findAll();
        for(Doctor other : u)
        {
            if(  other.getEmailid().equals(user.getEmailid()) && other.getPassword().equals(user.getPassword()) ) {
                return other.getDid();
            }
        }
        return  -1;
    }



    @PostMapping("/updateForm")
    @CrossOrigin("http://localhost:4200")
    public Boolean checkUser(@RequestBody Doctor doctor){

        List<Doctor> u = (List<Doctor>) doctorRepository.findAll();
        for(Doctor other : u)
        {
            if(  other.getDid() == doctor.getDid()) {
                doctor.setDid(other.getDid());
                doctorRepository.save(doctor);
            }
        }
        return  false;
    }


    @PostMapping("/setavail")
    @CrossOrigin("http://localhost:4200")
    public void setAvail(@RequestParam Integer id){

        List<Doctor> u = (List<Doctor>) doctorRepository.findAll();
        for(Doctor other : u)
        {
            if(  other.getDid() == id) {
                other.setAvailability(0);
                doctorRepository.save(other);
            }
        }
        return;
    }




}

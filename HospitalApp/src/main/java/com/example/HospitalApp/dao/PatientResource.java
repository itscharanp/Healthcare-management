package com.example.HospitalApp.dao;

import com.example.HospitalApp.entity.Doctor;
import com.example.HospitalApp.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PatientResource {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    @CrossOrigin("http://localhost:4200")
    public List<Patient> getPatients(){
        return(List<Patient>) patientRepository.findAll();

    }


    @PostMapping("/loginUser")
    @CrossOrigin("http://localhost:4200")
    public Integer checkUser(@RequestBody Patient user){

        List<Patient> u = (List<Patient>) patientRepository.findAll();
        for(Patient other : u)
        {
            if(  other.getEmailid().equals(user.getEmailid()) && other.getPassword().equals(user.getPassword()) ) {
                return other.getPid();
            }
        }
        return  -1;
    }


    @PostMapping("/addPatient")
    @CrossOrigin("http://localhost:4200")
    public Patient addPatient(@RequestBody Patient patient) {
     return patientRepository.save(patient);
    }


    @PostMapping("/addpres")
    @CrossOrigin("http://localhost:4200")
    public String addpress( @RequestBody Patient pt) {

        List<Patient> u = (List<Patient>) patientRepository.findAll();
        for(Patient other : u)
        {
            if(  other.getPid() == pt.getPid()) {
                other.setPrescription(pt.getPrescription());
                patientRepository.save(other);
                return "succesfull";
            }

        }
        return "failed!!"; }







    @PostMapping("/setDoctor")
   @CrossOrigin("http://localhost:4200")
    public String SetDoctor( @RequestBody Patient pt,@RequestParam Integer did) {

        List<Patient> u = (List<Patient>) patientRepository.findAll();
        for(Patient other : u)
        {
            if(  other.getPid() == pt.getPid()) {
                 other.setSlot1(did);
                Patient savedUser = patientRepository.save(other);
                 return "succesfull";
            }

        }
         return "failed!!"; }

    @PostMapping("/setDoctor2")
    @CrossOrigin("http://localhost:4200")
    public String SetDoctor2( @RequestBody Patient pt,@RequestParam Integer did) {

        List<Patient> u = (List<Patient>) patientRepository.findAll();
        for(Patient other : u)
        {
            if(  other.getPid() == pt.getPid()) {
                other.setSlot2(did);
                Patient savedUser = patientRepository.save(other);
                return "succesfull";
            }

        }
        return "failed!!"; }



    @GetMapping("/getPats")
    @CrossOrigin("http://localhost:4200")
    public List<Patient> getPatientsbySlot(@RequestParam Integer did){
        List<Patient> u = (List<Patient>) patientRepository.findAll();
        List<Patient> patients=new ArrayList<Patient>();
        for (Patient other : u) {
            //System.out.println(other.getEmail()+" "+user.getEmail() +" "+ other.getPassword()+" "+user.getPassword());
            if (other.getSlot1()==did || other.getSlot2()==did) {

                patients.add(other);
            }
        }
        //return(List<Patient>) patientRepository.findAll();
        return patients;

    }


}

package com.charan.Elearning.dao;

import com.charan.Elearning.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentResource {


    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    @CrossOrigin("http://localhost:4200")
    public List<Student> getPatients(){
        return(List<Student>) studentRepository.findAll();

    }


    @PostMapping("/loginUser")
    @CrossOrigin("http://localhost:4200")
    public Integer checkUser(@RequestBody Student user){

        List<Student> u = (List<Student>) studentRepository.findAll();
        for(Student other : u)
        {
            if(  other.getEmailid().equals(user.getEmailid()) && other.getPassword().equals(user.getPassword()) ) {
                return other.getSid();
            }
        }
        return  -1;
    }


    @PostMapping("/addStudent")
    @CrossOrigin("http://localhost:4200")
    public Student addPatient(@RequestBody Student student) {
        return studentRepository.save(student);
    }






//    @PostMapping("/setDoctor")
//    @CrossOrigin("http://localhost:4200")
//    public String SetDoctor( @RequestBody Patient pt,@RequestParam Integer did) {
//
//        List<Patient> u = (List<Patient>) patientRepository.findAll();
//        for(Patient other : u)
//        {
//            if(  other.getPid() == pt.getPid()) {
//                other.setSlot1(did);
//                Patient savedUser = patientRepository.save(other);
//                return "succesfull";
//            }
//
//        }
//        return "failed!!"; }
//
//    @PostMapping("/setDoctor2")
//    @CrossOrigin("http://localhost:4200")
//    public String SetDoctor2( @RequestBody Patient pt,@RequestParam Integer did) {
//
//        List<Patient> u = (List<Patient>) patientRepository.findAll();
//        for(Patient other : u)
//        {
//            if(  other.getPid() == pt.getPid()) {
//                other.setSlot2(did);
//                Patient savedUser = patientRepository.save(other);
//                return "succesfull";
//            }
//
//        }
//        return "failed!!"; }
//





    @GetMapping("/getPats")
    @CrossOrigin("http://localhost:4200")
    public void getPatientsbySlot(@RequestParam Integer did){
//        List<Student> u = (List<Student>) studentRepository.findAll();
//        List<Student> patients=new ArrayList<Student>();
//        for (Student other : u) {
//            //System.out.println(other.getEmail()+" "+user.getEmail() +" "+ other.getPassword()+" "+user.getPassword());
//            if (other.getSlot1()==did || other.getSlot2()==did) {
//
//                patients.add(other);
//            }
//        }
//        //return(List<Patient>) patientRepository.findAll();
//        return patients;

    }


}

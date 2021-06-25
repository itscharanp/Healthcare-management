package com.charan.Elearning.dao;

import com.charan.Elearning.entity.Professor;
import com.charan.Elearning.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class ProfessorResource {


    @Autowired
    private ProfessorRepository professorRepository;


    @GetMapping("/professors")
    @CrossOrigin("http://localhost:4200")
    public List<Professor> getDoctors(){
        return(List<Professor>) professorRepository.findAll();

    }

    @GetMapping("/professors/{id}")
    @CrossOrigin("http://localhost:4200")
    public Professor retrieveStudent(@PathVariable Integer id) throws UserNotFoundException {
        Optional<Professor> student = professorRepository.findById(id);

        if (!student.isPresent())
            throw new UserNotFoundException();

        return student.get();
    }

    @DeleteMapping("/professors/{did}")
    @CrossOrigin("http://localhost:4200")
    public void deleteStudent(@PathVariable Integer did) {
        professorRepository.deleteById(did);
    }












    @PostMapping("/putdoctors")
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<Object> createStudent(@RequestBody Professor professor) {
        System.out.println(professor);
        Professor savedUser = professorRepository.save(professor);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getPid()).toUri();

        return ResponseEntity.created(location).build();

    }


    @PostMapping("/addpres")
    @CrossOrigin("http://localhost:4200")
    public String addpress( @RequestBody Professor ps) {

        List<Professor> u = (List<Professor>) professorRepository.findAll();
        for(Professor other : u)
        {
            if(  other.getPid() == ps.getPid()) {
                other.setResources(ps.getResources());
                other.setClassmssg(ps.getClassmssg());
                professorRepository.save(other);
                return "succesfull";
            }

        }
        return "failed!!"; }

    @PostMapping("/loginDoctor")
    @CrossOrigin("http://localhost:4200")
    public Integer checkDoctor(@RequestBody Professor user){

        List<Professor> u = (List<Professor>) professorRepository.findAll();
        for(Professor other : u)
        {
            if(  other.getEmailid().equals(user.getEmailid()) && other.getPassword().equals(user.getPassword()) ) {
                return other.getPid();
            }
        }
        return  -1;
    }



    @PostMapping("/updateForm")
    @CrossOrigin("http://localhost:4200")
    public Boolean checkUser(@RequestBody Professor professor){

        List<Professor> u = (List<Professor>) professorRepository.findAll();
        for(Professor other : u)
        {
            if(  other.getPid() == professor.getPid()) {
                professor.setPid(other.getPid());
                professorRepository.save(professor);
            }
        }
        return  false;
    }


    @PostMapping("/setavail")
    @CrossOrigin("http://localhost:4200")
    public void setAvail(@RequestParam Integer id){

        List<Professor> u = (List<Professor>) professorRepository.findAll();
        for(Professor other : u)
        {
            if(  other.getPid() == id) {
//                other.setAvailability(0);
                professorRepository.save(other);
            }
        }
        return;
    }


}

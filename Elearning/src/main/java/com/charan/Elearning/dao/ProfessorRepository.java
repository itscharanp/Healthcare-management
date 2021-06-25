package com.charan.Elearning.dao;
import com.charan.Elearning.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface ProfessorRepository extends JpaRepository<Professor,Integer>  {
}

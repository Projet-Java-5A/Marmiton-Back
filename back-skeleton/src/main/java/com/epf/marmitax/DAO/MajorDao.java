package com.epf.marmitax.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.epf.marmitax.models.Major;
import com.epf.marmitax.models.Student;

import java.util.List;

@Repository
public interface MajorDao extends JpaRepository<Major, Long> {
    @Query("SELECT m.students FROM Major m WHERE m.id= :majorId")
    List<Student> getAllStudentsFromMajor(Long majorId);
}

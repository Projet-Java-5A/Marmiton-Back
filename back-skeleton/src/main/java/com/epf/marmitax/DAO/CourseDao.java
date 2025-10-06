package com.epf.marmitax.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epf.marmitax.models.Course;

@Repository
public interface CourseDao extends JpaRepository<Course, Long> {
}

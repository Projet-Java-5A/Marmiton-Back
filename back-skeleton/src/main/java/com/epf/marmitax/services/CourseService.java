package com.epf.marmitax.services;

import org.springframework.stereotype.Component;

import com.epf.marmitax.DAO.CourseDao;
import com.epf.marmitax.models.Course;

import java.util.List;

@Component
public class CourseService {
    private final CourseDao courseDao;

    public CourseService(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public List<Course> findAll() {
        return courseDao.findAll();
    }
}

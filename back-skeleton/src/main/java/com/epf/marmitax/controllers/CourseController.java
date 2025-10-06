package com.epf.marmitax.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epf.marmitax.models.Course;
import com.epf.marmitax.services.CourseService;

import java.util.List;

@CrossOrigin
@RequestMapping("courses")
@RestController
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("")
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }
}

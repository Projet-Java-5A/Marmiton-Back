package com.epf.marmitax.DTO;

import java.io.IOException;

import com.epf.marmitax.models.Student;

public class StudentMapper {
    public static Student fromDto(StudentDto dto, Long id) throws IOException {
        return new Student.Builder()
                .id(id)
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .birthdate(dto.getBirthdate())
                .courses(dto.getCourses())
                .major(dto.getMajor())
                .build();
    }

    public static StudentDto toDto (Student student){
        return new StudentDto.StudentDtoBuilder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .birthdate(student.getBirthdate())
                .courses(student.getCourses())
                .major(student.getMajor())
                .build();
    }
}

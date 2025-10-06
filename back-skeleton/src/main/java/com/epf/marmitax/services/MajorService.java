package com.epf.marmitax.services;

import org.springframework.stereotype.Component;

import com.epf.marmitax.DAO.MajorDao;
import com.epf.marmitax.models.Major;
import com.epf.marmitax.models.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class MajorService {
    private final MajorDao majorDao;

    public MajorService(MajorDao majorDao) {
        this.majorDao = majorDao;
    }

    public List<Major> findAll() {
        Iterable<Major> it = majorDao.findAll();
        List <Major> majors = new ArrayList<>();
        it.forEach(majors::add);
        return majors;
    }

    public List<Student> getStudentsOfMajor(Long id) {
        return majorDao.getAllStudentsFromMajor(id);
    }
}

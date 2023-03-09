package com.studentManagemnt.service;

import com.studentManagemnt.dto.StudentDTO;
import com.studentManagemnt.gateway.StudentServiceGateway;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentServiceGateway {
    private final List<StudentDTO> studentList = new ArrayList<>();

    @Override
    public List<StudentDTO> getAllStudent() {
        for (int i = 0; i < 10; i++) {
            StudentDTO student = new StudentDTO();
            student.setId(String.valueOf(i));
            student.setName("Name" + i);
            student.setGrade("Age" + i);
            student.setSubjectId("Subject" + i);
            studentList.add(student);
        }
        return studentList;
    }
}

package com.teacherManage.service;

import com.teacherManage.dto.TeacherDTO;
import com.teacherManage.gateway.TeacherServiceGateway;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherServiceGateway {
    private final List<TeacherDTO> teacherList = new ArrayList<>();

    @Override
    public List<TeacherDTO> getAllTeacher() {
        for (int i = 0; i < 20; i++) {
            TeacherDTO student = new TeacherDTO();
            student.setId(String.valueOf(i));
            student.setName("Name" + i);
            student.setGender("Gender" + i);
            student.setSubjectId("Subject" + i);
            teacherList.add(student);
        }
        return teacherList;
    }
}

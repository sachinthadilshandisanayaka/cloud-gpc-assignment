package com.addmnistration.service.teacher;

import com.addmnistration.dto.TeacherDTO;
import com.addmnistration.gateway.teacher.TeacherGateway;
import com.addmnistration.interService.out.TeacherGRPCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherService implements TeacherGateway {
    private final TeacherGRPCService teacherGRPCService;

    @Autowired
    TeacherService(TeacherGRPCService teacherGRPCService) {
        this.teacherGRPCService = teacherGRPCService;
    }

    @Override
    public List<TeacherDTO> getAllTeacher() throws Exception {
        try {
            return teacherGRPCService.getAllStudent();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }
}

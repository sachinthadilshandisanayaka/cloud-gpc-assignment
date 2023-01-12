package com.addmnistration.service.student;

import com.addmnistration.dto.StudentDTO;
import com.addmnistration.gateway.student.StudentGateway;
import com.addmnistration.interService.out.StudentGRPCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentGateway {

    private final StudentGRPCService studentGRPCService;

    @Autowired
    StudentService(StudentGRPCService studentGRPCService) {
        this.studentGRPCService = studentGRPCService;
    }

    @Override
    public List<StudentDTO> getAllStudent() throws Exception {
        try {
            return studentGRPCService.getAllStudent();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }
}

package com.studentManagemnt.gateway;

import com.studentManagemnt.dto.StudentDTO;

import java.util.List;

public interface StudentServiceGateway {
    public List<StudentDTO> getAllStudent();
}

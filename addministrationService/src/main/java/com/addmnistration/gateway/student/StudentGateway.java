package com.addmnistration.gateway.student;

import com.addmnistration.dto.StudentDTO;

import java.util.List;

public interface StudentGateway {
    List<StudentDTO> getAllStudent() throws Exception;
}

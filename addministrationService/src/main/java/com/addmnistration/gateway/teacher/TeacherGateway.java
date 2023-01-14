package com.addmnistration.gateway.teacher;

import com.addmnistration.dto.TeacherDTO;

import java.util.List;

public interface TeacherGateway {
    List<TeacherDTO> getAllTeacher() throws Exception;
}

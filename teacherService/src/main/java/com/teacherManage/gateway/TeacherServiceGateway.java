package com.teacherManage.gateway;

import com.teacherManage.dto.TeacherDTO;

import java.util.List;

public interface TeacherServiceGateway {
    List<TeacherDTO> getAllTeacher();
}

package com.addmnistration.controller.teacher;

import com.addmnistration.dto.TeacherDTO;
import com.addmnistration.gateway.teacher.TeacherGateway;
import com.addmnistration.response.SuccessResponse;
import com.addmnistration.response.SuccessResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/sm/tc")
public class TeacherController {
    private final TeacherGateway teacherGateway;

    @Autowired
    TeacherController(TeacherGateway teacherGateway) {
        this.teacherGateway = teacherGateway;
    }

    @GetMapping(path = "/getTeacher/all")
    public ResponseEntity<SuccessResponse> getAllStudent() throws Exception {
        List<TeacherDTO> data = teacherGateway.getAllTeacher();
        return SuccessResponseHandler.generateResponse(data);
    }
}

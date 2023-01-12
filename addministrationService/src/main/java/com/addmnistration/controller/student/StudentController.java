package com.addmnistration.controller.student;

import com.addmnistration.dto.StudentDTO;
import com.addmnistration.gateway.student.StudentGateway;
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
@RequestMapping("/sm/st")
public class StudentController {
    private final StudentGateway studentGateway;

    @Autowired
    StudentController(StudentGateway studentGateway) {
        this.studentGateway = studentGateway;
    }

    @GetMapping(path = "/getStudent/all")
    public ResponseEntity<SuccessResponse> getAllStudent() throws Exception {
        List<StudentDTO> data = studentGateway.getAllStudent();
        return SuccessResponseHandler.generateResponse(data);
    }
}

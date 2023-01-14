package com.addmnistration.interService.out;

import com.addmnistration.dto.StudentDTO;
import com.cloudGRPCStudent.Empty;
import com.cloudGRPCStudent.Student;
import com.cloudGRPCStudent.StudentGRPCServiceGrpc;
import com.cloudGRPCStudent.StudentWrapper;
import io.grpc.Deadline;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class StudentGRPCService {

    @GrpcClient("student-grpc-service")
    public StudentGRPCServiceGrpc.StudentGRPCServiceBlockingStub studentGRPCServiceBlockingStub;

    public List<StudentDTO> getAllStudent() throws Exception {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        StudentDTO studentDTO = new StudentDTO();
        Empty emptyRequest = Empty.newBuilder().build();

        StudentWrapper studentRequest = studentGRPCServiceBlockingStub
                .withDeadline(Deadline.after(5, TimeUnit.MINUTES))
                .withWaitForReady()
                .getAllStudent(emptyRequest);
        try {
            for (Student student : studentRequest.getStudentListList()) {
                mapGrpcObjectToDTO(student, studentDTO);
                studentDTOList.add(studentDTO);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
        return studentDTOList;
    }

    private void mapGrpcObjectToDTO(Student student, StudentDTO studentDTO) {
        studentDTO.setId(student.getStId());
        studentDTO.setName(student.getStName());
        studentDTO.setGrade(student.getStGrade());
        studentDTO.setSubjectId(student.getStSjId());
    }
}

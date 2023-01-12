package com.studentManagemnt.interService.in;

import com.cloudGRPCStudent.*;
import com.studentManagemnt.dto.StudentDTO;
import com.studentManagemnt.gateway.StudentServiceGateway;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@GrpcService
public class StudentGRPCService extends StudentGRPCServiceGrpc.StudentGRPCServiceImplBase {

    private final StudentServiceGateway studentServiceGateway;

    @Autowired
    public StudentGRPCService(StudentServiceGateway studentServiceGateway) {
        this.studentServiceGateway = studentServiceGateway;
    }

    @Override
    public void getStudentById(StudentById request, StreamObserver<Student> responseObserver) {
        super.getStudentById(request, responseObserver);
    }

    @Override
    public void getAllStudent(Empty request, StreamObserver<StudentWrapper> responseObserver) {
        try {
            List<StudentDTO> studentList = studentServiceGateway.getAllStudent();
            StudentWrapper.Builder studentListBuilder = StudentWrapper.newBuilder();
            Student.Builder studentBuilder = Student.newBuilder();
            List<Student> studentListTarget = new ArrayList<>();

            if (studentList != null) {
                mapStudentDTOsToGRPCObject(studentList, studentBuilder, studentListTarget);
            }
            studentListBuilder.addAllStudentList(studentListTarget);
            responseObserver.onNext(studentListBuilder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    private void mapStudentDTOsToGRPCObject(List<StudentDTO> studentList,
                                            Student.Builder studentBuilder,
                                            List<Student> studentListTarget) {
        for (StudentDTO student : studentList) {
            mapSingleStudentDTOToGrpcObject(student, studentBuilder);
            studentListTarget.add(studentBuilder.build());
        }
    }

    private void mapSingleStudentDTOToGrpcObject(StudentDTO student,
                                                 Student.Builder studentBuilder) {
        if (student.getId() != null)
            studentBuilder.setStId(student.getId());
        if (student.getName() != null)
            studentBuilder.setStName(student.getName());
        if (student.getGrade() != null)
            studentBuilder.setStGrade(student.getGrade());
        if (student.getSubjectId() != null)
            studentBuilder.setStSjId(student.getSubjectId());
    }
}

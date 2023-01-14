package com.teacherManage.interService.in;

import com.cloudGRPCTeacher.*;
import com.teacherManage.dto.TeacherDTO;
import com.teacherManage.gateway.TeacherServiceGateway;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@GrpcService
public class TeacherGRPCService extends TeacherGRPCServiceGrpc.TeacherGRPCServiceImplBase {

    private final TeacherServiceGateway teacherServiceGateway;

    @Autowired
    TeacherGRPCService(TeacherServiceGateway teacherServiceGateway) {
        this.teacherServiceGateway = teacherServiceGateway;
    }

    @Override
    public void getTeacherById(TeacherById request, StreamObserver<Teacher> responseObserver) {
        super.getTeacherById(request, responseObserver);
    }

    @Override
    public void getAllTeacher(Empty request, StreamObserver<TeacherWrapper> responseObserver) {
        try {
            List<TeacherDTO> studentList = teacherServiceGateway.getAllTeacher();
            TeacherWrapper.Builder teacherListBuilder = TeacherWrapper.newBuilder();
            Teacher.Builder teacherBuilder = Teacher.newBuilder();
            List<Teacher> teacherListTarget = new ArrayList<>();

            if (studentList != null) {
                mapTeacherDTOsToGRPCObject(studentList, teacherBuilder, teacherListTarget);
            }
            teacherListBuilder.addAllTeacherList(teacherListTarget);
            responseObserver.onNext(teacherListBuilder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    private void mapTeacherDTOsToGRPCObject(List<TeacherDTO> teacherList,
                                            Teacher.Builder teacherBuilder,
                                            List<Teacher> teacherLisTarget) {
        for (TeacherDTO teacher : teacherList) {
            mapSingleTeacherDTOToGrpcObject(teacher, teacherBuilder);
            teacherLisTarget.add(teacherBuilder.build());
        }
    }

    private void mapSingleTeacherDTOToGrpcObject(TeacherDTO teacher,
                                                 Teacher.Builder teacherBuilder) {
        if (teacher.getId() != null)
            teacherBuilder.setTcId(teacher.getId());
        if (teacher.getName() != null)
            teacherBuilder.setTcName(teacher.getName());
        if (teacher.getGender() != null)
            teacherBuilder.setStGender(teacher.getGender());
        if (teacher.getSubjectId() != null)
            teacherBuilder.setTcSjId(teacher.getSubjectId());
    }
}

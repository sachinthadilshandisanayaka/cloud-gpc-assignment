package com.addmnistration.interService.out;

import com.addmnistration.dto.TeacherDTO;
import com.cloudGRPCTeacher.Empty;
import com.cloudGRPCTeacher.Teacher;
import com.cloudGRPCTeacher.TeacherGRPCServiceGrpc;
import com.cloudGRPCTeacher.TeacherWrapper;
import io.grpc.Deadline;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class TeacherGRPCService {

    @GrpcClient("teacher-grpc-service")
    public TeacherGRPCServiceGrpc.TeacherGRPCServiceBlockingStub teacherGRPCServiceBlockingStub;

    public List<TeacherDTO> getAllStudent() throws Exception {
        List<TeacherDTO> teacherDTOList = new ArrayList<>();
        TeacherDTO teacherDTO = new TeacherDTO();
        Empty emptyRequest = Empty.newBuilder().build();

        TeacherWrapper teacherRequest = teacherGRPCServiceBlockingStub
                .withDeadline(Deadline.after(5, TimeUnit.MINUTES))
                .withWaitForReady()
                .getAllTeacher(emptyRequest);
        try {
            for (Teacher teacher : teacherRequest.getTeacherListList()) {
                mapGrpcObjectToDTO(teacher, teacherDTO);
                teacherDTOList.add(teacherDTO);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
        return teacherDTOList;
    }

    private void mapGrpcObjectToDTO(Teacher teacher, TeacherDTO teacherDTO) {
        teacherDTO.setId(teacher.getTcId());
        teacherDTO.setName(teacher.getTcName());
        teacherDTO.setGender(teacher.getStGender());
        teacherDTO.setSubjectId(teacher.getTcSjId());
    }
}

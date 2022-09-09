package com.springboot.miscroserice.course.services;

import com.springboot.miscroserice.course.dto.CourseRequestDTO;
import com.springboot.miscroserice.course.dto.CourseResponseDTO;
import com.springboot.miscroserice.course.modal.CourseEntity;
import com.springboot.miscroserice.course.repository.CourseRepository;
import com.springboot.miscroserice.course.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    public CourseResponseDTO save(CourseRequestDTO courseRequestDTO) {

        CourseEntity courseEntity = AppUtil.convertRequestToEntity(courseRequestDTO);
        CourseEntity entity = courseRepository.save(courseEntity);
        CourseResponseDTO responseDTO = AppUtil.convertEntityToResponse(entity);
        responseDTO.setCourseUniqueCode(UUID.randomUUID().toString().split("-")[0]);
        return responseDTO;
    }

    public List<CourseResponseDTO> viewAllCourse() {
        Iterable<CourseEntity> iterable = courseRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(courseEntity -> AppUtil.convertEntityToResponse(courseEntity))
                .collect(Collectors.toList());
    }

    public CourseResponseDTO getCourseDetails(int courseId) {
        CourseEntity courseEntity = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("CourseId doesn't found =" + courseId));

        return AppUtil.convertEntityToResponse(courseEntity);

    }

    public CourseResponseDTO updateCourseDetails(CourseRequestDTO courseRequestDTO, int courseId) {

        CourseEntity courseEntity = courseRepository.findById(courseId).orElse(null);

        courseEntity.setName(courseRequestDTO.getName());
        courseEntity.setTrainerName(courseRequestDTO.getTrainerName());
        courseEntity.setDuration(courseRequestDTO.getDuration());
        courseEntity.setStartDate(courseRequestDTO.getStartDate());
        courseEntity.setCourseType(courseRequestDTO.getCourseType());
        courseEntity.setFees(courseRequestDTO.getFees());
        courseEntity.setCertificateAvailable(courseRequestDTO.isCertificateAvailable());
        courseEntity.setDescription(courseRequestDTO.getDescription());

//        courseRepository
        return null;

    }
}

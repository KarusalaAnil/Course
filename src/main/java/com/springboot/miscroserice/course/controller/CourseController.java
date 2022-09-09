package com.springboot.miscroserice.course.controller;

import com.springboot.miscroserice.course.dto.CourseRequestDTO;
import com.springboot.miscroserice.course.dto.CourseResponseDTO;
import com.springboot.miscroserice.course.modal.CourseEntity;
import com.springboot.miscroserice.course.services.CourseService;
import com.springboot.miscroserice.course.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;


//    addCourse
    //findALlCourse
    //findCourse
    //updateCourse
    //Delete course

    @PostMapping
    public CourseResponseDTO addCourse(@RequestBody CourseRequestDTO courseRequestDTO) {

        CourseResponseDTO courseResponseDTO = courseService.save(courseRequestDTO);
        return courseResponseDTO;

    }
    @GetMapping
    public List<CourseResponseDTO> findAllCourse(){
        List<CourseResponseDTO> courseResponseDTOList= courseService.viewAllCourse();
        return courseResponseDTOList;
    }
    @GetMapping("/find/{courseId}")
    public CourseResponseDTO findCourse(@PathVariable("courseId") int courseId){
        return courseService.getCourseDetails(courseId);
    }

    @PutMapping("/update/{courseId}")
    public CourseResponseDTO updateCourse(@RequestBody CourseRequestDTO requestDTO ,
                                          @PathVariable int courseId) {

        return courseService.updateCourseDetails(requestDTO , courseId);

    }


}

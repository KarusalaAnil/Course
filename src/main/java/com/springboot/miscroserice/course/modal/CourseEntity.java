package com.springboot.miscroserice.course.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseEntity {

    private int courseId;
    private String name;
    private String trainerName;
    private String duration;
    private String startDate;
    private String courseType;
    private double fees;
    private boolean isCertificateAvailable;
    private String description;


}


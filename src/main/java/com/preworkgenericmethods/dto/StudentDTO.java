package com.preworkgenericmethods.dto;

import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String marks;
    private Long departmentId;
    private boolean active;
}

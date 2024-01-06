package com.taswiksri.employeedata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;


}

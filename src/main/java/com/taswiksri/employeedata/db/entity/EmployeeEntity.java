package com.taswiksri.employeedata.db.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "EMPLOYEE")
@Getter
@Setter
@ToString
public class EmployeeEntity {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name="EMPLOYEE_SEQUENCE_GENERATOR", sequenceName="EMPLOYEE_SEQUENCE", initialValue=12,allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLOYEE_SEQUENCE_GENERATOR")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "E_MAIL")
    private String email;
}

package com.taswiksri.employeedata.db.repository;

import com.taswiksri.employeedata.db.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {


}

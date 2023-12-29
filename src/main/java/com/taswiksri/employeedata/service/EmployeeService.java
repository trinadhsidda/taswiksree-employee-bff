package com.taswiksri.employeedata.service;

import com.taswiksri.employeedata.db.entity.EmployeeEntity;
import com.taswiksri.employeedata.db.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {


    private final EmployeeRepository employeeRepository;

    @Value("${page.size:10}")
    private int pageSize;

    public EmployeeEntity getEmployee(Long id){
        return employeeRepository.findById(id).orElseGet(() -> new EmployeeEntity());
    }

    public Page<EmployeeEntity> getAllEmployees(){
        return employeeRepository.findAll(Pageable.ofSize(pageSize));
    }

    public void save() {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(1L);
        employeeEntity.setFirstName("Trinadh");
        employeeEntity.setLastName("Sidda");
        employeeEntity.setEmail("trinadh.sidda@gmail.com");
        employeeRepository.save(employeeEntity);
    }
}

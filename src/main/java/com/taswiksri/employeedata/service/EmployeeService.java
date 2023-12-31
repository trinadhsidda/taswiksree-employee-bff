package com.taswiksri.employeedata.service;

import com.taswiksri.employeedata.db.entity.EmployeeEntity;
import com.taswiksri.employeedata.db.repository.EmployeeRepository;
import com.taswiksri.employeedata.dto.Employee;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {


    private final EmployeeRepository employeeRepository;

    @Value("${page.size:100}")
    private int pageSize;

    /**
     * This method gets the employee by ID
     * @param id - Employee ID
     * @return
     */
    public EmployeeEntity getEmployee(Long id){
        return employeeRepository.findById(id).orElseGet(() -> new EmployeeEntity());
    }

    /**
     * This method returns all employee details by Page
     * @return
     */
    public Page<EmployeeEntity> getAllEmployees(){
        return employeeRepository.findAll(Pageable.ofSize(pageSize));
    }

    /**
     * This method saves the Employee data
     * @param employee
     */
    @Transactional
    public void save(Employee employee) {

        log.info("Employee to be saved: {}",employee);
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employee.getId());
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());
        employeeEntity.setEmail(employee.getEmail());
        employeeRepository.save(employeeEntity);
    }

    /**
     * This service delets the Employee data by ID
     * @param id - Employee ID
     */
    public void delete(Long id){
        employeeRepository.deleteById(id);
    }
}

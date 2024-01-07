package com.taswiksri.employeedata.controller;

import com.taswiksri.employeedata.db.entity.EmployeeEntity;
import com.taswiksri.employeedata.dto.Employee;
import com.taswiksri.employeedata.service.EmployeeService;
import io.swagger.models.Response;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/taswiksri")
@RequiredArgsConstructor
@CrossOrigin(value = "*",allowedHeaders = {})
public class EmployeeController {

    private final EmployeeService employeeService;

    /**
     * Health end point to indicate the application's health
     * @return
     */
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck(){

        return ResponseEntity.ok("OK");

    }

    /**
     * This GET mapping identifies the employee by ID
     * @param id - Employee id
     * @return - EmployeeEntity
     */
    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeEntity> getEmployee(@PathVariable("id") Long id){

        var employee = employeeService.getEmployee(id);
        return ResponseEntity.ok(employee);
    }

    /**
     * The GET Mapping helps to return employees list
     *
     * @return
     */
    @GetMapping("/employees")
    public ResponseEntity<Object> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees().getContent());

    }

    /**
     * This POST mapping add/update employee object
     * @param employee
     * @return
     */
    @PostMapping("/employee")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return ResponseEntity.ok("OK");
    }

    /**
     * This Delete mapping deletes an employee by ID
     * @param id - Employee ID
     * @return
     */
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id){
        employeeService.delete(id);
        return ResponseEntity.ok().build();

    }
}

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
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck(){

        return ResponseEntity.ok("OK");

    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeEntity> getEmployee(@PathVariable("id") Long id){

        var employee = employeeService.getEmployee(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/employees")
    public ResponseEntity<Object> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees().getContent());

    }

    @PostMapping("/employee")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return ResponseEntity.ok("OK");
    }
}

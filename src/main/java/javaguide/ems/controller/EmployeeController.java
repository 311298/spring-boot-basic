package javaguide.ems.controller;

import javaguide.ems.dto.EmployeeDto;
import javaguide.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor// base URL for all the api action
public class EmployeeController {

    // how to do the f12

    /*
    ResponseEntity is the class in the Spring Framework that represents
    the entire HTTP response, including the status code, headers,
    and body
    */

    private EmployeeService employeeService;

    // build add employee restApi
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(
            @RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee =
                employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
//        return  ResponseEntity.created(savedEmployee);
//        why above one not working ?? ask rahul
    }

    // build get employee restApi
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(
            @PathVariable("id") Long employeeId
            // @PathVariable when dynamic url value in our operation
    ) {
        EmployeeDto employeeDto =
                employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    // build get All employee restApi
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees =
                employeeService.getAllEmployee();
        return ResponseEntity.ok(employees);
    }

    // build update the employee restApi with given id and body
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(
            @PathVariable("id")  Long employeeId,
            @RequestBody EmployeeDto updatedEmployee
    ) {
        EmployeeDto newUpdatedEmployee =
                employeeService.updateEmployeeById(employeeId, updatedEmployee);
        return ResponseEntity.ok(newUpdatedEmployee);
    }

    // build delete the employee restApi with given id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable("id") Long employeeId
    ){
        employeeService.deleteEmployeeById(employeeId);
        return ResponseEntity.ok("Employee deleted successfully !!");
    }

}

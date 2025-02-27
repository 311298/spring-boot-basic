package javaguide.ems.mapper;

import javaguide.ems.dto.EmployeeDto;
import javaguide.ems.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto
            mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }

    /*
    above to method transform the data from database to response and
    response to database

    employee dto <-> employee entity

    I guess think of static method as helper function in service file
    */
}

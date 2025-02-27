package javaguide.ems.service.implementation;

import javaguide.ems.dto.EmployeeDto;
import javaguide.ems.entity.Employee;
import javaguide.ems.exception.ResourceNotFoundException;
import javaguide.ems.mapper.EmployeeMapper;
import javaguide.ems.repository.EmployeeRepository;
import javaguide.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImplementation
        implements EmployeeService {
    /*
    @Service is type of @Component,  which creates the bean  that is
    in return managed by spring boot
    */
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // first convert the employee dto into employee jpa
        Employee employee =
                EmployeeMapper.mapToEmployee(employeeDto);
        // save the data into the database
        Employee savedEmployee = employeeRepository.save(employee);
        // return the data for the response
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
//        Employee employee =
//                employeeRepository.findById(employeeId)
//                .orElseThrow(() ->
//                        new ResourceNotFoundException
//                                ("employee not exists for given id : " + employeeId));
        Employee employee = returnEmployeeById(employeeId);
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees =
                employeeRepository.findAll();
        return employees
                .stream()
                .map((element) ->
                        EmployeeMapper.mapToEmployeeDto(element))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployeeById(
            Long employeeId,
            EmployeeDto updatedEmployee) {
//        Employee employee =
//                employeeRepository.findById(employeeId)
//                        .orElseThrow(() -> new ResourceNotFoundException("employee not exists for given id : "+employeeId));

        Employee employee = returnEmployeeById(employeeId);

        // individual field manually
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee newUpdatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(newUpdatedEmployee);
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        Employee employee = returnEmployeeById(employeeId);
        employeeRepository.deleteById(employeeId);
    }

    public Employee returnEmployeeById(Long employeeId){
        Employee employee =
                employeeRepository.findById(employeeId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException
                                        ("employee not exists for given id : " + employeeId));
        return employee;
    }
}

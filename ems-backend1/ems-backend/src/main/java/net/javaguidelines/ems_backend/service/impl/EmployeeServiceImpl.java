package net.javaguidelines.ems_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguidelines.ems_backend.entity.Department;
import net.javaguidelines.ems_backend.entity.Employee;
import net.javaguidelines.ems_backend.exception.ResourceNotFoundException;
import net.javaguidelines.ems_backend.mapper.EmployeeMapper;
import net.javaguidelines.ems_backend.repository.DepartmentRepository;
import net.javaguidelines.ems_backend.repository.EmployeeRepository;
import net.javaguidelines.ems_backend.service.EmployeeService;
import net.javaguidelines.ems_backend.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Department department = departmentRepository.findById(employeeDto.getDepartmentId())
                .orElseThrow(()->
                        new ResourceNotFoundException("Department is not exists with given id:"+employeeDto.getDepartmentId()));
        employee.setDepartment(department);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);

    }

    @Override
    public EmployeeDto getEmployeeById(long employeeId) {
                 Employee employee = employeeRepository.findById(employeeId)
                          .orElseThrow(()->
                new ResourceNotFoundException("Employee is not exists with given id:"+employeeId));

          return EmployeeMapper.mapToEmployeeDto(employee);

    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee>   employees = employeeRepository.findAll();
       return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
               .collect(Collectors.toList());
    }

    @Override

    public EmployeeDto updateEmployee(Long employeeId,EmployeeDto updatedEmployeeDto)
    {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id:" + employeeId));
        employee.setFirstName(updatedEmployeeDto.getFirstName());
        employee.setLastName(updatedEmployeeDto.getLastName());
        employee.setEmail(updatedEmployeeDto.getEmail());
        Department department = departmentRepository.findById(updatedEmployeeDto.getDepartmentId())
                .orElseThrow(()->
                        new ResourceNotFoundException("Department is not exists with given id:"+updatedEmployeeDto.getDepartmentId()));
        employee.setDepartment(department);
        Employee updatedObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedObj);

    }


    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("employee is not exists with given id:" + employeeId));


        employeeRepository.deleteById(employeeId);
    }
}







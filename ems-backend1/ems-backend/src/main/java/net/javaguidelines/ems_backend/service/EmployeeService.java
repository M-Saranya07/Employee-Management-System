package net.javaguidelines.ems_backend.service;

import net.javaguidelines.ems_backend.dto.EmployeeDto;
import net.javaguidelines.ems_backend.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeedto);
    EmployeeDto getEmployeeById(long employeeId);
    List<EmployeeDto> getAllEmployee();
    EmployeeDto updateEmployee(Long employeeId,EmployeeDto updatedEmployeeDto);
    void deleteEmployee(Long employeeId);
}

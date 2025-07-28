package net.javaguidelines.ems_backend.service;

import net.javaguidelines.ems_backend.dto.DepartmentDto;
import net.javaguidelines.ems_backend.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(long departmentId);
    List<DepartmentDto> getAllDepartment();
    DepartmentDto updateDepartment(Long departmentId,DepartmentDto updatedDepartmentDto);
    void deleteDepartment(Long departmentId);
}

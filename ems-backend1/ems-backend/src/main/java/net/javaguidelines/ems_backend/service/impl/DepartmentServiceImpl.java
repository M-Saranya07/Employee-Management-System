package net.javaguidelines.ems_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguidelines.ems_backend.dto.DepartmentDto;

import net.javaguidelines.ems_backend.dto.EmployeeDto;
import net.javaguidelines.ems_backend.entity.Department;

import net.javaguidelines.ems_backend.entity.Employee;
import net.javaguidelines.ems_backend.exception.ResourceNotFoundException;
import net.javaguidelines.ems_backend.mapper.DepartmentMapper;

import net.javaguidelines.ems_backend.mapper.EmployeeMapper;
import net.javaguidelines.ems_backend.repository.DepartmentRepository;
import net.javaguidelines.ems_backend.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);

    }

    @Override
    public DepartmentDto getDepartmentById(long departmentId) {
        Department department= departmentRepository.findById(departmentId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Employee is not exists with given id:"+departmentId));

        return DepartmentMapper.mapToDepartmentDto(department);

    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
        List<Department>   departments = departmentRepository.findAll();
        return departments.stream().map((department) -> DepartmentMapper.mapToDepartmentDto(department))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartmentDto) {
        Department department= departmentRepository.findById(departmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id:" + departmentId));
        department.setDepartmentName(updatedDepartmentDto.getDepartmentName());
        department.setDepartmentDescription(updatedDepartmentDto.getDepartmentDescription());

        Department updatedObj = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(updatedObj);

    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department is not exists with given id:" + departmentId));


        departmentRepository.deleteById(departmentId);
    }



}

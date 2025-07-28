package net.javaguidelines.ems_backend.mapper;

import net.javaguidelines.ems_backend.dto.DepartmentDto;
import net.javaguidelines.ems_backend.entity.Department;

public class DepartmentMapper {
    public static DepartmentDto mapToDepartmentDto(Department department) {
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription()
        );
    }

    public static Department mapToDepartment(DepartmentDto departmentDto) {
        Department department = new Department();
        // Don't set id (let DB auto-generate it)
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        return department;
    }
}
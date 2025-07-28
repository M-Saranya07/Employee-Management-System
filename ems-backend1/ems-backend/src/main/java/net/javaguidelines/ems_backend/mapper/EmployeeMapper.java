package net.javaguidelines.ems_backend.mapper;
import net.javaguidelines.ems_backend.entity.Employee;
import net.javaguidelines.ems_backend.dto.EmployeeDto;




public class EmployeeMapper
{
    public static EmployeeDto mapToEmployeeDto(Employee employee)
    {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartment().getId()

        );
    }

    public static Employee mapToEmployee(EmployeeDto employeedto)
    {
              Employee employee = new Employee();
              employee.setId(employeedto.getId());
              employee.setFirstName(employeedto.getFirstName());
              employee.setLastName(employeedto.getLastName());
              employee.setEmail(employeedto.getEmail());
              return employee;



    }
}

package com.example.transactional.Service;

import com.example.transactional.Entity.Department;
import com.example.transactional.Entity.Employee;
import com.example.transactional.Repository.DepartmentRepo;
import com.example.transactional.Repository.EmployeeRepo;
import com.example.transactional.VO.EmployeeRequestVO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service

public class EmployeeService {

    private EmployeeRepo employeeRepo;
    private DepartmentRepo departmentRepo;

    public EmployeeService(EmployeeRepo employeeRepo, DepartmentRepo departmentRepo) {
        this.employeeRepo = employeeRepo;
        this.departmentRepo = departmentRepo;
    }

    @Transactional
    public String saveEmployee(EmployeeRequestVO employeeRequest) {
        Department department = new Department();
        department.setDepartmentName(employeeRequest.getDepartmentName());
        department.setDepartmentCode(employeeRequest.getDepartmentName());
        long departmentId = departmentRepo.save(department).getDepartmentId();
        Employee employee = null;
        employee.setEmployeeName(employeeRequest.getEmpName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setDepartmentId(departmentId);
        employeeRepo.save(employee);

        return "employee is saved with employee id :" + employee.getEmployeeId();
    }

}

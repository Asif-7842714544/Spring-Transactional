package com.example.transactional.Controller;

import com.example.transactional.Service.EmployeeService;
import com.example.transactional.VO.EmployeeRequestVO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    @PostMapping("/employee")
    public String saveEmployee(@RequestBody EmployeeRequestVO employeeRequest) {
      return  employeeService.saveEmployee(employeeRequest);
    }

}

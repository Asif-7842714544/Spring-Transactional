package com.example.transactional.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestVO {

    private String empName;
    private String email;
    private String departmentName;

}

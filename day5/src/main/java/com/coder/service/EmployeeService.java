package com.coder.service;

import com.coder.model.Employee;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService {
    List<Employee> getEmpByCity(String city);

    BigDecimal getAvgSalByProvince(String province);

    int removeEmpByIds(Integer[] empIds);
}

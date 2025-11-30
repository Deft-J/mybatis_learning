package com.coder.test;

import com.coder.model.Employee;
import com.coder.service.EmployeeService;
import com.coder.service.EmployeeServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class EmployeeTest {
    private final EmployeeService employeeService = new EmployeeServiceImpl();

    @Test
    public void testSelectEmpByCity() {
        String city = "南京市";
        List<Employee> empList = employeeService.getEmpByCity(city);
        if (empList.isEmpty()) {
            System.out.println("未查询到员工");
        } else {
            for (Employee emp : empList) {
                System.out.println(emp);
            }
        }
    }

    @Test
    public void testCountAvgSalByProvince() {
        String province = "江苏省";
        BigDecimal avgSal = employeeService.getAvgSalByProvince(province);
            System.out.println("平均工资：" + avgSal.setScale(2) + " 元");
    }


    @Test
    public void testDeleteEmpByIds() {
        Integer[] empIds = {5, 6};
        employeeService.removeEmpByIds(empIds);
    }
}

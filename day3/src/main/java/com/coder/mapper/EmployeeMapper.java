package com.coder.mapper;

import com.coder.model.Employee;

import java.util.List;

public interface EmployeeMapper {
    //查询江苏的员工信息
    List<Employee> selectJiangsuEmployees();

    //查询吉林的员工的平均工资
    Double selectJilinAvgSal();

    //将所有年龄超过30岁的销售员提升为销售经理
    void updateSalesmanToManager();

    //删除年龄超过35岁的员工
    void deleteEmployeeOver35();
}

package com.coder.mapper;

import com.coder.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeMapper {
    List<Employee> selectEmpByCity(@Param("city") String city);
    BigDecimal countAvgSalByProvince(@Param("province") String province);
    int deleteEmpByIds(Integer[] empIds);

}

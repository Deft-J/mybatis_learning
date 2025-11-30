package com.coder.service;

import com.coder.mapper.EmployeeMapper;
import com.coder.model.Employee;
import com.coder.util.SqlMapUtil;
import org.apache.ibatis.session.SqlSession;

import java.math.BigDecimal;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List<Employee> getEmpByCity(String city) {
        SqlSession sqlSession = SqlMapUtil.getSqlSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            return mapper.selectEmpByCity(city);
        } finally {
            SqlMapUtil.closeSqlSession(sqlSession);
        }
    }

    @Override
    public BigDecimal getAvgSalByProvince(String province) {
        SqlSession sqlSession = SqlMapUtil.getSqlSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            return mapper.countAvgSalByProvince(province);
        } finally {
            SqlMapUtil.closeSqlSession(sqlSession);
        }
    }

    @Override
    public int removeEmpByIds(Integer[] empIds) {
        SqlSession sqlSession = SqlMapUtil.getSqlSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            return mapper.deleteEmpByIds(empIds);
        } finally {
            SqlMapUtil.closeSqlSession(sqlSession);
        }
    }
}

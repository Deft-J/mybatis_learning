package com.coder.mapper;

import com.coder.model.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EmployeeMapper {

    // 新增员工
    @Insert("INSERT INTO teacher(name, addr, age, job, sal) " +
            "VALUES(#{name}, #{addr}, #{age}, #{job}, #{sal})")
    void saveEmployee(Employee employee);

    // 根据id删除员工
    @Delete("DELETE FROM teacher WHERE id = #{id}")
    void deleteEmployeeById(Integer id);

    // 根据id更新员工
    @Update("UPDATE teacher " +
            "SET name = #{name}, addr = #{addr}, age = #{age}, job = #{job}, sal = #{sal} " +
            "WHERE id = #{id}")
    void updateEmployee(Employee employee);

    // 查询所有员工
    @Select("SELECT id, name, addr, age, job, sal FROM teacher ORDER BY id ASC")
    List<Employee> selectAllEmployees();

    // 根据 id 查询单个员工
    @Select("SELECT id, name, addr, age, job, sal FROM teacher WHERE id = #{id}")
    Employee selectEmployeeById(Integer id);
}
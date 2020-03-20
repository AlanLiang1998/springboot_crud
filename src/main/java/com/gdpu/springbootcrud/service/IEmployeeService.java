package com.gdpu.springbootcrud.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdpu.springbootcrud.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author AlanLiang
 * @since 2020-03-18
 */
public interface IEmployeeService extends IService<Employee> {
    /**
     * 分页查询员工信息（携带部门信息）
     * @param page
     * @return
     */
    Page<Employee> pageWithDept(Page<Employee> page);

    /**
     * 根据关键词分页查询员工信息（携带部门信息）
     * @param keyword
     * @param page
     * @return
     */
    Page<Employee> getByKeyword(String keyword, Page<Employee> page);
}
